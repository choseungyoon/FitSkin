<template>
	<header>
		<h1><a href="#" class="logo"><img alt="Vue logo" src="../../assets/fitskin_logo.png" width="200px"></a></h1>
		<div class="menuWrap">
			<ul class="menu">
				<li><a href="javascript:;">서비스 소개</a></li>
				<li><a href="javascript:;">제품검색</a></li>
				<li><a href="javascript:;">FAQ</a></li>
			</ul>
		</div>
	</header>
</template>

<script>
export default {
    
}
</script>

<style scoped>
header{width:100%; text-align:center; position:relative; height:120px; border-bottom:1px solid #35495e}
header h1{position:absolute; top:0; left:100px;}
header ul.menu:after{display:block; clear:both; content:'';}
header ul.menu{position:absolute; top:20px; right:50px;}
header ul.menu li{float:left; padding:10px 20px; list-style:none;}

a{text-decoration:none; color:#333;}
</style>