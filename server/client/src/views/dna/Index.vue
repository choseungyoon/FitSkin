<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'Dna',

    metaInfo: { title: '유전자 검사' },

    extends: View,

    mixins: [
      LoadSections([
        'ready-service',
        'info',
      ]),
    ],

    props: {
      id: {
        type: String,
        default: 'home',
      },
    },
  }
</script>
