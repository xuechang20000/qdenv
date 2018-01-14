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
                原密码：
            </td>
            <td class="form-td-odd">
                <input id="password"  name="password" class="mini-password" style="width:200px;" required="true" />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                新密码：
            </td>
            <td class="form-td-odd">
                <input id="newPassword"   name="newPassword" class="mini-password" style="width:200px;" required="true" />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                确认新密码：
            </td>
            <td class="form-td-odd">
                <input id="newPassword2"   name="newPassword2" class="mini-password" style="width:200px;" required="true" />
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
        Web.util.confirm("确定要修改？",function (action) {
                //提交表单数据
                var url = '<%=request.getContextPath()%>/admin/updatePassword';
                var form = new mini.Form("#form1");
                var data = form.getData(true);
                if(data.newPassword2!=data.newPassword){
                    Web.util.showTipsWanring("确认新密码不正确！")
                    return;
                }
                Web.util.requestAsync(url,'',data,function(data,textstatus){
                    Web.util.showTips("保存成功！下次登陆时生效 ");
                    mini.get("doSubmit").disable();
                });
            }
        );
    }

</script>
</html>
