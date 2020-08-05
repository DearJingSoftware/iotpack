
<script>
export let status='default';
export let active='';
import { createEventDispatcher } from 'svelte';

  const dispatch = createEventDispatcher();
  
  function handleClick() {
		dispatch('click', {});
	}
</script>


<style>
.dropdown {
  position:relative;
}
.dropdown:hover .menu_warp{
  display: block;
}
.dropdown:hover .menu_warp:hover {
  display: block;
}
.menu_warp {
  display: none;
  z-index: 200;
  top:69px;
  position:absolute;
  width: 120px;
  left: -80px;
  box-shadow: 0px 2px 16px rgba(153,155,168,0.12);
  margin: 0px;
  padding: 0px;
  border-left: 2px solid rgba(153,155,168,0.12);
  border-right: 2px solid rgba(153,155,168,0.12);
  border-bottom: 2px solid rgba(153,155,168,0.12);
  background-color: white;
}

</style>

<div class="dropdown">
   
   <slot>
   </slot>

  <div class="menu_warp">
    <slot name="menu">
    </slot>
  </div>

</div>