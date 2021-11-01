<template>
  <div class="product">
    <v-row>
      <v-col cols="12">
        <v-card>
          <v-row>
            <v-col cols="1"></v-col>
            <v-col cols="10">
              <v-row justify="center">
                <v-col class="text-right">
                  <v-dialog
                    v-model="dialog"
                    persistent
                    max-width="600px"
                    ref="form"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn color="primary" dark v-bind="attrs" v-on="on">
                        Add Product
                      </v-btn>
                    </template>
                    <v-card>
                      <v-card-title>
                        <span class="text-h5">New Product</span>
                      </v-card-title>
                      <v-card-text>
                        <v-container>
                          <v-row>
                            <v-col cols="12" sm="12" md="12">
                              <v-text-field
                                v-model="product.name"
                                :rules="[
                                  () => !!name || 'This field is required',
                                ]"
                                label="제품명*"
                                required
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6" md="12">
                              <v-select
                                v-model="product.ingredientCode"
                                :items="ingredientCodeList"
                                :rules="[(v) => !!v || 'Item is required']"
                                label="성분 분류코드(주성분)*"
                                chips
                                required
                              ></v-select>
                            </v-col>
                            <v-col cols="12">
                              <v-text-field
                                v-model="product.subIngredient"
                                label="주성분 외 성분"
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6">
                              <v-text-field
                                v-model="product.origin"
                                label="주원료 원산지*"
                                required
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="6">
                              <v-text-field
                                v-model="product.perContent"
                                label="1단위당 주성분 함량*"
                                required
                                suffix="mg"
                              ></v-text-field>
                            </v-col>

                            <v-col cols="12" sm="3">
                              <v-text-field
                                v-model="product.formulation"
                                label="제형*"
                                required
                              ></v-text-field>
                            </v-col>

                            <v-col cols="12" sm="9">
                              <v-menu
                                v-model="menu2"
                                :close-on-content-click="false"
                                :nudge-right="20"
                                transition="scale-transition"
                                offset-y
                                min-width="auto"
                              >
                                <template v-slot:activator="{ on, attrs }">
                                  <v-text-field
                                    v-model="product.registeredDate"
                                    label="건기식 인증*"
                                    prepend-icon="mdi-calendar"
                                    readonly
                                    v-bind="attrs"
                                    v-on="on"
                                  ></v-text-field>
                                </template>
                                <v-date-picker
                                  v-model="product.registeredDate"
                                  @input="menu2 = false"
                                ></v-date-picker>
                              </v-menu>
                            </v-col>

                            <v-col cols="12" sm="4">
                              <v-text-field
                                v-model="product.price"
                                label="가격*"
                                required
                                suffix="원"
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="4">
                              <v-text-field
                                v-model="product.totalVolume"
                                label="제품 총 용량*"
                                required
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="4">
                              <v-text-field
                                v-model="product.dayVolume"
                                label="1일 용량*"
                                required
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="12">
                              <v-text-field
                                v-model="product.image"
                                label="Image"
                                prefix="URL"
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="12">
                              <v-text-field
                                v-model="product.etcIngredient"
                                label="기타 첨가물(상위 5개)"
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="12">
                              <v-textarea
                                v-model="product.description"
                                clear-icon="mdi-close-circle"
                                label="Description"
                              ></v-textarea>
                            </v-col>
                          </v-row>
                        </v-container>
                        <small>*indicates required field</small>
                      </v-card-text>
                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                          color="blue darken-1"
                          text
                          @click="dialog = false"
                        >
                          Close
                        </v-btn>
                        <v-btn color="blue darken-1" text @click="submit">
                          Save
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                </v-col>
              </v-row>
              <v-card-title>
                <v-text-field
                  v-model="search"
                  append-icon="mdi-magnify"
                  label="Search"
                  single-line
                  hide-details
                ></v-text-field>
              </v-card-title>
              <v-layout row wrap>
                <v-flex
                  v-for="item in itemlist"
                  :key="item.itemId"
                  xs12
                  md6
                  lg3
                >
                  <v-card class="mx-auto my-5" max-width="250" width="95%">
                    <v-img height="250" :src="item.image"></v-img>

                    <v-card-title v-text="item.name"></v-card-title>
                    <v-card-text>
                      <div>
                        주요성분: L.sakei Probio65
                      </div>
                    </v-card-text>

                    <v-divider class="mx-4"></v-divider>

                    <v-card-text>
                      <v-chip-group
                        v-model="selection"
                        active-class="deep-purple accent-4 white--text"
                        column
                      >
                        <v-chip color="blue lighten-4">수분</v-chip>
                        <v-chip>민감성</v-chip>
                      </v-chip-group>
                    </v-card-text>
                  </v-card>
                </v-flex>
              </v-layout>
            </v-col>
            <v-col cols="1"></v-col>
          </v-row>
          <v-row>
            <v-col cols="2"></v-col>
            <v-col cols="8">
              <v-textarea
                filled
                name="input-7-4"
                readonly="true"
                value="주식회사 라이크팜에서 제공하는 정보는 신뢰할 만한 자료 및 정보로부터 얻어진 것이나 그 정확성이나 완전성을 보장 할 수 없으며, 시간이 경과함에 따라 변경될 수 있습니다.

