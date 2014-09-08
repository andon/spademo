aemspa.pager = function($){

  function updatePager(data) {
    // pagingInfo: {
    // pageNumbers: [1, 2, 3],
    // currentPage: 1,
    // hasNext: true,
    // hasPrev: false
    //}
    $(".pagination").loadTemplate($("#pagingTemplate"), data.pageNumbers);
  }
  
  return {
    updatePager : updatePager
  }
  
}(jQuery);