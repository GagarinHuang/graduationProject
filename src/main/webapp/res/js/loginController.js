var app = angular.module('loginApp', []);
app.controller('loginCtrl', function($scope, $http) {
    $scope.message = "点击登陆！";
    $scope.userLogin = {
        userId : "test",
        userPassword : "test"
    };

    $scope.login = function(){
        $http({
            method: "POST",
            url: "/userLogin/login",
            data: $scope.userLogin,
        }).then(function successCallback(response) {
            // 请求成功执行代码
            alert(response.data.result);
            $scope.message = response.data.result;
        }, function errorCallback(response) {
            alert(response);
        });
    };
});