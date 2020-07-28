<script>
export let size='48';
export let src='';
//circle
export let style='circle';
</script>
<style>
  .big {
    width: 128px;
    height: 128px;
  }
  
  .middle {
    width: 64px;
    height: 64px;
  }
  
  .small {
    width: 32px;
    height: 32px;
  }

  .square {

  }
  
  .round {
    border-radius: 4px;
  }
  
  .circle {
    border: 50%;
  }

  img {
    width: 100%;
    height: 100%;
  }

</style>
<div class="{style}" style="width:{size}px;height:{size}px" >
  <img {src} alt="avatar"/>
</div>