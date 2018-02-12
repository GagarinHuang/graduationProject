/*utilityDirective.js
* user to define shared directive
* */
var utilityDirective = angular.module("utilityDirective", []);
utilityDirective.directive('errorMessage', ['$compile', function($compile) {
    // Runs during compile
    return {
        restrict: 'A',
        require: 'ngModel',
        scope:{
            title:'@'
        },
        link: function(scope, element, attr, ngModel) {
            var parenNode = element.parent();
            var origin_placeholder = element[0].placeholder;
            parenNode.addClass("has-feedback");

            var subScope = scope.$new(true);
            subScope.errorsText={
                required:"不能为空",
                pattern:scope.title
            }
            subScope.hasError=function(){
                var re=(ngModel.$$parentForm.$submitted||ngModel.$dirty)&&ngModel.$invalid;
                if(re){
                    element[0].placeholder = "不能为空";
                    parenNode.addClass("has-error");
                }else{
                    parenNode.removeClass("has-error");
                }
                return re;
            }

            subScope.errors=function(){
                return ngModel.$error;
            }


            var errorElement = $compile('' +
                '<span ng-if="hasError()" class="glyphicon glyphicon-warning-sign form-control-feedback" ></span>')
                // '<ul class="help-block" ng-if="hasError()">' +
                // '<li style="list-style-type:none;" ng-repeat="(error,wrong) in errors()" ng-bind="errorsText[error]">' +
                // '</ul>')
                (subScope);
            element.after(errorElement);
        }
    };


}]);