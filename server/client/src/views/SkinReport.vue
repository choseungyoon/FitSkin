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
            20대 평균 여성보다 보습 , 트러블 빈도가 높은 편이에요 <br />
            수분 충분과 민감성 피부에 좋은 솔루션이 필요해요!
          </v-col>
        </v-row>
      </v-container>
    </section>
    <v-divider></v-divider>
    <section id="recommend">
      <v-container class="text-center">
        <v-row align="center">
          <v-col class="black--text text-center" cols="12">
            <span
              :class="[
                $vuetify.breakpoint.smAndDown ? 'display-1' : 'display-2',
              ]"
              class="font-weight-black"
            >
              아래 제품을 추천드려요
            </span>
          </v-col>
        </v-row>
      </v-container>
      <v-container class="text-center" px-5>
        <v-col cols="12">
          <div class="row mb-50 border-bottom">
            <div class="product-img-container m-auto">
              <img
                src="data:image/jpeg;base64,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"
                alt=""
              />
            </div>
            <div>
              <div class="row">
                <div class="text-center body-1 product-desc-row">
                  <p style="padding-top: 16px" class="body-1">
                    Perfect for dry skin, this cleanser is gentle enough to
                    sweep away impurities and pollutants while leaving your skin
                    soft and hydrated. Targeting large pores, it works like a
                    vaccuum to suck up excess oil that clogs pores and makes
                    them appear larger.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </v-col>
        <v-col cols="12">
          <div class="row mb-50 border-bottom">
            <div class="product-img-container m-auto">
              <img
                src="https://view01.wemep.co.kr/wmp-product/3/804/1301178043/pm_fiigijecobin.jpg"
                alt=""
                width="30%"
              />
            </div>
            <div>
              <div class="row">
                <div class="text-center body-1 product-desc-row">
                  <p style="padding-top: 16px" class="body-1">
                    Perfect for dry skin, this cleanser is gentle enough to
                    sweep away impurities and pollutants while leaving your skin
                    soft and hydrated. Targeting large pores, it works like a
                    vaccuum to suck up excess oil that clogs pores and makes
                    them appear larger.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </v-col>
        <v-col cols="12">
          <div class="row mb-50 border-bottom">
            <div class="product-img-container m-auto">
              <img
                src="http://cdn.011st.com/11dims/resize/1200x1200/quality/75/11src/pd/19/0/9/6/5/2/8/MAsZM/2586096528_L300.jpg"
                alt=""
                width="30%"
              />
            </div>
            <div>
              <div class="row">
                <div class="text-center body-1 product-desc-row">
                  <p style="padding-top: 16px" class="body-1">
                    Perfect for dry skin, this cleanser is gentle enough to
                    sweep away impurities and pollutants while leaving your skin
                    soft and hydrated. Targeting large pores, it works like a
                    vaccuum to suck up excess oil that clogs pores and makes
                    them appear larger.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </v-col>
      </v-container>
    </section>
  </div>
</template>

<script>
import VueApexCharts from "vue-apexcharts";
import SurveyDataService from "../services/SurveyDataService";

export default {
  name: "App",
  components: {
    apexcharts: VueApexCharts,
  },
  created: function() {
    console.log("param : " + this.$route.params.id);
    SurveyDataService.getResult(this.$route.params.id)
      .then((response) => {
        console.log(response.data.data);
        this.series = response.data.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
  data() {
    return {
      series: "",
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
    };
  },
};
</script>
