<template>
  <v-hover #default="{ hover }">
    <v-card
      max-height="400"
      width="auto"
      class="px-auto"
      flat
      outlined
      tile
    >
      <v-img
        min-height="300"
        height="100%"
        :src="src"
      >
        <v-fade-transition>
          <div
            v-if="hover && socialLinks.length"
            class="d-flex transition-fast-in-fast-out v-card--reveal white--text grey lighten-3"
            style="height: 100%; opacity: .8"
          >
            <v-row
              justify="center"
              align="center"
            >
              <v-btn
                v-for="site in socialLinks"
                :key="site.link"
                :href="site.link"
                target="_blank"
                class="mx-2"
                icon
                outlined
                x-large
              >
                <v-icon
                  class="mx-0"
                  x-large
                  v-text="site.icon"
                />
              </v-btn>
            </v-row>
          </div>
        </v-fade-transition>
      </v-img>
      <v-card-text
        class="pt-3"
        style="position: relative;"
      >
        <div
          class="font-weight-bold mb-2 text-left"
          v-text="name"
        />
        <div
          class="mb-2 text-left"
          v-text="title"
        />
      </v-card-text>
    </v-card>
  </v-hover>
</template>

<script>
  export default {
    name: 'BaseTeamMember',

    props: {
      name: {
        type: String,
        required: true,
      },
      src: {
        type: String,
        required: true,
      },
      title: String,
      socialLinks: {
        type: Array,
        default: () => ([]),
        validator: (val) => {
          return val.every(v => ({}).hasOwnProperty.call(v, 'link') && ({}).hasOwnProperty.call(v, 'icon'))
        },
      },
    },
  }
</script>

<style lang="scss" scoped>

</style>
