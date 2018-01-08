<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人查询首页</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/workspace.css" media="all">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/miniui/boot.js"></script>
	<style type="text/css">
		.mymenu .mini-menu-float{float:right;}
		.mini-splitter #leftTree .mini-outlookbar-groupTitle{font-size:10pt;line-height:24px;TEXT-ALIGN:left;}
		.mini-splitter #p1 .mini-panel-title,.mini-outlookbar-groupTitle{float:none;TEXT-ALIGN: center;}
		#toolbar1{padding:0px;padding-top:20px;height:40px; border: 0px}
		#toolbar1 .mini-button{font-size: 16px}
		#popupMenu .mini-menu{font-size: 12px}
		#index_title {font-family: "Trebuchet MS", Arial, sans-serif;font-size: 18px;padding-left: 10px}
		#layout1{height:595px;padding:0px;}
	</style>
</head>
<body>
<!--top开始-->

<!--top结束-->
<div id="layout1" class="mini-layout" style="width: 100%"  borderStyle="border:solid 1px #aaa;">
	<div title="" region="south" showSplit="false" showHeader="false" height="40" showSplitIcon="true" STYLE="border: 0px" >
		<div style="text-align: center">@XXXXXXX</div>
	</div>
	<div title="center" region="center"  >
		<div id="centerSplitter" class="mini-splitter" style="width:100%;height:100%;"  borderStyle="border:1;">
			<!-- ---------------- -->
			<div size="20%" showCollapseButton="true" style="border:1px;">
				<div id="p1" class="mini-panel" title="header"  style="width:auto;border:0;" bodyStyle="display:none">
				</div>
				<div id="leftTree" class="mini-outlookmenu" url="<%=request.getContextPath()%>/loadMenus" onitemclick="onItemSelect" style="height: 510px;"
					 idField="id" parentField="pid" textField="text" borderStyle="border:0">
				</div>
			</div>
			<!-- ---------------- -->
			<div showCollapseButton="false" style="border:1px;">
				<div class="mini-tabs"  id="tabs1" activeIndex="0" style="width:100%;height:100%;" plain='false'>
					<div title="首页" name="init" >
						<iframe id="mainframe" src="<%= request.getContextPath()%>/workspace/loadWelcomPage.action" frameborder="0"  style="width:100%;height:100%;" border="0"></iframe>
					</div>
				</div>
			</div>
			<!-- ---------------- -->
		</div>
	</div>
</div>


<script type="text/javascript">
    mini.parse();
    function onItemSelect(e) {
        var item = e.item;
        var src = '<%=request.getContextPath()%>'+item.url;
        nodeid = "tab$" + item.id;
        text =item.text;

        var tabs = mini.get("tabs1");
        var tab = tabs.getTab(nodeid);
        if(!tab){
            tab = {};
            tab.title=text;
            tab.showCloseButton = true;
            tab.name = nodeid;
            tab.url=src;
            tabs.addTab(tab);
        }
        tabs.activeTab(tab);
    }
</script>
</body>
</html>
