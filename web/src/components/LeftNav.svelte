<script>
	export let segment;
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
		Evolution
	</a>
	<ul>
		<li class="nav-item" aria-current="{segment === undefined ? 'page' : undefined}" >
		
		<a href=".">	<i class="las la-tachometer-alt"></i>首页</a></li>
		<li class="nav-item" aria-current="{segment === 'project' ? 'page' : undefined}"><a  href="project">
		<i class="las la-tachometer-alt"></i>项目</a></li>
		<li class="nav-item" aria-current="{segment === 'organizational' ? 'page' : undefined}"><a  href="organizational">
		<i class="las la-user-friends"></i>组织</a></li>
		<li class="nav-item" aria-current="{segment === 'application' ? 'page' : undefined}"><a  href="application">
		<i class="lab la-uikit"></i>应用</a></li>
		<li class="nav-item" aria-current="{segment === 'task' ? 'page' : undefined}"><a  href="task">
		<i class="las la-tasks"></i>任务</a></li>
		<li class="nav-item" aria-current="{segment === 'calendar' ? 'page' : undefined}"><a  href="calendar">
		<i class="las la-calendar"></i>日历</a></li>
	</ul>
</nav>
