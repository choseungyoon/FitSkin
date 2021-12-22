<template>
  <base-section
    class="blog-excerpt px-3"
    space="5"
  >
    <base-body
      v-for="(text, i) in texts"
      :key="i"
      :text="text"
    />
  </base-section>
</template>

<script>
  export default {
    name: 'SectionBlogExcerpt',
    data () {
      return {
        texts: [
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu tincidunt diam, eu ultricies felis. Sed pretium fringilla volutpat. Vestibulum vel justo a sapien tempus pretium ut nec mi. Duis ut turpis sodales, fermentum massa vel, laoreet nibh. Aliquam maximus finibus orci. Suspendisse potenti. Vestibulum pulvinar sapien egestas nulla efficitur vestibulum. Aenean tortor tortor, placerat eget lorem nec, ultrices consequat lacus. Mauris lacinia suscipit lacus, tempus laoreet nulla pellentesque vel. Vivamus at urna ultricies, elementum felis vel, tincidunt felis. Pellentesque vitae neque pellentesque odio aliquet iaculis. Aenean pretium dolor arcu, luctus bibendum leo porta quis. In imperdiet sapien ut maximus mattis.',
          'Pellentesque id mauris felis. Nulla rhoncus venenatis velit ut pellentesque. Etiam et erat feugiat justo egestas iaculis et vitae metus. Vestibulum maximus sapien nec elit sodales, ac fermentum sem tempor. Etiam luctus enim aliquam, faucibus lorem nec, vehicula augue. Maecenas imperdiet odio non nisl consequat, sit amet venenatis massa vehicula. Donec odio diam, blandit eu dignissim quis, ultricies nec mi. Sed eget facilisis tortor, ac aliquam erat. In vel augue finibus, venenatis massa a, venenatis dui. Integer quis nisi at nibh pulvinar congue at vel quam.',
          'Phasellus at urna eget arcu vulputate luctus. Cras quis porta dolor. Fusce a sodales sapien, sed semper arcu. Morbi sed neque sit amet dolor viverra ultrices. Proin ac fermentum ex. Quisque sagittis sed mi suscipit faucibus. Cras ut ex sapien. Nullam eget leo at mauris tempus ornare sit amet at ligula. Vestibulum enim mauris, varius eget leo ultrices, tempus dictum nibh. Morbi ut felis mollis, semper eros vel, rutrum risus. In hac habitasse platea dictumst. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.',
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
