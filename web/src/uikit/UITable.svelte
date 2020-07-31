
<script>
	import UiCheckBox from './form/UICheckBox.svelte';
  export var data=[];
  export var field =[];
  export var query={};
  export var select=true;
  export var url="";
  export var list_style=1;
</script>

<style>
a {
  text-decoration: none;
}

.header {
  display: flex;
  padding: 20px;
  border-bottom: 1px solid #E8ECEF;
}

.footer {
   background-color: #F8FAFB;
}
.header_item {
  flex-grow: 1;
  display: flex;
  flex-direction: row;
}

.header .title {
  margin-left: 5px;
}

.header .handler {
  width: 20px;
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

</style>
<div>
  {#if field.length>0 && data.length>0 && list_style==1 }
    <div class="header">
      {#if select && field.length>0 }
        <div class="header_item" style="width:30px;margin-right:20px;flex-grow:0">
            <UiCheckBox></UiCheckBox>
        </div>
        {/if}
      {#each field as f}
      <div class="header_item" style="width:{f.width}">
        {#if f.sort}
          <a href="javascript:void(0);" class="handler"><i class="las la-sort-amount-down-alt"></i></a>
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
                <UiCheckBox></UiCheckBox>
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