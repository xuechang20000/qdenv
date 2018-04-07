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
<div class="container">
    <form class="form-inline">
     <div class="row">
         <div class="col-md-5">
                <div class="form-group">
                    <label for="exampleInputEmail1" >Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>

                <div class="form-group">
                    <label for="userName">userName</label>
                    <input type="text" class="form-control" id="userName" placeholder="Username">
                </div>
         </div>
         <div class="col-md-5">

         </div>
     </div>
    </form>
</div>
</body>
</html>
