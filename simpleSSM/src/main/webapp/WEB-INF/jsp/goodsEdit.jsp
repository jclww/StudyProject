<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/12
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${goods.name}</title>
</head>
<body>
<form class="form-horizontal" role="form" action="modifyBySn" method="post">
    <div class="input-group">
        <span class="input-group-addon">商品名</span>
        <input name="name" type="text" class="form-control" value="${goods.name}">
    </div>
    <div class="input-group">
        <span class="input-group-addon">商品商城标语</span>
        <input name="productTitle" type="text" class="form-control" value="${goods.product_title}">
    </div>
    <div class="input-group">
        <span class="input-group-addon">商品商城编号</span>
        <input name="sn" type="text" class="form-control" value="${goods.sn}">
    </div>
    <div class="input-group">
        <span class="input-group-addon">修改人</span>
        <input name="editBy" type="text" class="form-control">
    </div>
    <input type="submit" value="修改">
</form>
</body>
</html>
