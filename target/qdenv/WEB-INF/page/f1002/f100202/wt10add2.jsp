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
<div id="form1" >
<br>
    <table>
        <tr>
            <td align="right">
                <label for="wxt007">采样设备：</label>
            </td>
            <td align="left">
                <input name="wxt007" class="mini-combobox" textField="bmz002" valueField="bmz001" id="wxt007" style="width:150px"
                        onvaluechanged="onSelectWst006"   popupWidth="220"  url="<%=request.getContextPath()%>/work/f100604/queryBz06List?aae016=1&bmz003=1" />
            </td>
            <td align="right">
                <label for="wxt014">采样设备编号：</label>
            </td>
            <td align="left">
                <input name="wxt014" class="mini-combobox" textField="text" valueField="text" id="wxt014" style="width:150px"
                        popupWidth="220" />
            </td>
        </tr>
    <tr>
    <td align="right">
        <label for="wxt001s">对应检测项目：</label>
    </td>
    <td colspan="3">

        <div id="wxt001s" class="mini-radiobuttonlist" repeatItems="3" repeatLayout="table"
             textField="bcz002" valueField="wxt001"  >
        </div>
    </td>
    </tr>
        <tr>
            <td align="right">
                <label for="wxt002">检测值：</label>
            </td>
            <td colspan="3">
                <input id="wxt002"  name="wxt002" class="mini-textbox"   required="true" />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="aae013">备注：</label>
            </td>
            <td colspan="3">

                <input id="aae013" name="aae013" class="mini-textarea" style="width: 300px;height: 40px">                </input>
            </td>

        </tr>
        <tr>
            <td></td>
            <td><a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
                &nbsp;&nbsp;<a class="mini-button" href="javascript:doReset();" id="doReset" visible="false"  iconCls="icon-redo" >重置</a></td>
        </tr>
    </table>
</div>
</body>
</html>
<script type="text/javascript">

    mini.parse();
    var wct001='${param.wct001}'
    var form = new mini.Form("#form1");
    loadWxt001s();
    function doSubmit() {
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var url="${pageContext.request.contextPath}/work/f100202/updateWt04"
        var data = form.getData(true);
        data.wxt007=mini.get("wxt007").getValue();
        data.wxt014=mini.get("wxt014").getValue();
        data.wxt001=mini.get("wxt001s").getValue();
        Web.util.request(url,"post",data,function () {
            Web.util.showTips("保存成功");
            mini.get('doSubmit').disable()
        })
    }
    function loadWxt001s() {
        var url ='${pageContext.request.contextPath}/work/f100201/queryWt03'
        Web.util.formLoad("form1",url,"post",{wct001:wct001},function (data) {
            var wt04list=data.wt04DtoList,i=0,wxt001s=[];
            for(var wt04;wt04=wt04list[i++];){
                var row={wxt001:wt04.wxt001,bcz002:wt04.bcz002}
                wxt001s.push(row)
            }
            mini.get("wxt001s").loadData(wxt001s);
        });
    }
    function onSelectWst006() {
        var wst006=mini.get("wxt007").getValue();
        var url="${pageContext.request.contextPath}/work/f100604/queryBz06List";
        Web.util.request(url,"post",{bmz001:wst006},function (data) {
            var bmz004s,wst007s=[];
            if(data[0]){
                if (bmz004s=data[0].bmz004){
                    var bmz004Array=bmz004s.split(",");
                    for (var i=0;i< bmz004Array.length;i++){
                        if(bmz004Array[i]) wst007s.push({"text":bmz004Array[i]})
                    }
                }
            }
            mini.get("wxt014").set({data:wst007s})
        })

    }
    function doReset() {
        form.reset();
        mini.get("wft001").setValue(wft001);
    }
</script>
</html>
