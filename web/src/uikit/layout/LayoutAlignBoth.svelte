<style>

.layout_align_both {
  display: flex;
  justify-content: space-between;
}
</style>

<div class="layout_align_both">
  <slot name="left"></slot>
  <slot></slot>
  <slot name="right"></slot>
</div>