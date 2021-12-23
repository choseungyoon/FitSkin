<template>
  <v-app-bar
    app
    elevate-on-scroll
    style="right: 0"
    :color="color || 'white'"
    :height="$vuetify.breakpoint.mdAndUp ? '150px' : '60px'"
  >
    <router-link :to="{ name: 'Home' }">
      <v-img
        class="hidden-sm-and-down"
        :max-width="$vuetify.breakpoint.mdAndUp ? '260px' : '400px'"
        max-height="70px"
        min-height="90px"
        :src="require('@/assets/fitskin-img/fitskin_logo.png')"
      />
    </router-link>

    <v-spacer />
    <div v-if="$vuetify.breakpoint.mdAndUp">
      <v-tabs
        hide-slider
        optional
        background-color="transparent"
        v-bind="tabAttrs"
      >

        <v-tab
          v-for="item in items"
          :key="item.name"
          :to="{ name: item.link }"
          :exact="item.name === 'Home'"
          :ripple="false"
          active-class="primary--text"
          class="font-weight-medium text-none"
          min-width="120px"
          text
        >
          <span v-text="item.name" />
          <v-icon
            v-if="item.icon && $vuetify.breakpoint.mdAndUp"
            small
            right
            v-text="item.icon"
          />
        </v-tab>
      </v-tabs>
    </div>
    <div v-else>
      <v-btn
        icon
        @click="drawer = true"
      >
        <v-icon>mdi-menu</v-icon>
      </v-btn>
      <blog-sidebar
        v-if="$route.name === 'Blog'"
        :value="drawer"
        @input="drawer = $event"
      />
      <base-sidebar
        v-else
        :items="items"
        :value="drawer"
        @input="drawer = $event"
      />
    </div>
  </v-app-bar>
</template>

<script>
  export default {
    name: 'BaseAppBar',

    components: {
      BlogSidebar: () => import('@/layouts/base/BlogSidebar'),
      BaseSidebar: () => import('@/layouts/base/BaseSidebar'),
    },

    props: {
      block: Boolean,
      search: Boolean,
      color: String,
    },

    data () {
      return {
        drawer: false,
        items: [
          { name: 'Home', icon: 'mdi-home', link: 'Home' },
          { name: '피부 비타민 추천', icon: 'mdi-google-analytics', link: '피부 비타민 추천' },
          { name: '유전자검사', icon: 'mdi-dna', link: '유전자검사' },
          { name: 'Store', icon: 'mdi-store', link: 'Store' },
          { name: 'Contact', icon: 'mdi-phone', link: 'Contact' },
          { name: 'Login', icon: 'mdi-login-variant', link: 'Login' },
        ],
      }
    },

    computed: {
      tabAttrs () {
        const attrs = {}
        if (this.block) attrs.height = '150px'
        return attrs
      },
    },

    watch: {
      '$route.name' (val) {
        this.drawer = false
      },
    },
  }
</script>
