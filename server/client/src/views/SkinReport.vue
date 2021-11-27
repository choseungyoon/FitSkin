<template>
  <div class="report">
    <section id="title">
      <v-container>
        <v-row align="center">
          <v-col class="black--text text-center" cols="12" tag="h1">
            <span
              :class="[
                $vuetify.breakpoint.smAndDown ? 'display-2' : 'display-3',
              ]"
              class="font-weight-black"
            >
              You're Skin Report
            </span>
          </v-col>
        </v-row>
      </v-container>
    </section>
    <section id="chart">
      <v-container>
        <v-row align="center">
          <v-col cols="6">
            <apexcharts
              type="radar"
              width="400px"
              height="400px"
              align="center"
              :options="chartOptions"
              :series="series"
            ></apexcharts>
          </v-col>
          <v-col cols="6">
            <v-row>
              <v-col cols="3"></v-col>
              <v-col cols="6" class="font-weight-bold" tag="h4"
                >나의 피부 점수 {{ total }}</v-col
              >
              <v-col cols="3"></v-col>
            </v-row>
            <v-row>
              <v-col cols="6">
                <v-row align="center" justify="center">좋아요😊</v-row>
                <v-row>
                  <v-img :src="bestIndex.image" height="30%"></v-img>
                </v-row>
                <v-row align="center" justify="center">
                  <p class="font-weight-bold">{{ bestIndex.name }}</p>
                </v-row>
              </v-col>
              <v-col cols="6">
                <v-row align="center" justify="center">아쉬워요😢</v-row>
                <v-row>
                  <v-img :src="worstIndex.image" height="30%"></v-img>
                </v-row>
                <v-row align="center" justify="center">
                  <p class="font-weight-bold">{{ worstIndex.name }}</p>
                </v-row>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-container>
    </section>
    <section id="analysis">
      <v-container>
        <v-row><br /><br /><br /></v-row>
        <v-row>
          <v-col cols="1"></v-col>
          <v-col cols="9">
            <div :class="'display-1'">
              <strong class="font-weight-bold">당신의 </strong>
              <strong class="pink--text text--lighten-3"
                >{{ worstIndex.name }}
              </strong>
              <strong class="font-weight-bold">점수는 </strong>
              <strong class="pink--text text--lighten-3">{{
                worstIndex.score
              }}</strong>
              <strong class="font-weight-bold">점이에요</strong>
            </div>
            <div :class="'title'" class="font-weight-bold">
              아래 성분이 도움 될 것 같아요
            </div>
          </v-col>
          <v-col cols="1"></v-col>
        </v-row>
        <v-row>
          <v-col cols="1"></v-col>
          <v-col cols="9">
            <v-divider></v-divider>
            <v-row>
              <v-col cols="3">
                <v-row class="font-weight-bold" align="center" justify="center">
                  {{ recommendIndex[0].name }}</v-row
                >
                <v-row><br /></v-row>
                <v-row>{{ recommendIndex[0].description }}</v-row>
              </v-col>
              <v-col cols="1"></v-col>
              <v-col cols="4">
                <v-row class="font-weight-bold" align="center" justify="center">
                  {{ recommendIndex[1].name }}
                </v-row>

                <v-row><br /></v-row>
                <v-row>{{ recommendIndex[0].description }}</v-row>
              </v-col>
              <v-col cols="1"></v-col>
              <v-col cols="3">
                <v-row class="font-weight-bold" align="center" justify="center">
                  {{ recommendIndex[2].name }}
                </v-row>
                <v-row><br /></v-row>
                <v-row>{{ recommendIndex[0].description }}</v-row>
              </v-col>
            </v-row>
          </v-col>
          <v-col cols="1"></v-col>
        </v-row>
      </v-container>
    </section>
    <section id="analysis">
      <v-container>
        <v-row><br /><br /><br /></v-row>
        <v-row>
          <v-col cols="1"></v-col>
          <v-col cols="9">
            <div :class="'display-1'">
              <strong class="font-weight-bold"> </strong>
              <strong class="pink--text text--lighten-3"
                >{{ worstIndex.name }}
              </strong>
              <strong class="font-weight-bold"
                >관련 좋은 제품을 추천드려요!
              </strong>
            </div>
          </v-col>
          <v-col cols="1"></v-col>
        </v-row>
        <v-row>
          <v-col cols="1"></v-col>
          <v-col cols="9">
            <v-divider></v-divider>
            <v-row>
              <v-col cols="3">
                <v-row>
                  <v-img :src="recommendProduct[0].image" height="30%"></v-img>
                </v-row>
                <v-row><br /></v-row>
                <v-row class="font-weight-bold" align="center" justify="center">
                  {{ recommendProduct[0].name }}</v-row
                >
                <v-row>{{ recommendProduct[0].description }}</v-row>
              </v-col>
              <v-col cols="1"></v-col>
              <v-col cols="4">
                <v-row>
                  <v-img :src="recommendProduct[1].image" height="30%"></v-img>
                </v-row>
                <v-row><br /></v-row>
                <v-row class="font-weight-bold" align="center" justify="center">
                  {{ recommendProduct[1].name }}</v-row
                >

                <v-row><br /></v-row>
                <v-row>{{ recommendProduct[1].description }}</v-row>
              </v-col>
              <v-col cols="1"></v-col>
              <v-col cols="3">
                <v-row>
                  <v-img :src="recommendProduct[2].image" height="30%"></v-img>
                </v-row>
                <v-row><br /></v-row>
                <v-row class="font-weight-bold" align="center" justify="center">
                  {{ recommendProduct[2].name }}</v-row
                >
                <v-row><br /></v-row>
                <v-row>{{ recommendProduct[2].description }}</v-row>
              </v-col>
            </v-row>
          </v-col>
          <v-col cols="1"></v-col>
        </v-row>
      </v-container>
    </section>
  </div>
