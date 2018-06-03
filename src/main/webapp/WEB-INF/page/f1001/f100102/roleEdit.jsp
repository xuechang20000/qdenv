<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        fieldset{float: left;margin-left:10px;padding-left: 10px;width:390px;height: 400px;overflow: scroll}
    </style>
</head>
<body>
<fieldset id="fd1" >
    <legend><span>菜单权限</span></legend>
            <ul id="tree2" class="mini-tree" url="<%=request.getContextPath()%>/admin/queryAllAppMenu"
                style="width:200px;padding:5px;"
                showTreeIcon="true" textField="name" idField="menuId" parentField="parentMenuId" resultAsTree="false"
                showCheckBox="true" checkRecursive="false" expandOnLoad="true"
            >
            </ul>
</fieldset>
<fieldset id="fd2" >
    <legend><span>资源权限</span></legend>
            <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:380px;" allowResize="true" pageSize="100"
                 url="<%=request.getContextPath()%>/admin/queryAllAppResource" multiSelect="true"   idField="resourceId">
                <div property="columns">
                    <div type="checkcolumn" ></div>
                    <div field="resourceId" width="30" headerAlign="center" allowSort="true">资源ID</div>
                    <div field="resourceCode" width="50" headerAlign="center" allowSort="true">资源代码</div>
                    <div field="resourceName" width="80" headerAlign="center" allowSort="true">资源名称</div>
                </div>
            </div>
</fieldset>

            <div style="clear: both;text-align: center;">
                <br/>
                <a class="mini-button" iconCls="icon-save" id="doSubmit" onclick="submitForm()">保存</a>
            </div>


</body>
<script type="text/javascript">
    mini.parse();
    var tree=mini.get("tree2");
    var grid=mini.get("datagrid1");
    var dtoJson=${dtoJson}
    var appMenuList=dtoJson.appMenuList;
    var appResourceList=dtoJson.appResourceList;
    grid.load({},function () {
        grid.selects(appResourceList);
    });
    //设置菜单
    setMenus();

    function setMenus() {
            var ms='';
            for(var i=0;i<appMenuList.length;i++){
                ms+=','+appMenuList[i].menuId;
            }
            tree.setValue(ms);
     }
    function submitForm() {
        var menus=tree.getValue();
        var rows=grid.getSelecteds();
        Web.util.request("<%=request.getContextPath()%>/admin/updateAppRolePermission","post",
            {"roleId":dtoJson.roleId,"menus":menus,"resources":JSON.stringify(rows)},function () {
                mini.get("doSubmit").disable();
                Web.util.showTips("保存成功！")
            })
    }
</script>
</html>
