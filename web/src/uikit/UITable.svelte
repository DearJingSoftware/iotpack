<script>
  import { createEventDispatcher } from 'svelte';
   const dispatch = createEventDispatcher();
	import UiCheckBox from './form/UICheckBox.svelte';
  import LeftTree from './table/LeftTree.svelte';
  
  export var data=[];
  export var field =[];
  export var autoRefresh=10;
  export var adaptive="table-content";
  export var query={
    //排序字段
    sort:"",
    //排序顺序 desc asc
    order:"desc",
    checkAll:false
  };
  export var select=true;
  export var colTree=false;
  export var bigDetail=false;
  
  export var url="";
  export var tree=false;
  export var treeData=[
    {
      id:0,
      name:"中国",
      is_explode:true,
      count:2000,
      children:[
          {
            id:1,
            name:"北京",
            is_explode:false,
            count:20,
            children:[
              {
                id:3,
                name:"海淀",
                count:5,
                children:[

                ],
              },
               {
                id:3,
                name:"朝阳",
                count:5,
                children:[

                ],
              }
            ],
          },
           {
            id:2,
            name:"上海",
            children:[

            ],
          }
      ]
    },
      {
      id:0,
      name:"美国",
      is_explode:false,
      children:[
          {
            id:1,
            name:"纽约",
            children:[
            ],
          },
           {
            id:2,
            name:"西雅图",
            children:[
            ],
          }
      ]
    }
  ];
  export var list_style=1;
  //全部选择
  function selectAll(e) {
    data.forEach(d=>{
      d.check=!query.checkAll;
    })
    query.checkAll=!query.checkAll;
    data=data;
  }
  //全部
  function handlerSort(e,d) {
    if(d.name === query.sort){
      query.order=(query.order=="desc")?"asc":"desc";
    }else{
      query.sort=d.name
      query.order="desc"
    }
    query=query
  }
  //显示详情内容
  function  handlerExplode(d) {
    d.is_explode=!d.is_explode
    data=data;
  }

  function handlerRowTree(d) {
    d.is_row_tree=!d.is_row_tree;
    data=data;
  }

  function handlerRefresh() {
    console.log("自动更新");
  }

  if(autoRefresh>0){
    setInterval(() => {
      handlerRefresh();
    }, autoRefresh*1000);
  }
</script>

<style>
a {
  text-decoration: none;
}

.header {
  min-width: fit-content;
  display: flex;
  border-bottom: 2px solid #E8ECEF;
}

.footer {
   background-color: #F8FAFB;
}
.header_item {
  border-left: 1px solid white;
  flex-shrink: 0;
  word-break: keep-all;
  padding: 20px;
  display: flex;
  flex-direction: row;
  cursor: pointer;
  justify-content: space-between;
}



.header .handler {
  width: 20px;
  cursor: pointer;
}

.header .header_item:first-child :hover {
   background-color: white
}

.header .handler.active {
  color: #4D7CFE;
}

.remote_loading ,.no_data {
  text-align: center;
  height: 500px;
  line-height: 500px;
  margin: 20px;
}
.row {
  min-width: fit-content;
  display: flex;
  /* padding: 20px; */
  border-bottom: 1px solid #E8ECEF;
}

.row_detail {
  display: flex;
  padding: 20px;
  border-bottom: 1px solid #E8ECEF;
}

.row_tree {
  display: flex;
  padding: 20px;
  border-bottom: 1px solid #E8ECEF;
}

.row:hover {
  background-color: #f2f4f6;
}
.col {
  padding:20px;
  flex-shrink: 0;
  border-left: 1px solid #00000000;
  /* flex-grow: 1; */
  /* margin-left: 20px; */
  /* display:flex; 
  justify-content:start;
  justify-items: center; */
}

.grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 20px;
  grid-auto-rows: minmax(100px, auto);
}

.grid {
  background-color: #F8FAFB;
  text-align: center;
}

.grid-wrap {
  background-color: #F8FAFB;
  background-color: white;
  padding: 30px;
  box-shadow: 0px 2px 16px rgba(153,155,168,0.12);
  border-radius: 4px;
}
.warp {
  display: flex;
  width: 100%;
}

.table {
  flex: 1 1 auto;
  min-width: 0
}

.content {
  overflow-x: auto;
  display: flex;
  flex-direction: column;
}
.table-content {
  flex-grow: 1;
}

</style>
<div class="warp">
{#if tree }
<LeftTree data={treeData}></LeftTree>
{/if}
<div class="table {adaptive}">
  
    <div class="content">
      {#if field.length>0 && data.length>0 && list_style==1 }
        <div class="header">
          {#if select && field.length>0 }
            <div class="header_item" style="width:30px;flex-grow:0">
                <UiCheckBox on:change={selectAll}></UiCheckBox>
            </div>
          {/if}

          {#if colTree && field.length>0 }
            <div class="header_item" style="width:30px;flex-grow:0">
                
            </div>
          {/if}
          
          {#each field as f}
          <div class="header_item" style="width:{f.width}" on:click={(e)=>{handlerSort(e,f)}}>
          
            <div class="title">{f.displayName?f.displayName:f.name}</div>
            {#if f.sort}
              <a href="javascript:void(0);" class="handler {f.name==query.sort?'active':''}"><i class="las {(query.order=='asc'&&f.name==query.sort)?'la-sort-amount-up-alt':'la-sort-amount-down-alt'}"></i></a>
            {/if}
          </div>
          {/each}
        </div>
      {/if}
      {#if data.length==0 }
        {#if url!="" }
            <div class="remote_loading"><i class="las la-spinner"></i>数据加载中...</div>
        {:else}
            <div class="no_data"><i class="las la-exclamation"></i>暂无数据</div>
        {/if}
      {:else}
      <div class="body {list_style==1?'list':'grid'}">
        
          {#each data as d}
            {#if list_style==1 }
              <div class="row" >
                <div class="col" style="text-align:center;width:30px;margin-left: 0px;flex-grow:0">
                    <UiCheckBox bind:value={d.check}></UiCheckBox>
                </div>
                {#if colTree}
                <div class="col" style="text-align:center;width:30px;margin-left: 0px;flex-grow:0">
                    <i class="lar {d.is_row_tree?'la-minus-square ':'la-plus-square'}" on:click={handlerRowTree(d)} ></i>
                </div>
                {/if}
                {#each field as f}
                  <div class="col" on:click={handlerExplode(d)} style="width:{f.width};{f.align?"text-align:"+f.align:''}">
                      {#if f.component}
                        <svelte:component this={f.component}  {...d}/>
                      {:else}
                        {d[f.name]?d[f.name]:""}
                      {/if}
                  </div>
                {/each}
              </div>
              {#if bigDetail && d.is_explode}
                <div class="row_detail">
                  详情
                </div>
              {/if}
              {#if d.is_row_tree}
                <div class="row_tree">
                  嵌套表格
                </div>
              {/if}
            {:else}
                <div class="grid-wrap">
                  <slot name="grid-item" data={d} ></slot>
                </div>
            {/if}
          {/each}
      
      </div>
      {/if}
     </div>
  
  {#if field.length>0 && data.length>0 }
  <div class="footer">
    <slot name="footer"></slot>
  </div>
  {/if}
</div>


</div>