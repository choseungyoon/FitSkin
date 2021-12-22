<template>
  <v-row no-gutters>
    <v-col class="shrink">
      <base-avatar
        :key="`tweet-date`"
        icon="mdi-twitter"
        icon-color="#1A91DA"
        color="grey lighten-3"
        tile
        size="100"
        class="ma-2"
      />
    </v-col>
    <v-col class="pl-2 py-2">
      <base-subheading
        :title="tweet.title"
        size="title"
        class="primary--text"
        space="0"
      />
      <base-body
        :key="`tweet-text`"
        space="0"
        :clamp="3"
        :text="tweet.text"
      />
      <div
        v-if="tweet.date"
        class="font-italic"
        v-text="tweet.date"
      />
    </v-col>
  </v-row>
</template>

<script>
  export default {
    name: 'BlogTweet',
    props: {
      tweet: {
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
