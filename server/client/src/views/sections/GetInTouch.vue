<template>
  <base-section
    id="get-in-touch"
    class="grey lighten-3"
  >
    <v-row align="start">
      <v-col
        cols="3"
        sm="6"
        class="px-12"
      >
        <base-subheading
          class="font-weight-black primary--text"
          title="GET IN TOUCH"
          align="left"
        />
        <base-body
          text="주민중한테 연락 기기"
          align="left"
        />
        <base-subheading
          title="Contact Information"
          class="primary--text"
          align="left"
        />
        <base-subtitle
          title="Company"
          weight="bold"
        />
        <base-body
          space="2"
          text="주식회사 라이크팜"
        />
        <base-subtitle
          title="Email"
          weight="bold"
        />
        <base-body
          space="2"
          :text="appData.contact.email.value"
        />
        <base-subtitle
          title="Phone"
          weight="bold"
        />
        <base-body
          space="2"
          :text="appData.contact.phone.value"
        />
      </v-col>
      <v-col
        cols="9"
        sm="6"
      >
        <v-row no-gutters>
          <v-col
            cols="12"
            md="6"
          >
            <base-text-field
              v-model="name"
              label="Name"
              :class="$vuetify.breakpoint.mdAndUp ? 'mr-1' : ''"
            />
          </v-col>
          <v-col
            cols="12"
            md="6"
          >
            <base-text-field
              v-model="email"
              :class="$vuetify.breakpoint.mdAndUp ? 'ml-1' : ''"
              label="Email"
            />
          </v-col>
        </v-row>
        <v-row no-gutters>
          <v-col
            cols="12"
            md="6"
          >
            <base-text-field
              v-model="website"
              label="Website"
              :class="$vuetify.breakpoint.mdAndUp ? 'mr-1' : ''"
            />
          </v-col>
          <v-col
            cols="12"
            md="6"
          >
            <base-text-field
              v-model="subject"
              :class="$vuetify.breakpoint.mdAndUp ? 'ml-1' : ''"
              label="Subject"
            />
          </v-col>
        </v-row>
        <v-row no-gutters>
          <v-textarea
            v-model="message"
            label="Message"
            outlined
          />
        </v-row>
        <v-row no-gutters>
          <base-btn
            color="primary"
            class="px-12"
            depressed
          >
            <span
              class="font-weight-bold"
              v-text="'Submit Message'"
            />
          </base-btn>
        </v-row>
      </v-col>
    </v-row>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionGetInTouch',
    data () {
      return {
        name: '',
        email: '',
        website: '',
        subject: '',
        message: '',
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
