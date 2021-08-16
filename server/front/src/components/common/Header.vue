<template>
	<header>
		<h1><router-link to="/" class="logo"><img alt="Vue logo" src="../../assets/fitskin_logo.png" width="200px"></router-link></h1>
		<b-nav align = "center">
			<b-nav-item to="/" exact>서비스소개</b-nav-item>
			<b-nav-item to="/product/search">나만의 제품</b-nav-item>
			<b-nav-item to="/FAQ">FAQ</b-nav-item>
		</b-nav>
	</header>
</template>

<script>

export default {
    
}
</script>

<style scoped>
header{
	width:100%; 
	text-align:center; 
	position:relative; 
	height:80px; 
	border-bottom:1px solid #35495e}
header h1{
	position:absolute; 
	top:0; 
	left:100px;
	}
a{
	text-decoration:none; 
	color:#333;
	padding-left: 35x;
    padding-right: 35px;
}
a:hover , a.router-link-active{
	font-weight: bold;
	text-decoration: underline;
	text-underline-position: under;
	color:mediumaquamarine;
}
</style>