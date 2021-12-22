<template>
  <base-section
    id="our-services"
  >
    <div class="justify-center align-center">
      <base-heading
        class="font-weight-bold"
        title="Our Services"
        align="center"
      />
      <base-divider
        color="primary"
        align="center"
      />
    </div>
    <v-row
      justify="center"
      align="stretch"
      class="px-3"
    >
      <template v-for="(feature, i) in features">
        <v-col
          :key="i"
          cols="12"
          md="6"
          lg="3"
        >
          <base-feature-alt
            class="pa-1"
            v-bind="feature"
          />
        </v-col>
      </template>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionOurServices',
    data () {
      return {
        features: [
          {
            icon: 'mdi-flash',
            title: 'Fast Loads',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-cog',
            outlined: true,
            title: 'Customizable Sections',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-responsive',
            avatarColor: 'offblack',
            outlined: true,
            title: 'Responsive',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-face-agent',
            title: 'Friendly Support',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-auto-fix',
            title: 'Beautiful Designs',
            avatarColor: '#0077b5',
            outlined: true,
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-calendar',
            title: 'Flexible Schedule',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-magnify',
            title: 'Search Engine Optimization',
            avatarColor: '#0077b5',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
          {
            icon: 'mdi-thought-bubble',
            title: 'Versatile Content Support',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et ante a quam dignissim venenatis.',
          },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
