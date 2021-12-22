<template>
  <v-card
    width="352px"
    outlined
    color="#f5e5d7"
  >
    <v-row
      class="ma-8 flex-column"
    >
      <base-title
        :title="title"
        class="text-uppercase"
        align="center"
      />
      <base-subtitle
        :title="subtitle"
        align="center"
      />
      <base-heading
        :title="price"
        align="center"
      />
      <base-body
        :text="`/${frequency}`"
        class="font-weight-medium"
        align="center"
        space="0"
      />
    </v-row>
    <v-divider v-if="features.length" />
    <v-row
      v-for="(feature, i) in features"
      :key="i"
      class="d-flex flex-column"
      no-gutters
    >
      <base-body
        class="mx-auto pa-5"
        space="0"
        :text="feature"
      />
      <v-divider />
    </v-row>
    <v-card-actions class="px-8 py-10">
      <slot />
    </v-card-actions>
  </v-card>
</template>

<script>
  export default {
    name: 'BasePricingPlan',
    provide () {
      return {
        heading: this.heading,
      }
    },
    props: {
      features: {
        type: Array,
        default: () => ([]),
      },
      frequency: String,
      price: [String, Number],
      title: String,
      subtitle: String,
    },
    data () {
      return {
        heading: {
          align: 'center',
        },
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
