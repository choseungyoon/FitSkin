<template>
  <base-section id="construction">
    <v-img
      :src="require('@/assets/under-construction-dual.svg')"
      min-height="500px"
      max-height="500px"
    >
      <v-theme-provider>
        <v-container class="fill-height px-5 py-12">
          <v-responsive
            class="d-flex align-center justify-center"
            height="100%"
            width="100%"
          >
            <base-heading
              class="text-uppercase font-weight-bold pb-12"
              align="center"
              title="Under Construction"
            />
          </v-responsive>
        </v-container>
      </v-theme-provider>
    </v-img>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionConstruction',
  }
</script>

<style lang="scss" scoped>

</style>
