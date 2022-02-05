<template>
  <div>
     <vue-html2pdf
        :show-layout="false"
        :float-layout="true"
        :enable-download="false"
        :preview-modal="true"
        :paginate-elements-by-height="1400"
        filename="fitskin_report.pdf"
        :pdf-quality="2"
        :manual-pagination="true"
        pdf-format="a4"
        pdf-orientation="landscape"
        pdf-content-width="100%"
        ref="html2Pdf"
        :htmlToPdfOptions = "htmlToPdfOptions"
        @beforeDownload="beforeDownload($event)"
    >
        <pdf-content slot="pdf-content">
            <v-app>
              <base-section>
              <v-row
                align="center"
                justify="center"
              >
                <v-col
                  cols="12"
                >
                <div class="justify-center align-center">
                  <base-heading
                    title="FITSKIN 피부진단 결과"
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
                <div class="html2pdf__page-break" />
                <br>
                <br>
                <br>
                <br>
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
                      <span class="text-h6 font-weight-black">
                            나의 피부 종합점수는 {{total}}점이에요
                      </span>
                      <br><br>
                      <span class="text-h6 font-weight-black">
                            {{analysisMsg}}
                      </span>
                      <br><br>
                      <span class="text-h6 font-weight-black">
                            아래 생활습관을 통해 {{worstIndex.name}} 관리 시작해보세요
                      </span>
                      <br><br>
                        <li
                          style="list-style: none;"
                          v-for="(value) in recommendHabits"
                          v-bind:key="value"
                          >
                          <v-icon left>
                            mdi-checkbox-outline
                          </v-icon>
                          <span class="text-h6 font-weight-black">
                          {{ value.title }}
                          </span>
                        </li>
                    </v-col>
                  </v-row>
                  <div class="html2pdf__page-break" />
                  <br>
                  <br>
                  <br>
                  <br>
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
                    <br>
                    </v-col>
                  </v-row>
                  <v-divider />
                  <v-row>
                    <br>
                  </v-row>
                  <v-row
                    justify="center"
                    align="center"
                    class="px-12"
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
                  <div class="html2pdf__page-break" />
                  <br>
                  <br>
                  <br>
                  <br>
                  <v-row
                    justify="center"
                    align="center"
                    class="px-2"
                  >
                    <v-col>
                      <div class="match-with-it">
                        <p class="text-h3 font-weight-black">아래 제품들을 추천드려요</p>
                        <sf-button class="sf-button--text smartphone-only">See all</sf-button>
                      </div>
                      <sf-carousel>
                        <sf-carousel-item>
                          <sf-carousel-item
                            v-for="(product, index) in paginatedData"
                            :key="index"
                            class="carousel__item"
                          >
                            <sf-product-card
                              :image="product.image"
                              :title="product.title"
                              :regular-price="product.price.regular"
                              :special-price="product.price.special"
                              :score-rating="product.rating.score"
                              :max-rating="product.rating.max"
                              :reviews-count="product.reviews"
                            />
                          </sf-carousel-item>
                        </sf-carousel-item>
                      </sf-carousel>
                    </v-col>
                  </v-row>
                </div>
                </v-col>
              </v-row>
              </base-section>
            </v-app>
        </pdf-content>
    </vue-html2pdf>
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
          title="FITSKIN 피부진단 결과"
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
            <span class="text-h6 font-weight-black">
                  나의 피부 종합점수는 {{total}}점이에요
            </span>
            <br><br>
            <span class="text-h6 font-weight-black">
                  {{analysisMsg}}
            </span>
            <br><br>
            <span class="text-h6 font-weight-black">
                  아래 생활습관을 통해 {{worstIndex.name}} 관리 시작해보세요
            </span>
            <br><br>
              <li
                style="list-style: none;"
                v-for="(value) in recommendHabits"
                v-bind:key="value"
                >
                <v-icon left>
                  mdi-checkbox-outline
                </v-icon>
                <span class="text-h6 font-weight-black">
                {{ value.title }}
                </span>
              </li>
          </v-col>
        </v-row>
        <v-row><br><br></v-row>
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
          <br>
          </v-col>
        </v-row>
        <v-divider />
        <v-row>
          <br>
        </v-row>
        <v-row
          justify="center"
          align="center"
          class="px-12"
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
            <div class="match-with-it">
            <p class="text-h3 font-weight-black">아래 제품들을 추천드려요</p>
            <sf-button class="sf-button--text smartphone-only">See all</sf-button>
          </div>
          <sf-carousel>
            <sf-carousel-item>
              <sf-carousel-item
                v-for="(product, index) in paginatedData"
                :key="index"
                class="carousel__item"
              >
                <sf-product-card
                  :image="product.image"
                  :title="product.title"
                  :regular-price="product.price.regular"
                  :special-price="product.price.special"
                  :score-rating="product.rating.score"
                  :max-rating="product.rating.max"
                  :is-in-wishlist="product.isInWishlist"
                  :show-add-to-cart-button="true"
                  :reviews-count="product.reviews"
                  :badge-label="product.badgeLabel"
                  :badge-color="product.badgeColor"
                  @click:wishlist="toggleWishlist(index)"
                  @click="productDetail(index)"
                />
              </sf-carousel-item>
            </sf-carousel-item>
          </sf-carousel>
          </v-col>
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
            @click="generateReport"
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
  import {
    SfCarousel,
    SfButton,
    SfProductCard,
  } from '@storefront-ui/vue'
  import VueApexCharts from 'vue-apexcharts'
  import SurveyService from '@/services/SurveyService'
  import ProductService from '@/services/ProductService'
  import VueHtml2pdf from 'vue-html2pdf'

  export default {
    name: 'Analysis',
    metaInfo: { title: 'Skin Report' },
    components: {
      apexcharts: VueApexCharts,
      SfCarousel,
      SfButton,
      SfProductCard,
      VueHtml2pdf,
    },
    data () {
      return {
        htmlToPdfOptions: {
          image: {
            type: 'jpeg',
            quality: 1,
          },
          html2canvas: {
            dpi: 250,
            letterRendering: true,
            useCORS: true,
          },
          jsPDF: {
            unit: 'mm',
            format: 'a4',
            orientation: 'landscape',
          },
        },
        recommendProduct: [],
        length: 3,
        window: 0,
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
            size: 6,
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
            height: 300,
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
        analysisMsg: '',
        recommendHabits: [],
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
          for (var score in this.analysisScore.data) {
            const title = this.chartOptions.xaxis.categories[score]
            let icon = ''
            if (title === '보습') {
              icon = 'mdi-water-plus'
            } else if (title === '민감성') {
              icon = 'mdi-cancel'
            } else if (title === '피지분비') {
              icon = 'mdi-shimmer'
            } else if (title === '피부탄력') {
              icon = 'mdi-wall'
            } else if (title === '색소침착') {
              icon = 'mdi-face-woman-shimmer-outline'
            } else if (title === '트러블') {
              icon = 'mdi-allergy'
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
            this.getAnalysisMessage()
            this.getRecommnedHabit()
          })
          .catch((err) => {
            console.log(err)
          })

        ProductService.recommendProduct(this.worstIndex.name)
          .then((response) => {
            ref.recommendProduct = []
            for (var productIdex in response.data) {
              ref.recommendProduct.push({
                id: response.data[productIdex].id,
                title: response.data[productIdex].name,
                image: response.data[productIdex].image,
                price: { regular: response.data[productIdex].price + '원' },
                rating: { max: 5, score: 4 },
                isInWishlist: true,
                reviews: 8,
                badgeLabel: '',
                badgeColor: 'color-primary',
              })
            }
            console.log(ref.recommendProduct)
          })
          .catch((err) => {
            console.log(err)
          })
      })
    },
    computed: {
      paginatedData () {
        return this.recommendProduct.slice(0, 3)
      },
    },
    methods: {
      productDetail (id) {
        this.$router.push({ name: 'ProductDetail', params: { id: this.paginatedData[id].id } })
      },
      getRecommnedHabit () {
        SurveyService.getRecommendHabits(this.worstIndex.name)
          .then((response) => {
            for (var habit in response.data.data) {
              this.recommendHabits.push({
                title: response.data.data[habit].title,
                text: response.data.data[habit].value,
              })
            }
          })
      },
      getAnalysisMessage () {
        let avgScore
        if (this.worstIndex.name === '피부보습') {
          avgScore = this.series[2].data[0]
        } else if (this.worstIndex.name === '피지분비') {
          avgScore = this.series[2].data[1]
        } else if (this.worstIndex.name === '민감성') {
          avgScore = this.series[2].data[2]
        } else if (this.worstIndex.name === '피부탄력') {
          avgScore = this.series[2].data[3]
        } else if (this.worstIndex.name === '색소침착') {
          avgScore = this.series[2].data[4]
        } else if (this.worstIndex.name === '트러블') {
          avgScore = this.series[2].data[5]
        }
        if (avgScore <= this.worstIndex.score) {
          this.analysisMsg = '가장 낮은 피부지표는 ' + this.worstIndex.name + '이지만 ' + this.series[2].name + '보다 높은편으로 평소에 관리를 잘 하신것 같아요'
        } else {
          this.analysisMsg = this.worstIndex.name + ' 점수가 ' + this.series[2].name + '보다 낮은 편이라 관리가 필요해요'
        }
      },
      kakaoLink () {
        const mainUrl = 'http://fitskin.co.kr'
        const surveyUrl = 'http://fitskin.co.kr/survey'
        const resultUrl = 'http://fitskin.co.kr' + window.location.pathname
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
      async beforeDownload ({ html2pdf, options, pdfContent }) {
        await html2pdf().set(options).from(pdfContent).toPdf().get('pdf').then((pdf) => {
          const totalPages = pdf.internal.getNumberOfPages()
          for (let i = 1; i <= totalPages; i++) {
            pdf.setPage(i)
            pdf.setFontSize(10)
            pdf.setTextColor(150)
            pdf.text('Page ' + i + ' of ' + totalPages, (pdf.internal.pageSize.getWidth() * 0.88), (pdf.internal.pageSize.getHeight() - 0.3))
          }
        }).save()
      },
      generateReport () {
        this.$refs.html2Pdf.generatePdf()
      },
    },
  }
</script>
<style lang="scss" scoped>
@import "~@storefront-ui/vue/styles";
.match-with-it {
  display: flex;
  justify-content: space-between;
  align-items: baseline;
  margin-top: var(--spacer-xl);
  font-size: var(--h3-font-size);
  font-family: var(--font-family--secondary);
  font-weight: var(--font-weight--bold);
  border-bottom: solid 1px var(--c-light);
  &__paragraph {
    margin-bottom: var(--spacer-xs);
  }
  @include for-desktop {
    border: none;
    justify-content: center;
    font-weight: var(--font-weight--semibold);
  }
}
.carousel {
  margin: 0 calc(-1 * var(--spacer-sm)) 0 0;
  @include for-desktop {
    margin: 0;
  }
  &__item {
    margin: 1.9375rem 0 2.4375rem 0;
  }
}
</style>
