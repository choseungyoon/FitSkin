<template>
  <v-avatar
    size="270"
    :style="styles"
  >
    <div
      :class="`${color}--text`"
    >
      <base-heading
        space="2"
        align="center"
        v-text="number"
      />
      <base-divider
        color="primary"
      />
      <base-body
        class="text-uppercase headline"
        align="center"
        space="2"
        v-text="text"
      />
    </div>
  </v-avatar>
</template>

<script>
  export default {
    name: 'Stat',
    props: {
      number: {
        type: [Number, String],
        required: true,
      },
      text: {
        type: String,
        required: true,
      },
      color: {
        type: String,
        default: 'primary',
      },
      outlined: {
        type: Boolean,
        default: false,
      },
    },
    computed: {
      styles () {
        const isDark = this.$vuetify.theme.isDark
        const namedColor = this.$vuetify.theme.themes[isDark ? 'dark' : 'light'][this.color]
        const mobile = this.$vuetify.breakpoint.mobile
        return {
          border: this.outlined && !mobile ? `2px ${namedColor ?? this.color} solid !important` : 'unset',
        }
      },
    },
  }
</script>

<style lang="scss" scoped>

</style>
