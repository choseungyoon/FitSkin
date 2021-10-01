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
    <section id="recommend">
      <v-container>
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
