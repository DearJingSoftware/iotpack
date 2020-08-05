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
	import Menu from './project/component/Menu.svelte';

	export var list_style=2;
	var showCreateProject="hide";
	function createProject(event) {
			showCreateProject="show"
	}

	function handleStyle(style) {
			list_style=style
	}

		var menu=[
					{id:1,name:"编辑",icon:"las la-pen"},
					{id:2,name:"发布",icon:"las la-code-branch"},
					{id:3,name:"删除",icon:"las la-trash"},
					{id:4,name:"移除",icon:"las la-sign-out-alt"},
					{id:5,name:"导出",icon:"las la-file-export"},
					{id:2,name:"克隆",icon:"las la-clone"},
					];

	var	list = [
		{
			id:1,name:"Arduino",deviceCount:100,gatewayCount:20,is_publish:false,avatar:"/img/arduino.png",detail:"项目信息项目信息项目信息项目信息项目信"
		},
		{
			id:2,name:"Orangepi",deviceCount:100,gatewayCount:20,is_publish:false,avatar:"/img/orangepi.png",detail:"项目信息项目信息"
		},
		{
			id:3,name:"Raspberrypi",deviceCount:200,gatewayCount:200,is_publish:true,avatar:"/img/raspberrypi.png",detail:"项目信息项目信息"
		},
			{
			id:4,name:"Arduino",deviceCount:100,gatewayCount:20,is_publish:false,avatar:"/img/arduino.png",detail:"项目信息项目信息"
		},
		{
			id:5,name:"Orangepi",deviceCount:100,gatewayCount:20,is_publish:false,avatar:"/img/orangepi.png",detail:"项目信息项目信息"
		},
		{
			id:6,name:"Raspberrypi",deviceCount:200,gatewayCount:200,is_publish:true,avatar:"/img/raspberrypi.png",detail:"项目信息项目信息"
		},
			{
			id:7,name:"Arduino",deviceCount:100,gatewayCount:20,is_publish:false,avatar:"/img/arduino.png",detail:"项目信息项目信息"
		},
		{
			id:8,name:"Orangepi",deviceCount:100,gatewayCount:20,is_publish:false,avatar:"/img/orangepi.png",detail:"项目信息项目信息"
		}
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
			id:3,name:"member",width:"200px",sort:true,displayName:"项目成员"
		},
		{
			id:4,name:"progress",width:"80px",sort:true,displayName:"项目进度",component:UIProgress
		},
		{
			id:5,name:"type",width:"200px",sort:true,displayName:"设备信息"
		},
		{
			id:6,name:"action",width:"200px",displayName:"操作"
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

<UISilder bind:show={showCreateProject} title="新增项目">
		<UIForm>
			<UIFormGroup title="项目Logo:" info="项目Logo">
					<UIUpload  placeholder="项目成员"></UIUpload>
			</UIFormGroup>
			<UIFormGroup title="项目名称:" info="项目名称">
					<UITextInput  placeholder="项目名称"></UITextInput>
			</UIFormGroup>
			<UIFormGroup title="项目成员:" info="项目成员" >
					<UITextInput placeholder="项目成员" disabled></UITextInput>
			</UIFormGroup>
		</UIForm>
	
	<span slot="footer">
		<LayoutAlignBoth>
					<span slot="left"><UIButton1>创建</UIButton1></span>
					<span slot="right"><UIButton1>取消</UIButton1></span>
		</LayoutAlignBoth>
	</span>
</UISilder>
<UIPage>
	<span slot="header-left">
		<ul class="filter">
		
		</ul>
	</span>
	<span slot="header-right">
		<ul class="filter">
			<li>
				<UIButton status="primary" on:click={createProject}>
					<i class="las la-plus-circle" ></i>创建新项目
				</UIButton>
			</li>
		</ul>
	</span>

	<UITable data={list} field={field} url="" bind:list_style={list_style}>
			<span slot="row">
			</span>
			<span slot="footer">
				<UIPagination></UIPagination>
			</span>
			<span slot="grid-item" let:data={data} class="item-container project">
				<!-- <div class="progress" style="width:54px">
					<UIProgress></UIProgress>
				</div> -->
				<div class="action" >
						<UIDropdown>
							<i class="las la-ellipsis-h" ></i>
							<span slot="menu">
								<Menu data={menu}></Menu>
							</span>
						</UIDropdown>
				</div>
				<Avatar size="80" src="{data.avatar}"></Avatar>
				<div class="name" style="">{data.name}</div>
				<div class="completion_ratio" style="font-size:24px;color: #252631;">{data.deviceCount}/{data.gatewayCount}</div>
				<div class="completion_word" style=" line-height: 21px;font-size:14px;color: #252631;  color: #98a9bc;margin-bottom:30px">{data.detail}</div>
				<div class="member_avatar"><ProjectMemberList /></div>
			</span>
	</UITable>

	<span slot="page-footer">
		page header
	</span>

</UIPage>
