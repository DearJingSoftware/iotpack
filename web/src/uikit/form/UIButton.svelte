
<script>
import { createEventDispatcher } from 'svelte';
const dispatch = createEventDispatcher();
</script>

<style>
.form-button {
  width: 100%;
  outline: none;
  border: none;
  padding: 0;
  margin: 0px;
  height: 22px;
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