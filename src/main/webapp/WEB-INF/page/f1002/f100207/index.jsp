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
      委托编号:<input id="wat002"  name="wat002" class="mini-textbox"  style="width:100px;" onenter="onSerach()"/>
    样品编号:<input id="wst003"  name="wst003" class="mini-textbox"  style="width:100px;" onenter="onSerach()"/>
    <a class="mini-button" iconCls="icon-search" id="doSearch" onclick="onSerach()">查询</a>
</span>
<div id="datagrid" class="mini-datagrid" style="width: 100%;height: 350px;" allowResize="true" pageSize="10"
    url="${pageContext.request.contextPath}/work/f100207/queryWt10PageForRecord"  idField="wbt001">
    <div property="columns">
        <div headerAlign="center" width="40"  renderer="renderUser">操作</div>
        <div field="wxt001" width="20" headerAlign="center" visible="false">实检测项目ID</div>
        <div field="bcz001" width="20" headerAlign="center" visible="false">检测项目ID</div>
        <div field="wct001" width="20" headerAlign="center" visible="false">采样点ID</div>
        <div field="wst001" width="20" headerAlign="center" visible="false">样品ID</div>
        <div field="wat002" width="50" headerAlign="center" >委托编号</div>
        <div field="bcz002" width="100" headerAlign="center" >检测项目</div>
        <div field="wst003" width="30" headerAlign="center" >样品编号</div>
        <div field="wst004" width="70" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" >采样时间起</div>
        <div field="wst005" width="70" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" >采样时间止</div>
        <div field="wst008" width="70" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss">录入时间</div>
        <!--<div field="wst009" width="70" headerAlign="center" >录入人</div>-->
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
        var wst003=mini.get("wst003").getValue();
        var wat002=mini.get("wat002").getValue();
        if(!wst003&&!wat002){
            Web.util.showTipsWanring("请输入查询条件！")
            return;
        }
        if (wat002&&wat002.length<10&&!wst003){
            Web.util.showTipsWanring("请输入样品编号！")
            return;
        }
        if(wst003) wst003=wst003.trim();
        if(wat002) wat002=wat002.trim();
        grid.load({wst003:wst003,wat002:wat002});
    }
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onInput() {
        var row = grid.getSelected();
        var url="${pageContext.request.contextPath}/work/load/f1002/f100207/oraRecord?wst001="+row.wst001+"&wxt001="+row.wxt001+"&wct001="+row.wct001+"&bcz001="+row.bcz001;
        Web.util.openMiniWindow('检测原始数据录入('+row.wst003+')', url, 1000, 550, function () {
            //grid.reload();
        })
    }
</script>
</html>
