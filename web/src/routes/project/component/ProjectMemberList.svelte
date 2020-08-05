<script>
	import Avatar from "../../../uikit/Avatar.svelte";
</script>

<style>
  .group{
    display: flex;
  }
  img{
    background-color: white;
  }
  .counter {
    width: 36px;
    height: 36px;
    line-height: 36px;
    border-radius: 50%;
    background-color: #98a9bc;
    color:#98a9bc;
    border: solid 1px #ffffff;
    background: #f2f4f6;
    box-shadow: 0px 2px 16px rgba(153,155,168,0.12);
  }
  .avatar {
    border: solid 1px #ffffff;
    width: 36px;
    height: 36px;
    border-radius: 50%;
    margin-left: -10px;
  }
</style>

<div class="group">
  <img src="/img/arduino.png" alt="avatar"  class="avatar"/>
  <img src="/img/raspberrypi.png" alt="avatar"  class="avatar"/>
  <img src="/img/arduino.png" alt="avatar"  class="avatar"/>
  <img src="/img/raspberrypi.png" alt="avatar"  class="avatar"/>
  <img src="/img/raspberrypi.png" alt="avatar"  class="avatar"/>
  <div class="counter avatar">+20</div>
</div>