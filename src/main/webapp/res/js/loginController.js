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
                    var roleId = response.data.roleId;
                    if(roleId == 0){
                        //管理员
                    }
                    else if(roleId == 1){
                        //家长界面
                    }
                    else if(roleId ==2){
                        //学生界面
                    }
                    else if(roleId ==3){
                        //老师界面,待修改
                        window.location.href = '/question/fetch?questionId=q0000000000439468468';
                    }
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