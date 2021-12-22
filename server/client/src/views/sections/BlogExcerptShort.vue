<template>
  <base-section
    class="blog-excerpt-short px-3"
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
          'Nunc et facilisis purus, vitae dapibus lacus. Morbi aliquam libero vitae justo elementum aliquet. Aliquam semper auctor pellentesque. Morbi sit amet dolor eget lacus molestie ullamcorper. Vestibulum nec ornare nisl, ac imperdiet mi. Cras vitae condimentum velit, vitae interdum eros. Cras pretium faucibus tellus, id commodo elit ornare eu. Duis in pretium tortor, et eleifend ipsum. Cras lacus libero, dignissim nec neque ultrices, viverra consectetur enim.',
          'Nam id laoreet ex. Aenean diam magna, fringilla ac egestas in, tempus et urna. Proin placerat, felis sit amet rutrum euismod, orci tortor dictum lacus, sed consequat quam augue eu lorem. Duis non imperdiet lorem, nec gravida est. Maecenas ultricies ante lacus, non maximus ex tristique eu. Duis sed posuere lacus. Maecenas quis scelerisque lectus, eget ullamcorper ligula. Nam elementum a lectus et bibendum. Nunc ultricies consectetur dolor nec auctor. Vivamus mattis eros vitae sem venenatis, id aliquam nisi ultricies. In hac habitasse platea dictumst.',
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
