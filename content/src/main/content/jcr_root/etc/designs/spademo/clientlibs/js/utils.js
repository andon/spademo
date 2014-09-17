aemspa.utils = function($) {
  function isDefinedAndNotNull(variable) {
    var isDefined = typeof variable !== 'undefined';
    var isNotNull = variable !== null;
    return isDefined && isNotNull;
  }
  return {
    isDefinedAndNotNull : isDefinedAndNotNull
  }
}(jQuery);
