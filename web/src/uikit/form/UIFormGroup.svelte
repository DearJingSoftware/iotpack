
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
.body {
  border: 2px solid #E8ECEF;
  background-color: white;
  border-radius: 4px;
  display: flex;
  justify-content: center;
  justify-items: center;
  align-items: center;
  padding: 10px;
}
</style>
<div class="group">

  <div class="label">
      {title}
  </div>
  <div class="body">
    <slot>
    </slot>
  </div>
  <!-- <div class="help">
      提示信息
  </div> -->
</div>