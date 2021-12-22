<template>
  <base-section
    id="our-team"
  >
    <div class="justify-center align-center">
      <base-heading
        class="font-weight-bold"
        title="Our Team"
        align="center"
      />
      <base-divider
        color="primary"
        align="center"
      />
      <base-body
        text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam aliquet mauris non venenatis auctor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per."
        align="center"
      />
    </div>
    <v-row
      justify="center"
      align="center"
      class="px-10"
    >
      <template v-for="(employee, i) in teamMembers">
        <v-col
          :key="i"
          cols="12"
          sm="6"
          md="3"
        >
          <base-team-member
            class="pa-3"
            v-bind="employee"
          />
        </v-col>
      </template>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionOurTeam',
    data () {
      return {
        teamMembers: [
          {
            title: 'CEO',
            name: 'Neil Barnett',
            socialLinks: [
              { link: 'https://linkedin.com', icon: 'mdi-linkedin' },
              { link: 'https://twitter.com', icon: 'mdi-twitter' },
              { link: 'mailto:sample@example.com', icon: 'mdi-email' },
            ],
            src: require('@/assets/team/rana-sawalha-IhuHLIxS_Tk-unsplash.jpg'),
          },
          {
            title: 'COO',
            name: 'Sherri Cayne',
            socialLinks: [
              { link: 'https://linkedin.com', icon: 'mdi-linkedin' },
              { link: 'https://twitter.com', icon: 'mdi-twitter' },
              { link: 'mailto:sample@example.com', icon: 'mdi-email' },
            ],
            src: require('@/assets/team/christopher-campbell-rDEOVtE7vOs-unsplash.jpg'),
          },
          {
            title: 'CTO',
            name: 'Erica Baker',
            socialLinks: [
              { link: 'https://linkedin.com', icon: 'mdi-linkedin' },
              { link: 'https://twitter.com', icon: 'mdi-twitter' },
              { link: 'mailto:sample@example.com', icon: 'mdi-email' },
            ],
            src: require('@/assets/team/dan-ROJFuWCsfmA-unsplash.jpg'),
          },
          {
            title: 'CFO',
            name: 'Wesley Graves',
            socialLinks: [
              { link: 'https://linkedin.com', icon: 'mdi-linkedin' },
              { link: 'https://twitter.com', icon: 'mdi-twitter' },
              { link: 'mailto:sample@example.com', icon: 'mdi-email' },
            ],
            src: require('@/assets/team/brooke-cagle-wKOKidNT14w-unsplash.jpg'),
          },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
