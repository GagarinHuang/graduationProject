var app = angular.module('teacherApp', ['usst.services']);
app.controller('teacherCtrl', function($scope, $http, utilService) {
    $scope.isShow = false;
    $scope.isShowQList = true;

    //动态添加 begin
    $scope.DATA = new Object();
    $scope.DATA.data = [{key: 0, value: $('#item0').val()}];
    // add
    $scope.add = function($index) {
        // 用时间戳作为每个item的key
        $scope.DATA.data.splice($index + 1, 0,{key: $index + 1, value: $('#item'+($index+1)).val()});
    }
    // delete
    $scope.deleteItem = function($index) {
        $scope.DATA.data.splice($index, 1);
    }
    // 结果
    function getItems() {
        var result = [];
        angular.forEach($scope.DATA.data, function(data) {
            result.push(data.value);
        });
        return result;
    };
    //动态添加 end

    $scope.loadView = function () {
        $scope.isShow = false;
        $scope.isShowQList = true;
        var action = $("#createBtn").text();
        if(action == '+'){
            utilService.initialize('/question').then(function (data) {
                //初始化question界面
                if(data.msg == "success"){
                    $scope.isShow = true;
                    $scope.isShowQList = false;
                    $scope.subjectList = data.subjectList;
                    $scope.examTypeList = data.examTypeList;
                    $scope.levelList = data.levelList;
                    $scope.question = data.question;
                    $("#createBtn").text('X');
                }
                else {
                    alert("server error");
                }
            });
        }
        else if(action == 'X'){
            $('#test').treegrid('reload');
            //TODO:显示display界面
            $("#createBtn").text('+');
        }
    }
    $scope.saveQuestion = function () {
        $scope.question.questionStatus = 0;
        $scope.question.items = getItems();
        createQuestion();
    }
    $scope.commitQuestion = function () {
        $scope.question.questionStatus = 3;
        createQuestion();
    }
    function createQuestion(){
        var formData = new FormData();
        angular.forEach($scope.question, function (value, key) {
            formData.append(key, value);
        });
        $http({
            method: "POST",
            url: "/question/create",
            headers: {'Content-Type': undefined},
            data: formData,
            transformRequest: angular.identity
        }).then(function successCallback(response) {
            // 请求成功执行代码
            for(var i=0;i<response.data.msgList;i++){
                console.log(response.data.msgList[0]);
            }
        }, function errorCallback(response) {
            alert( "服务器异常" );
        });
    }
});