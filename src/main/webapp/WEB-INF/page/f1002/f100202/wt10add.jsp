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
            <label >样品编号：</label>
        </td>
            <td align="left">
                <input id="wst003"  name="wst003" class="mini-textbox" vtype="int" style="width:150px"  required="true" />
                <input id="wct001" name = "wct001" class="mini-textbox" visible="false" value="${param.wct001}"/>
            </td>
            <td align="right">
                <label >容器类型：</label>
            </td>
            <td align="left">
                <input id="wst002" class="mini-combobox"   textField="dictName" valueField="dictVal" style="width:150px"
                       url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WST002"   required="true" allowInput="true" nullItemText="请选择..."/>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wst004">采样时间起：</label>
            </td>
            <td align="left">
                <input id="wst004"  name="wst004" class="mini-datepicker" style="width:150px" required="true"
                       format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" />
            </td>
            <td align="right">
                <label for="wst005">采样时间止：</label>
            </td>
            <td align="left">
                <input id="wst005"  name="wst005" class="mini-datepicker" style="width:150px" required="true"
                       format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wst006">采样设备：</label>
            </td>
            <td align="left">
                <input name="wst006" class="mini-combobox" textField="bmz002" valueField="bmz001" id="wst006" style="width:150px"
                        onvaluechanged="onSelectWst006"   popupWidth="220"  url="<%=request.getContextPath()%>/work/f100604/queryBz06List?aae016=1&bmz003=1" />
            </td>
            <td align="right">
                <label for="wst007">采样设备编号：</label>
            </td>
            <td align="left">
                <input name="wst007" class="mini-combobox" textField="text" valueField="text" id="wst007" style="width:150px"
                        popupWidth="220" />
            </td>
        </tr>
    <tr>
    <td align="right">
        <label for="wxt001s">对应检测项目：</label>
    </td>
    <td colspan="3">

        <div id="wxt001s" class="mini-checkboxlist" repeatItems="3" repeatLayout="table"
             textField="bcz002" valueField="wxt001"  >
        </div>
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
        var url="${pageContext.request.contextPath}/work/f100202/saveWt10"
        var data = form.getData(true);
        data.wxt001s=mini.get("wxt001s").getValue();
        data.wst002=mini.get("wst002").getValue();
        data.wst003=wct001+data.wst002+data.wst003;
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
        var wst006=mini.get("wst006").getValue();
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
            mini.get("wst007").set({data:wst007s})
        })

    }
    function doReset() {
        form.reset();
        mini.get("wft001").setValue(wft001);
    }
</script>
</html>
