<template>
  <base-section
    id="blog-header"
    class="px-3"
    space="5"
  >
    <blog-heading
      title="Lorem ipsum dolor sit amet, consectetur adipiscing elit."
      author="Martin Flox"
      :date="new Date().toLocaleDateString()"
      comment-count=""
    />
  </base-section>
</template>

<script>
  export default {
    name: 'SectionBlogHeader',
    components: {
      BlogHeading: () => import('@/components/blog/Heading'),
    },
  }
</script>

<style lang="scss" scoped>

</style>
