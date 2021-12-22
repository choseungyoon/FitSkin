<template>
  <base-section
    id="callout"
    class="grey lighten-3"
  >
    <div class="justify-center align-center text-center">
      <base-heading
        class="font-weight-bold"
        title="SUPER FLEXIBLE"
        align="center"
      />
      <base-body
        text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam aliquet mauris non venenatis auctor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per."
        align="center"
      />
      <base-btn
        rounded
        color="offblack"
        dark
        href="https://store.vuetifyjs.com/products/flairo-theme-pro"
        target="_blank"
      >
        <span
          class="font-weight-medium text-none"
          v-text="`Purchase ${appData.title}`"
        />
      </base-btn>
    </div>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionCallout',
  }
</script>

<style lang="scss" scoped>

</style>
