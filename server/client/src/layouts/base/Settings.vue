<template>
  <v-menu
    v-model="menu"
    :close-on-content-click="false"
    bottom
    left
    max-width="90%"
    min-width="275"
    offset-x
    offset-y
    origin="top right"
    transition="scale-transition"
  >
    <template #activator="{ attrs, on }">
      <v-card
        class="py-2 px-4"
        color="#0000004D"
        dark
        flat
        :style="`position: fixed; top: ${$vuetify.breakpoint.smAndDown ? '70px': '230px'}; right: -35px;`"
        width="90"
        v-bind="attrs"
        v-on="on"
      >
        <v-icon>
          mdi-cog
        </v-icon>
      </v-card>
    </template>

    <v-card class="py-2">
      <v-card-text>
        <base-btn
          block
          text
          color="grey darken-1"
          dark
          @click="menu = false"
        >
          Settings
        </base-btn>
      </v-card-text>
    </v-card>
  </v-menu>
</template>

<script>
  export default {
    name: 'BaseSettings',

    data () {
      return {
        menu: false,
      }
    },
  }
</script>
