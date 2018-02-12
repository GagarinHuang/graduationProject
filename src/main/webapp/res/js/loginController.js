var app = angular.module('loginApp', ['utilityDirective']);
//或许要加'ui.bootstrap'?
app.controller('loginCtrl', function($scope, $http) {
    $scope.login = function(){
        if($scope.userLogin.$invalid) {
            $scope.userLogin.$setSubmitted(true);
        }
        else {
            $scope.userLogin = {
                userId : $scope.userId,
                userPassword : $scope.userPassword
            };
            $http({
                method: "POST",
                url: "/userLogin/login",
                data: $scope.userLogin,
            }).then(function successCallback(response) {
                // 请求成功执行代码

                if(response.data.result === false)
                    $scope.message = "用户名或者密码错误";
                else {
                    //跳入界面
                }
            }, function errorCallback(response) {
                $scope.message = "服务器异常";
            });
        }

    };
});
