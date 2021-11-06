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
                      <v-btn
                        color="primary"
                        dark
                        v-bind="attrs"
                        v-on="on"
                        @click="editProduct(0)"
                      >
                        Add Product
                      </v-btn>
                    </template>
                    <v-card>
                      <v-card-title>
                        <span class="text-h5">{{ dialogName }}</span>
                      </v-card-title>
                      <v-card-text>
                        <v-container>
                          <v-row>
                            <v-col cols="12" sm="12" md="12">
                              <v-text-field
                                v-model="product.name"
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
                                type="number"
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
                                type="number"
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="4">
                              <v-text-field
                                v-model="product.totalVolume"
                                label="제품 총 용량*"
                                required
                                type="number"
                              ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="4">
                              <v-text-field
                                v-model="product.dayVolume"
                                label="1일 용량*"
                                type="number"
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
                  v-model="param"
                  append-icon="mdi-magnify"
                  label="Search"
                  single-line
                  hide-details
                  @keydown.enter="searchProduct(param)"
                ></v-text-field>
              </v-card-title>
              <v-layout row wrap>
                <v-flex
                  v-for="item in paginatedData"
                  :key="item.itemId"
                  xs12
                  md6
                  lg3
                >
                  <v-card
                    class="mx-auto my-5"
                    max-width="250"
                    width="95%"
                    @click.stop="editProduct(item.id)"
                  >
                    <v-img height="250" :src="item.image"></v-img>

                    <v-card-title v-text="item.name"></v-card-title>
                    <v-card-text>
                      <div>주요 성분 : {{ item.ingredient }}</div>
                    </v-card-text>

                    <v-divider class="mx-4"></v-divider>

                    <v-card-text>
                      <v-chip-group
                        v-model="selection"
                        active-class="deep-purple accent-4 white--text"
                        column
                      >
                        <v-chip color="blue lighten-4">{{ item.index }}</v-chip>
                      </v-chip-group>
                    </v-card-text>
                  </v-card>
                </v-flex>
              </v-layout>
            </v-col>
            <v-col cols="1"></v-col>
          </v-row>
          <v-row>
            <v-col cols="4"></v-col>
            <v-col cols="4">
              <div class="btn-cover" style="text-align: center;">
                <v-btn
                  :disabled="pageNum === 0"
                  @click="prevPage"
                  class="page-btn"
                >
                  이전
                </v-btn>
                <span class="page-count"
                  >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
                >
                <v-btn
                  :disabled="pageNum >= pageCount - 1"
                  @click="nextPage"
                  class="page-btn"
                >
                  다음
                </v-btn>
              </div>
            </v-col>
            <v-col cols="4"></v-col>
          </v-row>
          <v-row> <br /><br /> </v-row>
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
      dialogName: "",
      date: new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
        .toISOString()
        .substr(0, 10),
      menu: false,
      modal: false,
      menu2: false,
      product: {
        productId: "",
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
      ingredientCodeList: [],
      itemlist: [],
      search: "",
      pageNum: 0,
      editId: 0,
    };
  },
  props: {
    pageSize: {
      type: Number,
      required: false,
      default: 12,
    },
  },
  computed: {
    pageCount() {
      let listLeng = this.itemlist.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      /*
      아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
      이런식으로 if 문 없이 고칠 수도 있다!
      */
      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
        end = start + this.pageSize;
      return this.itemlist.slice(start, end);
    },
  },
  created() {
    var ref = this;
    this.getAllProduct();
    ProductService.getIngredientAll().then((response) => {
      ref.ingredientCodeList = [];

      response.data.data.forEach(function(element) {
        ref.ingredientCodeList.push(element.code);
      });
    });
  },
  methods: {
    getAllProduct() {
      var ref = this;
      ProductService.getProductAll()
        .then((response) => {
          console.log(response.data);
          ref.itemlist = [];

          response.data.forEach(function(element) {
            var index;
            switch (element.ingredientCode.charAt(0)) {
              case "M":
                index = "보습";
                break;
              case "P":
                index = "색소침착";
                break;
              case "R":
                index = "민감성";
                break;
              case "T":
                index = "트러블 완화";
                break;
              case "W":
                index = "탄력";
                break;
            }
            ref.itemlist.push({
              id: element.productId,
              name: element.name,
              image: element.image,
              ingredient: element.ingredientCode,
              index: index,
            });
          });
        })
        .catch((err) => {
          alert("Sorry for fail!!!");
          console.log(err);
        });
    },
    clearAll() {
      (this.product.name = ""),
        (this.product.ingredientCode = null),
        (this.product.subIngredient = ""),
        (this.product.formulation = ""),
        (this.product.registeredDate = ""),
        (this.product.origin = ""),
        (this.product.perContent = 0),
        (this.product.price = 0),
        (this.product.totalVolume = 0),
        (this.product.dayVolume = 0),
        (this.product.image = ""),
        (this.product.etcIngredient = ""),
        (this.product.description = "");
    },
    submit() {
      console.log(this.product);
      if (this.product.productId == "new") {
        this.clearAll();
        ProductService.insertProduct(this.product)
          .then((response) => {
            console.log(response.data);
            this.dialog = false;
            this.getAllProduct();
          })
          .catch((err) => {
            alert("Sorry for fail");
            console.log(err);
          });
      } else {
        ProductService.updateProduct(this.product)
          .then((response) => {
            console.log(response.data);
            this.dialog = false;
            this.getAllProduct();
          })
          .catch((err) => {
            alert("Sorry for fail");
            console.log(err);
          });
      }
    },
    searchProduct(param) {
      console.log(param);
      var ref = this;
      ProductService.searchProduct(param)
        .then((response) => {
          console.log(response.data);
          ref.itemlist = [];

          response.data.forEach(function(element) {
            var index;
            switch (element.ingredientCode.charAt(0)) {
              case "M":
                index = "보습";
                break;
              case "P":
                index = "색소침착";
                break;
              case "R":
                index = "민감성";
                break;
              case "T":
                index = "트러블 완화";
                break;
              case "W":
                index = "탄력";
                break;
            }
            ref.itemlist.push({
              name: element.name,
              image: element.image,
              ingredient: element.ingredientCode,
              index: index,
            });
          });
        })
        .catch((err) => {
          alert("Sorry for fail");
          console.log(err);
        });
    },
    nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    },
    editProduct(id) {
      if (id == 0) {
        this.dialogName = "New Product";
        this.product.productId = "new";
      } else {
        this.dialogName = "Edit Product";
        this.editId = id;
        console.log("id : " + id);
        ProductService.getProduct(id)
          .then((response) => {
            console.log(response.data);
            this.product.productId = response.data.data.productId;
            this.product.name = response.data.data.name;
            this.product.image = response.data.data.image;
            this.product.ingredientCode = response.data.data.ingredientCode;
            this.product.formulation = response.data.data.formulation;
            this.product.registeredDate = response.data.data.registeredDate;
            this.product.origin = response.data.data.origin;
            this.product.perContent = response.data.data.perContent;
            this.product.price = response.data.data.price;
            this.product.totalVolume = response.data.data.totalVolume;
            this.product.dayVolume = response.data.data.dayVolume;
            this.product.description = response.data.data.description;
          })
          .catch((err) => {
            console.log(err);
          });
      }

      this.dialog = true;
    },
  },
};
</script>

<style scoped>
.page-count {
  padding-left: 10px;
  padding-right: 10px;
}
</style>
