<template>
  <v-app-bar
    app
    elevate-on-scroll
    style="right: 0"
    :color="color || 'white'"
    :height="$vuetify.breakpoint.mdAndUp ? '150px' : '60px'"
  >
    <v-img
      class="hidden-sm-and-down"
      :max-width="$vuetify.breakpoint.mdAndUp ? '120px' : '100px'"
      max-height="120px"
      min-height="120px"
      :src="require('@/assets/fitskin-img/logo.png')"
    />
    <v-toolbar-title class="headline">
      <router-link
        :to="{ name: 'Home' }"
        tag="h4"
        style="cursor: pointer"
        v-text="appData.title"
      />
    </v-toolbar-title>
    <v-spacer></v-spacer>
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
      <div
        v-if="!currentUser"
        class="navbar-nav ml-auto"
        >
        <v-tabs
          hide-slider
          optional
          background-color="transparent"
          v-bind="tabAttrs"
        >
         <v-tab
              to = "Login"
              active-class="primary--text"
              class="font-weight-medium text-none"
              min-width="120px"
              text
            >
                Login
              <v-icon
                small
                right
              >mdi-login-variant</v-icon>
        </v-tab>
        </v-tabs>
      </div>
      <div
        v-if="currentUser"
        class="navbar-nav ml-auto"
      >
        <v-tabs
          hide-slider
          optional
          background-color="transparent"
          v-bind="tabAttrs"
        >
          <v-tab
              to = "Profile"
              active-class="primary--text"
              class="font-weight-medium text-none"
              min-width="120px"
              text
            >
                {{ currentUser.username }}
              <v-icon
                small
                right
              >mdi-account-settings
              </v-icon>
          </v-tab>
          <v-tab
              active-class="primary--text"
              class="font-weight-medium text-none"
              min-width="120px"
              text
              @click.prevent="logOut"
            >
              LogOut
              <v-icon
                small
                right
              >
                mdi-logout
              </v-icon>
          </v-tab>
        </v-tabs>
      </div>
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
        ],
      }
    },

    computed: {
      tabAttrs () {
        const attrs = {}
        if (this.block) attrs.height = '150px'
        return attrs
      },
      currentUser () {
        return this.$store.state.auth.user
      },
    },
    watch: {
      '$route.name' (val) {
        this.drawer = false
      },
    },
    methods: {
      logOut () {
        this.$store.dispatch('auth/logout')
        this.$router.push('/login')
      },
    },
  }
</script>
