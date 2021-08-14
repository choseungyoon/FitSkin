<template>
	<header>
		<h1><a href="#" class="logo"><img alt="Vue logo" src="../../assets/fitskin_logo.png" width="200px"></a></h1>
		<b-nav align = "center">
			<b-nav-item active to="/">서비스 소개</b-nav-item>
			<b-nav-item to="/product/search">제품검색</b-nav-item>
			<b-nav-item to="/FAQ">FAQ</b-nav-item>
		</b-nav>
	</header>
</template>

<script>
export default {
    
}
</script>

<style scoped>
header{width:100%; text-align:center; position:relative; height:80px; border-bottom:1px solid #35495e}
header h1{position:absolute; top:0; left:100px;}
header ul.menu:after{display:block; clear:both; content:'';}
header ul.menu{position:absolute; top:20px; right:50px;}
header ul.menu li{float:left; padding:10px 20px; list-style:none;}
a{text-decoration:none; color:#333;}
</style>