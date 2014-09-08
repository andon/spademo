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
<h3 class="conferenceDate"></h3>
<table class="table table-striped" id="adaptToTalks">
  <thead>
    <tr>
      <th>
         <span class="sortable down">
            Time
            <span class="icon-sort"></span>
            <span class="icon-sort-up"></span>
            <span class="icon-sort-down"></span>
         </span>
      </th>
      <th>
         <span class="sortable none">
             Talk
             <span class="icon-sort"></span>
             <span class="icon-sort-up"></span>
             <span class="icon-sort-down"></span>
         </span>
      </th>
      <th>
         <span class="sortable none">
           Speakers
           <span class="icon-sort"></span>
           <span class="icon-sort-up"></span>
           <span class="icon-sort-down"></span>
         </span>
      </th>
    </tr>
  </thead>
  <tbody>
  </tbody>
</table>
<cq:include resourceType="spademo/components/pager" path="pager" />
</div>
<script type="text/javascript">
    aemspa.scheduletable.init({
      getPageContentUrl: '',
      sortByUrl: '',
    });
</script>