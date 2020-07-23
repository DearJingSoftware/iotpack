<script>
	export let segment;
	import { menu } from "../config/menu.js";
	var menus=[];
	const unsubscribe = menu.subscribe(value => {
			menus=value
	});
</script>

<style>
	nav {
		font-weight: 300;
		width: 240px;
		background-color: #FFFFFF;
		border-right: 2px #E8ECEF solid;
	}

	nav  i {
		
		font-size: 22px;
		padding-right: 10px;
	}

	ul {
		margin: 0;
		padding: 0;
		display:flex;
		flex-direction: column;
	
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
		background-color: #FFFFFF;
		border-left: white 2px solid;
	}
	li:hover ,[aria-current]{
		display: block;
		float: left;
		color:#4D7CFE;
		background-color: #F8FAFB;
		border-left: #4D7CFE 2px solid;
	}

	[aria-current] {
		position: relative;
		display: block;
	
	}

	li:hover a,[aria-current] a,[aria-current] i{
			color:#4D7CFE;
	}

	.nav-item a {
		text-decoration: none;
		padding: 20px 0px 20px 28px;
		font-size: 18px;
		display: block;
		text-align: left;
		color: #778CA2;
	}

	a.main_logo {
		background-color: #ffffff;
		width: 240px;
		line-height: 60px;
		font-size: 20px;
		font-weight: 600;
		color:#4D7CFE;
		text-align: center;
		text-decoration: none;
		display: block;
	}
</style>

<nav>
	<a  href="/" class="main_logo">
		IotPack
	</a>
	<ul>
	{#each menus as item}
		<li class="nav-item" aria-current="{item.segment === segment ? 'page' : undefined}" >
		<a href="{item.segment}">	<i class="{item.icon}"> </i>{item.name}</a></li>
	{/each}
	
	</ul>
</nav>
