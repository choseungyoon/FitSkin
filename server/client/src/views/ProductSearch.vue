<template>
  <div class="product">
    <v-row>
      <v-col cols="12">
        <v-card>
          <v-row>
            <v-col cols="1"></v-col>
            <v-col cols="10">
              <v-card-title>
                <v-text-field
                  v-model="search"
                  append-icon="mdi-magnify"
                  label="Search"
                  single-line
                  hide-details
                ></v-text-field>
              </v-card-title>
              <v-row justify="center">
                <v-dialog v-model="dialog" persistent max-width="600px">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn color="primary" dark v-bind="attrs" v-on="on">
                      Open Dialog
                    </v-btn>
                  </template>
                  <v-card>
                    <v-card-title>
                      <span class="text-h5">User Profile</span>
                    </v-card-title>
                    <v-card-text>
                      <v-container>
                        <v-row>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field
                              label="Legal first name*"
                              required
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field
                              label="Legal middle name"
                              hint="example of helper text only on focus"
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field
                              label="Legal last name*"
                              hint="example of persistent helper text"
                              persistent-hint
                              required
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12">
                            <v-text-field
                              label="Email*"
                              required
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12">
                            <v-text-field
                              label="Password*"
                              type="password"
                              required
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6">
                            <v-select
                              :items="['0-17', '18-29', '30-54', '54+']"
                              label="Age*"
                              required
                            ></v-select>
                          </v-col>
                          <v-col cols="12" sm="6">
                            <v-autocomplete
                              :items="[
                                'Skiing',
                                'Ice hockey',
                                'Soccer',
                                'Basketball',
                                'Hockey',
                                'Reading',
                                'Writing',
                                'Coding',
                                'Basejump',
                              ]"
                              label="Interests"
                              multiple
                            ></v-autocomplete>
                          </v-col>
                        </v-row>
                      </v-container>
                      <small>*indicates required field</small>
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="blue darken-1" text @click="dialog = false">
                        Close
                      </v-btn>
                      <v-btn color="blue darken-1" text @click="dialog = false">
                        Save
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-row>

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
export default {
  name: "product",
  data() {
    return {
      dialog: false,
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
      headers: [
        {
          text: "영양제명",
          align: "start",
          sortable: false,
          value: "name",
        },
        { text: "가격", value: "price" },
        { text: "1회 섭취량 (g)", value: "serving" },
        { text: "주요 영양소", value: "ingredient" },
        { text: "함량 (g)", value: "content" },
        { text: "제품 소개", value: "description" },
      ],
      desserts: [
        {
          name:
            "California Gold Nutrition, CollagenUP, 하이드롤라이즈드 해양 콜라겐 + 히알루론산 + 비타민C, 무맛, 206g(7.26oz)",
          serving: " 1스쿱(5.16g♦)",
          price: 20000,
          ingredient: "칼로리",
          content: 20,
          description: "",
        },
        {
          name:
            "California Gold Nutrition, CollagenUP, 바다에서 얻은 하이드롤라이즈드콜라겐 + 히알루론산 + 비타민C, 무맛, 464g(16.37oz)",
          price: 20000,
          serving: " 1스쿱(5.16g♦)",
          ingredient: "단백질",
          content: 4,
          description: "",
        },
        {
          name:
            "Solumeve, Radiant Beauty, 목초사육 콜라겐, 프로바이오틱스 및 슈퍼 과일 분말 드링크 믹스, 트로피컬 히비스커스, 454g(16oz)",
          price: 20000,
          serving: 262,
          ingredient: 16.0,
          content: 23,
          description: 6.0,
        },
        {
          name:
            "Solumeve, Radiant Beauty, 목초사육 콜라겐, 프로바이오틱스 및 슈퍼 과일 분말 드링크 믹스, 감귤 향, 454g(16oz)",
          price: 20000,
          serving: 305,
          ingredient: 3.7,
          content: 67,
          description: 4.3,
        },
        {
          name: "Natrol, 비오틴, 최대 강도, 10,000mcg, 100 정",
          price: 20000,
          serving: 356,
          ingredient: 16.0,
          content: 49,
          description: 3.9,
        },
        {
          name: "Solgar, 피부, 손발톱 및 모발, 어드밴스드 MSM 포뮬라, 120정",
          price: 20000,
          serving: 375,
          ingredient: 0.0,
          content: 94,
          description: 0.0,
        },
        {
          name: "Solgar, 피부, 손발톱 & 모발, 고급 MSM 포뮬라, 60정",
          price: 20000,
          serving: 392,
          ingredient: 0.2,
          content: 98,
          description: 0,
        },
        {
          name: "Country Life, Maxi-Hair 플러스, 5,000mcg, 베지 캡슐 120정",
          price: 20000,
          serving: 408,
          ingredient: 3.2,
          content: 87,
          description: 6.5,
        },
        {
          name: "Natrol, 피부, 모발 및 손발톱, 어드밴스드 뷰티, 캡슐 60정",
          price: 20000,
          serving: 452,
          ingredient: 25.0,
          content: 51,
          description: 4.9,
        },
        {
          name: "Neocell, 슈퍼 콜라겐 펩타이드, 무맛, 200g(7oz)",
          price: 20000,
          serving: "4정",
          ingredient: "비타민B6(피리독신 HCI)",
          content: 60,
          description: "",
        },
      ],
    };
  },
};
</script>
