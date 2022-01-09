<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'Store',
    metaInfo: { title: 'Store' },
    extends: View,
    mixins: [
      LoadSections([
        'category',
      ]),
    ],
  }
</script>
