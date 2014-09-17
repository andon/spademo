aemspa.scheduletable = function($, pager, sort){
  var urlParams;
  
  function init(params){
    urlParams = params;
    sort.addClickHandler(sortResults);
    getPage(1);
  }
  
  function getPage(pageNumber) {
    $.ajax({
      url: urlParams.getPageContentUrl,
      data: {
        _charset_: 'UTF-8',
        pageNumber: pageNumber
      },
      type: 'POST',
      dataType: 'json',
      success: function(data){
        updateTable(data);
        pager.updatePager(data.pagingInfo, aemspa.scheduletable.getPage);
      }
    });
  }
  
  function sortResults(sortCriteria, sortDirection) {
    $.ajax({
      url: urlParams.sortDataUrl,
      data: {
        _charset_: 'UTF-8',
        sort: sortCriteria,
        sortDirection: sortDirection
      },
      type: 'POST',
      dataType: 'json',
      success: function(data){
        updateTable(data);
        pager.updatePager(data.pagingInfo, aemspa.scheduletable.getPage);
        sort.updateSortingIcons(data.sortingInfo);
      }
    });
  }
  
  function updateTable(data) {
    $('.conferenceDate').text(data.schedule.date);
    $("#adaptToTalks tbody").loadTemplate($("#scheduleTemplate"), data.schedule.talks);
  }
  
  return{
    init : init,
    getPage : getPage
  }
}(jQuery, aemspa.pager, aemspa.sort);