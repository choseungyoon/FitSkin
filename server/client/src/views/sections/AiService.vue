<template>
  <base-section
    id="our-services"
  >
    <div class="justify-center align-center">
      <base-heading
        class="font-weight-bold"
        title="FitSkin만의 AI 기반 제품 추천 서비스"
        align="center"
      />
      <base-divider
        color="primary"
        align="center"
      />
    </div>
    <!--
    <v-row
      align="center"
      justify="center"
    >
      <v-col
        cols="12"
        md="6"
      >
        <v-img
          :min-height="$vuetify.breakpoint.mdAndUp ? '300px' : '150px'"
          :height="$vuetify.breakpoint.mdAndUp ? '300px' : '100px'"
          :min-width="$vuetify.breakpoint.mdAndUp ? '500px' : '200px'"
          :src="require('@/assets/fitskin-img/naver_ai_logo.png')"
        />
      </v-col>
    </v-row>
    -->
    <v-row
      justify="center"
      align="stretch"
      class="px-3"
    >
      <template v-for="(feature, i) in features">
        <v-col
          :key="i"
          cols="12"
          md="5"
          lg="5"
        >
          <base-feature-alt
            class="pa-1"
            v-bind="feature"
          />
        </v-col>
      </template>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionOurServices',
    data () {
      return {
        features: [
          {
            icon: 'mdi-numeric-6',
            outlined: true,
            title: '6가지 주요 성분',
            text: '보습 , 수분, 피지분비 , 민감성 , 색소침착 , 트러블 관련 주요 피부 지표를 통해 알맞은 제품을 추천합니다',
          },
          {
            icon: 'mdi-google-analytics',
            outlined: true,
            title: 'Naver AI기반 사용자 맞춤 추천 모델',
            text: 'Naver AI 기반으로 FitSkin 만의 피부 분석 모델로 최적의 제품을 제공합니다',
          },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
