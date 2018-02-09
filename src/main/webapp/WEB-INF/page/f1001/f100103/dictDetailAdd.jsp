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
                字典代码：
            </td>
            <td class="form-td-odd">
                <input id="dictCode"  name="dictCode" class="mini-textbox" style="width:200px;" value="${param.dictCode}" enabled="false"/>
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                字典项名称：
            </td>
            <td class="form-td-odd">
                <input id="dictName"  name="dictName" class="mini-textbox" style="width:200px;" required="true"  />
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
    var dictCode='${param.dictCode}';
    function submitForm() {
        var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
                //提交表单数据
                var url = '<%=request.getContextPath()%>/admin/addAppDictDetail';
                var form = new mini.Form("#form1");
                var data = form.getData(true);      //获取表单多个控件的数据
                data.dictCode=dictCode;
                data.priority = 1;
                data.status = '1';
                Web.util.requestAsync(url,'',data,function(data,textstatus){
                    Web.util.showTips("保存成功！ ");
                    mini.get("doSubmit").disable();
                });
    }
</script>
</html>
