
<script>
  export var align="center";
</script>
<style>
  .wrap {
    display: flex;
    justify-content: center;
  }
  .pagination {
    display: flex;
    list-style: none;
  }
  
  .pagination li {
    line-height: 40px;
    cursor: pointer;
  }
  .prev {
    margin-right: 10px;
  }
  .next {
    margin-left: 10px;
  }
  .prev ,.next {
      color: #778ca2;
  }

  .pagination .page_num {
    line-height: 40px;
    width: 40px;
    height: 40px;
    text-align: center;
  }

  .pagination .page_num.active{
    background-color: #4d7cfe;
    color: white;
    border-radius: 4px;
   
  }
</style>
<div class="wrap" style="justify-content:{align}">
  <ul  class="pagination">
    <li class="prev">
   <i class="las la-angle-left"></i> Prev
    </li>
    <li class="page_num active">
      1
    </li>
     <li class="page_num">
      2
    </li>
     <li class="page_num">
      3
    </li>
     <li class="page_num">
      4
    </li>
     <li class="page_num">
      5
    </li>
     <li class="next">
    Next <i class="las la-angle-right"></i>
    </li>
  <ul>
</div>