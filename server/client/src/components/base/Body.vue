<template>
  <component
    :is="tag"
    :class="classes"
    :style="styles"
    class="base-body body-1"
    v-bind="$attrs"
    v-on="$listeners"
  >
    <!-- Only use v-html for user data -->
    <div
      v-if="text"
      :style="textStyles"
      v-text="text"
    />

    <div
      v-else-if="html"
      :style="textStyles"
      v-html="html"
    />

    <slot v-else />
  </component>
</template>

<script>
  export default {
    name: 'BaseBody',

    inject: ['theme'],

    props: {
      html: String,
      maxWidth: {
        type: [Number, String],
        default: undefined,
      },
      space: {
        type: [Number, String],
        default: 10,
      },
      tag: {
        type: String,
        default: 'p',
      },
      align: {
        type: String,
        default: 'left',
        validator: (v) => ['left', 'center', 'right'].includes(v),
      },
      text: String,
      clamp: {
        type: [String, Number],
        default: 'none',
      },
    },

    computed: {
      classes () {
        return [
          this.theme.isDark ? 'white--text' : 'offblack--text',
          this.theme.isDark ? 'text--lighten-1' : 'text--darken-1',
          `text-${this.align}`,
          `mb-${this.space}`,
        ]
      },
      styles () {
        return {
          maxWidth: `${this.maxWidth}px`,
        }
      },
      textStyles () {
        return this.clamp === 'none' ? {} : {
          display: '-webkit-box',
          '-webkit-line-clamp': String(this.clamp),
          '-webkit-box-orient': 'vertical',
          overflow: 'hidden',
        }
      },
    },
  }
</script>
