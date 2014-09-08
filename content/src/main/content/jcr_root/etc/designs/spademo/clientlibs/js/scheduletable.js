aemspa.scheduletable = function($){
  var params;
  
  function init(params){
    this.params = params;
    getPage(0);
  }
  
  function getPage(pageNumber) {
    //$.ajax();
    var data = {
        entries: {
          talks: [
             {
               time: '10:00 - 10:30',
               title: 'Dynamic Components using Single-Page-Application Concepts',
               speakers: 'Andon Sikavica, Bojana Popovska'
             },
             {
               time: '10:30 - 10:45',
               title: 'Break',
               speakers: ''
             }
          ],
          total: 20
        },
        pagingInfo: {
          pageNumbers: [1, 2, 3],
          currentPage: 1,
          hasNext: true,
          hasPrev: false
        },
        sortingInfo: {
          criteria: 'date',
          order: 'asc'
        }
    };
    updateTable(data);
  }
  
  function updateTable(data){
    $("#adaptToTalks tbody").loadTemplate($("#scheduleTemplate"), data.entries.talks);
  }
  
  return{
    init:init
  }
}(jQuery);