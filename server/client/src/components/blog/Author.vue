<template>
  <v-card
    color="grey lighten-4"
    flat
    class="ma-4"
  >
    <v-card-text>
      <v-row>
        <v-col class="shrink">
          <v-avatar
            size="128"
            tile
          >
            <v-img
              :src="src"
              min-height="128px"
            />
          </v-avatar>
        </v-col>
        <v-col>
          <base-title
            space="2"
            weight="bold"
            v-text="name"
          />
          <base-body
            space="0"
            v-text="bio"
          />
        </v-col>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
  export default {
    name: 'BlogBlockquote',

    props: {
      name: String,
      bio: String,
      src: String,
    },
  }
</script>

<style lang="scss" scoped>

</style>
