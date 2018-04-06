<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">

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
                <label for="wat004">预约时间：</label>
            </td>
            <td>
                <input id="wat004" name="wat004" class="mini-datepicker" style="width: 200px;"
                       format="yyyy-MM-dd H:mm" timeFormat="H:mm" showTime="true" showOkButton="true" />
            </td>
        </tr>
        <tr>
        <td align="right">
            <label for="wdt001">安排人员：</label>
        </td>
        <td>
            <div id="wdt001" class="mini-checkboxlist" repeatItems="3" repeatLayout="table"
                 textField="name" valueField="userId"
                 url="<%=request.getContextPath()%>/admin/queryAllUser" >
            </div>
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
        var url="${pageContext.request.contextPath}/work/f100201/queryWt08ListByWat001";
        Web.util.request(url,'post',{wat001:wat001},function (data) {
            $("#span_wat002").html(data[0].wat002);
            mini.get("aae013").setValue(data[0].aae013);
            mini.get("wat004").setValue(data[0].wat004);
               var users='',i=0;
               for(var d;d=data[i++];){
                   users+=d.userid+",";
               }
               mini.get("wdt001").setValue(users);
        })
    }
    function doSubmit() {
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var url="${pageContext.request.contextPath}/work/f100201/saveWt08List"
        var data = form.getData(true);
        data.json1=mini.get("wdt001").getValue();
        if(data.json1=='') {
            Web.util.showTipsWanring("请选择人员")
            return;
        }
        Web.util.request(url,"post",data,function () {
            Web.util.showTips("保存成功")
            mini.get('doSubmit').disable()
        })
    }
</script>
</html>
