<script>
	import UITable from '../uikit/UITable.svelte';
	import UIPage from '../uikit/UIPage.svelte';
	import UIButton from '../uikit/UIButton.svelte';
	import UISearchInput from '../uikit/UISearchInput.svelte';
</script>
<svelte:head>
	<title>设备管理</title>
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

			<li>
				<i class="las la-calendar-day"></i> 日期: 全部 	<i class="las la-angle-down"></i>
			</li>

			<li>
					<UISearchInput></UISearchInput>
			</li>
		</ul>
	</span>
	<span slot="header-right">
		<ul class="filter">
			<li>
				<UIButton>
					<i class="las la-list-ol"></i> 列表
				</UIButton>
			</li>
			<li>
				<UIButton>
					<i class="las la-list"></i> 网格
				</UIButton>
			</li>
		
			<li>
				<UIButton>
					<i class="las la-cloud-upload-alt"></i> 导入
				</UIButton>
			</li>
			<li>
				<UIButton>
					<i class="las la-cloud-download-alt"></i> 导出
				</UIButton>
			</li>
			<li>
				<UIButton status="primary">
					<i class="las la-plus-circle"></i>创建设备
				</UIButton>
			</li>
		</ul>
	</span>

	<UITable />


	<span slot="page-footer">
		page header
	</span>
</UIPage>
