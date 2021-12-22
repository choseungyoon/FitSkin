<template>
  <v-btn
    :color="color"
    v-bind="$attrs"
    v-on="$listeners"
  >
    <slot v-if="!icon" />
    <v-icon
      v-else
      v-text="icon"
    />
  </v-btn>
</template>

<script>
  export default {
    name: 'Btn',

    props: {
      icon: String,
      color: {
        type: String,
        default: 'primary',
      },
    },
  }
</script>
