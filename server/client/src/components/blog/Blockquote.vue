<template>
  <v-card
    color="grey lighten-3"
    flat
    class="ma-4"
  >
    <v-card-text class="font-italic">
      <base-body
        space="0"
        v-text="quote"
      />
    </v-card-text>
    <v-card-text class="primary--text text-uppercase">
      <base-subtitle
        space="0"
        weight="bold"
        color="primary--text"
        v-text="author"
      />
    </v-card-text>
  </v-card>
</template>

<script>
  export default {
    name: 'BlogBlockquote',

    props: {
      author: String,
      quote: String,
    },
  }
</script>

<style lang="scss" scoped>

</style>
