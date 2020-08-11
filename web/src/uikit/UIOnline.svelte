<script>
export let is_online={};
</script>

<style>
.online{
  color: green;
}
.offline{
  color: red;
}
</style>
<i class=" {is_online?'fas fa-circle online':'lar la-circle offline'}"></i>