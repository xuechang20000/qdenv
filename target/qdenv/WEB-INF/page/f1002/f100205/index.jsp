<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        #form1{ }
        #form1 table {margin:0px auto}
        #form1 table td{padding: 3px}
    </style>
</head>
<body>
<span id="search" style="margin: 6px;display: block">
    委托编号:<input id="wat002"  name="wat002" class="mini-textbox" value="${param.wat002}" style="width:200px;" />
    <a class="mini-button" iconCls="icon-search" id="doSearch" onclick="onSerach()">查询</a>
</span>
<div id="datagrid" class="mini-datagrid" style="width: 100%;height: 350px;" allowResize="true" pageSize="10"
    url="${pageContext.request.contextPath}/work/f100201/queryWt02"  idField="wbt001">
    <div property="columns">
        <div headerAlign="center" width="40"  renderer="renderUser">操作</div>
        <div field="wbt001" width="20" headerAlign="center" >ID</div>
        <div field="bbz002" width="200" headerAlign="center" >标准名称</div>
        <div field="bbz003" width="70" headerAlign="center" >标签</div>
        <div field="aae013" width="80" headerAlign="center" >备注</div>
    </div>
</div>
<span id="grid_buttons" style="display: none"  >
         <a class="mini-button" href="javascript:onInput()" plain="true" iconCls="icon-edit">录入</a>
    </span>
</body>
</html>
<script type="text/javascript">
    mini.parse();
    var grid=mini.get("datagrid");
    function onSerach(){
        var wat002=mini.get("wat002").getValue();
        if(!wat002){
            Web.util.showTipsWanring("请先输入委托编号！")
            return;
        }
        wat002=wat002.trim();
        var url="${pageContext.request.contextPath}/work/f100201/queryWtList";
        Web.util.request(url,"post",{wat002:wat002},function (data) {
            grid.load({wat001:data[0].wat001});
        })

    }
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onInput() {
        var row = grid.getSelected();
        var url="${pageContext.request.contextPath}/work/f100202/loadDO_4?wbt001="+row.wbt001;
        Web.util.openMiniWindow('检测数据录入', url, 1000, 500, function () {
            //grid.reload();
        })
    }
</script>
</html>
