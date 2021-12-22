<template>
  <base-section
    class="blog-excerpt-left px-3"
    space="5"
  >
    <v-row>
      <v-col
        cols="12"
        md="6"
      >
        <base-body
          v-for="(text, i) in texts"
          :key="i"
          :text="text"
        />
      </v-col>
      <v-col
        cols="12"
        md="6"
      >
        <v-img
          :src="require('@/assets/instagram/lukasz-szmigiel-dAgtO5H8cXg-unsplash.jpg')"
          height="400px"
        />
      </v-col>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionBlogExcerptRightImg',
    data () {
      return {
        texts: [
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu tincidunt diam, eu ultricies felis. Sed pretium fringilla volutpat. Vestibulum vel justo a sapien tempus pretium ut nec mi. Duis ut turpis sodales, fermentum massa vel, laoreet nibh. Aliquam maximus finibus orci. Suspendisse potenti. Vestibulum pulvinar sapien egestas nulla efficitur vestibulum. Aenean tortor tortor, placerat eget lorem nec, ultrices consequat lacus. Mauris lacinia suscipit lacus, tempus laoreet nulla pellentesque vel. Vivamus at urna ultricies, elementum felis vel, tincidunt felis. Pellentesque vitae neque pellentesque odio aliquet iaculis. Aenean pretium dolor arcu, luctus bibendum leo porta quis. In imperdiet sapien ut maximus mattis.',
          'Pellentesque id mauris felis. Nulla rhoncus venenatis velit ut pellentesque. Etiam et erat feugiat justo egestas iaculis et vitae metus. Vestibulum maximus sapien nec elit sodales, ac fermentum sem tempor. Etiam luctus enim aliquam, faucibus lorem nec, vehicula augue. Maecenas imperdiet odio non nisl consequat, sit amet venenatis massa vehicula. Donec odio diam, blandit eu dignissim quis, ultricies nec mi. Sed eget facilisis tortor, ac aliquam erat. In vel augue finibus, venenatis massa a, venenatis dui.',
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
