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
    <table  class="form-table">
        <colgroup align="right" width="30%"></colgroup>
        <colgroup align="left" width="70%"></colgroup>
        <tr>
            <td class="form-td-even">
                帐号：
            </td>
            <td class="form-td-odd">
                <input id="loginname"  name="loginname" class="mini-textbox" style="width:200px;" required="true" onvalidation="onEnglishAndNumberValidation"/>
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                用户名：
            </td>
            <td class="form-td-odd">
                <input id="name"  name="name" class="mini-textbox" style="width:200px;" required="true" onvalidation="onChineseValidation" />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                性别：
            </td>
            <td class="form-td-odd">
                <div id="sex" class="mini-radiobuttonlist"
                     textField="text" valueField="id" value="1" data="[{'id':'1','text':'男'},{'id':'2','text':'女'}]">
                </div>
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                选择角色：
            </td>
            <td class="form-td-odd">
                <div id="roles" class="mini-checkboxlist"  textField="roleName" valueField="roleId"
                     url="<%=request.getContextPath()%>/admin/queryAllRole" >
                </div>
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="form-td-odd">
                <a class="mini-button" iconCls="icon-save" id="doSubmit" onclick="submitForm()">保存</a>
            </td>

        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    function submitForm() {
        var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        Web.util.confirm("确定要保存？",function (action) {
                    //提交表单数据
                    var url = '<%=request.getContextPath()%>/admin/saveAppUserRole';
                    var form = new mini.Form("#form1");
                    var data = form.getData(true);      //获取表单多个控件的数据
                    var sex=mini.get("sex").getValue();
                    var roles=mini.get("roles").getValue();
                    if(!roles){
                        Web.util.showTipsWanring('请选择角色！');
                        return;
                    }
                    data.sex=sex;
                    data.roles=roles;
                    Web.util.requestAsync(url,'',data,function(data,textstatus){
                        //alert(data);
                        Web.util.showTips("保存成功！ ");
                        mini.get("doSubmit").disable();
                    });
            }
        );
    }
</script>
</html>
