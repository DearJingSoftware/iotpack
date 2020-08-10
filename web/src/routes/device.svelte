<script>
	import UITable from '../uikit/UITable.svelte';
	import UIPage from '../uikit/UIPage.svelte';
	import UIButton from '../uikit/UIButton.svelte';
	import UISearchInput from '../uikit/UISearchInput.svelte';
	import UIOnline from '../uikit/UIOnline.svelte';
	import UIPagination from "../uikit/UIPagination.svelte";

	var showCreateProject="hide";
	function createProject(event) {
			showCreateProject="show"
	}
		var	list = [
		{
			id:1,name:"863808040532006",deviceCount:9999,load:'60%',is_online:true,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"烟感"
			,principal:"JZX",maintenance:"JZX"
		},
		{
			id:2,name:"863808040532006",deviceCount:9999,load:'60%',is_online:false,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"红外线"
					,principal:"JZX",maintenance:"JZX"
		},
		{
			id:3,name:"863808040532006",deviceCount:9999,load:'60%',is_online:true,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"紫外线"
				,principal:"JZX",maintenance:"JZX"
		},
		{
			id:4,name:"863808040532006",deviceCount:9999,load:'60%',is_online:false,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"燃气"
			,principal:"JZX",maintenance:"JZX"
		},
		{
			id:5,name:"863808040532006",deviceCount:9999,load:'60%',is_online:false,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"门磁"
			,principal:"JZX",maintenance:"JZX"
		},
		{
			id:6,name:"863808040532006",deviceCount:9999,load:'60%',is_online:false,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"门磁"
			,principal:"JZX",maintenance:"JZX"
		},
		{
			id:7,name:"863808040532006",deviceCount:9999,load:'60%',is_online:true,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"门磁"
			,principal:"JZX",maintenance:"JZX"
		},
		{
			id:8,name:"863808040532006",deviceCount:9999,load:'60%',is_online:false,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"门磁"
			,principal:"JZX",maintenance:"JZX"
		},
		{
			id:9,name:"863808040532006",deviceCount:9999,load:'60%',is_online:true,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"门磁"
			,principal:"JZX",maintenance:"JZX"
		},
		{
			id:10,name:"863808040532006",deviceCount:9999,load:'60%',is_online:false,addr:"北京市海淀区青龙桥街道骚子营社区",organization:"报警小组",maintain:"维护小组",last_status:"心跳",last_time:"2020年8月10日17:57:27",type:"门磁"
			,principal:"JZX",maintenance:"JZX"
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
			id:1,name:"id",width:"80px",sort:true,displayName:"编号",
		},
		{
			id:2,name:"type",width:"100px",displayName:"类型"
		},
		{
			id:2,name:"name",width:"200px",displayName:"设备名称",sort:true
		},
		{
			id:3,name:"addr",width:"350px",displayName:"设备位置",sort:true
		},
		{
			id:5,name:"organization",width:"200px",displayName:"报警小组"
		},
		{
			id:6,name:"maintain",width:"200px",displayName:"维护小组"
		},
		{
			id:5,name:"principal",width:"200px",displayName:"负责人"
		},
		{
			id:6,name:"maintenance",width:"200px",displayName:"维护人"
		},
		{
			id:7,name:"is_online",width:"80px",displayName:"在线",component:UIOnline
		},
		{
			id:7,name:"rssi",width:"80px",displayName:"RSSI"
		},
		{
			id:8,name:"last_status",width:"100px",displayName:"最后状态"
		},
		{
			id:9,name:"last_time",width:"200px",displayName:"最后通讯时间"
		},
	]


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

	<UITable tree=true adaptive="" data={list}  field={field} url="" query={query} colTree=true>

		<span slot="footer">
				<UIPagination align="left"></UIPagination>
		</span>
	</UITable>


	<span slot="page-footer">
		page header
	</span>
</UIPage>
