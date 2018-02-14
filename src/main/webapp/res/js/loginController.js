var app = angular.module('loginApp', []);
app.controller('loginCtrl', function($scope, $http) {
    $scope.login = function(){
            validLoginForm();
            $http({
                method: "POST",
                url: "/userLogin/login",
                data: $scope.userLogin,
            }).then(function successCallback(response) {
                // 请求成功执行代码

                if(response.data.result === false)
                    $scope.message = "用户名或者密码错误";
                else {
                    $scope.message = "登陆成功！";
                    //跳入界面
                }
            }, function errorCallback(response) {
                $scope.message = "服务器异常";
            });
    };
    function validLoginForm() {
        var isValid = true;
        if($('#username').val()== "" || $('#username').val()== null ){
            isValid = false;
        }
        else if($('#password').val()== "" || $('#password').val()== null){
            isValid = false;
        }
        return isValid;
    }
});