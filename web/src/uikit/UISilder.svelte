<script>
import { createEventDispatcher } from 'svelte';
export var show='hide';
  export var title='';
  const dispatch = createEventDispatcher();
  
  function handleClose() {
    console.log("关闭")
    show='hide'
		dispatch('close', {});
  }
  
  function handleContentClose(e) {
    e.stopPropagation();
	}

</script>
<style>


  .modal {
    position: fixed;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    width: 100vw;
    height: 100vh;
    background-color: #33333333 ;
    display: flex;
    justify-content: flex-end;
    justify-items: center;
    z-index:1000;
  }
  .modal.hide {
      display:none;
  }
  .content {
    z-index: 1001;
    min-width: 30vw;
    height: 100vh;
    display: flex;
    flex-direction: column;
    background-color: white;
  }

  .more i {
    font-size: 24px;
  }

  .title {
    display: flex;
    padding: 24px 20px;
    font-size: 16px;
  }
  .title .text {
    flex-grow: 1;
  }
  .body {
    flex-grow: 1;
    padding: 24px;
    background-color: #F8FAFB;
  }

</style>
<div class="modal {show}" on:click={handleClose}>
  
  <div class="content" on:click={handleContentClose}>

  <div class="title">
    <div class="text">
      {title}
    </div>
    <div class="more">
      <i class="las la-ellipsis-h"></i>
    </div>
  </div>
  <div class="body">
    <slot>
    </slot>
  </div>
  <slot name="footer">
    底部菜单
  </slot>


  </div>
</div>