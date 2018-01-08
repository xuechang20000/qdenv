<%@ page contentType="text/html; charset=utf-8"%>
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
				<!-- settings start -->
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i class="icon-tasks"></i>
						<span class="badge bg-success">6</span>
					</a>
					<ul class="dropdown-menu extended tasks-bar">
						<div class="notify-arrow notify-arrow-green"></div>
						<li>
							<p class="green">You have 6 pending tasks</p>
						</li>
						<li>
							<a href="#">
								<div class="task-info">
									<div class="desc">Dashboard v1.3</div>
									<div class="percent">40%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
										<span class="sr-only">40% Complete (success)</span>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="task-info">
									<div class="desc">Database Update</div>
									<div class="percent">60%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (warning)</span>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="task-info">
									<div class="desc">Iphone Development</div>
									<div class="percent">87%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 87%">
										<span class="sr-only">87% Complete</span>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="task-info">
									<div class="desc">Mobile App</div>
									<div class="percent">33%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 33%">
										<span class="sr-only">33% Complete (danger)</span>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="task-info">
									<div class="desc">Dashboard v1.3</div>
									<div class="percent">45%</div>
								</div>
								<div class="progress progress-striped active">
									<div class="progress-bar"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
										<span class="sr-only">45% Complete</span>
									</div>
								</div>

							</a>
						</li>
						<li class="external">
							<a href="#">See All Tasks</a>
						</li>
					</ul>
				</li>
				<!-- settings end -->
				<!-- inbox dropdown start-->
				<li id="header_inbox_bar" class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i class="icon-envelope-alt"></i>
						<span class="badge bg-important">5</span>
					</a>
					<ul class="dropdown-menu extended inbox">
						<div class="notify-arrow notify-arrow-red"></div>
						<li>
							<p class="red">You have 5 new messages</p>
						</li>
						<li>
							<a href="#">
								<span class="photo"><img alt="avatar" src="<%=request.getContextPath()%>/resources/bootstrap/img/avatar-mini.jpg"></span>
								<span class="subject">
                                    <span class="from">Jonathan Smith</span>
                                    <span class="time">Just now</span>
                                    </span>
								<span class="message">
                                        Hello, this is an example msg.
                                    </span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="photo"><img alt="avatar" src="<%=request.getContextPath()%>/resources/bootstrap/img/avatar-mini2.jpg"></span>
								<span class="subject">
                                    <span class="from">Jhon Doe</span>
                                    <span class="time">10 mins</span>
                                    </span>
								<span class="message">
                                     Hi, Jhon Doe Bhai how are you ?
                                    </span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="photo"><img alt="avatar" src="<%=request.getContextPath()%>/resources/bootstrap/img/avatar-mini3.jpg"></span>
								<span class="subject">
                                    <span class="from">Jason Stathum</span>
                                    <span class="time">3 hrs</span>
                                    </span>
								<span class="message">
                                        This is awesome dashboard.
                                    </span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="photo"><img alt="avatar" src="<%=request.getContextPath()%>/resources/bootstrap/img/avatar-mini4.jpg"></span>
								<span class="subject">
                                    <span class="from">Jondi Rose</span>
                                    <span class="time">Just now</span>
                                    </span>
								<span class="message">
                                        Hello, this is metrolab
                                    </span>
							</a>
						</li>
						<li>
							<a href="#">See all messages</a>
						</li>
					</ul>
				</li>
				<!-- inbox dropdown end -->
				<!-- notification dropdown start-->
				<li id="header_notification_bar" class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">

						<i class="icon-bell-alt"></i>
						<span class="badge bg-warning">7</span>
					</a>
					<ul class="dropdown-menu extended notification">
						<div class="notify-arrow notify-arrow-yellow"></div>
						<li>
							<p class="yellow">You have 7 new notifications</p>
						</li>
						<li>
							<a href="#">
								<span class="label label-danger"><i class="icon-bolt"></i></span>
								Server #3 overloaded.
								<span class="small italic">34 mins</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="label label-warning"><i class="icon-bell"></i></span>
								Server #10 not respoding.
								<span class="small italic">1 Hours</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="label label-danger"><i class="icon-bolt"></i></span>
								Database overloaded 24%.
								<span class="small italic">4 hrs</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="label label-success"><i class="icon-plus"></i></span>
								New user registered.
								<span class="small italic">Just now</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="label label-info"><i class="icon-bullhorn"></i></span>
								Application error.
								<span class="small italic">10 mins</span>
							</a>
						</li>
						<li>
							<a href="#">See all notifications</a>
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
						<span class="username">Jhon Doue</span>
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<li><a href="#"><i class=" icon-suitcase"></i>Profile</a></li>
						<li><a href="#"><i class="icon-cog"></i> Settings</a></li>
						<li><a href="#"><i class="icon-bell-alt"></i> Notification</a></li>
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
    var menusJson=${menusJson}
</script>
<!--common script for all pages-->
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/common-scripts.js"></script>

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

</script>
</body>
</html>
