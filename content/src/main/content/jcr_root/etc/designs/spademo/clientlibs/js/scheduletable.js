aemspa.scheduletable = function($, pager){
  var params;
  
  function init(params){
    this.params = params;
    getPage(0);
  }
  
  function getPage(pageNumber) {
    //$.ajax();
    var data = {
        schedule: {
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
           date: '24.09.2014'
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
    pager.updatePager(data.pagingInfo);
  }
  
  function updateTable(data) {
    $('.conferenceDate').text(data.schedule.date);
    $("#adaptToTalks tbody").loadTemplate($("#scheduleTemplate"), data.schedule.talks);
  }
  
  return{
    init:init
  }
}(jQuery, aemspa.pager);