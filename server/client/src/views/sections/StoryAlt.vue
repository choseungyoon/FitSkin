<template>
  <base-section
    id="story-alt"
    class="grey lighten-4"
  >
    <v-row
      align="center"
      justify="center"
    >
      <v-col
        cols="12"
        md="6"
      >
        <v-img
          :min-height="$vuetify.breakpoint.mdAndUp ? '500px' : '200px'"
          :height="$vuetify.breakpoint.mdAndUp ? '500px' : '200px'"
          :min-width="$vuetify.breakpoint.mdAndUp ? '600px' : '300px'"
          :src="require('@/assets/fitskin-img/story-alt.png')"
        />
      </v-col>
      <v-col
        cols="12"
        md="6"
        class="px-10"
      >
        <base-heading
          class="font-weight-bold py-3"
          title="나만의 이너뷰티를 찾아보세요"
          align="left"
        />
        <base-body
          text="FitSkin의 자체 알고리즘 기반으로 설문을 통해 현재 보충이 필요한 피부 성분과 FitSkin 인증제품을 추천드려요"
        />
        <base-body
          text="개인 맞춤형 설문 진단을 통해 피부 영양학적으로 분석하여 피부 진단 결과 제공 및 나의 주요 피부 성분 점수를 확인할 수 있어요"
        />
        <router-link
          to="/survey"
          tag="button"
        >
          <base-btn
            class="my-10 elevation-0 mx-1"
            rounded
            color="black"
            dark
            depressed
            target="_blank"
          >
            <span
              class="font-weight-black text-none"
              v-text="`나만의 ${appData.title} 제품 찾기`"
            />
          </base-btn>
        </router-link>
      </v-col>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionStoryAlt',
    data () {
      return {
        features: [
          {
            icon: 'mdi-flash',
            title: 'Fast',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-cog',
            title: 'Customizable',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-responsive',
            title: 'Responsive',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-face-agent',
            title: 'Friendly Support',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
