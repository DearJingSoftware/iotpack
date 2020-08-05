<script>
	export let segment;
	import Search from './top_nav/search.svelte';
	import { theme } from "../config/theme.js";
	import  auth  from "../config/auth.js";
	import Message from "./top_nav/message.svelte";
	import Menu from "./top_nav/menu.svelte";

	import UIDropdown from '../uikit/UIDropdown.svelte';
	function handleTaggleLeftNav(event) {
			console.log("切换显示模式")
			theme.leftNavTaggle()
	}
	var	userInfo={
		user:{
			username:""
		}
	}
	auth.subscribe(u=>{
			userInfo=u;
	})

</script>



<nav>
	<ul class="left">
			<li>
				项目
			</li>
	</ul>
	<ul class="right">
		<li>
			设置
		</li>
	</ul>
</nav>


<style>



	nav {
		height: 60px;
		font-weight: 300;
		display: flex;
		background-color: #ffffff;
		border-bottom:2px #E8ECEF solid;
	}

	nav .left {
		flex-grow: 1;
	}

	nav .right {
		margin-right: 10px;
	}

		nav .right li {
			padding:0px 10px;
	}



	ul {
		margin: 0;
		padding: 0;
	}

	/* clearfix */
	ul::after {
		content: '';
		display: block;
		clear: both;
	}

	li {
		display: block;
		float: left;
	}
</style>
