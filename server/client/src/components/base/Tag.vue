<template>
  <v-chip
    :class="classes"
    class="base-tag mx-1 my-2"
    v-bind="$attrs"
    v-on="$listeners"
  >
    <div
      v-if="text"
      v-text="text"
    />
    <slot v-else />
  </v-chip>
</template>

<script>
  export default {
    name: 'BaseTag',

    inject: ['theme'],

    props: {
      text: String,
    },

    computed: {
      classes () {
        return [
          this.theme.isDark ? 'white--text' : 'offblack--text',
          this.theme.isDark ? 'text--lighten-1' : 'text--darken-1',
        ]
      },
    },
  }
</script>
