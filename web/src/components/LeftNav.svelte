<script>
	export let segment;
	import { menu } from "../config/menu.js";
	import { theme } from "../config/theme.js";

	var menus=[];
	const unsubscribe = menu.subscribe(value => {
			menus=value
	}); 

	var themeConfig={};
	const menuUnsubscribe= theme.subscribe(value=>{
		themeConfig=value;
		console.log("");
	})
	
</script>

<style>
	nav {
		font-weight: 300;
		width: 240px;
		background-color: #FFFFFF;
		border-right: 2px #E8ECEF solid;
	}
	nav.menu_fold {
		width: 64px;
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
		padding: 20px 0px 20px 20px;
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
		color:black;
		text-align: center;
		text-decoration: none;
		display: flex;
		justify-content: center;
		justify-items: center;
		align-items: center;
	}
	a.main_logo img {
		margin-right: 5px;
	}
	.min_logo {
		background-color: #ffffff;
		width: 64px;
		height: 60px;
		font-size: 12px;
		font-weight: 600;
		color:#4D7CFE;
		text-align: center;
		text-decoration: none;
		display: flex;
		justify-content: center;
		justify-items: center;
		align-items: center;
}
	.fa {
		font-size: 22px;
		width: 22px;
	}
</style>

<nav class="{themeConfig.leftNavTaggle?"menu_unfold":"menu_fold"}">
	{#if themeConfig.leftNavTaggle}
	<a  href="/" class="main_logo">
		<img src="/logo.png" width="24px" height="24px"/>
		IotPack
	</a>
	{/if}
	{#if !themeConfig.leftNavTaggle}
	<a  href="/" class="min_logo">
		<img src="/logo.png" width="36px" height="36px"/>
	</a>
	{/if}
	
	<ul>
	{#each menus as item}
		<li class="nav-item" aria-current="{item.segment === segment ? 'page' : undefined}" >
		<a href="{item.segment}" alt="{item.name}">	<i class="{item.segment === segment?item.active_icon:item.icon}"> </i>
			{#if themeConfig.leftNavTaggle}	
				{item.name}
			{/if}
		</a>
		</li>
	{/each}
	
	</ul>
</nav>
