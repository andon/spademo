<%@include file="/libs/foundation/global.jsp"%>
<script type="text/html" id="pagingTemplate">
   <li data-template-bind='
      [{"attribute": "class", "value": ""}]'>
      <a href="#" data-content=""></a>
   </li>
</script>
<div class="pagingNumeric">
  <ul class="pagination">
  </ul>
</div>
<div class="pagingNextPrev">
  <ul class="pager">
    <li class="previousPage"><a href="#">Previous</a></li>
    <li class="nextPage"><a href="#">Next</a></li>
  </ul>
</div>