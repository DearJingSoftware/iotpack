
<script>
export let status='default';

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
</style>
<div class="{'button'+" "+status}" on:click={handleClick}>
<slot>

</slot>
</div>
