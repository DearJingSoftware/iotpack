
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
  top:24px;
  position:absolute;
  width: 80px;
  left: -64px;
  box-shadow: 0px 2px 16px rgba(153,155,168,0.12);
  margin: 0px;
  padding: 0px;
  border: 2px solid rgba(153,155,168,0.12);
  background-color: white;
}
.handler_icon{
  border-radius: 50%;
  width: 24px;
  height: 24px;
}


.dropdown:hover .handler_icon {
  background-color: rgba(28,28,33,0.08)
}
.handler_icon:hover{
  background-color: rgba(28,28,33,0.08)
}
</style>

<div class="dropdown">
  <div class="handler_icon">
    <slot >
  
    </slot>
  </div>
  <div class="menu_warp">
    <slot name="menu">
    </slot>
  </div>

</div>