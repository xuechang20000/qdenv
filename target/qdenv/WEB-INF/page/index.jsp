<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="xue">
	<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<link rel="shortcut icon" href="img/favicon.html">

	<title>Blank</title>

	<!-- Bootstrap core CSS -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-reset.css" rel="stylesheet">
	<!--external css-->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<!-- Custom styles for this template -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/css/style.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/bootstrap/css/style-responsive.css" rel="stylesheet" />

	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/miniui/boot.js"></script>

</head>

<body>

<section id="container" class="">
	<!--header start-->
	<header class="header white-bg">
		<div class="sidebar-toggle-box">
			<div data-original-title="Toggle Navigation" data-placement="right" class="icon-reorder tooltips"></div>
		</div>
		<!--logo start-->
		<a href="#" class="logo" >Flat<span>lab</span></a>
		<!--logo end-->
		<div class="nav notify-row" id="top_menu">
			<!--  notification start -->
			<ul class="nav top-menu">
				<!-- inbox dropdown start 站内信息-->
				<li id="header_inbox_bar" class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i class="icon-envelope-alt"></i>
						<span class="badge bg-important"></span>
					</a>
					<ul class="dropdown-menu extended inbox">
						<div class="notify-arrow notify-arrow-red"></div>
						<li>
							<p class="red"></p>
						</li>
					</ul>
				</li>
				<!-- inbox dropdown end -->
				<!-- notification dropdown start 通知公告-->
				<li id="header_notification_bar" class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">

						<i class="icon-bell-alt"></i>
						<span class="badge bg-warning"></span>
					</a>
					<ul class="dropdown-menu extended notification">
						<div class="notify-arrow notify-arrow-yellow"></div>
						<li>
							<p class="yellow"></p>
						</li>

					</ul>
				</li>
				<!-- notification dropdown end -->
			</ul>
		</div>
		<div class="top-nav ">
			<ul class="nav pull-right top-menu">
				<li>
					<input type="text" class="form-control search" placeholder="Search">
				</li>
				<!-- user login dropdown start-->
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<img alt="" src="<%=request.getContextPath()%>/resources/bootstrap/img/avatar1_small.jpg">
						<span class="username">${user.name}</span>
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<li><a href="javascript:showUserInfo()"><i class=" icon-suitcase"></i>个人信息</a></li>
						<li><a href="javascript:changePW()"><i class="icon-cog"></i> 密码修改</a></li>
						<li><a href="javascript:addAltTab()"><i class="icon-bell-alt"></i> 公告</a></li>
						<li><a href="logout"><i class="icon-key"></i> 退&nbsp;&nbsp;出</a></li>
					</ul>
				</li>
				<!-- user login dropdown end -->
			</ul>
		</div>
	</header>
	<!--header end-->
	<!--sidebar start-->
	<aside>
		<div id="sidebar"  class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu">
			</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper" style="height:560px;padding: 0px">
			<!-- page start-->
			<div class="mini-fit" style="height:100%;">
			<div class="mini-tabs"  id="tabs1" activeIndex="0" style="width:100%;height:100%;" plain='false'>
				<div title="首页" name="init" >
					<iframe id="mainframe" src="<%=request.getContextPath()%>/index_bckd.jsp" frameborder="0"  style="width:100%;height:100%;" border="0"></iframe>
				</div>
			</div>
			</div>
			<!-- page end-->
		</section>
	</section>
	<!--main content end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.scrollTo.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.nicescroll.js" type="text/javascript"></script>

<script type="text/javascript">
    var menusJson=${menusJson};
