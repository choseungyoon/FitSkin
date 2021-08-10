<template>
    <div class="main">
        <div class="container">
          <Header />
          <HelloWorld msg="Welcome to Your Vue.js App"/>
          <Footer />
        </div>
    </div>
</template>

<script>
import Header from './common/Header';
import HelloWorld from './HelloWorld.vue'; 
import Footer from './common/Footer';

export default {
    name: 'Main',
    components : {
        Header,
        HelloWorld,
        Footer
    }
}
</script>

<style scoped>
html,body{padding:0; margin:0;}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin:0; padding:0;
}
</style>
