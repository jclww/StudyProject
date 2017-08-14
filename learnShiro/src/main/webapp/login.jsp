<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>login page</h1>
<form id="" action="/dologin" method="post">
    <label>账号:</label><input name="userName" maxLength="40"/>
    <input title="是否是管理员" type="checkbox" name="isAdmin"><label>是否为管理员</label><br>
    <label>密码：</label><input title="密码" type="password" name="password" /><br>
    <input type="submit" value="登录"/>
</form>
<%--用于输入后台返回的验证错误信息 --%>
<P><c:out value="${message }"/></P>
</body>
</html>