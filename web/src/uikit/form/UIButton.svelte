
<script>
import { createEventDispatcher } from 'svelte';
const dispatch = createEventDispatcher();
</script>

<style>
.form-button {
  min-width: 80px;
  outline: none;
  border: none;
  padding: 0px 10px;
  margin: 5px 0px;
  font-size: 14px;
  text-align: center;
  background-color: #4D7CFE;
  color: white;
  height: 46px;
  border-radius: 4px;
  line-height:46px;
  cursor: pointer;
  }
</style>


<div class="form-button" on:click>
<slot>
</slot>
</div>