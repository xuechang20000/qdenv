<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
    #form1{position: relative; top: 40%;  transform: translateY(-50%); }
    #form1 table {margin:0px auto}
    #form1 table td{padding: 3px}
    </style>
</head>
<body>
<div id="form1" >
    <input name="wat001" class="mini-hidden"  value="${param.wat001}" />
    <table>
        <tr>
            <td align="right">
                <label >委托编号：</label>
            </td>
            <td align="left">
                <span id="span_wat002" style="color: red;font-size: 16px"></span>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wat010">收件地址：</label>
            </td>
            <td align="left">
                <input id="wat010"  name="wat010" style="width:300px" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wat011">收件人：</label>
            </td>
            <td align="left">
                <input id="wat011"  name="wat011" style="width:200px" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wat012">联系电话：</label>
            </td>
            <td align="left">
                <input id="wat012"  name="wat012"  style="width:200px" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft017">发票信息：</label>
            </td>
            <td align="left">
                <input id="wft017"  name="wft017" style="width:200px" class="mini-textbox"  />
                <input id="wft001"  name="wft001" visible="false" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wat013">邮寄日期：</label>
            </td>
            <td align="left">
                <input id="wat013"  name="wat013" class="mini-datepicker" style="width: 200px;"
                       format="yyyy-MM-dd H:mm" timeFormat="H:mm" />
            </td>
        </tr>
        <td align="right">
            <label for="wat019">快递公司：</label>
        </td>
        <td>
            <input id="wat019" class="mini-combobox" style="width: 200px;"  textField="dictName" valueField="dictVal"
                   url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WAT019"   required="true" allowInput="true" nullItemText="请选择..."/>
        </td>
        <tr>
            <td align="right">
                <label for="wat014">快递单号：</label>
            </td>
            <td align="left">
                <input id="wat014"  name="wat014" style="width: 200px;" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="aae013">备注：</label>
            </td>
            <td>
                <input id="aae013" name="aae013" style="width: 300px;"  class="mini-textarea" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a></td>
        </tr>
    </table>
</div>
</body>
</html>
<script type="text/javascript">

    mini.parse();
    var form = new mini.Form("#form1");
    var wat001=${param.wat001}
        loadWt();
    function loadWt() {
        var url="${pageContext.request.contextPath}/work/f100201/queryWtList";
        Web.util.request(url,'post',{wat001:wat001},function (data) {
            $("#span_wat002").html(data[0].wat002);
            mini.get("wat010").setValue(data[0].wat010);
            mini.get("wat011").setValue(data[0].wat011);
            mini.get("wat012").setValue(data[0].wat012);
            mini.get("wft001").setValue(data[0].wft002);
            mini.get("aae013").setValue(data[0].aae013);
            mini.get("wat014").setValue(data[0].wat014);
            mini.get("wat013").setValue(data[0].wat013);
            mini.get("wat019").setValue(data[0].wat019);

        })
    }
    function doSubmit() {
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var url="${pageContext.request.contextPath}/work/f100201/saveWtAttach"
        var data = form.getData(true);
        data.wat019=mini.get("wat019").getValue();
        data.wat013=mini.get("wat013").getFormValue();
        Web.util.request(url,"post",data,function () {
            Web.util.showTips("保存成功")
            mini.get('doSubmit').disable()
        })
    }
</script>
</html>
