
<script>
export let placeholder='';
</script>

<style>
.form-input {
  width:0px;
  height: 0px;
}

.body {
  border: 1px dashed #E8ECEF;
  background-color: white;
  border-radius: 4px;
  display: flex;
  justify-content: center;
  justify-items: center;
  align-items: center;
  padding: 10px;
  cursor: pointer;
  color: #778ca2;
  min-height: 128px;
}
.body:hover {
 border: 1px dashed #4D7CFE;
}
</style>



<div class="body">
  <div><i class="las la-cloud-upload-alt"></i>拖放或者点击上传图片</div>
  <input type="file" class="form-input" placeholder="{placeholder}"/>
</div>