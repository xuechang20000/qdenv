<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        #fd2{margin-bottom: 5px;padding: 5px}
        .temp_report{margin-bottom:3px;background-color: #efefef;padding: 4px; border: 1px solid;border-color: #9c9c9c}
        .temp_report img:hover{cursor:pointer}
        .temp_report img{vertical-align:middle}
        .temp_report_title{font-weight: bold;color: #1296db}
        .temp_select_title{color:#1296db}
        .temp_select{padding-bottom: 4px}
    </style>

</head>
<body>
<jsp:include page="/include/exportExcle.jsp"/>
<fieldset id="fd2">
    <legend><span>查询条件</span></legend>
    <div id="form1" style="line-height: 28px">
        <table>
        <tr>
            <td class="form-td-even">
                选择仪器类别：
            </td>
            <td class="form-td-odd">
                <input id="bmz003" class="mini-combobox" style="width: 150px;"  textField="dictName" valueField="dictVal" onvaluechanged="onSelectBmz003"
                       url="${pageContext.request.contextPath}/admin/queryRenderedAppDictDetails?dictCode=BMZ003"   required="true" allowInput="true" nullItemText="请选择..."/>
            </td>
            <td align="right">
                <label for="wst006">设备：</label>
            </td>
            <td align="left">
                <input name="wst006" class="mini-combobox" textField="bmz002" valueField="bmz001" id="wst006" style="width:250px"
                       onvaluechanged="onSelectWst006"   popupWidth="220" allowInput="true"   />
            </td>
            <td align="right">
                <label for="wst007">编号：</label>
            </td>
            <td align="left">
                <input name="wst007" class="mini-combobox" textField="text" valueField="text" id="wst007" style="width:150px"
                       popupWidth="220" />
            </td>
            <td>
                <a class="mini-button" id="id_onSerach" iconCls="icon-search" onclick="onSerach">查询</a>
            </td>
        </tr>
        </table>

    </div>
</fieldset>
<div id="datagrid1" class="mini-datagrid" style="width:100%;height:430px;" allowResize="true"
     url="<%=request.getContextPath()%>/work/f100208/queryEquipment" pagerButtons="#exportExcel"
     idField="wat001"  pageSize='100'  sortMode="client">
    <div property="columns">
        <div field="wat001" width="40" headerAlign="center" align="center" visible="false" allowSort="true">委托id</div>
        <div field="wat002" width="60" headerAlign="center" align="center" allowSort="true">委托编号</div>
        <div field="wct002" width="60" headerAlign="center" align="center" allowSort="true">采样点</div>
        <div field="wxt007s" width="100" headerAlign="center" align="center" allowSort="true">设备名称</div>
        <div field="wxt014" width="60" headerAlign="center" align="center" allowSort="true">设备编号</div>
        <div field="bcz002" width="140" headerAlign="center"  align="center" allowSort="true" >检测项目</div>
        <div field="wxt008" width="80" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" align="center" allowSort="true" >使用时间起</div>
        <div field="wxt010" width="80" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss"  align="center" allowSort="true" >使用时间止</div>
        <div field="username" width="60" headerAlign="center"   align="center" allowSort="true" >使用人</div>
    </div>
</div>
<span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onUpdate()" plain="true" iconCls="icon-edit" >维护</a>
    </span>
</body>

<script type="text/javascript">
    mini.parse();
    var grid=mini.get("datagrid1");
   onSerach();
    function onSerach() {
        var form = new mini.Form("#form1");
        var data = form.getData(true);
        data.bmz003='1';
        data.bmz001 = mini.get("wst006").getValue();
        data.bmz004 = mini.get("wst007").getValue();
        data.bmz003 = mini.get("bmz003").getValue();
        grid.load(data);
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
    function onSelectBmz003() {
        var bmz003=mini.get("bmz003").getValue();
        var url="${pageContext.request.contextPath}/work/f100604/queryBz06List?aae016=1&bmz003="+bmz003;
        mini.get("wst006").load(url);
    }
</script>

</html>
