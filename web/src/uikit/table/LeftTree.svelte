<script>
import { tick } from 'svelte';
export var data=[];

async function handleListClick(d){
  console.log("点击")
  console.log(d);
  d.is_explode=!!!d.is_explode
}
</script>

<style>
.table-left {
  padding-right: 20px;
  background-color: #F8FAFB;
  width: 15%;
  color:#778CA2
}
.active {
  border-radius: 4px;
  background-color: Rgb(225,225,225)
}
nav>ul{
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
[explode='true']{
  color: red;
}
i {
  width: 24px;
  height: 24px;
  display: inline-block;
}
</style>
<nav class="table-left">
  <ul>
    <li  class="active"> <span class="name"><i>&nbsp;</i>全部</span> <span class="count">100</span></li>
    {#each data as d}
      <li  explode={d.is_explode?true:false} on:click={handleListClick(d)}><span class="name"><i class="las la-caret-right"></i>{d.name}</span><span  class="count">{d.count||0}</span></li>
      {#if d.children.length>0 }
        <ul >
          {#each d.children as d1}
          <li  explode={d1.is_explode} on:click={handleListClick(d1)}><span class="name"><i class="las la-caret-right"></i>{d1.name}</span><span  class="count">{d1.count||0}</span></li>
           {#if d1.children.length>0 }
            <ul>
              {#each d1.children as d2}
              <li on:click={handleListClick(d2)}><span class="name">
                  {#if d2.children.length>0 }
                    <i class="las la-caret-right"></i>
                  {:else}
                    <i>&nbsp;</i>
                  {/if}
                  {d2.name}</span><span  class="count">{d2.count||0}</span></li>
              {/each}
            </ul>
          {/if}
          {/each}
        </ul>
      {/if}
    {/each}
  </ul>
</nav>