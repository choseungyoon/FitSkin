<template>
  <div
    :class="classes"
    class="base-avatar d-inline-flex"
  >
    <v-avatar
      v-if="outlined"
      :color="outlineColor || color || 'grey lighten-3'"
      :size="outlineSize"
      :style="outlineStyles"
      class="base-avatar__outline"
    />

    <v-avatar
      ref="avatar"
      :color="color || 'white'"
      :size="size"
      :tile="tile"
      :style="avatarStyles"
      class="base-avatar__avatar"
      v-bind="$attrs"
      v-on="$listeners"
    >
      <v-icon
        v-if="icon"
        :color="localIconColor"
        :size="size / 3"
      >
        {{ icon }}
      </v-icon>
      <span
        v-else-if="text"
        class="text-wrap"
        v-text="text"
      />
    </v-avatar>
  </div>
</template>

<script>
  export default {
    name: 'Avatar',

    props: {
      icon: String,
      iconColor: String,
      size: {
        type: [String, Number],
        default: '130',
      },
      color: {
        type: String,
        default: 'primary',
      },
      text: String,
      tile: Boolean,
      rounded: Boolean,
      outlined: Boolean,
      outlineColor: String,
    },

    data: (vm) => ({
      factor: 6,
    }),

    computed: {
      localIconColor () {
        if (this.iconColor) return this.iconColor
        return this.getIconColor()
      },
      classes () {
        return [
          this.outlined && 'base-avatar--outlined',
        ]
      },
      outlineSize () {
        return Number(this.size) + (this.size / this.factor)
      },
      outlineStyles () {
        const margin = this.size / (this.factor * 2)

        return {
          borderRadius: this.rounded
            ? '25%'
            : this.tile
              ? '0%'
              : '50%',
          // Aligns the outline content with the content
          opacity: this.outlineColor ? 1 : 0.4,
          margin: `-${margin}px 0 0 -${margin}px`,
        }
      },
      avatarStyles () {
        return {
          borderRadius: this.rounded
            ? '25%'
            : this.tile
              ? '0%'
              : '50%',
        }
      },
    },

    methods: {
      getIconColor () {
        const INTENSITY_THRESHOLD = 145
        const defaultColor = this.color === 'primary' ? 'white' : 'primary'
        const el = this.$refs.avatar?.$el
        if (!el) {
          return defaultColor
        }
        const styles = window.getComputedStyle(el)
        const color = styles.backgroundColor
        // eslint-disable-next-line no-unused-vars
        const [_, r, g, b] = /rgba?\((\d{1,3}), ?(\d{1,3}), ?(\d{1,3})\)?(?:, ?(\d(?:\.\d?))\))?/.exec(color)
        const redIntensity = +r * 0.300
        const greenIntensity = +g * 0.584
        const blueIntensity = +b * 0.114
        if (redIntensity + greenIntensity + blueIntensity < INTENSITY_THRESHOLD) {
          return 'white'
        }
        return defaultColor
      },
    },
  }
</script>

<style lang="sass" scoped>
  .base-avatar
    border-radius: 50%
    position: relative
    overflow: visible

    &__outline
      position: absolute !important
      left: 0
      top: 0

    &--outlined
      background-color: #FFFFFF
</style>
