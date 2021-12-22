<template>
  <base-section
    id="gallery-alt"
    space="0"
  >
    <v-row
      justify="center"
      align="center"
      no-gutters
    >
      <template v-for="(project, i) in shuffledProjects">
        <v-col
          :key="i"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <base-project
            class="my-2 mx-1"
            v-bind="project"
          />
        </v-col>
      </template>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionProjectGalleryAlt',
    computed: {
      shuffledProjects () {
        const projs = this.appData.projects.slice()
        const breakpoint = this.$vuetify.breakpoint.name

        projs.sort(() => Math.random() - 0.5)
        const sizeMap = {
          xs: 3,
          sm: 2,
          md: 3,
          lg: 4,
          xl: 4,
        }
        return projs.slice(0, sizeMap[breakpoint])
      },
    },
  }
</script>

<style lang="scss" scoped>

</style>
