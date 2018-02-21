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
         url="<%=request.getContextPath()%>/work/f100601/queryHangye"  idField="userId">
            <div property="columns">
            <div field="bhz001"  headerAlign="center" allowSort="true">ID</div>
            <div field="bhz003"  headerAlign="center" allowSort="true">行业代码</div>
                <div field="bzh002"  headerAlign="center" allowSort="true">行业名称</div>
            <div field="aae016"  headerAlign="center" allowSort="true" renderer="oncodeRender">有效标志</div>
            <div field="aae013"  headerAlign="center" allowSort="true">备注</div>
            <div headerAlign="center"  renderer="renderUser">操作</div>
        </div>
    </div>

    <span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onDelete()" plain="true" iconCls="icon-remove">删除</a>
    </span>
     <div id="buttons">
         <span class="separator"></span>
         <a class="mini-button" iconCls="icon-add" plain="true" onclick="onAdd()">添加</a>
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
        Web.util.openMiniWindow('添加',"<%=request.getContextPath()%>/work/f100601/loadHangyeAdd",700,250,function () {
            Web.util.reload("datagrid1");
        })
    }
    function onDelete() {
        var bhz001=mini.get("datagrid1").getSelected().bhz001;
        Web.util.confirm("确定要删除？",function (action) {
            Web.util.request("<%=request.getContextPath()%>/work/f100601/updateHangye",'post',{bhz001:bhz001,aae016:0},function () {
                Web.util.reload("datagrid1");
            })
        });
    }
</script>
</html>
