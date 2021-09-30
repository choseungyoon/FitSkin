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
</style>
