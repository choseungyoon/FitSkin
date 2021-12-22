<template>
  <v-app>
    <app-bar
      block
      search
    />
    <base-view />
    <settings />
  </v-app>
</template>

<script>
  export default {
    name: 'BaseLayout',

    components: {
      AppBar: () => import('@/layouts/base/AppBar'),
      Settings: () => import('@/layouts/base/Settings'),
      BaseView: () => import('@/layouts/base/View'),
    },
  }
</script>
