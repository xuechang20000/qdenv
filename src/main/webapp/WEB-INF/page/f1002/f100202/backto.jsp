<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        table td{padding: 3px}
    </style>
</head>
<body>
<center>
<table align="center">
    <tr>
        <td>退回原因：</td>
        <td><input id="json1" name="json1" style="width: 240px;" class="mini-textbox" required="true"/></td>
    </tr>
    <tr>
        <td>退回到步骤：</td>
        <td><div id="wlt003" class="mini-radiobuttonlist" repeatItems="3" repeatLayout="table" repeatDirection="vertical"
                 textField="wlt002" valueField="wlt003"
                 url="${pageContext.request.contextPath}/work/f100201/queryWt06Bywlt004?wat018=${param.wat018}" >
        </div></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
        </td>
    </tr>
</table>
</center>
</body>
</html>
<script type="text/javascript">
    var wat001=${param.wat001}
    mini.parse();
    function doSubmit() {
        var value=mini.get("json1").getValue();
        if(!value) {
            Web.util.showTipsWanring("请填写退回原因！")
            return;
        }
        var wlt003=mini.get("wlt003").getValue();

        url="${pageContext.request.contextPath}/work/f100201/savePreStep";
            Web.util.request(url,"post",{wat001:wat001,wlt003:wlt003,json1:value},function (data) {
                Web.util.showTips("保存成功")
                mini.get("doSubmit").disable();
            })
    }
</script>
</html>
