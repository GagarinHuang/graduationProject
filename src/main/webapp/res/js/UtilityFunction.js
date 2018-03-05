angular.module('usst.services', [])
    .factory('utilService', function($http,$q) {
        return {
            onFieldChange:function(url,fieldName,fieldValue){
                var deferred = $q.defer();
                $http({
                    method: "POST",
                    url: url,
                    params: {
                        "fieldName"  : fieldName,
                        "fieldValue" : fieldValue
                    }
                }).then(function successCallback(response) {
                    // 请求成功执行代码
                    deferred.resolve(response.data.msg);
                }, function errorCallback(response) {
                    deferred.resolve("服务器异常");
                });
                return deferred.promise;
            },
            //add more util function
            initialize:function(moduleName){
                var deferred = $q.defer();
                $http({
                    method: "GET",
                    url: moduleName + '/initialize',
                }).then(function successCallback(response) {
                    // 请求成功执行代码
                    deferred.resolve(response.data);
                }, function errorCallback(response) {
                    deferred.resolve("server error");
                });
                return deferred.promise;
            }
        }
    })
    // .directive("fileread", [function () {
    //     return {
    //         scope: {
    //             fileread: "="
    //         },
    //         link: function (scope, element, attributes) {
    //             element.bind("change", function (changeEvent) {
    //                 var reader = new FileReader();
    //                 reader.onload = function (loadEvent) {
    //                     scope.$apply(function () {
    //                         scope.fileread = loadEvent.target.result;
    //                     });
    //                 }
    //                 reader.readAsDataURL(changeEvent.target.files[0]);
    //             });
    //         }
    //     }
    // }]);
    .directive( "fileModel", [ "$parse", function( $parse ){
        return {
            restrict: "A",
            link: function( scope, element, attrs ){
                var model = $parse( attrs.fileModel );
                var modelSetter = model.assign;

                element.bind( "change", function(){
                    scope.$apply( function(){
                        modelSetter( scope, element[0].files[0] );
                        // console.log( scope );
                    } )
                } )
            }
        }
    }])
