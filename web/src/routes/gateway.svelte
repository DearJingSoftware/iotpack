<script>
	import UITable from '../uikit/UITable.svelte';
	import UIPage from '../uikit/UIPage.svelte';
	import UIButton from '../uikit/UIButton.svelte';
	import UIPlaceholder from '../uikit/UIPlaceholder.svelte';
	import UIProgress from '../uikit/UIProgress.svelte';
	import UIOnline from '../uikit/UIOnline.svelte';
	import UIModal from '../uikit/UIModal.svelte';
	import UISilder from '../uikit/UISilder.svelte';
	import UIForm from '../uikit/form/UIForm.svelte';
	import UISelect from '../uikit/form/UISelect.svelte';

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
			id:1,name:"NBIOT",deviceCount:9999,load:'60%',is_online:true
		},
		{
			id:2,name:"Ctwing",deviceCount:9999,load:'60%',is_online:false
		},
		{
			id:3,name:"Onenet",deviceCount:9999,load:'60%',is_online:true
		},
		{
			id:4,name:"OC网关",deviceCount:9999,load:'60%',is_online:false
		},
		{
			id:5,name:"直连网关",deviceCount:9999,load:'60%',is_online:false
		},
		{
			id:6,name:"直连网关",deviceCount:9999,load:'60%',is_online:false
		},
		{
			id:7,name:"直连网关",deviceCount:9999,load:'60%',is_online:true
		},
		{
			id:8,name:"直连网关",deviceCount:9999,load:'60%',is_online:false
		},
		{
			id:9,name:"直连网关",deviceCount:9999,load:'60%',is_online:true
		},
		{
			id:10,name:"直连网关",deviceCount:9999,load:'60%',is_online:false
		},
		
	]

	var query={
		sort:"id",
		order:"desc",
		active:null,
		status:null,
		gateway:null,
	}
	// list=[];

	var	field = [
		{
			id:1,name:"id",width:"20px",sort:true,displayName:"编号"
		},
		{
			id:2,name:"name",width:"100px",displayName:"网关名称",component:UIPlaceholder
		},
		{
			id:3,name:"deviceCount",width:"200px",displayName:"设备信息",sort:true
		},
			{
			id:4,name:"is_online",width:"40px",displayName:"在线",component:UIOnline
		},
		{
			id:4,name:"load",width:"80px",displayName:"负载情况",sort:true
		},
		{
			id:6,name:"action",width:"200px",displayName:"操作"
		}
	]
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

<UISilder bind:show={showCreateProject} title="新增网关">
	<div style="height:300px">
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
				<UISelect icon="la-exclamation-circle" title="在线状态" multiple=false bind:value={query.status} defaultData="-1" data={[{id:1,name:"在线"},{id:2,name:"离线"}]}></UISelect>
			</li>
			<li>
				<UISelect icon="la-sync" title="网关类型" multiple=false bind:value={query.gateway} defaultData="-1" data={[{id:1,name:"MQTT"},{id:2,name:"COAP"}]}></UISelect>
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
					<i class="las la-plus-circle" ></i>新建网关
				</UIButton>
			</li>
		</ul>
	</span>

	<UITable data={list} field={field} url="" query={query}>
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
