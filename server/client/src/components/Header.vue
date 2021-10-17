<template>
  <v-app-bar app color="white" height="100" class="navbar navbar-expand ">
    <v-avatar class="mr-3" color="white" size="100">
      <v-img contain max-height="70%" src="../assets/img/icon.png"></v-img>
    </v-avatar>
    <v-toolbar-title class="font-weight-black headline">
      FITSKIN
    </v-toolbar-title>

    <b-nav align="center">
      <b-nav-item to="/" exact>서비스소개</b-nav-item>
      <b-nav-item to="/product/my">나만의 제품</b-nav-item>
      <b-nav-item to="/product">핏스킨인증제품</b-nav-item>
      <b-nav-item to="/FAQ">FAQ</b-nav-item>
    </b-nav>

    <div v-if="!currentUser" class="navbar-nav ml-auto">
      <li class="nav-item">
        <router-link to="/register" class="nav-link">
          <font-awesome-icon icon="user-plus" />Sign Up
        </router-link>
      </li>
      <li class="nav-item">
        <router-link to="/login" class="nav-link">
          <font-awesome-icon icon="sign-in-alt" />Login
        </router-link>
      </li>
    </div>

    <div v-if="currentUser" class="navbar-nav ml-auto">
      <li class="nav-item">
        <router-link to="/profile" class="nav-link">
          <font-awesome-icon icon="user" />
          {{ currentUser.username }}
        </router-link>
      </li>
      <li class="nav-item">
        <a class="nav-link" href @click.prevent="logOut">
          <font-awesome-icon icon="sign-out-alt" />LogOut
        </a>
      </li>
    </div>
  </v-app-bar>
</template>

<script>
export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  methods: {
    logOut() {
      this.$store.dispatch("auth/logout");
      this.$router.push("/login");
    },
  },
};
</script>

<style scoped>
header {
  display: flex;
  justify-content: space-evenly;
}
a {
  color: black;
}
a:hover,
a.router-link-active {
  font-weight: bold;
  text-decoration: underline;
  text-underline-position: under;
  color: mediumaquamarine;
}
</style>
