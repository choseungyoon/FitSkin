<template>
  <component
    :is="wrapper.name"
    v-bind="wrapper.props"
  >
    <v-container class="fill-height">
      <v-responsive
        class="mx-auto shrink text-center"
        max-width="90%"
        width="700"
      >
        <v-avatar
          class="mb-6"
          size="128"
        >
          <v-img
            :src="src"
            min-height="128px"
          />
        </v-avatar>

        <p class="font-italic text-center black--text mb-6 d-block">
          "{{ customer.review }}"
        </p>

        <h4 class="text-center headline text-uppercase">
          - {{ customer.name }}
        </h4>

        <p
          v-if="customer.title"
          class="text-center primary--text darken-2 font-weight-medium"
        >
          {{ customer.title }}
        </p>
      </v-responsive>
    </v-container>
  </component>
</template>

<script>
  import VSheet from 'vuetify/lib/components/VSheet'
  import VImg from 'vuetify/lib/components/VImg'

  export default {
    name: 'BaseTestimony',
    props: {
      src: String,
      backgroundSrc: String,
      customer: {
        type: Object,
        required: true,
      },
    },
    computed: {
      wrapper () {
        const imgProps = {
          src: this.backgroundSrc,
          maxWidth: '100%',
          maxHeight: '500px',
          gradient: 'to right, rgba(241, 241, 241, .2), rgba(241, 241, 241, .5)',
        }
        return {
          name: this.backgroundSrc ? VImg : VSheet,
          props: this.backgroundSrc ? imgProps : { height: '500px', width: '100%', color: '#f1f1f1' },
        }
      },
    },
  }
</script>

<style lang="scss" scoped>

</style>
