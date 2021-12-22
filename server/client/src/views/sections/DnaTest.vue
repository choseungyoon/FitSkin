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
        class="px-10"
      >
        <base-heading
          class="font-weight-bold py-3"
          title="유전자 검사를 통해 이너뷰티 추천"
          align="left"
        />
        <base-body
          text="헬스 및 뷰티에 초점을 맞춘 유전자 검사 항목(12가지)을 분석한 결과와 핏스킨 알고리즘이 결합되어 맞춤형 결과를 추천합니다"
        />
        <base-body
          text="유전저 검사를 통해 맞춤형 이너뷰티와 이력관리까지 받아보세요."
        />
        <base-btn
          class="my-10 elevation-0 mx-1"
          rounded
          color="black"
          dark
          depressed
          href="https://store.vuetifyjs.com/products/flairo-theme-pro"
          target="_blank"
        >
          <span
            class="font-weight-black text-none"
            v-text="`자세히 보기`"
          />
        </base-btn>
      </v-col>
      <v-col
        cols="12"
        md="6"
      >
        <v-img
          :min-height="$vuetify.breakpoint.mdAndUp ? '500px' : '200px'"
          :height="$vuetify.breakpoint.mdAndUp ? '500px' : '200px'"
          :min-width="$vuetify.breakpoint.mdAndUp ? '600px' : '300px'"
          :src="require('@/assets/fitskin-img/dnaTest.jpeg')"
        />
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
