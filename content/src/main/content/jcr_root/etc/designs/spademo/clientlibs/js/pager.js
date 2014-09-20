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
    
    $('.pagination li').click(function(){
      handler($(this).attr('class'));
    });
    
    $('.previousPage').click(function(){
      handler(data.currentPage - 1);
    });
    
    $('.nextPage').click(function(){
      handler(data.currentPage + 1);
    });
  }
  
  function getCurrentPage(){
    return $('.pagingNumeric .pagination .active a').text();
  }
  
  
  return {
    updatePager : updatePager,
    getCurrentPage : getCurrentPage
  }
  
}(jQuery);