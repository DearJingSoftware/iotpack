
<script>
import { createEventDispatcher } from 'svelte';

import UIMenu from '../menu/UIMenu.svelte';
const dispatch = createEventDispatcher();
export let data=[];
export let title="";
export let defaultData="";
export let icon="la-exclamation-circle";
export let multiple=false;
export let search=false;
export let value=null;

function changeValue(v) {
    console.log("修改值"+v);
    value=v;
}
</script>

<style>
    .body{
      /* background-color: white; */
      position: relative;
    }

    .menu {
      display: none;
      position: absolute;
      z-index: 200;
      box-shadow: 0px 2px 16px rgba(153,155,168,0.12);
      margin: 0px;
      padding: 0px;
      min-width: 150px;
      border: 2px solid rgba(153,155,168,0.12);
      background-color: white;
    }

    .body:hover .menu{
      display: inline-block;
    }

    ul ,li {
      margin: 0px;
      padding: 0px;
      text-align: right;
      list-style: none;
    }
    li {
      margin: 10px;
    }
    li:hover {
          color:#4D7CFE
    }
    ul a ,li a {
      text-decoration: none;
    }
    li .icon {
      margin-right: 10px;
    }



.search-input {
  border: none;
  padding: 10px;
}

.search-input:focus{
    outline: none;
}
.search_box {
    height: 60px;
    display: flex;
    justify-items: center;
    align-items: center;
		text-decoration: none;
    text-align: right;
}

.search_box i {
  font-size: 24px;
}
input[placeholder], [placeholder], *[placeholder] { 
  color:#778CA2 !important; 
}
.search_widget {
    border-bottom: 1px solid #778CA2;
    display: flex;
     justify-items: center;
    align-items: center;
}
</style>
<div class="body">
  <div class="handler">
    {#if value==null}
      {#if defaultData==-1}
        <i class="las {icon}"></i> {title}: 全部 	<i class="las la-angle-down"></i>  
      {/if}
      {#if defaultData==0}
        <i class="las {icon}"></i> {title}: 未选择 	<i class="las la-angle-down"></i>  
      {/if}
    {:else}
       {#if value==0}
        <i class="las {icon}"></i> {title}: 全部 	<i class="las la-angle-down"></i>  
      {/if}
      {#if value==-1}
        <i class="las {icon}"></i> {title}: 未选择 	<i class="las la-angle-down"></i>  
      {/if}
      {#each data as d}
          {#if d.id==value}
            <i class="las {icon}"></i> {title}: {d.name} 	<i class="las la-angle-down"></i>  
          {/if}
      {/each}
    {/if}
  </div>

  <ul class="menu">
      {#if search}
        <li class="search_widget"><input class="search-input" placeholder="搜索"><i class="las la-search"></i></li>
      {/if}
      {#if defaultData==-1}
      <li on:click={(e)=>{changeValue(0)}}><a href="javascript:void(0)">全部</a></li>
      {/if}
      {#if defaultData==0}
      <li on:click={(e)=>{changeValue(-1)}}><a href="javascript:void(0)">未选择</a></li>
      {/if}
      {#each data as d}
        <!-- <li><i class="icon las la-address-card"></i><a href="user/edit">{d.name}</a></li> -->
         <li on:click={changeValue(d.id)} class:active={value=d.id}><i class="icon las {d.icon}"></i><a href="javascript:void(0)">{d.name}</a></li>
      {/each}
  </ul>
</div>

