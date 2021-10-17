<template>
  <section class="profile">
    <v-row class="account">
      <v-col cols="2"></v-col>
      <v-col cols="8" class="center">
        <v-row>
          <v-col cols="12">
            <v-list-item>
              <v-list-item-avatar>
                <v-img
                  src="https://randomuser.me/api/portraits/men/85.jpg"
                ></v-img>
              </v-list-item-avatar>
              <v-list-item-title>
                <p class="font-weight-bold">
                  {{ this.currentUser.username }}
                </p>
              </v-list-item-title>
            </v-list-item>
          </v-col>
        </v-row>
        <v-row class="survey_result">
          <v-col cols="6">
            나의 최근 피부 분석 결과
          </v-col>
          <v-col cols="6">
            <apexcharts
              type="line"
              width="400px"
              height="400px"
              align="center"
              :options="lineChartOptions"
              :series="series"
            ></apexcharts>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12">
            최근 추천받은 제품
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
  </section>
</template>

<script>
import SurveyDataService from "../services/SurveyDataService";
import VueApexCharts from "vue-apexcharts";

export default {
  name: "Profile",
  components: {
    apexcharts: VueApexCharts,
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  data() {
    return {
      series: [
        {
          name: "탄력",
          data: [],
        },
        {
          name: "보습",
          data: [],
        },
        {
          name: "색소침착",
          data: [],
        },
        {
          name: "민감성",
          data: [],
        },
        {
          name: "피지분비",
          data: [],
        },
        {
          name: "트러블 빈도",
          data: [],
        },
      ],

      lineChartOptions: {
        chart: {
          height: 350,
          type: "line",
          zoom: {
            enabled: false,
          },
        },
        dataLabels: {
          enabled: false,
        },
        stroke: {
          width: [5, 7, 5],
          curve: "straight",
          dashArray: [0, 8, 5],
        },
        title: {
          text: "Skin 분석 History",
          align: "left",
        },
        legend: {
          tooltipHoverFormatter: function(val, opts) {
            return (
              val +
              " - " +
              opts.w.globals.series[opts.seriesIndex][opts.dataPointIndex] +
              ""
            );
          },
        },
        markers: {
          size: 0,
          hover: {
            sizeOffset: 6,
          },
        },
        xaxis: {
          categories: [],
        },
        tooltip: {
          y: [
            {
              title: {
                formatter: function(val) {
                  return val + " (mins)";
                },
              },
            },
            {
              title: {
                formatter: function(val) {
                  return val + " per session";
                },
              },
            },
            {
              title: {
                formatter: function(val) {
                  return val;
                },
              },
            },
          ],
        },
        grid: {
          borderColor: "#f1f1f1",
        },
      },
    };
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/login");
    }
  },
  created() {
    var ref = this;

    console.log(this.currentUser.email);

    SurveyDataService.getAllResult(this.currentUser.email)
      .then((response) => {
        this.surveyresults = response.data.data;

        response.data.data.forEach(function(element) {
          ref.series[0].data.push(element.elasticity);
          ref.series[1].data.push(element.moisturizing);
          ref.series[2].data.push(element.pigmentation);
          ref.series[3].data.push(element.sensitivity);
          ref.series[4].data.push(element.sebum);
          ref.series[5].data.push(element.trouble);
          ref.lineChartOptions.xaxis.categories.push(element.date.toString());
        });

        console.log(this.lineChartOptions.xaxis.categories);
        console.log(this.series);
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
