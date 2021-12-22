<template>
  <base-section
    id="blog-header"
    class="px-3"
    space="5"
  >
    <base-divider
      color="black"
      max-width="500"
    />
    <blog-author
      name="Martin Flox"
      bio="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit."
      :src="require('@/assets/testimony/testimony-1.jpg')"
    />
  </base-section>
</template>

<script>
  export default {
    name: 'SectionBlogAuthor',
    components: {
      BlogAuthor: () => import('@/components/blog/Author'),
    },
  }
</script>

<style lang="scss" scoped>

</style>
