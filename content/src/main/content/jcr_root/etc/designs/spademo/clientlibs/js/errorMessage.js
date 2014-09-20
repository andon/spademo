aemspa.errorMessage = function($){
  
  function setErrorMessage(data){
    $('.errorMessage').text(data.errorMessage);
    $('.errorMessage').css('display', 'table');
  }
  
  return {
    setErrorMessage : setErrorMessage
  }
}(jQuery);