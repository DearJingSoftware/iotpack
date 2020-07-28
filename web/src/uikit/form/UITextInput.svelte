
<script>
	import { createEventDispatcher } from 'svelte';

	const dispatch = createEventDispatcher();
export let placeholder='';
export let value='';
</script>

<style>
.form-input {
  width: 100%;
  outline: none;
  border: none;
  padding: 0;
  margin: 0px;
  height: 22px;
  font-size: 14px;
}

.body {
  border: 1px solid #E8ECEF;
  background-color: white;
  border-radius: 4px;
  display: flex;
  justify-content: center;
  justify-items: center;
  align-items: center;
  padding: 10px;
}

.body:hover {
 border: 1px solid #4D7CFE;
}
</style>


<div class="body">
  <input type="text" class="form-input" placeholder="{placeholder}" bind:value={value}/>
</div>
