<template>
  <v-container
    id="home"
    class="fill-height text-center mx-0 px-0 pt-0"
    style="max-width: none"
    tag="section"
  >
    <v-row justify="start">
      <template v-for="skill in skills">
        <v-col
          :key="skill.name"
          cols="6"
        >
          <base-skill-meter
            class="px-3"
            rounded
            :skill="skill.name"
            :value="skill.value"
          />
        </v-col>
      </template>
    </v-row>
    <!-- Feature Cards -->
    <v-row justify="center">
      <base-feature
        icon="mdi-auto-fix"
        title="Unlimited Colors"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="400px"
      />
      <base-feature
        icon="mdi-flash"
        title="Responsive Design"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="400px"
      />
      <base-feature
        icon="mdi-recycle"
        title="Awesome Sliders"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="400px"
        outlined
        outline-color="black"
      />
      <base-feature
        icon="mdi-water"
        title="Unlimited Colors"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="400px"
      />
    </v-row>
    <v-row justify="center">
      <base-testimony
        :src="require('@/assets/testimony/testimony-1.jpg')"
        :background-src="require('@/assets/background-light.png')"
        :customer="{ review: 'Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima.', name: 'Sample Name', title: 'New Customer' }"
      />
      <base-testimony
        :src="require('@/assets/testimony/testimony-3.jpg')"
        :customer="{ review: 'Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima.', name: 'Sample Name', title: 'New Customer' }"
      />
    </v-row>
    <v-row justify="center">
      <base-feature-alt
        title="Friendly Support"
        icon="mdi-auto-fix"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
      <base-feature-alt
        title="Responsive"
        outlined
        icon="mdi-sync mdi-rotate-270"
        avatar-color="primary"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
      <base-feature-alt
        title="Awesome Sliders"
        icon="mdi-cog"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
      <base-feature-alt
        title="Unlimited Colors"
        icon="mdi-water"
        outlined
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
    </v-row>
    <v-row
      justify="center"
      class="pa-3"
    >
      <v-col
        cols="12"
        sm="6"
        md="3"
      >
        <base-team-member
          title="CEO"
          name="Neil Barnett"
          :social-links="teamSocialLinks"
          :src="require('@/assets/team/rana-sawalha-IhuHLIxS_Tk-unsplash.jpg')"
        />
      </v-col>
      <v-col
        cols="12"
        sm="6"
        md="3"
      >
        <base-team-member
          title="COO"
          name="Sherri Cayne"
          :social-links="teamSocialLinks"
          :src="require('@/assets/team/christopher-campbell-rDEOVtE7vOs-unsplash.jpg')"
        />
      </v-col>
      <v-col
        cols="12"
        sm="6"
        md="3"
      >
        <base-team-member
          title="CTO"
          name="Erica Baker"
          :social-links="teamSocialLinks"
          :src="require('@/assets/team/dan-ROJFuWCsfmA-unsplash.jpg')"
        />
      </v-col>
      <v-col
        cols="12"
        sm="6"
        md="3"
      >
        <base-team-member
          title="CFO"
          name="Wesley Graves"
          :social-links="teamSocialLinks"
          :src="require('@/assets/team/brooke-cagle-wKOKidNT14w-unsplash.jpg')"
        />
      </v-col>
    </v-row>
    <v-row justify="center">
      <base-feature-alt
        outlined
        title="Friendly Support"
        icon="mdi-auto-fix"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="370px"
        :to="{ name: 'Home' }"
      />
      <base-feature-alt
        outlined
        title="Responsive"
        icon="mdi-sync mdi-rotate-270"
        avatar-color="black"
        max-width="370px"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
      <base-feature-alt
        title="Awesome Sliders"
        icon="mdi-cog"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="370px"
        :to="{ name: 'Home' }"
      />
    </v-row>
    <v-row justify="center">
      <base-pricing-plan
        class="mx-5 my-1"
        price="$59.99"
        frequency="month"
        title="Basic Plan"
        subtitle="Starting at"
        :features="planFeatures"
      >
        <v-btn
          color="primary"
          depressed
          large
          class="px-12 mx-auto"
          v-text="'Order Now'"
        />
      </base-pricing-plan>
      <base-pricing-plan
        class="mx-5 my-1"
        price="$99.99"
        frequency="month"
        title="Pro Plan"
        subtitle="Starting at"
        :features="planFeatures"
      >
        <v-btn
          color="primary"
          depressed
          large
          class="px-12 mx-auto"
          v-text="'Order Now'"
        />
      </base-pricing-plan>
      <base-pricing-plan
        class="mx-5 my-1"
        price="$999.99"
        frequency="month"
        title="Enterprise Plan"
        subtitle="Starting at"
        :features="planFeatures"
      >
        <v-btn
          color="primary"
          depressed
          large
          class="px-12 mx-auto"
          v-text="'Order Now'"
        />
      </base-pricing-plan>
    </v-row>
    <v-row justify="center">
      <base-feature-alt
        rounded
        title="Friendly Support"
        icon="mdi-auto-fix"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="400px"
        :to="{ name: 'Home' }"
      />
      <base-feature-alt
        rounded
        title="Responsive"
        icon="mdi-sync mdi-rotate-270"
        avatar-color="black"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="400px"
        :to="{ name: 'Home' }"
      />
      <base-feature-alt
        rounded
        title="Awesome Sliders"
        icon="mdi-cog"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        max-width="400px"
        :to="{ name: 'Home' }"
      />
    </v-row>
    <v-row
      justify="center"
      class="pt-12"
    >
      <base-feature-card
        class="mx-3 mt-12"
        icon="mdi-auto-fix"
        heading="Friendly Support"
        body="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
      <base-feature-card
        class="mx-3 mt-12"
        icon="mdi-recycle"
        heading="Fusion Builder"
        outlined
        outline-color="white"
        body="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
      <base-feature-card
        class="mx-3 mt-12"
        icon="mdi-water"
        heading="Unlimited Colors"
        body="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
        :to="{ name: 'Home' }"
      />
    </v-row>
    <v-row justify="center">
      <base-feature
        tile
        icon="mdi-auto-fix"
        title="Unlimited Colors"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
      />
      <base-feature
        tile
        icon="mdi-flash"
        title="Responsive Design"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
      />
      <base-feature
        tile
        icon="mdi-recycle"
        title="Awesome Sliders"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
      />
      <base-feature
        tile
        icon="mdi-water"
        title="Unlimited Colors"
        text="Lorem ipsum dolor sit amet, consequam, adipiscingconmentum tristiidem nemo minima."
      />
    </v-row>
    <v-row justify="center">
      <base-stat
        number="1458"
        text="Lines of Code"
        outlined
      />
      <base-stat
        number="768"
        text="Works"
      />
      <base-stat
        number="475"
        text="Cups of coffee"
        outlined
      />
      <base-stat
        number="83"
        text="Awards won"
      />
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'Sink',

    data: () => ({
      skills: [
        { name: 'Vue.js', value: 100 },
        { name: 'Python', value: 90 },
        { name: 'Javascript', value: 100 },
        { name: 'Node', value: 80 },
        { name: 'Swift', value: 50 },
      ],
      teamSocialLinks: [
        { link: 'https://linkedin.com', icon: 'mdi-linkedin' },
        { link: 'https://twitter.com', icon: 'mdi-twitter' },
        { link: 'mailto:sample@example.com', icon: 'mdi-email' },
      ],
      planFeatures: [
        'Wordpress',
        'HTML5 & CSS3',
        'PSD Files',
        'Unlimited Support',
      ],
    }),
  }
</script>
