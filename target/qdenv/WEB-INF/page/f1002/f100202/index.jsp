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
<fieldset id="fd2">
    <legend><span>查询条件</span></legend>
    <div id="form1" >
        <input id="wat018" class="mini-combobox" style="width: 100px;"  textField="wlt002" valueField="wlt003"
               url="<%=request.getContextPath()%>/work/f100201/queryWt06"   allowInput="true" showNullItem="true" emptyText="全部状态" />
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
     idField="wat001"  pageSize='100'  sortMode="client"  contextMenu="#gridMenu"  >
    <div property="columns">
        <div type="expandcolumn"></div>
        <div field="wat001" width="40" headerAlign="center" align="center" visible="false" allowSort="true">委托id</div>
        <div field="wat002" width="60" headerAlign="center" align="center" allowSort="true">编号</div>
        <div field="wat018" width="40" headerAlign="center" align="center" visible="false" allowSort="true">状态</div>
        <div field="wat018s" width="40" headerAlign="center" align="center"  allowSort="true">状态</div>
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
<ul id="gridMenu" class="mini-contextmenu" onbeforeopen="onBeforeOpen">
    <li name="DO_1" iconCls="icon-node" onclick="onWt01DO('DO_1','相关信息')">相关信息</li>
    <li name="DO_2" iconCls="icon-node" onclick="onWt01DO('DO_2','委托协议')">委托协议</li>
    <li name="DO_3" iconCls="icon-node" onclick="onWt01DO('DO_3','信息修正')">信息修正</li>
    <li name="DO_4" iconCls="icon-node" onclick="onWt01DO('DO_4','检测数据')">检测数据</li>
   <!-- <li name="DO_5" iconCls="icon-node" onclick="onWt01DO('DO_5','重新检测')">重新检测</li>-->
    <li name="DO_6" iconCls="icon-node" onclick="onWt01DO('DO_6','快递信息')">快递信息</li>
    <li name="DO_14" iconCls="icon-node" onclick="onWt01DO('DO_14','安排采样')">安排采样</li>
    <li name="DO_12" iconCls="icon-downgrade" onclick="onWt01DO('DO_12')">提交(下一环节)</li>
    <li name="DO_13" iconCls="icon-upgrade" onclick="onWt01DO('DO_13')">退回(上一环节)</li>
</ul>
</body>
<script id="formTemplate" type="text/x-jquery-tmpl">
<div class="temp_report">

<span class="temp_report_title">报告({{= wbt001}}):{{= bbz002}}({{= bbz004}}) {{= bbz003}}
 <img src="${pageContext.request.contextPath}/resources/image/add.png"/ onclick="onAddWt03({{= wbt001}})">
 <img src="${pageContext.request.contextPath}/resources/image/edit.png"/ onclick="onEditWt02({{= wbt001}})">
 <img src="${pageContext.request.contextPath}/resources/image/preview.png"/ onclick="onPreviewWt02({{= wbt001}})">
 <img src="${pageContext.request.contextPath}/resources/image/out.png"/ onclick="onOutWt02({{= wbt001}})">
 <img src="${pageContext.request.contextPath}/resources/image/check.png"/ onclick="onCheckWt02({{= wbt001}})">
</span>

{{each(i,wt03) wt03DtoList}}
<div class="temp_select">
    <span class="temp_select_title">
    <img src="${pageContext.request.contextPath}/resources/image/delete.png" onclick="onDeleteWt03({{= wt03.wct001}})"/>
    <img src="${pageContext.request.contextPath}/resources/image/edit.png" onclick="onEditWt03({{= wt03.wct001}})"/>
    (ID:{{= wt03.wct001}}){{= wt03.wct002}}</span>
    项目：
    <span>
        {{each(j,wt04) wt03.wt04DtoList}}
        ,{{= wt04.bcz002}}
        {{/each}}
    </span>
</div>
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
    function onBeforeOpen(e) {
        var menu = e.sender;
        var editItem = mini.getbyName("edit", menu);
        var removeItem = mini.getbyName("remove", menu);
        var row = grid.getSelected();
        //editItem.show();
        //removeItem.enable();
    }
    //删除采样点
function onDeleteWt03(v) {
    alert(v);
}
    //编辑采样点
function onEditWt03(v) {
    alert(v);
}
    //添加采样点
function onAddWt03(v) {
    alert(v);
}
    //编写报告
function onEditWt02(v) {
    alert(v);
}
//签发报告
function onPreviewWt02(v) {
    alert(v);
}
    //输出报告
function onOutWt02(v) {
    alert(v);
}
    //审核报告
function onCheckWt02(v) {
    alert(v);
}
function onWt01DO(v,t) {
    var row = grid.getSelected();
    var url="${pageContext.request.contextPath}/work/f100202/load"+v+"?wat001="+row.wat001;
    if ('DO_12'==v){//提交
        url="${pageContext.request.contextPath}/work/f100201/saveNextStep?wat001="+row.wat001;
        Web.util.request(url,"post",{},function (data) {
            grid.reload();
        })
    }else if ('DO_13'==v){//回退
        url="${pageContext.request.contextPath}/work/f100201/savePreStep?wat001="+row.wat001;
        Web.util.request(url,"post",{},function (data) {
            grid.reload();
        })
    }else {//打印界面
        Web.util.openMiniWindow(t, url, 1000, 500, function () {
            grid.reload();
        })
    }
}
</script>

</html>
