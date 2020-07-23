<script>
	import Search from './top_nav/search.svelte';
	export let segment;
</script>



<nav>

	<ul class="left">
		<li>
			<a href="javascriopt:;"><i class="las la-bars"></i></a>
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
		<li><a href="/chat"><i class="las la-comments"></i></a></li>
		<li><a href="/message/inbox"><i class="las la-bell"></i></a></li>
		<li class="avatar">
			<a href="#" alt="avatar">
			<img width="36px" height="36px" src="https://api-lunacy.icons8.com/api/assets/f7f8d13a-d1aa-420a-b8d6-ff44c1b937f2/img.png" alt="avatar"/></a>
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

	a {
		text-decoration: none;
		padding: 1em 0.5em;
		display: block;
		text-align: right;
	}
</style>
