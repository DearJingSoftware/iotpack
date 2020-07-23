
<script>
	function handleClick(event) {
		console.log("搜索")
	}
</script>


<div class="search_box">
  <i class="las la-search"></i>
	<input class="search-input" placeholder="搜索任务/项目/组织/应用">
</div>

<style>

.search-input {
  border: none;
  padding: 10px;
}

.search-input:focus{
    outline: none;
}
.search_box {
    height: 60px;
    display: flex;
    justify-items: center;
    align-items: center;
		text-decoration: none;
    text-align: right;
}

.search_box i {
  font-size: 24px;
}
input[placeholder], [placeholder], *[placeholder] { 
  color:#778CA2 !important; 
}
</style>