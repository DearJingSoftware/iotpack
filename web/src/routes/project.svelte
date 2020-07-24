<script>
	import UITable from '../uikit/UITable.svelte';
	import UIPage from '../uikit/UIPage.svelte';
	import UIButton from '../uikit/UIButton.svelte';
	import UIModal from '../uikit/UIModal.svelte';
	import UISilder from '../uikit/UISilder.svelte';
	import UIForm from '../uikit/form/UIForm.svelte';
	import UIFormGroup from '../uikit/form/UIFormGroup.svelte';
	import UITextInput from '../uikit/form/UITextInput.svelte';
	import UIUpload from '../uikit/form/UIUpload.svelte';
	import UIButton1 from '../uikit/form/UIButton.svelte';
	import UIPagination from "../uikit/UIPagination.svelte";
	import LayoutAlignBoth from '../uikit/layout/LayoutAlignBoth.svelte';


	var showCreateProject="hide";

	function createProject(event) {
			showCreateProject="show"
	}
	var	list = [
		{
			id:1,name:"name1",
		},
		{
			id:2,name:"name2"
		},
		{
			id:3,name:"name3"
		},
			{
			id:4,name:"name4"
		},
			{
			id:5,name:"name5"
		},
			{
			id:6,name:"name5"
		},
			{
			id:7,name:"name5"
		},
			{
			id:8,name:"name5"
		},
			{
			id:9,name:"name5"
		},
			{
			id:10,name:"name5"
		}
		
	]

	var	field = [
		{
			id:1,name:"id",width:"20px",sort:true,
		},
		{
			id:2,name:"name",width:"200px",sort:true
		},
		{
			id:3,name:"role",width:"200px",sort:true
		},
		{
			id:4,name:"salary",width:"200px",sort:true
		},
		{
			id:5,name:"type",width:"200px",sort:true
		},
		{
			id:6,name:"action",width:"200px"
		}
	]
</script>
<svelte:head>
	<title>项目管理</title>
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

<UISilder bind:show={showCreateProject} title="新增项目">
	<div style="height:300px">
		<UIForm>
			<UIFormGroup title="项目Logo:" info="项目Logo">
					<UIUpload  placeholder="项目成员"></UIUpload>
			</UIFormGroup>
			<UIFormGroup title="项目名称:" info="项目名称">
					<UITextInput  placeholder="项目成员"></UITextInput>
			</UIFormGroup>
			<UIFormGroup title="项目成员:" info="项目成员" >
					<UITextInput placeholder="项目成员" disabled></UITextInput>
			</UIFormGroup>
		</UIForm>
	</div>
	<span slot="footer">
		<LayoutAlignBoth>
				<UIButton1>创建</UIButton1>
				<UIButton1>取消</UIButton1>
		</LayoutAlignBoth>
	</span>
</UISilder>
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
					<i class="las la-list-ol"></i>列表
				</UIButton>
			</li>
			<li>
				<UIButton>
					<i class="las la-list"></i> 网格
				</UIButton>
			</li>
			<li>
				<UIButton status="primary" on:click={createProject}>
					<i class="las la-plus-circle" ></i>创建新项目
				</UIButton>
			</li>
		</ul>
	</span>

	<UITable data={list} field={field}>
			<span slot="row">
			</span>
			<span slot="footer">
				<UIPagination></UIPagination>
			</span>
	</UITable>


	<span slot="page-footer">
		page header
	</span>
</UIPage>
