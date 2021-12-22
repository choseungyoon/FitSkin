<template>
  <v-navigation-drawer
    :value="value"
    width="400px"
    class="py-5 pl-3"
    app
    absolute
    clipped
    floating
    right
    @input="$emit('input', $event)"
  >
    <template #prepend>
      <v-btn
        style="position:absolute;right:16px;top:12px"
        icon
        @click="$emit('input', false)"
      >
        <v-icon>mdi-close</v-icon>
      </v-btn>
      <base-title title="Search" />
      <base-divider align="left" />
      <base-text-field
        v-model="search"
        placeholder="Search"
        outlined
        hide-details
        class="pr-4 pb-5"
      >
        <template
          #append-outer
        >
          <v-btn
            color="primary"
            class="mt-n2 ml-n1"
          >
            <v-icon v-text="'mdi-magnify'" />
          </v-btn>
        </template>
      </base-text-field>
    </template>
    <!-- Categories -->
    <v-card flat>
      <base-title
        class="mt-4"
        title="Categories"
      />
      <base-divider align="left" />
      <v-list
        dense
        class="pt-0"
      >
        <v-list-item
          v-for="category in categories"
          :key="category.name"
        >
          <v-icon>mdi-chevron-right</v-icon>
          <span>{{ category.name }} ({{ category.count }})</span>
        </v-list-item>
      </v-list>
    </v-card>
    <!-- Popular Posts -->
    <v-card
      flat
      class="pr-3"
    >
      <base-title
        class="mt-4"
        title="Popular Posts"
      />
      <base-divider align="left" />
      <template v-for="(post, i) in appData.blogPosts">
        <blog-post
          :key="i"
          :post="post"
          clamp="2"
        />
      </template>
    </v-card>
    <!-- Photos -->
    <v-card
      flat
      class="pr-3"
    >
      <base-title
        class="mt-4"
        title="Instagram Photos"
      />
      <base-divider align="left" />
      <v-row
        justify="center"
        align="center"
        no-gutters
      >
        <template v-for="ig in appData.instagramPosts">
          <v-col
            :key="ig.id"
            cols="4"
            class="pb-5"
          >
            <v-img
              :src="ig.src"
              min-height="100"
              max-width="100"
              height="100"
              fill
            />
          </v-col>
        </template>
      </v-row>
    </v-card>
    <!-- Tweets -->
    <v-card
      flat
      class="pr-3"
    >
      <base-title
        class="mt-4"
        title="Latest Tweets"
      />
      <base-divider align="left" />
      <template v-for="tweet in appData.tweets">
        <blog-tweet
          :key="tweet.id"
          :tweet="tweet"
        />
      </template>
    </v-card>
    <!-- Tags -->
    <v-card
      flat
      class="pr-3"
    >
      <base-title
        class="mt-4"
        title="Tags"
      />
      <base-divider align="left" />
      <v-row
        no-gutters
      >
        <template v-for="tag in appData.tags">
          <base-tag
            :key="tag"
            :text="tag"
          />
        </template>
      </v-row>
    </v-card>
  </v-navigation-drawer>
</template>

<script>
  export default {

    name: 'BlogSidebar',

    components: {
      BlogPost: () => import('@/components/blog/Post'),
      BlogTweet: () => import('@/components/blog/Tweet'),
    },

    props: {
      value: { type: Boolean, default: false },
    },

    data () {
      return {
        navOpen: false,
        search: '',
        categories: [
          { name: 'Daytime', count: 9 },
          { name: 'Nighttime', count: 5 },
          { name: 'Campfire', count: 3 },
          { name: 'Mountain', count: 8 },
          { name: 'Miscellaneous', count: 5 },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
