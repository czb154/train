<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>菜品管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/TrainList.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>









    </script>
</head>
<body>


<div class="container">
    <h3 style="text-align: center">车票订票模块</h3>




    <form id="trainlist_form" name="form" action="${pageContext.request.contextPath}/order/orderdeal" >
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">

                <th>订单号</th>
                <th>乘客信息</th>
                <th>列票信息</th>
                <th>票数</th>
                <th>单价</th>

            </tr>


                <tr>

                    <td>${sessionScope.order_id}</td>
                    <td>乘客人：${sessionScope.user.user_name}<br>
                    身份证：${sessionScope.user.user_idcard}<br>
                    电话：${sessionScope.user.user_phone}</td>
                    <td>出发时间：${sessionScope.train.printtime()}<br>
                    出发站：${sessionScope.train.train_start}<br>
                    终点站：${sessionScope.train.train_end}
                    类型：${sessionScope.train.train_type}</td>
                    <td><input type="number" name="order_number"></td>

                    <td>${sessionScope.train.train_price}</td>
                </tr>



        </table>
        <div style="float: right;margin: 5px;">



            <input class="btn btn-default" id="delSelected" type="submit" value="确定订票">
            <a href="${pageContext.request.contextPath}/order/oldorderview">历史订单</a>
            <p>${sessionScope.msg_order}</p>
        </div>
    </form>



</div>


</body>
</html>