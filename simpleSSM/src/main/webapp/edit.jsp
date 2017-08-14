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
    <title>Title</title>
</head>
<body>

<form class="form-horizontal" role="form" action="modifyBySn" method="post">
    <div class="input-group">
        <span class="input-group-addon">创&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;建&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人</span>
        <input name="create" type="text" class="form-control">
    </div>
    <div class="input-group">
        <span class="input-group-addon">商品商城标语</span>
        <input name="slogan" type="text" class="form-control">
    </div>
    <div class="input-group">
        <span class="input-group-addon">商品商城编号</span>
        <input name="shopId" type="text" class="form-control">
    </div>
    <div class="input-group">
        <span class="input-group-addon">商品对应商户ID</span>
        <input name="sn" type="text" class="form-control">
    </div>
    <input type="submit" value="修改">
</form>

</body>
</html>
