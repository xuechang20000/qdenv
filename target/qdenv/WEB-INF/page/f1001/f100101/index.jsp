<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
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
    <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true"
         url="<%=request.getContextPath()%>/admin/queryAllUser"  idField="userId">
            <div property="columns">
            <div field="userId" width="120" headerAlign="center" allowSort="true">用户ID</div>
            <div field="loginname" width="120" headerAlign="center" allowSort="true">用户账号</div>
            <div field="name" width="120" headerAlign="center" allowSort="true">姓名</div>
            <div field="ctime" width="100" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" allowSort="true">创建日期</div>
            <div headerAlign="center"  renderer="renderUser">操作</div>
        </div>
    </div>

    <span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onUpdate()" plain="true" iconCls="icon-edit" >修改</a>
        <a class="mini-button" href="javascript:onDelete()" plain="true" iconCls="icon-remove">删除</a>
    </span>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    Web.util.load("datagrid1");
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onAdd() {
        Web.util.openMiniWindow('添加用户',"<%=request.getContextPath()%>/admin/loadUserAdd",700,250,function () {
            Web.util.reload("datagrid1");
        })
    }
    function onUpdate() {
           var userId=mini.get("datagrid1").getSelected().userId;
            Web.util.openMiniWindow('更新用户','<%=request.getContextPath()%>/admin/loadEditUserInfo?userId='+userId,700,250,function () {
                Web.util.reload("datagrid1");
            })
    }
    function onDelete() {
        var userId=mini.get("datagrid1").getSelected().userId;
        Web.util.confirm("确定要删除该账户？",function (action) {
            Web.util.request("<%=request.getContextPath()%>/admin/deleteUser",'post',{userid:userId},function () {
                Web.util.reload("datagrid1");
            })
        });
    }
</script>
</html>
