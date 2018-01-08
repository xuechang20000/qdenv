<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>
<div style="width:43%;height:100%; float: left">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" onclick="addDict()">增加</a>
                    <a class="mini-button" iconCls="icon-remove" onclick="updateDict(0)">禁用</a>
                    <a class="mini-button" iconCls="icon-ok" onclick="updateDict(1)">启用</a>
                </td>
                <td style="white-space:nowrap;">
                    <input id="keyDict" class="mini-textbox" emptyText="请输入字典名称" style="width:100px;" onenter="searchDict"/>
                    <a class="mini-button" onclick="searchDict()">查询</a>
                </td>
            </tr>
        </table>
    </div>
<div class="mini-fit" style="height:100%;">
    <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true" pageSize="100"
         url="<%=request.getContextPath()%>/admin/queryAppDicts"  idField="dictId" multiSelect="true" onrowclick="onrowclick">
        <div property="columns">
            <div type="checkcolumn"></div>
            <div field="dictId" width="40" headerAlign="center" allowSort="true">字典ID</div>
            <div field="dictCode" width="100" headerAlign="center" allowSort="true">字典代码</div>
            <div field="dictName" width="100" headerAlign="center" allowSort="true">字典名称</div>
            <div field="status" width="40" headerAlign="center" renderer='oncodeRender' allowSort="true">是否有效</div>
        </div>
    </div>
</div>
</div>
<div style="width:55%;height:100%; float: left;margin-left: 8px">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" onclick="addDetail()">增加</a>
                    <a class="mini-button" iconCls="icon-remove" onclick="updateDictDetail(0)">禁用</a>
                    <a class="mini-button" iconCls="icon-ok" onclick="updateDictDetail(1)">启用</a>
                </td>
                <td style="white-space:nowrap;">
                    <input id="keyDetail" class="mini-textbox" emptyText="请输入字典名称" style="width:100px;" onenter="searchDetail"/>
                    <a class="mini-button" onclick="searchDetail()">查询</a>
                </td>
            </tr>
        </table>
    </div>
    <div class="mini-fit" style="height:100%;">
        <div id="datagrid2" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true" pageSize="100"
             url="<%=request.getContextPath()%>/admin/queryAppDictDetails" multiSelect="true" idField="dictId">
            <div property="columns">
                <div type="checkcolumn"></div>
                <div field="dictId" width="40" headerAlign="center" allowSort="true">字典项ID</div>
                <div field="dictCode" width="80" headerAlign="center" allowSort="true">字典代码</div>
                <div field="dictVal" width="40" headerAlign="center" allowSort="true">字典值</div>
                <div field="dictName" width="80" headerAlign="center" allowSort="true">字典项名称</div>
                <div field="status" width="40" headerAlign="center" renderer='oncodeRender' allowSort="true">是否有效</div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    Web.util.load("datagrid1");
    var dictCode;
    function searchDict() {
        var key = mini.get("keyDict").getValue();
        Web.util.load("datagrid1",{"dictName": key });
    }
    function searchDetail() {
        var key = mini.get("keyDetail").getValue();
        Web.util.load("datagrid2",{"dictCode":dictCode,"dictName": key });
    }
    function onrowclick(e) {
        dictCode=e.record.dictCode;
        Web.util.load("datagrid2",{"dictCode":dictCode});
    }
    function addDict() {
        Web.util.openMiniWindow("添加字典","<%=request.getContextPath()%>/admin/loadDictAdd",500,240,function () {
            Web.util.reload("datagrid1");
        })
    }
    function addDetail() {
        if(!dictCode){
            mini.alert("请选中一条字典记录");
            return;
        }
        Web.util.openMiniWindow("添加字典项","<%=request.getContextPath()%>/admin/loadDictDetailAdd?dictCode="+dictCode,500,240,function () {
            Web.util.reload("datagrid2");
        })
    }
    function updateDict(val) {
        var grids=mini.get("datagrid1").getSelecteds();
        Web.util.requestAsync("<%=request.getContextPath()%>/admin/updateAppDict","post",
            {"appDicts":JSON.stringify(grids),"status":val},function () {
            Web.util.reload("datagrid1");
        })
    }
    function updateDictDetail(val) {
        var grids=mini.get("datagrid2").getSelecteds();
        Web.util.requestAsync("<%=request.getContextPath()%>/admin/updateAppDictDetail","post",
            {"appDictDetails":JSON.stringify(grids),"status":val},function () {
            Web.util.reload("datagrid2");
        })
    }
</script>
</html>
