<template>
  <v-card
    width="400"
    outlined
  >
    <v-card-text>
      <v-row justify="center">
        <base-avatar
          class="mt-n12"
          :icon="icon"
          size="70"
          icon-size="20"
          :color="avatarColor"
          :outlined="outlined"
          :outline-color="outlineColor"
        />
      </v-row>
      <v-row justify="center">
        <v-col cols="8">
          <span
            class="title primary--text"
            v-text="heading"
          />
        </v-col>
      </v-row>
      <v-row
        v-if="body"
        justify="center"
      >
        <v-col cols="12">
          <span
            class="body-2"
            v-text="body"
          />
        </v-col>
        <v-btn
          depressed
          outlined
          small
          color="primary"
          class="text-none"
          :to="to"
        >
          Read More
          <v-icon
            right
            v-text="'mdi-chevron-right'"
          />
        </v-btn>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
  export default {
    name: 'Feature',

    props: {
      color: {
        type: String,
        default: 'white',
      },
      icon: {
        type: String,
        required: true,
      },
      heading: {
        type: String,
        required: true,
      },
      body: {
        type: String,
        default: '',
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
      to: {
        type: Object,
        default: () => ({}),
      },
    },
  }
</script>
