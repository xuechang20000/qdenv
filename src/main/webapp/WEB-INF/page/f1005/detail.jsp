<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; />
	<meta charset="UTF-8">
	<title>上传</title>
	<%@include file="/include/head.jsp"%>
	<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css " type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" ></script>

	<style type="text/css">
		#attachement a{padding-left: 3px;text-decoration: underline }
	</style>
</head>
<body style="padding-left: 14px">
<div class="panel-body">

	<form class="form-horizontal" role="form" >
		<div class="form-group">
			<h5>标题：<span id="title"></span></h5>
			<h5>收件人：</h5><div id="reciver"></div>
			<h5>附件：<span id="attachement"></span></h5>
			<h5>内容：</h5>
			<span id="content"></span>
		</div>
	</form>
</div>
</body>
<script type="text/javascript">
var noticeList=${list}
	var noticeType='${noticeType}'
	$(document).ready(function () {
		$("#title").html(noticeList.noticeTitle);
		$("#content").html(noticeList.noticeContent);

		$(noticeList.appNoticeAttachmentList).each(function () {
		    if(typeof $(this)['0'].filename !='undefined')
			$("#attachement").append('<a href="<%=request.getContextPath()%>/admin/downLoadAttachment?attid='+$(this)['0'].noticeAttachmentId+'">'+$(this)['0'].filename+'</a>');
        })
        $(noticeList.appNoticeUserDTOList).each(function () {
            $("#reciver").append('<span class="label label-info">'+$(this)['0'].name+'</span>\t');
        })
		//set already read
		Web.util.request("<%=request.getContextPath()%>/admin/updateAppNoticeUser","",{"noticeId":noticeList.noticeId,"noticeIsread":"1"},function () {
			
        })
    })

</script>
</html>
