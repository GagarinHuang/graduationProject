//学生姓名等等验证没加
var app = angular.module('signupTApp', ['usst.services']);
app.controller('signupTCtrl', function($scope, $http, utilService, $q) {
    //const
    $scope.form1PostUrl    = "/userLogin/handleFieldChange";
    $scope.form2PostUrl    = "";
    $scope.form3PostUrl    = "";
    $scope.msgFieldSelect1 = 1;
    $scope.msgFieldSelect2 = 2;
    $scope.msgFieldSelect3 = 3;
    //variable
    $scope.fieldChangeMsg1 = "";
    $scope.fieldChangeMsg2 = "";
    $scope.fieldChangeMsg3 = "";

    //input 需要添加ng-change 才会触发此事件
    $scope.onFieldChange = function(url,fieldName,fieldValue,msgFieldSelect){
        $scope.fieldChangeMsg1 = "";
        $scope.fieldChangeMsg2 = "";
        $scope.fieldChangeMsg3 = "";

        if(msgFieldSelect == $scope.msgFieldSelect1){
            //添加发送请求前验证
            //验证手机号
            var pattern = /^1[34578]\d{9}$/;
            if(!pattern.test($('#usr_par').val())){
                $scope.fieldChangeMsg1 = "用户名为手机号，格式错误";
            };
            if($scope.fieldChangeMsg1 == ""){
                utilService.onFieldChange(url,fieldName,fieldValue).then(function (msg) {
                    $scope.fieldChangeMsg1 = msg;
                });
            }
            if($scope.fieldChangeMsg1 == ""){
                haveUnsolvedMsg = false;
            }
            else {
                haveUnsolvedMsg = true;
            }
        }
        else if(msgFieldSelect == $scope.msgFieldSelect2){
            var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
            if(!pattern.test($('#usr_stu').val())){
                $scope.fieldChangeMsg2 = "请输入中文";
            }
            if($scope.fieldChangeMsg2 == ""){
                utilService.onFieldChange(url,fieldName,fieldValue).then(function (msg) {
                    $scope.fieldChangeMsg2 = msg;
                });
            }
            if($scope.fieldChangeMsg2 == ""){
                haveUnsolvedMsg = true;
            }
            else {
                haveUnsolvedMsg = false;
            }
        }
        else if(msgFieldSelect == $scope.msgFieldSelect3){
            utilService.onFieldChange(url,fieldName,fieldValue).then(function (msg) {
                $scope.fieldChangeMsg3 = msg;
            });
            if($scope.fieldChangeMsg3 == ""){
                haveUnsolvedMsg = true;
            }
            else {
                haveUnsolvedMsg = false;
            }
        }
    }
    //click button 'next' of form1
    $scope.createUserLogin = function () {
        animating = false;
        isProcossedByServer = true;
        if(haveUnsolvedMsg != true){
            $scope.fieldChangeMsg1 = "";
            //add more mixed validation
            validForm1();
            if($scope.fieldChangeMsg1 != ""){
                isProcossedByServer = false;
            }
        }
        else {
            isProcossedByServer = false;
        }
    }
    $scope.createTeacherInformation = function () {
        animating = false;
        isProcossedByServer = true;
        $scope.fieldChangeMsg2 = "";
        if(haveUnsolvedMsg != true){
            $scope.fieldChangeMsg2 == "";
            //add more mixed validation
            validForm2();
            if($scope.fieldChangeMsg2 != ""){
                isProcossedByServer = false;
            }
        }
        else {
            isProcossedByServer = false;
        }
    }
    $scope.signup = function () {
        animating = false;
        isProcossedByServer = true;
        $scope.fieldChangeMsg3 = "";
        $scope.tUserDetail.dateOfBirth = $('#dateOfBirth').val();
        $scope.tUserDetail.affiliationId= $("#school").find("option:selected").attr("data-code");
        if(haveUnsolvedMsg != true){
            validForm3();
            if($scope.fieldChangeMsg3 == ""){
                //提交后台
                var promise = function () {
                    var deferred = $q.defer();
                    $http({
                        method: "POST",
                        url: "/tUserDetail/create",
                        params: {
                            json:{
                                tUserDetail : $scope.tUserDetail,
                                tUserLogin  : $scope.tUserLogin
                            }
                        }
                    }).then(function successCallback(response) {
                        // 请求成功执行代码
                        deferred.resolve(response.data);
                    }, function errorCallback(response) {
                        deferred.resolve("服务器异常");
                    });
                    return deferred.promise;
                }
                promise().then(function (data) {
                    if(data.msgList.length == 0) {
                        isProcossedByServer = true;
                    }
                    else {
                        isProcossedByServer = false;
                        for(var i = 0;i<data.msgList.length;i++){
                            //show error msg from server
                            alert(data.msgList[i]);
                        }
                    }
                });
            }
            else{
                isProcossedByServer = false;
            }
        }
        else{
            isProcossedByServer = false;
        }
    }
    function validForm2() {
        if($scope.fieldChangeMsg2 == "") {
            if ($('#t_name').val() == "" || $('#t_name').val() == null) {
                $scope.fieldChangeMsg2 = "学生姓名不能为空";
            }
        }
    }
    function validForm1() {
        if($scope.fieldChangeMsg1 == "") {
            if($('#usr_par').val() == "" || $('#usr_par').val() == null){
                $scope.fieldChangeMsg1 = "用户名不能为空";
            }
            else if($('#password1').val() == "" || $('#password1').val() == null){
                $scope.fieldChangeMsg1 = "密码不能为空";
            }
            else if($('#password1').val().length <5 || $('#password2').val().length <5){
                $scope.fieldChangeMsg1 = "密码最少为5位";
            }
            else if($('#password1').val() != $('#password2').val()){
                $scope.fieldChangeMsg1 = "两次密码不同";
            }
        }

    }
    function validForm3() {
        if($scope.fieldChangeMsg3 == "") {
            var schoolName = $("#school").val();
            if(schoolName == null || schoolName == ''|| schoolName == 'School') {
                $scope.fieldChangeMsg3 = "请选择学生所在学校";
            }
        }
    }
});