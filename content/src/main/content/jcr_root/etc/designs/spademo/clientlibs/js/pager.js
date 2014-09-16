aemspa.pager = function($){

  function updatePager(data, handler) {
    $(".pagination").loadTemplate($("#pagingTemplate"), data.pageNumbers);
    if(data.hasNext) {
      $('.nextPage').show();
    } else {
      $('.nextPage').hide();
    }
    
    if(data.hasPrev){
      $('.previousPage').show();
    } else {
      $('.previousPage').hide();
    }
    
    $('.pagingNumeric .pagination .' + data.currentPage).addClass('active');
  }
  
  return {
    updatePager : updatePager
  }
  
}(jQuery);