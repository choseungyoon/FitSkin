<template>
  <base-section
    id="stats"
    class="primary"
  >
    <v-row
      justify="center"
      align="center"
      class="px-10"
    >
      <template v-for="(stat, i) in stats">
        <v-col
          :key="i"
          cols="12"
          sm="6"
          md="3"
          class="text-center"
        >
          <base-stat
            class="pa-3"
            v-bind="stat"
          />
        </v-col>
      </template>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionStats',
    data () {
      return {
        stats: [
          { text: 'Awards Won', number: '5', outlined: true, color: 'white' },
          { text: 'Projects', number: '322', color: 'white' },
          { text: 'Positive Reviews', number: '2182', outlined: true, color: 'white' },
          { text: 'Revenue', number: '$5M', color: 'white' },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
