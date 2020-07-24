
<script>
	import UiCheckBox from './form/UICheckBox.svelte';
  export var data=[];
  export var field =[];
  export var select=true;
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
}
</style>
<div>
  {#if field.size>0 }
    <div class="header">
      {#if select && field.size>0 }
        <div class="header_item" style="width:30px;margin-right:20px;flex-grow:0">
            <UiCheckBox></UiCheckBox>
        </div>
        {/if}
      {#each field as f}
      <div class="header_item" style="width:{f.width}">
        {#if f.sort}
          <a href="javascript:void(0);" class="handler"><i class="las la-sort-amount-down-alt"></i></a>
        {/if}
        <div class="title">{f.name}</div>
      </div>
      {/each}
    </div>
  {/if}
  <div class="body">
    {#each data as d}
    <div class="row">
        <div class="col" style="text-align:center;width:30px;margin-left: 0px;margin-right:20px;flex-grow:0">
            <UiCheckBox></UiCheckBox>
        </div>
        {#each field as f}
          <div class="col" style="width:{f.width};{f.align?"text-align:"+f.align:''}">
            {d[f.name]?d[f.name]:""}
          </div>
        {/each}
      </div>
    {/each}
  </div>
  <div class="footer">
    <slot name="footer"></slot>
  </div>
</div>