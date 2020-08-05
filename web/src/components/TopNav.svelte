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
			<a href="javascript:void(0);"  on:click={handleTaggleLeftNav} ><i class="las la-bars"></i></a>
		</li>
		<li>
			<a href="javascriopt:;"  class="pageTitle">
				{segment === undefined ? '' : ""}	
				{segment === "project" ? '项目' : ""}
				{segment === "organizational" ? '组织' : ""}
				{segment === "application" ? '应用' : ""}
				{segment === "task" ? '任务' : ""}
				{segment === "search" ? '搜索' : ""}
				{segment === "setting" ? '设置' : ""}
				{segment === "calendar" ? '日历' : ""}
				{segment === "message" ? '消息' : ""}
				{segment === "user" ? '用户' : ""}
			</a>
		</li>
	</ul>

	<ul class="right">
		<li>
			<Search></Search>
		</li>
		<li><Message icon="la-comments" num=20 href="/chat" color="red"></Message></li>
		<li><Message icon="la-bell" num=20 href="/message/inbox" color="green"></Message></li>
		<li class="avatar">
			<a href="user/profile" class="cur_user_name">{userInfo.user.username}</a>
				<UIDropdown>
					<a href="user/profile" alt="avatar">
						<img width="36px" height="36px" src="https://api-lunacy.icons8.com/api/assets/f7f8d13a-d1aa-420a-b8d6-ff44c1b937f2/img.png" alt="avatar"/>
					</a>
					<span slot="menu">
						<Menu></Menu>
					</span>
				</UIDropdown>
		</li>
	</ul>
</nav>


<style>


	.avatar {
    height: 60px;
    display: flex;
    justify-items: center;
    align-items: center;
		text-decoration: none;
    text-align: right;
	}

	nav i {
		font-size: 24px;
  	color:#778CA2;
	}
	nav {
		height: 60px;
		font-weight: 300;
		display: flex;
		background-color: #ffffff;
		border-bottom:2px #E8ECEF solid;
	}
	.pageTitle {
		font-weight: 600;
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

	a, .item {
		text-decoration: none;
		padding: 1em 0.5em;
		display: block;
		text-align: right;
	}
	.cur_user_name {
			padding: 1em 0;
	}
</style>
