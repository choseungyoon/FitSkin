<template>
  <v-navigation-drawer
    :value="value"
    app
    hide-overlay
    absolute
    right
    @input="$emit('input', $event)"
  >
    <v-list
      nav
      dense
    >
      <v-list-item-group
        active-class="primary--text text--accent-4"
      >
        <v-list-item
          v-for="item in items"
          :key="item.name"
          :to="{ name: item.name }"
          :exact="item.name === 'Home'"
          :ripple="false"
        >
          <v-list-item-icon><v-icon v-text="item.icon" /></v-list-item-icon>
          <v-list-item-title v-text="item.name" />
        </v-list-item>
      </v-list-item-group>
    </v-list>
    <template #append>
      <v-btn
        text
        :ripple="false"
        :href="`tel:${appData.contact.phone.value}`"
      >
        <v-icon
          class="mr-2"
          v-text="appData.contact.phone.icon"
        />
        <span
          v-text="appData.contact.phone.value"
        />
      </v-btn>

      <v-btn
        text
        tile
        height="60px"
        :ripple="false"
        :href="`mailto:${appData.contact.email.value}`"
      >
        <v-icon
          class="mr-2"
          v-text="appData.contact.email.icon"
        />
        <span
          v-text="appData.contact.email.value"
        />
      </v-btn>
    </template>
  </v-navigation-drawer>
</template>

<script>
  export default {
    name: 'BaseSidebar',

    props: {
      value: { type: Boolean, default: false },
      items: { type: Array, default: () => ([]) },
    },
  }
</script>

<style lang="scss" scoped>

</style>
