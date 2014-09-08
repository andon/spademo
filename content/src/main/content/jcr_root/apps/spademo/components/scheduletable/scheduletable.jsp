<%@include file="/libs/foundation/global.jsp"%>
<script type="text/html" id="scheduleTemplate">
  <tr>
      <td data-content="time"></td>
      <td data-content="title"></td>
      <td data-content="speakers"></td>
    </tr>
</script>
<div>
<h2>Addapt To 2014 schedule</h2>
<table class="table table-striped" id="adaptToTalks">
  <thead>
    <tr>
      <th>Time</th>
      <th>Talk</th>
      <th>Speakers</th>
    </tr>
  </thead>
  <tbody>
  </tbody>
</table>
  <ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">&raquo;</a></li>
  </ul>
</div>
<script type="text/javascript">
    aemspa.scheduletable.init({
      getPageContentUrl: '',
      sortByUrl: '',
    });
</script>