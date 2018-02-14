<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2018/2/8
  Time: 03:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MAPS|A TEST ONLINE WEBSITE</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../res/css/bootstrap.min.css">
    <link rel="stylesheet" href="../res/css/animate.css">
    <link rel="stylesheet" href="../res/css/style_login_stu.css">
</head>

<body class="style-3">
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-push-8" ng-app="loginApp" ng-controller="loginCtrl" >
            <!--angular animate效果没有-->
            <form action="#"
                  class="ls-form animate-box" data-animate-effect="fadeInRight">
                <h2>Sign In</h2>
                <div class="form-group">
                    <label for="userId" class="sr-only">Username</label>
                    <input type="text" class="form-control"
                           error-message
                           <%--title="输入的字符为8-16位"--%>
                           maxlength="30"
                           <%--pattern="[0-9A-Za-z]{8,16}"--%>
                           ng-model="userLogin.userId" id="userId"
                           placeholder="UserId"
                           required>
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" class="form-control" id="password"
                           error-message
                           maxlength="30"
                           ng-model="userLogin.userPassword"
                           placeholder="Password"
                           required>
                </div>
                <div>
                    <span ng-model="message" style="color:red">{{message}}</span>
                </div>
                <div class="form-group">
                    <label for="remember"><input type="checkbox" id="remember"> Remember Me</label>
                </div>
                <div class="form-group">
                    <input type="button" value="Sign In" ng-click="login()" class="btn btn-success btn-lg">
                    <input type="button" value="Forget" class="btn btn-danger btn-lg">
                </div>
            </form>


        </div>
    </div>
</div>

<!-- js -->
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
<%--<script src="https://cdn.bootcss.com/angular-ui-bootstrap/2.5.0/ui-bootstrap-tpls.js"></script>--%>
<script src="../res/js/utilityDirective.js"></script>
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular-animate.min.js"></script>
<script src="../res/js/loginController.js"></script>
<script src="../res/js/jquery.min.js"></script>
<script src="../res/js/bootstrap.min.js"></script>
<script src="../res/js/jquery.placeholder.min.js"></script>
<script src="../res/js/jquery.waypoints.min.js"></script>
<script src="../res/js/animate.js"></script>
<script src="../res/js/modernizr.custom.js"></script>


</body>
</html>
