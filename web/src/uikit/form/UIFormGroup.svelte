
<script>
export let title='';
</script>

<style>
.group{
  display: flex;
  flex-direction: column;
  margin: 10px 0px;
}
.label {
  font-size: 16px;
  height: 32px;
}

</style>
<div class="group">
  {#if title!==""}
  <div class="label">
      {title}
  </div>
  {/if}
  <slot>
  </slot>
  <!-- <div class="help">
      提示信息
  </div> -->
</div>