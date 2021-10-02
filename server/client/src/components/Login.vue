<template>
  <section class="section-container">
    <v-row class="signin">
      <v-col cols="8" class="left">
        <h1>Welcome to FitSkin</h1>
      </v-col>
      <v-col cols="4" class="right">
        <h2>LOGIN</h2>
        <form name="form" @submit.prevent="handleLogin">
          <div class="form-group">
            <label for="username">Username</label>
            <input
              v-model="user.username"
              v-validate="'required'"
              type="text"
              class="form-control"
              name="username"
            />
            <div
              v-if="errors.has('username')"
              class="alert alert-danger"
              role="alert"
            >
              Username is required!
            </div>
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input
              v-model="user.password"
              v-validate="'required'"
              type="password"
              class="form-control"
              name="password"
            />
            <div
              v-if="errors.has('password')"
              class="alert alert-danger"
              role="alert"
            >
              Password is required!
            </div>
          </div>
          <div class="form-group">
            <v-btn class="signin-btn" type="submit" rounded color="white" dark>
              <span
                v-show="loading"
                class="spinner-border spinner-border-sm"
              ></span>
              Login
            </v-btn>
          </div>
          <div class="form-group">
            <div v-if="message" class="alert alert-danger" role="alert">
              {{ message }}
            </div>
          </div>
        </form>
      </v-col>
    </v-row>
  </section>
</template>

<script>
import User from "../models/user";
import "../assets/css/styles.scss";
export default {
  name: "Login",
  components: {},
  data() {
    return {
      user: new User("", ""),
      loading: false,
      message: "",
    };
  },
  computed: {
    params() {
      return {
        member: {
          email: this.email,
          password: this.password,
        },
      };
    },
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then((isValid) => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.user.username && this.user.password) {
          this.$store.dispatch("auth/login", this.user).then(
            () => {
              this.$router.push("/profile");
            },
            (error) => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    },
  },
};
</script>
