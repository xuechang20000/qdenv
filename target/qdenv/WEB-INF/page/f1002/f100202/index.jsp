<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
<%@include file="/include/head.jsp"%>
    <style type="text/css">
        #fd2{margin-bottom: 5px;padding: 5px}
    </style>

</head>
<body>
<fieldset id="fd2">
    <legend><span>查询条件</span></legend>
    <div id="form1" >
    自：
    <input class="mini-datepicker" style="width:100px;" id="s_date" name="s_date"  />
    至
    <input class="mini-datepicker" style="width:100px;" id="e_date" name="e_date" />
    <input id="wat003" class="mini-combobox" style="width: 150px;"  textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WAT003"   allowInput="true" showNullItem="true" emptyText="请选择检测类别..." />
    <input id="bhz003" class="mini-combobox" style="width: 150px;"  textField="bzh002" valueField="bhz003"
           url="<%=request.getContextPath()%>/work/f100601/queryHangyeList"    allowInput="true" showNullItem="true" emptyText="请选择行业类别..."/>
    <input id="aab301" class="mini-combobox" style="width: 100px;"  textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=AAB301"    showNullItem="true" emptyText="请选择区市..."/>
    <a class="mini-button" id="id_onSerach" iconCls="icon-search" onclick="onSerach">查询</a>
    </div>
</fieldset>
<div id="datagrid1" class="mini-datagrid" style="width:100%;height:430px;" allowResize="true"
     url="<%=request.getContextPath()%>/work/f100201/queryWt" onshowrowdetail="onShowRowDetail"
     onrowdblclick="onShowRowDetail"  idField="wat001"  pageSize='100'  sortMode="client"    >
    <div property="columns">
        <div type="expandcolumn"></div>
        <div field="wat001" width="40" headerAlign="center" align="center" visible="false" allowSort="true">委托id</div>
        <div field="wat002" width="60" headerAlign="center" align="center" allowSort="true">编号</div>
        <div field="wat018" width="40" headerAlign="center" align="center"  allowSort="true">状态</div>
        <div field="aab301" width="50" headerAlign="center"  align="center" renderer="oncodeRender" allowSort="true" >地区</div>
        <div field="daw005" width="140" headerAlign="center"  align="center" allowSort="true" >地点</div>
        <div field="daw002" width="140" headerAlign="center"  align="center" allowSort="true" >委托单位</div>
        <div field="userid" width="60" headerAlign="center" visible="false" align="center" allowSort="true" >创建人</div>
        <div field="username" width="60" headerAlign="center"  align="center" allowSort="true" >创建人</div>
        <div field="wat017" width="40" headerAlign="center"   dateFormat="yyyy-MM-dd" align="center" allowSort="true" >创建时间</div>
        <div field="wft007" width="40" headerAlign="center" align="center" dataType="currency" currencyUnit="￥" allowSort="true" >费用</div>
        <div field="wft010" width="40" headerAlign="center" align="center" visible="false" allowSort="true" >是否实收</div>
        <div field="do" width="50" headerAlign="center" align="center" visible="false" allowSort="true" renderer='onrenderDO'>操作</div>
    </div>
</div>

</body>
<script id="formTemplate" type="text/x-jquery-tmpl">
<div>
<span>报告:{{= bbz002}}</span>
{{each(i,wt03) wt03DtoList}}
<div>${i+1}:{{= wt03.wct002}}</div>
{{/each}}
</div>
</script>
<script type="text/javascript">
    mini.parse();
    var grid=mini.get("datagrid1");
    grid.load();
function onSerach() {
    var form = new mini.Form("#form1");
    var data = form.getData(true);
    data.wat003=mini.get("wat003").getValue();
    data.bhz003=mini.get("bhz003").getValue();
    data.aab301=mini.get("aab301").getValue();
    grid.load(data);
}
function onShowRowDetail(e) {
    var grid = e.sender;
    var row = e.record;
    var td = grid.getRowDetailCellEl(row);
    var o={}
    var url="${pageContext.request.contextPath}/work/f100201/queryWt02"
    Web.util.request(url,'post',{wat001:row.wat001},function (data) {
        td.innerHTML = "";
        $("#formTemplate").tmpl(data).appendTo(td);
    })

}
</script>

</html>
