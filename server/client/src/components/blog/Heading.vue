<template>
  <div>
    <base-subheading
      :title="title"
    />
    <div class="caption">
      <v-icon
        small
        v-text="'mdi-file-document-edit-outline'"
      />
      <span
        class="ma-1"
        v-text="`by ${author}`"
      />
      <v-icon
        small
        class="ml-2"
        v-text="'mdi-clock'"
      />
      <span
        class="ma-1"
        v-text="date"
      />
      <v-icon
        small
        class="ml-2"
        v-text="'mdi-comment'"
      />
      <span
        class="ma-1"
        v-text="commentCount"
      />
      <span v-text="'Comments'" />
    </div>
  </div>
</template>

<script>
  export default {
    name: 'BlogHeading',
    props: {
      title: String,
      author: String,
      date: String,
      commentCount: [Number, String],
    },
  }
</script>

<style lang="scss" scoped>

</style>
