<template>
  <div class="main">
    <Header />
    <v-content>
      <router-view />
    </v-content>
    <Footer />
  </div>
</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";

export default {
  name: "App",

  data: () => ({
    //
  }),
  components: {
    Header,
    Footer,
  },
};
</script>

<style></style>
