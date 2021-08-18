<template>
  <div class="main">

    <strong>
      나만을 위한<br>
      합리적인<br>
      이너 뷰티<br><br>
    </strong>
    
    <p>찾아볼까요?</p>

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '핏스킨'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.main {
  display: grid;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-top: 10%;
}
strong {
  font-weight:bold;
  color: mediumaquamarine;
  font:caption;
  font-size: 50px;
}
p {
  font-weight:bold;
  color: mediumaquamarine;
  font-size: 20px;
}
</style>
