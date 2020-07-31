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
