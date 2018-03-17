<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
<%@include file="/include/head.jsp"%>
    <style type="text/css">
        .mini-panel-border{border: none}
    </style>
</head>
<body>
    <span id="search">
    委托编号:<input id="wat002"  name="wat002" class="mini-textbox" value="${param.wat002}" style="width:200px;" />
    <a class="mini-button" iconCls="icon-search" id="doSearch" onclick="onSerach()">查询</a>
    </span>

    <span id="back" style="display: none;">&nbsp;&nbsp;<a class="mini-button" iconCls="icon-undo" plain="true" onclick="javascript:history.go(-1);">返回</a></span>

<div class="mini-panel" id="content"   style="width:100%;height: 500px" showHeader="false" bodyStyle="padding:0px;margin:0px"
     showToolbar="false" showCloseButton="false" showFooter="false"
>
</div>
</body>
<script type="text/javascript">
    mini.parse();

    function onSerach(){
        var wat002=mini.get("wat002").getValue();
        if(!wat002){
            Web.util.showTipsWanring("请先输入委托编号！")
            return;
        }
        wat002=wat002.trim();
        var url="${pageContext.request.contextPath}/work/f100201/queryWtList";
        Web.util.request(url,"post",{wat002:wat002},function (data) {
            var url="${pageContext.request.contextPath}/work/f100202/loadDO_3?wat001="+data[0].wat001;
            mini.get("content").load(url,function () {

            })
        })

    }
    (function () {
        var wat002=mini.get("wat002").getValue();
        if(wat002){
            onSerach();
            $("#search").hide();
            $("#back").show();
        }
    })()
</script>

</html>
