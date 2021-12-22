<template>
  <base-section
    id="blog-header"
    class="px-3"
    space="5"
  >
    <blog-blockquote
      quote="Vivamus imperdiet eros at placerat mollis. Nam rutrum sagittis tellus, ac tempor libero interdum in. Morbi eros neque, tincidunt vitae nisl id, vulputate lacinia dolor. Suspendisse in lectus ac lectus ornare rhoncus a quis ex. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi bibendum, dolor eget blandit fermentum, eros purus porta quam, sit amet lacinia nisl leo eget nunc. Etiam ultricies consequat velit, sit amet iaculis eros. Nulla ut urna ultricies, vestibulum ligula id, efficitur enim. Duis laoreet sollicitudin lacus in egestas. Fusce congue interdum mi."
      author="Martin Flox"
    />
  </base-section>
</template>

<script>
  export default {
    name: 'SectionBlogHeader',
    components: {
      BlogBlockquote: () => import('@/components/blog/Blockquote'),
    },
  }
</script>

<style lang="scss" scoped>

</style>
