
<script>
export let status='default';
export let href='';

import { createEventDispatcher } from 'svelte';

  const dispatch = createEventDispatcher();
  
  function handleClick() {
		dispatch('click', {});
	}
</script>
<style>

  a {
    color:#4D7CFE ;
    font-weight: 600;
    font-size:12px;
    text-decoration: none;
  }
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
<a  href="{href}" class="{'button'+" "+status}" on:click={handleClick}>
  <slot>
  </slot>
</a>
