<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>校园订餐登录页面</title>
</head>
<style>
    * {
        margin: 0px;
        padding: 0px;
        box-sizing: border-box;
    }

    body {

        padding-top: 25px;
    }
    .layout {

        width: 680px;
        height: 300px;
        border: 8px solid #EEEEEE;
        background-color: white;
        /*让div水平居中*/
        margin: auto
    }
    .left {

        float: left;
        margin: 15px;
    }
    .center{

        float: left;
        margin: 15px;
        width:300px;

        padding-left: 5px;
    }
    .right{

        float: right;
        margin: 15px;
    }
    .left p{
        color:#FFD026;
        font-size: 20px;
    }
    fieldset{
        padding-left:10px;
        padding-top: 10px;
        height:400px;
    }
    label{
        width: 100px;
        text-align: right;
        height: 32px;
        line-height: 50px;
        font-size:20px;
    }
    #username,#password{
        width: 150px;
        height: 25px;
        border: 1px solid #A6A6A6 ;
        /*设置边框圆角*/
        border-radius: 5px;
        padding-left: 10px;
    }
    #check{
        font-size:15px;
        line-height: 20px;
    }
    .btn{
        width: 130px;
        height: 25px;
        border: 1px solid #A6A6A6 ;
    }
    .login{
        width: 100px;
        padding-left: 70px;
        height: 32px;
        line-height: 50px;
        font-size:25px;
        color:cyan;

    }
</style>
<body>
<div class="layout">


    <div class="left">
        <p>火车登录系统</p>

    </div>



    <div class="center">
        <form action="${pageContext.request.contextPath}/user/login" >

            <p>
                <label class="login">登录界面
                </label>
            </p>
            <p>
                <label>账户id: <input type="text" name="user_id" id="id"/>
                </label>
            </p>
            <p>
                <label>密&nbsp;&nbsp;码：<input type="password" name="user_password" id="password" />
                </label>
            </p>

            <p>

                <label><input type="submit" value="登录" class="btn"/>
                    <input type="reset" value="取消"  class="btn"/>

                </label>
            </p>
            <p>

                <label>

                </label>
            </p>

        </form>
    </div>


    <div class="right">
        <p>没有账号?<a href="${pageContext.request.contextPath}/user/insertUser">立即注册</a></p>
    </div>


</div>
</body>
</html>