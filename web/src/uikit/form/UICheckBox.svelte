
<script>
export let href='';
export let value=false
import { createEventDispatcher } from 'svelte';
const dispatch = createEventDispatcher();
</script>

<style>
.form-checkbox {
  font-size:12px;
  display:flex;
}
a {
  text-decoration: none;
}
</style>


<div class="form-checkbox">
  <input type="checkbox" checked={!!value} on:change/>
  <a href="{href}">
    <slot>
    </slot>
  </a>
</div>

