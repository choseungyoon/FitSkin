<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'Blog',

    metaInfo: { title: 'Blog' },

    extends: View,

    mixins: [
      LoadSections([
        'blog-asset',
        'blog-header',
        'blog-excerpt',
        'blog-quote',
        'blog-excerpt-left-img',
        'blog-excerpt-short',
        'blog-excerpt-right-img',
        'blog-author',
        'related-blog-posts',
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
