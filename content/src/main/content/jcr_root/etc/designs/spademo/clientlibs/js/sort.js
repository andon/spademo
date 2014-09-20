aemspa.sort = function($, pager){

  function addClickHandler(handler) {
    $('.sortable').click(function(){
      var sortingDirection = $(this).data('sortdir');
      if(sortingDirection === 'none' || sortingDirection === 'asc'){
        sortingDirection = 'desc';
      } else {
        sortingDirection = 'asc';
      }
      
      var sortingCriteria = $(this).data('sort');
      $(this).addClass(sortingDirection);
      handler(pager.getCurrentPage(), sortingCriteria.toUpperCase(), sortingDirection.toUpperCase()); 
    });
  }
  
  function updateSortingIcons(sortingInfo) {
    $('.sortable').each(function(index, element) {
      var sortingCriteria = $(element).data('sort');
      if(sortingCriteria === sortingInfo.criteria.toLowerCase()){
        $(element).data('sortdir', sortingInfo.order.toLowerCase());
      } else {
        $(element).data('sortdir', 'none');
      }
      $(element).removeClass('none asc desc');
      $(element).addClass($(element).data('sortdir'));
    });
  }
  
  return {
    addClickHandler : addClickHandler,
    updateSortingIcons : updateSortingIcons
  }
  
}(jQuery, aemspa.pager);