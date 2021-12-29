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
                v-validate="'required|min:3|max:20'"
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
                v-validate="'required|email|max:50'"
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
                v-validate="'required|min:6|max:40'"
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
    </v-row>
  </section>
</template>

<script>
  import axios from 'axios'
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
      }
    },
    computed: {
      loggedIn () {
        return this.$store.state.auth.status.loggedIn
      },
    },
    mounted () {
      if (this.loggedIn) {
        this.$router.push('/profile')
      }
    },
    methods: {
      create () {
        this.codes = this.$route.query.code
        this.getToken()
      },
      getToken () {
        axios
          .get('http://34.64.253.121:9000/api/auth/klogin?authorize_code=' + this.codes)
          .then((res) => {
            console.log(res.data)
            this.form.email = res.data.email
            this.form.password = res.data.id
            if (this.form.password === undefined) {
              // alert('올바르지 못한 접근입니다')
              // this.$router.push('/')
            } else {
              alert('Email : ' + this.form.email)
              this.login()
            }
          })
      },
      handleRegister () {
        alert('ddd')
        this.message = ''
        this.submitted = true
        this.$validator.validate().then((isValid) => {
          if (isValid) {
            this.$store.dispatch('auth/register', this.user).then(
              (data) => {
                this.message = data.message
                this.successful = true
                this.$router.push('/login')
              },
              (error) => {
                this.message =
                  (error.response && error.response.data) ||
                  error.message ||
                  error.toString()
                this.successful = false
              },
            )
          }
        })
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
