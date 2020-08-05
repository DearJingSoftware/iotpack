  <script>
  export let data=[];
  </script>
  <style>
    ul ,li {
      margin: 0px;
      padding: 0px;
      text-align: left;
      list-style: none;
    }
    li {
      margin: 10px;
    }
    ul a ,li a {
      text-decoration: none;
    }
    li:hover{
        color: #4D7CFE;
    }
    li .icon {
      margin-right: 10px;
    }
  </style>
  
  <ul>
    {#each data as d}
			<li><i class="icon {d.icon}"></i><a  href="javascript:void(0)">{d.name}</a></li>
    {/each}
	</ul>