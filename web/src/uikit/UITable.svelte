
<script>
	import UiCheckBox from './form/UICheckBox.svelte';
  	import LeftTree from './table/LeftTree.svelte';
  export var data=[];
  export var field =[];
  export var query={
    //排序字段
    sort:"",
    //排序顺序 desc asc
    order:"desc",
    checkAll:false
  };
  export var select=true;
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
</script>

<style>
a {
  text-decoration: none;
}

.header {
  display: flex;
  padding: 0px 20px;
  border-bottom: 2px solid #E8ECEF;
}

.footer {
   background-color: #F8FAFB;
}
.header_item {
  flex-grow: 1;
  padding: 20px 0px;
  padding-left: 5px;
  display: flex;
  flex-direction: row;
  cursor: pointer;
}

.header .title {
  margin-left: 5px;
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
  display: flex;
  padding: 20px;
  border-bottom: 1px solid #E8ECEF;

}

.row:hover {
  background-color: #f2f4f6;
}
.col {
  flex-grow: 1;
  margin-left: 20px;
  /* display:flex; 
  justify-content:start;
  justify-items: center; */
}


.grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 45px;
  grid-auto-rows: minmax(100px, auto);
}
.grid {
  background-color: #F8FAFB;
  text-align: center;
}

.grid-wrap {
  background-color: #F8FAFB;
  background-color: white;
  padding: 35px;
  box-shadow: 0px 2px 16px rgba(153,155,168,0.12);
  border-radius: 4px;
}
.warp {
  display: flex;
}

.table-content {
  flex-grow: 1;
}
</style>
<div class="warp">
{#if tree }
<LeftTree data={treeData}></LeftTree>
{/if}
<div class="table-content">

 
  {#if field.length>0 && data.length>0 && list_style==1 }
    <div class="header">
      {#if select && field.length>0 }
        <div class="header_item" style="width:30px;margin-right:20px;flex-grow:0">
            <UiCheckBox on:change={selectAll}></UiCheckBox>
        </div>
        {/if}
      {#each field as f}
      <div class="header_item" style="width:{f.width}" on:click={(e)=>{handlerSort(e,f)}}>
        {#if f.sort}
          <a href="javascript:void(0);" class="handler {f.name==query.sort?'active':''}"><i class="las {(query.order=='asc'&&f.name==query.sort)?'la-sort-amount-up-alt':'la-sort-amount-down-alt'}"></i></a>
        {/if}
        <div class="title">{f.displayName?f.displayName:f.name}</div>
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
          <div class="row">
            <div class="col" style="text-align:center;width:30px;margin-left: 0px;margin-right:20px;flex-grow:0">
                <UiCheckBox bind:value={d.check}></UiCheckBox>
            </div>
            {#each field as f}
              
              <div class="col" style="width:{f.width};{f.align?"text-align:"+f.align:''}">

                  {#if f.component}
                    <svelte:component this={f.component}  {...d}/>
                  {:else}
                    {d[f.name]?d[f.name]:""}
                  {/if}
              </div>
            
            {/each}
          </div>
        {:else}
            <div class="grid-wrap">
              <slot name="grid-item" data={d} ></slot>
            </div>
        {/if}
      {/each}
  
  </div>
  {/if}
  {#if field.length>0 && data.length>0 }
  <div class="footer">
    <slot name="footer"></slot>
  </div>
  {/if}
</div>


</div>