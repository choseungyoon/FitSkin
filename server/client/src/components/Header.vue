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
      <b-nav-item to="/product/search">핏스킨인증제품</b-nav-item>
      <b-nav-item to="/FAQ">FAQ</b-nav-item>
    </b-nav>
  </v-app-bar>
</template>

<script>
export default {};
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
