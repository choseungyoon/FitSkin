<template>
  <div id="app">
      <div id="header">
          <Header />
      </div>
      <div class="container">
        <router-view></router-view>
      </div>
      <div id="footer">
        <Footer />
      </div>
  </div>
</template>

<script>
import Header from './components/common/Header';
import Footer from './components/common/Footer';

export default {
  name: 'App',
      components : {
        Header,
        Footer
    }
}
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
