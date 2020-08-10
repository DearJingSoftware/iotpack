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
	import UIDropdown from '../uikit/UIDropdownV1.svelte';


	import ProjectMemberList from './project/component/ProjectMemberList.svelte';
	import Action from './organization/Action.svelte';
	import Menu from './project/component/Menu.svelte';

	export var list_style=1;
	var showCreateProject="hide";
	function createProject(event) {
			showCreateProject="show"
	}

	function handleStyle(style) {
			list_style=style
	}

	var query={
		active:null,
		status:null,
		gateway:null,
	}
	var	list = [
		{
			id:1,name:"AirBnb",
		},
		{
			id:2,name:"Behance Presentation"
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
			id:6,name:"action",width:"200px",displayName:"操作",component:Action
		}
	]
</script>
<svelte:head>
	<title>组织管理</title>
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

<UISilder bind:show={showCreateProject} title="新增组织">
	<div style="height:300px">
		<UIForm>
			<UIFormGroup title="Logo:" info="Logo">
					<UIUpload  placeholder="项目成员"></UIUpload>
			</UIFormGroup>
			<UIFormGroup title="名称:" info="名称">
					<UITextInput  placeholder="项目名称"></UITextInput>
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
				组织
			</li>
		</ul>
	</span>
	<span slot="header-right">
		<ul class="filter">
			
			<li>
				<UIButton status="primary" on:click={createProject}>
					<i class="las la-plus-circle" ></i>创建组织
				</UIButton>
			</li>
		</ul>
	</span>

	<UITable data={list} field={field} url="" bind:list_style={list_style} tree=true colTree=true bigDetail=true>
			<span slot="row">
			</span>
			<span slot="footer">
				<UIPagination></UIPagination>
			</span>
			<span slot="grid-item" let:data={data} class="item-container project">
				<div class="progress" style="width:54px">
					<UIProgress></UIProgress>
				</div>
				<div class="action" >
						<UIDropdown>
							<i class="las la-ellipsis-h" ></i>
							<span slot="menu">
								<Menu></Menu>
							</span>
						</UIDropdown>
				</div>
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
