<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'Contact',

    metaInfo: { title: 'Contact' },

    extends: View,

    mixins: [
      LoadSections([
        'map',
        'get-in-touch',
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
