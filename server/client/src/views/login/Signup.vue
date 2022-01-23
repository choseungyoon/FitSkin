<template>
  <section class="section-container">
    <v-row class="signup">
      <v-col
        cols="8"
        class="float-left"
      >
        <h1>Welcome to FitSkin first!</h1>
      </v-col>
      <v-col
        cols="4"
        class="float-right"
      >
        <h2>REGISTER</h2>
        <form
          name="form"
          @submit.prevent="handleRegister"
          v-if="show"
        >
          <div v-if="!successful">
            <div class="form-group">
              <label for="username">Username</label>
              <input
                v-model="user.username"
                type="text"
                class="form-control"
                name="username"
              />
              <div
                v-if="submitted && errors.has('username')"
                class="alert-danger"
              >
                {{ errors.first("username") }}
              </div>
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <input
                v-model="user.email"
                type="email"
                class="form-control"
                name="email"
              />
              <div
                v-if="submitted && errors.has('email')"
                class="alert-danger"
              >
                {{ errors.first("email") }}
              </div>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input
                v-model="user.password"
                type="password"
                class="form-control"
                name="password"
              />
              <div
                v-if="submitted && errors.has('password')"
                class="alert-danger"
              >
                {{ errors.first("password") }}
              </div>
            </div>
            <div class="form-group">
              <v-btn
                class="signup-btn"
                type="submit"
                rounded
                color="white"
                dark
              >
                <span
                  v-show="loading"
                  class="spinner-border spinner-border-sm"
                ></span>
                Sign Up
              </v-btn>
            </div>

            <div
              v-if="message"
              class="alert"
              :class="successful ? 'alert-success' : 'alert-danger'"
            >
              {{ message }}
            </div>
          </div>
        </form>
      </v-col>
    <v-dialog
      v-model="dialog"
      max-width="290"
    >
      <v-card>
        <v-card-title class="text-h5">
          Use Google's location service?
        </v-card-title>

        <v-card-text>
          Let Google help apps determine location. This means sending anonymous location data to Google, even when no apps are running.
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>

          <v-btn
            color="green darken-1"
            text
            @click="dialog = false"
          >
            Disagree
          </v-btn>

          <v-btn
            color="green darken-1"
            text
            @click="dialog = false"
          >
            Agree
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    </v-row>
  </section>
</template>

<script>
  import User from '@/models/user'
  export default {
    name: 'Register',
    created () {
      this.create()
    },
    data () {
      return {
        user: new User('', '', ''),
        submitted: false,
        successful: false,
        message: '',
        codes: '',
        form: {
          password: '',
          email: '',
          uname: '',
        },
        show: true,
        dialog: false,
        loading: false,
      }
    },
    computed: {
      loggedIn () {
        return this.$store.state.auth.status.loggedIn
      },
    },
    mounted () {
      if (this.loggedIn) {
        this.$router.push('/')
      }
    },
    methods: {
      create () {
        this.codes = this.$route.query.code
        console.log(this.codes)
        if (this.codes != null) {
          this.getToken()
        }
      },
      getToken () {
        console.log('Start get Token')
        this.$store.dispatch('auth/loginByKakao', this.codes).then(
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
      handleRegister () {
        this.message = ''
        this.submitted = true
        this.$store.dispatch('auth/register', this.user).then(
          (data) => {
            this.message = data.message
            alert(this.message)
            this.successful = true
            this.$router.push('/login')
          },
          (error) => {
            this.message =
              (error.response && error.response.data) ||
              error.message ||
              error.toString()
            console.log(this.message)
            this.successful = false
            alert(this.message.message)
          },
        )
      },
    },
  }
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
}

.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}

.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>
