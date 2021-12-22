<template>
  <v-card
    flat
    v-bind="$attrs"
  >
    <v-card-text>
      <v-row justify="center">
        <base-avatar
          :icon="icon"
          :tile="tile"
          :color="avatarColor"
          :outlined="outlined"
          :outline-color="outlineColor"
        />
      </v-row>
      <div
        class="text-center flex-column"
      >
        <base-subheading
          class="title primary--text mt-4"
          align="center"
          :title="title"
        />
        <base-body
          v-if="text"
          :text="text"
          align="center"
        />
      </div>
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
      tile: {
        type: Boolean,
        default: false,
      },
      title: {
        type: String,
        required: true,
      },
      text: {
        type: String,
        default: '',
      },
      avatarColor: {
        type: String,
        default: 'primary',
      },
      outlined: Boolean,
      outlineColor: String,
    },
  }
</script>
