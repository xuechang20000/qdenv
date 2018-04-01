<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>
<div style="width:55%;height:100%; float: left">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-undo" onclick="updateWt02()">还原</a>
                </td>
                <td style="white-space:nowrap;">
                    <input id="keyDict" class="mini-textbox" emptyText="请输入委托编号" style="width:100px;" onenter="searchDict"/>
                    <a class="mini-button" onclick="searchDict()">查询</a>
                </td>
            </tr>
        </table>
    </div>
    <div class="mini-fit" style="height:100%;">
        <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true" pageSize="100"
             url="<%=request.getContextPath()%>/work/f100206/queryWt02Disables"  idField="wbt001" multiSelect="false" onrowclick="onrowclick">
            <div property="columns">
                <div type="checkcolumn"></div>
                <div field="wbt001" width="40" visible="false" headerAlign="center" allowSort="true">ID</div>
                <div field="wat002" width="40" headerAlign="center" allowSort="true">委托编号</div>
                <div field="daw002" width="100" headerAlign="center" allowSort="true">委托单位</div>
                <div field="wat018s" width="40" headerAlign="center"  allowSort="true">委托状态</div>
                <div field="aae016" width="40" headerAlign="center" renderer='oncodeRender' allowSort="true">是否有效</div>
            </div>
        </div>
    </div>
</div>
<div style="width:43%;height:100%; float: left;margin-left: 8px">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-undo" onclick="updateWt03()">还原</a>
                </td>
            </tr>
        </table>
    </div>
    <div class="mini-fit" style="height:100%;">
        <div id="datagrid2" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true" pageSize="100"
             url="<%=request.getContextPath()%>/work/f100201/queryWt03?aae016=0" multiSelect="false" idField="wct001">
            <div property="columns">
                <div type="checkcolumn"></div>
                <div field="wct001" width="40" visible="false" headerAlign="center" allowSort="true">ID</div>
                <div field="wct002" width="120" headerAlign="center" allowSort="true">采样点</div>
                <div field="aae016" width="40" headerAlign="center" renderer='oncodeRender' allowSort="true">是否有效</div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    Web.util.load("datagrid1");
    var wbt001;
    function searchDict() {
        var key = mini.get("keyDict").getValue();
        Web.util.load("datagrid1",{"wat002": key });
    }
    function onrowclick(e) {
        wbt001=e.record.wbt001;
        Web.util.load("datagrid2",{"wbt001":wbt001});
    }
    function updateWt02() {
        var row=mini.get("datagrid1").getSelected();
        Web.util.requestAsync("${pageContext.request.contextPath}/work/f100206/updateWt02Simple","post",
            {"wbt001":row.wbt001,"aae016":"1"},function () {
                Web.util.reload("datagrid1");
            })
    }
    function updateWt03() {
        var row=mini.get("datagrid2").getSelected();
        Web.util.requestAsync("${pageContext.request.contextPath}/work/f100206/updateWt03Simple","post",
            {"wct001":row.wct001,wbt001:wbt001,"aae016":"1"},function () {
                Web.util.reload("datagrid2");
            })
    }
</script>
</html>
