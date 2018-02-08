<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2018/2/8
  Time: 03:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MAPS|A TEST ONLINE WEBSITE</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../res/css/bootstrap.min.css">
    <link rel="stylesheet" href="../res/css/form-elements.css">
    <link rel="stylesheet" href="../res/css/login_ad.css">
    <!-- fontawsome -->
    <script src="https://use.fontawesome.com/61a9ff3a07.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong><img src="../res/images/logo.png" width="100"></strong></h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>后台登录</h3>
                            <p>Test Online后台管理系统</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="" method="" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="myusername" placeholder="Username" class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="mypassword" placeholder="Password" class="form-password form-control" id="form-password">
                            </div>
                            <label>
                                <input type="radio" name="kind" value="admin"/>admin
                            </label>
                            <label>
                                <input type="radio" name="kind" value="teacher"/>teacher
                            </label>
                            <button type="submit" class="btn">Log in</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>


<!-- js-->
<script src="../res/js/jquery.min.js"></script>
<script src="../res/js/bootstrap.min.js"></script>

</body>

</html>