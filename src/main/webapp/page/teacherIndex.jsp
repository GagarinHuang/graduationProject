<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- CSS -->
    <link href="../res/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../res/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="../res/css/icon.css">
    <link rel="stylesheet" type="text/css" href="../res/css/demo.css">
    <!-- 图片上传即使预览插件 -->
    <link rel="stylesheet"
          href="../res/css/fileinput.min.css">
    <title>教师端首页</title>
    <style>
        .row {
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .vertical-center{
            position: relative;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span12" ng-app="teacherApp" ng-controller="teacherCtrl">
            <div>
                <!-- 老师端导航栏-->
                <%@include file="/page/teacherNav.jsp"%>
            </div>
            <div id="questionTest" ng-show="false">
               ${requestScope.question.subjectId}
                   ${requestScope.question.semester}
                ${requestScope.question.questionId}
                <img src="${pageContext.request.contextPath}/question/fetchAttach?fieldName=attachDescription&questionId=${requestScope.question.questionId}"/>
            </div>
            <div id="qList" ng-show="isShowQList">
                <%@include file="/page/checkbox.html"%>
            </div>
            <div id="content" ng-show="isShow">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">学科</label>
                            <div class="col-sm-2">
                                <select class="form-control"  ng-model="question.subjectId">
                                    <option value="">请选择</option>
                                    <option ng-value="subject.subjectId" ng-repeat="subject in subjectList" >
                                        {{subject.subjectName}}
                                    </option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">单元</label>
                            <div class="col-sm-2">
                                <select class="form-control" ng-model="question.unit">
                                    <option value="">请选择</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>

                            <label class="col-sm-1 control-label">章节</label>
                            <div class="col-sm-2">
                                <select class="form-control" ng-model="question.chapter">
                                    <option value="">请选择</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">年级</label>
                            <div class="col-sm-2">
                                <select class="form-control" ng-model="question.levelId">
                                    <option value="">请选择</option>
                                    <option ng-value="level.levelId" ng-repeat="level in levelList" >
                                        {{level.levelName}}
                                    </option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">学期</label>
                            <div class="col-sm-2">
                                <select class="form-control" ng-model="question.semester">
                                    <option value="">请选择</option>
                                    <option value="1">第一学期</option>
                                    <option value="2">第二学期</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">考试类型</label>
                            <div class="col-sm-2">
                                <select class="form-control" ng-model="question.examTypeId">
                                    <option value="">请选择</option>
                                    <option ng-value="et.examTypeId" ng-repeat="et in examTypeList">
                                        {{et.examTypeName}}
                                    </option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">分值</label>
                            <div class="col-sm-1">
                                <input type="text" class="form-control"
                                       ng-model="question.grade" maxlength="2"/>
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <button class="btn btn-default" type="button">
                                    单选题
                                </button>
                                <button class="btn btn-default" type="button">
                                    多选题
                                </button>
                                <button class="btn btn-default" type="button">
                                    More
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">题目</label>
                            <div class="col-sm-4">
                                <textarea class="form-control col-sm-10" rows="6"
                                          ng-model="question.description"
                                          name="describ" placeholder="题目详述"></textarea>
                            </div>
                            <label class="col-sm-1 control-label">题目附件</label>
                            <div class="col-sm-4">
                                <input type="file" data-ref="url2"
                                       file-model="question.attachDescriptionFile"
                                       class="col-sm-10 myfile" value="" /> <input type="hidden"
                                                                                   name="url2" value="">
                            </div>
                        </div>
                    </div>
                    <div ng-repeat="item in DATA.data">
                        <div class="row clearfix">

                            <div class="form-group">

                                    <label class="col-sm-1" >{{$index + 1}}</label>
                                    <div class="col-sm-4">
                                    <textarea class="form-control col-sm-10" rows="6"
                                              ng-model="item.value" id="item{{$index}}"
                                              name="describ" placeholder="选项内容"></textarea>
                                    </div>
                                    <label class="col-sm-1 control-label">选项附件</label>
                                    <div class="col-sm-4">
                                        <input type="file" data-ref="url2" file-model="question.attachAFile"
                                               class="col-sm-10 myfile" value="" />
                                        <input type="hidden" name="url2" value="">
                                    </div>
                                    <div class="col-sm-1">
                                        <input type="button" ng-click="add($index)" ng-show="DATA.data.length<5 && $index == DATA.data.length-1"
                                            class="btn btn-primary" value="+">
                                    </div>
                                    <div>
                                        <input type="button" ng-show="DATA.data.length>1" class="btn btn-primary"
                                                ng-click="deleteItem($index)" value="-">
                                    </div>

                            </div>
                        </div>

                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">正确答案</label>
                            <div class="col-sm-4">
                                <input type="radio" name="key" ng-checked="true" ng-model="question.answer">A
                                <input type="radio" name="key" ng-model="question.answer">B
                                <input type="radio" name="key" ng-model="question.answer">C
                                <input type="radio" name="key" ng-model="question.answer">D
                                <input type="radio" name="key" ng-model="question.answer">E
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <!--根据选项个数显示相应答案选项个数-->
                        <div class="form-group">
                            <label class="col-sm-1 control-label">题目解析</label>
                            <div class="col-sm-4">
                                <textarea class="form-control col-sm-10" rows="6" ng-model="question.explanation"
                                          name="describ" placeholder="题目解析"></textarea>
                            </div>
                            <label class="col-sm-1 control-label">题目解析附件</label>
                            <div class="col-sm-4">
                                <input type="file" data-ref="url2" file-model="question.attachExplanationFile"
                                       class="col-sm-10 myfile" value="" />
                                <input type="hidden" name="url2" value="">
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <!--根据状态disable button-->
                            <div class="col-sm-4 pull-right">
                                <input type="button" value="保存" class="btn btn-danger" ng-click="saveQuestion()">
                                <input type="button" value="保存并提交" class="btn btn-primary" ng-click="commitQuestion()">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- js -->
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script src="../res/js/teacherController.js"></script>
<script src="../res/js/jquery.min.js" type="text/javascript"></script>
<script src="../res/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../res/js/UtilityFunction.js"></script>
<script type="text/javascript" src="../res/js/fileinput.min.js"></script>
<script type="text/javascript" src="../res/css/jquery.easyui.min.js"></script>
<!-- 这个是汉化-->
<script type="text/javascript" src="../res/js/locales/zh.js"></script>
<script type="text/javascript">
    $(".myfile").fileinput({
        //上传的地址
        uploadUrl:"XXX",
        uploadAsync : false, //默认异步上传
        showUpload : false, //是否显示上传按钮,跟随文本框的那个
        showRemove : false, //显示移除按钮,跟随文本框的那个
        showCaption : true,//是否显示标题,就是那个文本框
        showPreview : true, //是否显示预览,不写默认为true
        dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount : 1, //表示允许同时上传的最大文件个数
        enctype : 'multipart/form-data',
        validateInitialCount : true,
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
        allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
        allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
        language : 'zh'
    })
    //异步上传返回结果处理
    $('.myfile').on('fileerror', function(event, data, msg) {
        console.log("fileerror");
        console.log(data);
    });
    //异步上传返回结果处理
    $(".myfile").on("fileuploaded", function(event, data, previewId, index) {
        console.log("fileuploaded");
        var ref = $(this).attr("data-ref");
        $("input[name='" + ref + "']").val(data.response.url);

    });

    //同步上传错误处理
    $('.myfile').on('filebatchuploaderror', function(event, data, msg) {
        console.log("filebatchuploaderror");
        console.log(data);
    });

    //同步上传返回结果处理
    $(".myfile").on("filebatchuploadsuccess",
        function(event, data, previewId, index) {
            console.log("filebatchuploadsuccess");
            console.log(data);
        });

    //上传前
    $('.myfile').on('filepreupload', function(event, data, previewId, index) {
        console.log("filepreupload");
    });


    //treegrid部分
    $("#test").treegrid({
        onCheckNode : function(row, checked){
            //添加判断叶子还是根节点
            console.log("onCheckNode: "+ row + "/" + checked);
        }
    });
    //加载超链接
    var formatToHref = function (value,row) {
        //添加分支：根据前缀不同 fetch出不同的东西，qs or q
        var text = "<a href='#'>"+value+"</a>";
        return text;
    }
    function getChecked() {
        var nodes = $("#test").treegrid('getCheckedNodes','indeterminate');
        var nodes1 = $('#test').treegrid('getCheckedNodes');
        var s = '';
        for(var i=0; i<nodes.length; i++){
            if (s != '') s += ',';
            s += nodes[i].id;
        }
        for(var i=0; i<nodes1.length; i++){
            if (s != '') s += ',';
            s += nodes1[i].id;
        }
        return s;
    }
    function group(){
        var s = getChecked();
        //返回后台组卷
        var params = {};
        params.qIdList = s;
        $.ajax({
                type:'post',
                url:'/questionSet/group',
                //dataType:'text',
                data:params,
                dataType:"json",
                beforeSend:function(){
                    alert("发送之前！" + params.qIdList);
                    var checkNodes = s.split(",");
                    for(var i=0;i<checkNodes.length;i++){
                        $('#test').treegrid('uncheckNode',checkNodes[i]);
                    }
                },
                success:function(data){
                    //刷新前台显示
                    $('#test').treegrid('reload');
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    alert("进入error！");
                }
            }
        );

    }
    function ungroup(){
        var s = getChecked();
        //返回后台组卷
        var params = {};
        params.qIdList = s;
        $.ajax({
                type:'post',
                url:'/questionSet/ungroup',
                //dataType:'text',
                data:params,
                dataType:"json",
                beforeSend:function(){
                    alert("发送之前！" + params.qIdList);
                    var checkNodes = s.split(",");
                    for(var i=0;i<checkNodes.length;i++){
                        $('#test').treegrid('uncheckNode',checkNodes[i]);
                    }
                },
                success:function(data){
                    //刷新前台显示
                    $('#test').treegrid('reload');
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    alert("进入error！");
                }
            }
        );

    }
</script>
</body>
</html>
