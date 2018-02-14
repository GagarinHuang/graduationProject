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
            }
            //add more util function
        }
    })