</template>

<script>
import VueApexCharts from "vue-apexcharts";
import SurveyDataService from "../services/SurveyDataService";
import ProductService from "../services/productService";

export default {
  name: "App",
  components: {
    apexcharts: VueApexCharts,
  },
  created: function() {
    var ref = this;

    this.recommendIngredient = "";
    this.recommendIndex = "";
    console.log("param : " + this.$route.params.id);
    // get survey result
    SurveyDataService.getResult(this.$route.params.id)
      .then((response) => {
        this.series = response.data.data;
        this.total = response.data.data[0].total;
      })
      .catch((err) => {
        console.log(err);
      });

    // get best & worst index
    SurveyDataService.getBestIndex(this.$route.params.id).then((response) => {
      this.bestIndex.name = response.data.data.skinIndex;
      this.bestIndex.image = response.data.data.image;
      this.bestIndex.score = response.data.data.score;
    });

    SurveyDataService.getWorstIndex(this.$route.params.id).then((response) => {
      this.worstIndex.name = response.data.data.skinIndex;
      this.worstIndex.image = response.data.data.image;
      this.worstIndex.score = response.data.data.score;
      console.log(this.worstIndex.name);

      ProductService.recommendIngredient(this.worstIndex.name)
        .then((response) => {
          ref.recommendIndex = response.data;
        })
        .catch((err) => {
          console.log(err);
        });

      ProductService.getProductByIndex(this.worstIndex.name)
        .then((response) => {
          ref.recommendProduct = response.data;
        })
        .catch((err) => {
          console.log(err);
        });
    });
  },
  data() {
    return {
      total: 0,
      series: "",
      bestIndex: {
        name: "",
        image: "",
        score: 0,
      },
      worstIndex: {
        name: "",
        image: "",
        score: 0,
      },
      chartOptions: {
        chart: {
          align: "center",
          height: 350,
          type: "radar",
          dropShadow: {
            enabled: true,
            blur: 1,
            left: 1,
            top: 1,
          },
        },

        stroke: {
          width: 2,
        },
        fill: {
          opacity: 0.1,
        },
        markers: {
          size: 0,
        },
        xaxis: {
          categories: [
            "보습",
            "피지분비",
            "민감성",
            "탄력",
            "색소침착",
            "트러블",
          ],
        },
      },
      recommendIndex: "",
      recommendProduct: "",
    };
  },
};
</script>
