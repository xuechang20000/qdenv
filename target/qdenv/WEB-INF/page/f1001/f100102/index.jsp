<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <%@include file="/include/head.jsp"%>
<body>

<div style="width: 100%; padding-bottom: 3px">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px; border: 0px">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" onclick="onAdd()" visible="false">增加</a>
                </td>
            </tr>
        </table>
    </div>
</div>
<div class="mini-fit" style="height:100%;">
    <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true"
         url="<%=request.getContextPath()%>/admin/queryAllRoleList"  idField="userId">
        <div property="columns">
            <div field="roleId" width="120" headerAlign="center" allowSort="true">角色ID</div>
            <div field="roleCode" width="120" headerAlign="center" allowSort="true">角色代码</div>
            <div field="roleName" width="120" headerAlign="center" allowSort="true">角色名称</div>
            <div headerAlign="center"  renderer="renderUser">操作</div>
        </div>
    </div>

    <span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onUpdate()" plain="true" iconCls="icon-edit" >编辑</a>
    </span>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    Web.util.load("datagrid1");
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onUpdate() {
        var roleId = mini.get("datagrid1").getSelected().roleId;
        Web.util.openMiniWindow('编辑角色', '<%=request.getContextPath()%>/admin/loadEditRoleInfoPage?roleId=' + roleId, 850, 500, function () {
            Web.util.reload("datagrid1");
        });
    }
</script>
</html>
