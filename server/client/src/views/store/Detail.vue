<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'ProjectDetail',

    metaInfo: { title: '상품정보' },

    extends: View,

    mixins: [
      LoadSections([
        'productDetail',
        'info',
      ]),
    ],

    props: {
      id: [Number, String],
    },
  }
</script>
