<template>
  <base-section
    id="hero"
    space="0"
  >
    <v-img
      :src="require('@/assets/fitskin-img/product.png')"
      min-height="695px"
    >
      <v-theme-provider>
        <v-container class="fill-height px-5 py-12">
          <v-responsive
            class="d-flex align-center justify-center"
            height="100%"
            width="99%"
          >
            <v-row align="center">
              <v-col
                cols="12"
                md="6"
              >
                <base-heading
                  class="text-uppercase font-weight-bold"
                  :title="`Why ${appData.title}?`"
                />
                <base-subheading
                  title="Your own Inner beauty"
                />
                <base-body
                  text="나만의 위한 합리적인 이너뷰티 찾아볼까요?"
                />
                <router-link
                  to="/survey"
                  tag="button"
                >
                  <base-btn
                    rounded
                    height="50px"
                    color="white"
                    class="primary--text font-weight-bold text-none mr-4 mb-1"
                    target="_blank"
                  >
                    <span v-text="`나만의 피부진단 시작하기`" />
                  </base-btn>
                </router-link>
              </v-col>
            </v-row>
          </v-responsive>
        </v-container>
      </v-theme-provider>
    </v-img>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionHero',
  }
</script>

<style lang="scss" scoped>

</style>
