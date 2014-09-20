aemspa.errorHandling = (function($, utils, errorMessage) {
  $.ajaxPrefilter(function(options, originalOptions, jqXHR) {
    addCustomAjaxHeader(jqXHR);
    wrapSuccessHandlerWithErrorHandler(options, originalOptions, jqXHR);
  });
  function addCustomAjaxHeader(jqXHR) {
    jqXHR.setRequestHeader('X-Request-Source', 'spa-ajax');
  }
  function wrapSuccessHandlerWithErrorHandler(options, originalOptions, jqXHR) {
    var originalSuccessHandler = options.success;
    options.success = function(data, textStatus, jqXHR) {
      $('.errorMessage').css('display', 'none');
      if (responseHasError(data)) {
        if (responseHasErrorMessage(data)) {
          displayErrorMessage(data);
          executeErrorHandlers(options.error, jqXHR);
          return;
        }
        if (reponseHasRedirectoToErrorPage(data)) {
          redirectToErrorPage(data);
          return;
        }
      } else {
        executeSuccessHandlers(originalSuccessHandler, data, textStatus, jqXHR);
      }
    };
  }
  function responseHasError(data) {
    return utils.isDefinedAndNotNull(data)
        && (responseHasErrorMessage(data) || reponseHasRedirectoToErrorPage(data));
  }
  function responseHasErrorMessage(data) {
    return utils.isDefinedAndNotNull(data.errorMessage);
  }
  function reponseHasRedirectoToErrorPage(data) {
    return utils.isDefinedAndNotNull(data.errorUrl);
  }
  function displayErrorMessage(data) {
    errorMessage.setErrorMessage(data);
  }
  function redirectToErrorPage(data) {
    window.location.href = data.errorUrl;
  }
  function executeErrorHandlers(errorHandlers, jqXHR) {
    var textStatus = "error";
    var errorThrown = "Backend not available";
    if (typeof errorHandlers === 'function') {
      errorHandlers(jqXHR, textStatus, errorThrown);
    } else if (errorHandlers instanceof Array) {
      $.each(errorHandlers, function(index, handler) {
        handler(jqXHR, textStatus, errorThrown);
      });
    }
  }
  function executeSuccessHandlers(successHandlers, data, textStatus, jqXHR) {
    if (typeof successHandlers === 'function') {
      successHandlers(data, textStatus, jqXHR);
    } else if (successHandlers instanceof Array) {
      $.each(successHandlers, function(index, handler) {
        handler(data, textStatus, jqXHR);
      });
    }
  }
  return {};
}(jQuery, aemspa.utils, aemspa.errorMessage));
