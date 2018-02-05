<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div ng-app="loginApp" ng-controller="loginCtrl">

    名: <input type="text" ng-model="userId"><br>
    姓: <input type="text" ng-model="userPassword"><br>
    <br>
    {{message}}
    <button ng-click="login()">登录</button>

</div>
</body>
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script src="/res/js/loginController.js"></script>
</html>
