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
            <td>签名方式：</td>
            <td><input id="wbt016" class="mini-combobox" style="width:100px;" textField="text" valueField="wbt016" emptyText="请选择..."
                       data="[{'wbt016':'1','text':'电子签名'},{'wbt016':'2','text':'手工签名'}]" onvaluechanged="onWbt016ch"  required="true" allowInput="true" showNullItem="true" nullItemText="请选择..."/>   </td>
        </tr>
        <tr>
            <td>签发人：</td>

            <td> <input id="wbt010" class="mini-combobox"  textField="name" valueField="userId"
                        url="<%=request.getContextPath()%>/admin/queryAllUser" value="${user.userId}"  required="true" allowInput="true" nullItemText="请选择..."/>
            </td>
        </tr>
        <tr id="sign" >
            <td>电子签名授权码:</td>
            <td><input id="ext1" name="ext1" style="width: 140px;"  class="mini-textbox" required="true"/></td>
        </tr>
        <tr>
            <td></td>
            <td class="form-td-odd">
                <a class="mini-button" iconCls="icon-save" id="doSubmit" onclick="submitForm()">签发</a>
            </td>

        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    $("#sign").hide();
    var wbt001=${param.wbt001}
    function submitForm() {
        var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var url="${pageContext.request.contextPath}/work/f100201/updateWt02";
        var wbt010=mini.get("wbt010").getValue();
        var wbt016=mini.get("wbt016").getValue();
        var ext1=mini.get("ext1").getValue();
        Web.util.confirm("是否确定签发？",function () {

            Web.util.request(url,"post",{wbt001:wbt001,wbt010:wbt010,wbt016:wbt016,ext1:ext1,flag:"3"},function () {
                Web.util.showTips("已签发");
                    mini.get("doSubmit").disable();
            })
        })
    }
    function onWbt016ch() {
        var wbt016=mini.get("wbt016").getValue();
        if("1"==wbt016){
           $("#sign").show();
        }else{
            $("#sign").hide();
        }
    }
</script>
</html>
