<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>仪器管理</title>
<%@include file="/include/head.jsp"%>
</head>
<body>

<div style="width: 100%; padding-bottom: 3px">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px; border: 0px">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" onclick="onAdd()">增加</a>
                </td>
            </tr>
        </table>
    </div>
</div>
 <div class="mini-fit" style="height:100%;">
    <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true" pageSize="100" pagerButtons="#buttons"
         url="<%=request.getContextPath()%>/work/f100604/queryBz06"  idField="userId" allowAlternating="true">
            <div property="columns">
            <div field="bmz001" width="40" headerAlign="center" allowSort="true">仪器ID</div>
            <div field="bmz002" width="180" headerAlign="center" allowSort="true">仪器名称</div>
            <div field="bmz003" width="80" headerAlign="center" allowSort="true" renderer='oncodeRender'>仪器类别</div>
            <div field="bmz004" width="300" headerAlign="center" allowSort="true">仪器编号列表</div>
            <div field="aae016" width="40" headerAlign="center" allowSort="true" renderer='oncodeRender'>状态</div>
            <div field="aae013" width="100" headerAlign="center" >备注</div>
            <div headerAlign="center" width="130" renderer="renderUser">操作</div>
        </div>
    </div>

    <span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onUpdate()" plain="true" iconCls="icon-edit" >修改</a>
        <a class="mini-button" href="javascript:onDelete()" plain="true" iconCls="icon-remove">删除</a>
    </span>
</div>
<div id="buttons">
    <span class="separator"></span>
    <input id="key" class="mini-textbox" emptyText="请输入关键词" style="width:150px;" onenter="onKeyEnter"/>
    <a class="mini-button" onclick="search()">查询</a>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    Web.util.load("datagrid1");
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }

    function onAdd() {
        Web.util.openMiniWindow('添加仪器',"<%=request.getContextPath()%>/work/f100604/loadInstrumentAdd",700,300,function () {
            Web.util.reload("datagrid1");
        })
    }
    function onUpdate() {
           var bmz001=mini.get("datagrid1").getSelected().bmz001;
            Web.util.openMiniWindow('更新仪器','<%=request.getContextPath()%>/work/f100604/loadInstrumentEdit?bmz001='+bmz001,700,300,function () {
                Web.util.reload("datagrid1");
            })
    }
    function onDelete() {
        var bmz001=mini.get("datagrid1").getSelected().bmz001;
        Web.util.confirm("确定要删除该仪器？",function (action) {
            Web.util.request("<%=request.getContextPath()%>/work/f100604/saveOrUpdateBz06",'post',{bmz001:bmz001,aae016:'0'},function () {
                Web.util.reload("datagrid1");
            })
        });
    }
    function search() {
        var grid=mini.get("datagrid1");
        var key = mini.get("key").getValue();
       grid.load({ bmz002: key });
    }
    function onKeyEnter(e) {
        search();
    }
</script>
</html>
