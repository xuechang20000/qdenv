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
<div id="datagrid" class="mini-datagrid" style="width: 100%;height: 150px;" allowResize="true" pageSize="10"
     onrowclick="onrowclick" idField="wft020">
    <div property="columns">
        <div field="wft020" width="20" headerAlign="center" >ID</div>
        <div field="wft012" width="100" headerAlign="center" >发票抬头</div>
        <div field="wft013" width="70" headerAlign="center" >税号</div>
        <div field="wft018" width="80" headerAlign="center" >开户行</div>
        <div field="wft019" width="80" visible="false" headerAlign="center" >账号</div>
        <div field="aac147" width="80" visible="false" headerAlign="center" >身份证号</div>
        <div field="wft016" width="80" visible="false" headerAlign="center" >开票时间</div>
        <div field="wft014" width="50" headerAlign="center" >开票金额</div>
        <div field="wft017" width="60" headerAlign="center" >发票号</div>
        <div field="aae006" width="80" visible="false" headerAlign="center" >地址</div>
        <div field="aae005" width="80" visible="false" headerAlign="center" >电话</div>
        <div field="aae016" width="40" headerAlign="center" renderer='oncodeRender'>有效标志</div>
        <div field="aae013" width="80" visible="false"headerAlign="center" >备注</div>
        <div field="wft022" width="80" visible="false"headerAlign="center" >发票类型</div>
        <div headerAlign="center" width="40" visible="false" renderer="renderUser">操作</div>
    </div>
</div>
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
                <label for="wft020">发票ID：</label>
            </td>
            <td align="left">
                <input id="wft020"  name="wft020" enabled="false" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft012">发票抬头：</label>
            </td>
            <td align="left">
                <input id="wft012"  name="wft012" style="width:300px" class="mini-textbox"  />

                <input id="wft001"  name="wft001"  visible="false" class="mini-textbox"  />
            </td>
            <td align="right">
                <label for="wft013">税号：</label>
            </td>
            <td align="left">
                <input id="wft013"  name="wft013"  style="width:200px" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft014">开票金额：</label>
            </td>
            <td align="left">
                <input id="wft014"  name="wft014" vtype="float" enabled="false" style="width:200px" class="mini-textbox"  />
            </td>
            <td align="right">
                <label for="wft016">开票时间：</label>
            </td>
            <td align="left">
                <input id="wft016"  name="wft016" class="mini-datepicker" enabled="false"  style="width: 200px;"
                       format="yyyy-MM-dd" />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft017">发票号：</label>
            </td>
            <td align="left">
                <input id="wft017"  name="wft017"   style="width:200px" enabled="false"  class="mini-textbox"  />
            </td>
            <td align="right">
                <label for="aae006">地址：</label>
            </td>
            <td align="left">
                <input id="aae006"  name="aae006" style="width:300px" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="aae005">电话：</label>
            </td>
            <td align="left">
                <input id="aae005"  name="aae005"  style="width:200px" class="mini-textbox"  />
            </td>
            <td align="right">
                <label for="wft018">开户行：</label>
            </td>
            <td align="left">
                <input id="wft018"  name="wft018" style="width:200px" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft019">账号：</label>
            </td>
            <td align="left">
                <input id="wft019"  name="wft019" style="width: 200px;" class="mini-textbox"  />
            </td>
            <td align="right">
                <label for="aac147">身份证号：</label>
            </td>
            <td align="left">
                <input id="aac147"  name="aac147" style="width: 200px;" class="mini-textbox"  />
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="wft022">发票类型：</label>
            </td>
            <td align="left">
                <input id="wft022" class="mini-combobox" style="width: 150px;"  textField="dictName" valueField="dictVal"
                       url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WFT022"   required="true" allowInput="true" nullItemText="请选择..."/>
            </td>
            <td align="right">
                <label for="aae013">备注：</label>
            </td>
            <td>
                <input id="aae013" name="aae013" style="width: 300px;"  class="mini-textarea" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
                &nbsp;&nbsp;<a class="mini-button" href="javascript:doReset();" id="doReset" visible="false"  iconCls="icon-redo" >重置</a></td>
        </tr>
    </table>
</div>
<span id="grid_buttons" style="display: none"  >
         <a class="mini-button" href="javascript:onRemove()" plain="true" iconCls="icon-remove">删除</a>
    </span>
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
        Web.util.request(url,'post',{wat001:wat001},function (data) {
            $("#span_wat002").html(data[0].wat002);
            wft001=data[0].wft001;
            mini.get("wft001").setValue(data[0].wft001);
            mini.get("aae006").setValue(data[0].daw005);
            mini.get("aae005").setValue(data[0].daw004);
            url="${pageContext.request.contextPath}/work/f100201/queryWt07List"
            Web.util.request(url,"post",{wft001:wft001,aae016:'1'},function (data1) {
                if (data1.length>0){
                    var i=0;
                    grid.clearRows();
                    for (var d;d=data1[i++];){
                        grid.addRow({wft020:d.wft020,wft012:d.wft012,wft013:d.wft013,wft014:d.wft014,wft018:d.wft018,
                            wft019:d.wft019,aac147:d.aac147,aae016:d.aae016,aae006:d.aae006,wft016:d.wft016,
                            aae005:d.aae005,wft017:d.wft017,wft022:d.wft022,aae013:d.aae013})
                    }
                }

            })
        })
    }
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onRemove() {
        var row=grid.getSelected();
        var url="${pageContext.request.contextPath}/work/f100201/saveWt07";
        var data={wft020:row.wft020,aae016:"0",wft015:"0"};
        Web.util.request(url,"post",data,function () {
            Web.util.showTips("删除成功");
            loadWt();
        })
    }
    function onrowclick(e) {
        mini.get("wft020").setValue(e.record.wft020) ;
        mini.get("wft012").setValue(e.record.wft012) ;
        mini.get("wft013").setValue(e.record.wft013) ;
        mini.get("wft014").setValue(e.record.wft014) ;
        mini.get("wft016").setValue(e.record.wft016) ;
        mini.get("wft017").setValue(e.record.wft017) ;
        mini.get("wft018").setValue(e.record.wft018) ;
        mini.get("wft019").setValue(e.record.wft019) ;
        mini.get("aae006").setValue(e.record.aae006) ;
        mini.get("aae005").setValue(e.record.aae005) ;
        mini.get("aac147").setValue(e.record.aac147) ;
        mini.get("aae013").setValue(e.record.aae013) ;
        mini.get("wft022").setValue(e.record.wft022) ;
        mini.get("doSubmit").enable();
    }
    function doSubmit() {
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var url="${pageContext.request.contextPath}/work/f100201/saveWt07"
        var data = form.getData(true);
        data.wft022=mini.get("wft022").getValue();
        Web.util.request(url,"post",data,function () {
            Web.util.showTips("保存成功");
            mini.get('doSubmit').disable()
            loadWt();
        })
    }
    function doReset() {
        form.reset();
        mini.get("wft001").setValue(wft001);
    }
</script>
</html>
