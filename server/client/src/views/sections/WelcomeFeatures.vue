<template>
  <base-section
    id="welcome-feature"
  >
    <div class="justify-center align-center">
      <base-heading
        class="font-weight-bold"
        :title="`피부영양 전문가가 큐레이션한 제품들을 만나보세요`"
        align="center"
      />
      <base-divider
        color="primary"
        align="center"
      />
      <base-body
        class="font-weight-black"
        text="약사, 약학박사, 화장품, 영양전문가등의 전문가가 인증한 FitSkin 인증제품을 만나보세요"
        align="center"
      />
      <base-body
        class="font-weight-black"
        text="국내외 전문기관 가이드라인 기준과 핏스킨 자체 알고리즘을 기반으로, 피부에 진짜 도움이 될 수 있는 제품들을 엄선하였습니다"
        align="center"
      />
      <base-body
        class="font-weight-black"
        text="효능없이 마켓팅만으로 핏스킨 인증을 통과 할 수 없습니다"
        align="center"
      />
    </div>
    <v-row
      justify="center"
      align="center"
      class="px-10"
    >
      <template v-for="(feature, i) in features">
        <v-col
          :key="i"
          cols="12"
          md="3"
        >
          <base-feature
            class="pa-3"
            v-bind="feature"
          />
        </v-col>
      </template>
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
        href="https://sell.smartstore.naver.com/#/home/about"
        target="_blank"
      >
        <span v-text="`FitSkin 인증제품 구경하기`" />
      </base-btn>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionWelcomeFeatures',
    data () {
      return {
        features: [
          {
            icon: 'mdi-file-document-multiple-outline',
            title: 'Simple Survey',
            text: '간단한 설문을 통해 맞춤형 제품을 빠르게 추천 받을 수 있어요',
          },
          {
            icon: 'mdi-brain',
            title: 'AI 추천 알고리즘',
            text: 'FitSkin만의 AI 추천 기능으로 나에게 필요한 제품을 찾아보세요',
          },
          {
            icon: 'mdi-face-agent',
            title: '피부 분야 전문가',
            text: '전문가가 인증한 제품으로 더 안전하게 사용하실 수 있어요',
          },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
