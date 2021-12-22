<template>
  <base-section id="not-found">
    <v-img
      :src="require('@/assets/not-found.svg')"
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
              title="That page doesn't exist"
            />
          </v-responsive>
        </v-container>
      </v-theme-provider>
    </v-img>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionNotFound',
  }
</script>

<style lang="scss" scoped>

</style>
