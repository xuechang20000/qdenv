<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
    #form1{ }
    #form1 table {margin:0px auto}
    #form1 table td{padding: 3px}
    </style>
</head>
<body>
<br/>
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
            <td align="right">
                <label for="daw002">委托单位：</label>
            </td>
            <td align="left">
                <input id="daw002"  name="daw002" enabled="false" style="width:200px" class="mini-textbox"  />
                <input id="wft001"  name="wft001" visible="false" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft002">采样费用：</label>
            </td>
            <td align="left">
                <input id="wft002"  name="wft002" enabled="false" style="width:200px" class="mini-textbox"  />¥

            </td>
            <td align="right">
                <label for="wft004">检测费用：</label>
            </td>
            <td align="left">
                <input id="wft004"  name="wft004" enabled="false" style="width:200px" class="mini-textbox"  />¥
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft006">折扣率：</label>
            </td>
            <td align="left">
                <input id="wft006"  name="wft006" vtype="float" enabled="false" style="width:200px" class="mini-textbox"  />
            </td>
            <td align="right">
                <label for="wft007">应收总费用：</label>
            </td>
            <td align="left">
                <input id="wft007"  name="wft007" vtype="float" enabled="false" style="width:200px" class="mini-textbox"
                        />¥
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft008">实收费用：</label>
            </td>
            <td align="left">
                <input id="wft008"  name="wft008"   style="width:200px" class="mini-textbox"  />¥
            </td>
            <td align="right">
                <label for="wft009">收费类型：</label>
            </td>
            <td align="left">
                <input id="wft009" class="mini-combobox" style="width: 200px;"  textField="dictName" valueField="dictVal"
                       url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WFT009"  required="true" allowInput="true" nullItemText="请选择..."/>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft010">是否实收：</label>
            </td>
            <td align="left">
                <input id="wft010" class="mini-combobox" style="width: 200px;"  textField="dictName" valueField="dictVal"
                       url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=IS"   required="true" allowInput="true" nullItemText="请选择..."/>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wftaae013">备注：</label>
            </td>
            <td>
                <input id="wftaae013" name="wftaae013" style="width: 300px;"  class="mini-textarea" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
               </td>
        </tr>
    </table>
</div>
</body>
</html>
<script type="text/javascript">

    mini.parse();
    var form = new mini.Form("#form1");
    var grid=mini.get("datagrid");
    var wat001=${param.wat001};
    var wft001;
        loadWt();
    function loadWt() {
        var url="${pageContext.request.contextPath}/work/f100201/queryWtList";
        Web.util.formLoad("form1",url,"post",{wat001:wat001},function (data) {
            $("#span_wat002").html(data.wat002);
            var wft008=mini.get("wft008").getValue();
            if (wft008=="") {
                mini.get("wft008").setValue(data.wft007)
            }
            mini.get("wft009").setValue(data.wft009)
            mini.get("wft010").setValue(data.wft010)
        })
    }
    function doSubmit() {
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var url="${pageContext.request.contextPath}/work/f100301/updateWt05"
        var data = form.getData(true);
        data.wft009=mini.get("wft009").getValue();
        data.wft010=mini.get("wft010").getValue();
        data.aae013=mini.get("wftaae013").getValue();

        Web.util.request(url,"post",data,function () {
            Web.util.showTips("保存成功");
            mini.get('doSubmit').disable()
        })
    }
</script>
</html>
