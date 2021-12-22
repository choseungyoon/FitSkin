<template>
  <v-hover #default="{ hover }">
    <v-card
      max-height="400"
      width="auto"
      class="px-auto"
      flat
      tile
    >
      <v-img
        min-height="300"
        max-height="300"
        fill
        :src="src"
      >
        <v-fade-transition>
          <div
            v-if="hover"
            class="d-flex transition-fast-in-fast-out v-card--reveal primary"
            style="height: 100%; opacity: .9"
          >
            <v-row
              class="flex-column"
              justify="center"
              align="center"
            >
              <v-btn
                :to="{ name: 'ProjectDetail', params: { id } }"
                class="mx-2 mb-2"
                icon
                dark
                x-large
              >
                <v-icon
                  class="mx-0"
                  x-large
                  v-text="'mdi-link'"
                />
              </v-btn>
              <div
                class="font-weight-black mb-2 text-left"
                v-text="title"
              />
              <div
                class="mb-2 text-left"
                v-text="subtitle"
              />
            </v-row>
          </div>
        </v-fade-transition>
      </v-img>
    </v-card>
  </v-hover>
</template>

<script>
  export default {
    name: 'BaseProject',

    props: {
      id: [String, Number],
      title: {
        type: String,
        required: true,
      },
      subtitle: String,
      src: {
        type: String,
        required: true,
      },
    },
  }
</script>

<style lang="scss" scoped>

</style>
