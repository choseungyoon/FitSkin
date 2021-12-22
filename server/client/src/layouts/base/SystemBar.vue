<template>
  <v-system-bar
    app
    dark
    color="primary"
    height="60px"
    style="z-index: 5;"
  >
    <v-btn
      class="mx-2"
      text
      tile
      height="60px"
      :ripple="false"
      :href="`tel:${appData.contact.phone.value}`"
    >
      <v-icon
        :left="$vuetify.breakpoint.mdAndUp"
        class="mr-2"
        v-text="appData.contact.phone.icon"
      />
      <span
        class="hidden-sm-and-down"
        v-text="appData.contact.phone.value"
      />
    </v-btn>

    <v-btn
      class="mx-2"
      text
      tile
      height="60px"
      :ripple="false"
      :href="`mailto:${appData.contact.email.value}`"
    >
      <v-icon
        :left="$vuetify.breakpoint.mdAndUp"
        class="mr-2"
        v-text="appData.contact.email.icon"
      />
      <span
        class="hidden-sm-and-down"
        v-text="appData.contact.email.value"
      />
    </v-btn>
    <v-spacer v-if="$vuetify.breakpoint.mdAndUp" />
    <template v-if="$vuetify.breakpoint.mdAndUp">
      <v-btn
        v-for="site in appData.socialLinks"
        :key="site.name"
        :href="site.link"
        target="_blank"
        class="mx-2"
        icon
      >
        <v-icon
          class="mx-0"
          v-text="site.icon"
        />
      </v-btn>
    </template>
  </v-system-bar>
</template>

<script>
  export default {
    name: 'BaseSystemBar',
  }
</script>
