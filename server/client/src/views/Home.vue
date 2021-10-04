<template>
  <div class="main">
    <section id="hero">
      <v-row no-gutters>
        <v-img
          :min-height="'calc(50vh - ' + $vuetify.application.top + 'px)'"
          src="../assets/img/product.jpeg"
        >
          <v-theme-provider dark>
            <v-container fill-height>
              <v-row
                align="center"
                class="white--text mx-auto"
                justify="center"
              >
                <v-col class="black--text text-center" cols="12" tag="h1">
                  <span
                    :class="[
                      $vuetify.breakpoint.smAndDown ? 'display-1' : 'display-2',
                    ]"
                    class="font-weight-light"
                  >
                    WELCOME TO
                  </span>

                  <br />

                  <span
                    :class="[
                      $vuetify.breakpoint.smAndDown ? 'display-3' : 'display-4',
                    ]"
                    class="font-weight-black"
                  >
                    FITSKIN
                  </span>
                </v-col>

                <v-btn
                  class="align-self-end"
                  fab
                  outlined
                  @click="$vuetify.goTo('#introduce')"
                  color="black"
                >
                  <v-icon>mdi-chevron-double-down</v-icon>
                </v-btn>
              </v-row>
            </v-container>
          </v-theme-provider>
        </v-img>
      </v-row>
    </section>

    <section id="introduce">
      <div class="py-12"></div>
      <v-container class="text-center">
        <h2 class="display-2 font-weight-bold mb-3">ABOUT SERVICE</h2>
        <v-responsive class="mx-auto mb-8" width="56">
          <v-divider class="mb-1"></v-divider>

          <v-divider></v-divider>
        </v-responsive>

        <v-responsive
          class="mx-auto title font-weight-light mb-8"
          max-width="720"
        >
          <strong>
            나만을 위한<br />
            합리적인<br />
            이너 뷰티<br /><br />
          </strong>
          <p>찾아볼까요?</p>
        </v-responsive>
      </v-container>
    </section>

    <section>
      <v-row>
        <v-img
          :min-height="'calc(50vh - ' + $vuetify.application.top + 'px)'"
          lazy-src="../assets/img/main_1.png"
        >
          <v-theme-provider dark>
            <v-container fill-height>
              <v-row
                align="center"
                class="white--text mx-auto"
                justify="center"
              >
                <v-col class="black--text text-center" cols="12" tag="h1">
                  <span
                    :class="[
                      $vuetify.breakpoint.smAndDown ? 'display-2' : 'display-3',
                    ]"
                    class="font-weight-bold"
                  >
                    당신의 피부건강
                  </span>

                  <br />
                  <br />
                  <span
                    :class="[
                      $vuetify.breakpoint.smAndDown ? 'display-1' : 'display-2',
                    ]"
                    class="font-weight-bold"
                  >
                    어떻게 관리하고 있나요?
                  </span>
                </v-col>
              </v-row>
            </v-container>
          </v-theme-provider>
        </v-img>
      </v-row>
    </section>

    <section>
      <v-row align="center" justify="center">
        <v-col cols="6" class="left">
          <v-img
            :min-height="'calc(50vh - ' + $vuetify.application.top + 'px)'"
            src="../assets/img/main_1.png"
          >
          </v-img>
        </v-col>
        <v-col cols="6" class="right" align="center" justify="center">
          <v-responsive class="mx-auto title font-weight-black" max-width="900">
            <strong
              style="font-size : 30px;  color: black; font-weight: bold ;"
            >
              당신의 피부건강 <br /><br />
              어떻게 관리하고 있나요? <br />
            </strong>
          </v-responsive>
        </v-col>
      </v-row>
    </section>

    <section id="section_2">
      <v-container class="text-center">
        <v-row align="center" justify="center">
          <v-col cols="6" class="left">
            <v-img
              :min-height="'calc(50vh - ' + $vuetify.application.top + 'px)'"
              src="../assets/img/main_1.png"
            >
            </v-img>
          </v-col>
          <v-col cols="6" class="right">
            <v-responsive
              class="mx-auto title font-weight-black"
              max-width="900"
            >
              당신의 피부건강 <br />
              어떻게 관리하고 있나요? <br />
            </v-responsive>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <section id="section_4">
      <div class="py-5"></div>
      <v-container class="text-center">
        <v-row align="center" justify="center">
          <v-col cols="6" class="left">
            <v-img
              :min-height="'calc(50vh - ' + $vuetify.application.top + 'px)'"
              src="../assets/img/main_3.png"
            >
            </v-img>
          </v-col>
          <v-col cols="6" class="right">
            <v-responsive
              class="mx-auto title font-weight-black"
              max-width="900"
            >
              <strong
                style="font-size : 25px;  color: black; font-weight: bold ;"
              >
                당신의 피부에 꼭 맞는 영양제, 제대로 알고 있나요? <br />
                <br />
                당신의 피부에게 필요한 성분, 제대로 알고 있나요? <br />
              </strong>
            </v-responsive>
          </v-col>
        </v-row>
      </v-container>
    </section>
    <section id="introduce">
      <div class="py-12"></div>
      <v-container class="text-center">
        <v-responsive class="mx-auto mb-8" width="56"> </v-responsive>

        <v-responsive
          class="mx-auto title font-weight-light mb-8"
          max-width="720"
        >
          <strong>
            당신의 피부퍼즐<br />
            <br />
            FITSKIN과 함께 하세요<br />
          </strong>
        </v-responsive>
      </v-container>
    </section>
    <div class="py-10"></div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.main {
  display: grid;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
strong {
  font-weight: bold;
  color: mediumaquamarine;
  font: caption;
  font-size: 50px;
}
p {
  font-weight: bold;
  color: mediumaquamarine;
  font-size: 20px;
}
em {
  font-size: 20px;
}
</style>
