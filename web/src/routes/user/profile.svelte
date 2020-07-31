<script>
	import Avatar from "../../uikit/Avatar.svelte";
</script>

<svelte:head>
	<title>用户信息</title>
</svelte:head>

<div class="user_page">
	<div class="cover">
		<div class="back_btn">
			返回
		</div>
		<div class="change_cover_btn">
			修改背景图
		</div>
	</div>
	<div class="profile">
			<Avatar size="96" src="https://api-lunacy.icons8.com/api/assets/f7f8d13a-d1aa-420a-b8d6-ff44c1b937f2/img.png"></Avatar>
			<div class="name">
					IoTPack
			</div>
			<div class="postion">
					software engineer
			</div>
			<div class="name">
					software engineer
			</div>
	</div>
	<div class="body">
	
	</div>
</div>

<style>
.user_page {
	padding:25px;
}
.cover {
	height: 30vh;
	position: relative;
}

.back_btn {
	position: absolute;
	left: 0px;
}

.change_cover_btn {
	position: absolute;
	right: 0px;
}
	
</style>