
<script>
export let href='';
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
  <input type="checkbox"/>

  <a href="{href}">
    <slot>
    </slot>
  </a>
</div>

