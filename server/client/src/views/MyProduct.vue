<template>
  <div class="product_search">
    <div class="item">
      <v-card :loading="loading" class="mx-auto my-12" max-width="374">
        <template slot="progress">
          <v-progress-linear
            color="deep-purple"
            height="10"
            indeterminate
          ></v-progress-linear>
        </template>

        <v-img
          height="250"
          src="https://i1.wp.com/diycrafts9.com/wp-content/uploads/2020/09/What-is-your-skin-type-1.jpg?fit=844%2C621&ssl=1"
        ></v-img>

        <v-card-title>Self 피부타입 진단</v-card-title>

        <v-card-text>
          <v-row align="center" class="mx-0"> </v-row>

          <div>
            몇가지 진단을 통해 나의 피부 타입을 확인할 수 있습니다. <br />
            약 5분의 시간이 소요됩니다.
          </div>
        </v-card-text>
        <v-divider class="mx-4"></v-divider>
        <v-card-actions>
          <v-btn color="deep-purple lighten-2" text to="/survey">
            Self 진단하기
          </v-btn>
        </v-card-actions>
      </v-card>
    </div>

    <div class="item">
      <v-card :loading="loading" class="mx-auto my-12" max-width="374">
        <template slot="progress">
          <v-progress-linear
            color="deep-purple"
            height="10"
            indeterminate
          ></v-progress-linear>
        </template>

        <v-img
          height="250"
          src="https://cdn.bosa.co.kr/news/photo/201909/2111765_152494_1815.jpg"
        ></v-img>

        <v-card-title>유전자 키트 검사</v-card-title>

        <v-card-text>
          <v-row align="center" class="mx-0"> </v-row>

          <div>
            유전자 키트를 통해 보다 정확한 진단을 받을 수 있습니다.<br />
            집으로 유전자 검사 키트가 발송됩니다.
          </div>
        </v-card-text>

        <v-divider class="mx-4"></v-divider>

        <v-dialog v-model="dialog" max-width="600px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="deep-purple lighten-2" text v-bind="attrs" v-on="on">
              유전자 키트 받기
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
                    <v-text-field label="Name" required></v-text-field>
                  </v-col>

                  <v-col cols="12" sm="6" md="4">
                    <v-text-field
                      label="Age"
                      hint="만 나이를 적어주세요"
                      persistent-hint
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12">
                    <v-text-field label="Email*" required></v-text-field>
                  </v-col>
                  <v-col cols="12">
                    <v-text-field
                      label="Address"
                      hint="유전자 키트 배송받으실 주소를 입력해주세요"
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-select
                      :items="['남성', '여성']"
                      label="성별"
                      required
                    ></v-select>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-autocomplete
                      :items="['건조', '노안', '트러블', '지성', '예방']"
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
      </v-card>
    </div>
  </div>
</template>

<style scoped>
.product_search {
  display: flex;
  flex-flow: row wrap;
  justify-content: space-evenly;
}
.item {
  flex-basis: auto;
}
</style>
