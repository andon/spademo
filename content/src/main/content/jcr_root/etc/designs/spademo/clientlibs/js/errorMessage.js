aemspa.errorMessage = function($){
  
  function setErrorMessage(data){
    $('.errorMessage').text(data.errorMessage);
  }
  
  return {
    setErrorMessage : setErrorMessage
  }
}(jQuery);