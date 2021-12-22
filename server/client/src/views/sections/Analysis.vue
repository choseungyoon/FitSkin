<template>
  <div
    ref="document"
    class="justify-center align-center"
  >
    <base-section
      id="analysis-report"
    >
    <v-row
      align="center"
      justify="center"
    >
      <v-col
        cols="12"
        md="2"
      >
      </v-col>
      <v-col
        cols="12"
        md="8"
      >
      <div class="justify-center align-center">
        <base-heading
          title="필요성분 추천 결과"
          align="center"
        />
        <base-divider
          color="primary"
          align="center"
        />
      </div>
      <v-row
        justify="center"
        align="center"
        class="px-3"
      >
        <v-col
          cols="12"
          md="5"
        >
          <apexcharts
            type="radar"
            width="400px"
            height="400px"
            align="center"
            :options="chartOptions"
            :series="series"
          />
        </v-col>
        <v-col
          cols="12"
          md="7"
        >
          <v-row>
            <v-col cols="12">
              <v-row
                align="center"
                justify="center"
                class="px-10"
              >
                <template v-for="(feature, i) in features">
                  <v-col
                    :key="i"
                    cols="6"
                    md="4"
                  >
                    <base-feature
                      class="pa-2"
                      v-bind="feature"
                    />
                  </v-col>
                </template>
              </v-row>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
      <v-row>
        <br>
      </v-row>
      <div class="justify-center align-center">
        <v-row>
          <br>
        </v-row>
        <v-row align="start">
          <v-col
            cols="12"
            sm="12"
            class="px-12"
          >
            <div>
                <span class="text-h4 font-weight-black">
                  당신의
                </span>
                <span class="text-h4 font-weight-black pink--text text--lighten-3">
                  {{ worstIndex.name }}
                </span>
                <span class="text-h4 font-weight-black">
                  점수는
                </span>
                <span class="text-h3 font-weight-black pink--text text--lighten-3">
                  {{ worstIndex.score }}
                </span>
                <span class="text-h4 font-weight-black">
                  점이에요
                </span>
            </div>
            <div>
                <span class="text-h6 font-weight-black">
                  6가지 피부 주요 성분중 가장 점수가 낮아요
                </span>
            </div>
            <div>
              <br>
            </div>
          </v-col>
        </v-row>
        <v-divider />
        <v-row>
          <br>
        </v-row>
        <v-row
          justify="center"
          align="center"
          class="px-3"
        >
          <v-col
            cols="12"
            md="6"
          >
            <apexcharts
              type="radialBar"
              height="350"
              :options="chartOptions2"
              :series="pieseries"
            />
          </v-col>
          <v-col
            cols="12"
            md="6"
          >
            <base-body
              class="font-weight-bold"
              text="6가지 항목중 --- 의 점수가 가장 낮아요 등등 설명 필요"
              align="left"
            />
          </v-col>
        </v-row>
        <v-row>
          <br>
        </v-row>
        <v-row
          justify="center"
          align="center"
          class="px-3"
        >
          <v-col
            cols="12"
            md="12"
          >
          <div>
            <span class="text-h4 font-weight-black pink--text text--lighten-3">
                {{ worstIndex.name }}
            </span>
            <span class="text-h4 font-weight-black">
                에 도움되는 성분이에요
            </span>
          </div>
          <div>
            <span class="text-h6 font-weight-black">
                참고해서 꾸준히 관리하면 더 좋아질 거에요!
            </span>
          </div>
          </v-col>
        </v-row>
        <v-divider />
        <v-row>
          <br>
        </v-row>
        <v-row
          justify="center"
          align="center"
          class="px-10"
        >
          <template v-for="(feature, i) in ingredients">
            <v-col
              :key="i"
              cols="12"
              md="4"
            >
              <base-feature
                class="pa-2"
                v-bind="feature"
              />
            </v-col>
          </template>
        </v-row>
        <v-row>
          <br>
        </v-row>
        <v-row
          justify="center"
          align="center"
          class="px-3"
        >
          <v-col
            cols="12"
            md="12"
          >
          <div>
            <center>
                <span class="text-h4 font-weight-black">
                  당신에게 필요한 제품을 FitSkin이 추천해드려요
                 </span>
            </center>
          </div>
          </v-col>
        </v-row>
        <v-row
          justify="center"
          align="center"
          class="px-3"
        >
          <v-sheet
              class="mx-auto"
              elevation="0"
              max-width="100%"
          >
            <v-slide-group
              class="pa-4"
              show-arrows
            >
              <template v-slot:next>
                <v-icon large>mdi-arrow-right-bold-circle-outline</v-icon>
              </template>
                  <template v-slot:prev>
                <v-icon  large>mdi-arrow-left-bold-circle-outline</v-icon>
              </template>
            <v-slide-item
                v-for="(feature, i) in products"
                :key="i"
            >
              <v-card
                class="ma-4"
                max-width="100%"
                elevation="0"
              >
                <v-img
                  :src="feature.image"
                ></v-img>

                <v-card-title>
                  {{feature.name}}
                </v-card-title>

                <v-card-subtitle>
                    {{feature.price.toLocaleString()}}원
                </v-card-subtitle>

                <v-card-actions>
                  <v-btn
                    color="orange lighten-2"
                    text
                  >
                    자세히보기
                  </v-btn>
                  <v-spacer></v-spacer>
                </v-card-actions>
              </v-card>
            </v-slide-item>
            </v-slide-group>
          </v-sheet>

        </v-row>
        <v-row>
          <br><br>
        </v-row>
        <v-row
          justify="center"
          align="center"
        >
          <base-btn
            rounded
            height="50px"
            width="300px"
            color="white"
            class="primary--text font-weight-bold text-none mr-4 mb-1"
            target="_blank"
            @click="exportToPDF"
          >
            <span v-text="`PDF로 다운로드 받기`" />
          </base-btn>
          <router-link
            to="/dna"
            tag="button"
          >
            <base-btn
              rounded
              height="50px"
              width="300px"
              color="white"
              class="primary--text font-weight-bold text-none mr-4 mb-1"
              target="_blank"
            >
              <span v-text="`더 자세히 유전자검사!`" />
            </base-btn>
          </router-link>
          <base-btn
            rounded
            height="50px"
            width="300px"
            color="white"
            class="primary--text font-weight-bold text-none mr-4 mb-1"
            target="_blank"
            @click="kakaoLink"
          >
            <span v-text="`공유하기`" />
          </base-btn>
        </v-row>

      </div>
       </v-col>
      <v-col
        cols="12"
        md="2"
      >
      </v-col>
    </v-row>
    </base-section>
  </div>
