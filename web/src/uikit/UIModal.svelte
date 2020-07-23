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
    justify-content: center;
    justify-items: center;
    /* align-items: center; */
    backdrop-filter: saturate(180%) blur(1px);
    /* justify-self: center; */
  }
  .modal.hide {
      display:none;
  }
  .content {
    margin-top: 200px;
    min-width: 30vw;
    height: 100px;
    display: inline-block;
    background-color: white;
   
    border-radius: 4px;
  }
  .close i {
    font-size: 24px;
  }
  .title {
    display: flex;
    padding: 24px 20px;
    font-size: 25px;
  }
  .title .text {
    flex-grow: 1;
  }
  .body {
    padding: 25px;
    background-color: #F8FAFB;
  }

</style>
<div class="modal {show}">
  
  <div class="content">

  <div class="title">
    <div class="text">
      {title}
    </div>
    <div class="close">
    <i class="lar la-times-circle" on:click={handleClose}></i>
    </div>
  </div>
  <div class="body">
    <slot>
    </slot>
  </div>
  <div class="footer">
    
  </div>


  </div>
</div>