</script>
<!--common script for all pages-->
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/common-scripts.js"></script>
<script src="<%=request.getContextPath()%>/resources/scripts/frame.js"></script>
<script src="<%=request.getContextPath()%>/resources/scripts/moment.js"></script>
<script src="<%=request.getContextPath()%>/resources/scripts/moment-with-locales.js"></script>
<script type="text/javascript">
    $(function(){

        $("#sidebar .sub-menu a").click(function(){

            var html=$(this).html(),
                menuid=$(this).attr("menuid"),
                menuurl=$(this).attr("menuurl");
            console.info('menuurl'+menuurl+':'+menuurl== undefined );
            if(menuurl==null||menuurl=='undefined'||menuurl.length==0) return;
            addTab(html,menuid,menuurl);
        });
        loadEnvelope();
        loadAlt();
    })
    mini.parse();
    function addTab(title,menuid,url) {
        var src = '<%=request.getContextPath()%>' + url,
            nodeid = "tab$" + menuid;
        text = title;

        var tabs = mini.get("tabs1");
        var tab = tabs.getTab(nodeid);
        if (!tab) {
            tab = {};
            tab.title = text;
            tab.showCloseButton = true;
            tab.name = nodeid;
            tab.url = src;
            tabs.addTab(tab);
        }
        tabs.activeTab(tab);
    }
function loadEnvelope() {
    Web.util.request("<%=request.getContextPath()%>/admin/loadRecevieMail","",{noticeType:"2",noticeIsread:"0",pageSize:"10",pageIndex:"0"},
		function (data) {
            generateDropDownNotify(data)
    })
}
function loadAlt() {
    Web.util.request("<%=request.getContextPath()%>/admin/loadRecevieMail","",{noticeType:"1",noticeIsread:"0",pageSize:"10",pageIndex:"0"},
        function (data) {
            generateAltNotify(data)
        })
}
 function generateDropDownNotify(data) {
        $("#header_inbox_bar").find("a[data-toggle]").find("span").html(data.total);
        $("#header_inbox_bar ul li p[class='red']").html('您有'+data.total+'封信件');
	   var i=0;
	   var li='';
       $("#header_inbox_bar ul li:has(span)").remove();
       for(var d;d=data.data[i++];){
           moment.locale("zh_cn");

           li='<li><a href="javascript:onQuery('+d.noticeId+')"><span class="photo">' +
			 '<img alt="avatar" src="<%=request.getContextPath()%>/resources/bootstrap/img/avatar-mini.jpg"></span>'+
			 '<span class="subject"><span class="from">'+d.name+'</span><span class="time">'+moment(d.ctime).fromNow()+'</span></span>'+
           '<span class="message">'+d.noticeTitle+'</span></a></li>';
           $("#header_inbox_bar ul").append($(li));

	   }
       $("#header_inbox_bar ul").append($('<li><span><a href="javascript:addEnvelopeTab()">查看所有信件</a></span></li>'))
    }
function generateAltNotify(data){
    $("#header_notification_bar").find("a[data-toggle]").find("span").html(data.total);
    $("#header_notification_bar ul li p[class='yellow']").html('您有'+data.total+'个公告未读');
    var i=0;
    var li='';
    $("#header_notification_bar ul li:has(span)").remove();
    for(var d;d=data.data[i++];){
        moment.locale("zh_cn");
		if(d.noticeTitle.length>10) d.noticeTitle=d.noticeTitle.substr(0,10)+"..";
        li='<li><a href="javascript:onQuery('+d.noticeId+')"><span class="label label-warning">' +
            '<i class="icon-bolt"></i></span>&nbsp;&nbsp;'+d.noticeTitle+'<span class="small italic">&nbsp;&nbsp;'+moment(d.ctime).fromNow()+'</span></a></li>';
        $("#header_notification_bar ul").append($(li));

    }
	$("#header_notification_bar ul").append($('<li><span><a href="javascript:addAltTab()">查看所有公告</a></span></li>'))
}
function addEnvelopeTab() {
	addTab('站内信','1005','/admin/f1005/index');
}
function addAltTab() {
	addTab('公告','100401','/admin/f100401/index');
}
function onQuery(noticeId) {
        var title=name?"查看信件(来自"+name+")":"查看信件";
        Web.util.openMiniWindow(title,"<%=request.getContextPath()%>/admin/f1005/loadDetail?noticeId="+noticeId+"&v=1",800,500,function () {
            loadEnvelope();
            loadAlt();
        })
    }
    function showUserInfo() {
        Web.util.openMiniWindow("个人信息","<%=request.getContextPath()%>/loadUserInfo",700,250,function () {

        })
    }
    function changePW() {
        Web.util.openMiniWindow("修改密码","<%=request.getContextPath()%>/admin/loadUpdatePassword",700,250,function () {

        })
    }
</script>
</body>
</html>