</template>

<script>
  import VueApexCharts from 'vue-apexcharts'
  import SurveyService from '@/services/SurveyService'
  import ProductService from '@/services/ProductService'
  import html2pdf from 'html2pdf.js'

  export default {
    name: 'Analysis',
    metaInfo: { title: 'Skin Report' },
    components: {
      apexcharts: VueApexCharts,
    },
    data () {
      return {
        total: 0,
        series: [],
        pieseries: [],
        analysisScore: [],
        chartOptions: {
          chart: {
            align: 'center',
            height: 350,
            type: 'radar',
            dropShadow: {
              enabled: true,
              blur: 1,
              left: 1,
              top: 1,
            },
          },
          dataLabels: {
            enabled: true,
          },
          stroke: {
            width: 2,
          },
          fill: {
            opacity: 0.1,
          },
          xaxis: {
            categories: [
              '보습',
              '피지분비',
              '민감성',
              '피부탄력',
              '색소침착',
              '트러블',
            ],
          },
          plotOptions: {
            radar: {
              size: 140,
              polygons: {
                strokeColors: '#e9e9e9',
                fill: {
                  colors: ['#f8f8f8', '#fff'],
                },
              },
            },
          },
          markers: {
            size: 4,
            colors: ['#fff'],
            strokeColor: '#B3E5FC',
            strokeWidth: 2,
          },
          tooltip: {
            y: {
              formatter: function (val) {
                return val
              },
            },
          },
        },
        features: [],
        ingredients: [],
        products: [],
        chartOptions2: {
          chart: {
            height: 350,
            type: 'radialBar',
          },
          plotOptions: {
            radialBar: {
              dataLabels: {
                name: {
                  fontSize: '22px',
                },
                value: {
                  fontSize: '16px',
                },
                total: {
                  show: true,
                  label: '종합 피부점수',
                  formatter: function (w) {
                    let sum = 0
                    for (var score in w.config.series) {
                      sum += Number(w.config.series[score])
                    }
                    return parseInt(sum / 6)
                  },
                },
              },
            },
          },
          labels: ['보습', '피지분비', '민감성', '피부탄력', '색소침착', '트러블'],
        },
        recommendIndex: '',
        worstIndex: {
          name: '',
          image: '',
          score: 0,
        },
      }
    },
    created: function () {
      var ref = this
      console.log('param : ' + this.$route.params.id)
      SurveyService.getResult(this.$route.params.id)
        .then((response) => {
          this.series = response.data.data
          this.total = response.data.data[0].total
          this.analysisScore = this.series[0]
          console.log(this.analysisScore)

          for (var score in this.analysisScore.data) {
            const title = this.chartOptions.xaxis.categories[score]
            let icon = ''
            if (title === '보습') {
              icon = 'mdi-water-plus'
            } else if (title === '민감성') {
              icon = 'mdi-hand-wave'
            } else {
              icon = 'icon'
            }
            this.features.push({
              icon: icon,
              title: title,
              text: this.analysisScore.data[score].toString() + '점',
            })
            this.pieseries.push(this.analysisScore.data[score])
          }
        })
        .catch((err) => {
          console.log(err)
        })

      SurveyService.getWorstIndex(this.$route.params.id).then((response) => {
        this.worstIndex.name = response.data.data.skinIndex
        this.worstIndex.image = response.data.data.image
        this.worstIndex.score = response.data.data.score

        ProductService.recommendIngredient(this.worstIndex.name)
          .then((response) => {
            ref.recommendIndex = response.data
            for (var ingredient in response.data) {
              ref.ingredients.push({
                icon: response.data[ingredient].icon,
                title: response.data[ingredient].name,
                text: response.data[ingredient].description,
              })
            }
          })
          .catch((err) => {
            console.log(err)
          })

        ProductService.getProductByIndex(this.worstIndex.name)
          .then((response) => {
            ref.recommendProduct = response.data
            for (var product in response.data) {
              ref.products.push({
                name: response.data[product].name,
                image: response.data[product].image,
                price: response.data[product].price,
                show: false,
              })
            }
            console.log(ref.recommendProduct)
          })
          .catch((err) => {
            console.log(err)
          })
      })
    },
    methods: {
      exportToPDF () {
        html2pdf(this.$refs.document, {
          margin: 0,
          filename: 'fitskin-report.pdf',
          image: { type: 'jpeg', quality: 0.95 },
          html2canvas: {
            scrollY: 0,
            scale: 1,
            dpi: 300,
            letterRendering: true,
            allowTaint: true,
            ignoreElements: function (element) {
              if (element.id === 'pdf-button-area') {
                return true
              }
            },
          },
          jsPDF: {
            orientation: 'portrait',
            unit: 'mm',
            format: 'a4',
            compressPDF: true,
          },
        })
      },
      kakaoLink () {
        const mainUrl = 'http://34.64.253.121:9000'
        const surveyUrl = 'http://34.64.253.121:9000/survey'
        const resultUrl = 'http://34.64.253.121:9000' + window.location.pathname
        window.Kakao.Link.sendDefault({
          objectType: 'feed',
          content: {
            title: '나만의 이너뷰티',
            description: '나만을 위한 합리적인 이너뷰티를 찾아드려요',
            imageUrl:
              'https://i.ibb.co/4PQpZR0/product.png',
            link: {
              mobileWebUrl: mainUrl,
              webUrl: mainUrl,
            },
          },
          buttons: [
            {
              title: '이너뷰티 검사 하기',
              link: {
                mobileWebUrl: surveyUrl,
                webUrl: surveyUrl,
              },
            },
            {
              title: '결과 보기',
              link: {
                mobileWebUrl: resultUrl,
                webUrl: resultUrl,

              },
            },
          ],
        })
      },
    },
  }
</script>
