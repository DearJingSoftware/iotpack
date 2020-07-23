<style>
.header {
  background-color: #F8FAFB;
}
.tool {
  padding: 20px 0px;
  display: flex
}
.tool .left {
  flex-grow: 1;
}
</style>

<div class="page">

  <div class="header">
      <slot name="page-header">
        
      </slot>
      <div class="tool">
        <div class="left">
          <slot name="header-left">
          left
          </slot>
        </div>
        <div class="right">
          <slot name="header-right">
            right
          </slot>
        </div>
      </div>
     
  </div>

  <div class="body">
  <slot>
  </slot>
  </div>
  
  <div class="footer">
    <slot name="footer">
          
    </slot>
  </div>
</div>