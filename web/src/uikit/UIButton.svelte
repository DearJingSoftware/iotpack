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

/* //填充 
//边框色
//圆角 直角
//状态色 */
  .button {
    cursor: pointer;
  }
  .button:hover {
    color: #4D7CFE;
  }

  .button.primary {
    color: #4D7CFE;
  }

  .button.active {
     color: #4D7CFE;
  }
</style>
<div class="{'button'+" "+status}" on:click={handleClick} class:active>
  <slot>
  </slot>
</div>
