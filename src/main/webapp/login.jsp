<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
  <meta charset="UTF-8" />

  <title>login</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/login.css" />
  <style type="text/css">
    body{
      font-family: Cambria, Palatino, "Palatino Linotype", "Palatino LT STD", Georgia, serif;
      background: #fff url(<%=request.getContextPath()%>/resources/images/login_bg.jpg) repeat top left;
      font-weight: 400;
      font-size: 15px;
      color: #1d3c41;
      overflow-y: scroll;
    }
    #container_demo{margin-top:30px;}
  </style>
</head>
<body>
<div class="container">
  <section>
    <div id="container_demo" >
      <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
      <div id="wrapper">
        <div id="login" class="animate form">
          <form  action="<%=request.getContextPath()%>/login" autocomplete="on" method="post">
            <h1>登陆</h1>
            <p>
              <label for="loginname" class="uname" data-icon="u" > 请输入您的帐户名 </label>
              <input id="loginname" name="loginname" required="required" type="text" placeholder="不少于4位的数字或字母"/>
            </p>
            <p>
              <label for="password" class="youpasswd" data-icon="p"> 您的密码 </label>
              <input id="password" name="password" required="required" type="password" placeholder="" />
            </p>
            <p class="keeplogin">
              <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
              <label for="loginkeeping">记住我</label>
            </p>
            <p class="login button">
              <input type="submit" value="登陆" />
            </p>
            ${errorMsg}
          </form>
        </div>

      </div>
    </div>
  </section>
</div>
</body>
</html>