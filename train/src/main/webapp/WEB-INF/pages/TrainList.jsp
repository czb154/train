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
    <h3 style="text-align: center">车票查询模块</h3>

    <div style="float: left;" id="form_inline">

        <form class="form-inline" action="${pageContext.request.contextPath}/train/selectOther1">
            <div class="form-group">
                <label for="exampleInputName2">时间:</label>
                <input type="date" name="train_time" value="" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">出发站:</label>
                <input type="text" name="train_start" value="" class="form-control" id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">终点站:</label>
                <input type="text" name="trian_end" value="" class="form-control" id="exampleInputEmail2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">车票类型:</label>
                <select name="train_type" class="form-control">
                    <option value="硬座">硬座</option>
                    <option value="软座">软座</option>
                    <option value="硬卧">硬卧</option>
                    <option value="软卧">软卧</option>
                </select>
            </div>
            <button type="submit" class="btn train_type form-inline_btn">查询</button>
        </form>

    </div>
    <p></p>


    <form id="trainlist_form" name="form" action="${pageContext.request.contextPath}/delSelected.action">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>起始站</th>
                <th>终点站</th>
                <th>类型</th>
                <th>价格</th>
                <th>时间</th>




                <th>剩余票数</th>
                <th>操作</th>

            </tr>


            <c:forEach items="${sessionScope.pb.list}" var="train" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="fid" value=${train.train_id}></td>
                    <td>${train.train_id}</td>
                    <td>${train.train_start}</td>
                    <td>${train.train_end}</td>
                    <td>${train.train_type}</td>
                    <td>${train.train_price}</td>
                    <td>${train.printtime()}</td>
                    <td>${train.train_number}</td>

                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/train/order?train_id=${train.train_id}">订票</a></td>
                </tr>
            </c:forEach>


        </table>

    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>


                    <a href="${pageContext.request.contextPath}/train/selectOther1?currentPage=${pb.currentPage - 1}&rows=5&train_time=${train_time}&train_start=${train_start}&train_end=${train_end}&train_type=${train_type}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <c:forEach begin="1" end="${pb.totalPage}" var="i">


                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/train/selectOther1?currentPage=${i}&rows=5&train_time=${train_time}&train_start=${train_start}&train_end=${train_end}&train_type=${train_type}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/train/selectOther1?currentPage=${i}&rows=5&train_time=${train_time}&train_start=${train_start}&train_end=${train_end}&train_type=${train_type}">${i}</a>
                        </li>
                    </c:if>

                </c:forEach>


                <li>
                    <a href="${pageContext.request.contextPath}/train/selectOther1?currentPage=${pb.currentPage + 1}&rows=5&train_time=${train_time}&train_start=${train_start}&train_end=${train_end}&train_type=${train_type}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>

            </ul>
        </nav>


    </div>


</div>


</body>
</html>
