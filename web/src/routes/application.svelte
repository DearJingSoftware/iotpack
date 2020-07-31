<script>
	import UITable from '../uikit/UITable.svelte';
	import UIPage from '../uikit/UIPage.svelte';
	import UIButton from '../uikit/UIButton.svelte';
	import UIPlaceholder from '../uikit/UIPlaceholder.svelte';
	import UIProgress from '../uikit/UIProgress.svelte';
	import UIModal from '../uikit/UIModal.svelte';
	import UISilder from '../uikit/UISilder.svelte';
	import UIForm from '../uikit/form/UIForm.svelte';
	import UIFormGroup from '../uikit/form/UIFormGroup.svelte';
	import UITextInput from '../uikit/form/UITextInput.svelte';
	import UIUpload from '../uikit/form/UIUpload.svelte';
	import UIButton1 from '../uikit/form/UIButton.svelte';
	import UIPagination from "../uikit/UIPagination.svelte";
	import Avatar from "../uikit/Avatar.svelte";
	import LayoutAlignBoth from '../uikit/layout/LayoutAlignBoth.svelte';


	import ProjectMemberList from './project/component/ProjectMemberList.svelte';


	var showCreateProject="hide";
	function createProject(event) {
			showCreateProject="show"
	}

	var	list = [
		{
			id:1,name:"AirBnb",
		},
		{
			id:2,name:"Behance Presentation"
		},
		{
			id:3,name:"Evanato"
		},
			{
			id:4,name:"DropBox"
		},
			{
			id:5,name:"Google"
		},
			{
			id:6,name:"Baidu"
		},
			{
			id:7,name:"Youtube"
		},
			{
			id:8,name:"Riddit"
		},
			{
			id:9,name:"Twitter"
		},
	]

	// list=[];

	var	field = [
		{
			id:1,name:"id",width:"20px",sort:true,displayName:"编号"
		},
		{
			id:2,name:"name",width:"100px",sort:true,displayName:"名称",component:UIPlaceholder
		},
		{
			id:3,name:"member",width:"200px",sort:true,displayName:"版本"
		},
		{
			id:4,name:"number",width:"200px",sort:true,displayName:"用户数"
		},
		{
			id:5,name:"number",width:"200px",sort:true,displayName:"最后更新时间"
		},
		{
			id:6,name:"action",width:"200px",displayName:"操作"
		}
	]
</script>
<svelte:head>
	<title>应用管理</title>
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

.item-container {
	display: flex;
	flex-direction: column;
	justify-items: center;
	justify-content: center;
	align-items: center;
}

.project .name {
	font-size:20px;
	line-height:23px;
	height:23px;
	color: #252631;
	padding: 35px 0px
}
.project:hover .name{
	color: #4d7cfe;
}
.project {
	cursor: pointer;
	position: relative;

}


.project .progress {
	left: 0px;
  top: 12px;
	position: absolute;
}
.project .action {
	    right: 0px;
    top: 0px;
	position: absolute;
}
</style>

<UISilder bind:show={showCreateProject} title="新增应用">
	<div style="height:300px">
		<UIForm>
			<UIFormGroup title="应用Logo:" info="应用Logo">
					<UIUpload  placeholder="应用logo"></UIUpload>
			</UIFormGroup>
			<UIFormGroup title="应用名称:" info="应用名称">
					<UITextInput  placeholder="应用名称"></UITextInput>
			</UIFormGroup>
			<UIFormGroup title="应用成员:" info="应用成员" >
					<UITextInput placeholder="应用成员" disabled></UITextInput>
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
					<i class="las la-plus-circle" ></i>创建应用
				</UIButton>
			</li>
		</ul>
	</span>

	<UITable data={list} field={field} url="" list_style=1>
			<span slot="row">
			</span>
			<span slot="footer">
				<UIPagination></UIPagination>
			</span>
			<span slot="grid-item" let:data={data} class="item-container project">
				<div class="progress" style="width:54px">
					<UIProgress></UIProgress>
				</div>
				<div class="action" ><i class="las la-ellipsis-h" ></i></div>
				<Avatar size="80" src="https://api-lunacy.icons8.com/api/assets/f7f8d13a-d1aa-420a-b8d6-ff44c1b937f2/img.png"></Avatar>
				<div class="name" style="">{data.name}</div>
				<div class="completion_ratio" style="font-size:24px;color: #252631;">80/148</div>
				<div class="completion_word" style=" line-height: 21px;font-size:14px;color: #252631;  color: #98a9bc;margin-bottom:30px">Task complete</div>
				<div class="member_avatar"><ProjectMemberList /></div>
			</span>
	</UITable>

	<span slot="page-footer">
		page header
	</span>

</UIPage>
