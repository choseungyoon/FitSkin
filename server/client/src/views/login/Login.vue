<template>
  <base-section
    class="section-container"
  >
    <v-row
      class="signin"
    >
      <v-col
        cols="12"
        md="6"
        class="float-left"
      >
        <h1>Welcome to Fitskin</h1>
      </v-col>
      <v-col
        cols="12"
        md="6"
        class="float-right"
      >
        <h2>LOGIN</h2>
        <validation-observer ref="observer">
          <v-form @submit.prevent="submit">
            <validation-provider
              v-slot="{ errors }"
              name="Email"
              rules="required|email"
            >
              <v-text-field
                v-model="user.email"
                :error-messages="errors"
                label="Email"
                required
                outlined
                dark
                filled
                dense
              />
            </validation-provider>
            <validation-provider
              v-slot="{ errors }"
              name="Password"
              rules="required"
            >
              <v-text-field
                v-model="user.password"
                :error-messages="errors"
                label="Password"
                :append-icon="showPass ? 'mdi-eye' : 'mdi-eye-off'"
                required
                outlined
                dense
                dark
                filled
                :type="showPass ? 'text' : 'password'"
                @click:append="showPass = !showPass"
              />
            </validation-provider>
            <div class="text-center">
              <v-btn
                class="signin-btn"
                type="submit"
                rounded
                color="white"
                dark
              >
                Sign In
              </v-btn>
              <div><br></div>
              <a
                id="custom-login-btn"
                v-on:click="loginWithKakao()"
              >
                <img
                  src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
                  width="240"
                />
              </a>
            </div>
            <dir><br></dir>
            <div class="text-center">
              Don't have an account? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="">Sign up</a>
            </div>
          </v-form>
        </validation-observer>
      </v-col>
    </v-row>
  </base-section>
</template>
<script>
  import { required, email } from 'vee-validate/dist/rules'
  import { extend, ValidationProvider, setInteractionMode, ValidationObserver } from 'vee-validate'
  import User from '@/models/user'

  setInteractionMode('eager')

  extend('required', {
    ...required,
    message: '{_field_} can not be empty',
  })

  extend('email', {
    ...email,
    message: 'Email must be valid',
  })
  export default {
    components: {
      ValidationProvider,
      ValidationObserver,
    },
    data: () => ({
      user: new User('', '', ''),
      showPass: false,
      loading: false,
    }),
    computed: {
      params () {
        return {
          user: this.user,
        }
      },
    },
    methods: {
      async submit () {
        const valid = await this.$refs.observer.validate()
        if (valid) {
          this.login(this.params) // action to login
        }
      },
      clear () {
        // you can use this method to clear login form
        this.user.email = ''
        this.user.password = null
        this.$refs.observer.reset()
      },
      loginWithKakao () {
        const params = {
          redirectUri: 'http://34.64.253.121:9000/kakaologin',
        }
        window.Kakao.Auth.authorize(params)
      },
      login (data) {
        this.loading = true
        this.$store.dispatch('auth/login', data.user).then(
          () => {
            this.$router.push('/')
          },
          (error) => {
            this.loading = false
            this.message =
              (error.response && error.response.data) ||
              error.message ||
              error.toString()
          },
        )
      },
    },
  }
</script>
