<template>
  <v-row no-gutters>
    <v-col class="shrink">
      <base-avatar
        :key="`post-date`"
        color="grey"
        tile
        size="100"
        class="ma-2"
      />
    </v-col>
    <v-col class="pl-2">
      <base-title
        :title="post.title"
        size="title"
        class="primary--text"
        space="0"
      />
      <base-body
        :key="`post-text`"
        space="0"
        :clamp="clamp"
        :text="post.text"
      />
      <div>
        <router-link
          v-if="post.to"
          :to="post.to"
          class="text-none"
          v-text="'Read More'"
        />
        <template v-if="post.date">
          <v-icon
            class="ml-4 mr-2"
            small
            v-text="'mdi-clock-outline'"
          />
          <span v-text="post.date" />
        </template>
        <template v-if="post.comments">
          <v-icon
            class="ml-4 mr-2"
            v-text="'mdi-comment'"
          />
          <span
            class="font-italic"
            v-text="'comments'"
          />
        </template>
      </div>
    </v-col>
  </v-row>
</template>

<script>
  export default {
    name: 'BlogPost',
    props: {
      post: {
        type: Object,
        required: true,
      },
      clamp: {
        type: [Number, String],
        default: 0,
      },
    },
  }
</script>

<style lang="scss" scoped>

</style>
