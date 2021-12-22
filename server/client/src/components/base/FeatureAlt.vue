<template>
  <v-card
    class="feat-alt"
    flat
    v-bind="$attrs"
  >
    <v-card-text class="py-0">
      <v-row
        align="start"
        justify="center"
      >
        <v-col cols="4">
          <base-avatar
            class="mr-6"
            :tile="tile"
            :rounded="rounded"
            :icon="icon"
            size="70"
            icon-size="25"
            :color="avatarColor"
            :outlined="outlined"
            :outline-color="outlineColor"
          />
        </v-col>
        <v-col
          cols="8"
          class="text-left"
        >
          <base-title
            class="primary--text"
            space="2"
            :title="title"
          />
          <base-body
            :text="text"
            space="2"
          />
          <router-link
            v-if="to"
            class="link"
            :to="to"
            v-text="'Read More'"
          />
          <v-icon
            v-if="to"
            color="primary"
            right
            small
            v-text="'mdi-chevron-right'"
          />
        </v-col>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
  export default {
    name: 'Feature',

    props: {
      icon: {
        type: String,
        required: true,
      },
      rounded: {
        type: Boolean,
        default: false,
      },
      tile: {
        type: Boolean,
        default: false,
      },
      avatarColor: {
        type: String,
        default: 'primary',
      },
      outlined: Boolean,
      outlineColor: String,
      title: {
        type: String,
        required: true,
      },
      text: {
        type: String,
        default: '',
      },
      to: Object,
    },
  }
</script>

<style lang="scss" scoped>
.link {
  text-decoration: none !important
}
</style>