따라서 정보의 오류, 누락에 대하여 주식회사 라이크팜 또는 주식회사 라이크팜에 자료를 제공하는 기관에서는 그 결과에 대해 법적인 책임을 지지 않습니다. 모든 콘텐츠에 대한 저작권은 주식회사 라이크팜에 있으며 사전 허가없이 이를 무단으로 사용하거나, 데이터베이스화 할 경우 민형사상 책임을 물을 수 있습니다."
              ></v-textarea>
            </v-col>
            <v-col cols="2"></v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import ProductService from "../services/productService";

export default {
  name: "product",
  data() {
    return {
      dialog: false,
      date: new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
        .toISOString()
        .substr(0, 10),
      menu: false,
      modal: false,
      menu2: false,
      product: {
        name: "",
        ingredientCode: null,
        subIngredient: "",
        formulation: "",
        registeredDate: "",
        origin: "",
        perContent: 0,
        price: 0,
        totalVolume: 0,
        dayVolume: 0,
        image: "",
        etcIngredient: "",
        description: "",
      },
      ingredientCodeList: [
        "M1 (히알루론산)",
        "M2 (비타민B7)",
        "M3 (세라마이드)",
        "M3-1 (곤약감자추출물)",
        "M4",
        "M5",
        "M6",
        "M7",
        "M8",
        "M9",
        "M10",
        "M11",
        "P1",
        "P2",
        "P3",
        "P4",
        "P5",
        "P6",
        "P7",
        "P8",
        "P8-1",
        "P8-2",
        "P8-3",
        "P9",
        "P10",
        "P11",
        "P12",
        "P13",
        "P14",
        "P15",
        "P16",
        "P17",
        "P18",
        "P19",
        "P20",
        "P21",
        "P22",
        "P23",
        "P24",
        "R1",
        "R2",
        "R3",
        "R4",
        "R5",
        "T1",
        "T2",
        "T3",
        "T4",
        "T4-1",
        "T5",
        "T5-1",
        "T6",
        "T7",
        "T7-1",
        "W1",
        "W1-1",
        "W1-2",
        "W1-3",
        "W1-4",
        "W1-5",
        "W2",
        "W2-1",
        "W2-2",
        "W3",
        "W3-1",
        "W3-2",
        "W3-3",
        "W3-4",
        "W3-5",
        "W3-6",
        "W4",
        "W5",
        "W6",
        "W7",
        "W8",
        "W9",
        "W10",
        "W11",
        "W12",
        "W13",
        "W14",
        "W15",
        "W16",
        "W17 (마그네슘)",
        "W18 (알로에베라분말)",
      ],
      itemlist: [
        {
          name: "토트랑 피부유산균키즈",
          image:
            "https://shopping-phinf.pstatic.net/main_8245820/82458207022.5.jpg",
          ingredient: "L.sakei Probio65",
        },
        {
          name: "에버콜라겐 인앤업비오틴 셀",
          image:
            "https://shopping-phinf.pstatic.net/main_2066453/20664531803.20201126141751.jpg",
          ingredient: "L-아스코브산나트륨,비오틴,산화아연",
        },
        {
          name: "면역엔 알로에 스틱",
          image:
            "https://shopping-phinf.pstatic.net/main_2678831/26788316525.20210420154532.jpg",
          ingredient: "비타민B1질산염,비타민 B6 염산염",
        },
        {
          name: "면역근원 베타글루칸",
          image:
            "https://shopping-phinf.pstatic.net/main_8245820/82458207022.5.jpg",
          ingredient: "베타글루칸분말",
        },
        {
          name: "뉴트리키즈 비타민 무기질",
          image:
            "https://shopping-phinf.pstatic.net/main_1693687/16936874310.1.jpg",
          ingredient: "비타민 B6 염산염,비타민 C",
        },
        {
          name: "헬스원 멀티비타민 포 우먼",
          image:
            "https://shopping-phinf.pstatic.net/main_8302185/83021855448.jpg",
          ingredient: "판토텐산칼슘,비타민E혼합제제",
        },
      ],
      search: "",
    };
  },
  methods: {
    submit() {
      console.log(this.product);
      ProductService.insertProduct(this.product)
        .then((response) => {
          this.dialog = false;
        })
        .catch((err) => {
          alert("Sorry for fail");
          console.log(err);
        });
    },
  },
};
</script>
