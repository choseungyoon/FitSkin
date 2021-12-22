<template>
  <base-section
    id="related-posts"
    class="px-2"
  >
    <base-subheading
      title="Related Posts"
    />
    <base-divider align="left" />
    <v-row no-gutters>
      <template v-for="post in appData.relatedPosts">
        <v-col
          :key="post.id"
          cols="12"
          sm="6"
          md="4"
          class="px-1"
        >
          <blog-card
            :post="post"
            :src="require('@/assets/projects/jamison-mcandie-waZEHLRP98s-unsplash.jpg')"
          />
        </v-col>
      </template>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionRelatedBlogPosts',
    components: {
      BlogCard: () => import('@/components/blog/Card'),
    },
  }
</script>

<style lang="scss" scoped>

</style>
