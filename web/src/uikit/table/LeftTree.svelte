<script>
import { tick } from 'svelte';
export var data=[];

async function handleListClick(e,d){
  d.is_explode=!!!d.is_explode
  data=data;
}
</script>

<style>
.table-left {
  padding-right: 20px;
  background-color: #F8FAFB;
  width: 15%;
  color:#778CA2;
  flex: 0 1 auto;
}
.active {
  border-radius: 4px;
  background-color: Rgb(225,225,225)
}
nav>ul{
  width: 200px;
  margin-top: 0px;
  margin-left: 0px;
  padding-left: 0px;
}
nav>ul :first{
 margin-top: 0px;
}
ul ,li {
  list-style: none;
}
li {
  cursor: pointer;
}
li:hover  .name{
  color:#4D7CFE
}
li {
  display: flex;
  padding: 10px 0px;
  padding-right: 10px;
  justify-content: space-between;
  justify-items: center;
  align-items: center;
}
li.explode{
  /* color: #4D7CFE; */
}
ul.explode{
  display: none;
}
i:hover{
 border:2px solid hsl(240, 1%, 60%);
 background-color: hsl(240, 1%, 60%);
 color: white;
}
.name {
  line-height: 18px;
  font-size: 18px;
}
i {
  border-radius: 50%;
  border:2px solid rgba(0, 0, 0, 0);
  font-size: 18px;
  line-height: 18px;
  width: 18px;
  height: 18px;
  display: inline-block;
}
.title {
  margin-left: 5px;
}
</style>
<nav class="table-left">
  <ul>
    <li  class="active"> <span class="name"><i>&nbsp;</i><span class="title">全部</span></span> <span class="count">100</span></li>
    {#each data as d}
      <li  class:explode={d.is_explode} on:click={(e)=>{handleListClick(e,d)}}><span class="name">
        <i class="las la-caret-{d.is_explode?'right':'down'}">
          </i><span class="title">{d.name}</span></span><span  class="count">{d.count||0}</span></li>
      {#if d.children.length>0 }
        <ul class:explode={d.is_explode} >
          {#each d.children as d1}
          <li explode={d1.is_explode} on:click={(e)=>{handleListClick(e,d1)}}><span class="name">
            {#if d1.children.length>0 }
              <i class="las la-caret-{d1.is_explode?'right':'down'}"></i>
            {:else}
              <i>&nbsp;</i>
            {/if}
          
          <span class="title">{d1.name}</span></span><span  class="count">{d1.count||0}</span></li>
           {#if d1.children.length>0 }
            <ul class:explode={d1.is_explode}>
              {#each d1.children as d2}
              <li on:click={(e)=>{handleListClick(e,d2)}}><span class="name">
                  {#if d2.children.length>0 }
                    <i class="las la-caret-{d2.is_explode?'right':'down'}"></i>
                  {:else}
                    <i>&nbsp;</i>
                  {/if}
                  <span class="title">{d2.name}</span>
                  </span><span  class="count">{d2.count||0}</span></li>
              {/each}
            </ul>
          {/if}
          {/each}
        </ul>
      {/if}
    {/each}
  </ul>
</nav>