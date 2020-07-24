

<script>
  export var icon=true;
  export var href="";
  export var color="green";
</script>

<style>
a {
    position: relative;
}
i {
  font-size: 24px;
  line-height: 60px;

}
.msg {
  width: 10px;
  height: 10px;
  background-color: pink;
  border-radius: 50%;
  position: absolute;
  float: right;
  margin-top: -40px;
  margin-left: 18px
}
</style>

<div>
  <a href="{href}"><i class=" las {icon}"></i><div class="msg" style=" background-color:{color}"></div></a>
  
</div>