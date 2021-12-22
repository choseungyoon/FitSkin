<template>
  <base-section
    id="callout"
  >
    <v-parallax
      src="@/assets/fitskin-img/doctor.jpeg"
    >
      <div class="justify-center align-center text-center">
        <base-heading
          class="font-weight-bold"
          title="당신의 피부퍼즐 FitSkin과 함께 하세요!"
          align="center"
          space="0"
        />
        <router-link
          to="/survey"
          tag="button"
        >
          <base-btn
            rounded
            class="mt-10 mb-2 elevation-0"
            color="white primary--text"
            depressed
            target="_blank"
          >
            <span
              class="font-weight-black text-none"
              v-text="`나만의 피부비타민 추천`"
            />
          </base-btn>
        </router-link>
      </div>
    </v-parallax>
  </base-section>
</template>
<script>
  export default {
    name: 'SectionCallout',
  }
</script>

<style lang="scss" scoped>

</style>
