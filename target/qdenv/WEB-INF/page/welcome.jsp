<%--
  Created by IntelliJ IDEA.
  User: xue
  Date: 2018/4/6
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/bootstrap/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group">
    <input type="text" class="form-control" placeholder="Recipient's username" aria-describedby="basic-addon2">
    <span class="input-group-addon" id="basic-addon2">@example.com</span>
</div>

<div class="input-group">
    <span class="input-group-addon">$</span>
    <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
    <span class="input-group-addon">.00</span>
</div>

<label for="basic-url">Your vanity URL</label>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon3">https://example.com/users/</span>
    <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
</div>
</body>
</html>
