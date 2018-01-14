<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>
<div id="form1" >
    <input id="userId"  name="userId" class="mini-textbox" visible="false"/>
    <table  class="form-table">
        <colgroup align="right" width="30%"></colgroup>
        <colgroup align="left" width="70%"></colgroup>
        <tr>
            <td class="form-td-even">
                帐号：
            </td>
            <td class="form-td-odd">
                <input id="loginname"  name="loginname" class="mini-textbox" style="width:200px;" required="true" enabled="false"/>
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                用户名：
            </td>
            <td class="form-td-odd">
                <input id="name"  name="name" class="mini-textbox" enabled="false" style="width:200px;" required="true" onvalidation="onChineseValidation" />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                性别：
            </td>
            <td class="form-td-odd">
                <div id="sex" class="mini-radiobuttonlist" enabled="false"
                     textField="text" valueField="id" data="[{'id':'1','text':'男'},{'id':'2','text':'女'}]">
                </div>
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                角色：
            </td>
            <td class="form-td-odd">
                <div id="roles" class="mini-checkboxlist"  textField="roleName" valueField="roleId" enabled="false"
                     url="<%=request.getContextPath()%>/admin/queryAllRole" >
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    var dtoJson=${dtoJson};
    loadForm();
    function loadForm() {
        mini.get("loginname").setValue(dtoJson.loginname);
        mini.get("name").setValue(dtoJson.name);
        mini.get("sex").setValue(dtoJson.sex);
        mini.get("userId").setValue(dtoJson.userId);
        var rs='';
        var roles=dtoJson.appRoles;
        for(var i=0;i<roles.length;i++){
            rs+=','+roles[i].roleId;
        }
        mini.get("roles").setValue(rs);
    }
</script>
</html>
