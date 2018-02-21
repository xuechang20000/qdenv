<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>


<div class="mini-fit" style="height:100%;">
    <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true" pagerButtons="#buttons"
         url="<%=request.getContextPath()%>/work/f100602/queryBiaozhun"  idField="bbz001">
        <div property="columns">
            <div field="bbz001" width="20"  headerAlign="center" allowSort="true">ID</div>
            <div field="bbz002" width="140"width="20" headerAlign="center" allowSort="true">标准名称</div>
            <div field="bbz003" width="40" headerAlign="center" allowSort="true">标签名称</div>
            <div field="bbz004" width="80" headerAlign="center" allowSort="true">标准代码</div>
            <!--<div field="bbz005"  width="40" headerAlign="center" allowSort="true">标准年度</div>-->
            <div field="bzh002s"  width="100" headerAlign="center" allowSort="true">所属行业</div>
            <div field="bbz006"  width="50" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd" allowSort="true">建立时间</div>
            <div field="aae016"  width="40" headerAlign="center" allowSort="true" renderer="oncodeRender">有效标志</div>
            <div field="aae013"  headerAlign="center" allowSort="true">说明</div>
            <div headerAlign="center" width="120"  renderer="renderUser">操作</div>
        </div>
    </div>

    <span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onDelete()" plain="true" iconCls="icon-edit">编辑</a>
         <a class="mini-button" href="javascript:onCopy()" plain="true" iconCls="icon-addnew">复制</a>
        <a class="mini-button" href="javascript:onEdit()" plain="true" iconCls="icon-node">维护</a>
    </span>
    <div id="buttons">
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-add" plain="true" onclick="onAdd()">添加</a>
        <span class="separator"></span>
        <input id="key" class="mini-textbox" emptyText="请输入关键词" style="width:150px;" onenter="onKeyEnter"/>
        <a class="mini-button" onclick="search()">查询</a>
    </div>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    Web.util.load("datagrid1");
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }

    function onAdd() {
        Web.util.openMiniWindow('添加',"<%=request.getContextPath()%>/work/f100602/loadBiaoZhunAdd",500,300,function () {
            Web.util.reload("datagrid1");
        })
    }
    function onEdit() {
        var bbz001=mini.get("datagrid1").getSelected().bbz001;
        var bbz002=mini.get("datagrid1").getSelected().bbz002;
        var url="<%=request.getContextPath()%>/work/f100602/loadBiaoZhunEdit?bbz001="+bbz001;
        window.location.href=url;
    }
    function onCopy() {
        var bhz001=mini.get("datagrid1").getSelected().bhz001;
        Web.util.openMiniWindow('复制',"<%=request.getContextPath()%>/work/f100602/loadBiaoZhunCopy",500,300,function () {
            //Web.util.reload("datagrid1");
        })
    }
    function onDelete() {
        var bbz001=mini.get("datagrid1").getSelected().bbz001;
        Web.util.openMiniWindow('编辑',"<%=request.getContextPath()%>/work/f100602/loadBiaoZhunDelete?bbz001="+bbz001,500,300,function () {
            Web.util.reload("datagrid1");
        })
    }
    function search() {
        var grid=mini.get("datagrid1");
        var key = mini.get("key").getValue();
        if(isChinese(key)){
            grid.load({ bbz002: key });
        }else{
            grid.load({ bbz004: key });
        }
    }
    function onKeyEnter(e) {
        search();
    }
</script>
</html>
