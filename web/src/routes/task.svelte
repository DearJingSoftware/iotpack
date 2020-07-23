<script>
	import UITable from '../uikit/UITable.svelte';
	import UIPage from '../uikit/UIPage.svelte';
	import UIButton from '../uikit/UIButton.svelte';
</script>
<svelte:head>
	<title>网关管理</title>
</svelte:head>

<style>

.filter {
	display: flex;
}

.filter, .filter li {
	margin: 0px;
	padding: 0px;
	padding-right: 20px;
	list-style: none;
}
</style>


<UIPage>
	<span slot="header-left">
		<ul class="filter">
			<li>
				<i class="las la-filter"></i> 排序: A-Z 	<i class="las la-angle-down"></i>
			</li>
			<li>
				<i class="las la-exclamation-circle"></i> 状态: 全部 	<i class="las la-angle-down"></i>
			</li>
		</ul>
	</span>
	<span slot="header-right">
		<ul class="filter">
			<li>
				<UIButton>
					<i class="las la-cloud-download-alt"></i> 导出
				</UIButton>
			</li>
		</ul>
	</span>

	<UITable />

	<span slot="page-footer">
		page header
	</span>
</UIPage>
