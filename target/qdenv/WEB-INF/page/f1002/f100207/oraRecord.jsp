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
<div id="datagrid" class="mini-datagrid" style="width: 100%;height: 250px;" allowResize="true" pageSize="10" pagerButtons="buttons"
    url="${pageContext.request.contextPath}/work/f100207/queryWt11Page"  idField="wbt001">
    <div property="columns">
        <div field="wrt001" width="20" headerAlign="center" visible="false">原始记录ID</div>
        <div field="bcz001" width="20" headerAlign="center" visible="false">检测项目ID</div>
        <div field="wct001" width="20" headerAlign="center" visible="false">采样点ID</div>
        <div field="wst001" width="20" headerAlign="center" visible="false">样品ID</div>
        <div field="bcz002" width="100" headerAlign="center" >检测项目</div>
        <div field="wrt008" width="30" headerAlign="center" >步骤序号</div>
        <div field="wrt002" width="70" headerAlign="center" >步骤</div>
        <div field="wrt003" width="30" headerAlign="center" >阴阳性</div>
        <div field="wrt004" width="100" headerAlign="center" >检测值</div>
        <div field="wrt005" width="30" headerAlign="center" >结果值</div>
        <div field="wrt006" width="80" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss">录入时间</div>
        <!--<div field="wrt007" width="70" headerAlign="center" >录入人</div>-->
        <div field="aae013" width="80" headerAlign="center" >备注</div>
    </div>
</div>
<fieldset id="fd1" style="width:100%;">

    <legend><span>添加步骤</span></legend>
    <div class="fieldset-body">
        <div id="form1" >
        <table class="form-table" border="0" width="90%" cellpadding="1" cellspacing="2">
            <tr>
                <td class="form-label" style="width:180px;" align="right">步骤：</td>
                <td style="width:350px" align="left">
                    <input id="wrt002" class="mini-combobox" style="width:300px;" textField="dictVal" valueField="dictVal" emptyText=""
                           url="${pageContext.request.contextPath}/work/f100207/queryBcz013List?bcz001=${param.bcz001}" value=""  required="true" allowInput="true" showNullItem="true" nullItemText="请选择..."/>
                </td>
                <td class="form-label" align="right">结果类别：</td>
                <td align="left">
                    <input name="type" id="type" class="mini-radiobuttonlist" onvaluechanged="selectType" data="[{id: 1, text: '阴性阳性'}, {id: 2, text: '检测值'}]"/>
                </td>
            </tr>
            <tr  id="type1" >
                <td class="form-label" align="right">检测结果：</td>
                <td align="left" colspan="2">
                    <input name="wrt003" id="wrt003" class="mini-radiobuttonlist" data="[{id: '阴性', text: '阴性'}, {id: '阳性', text: '阳性'}]"/>
                </td>
            </tr>
            <tr id="type2">
                <td class="form-label" align="right">检测结果,以英文状态下","间隔：</td>
                <td align="left">
                    <input name="wrt004" id="wrt004" class="mini-textbox" required="true" style="width:300px;"/>
                </td>
                <td>
                    <a class="mini-button" href="javascript:doAvg();" id="doAvg">求平均</a>
                    <label for="wrt005">结果值</label><input name="wrt005" id="wrt005" class="mini-textbox" required="true" style="width:50px;"/>
                </td>
            </tr>
            <tr>
                <td class="form-label" align="right">备注：</td>
                <td colspan="3" align="left">
                    <input name="aae013" class="mini-textarea" style="width:300px;height:40px;"/>
                </td>
            </tr>
            <tr><td colspan="4" align="center">
                <a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
                <a class="mini-button" href="javascript:doReset();"  iconCls="icon-redo" >重置</a>
            </td></tr>
        </table>
    </div>
    </div>
</fieldset>
<div id="buttons">
    <span class="separator"></span>
    <a class="mini-button" iconCls="icon-remove" plain="true" onclick="deleteWt11()"></a>
</div>
</body>
</html>
<script type="text/javascript">
    mini.parse();
    var grid=mini.get("datagrid");
    var wxt001=${param.wxt001};
    var wst001=${param.wst001};
    var wct001=${param.wct001};
    var bcz001=${param.bcz001};
    $("#type1").hide();
    $("#type2").hide();
    onSerach()
    function onSerach(){
        grid.load({wst001:wst001,wxt001:wxt001});
    }
    function deleteWt11() {
        var row=grid.getSelected();
        var url='${pageContext.request.contextPath}/work/f100207/deleteWt11';
        Web.util.request(url,"post",{wrt001:row.wrt001},function (data) {
            onSerach()
        })
    }
    function selectType() {
        var type=mini.get("type").getValue();
        if("1"==type){
            $("#type1").show();
            $("#type2").hide();
            mini.get("wrt004").setValue("");
            mini.get("wrt005").setValue("");
        }else{
            $("#type1").hide();
            $("#type2").show();
            mini.get("wrt003").setValue("");
        }
    }
    function doAvg() {
        var wrt004=mini.get("wrt004").getValue();
        if(!wrt004) return;
        if(wrt004.indexOf("，")>0){
            Web.util.showTipsWanring('值列表请用英文状态下”,“间隔！');
            return;
        }
        var sum=0,wrt004s=wrt004.split(",");
        for (var i=0;i<wrt004s.length;i++){
            sum=sum+parseFloat(wrt004s[i]);
        }
        mini.get("wrt005").setValue(sum/wrt004s.length);
    }
    function doSubmit() {
        var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var data = form.getData(true);
        data.wst001=wst001;
        data.wxt001=wxt001;
        data.wct001=wct001;
        data.bcz001=bcz001;
        data.wrt002=mini.get("wrt002").getValue();
        var url='${pageContext.request.contextPath}/work/f100207/saveWt11';
        Web.util.request(url,"post",data,function (data) {
            onSerach();
            mini.get("doSubmit").disable();
        })
    }
    function doReset() {
        var form = new mini.Form("#form1");
        form.reset();
        mini.get("wrt002").load("${pageContext.request.contextPath}/work/f100207/queryBcz013List?bcz001=${param.bcz001}");
        mini.get("doSubmit").enable();
    }
</script>
</html>
