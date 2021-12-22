<template>
  <div :style="{ width }">
    <v-row
      justify="space-between"
      no-gutters
      class="my-2"
    >
      <span v-text="skill" />
      <span v-text="`${value}%`" />
    </v-row>
    <v-row
      no-gutters
      class="my-2"
    >
      <v-progress-linear
        height="20"
        :value="value"
        v-bind="$attrs"
        v-on="$listeners"
      />
    </v-row>
  </div>
</template>

<script>
  export default {
    name: 'BaseSkillMeter',

    props: {
      width: {
        type: [Number, String],
        default: '100%',
      },
      skill: String,
      value: [Number, String],
    },
  }
</script>

<style lang="scss" scoped>

</style>
