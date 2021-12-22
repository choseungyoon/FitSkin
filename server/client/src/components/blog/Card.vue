<template>
  <v-card
    flat
    outlined
  >
    <v-img
      height="350"
      :src="post.src"
    />

    <v-card-title>
      <base-title
        v-text="post.title"
      />
    </v-card-title>
    <v-card-text>
      <div class="caption">
        <v-icon
          small
          v-text="'mdi-file-document-edit-outline'"
        />
        <span
          class="ma-1"
          v-text="post.author"
        />
        <v-icon
          small
          class="ml-2"
          v-text="'mdi-clock'"
        />
        <span
          class="ma-1"
          v-text="post.date"
        />
        <v-icon
          small
          class="ml-2"
          v-text="'mdi-comment'"
        />
        <span
          class="ma-1"
          v-text="post.commentCount"
        />
        <span v-text="'Comments'" />
      </div>
      <base-body
        class="mt-4"
        v-text="post.description"
      />
    </v-card-text>
  </v-card>
</template>

<script>
  export default {
    name: 'BlogCard',
    props: {
      post: {
        type: Object,
        required: true,
      },
    },
  }
</script>

<style lang="scss" scoped>

</style>
