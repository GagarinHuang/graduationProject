<%@ page pageEncoding="UTF-8" %>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <ul class="nav nav-pills">
                <li class="active">
                    <a id="createBtn" href="" ng-click="loadView()">+</a>
                </li>
                <li  class="disabled">
                    <a href="#">组织考试</a>
                </li>
                <li>
                    <a href="#">报告</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                        ${sessionScope.userId}<strong class="caret"></strong>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">个人中心</a>
                        </li>
                        <li>
                            <a href="#">退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

</div>