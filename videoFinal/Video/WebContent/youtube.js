
app.filter('trustUrl', function($sce) {
  return function(url) {
    return $sce.trustAsResourceUrl(url);
  };
});


app.directive('youtubeHelp', function() {
  return {
    restrict: 'E',
    scope: {
      header: '@',
      video: '@'
    },
    transclude: true,
    replace: true,
    template: '<iframe ng-src="{{video | trustUrl}}" allowfullscreen="allowfullscreen"></iframe>',
    link: function(scope, element, attrs) {
      scope.header = attrs.header;
   
    
    }
  };
});
