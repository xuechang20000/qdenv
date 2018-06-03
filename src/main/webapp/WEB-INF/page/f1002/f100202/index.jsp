<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
<%@include file="/include/head.jsp"%>
    <style type="text/css">
        #form1{margin-bottom: 3px;}
        .temp_report{margin-bottom:3px;background-color: #efefef;padding: 4px; border: 1px solid;border-color: #9c9c9c}
        .temp_report img:hover{cursor:pointer}
        .temp_report img{vertical-align:middle}
        .temp_report_title{font-weight: bold;color: #1296db}
        .temp_select_title{color:#1296db}
        .temp_select{padding-bottom: 4px}
        .wft010_1{color: #449d44;}
    </style>

</head>
<body>
<jsp:include page="/include/exportExcle.jsp"/>
<div id="form1" style="line-height: 28px">
    <input id="wat018" class="mini-combobox" style="width: 100px;"  textField="wlt002" valueField="wlt003"
           url="<%=request.getContextPath()%>/work/f100201/queryWt06"   allowInput="true" showNullItem="true" emptyText="全部状态" />
    自：
    <input class="mini-datepicker" style="width:100px;" id="s_date" name="s_date"  />
    至
    <input class="mini-datepicker" style="width:100px;" id="e_date" name="e_date" />&nbsp;&nbsp;
    委托编号： <input class="mini-textbox" style="width:100px;" id="wat002" name="wat002" onenter="onSerach()"/>
    委托单位： <input class="mini-textbox" style="width:200px;" id="daw002" name="daw002" onenter="onSerach()"/>
    地址： <input class="mini-textbox" style="width:120px;" id="daw005" name="daw002" onenter="onSerach()"/>
    电话： <input class="mini-textbox" style="width:100px;" id="daw004" name="daw002" onenter="onSerach()"/>
    <br/>
    <input id="wat003" class="mini-combobox" style="width: 150px;"  textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WAT003"   allowInput="true" showNullItem="true" emptyText="请选择检测类别..." />
    <input id="bhz003" class="mini-combobox" style="width: 150px;"  textField="bzh002" valueField="bhz003"
           url="<%=request.getContextPath()%>/work/f100601/queryHangyeList"    allowInput="true" showNullItem="true" emptyText="请选择行业类别..."/>
    <input id="aab301" class="mini-combobox" style="width: 100px;"  textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=AAB301"    showNullItem="true" emptyText="请选择区市..."/>
    <input id="wft010" class="mini-combobox" style="width: 100px;"  textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=IS"    showNullItem="true" emptyText="是否收费..."/>
    <input id="wft015" class="mini-combobox" style="width: 100px;"  textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=IS"    showNullItem="true" emptyText="是否开票..."/>

    <a class="mini-button" id="id_onSerach" iconCls="icon-search" onclick="onSerach">查询</a>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:100%;height:430px;" allowResize="true"  pagerButtons="#exportExcel"
     url="<%=request.getContextPath()%>/work/f100201/queryWt" onshowrowdetail="onShowRowDetail" showSummaryRow="true"
     idField="wat001"  pageSize='100'  sortMode="client"  contextMenu="#gridMenu" ondrawsummarycell="onDrawSummaryCell" >
    <div property="columns">
        <div type="expandcolumn"></div>
        <div field="wat001" width="40" headerAlign="center" align="center" visible="false" allowSort="true">委托id</div>
        <div field="wat002" width="60" headerAlign="center" align="center" allowSort="true">编号</div>
        <div field="wat018" width="40" headerAlign="center" align="center" visible="false" allowSort="true">状态</div>
        <div field="wat018s" width="40" headerAlign="center" align="center"  allowSort="true">状态</div>
        <div field="wat020" width="60" headerAlign="center" align="center" dateFormat="yyyy/MM/dd HH:mm" allowSort="true">上步提交时间</div>
        <div field="aab301" width="40" headerAlign="center"  align="center" renderer="oncodeRender" allowSort="true" >地区</div>
        <div field="daw005" width="140" headerAlign="center"  align="center" allowSort="true" >地点</div>
        <div field="daw002" width="80" headerAlign="center"  align="center" allowSort="true" >委托单位</div>
        <div field="daw003" width="40" headerAlign="center"  align="center" allowSort="true" >联系人</div>
        <div field="daw004" width="60" headerAlign="center"  align="center" allowSort="true" >电话</div>
        <div field="userid" width="60" headerAlign="center" visible="false" align="center" allowSort="true" >创建人</div>
        <div field="username" width="40" headerAlign="center"  align="center" allowSort="true" >创建人</div>
        <div field="wat017" width="50" headerAlign="center"   dateFormat="yyyy-MM-dd" align="center" allowSort="true" >创建时间</div>
        <div field="wft007" width="50" headerAlign="center" align="center" summaryType="sum" dataType="currency" currencyUnit="￥" allowSort="true" >费用</div>
        <div field="wft010" width="40" headerAlign="center" align="center" visible="false" allowSort="true" >是否实收</div>
        <div field="do" width="50" headerAlign="center" align="center" visible="false" allowSort="true" renderer='onrenderDO'>操作</div>
    </div>
</div>
<ul id="gridMenu" class="mini-contextmenu" onbeforeopen="onBeforeOpen">
    <shiro:hasPermission name="DO_1">
    <li name="DO_1" iconCls="icon-node" onclick="onWt01DO('DO_1','相关信息')">相关信息</li>
    </shiro:hasPermission>
    <shiro:hasPermission name="DO_2">
    <li name="DO_2" iconCls="icon-node" onclick="onWt01DO('DO_2','委托协议')">委托协议</li>
    </shiro:hasPermission>
        <shiro:hasPermission name="DO_3">
    <li name="DO_3" iconCls="icon-node" onclick="onWt01DO('DO_3','信息修正')">信息修正</li>
        </shiro:hasPermission>
    <shiro:hasPermission name="DO_15">
        <li name="DO_15" iconCls="icon-node" onclick="onWt01DO('DO_15','隐藏')">隐藏</li>
    </shiro:hasPermission>
    <shiro:hasPermission name="DO_16">
        <li name="DO_16" iconCls="icon-node" onclick="onWt01DO('DO_16','恢复显示')">恢复显示</li>
    </shiro:hasPermission>
    <shiro:lacksRole name=""></shiro:lacksRole>
    <!--<li name="DO_4" iconCls="icon-node" onclick="onWt01DO('DO_4','检测数据')">检测数据</li>-->
   <!-- <li name="DO_5" iconCls="icon-node" onclick="onWt01DO('DO_5','重新检测')">重新检测</li>-->
    <!-- <li name="DO_6" iconCls="icon-node" onclick="onWt01DO('DO_6','快递信息')">快递信息</li>-->
    <!-- <li name="DO_14" iconCls="icon-node" onclick="onWt01DO('DO_14','安排采样')">安排采样人员</li>-->
    <shiro:hasPermission name="DO_12">
    <li name="DO_12" iconCls="icon-downgrade" onclick="onWt01DO('DO_12')">提交(下一环节)</li>
    </shiro:hasPermission>
    <shiro:hasPermission name="DO_13">
    <li name="DO_13" iconCls="icon-upgrade" onclick="onWt01DO('DO_13')">退回</li>
    </shiro:hasPermission>
</ul>
</body>
<script id="formTemplate" type="text/x-jquery-tmpl">
<div class="temp_report">

<span class="temp_report_title">报告({{= wbt001}}):{{= bbz002}}({{= bbz004}}) {{= bbz003}}
  <!--<img src="${pageContext.request.contextPath}/resources/image/add.png"/ onclick="onAddWt03({{= wbt001}})">-->
<shiro:hasPermission name="DO_4">
 <img src="${pageContext.request.contextPath}/resources/image/edit.png"/ onclick="onEditWt02({{= wbt001}})" title="检测录入">
</shiro:hasPermission>
<shiro:hasPermission name="DO_7">
 <img src="${pageContext.request.contextPath}/resources/image/write.png"/ onclick="onPreviewWt02({{= wbt001}})" title="报告编写">
</shiro:hasPermission>
<shiro:hasPermission name="DO_8">
 <img src="${pageContext.request.contextPath}/resources/image/sign.png"/ onclick="onOutWt02({{= wbt001}})" title="报告签发">
</shiro:hasPermission>
<shiro:hasPermission name="DO_9">
 <img src="${pageContext.request.contextPath}/resources/image/check.png"/ onclick="onCheckWt02({{= wbt001}})" title="报告审核">
 </shiro:hasPermission>
</span>

{{each(i,wt03) wt03DtoList}}
<div class="temp_select">
    <span class="temp_select_title">
    <!--<img src="${pageContext.request.contextPath}/resources/image/delete.png" onclick="onDeleteWt03({{= wt03.wct001}})"/>-->
    <!--<img src="${pageContext.request.contextPath}/resources/image/edit.png" onclick="onEditWt03({{= wt03.wct001}})"/>-->
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
    data.wft010=mini.get("wft010").getValue();
    data.wft015=mini.get("wft015").getValue();
    data.wat018=mini.get("wat018").getValue();
    data.daw005=mini.get("daw005").getValue();
    data.daw004=mini.get("daw004").getValue();
    data.daw002=mini.get("daw002").getValue();
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
    function onDrawSummaryCell(e) {
        var result = e.result;
        var grid = e.sender;
        //客户端汇总计算
        var rows=grid.findRows(function (row) {
            if (row.wft010=="1"){
                return false;
            }
            return true;
        });
        var sum=0;
        for (var i=0;i<rows.length;i++){
            sum=sum+parseFloat(rows[i].wft007?rows[i].wft007:0);
        }
        if (e.field=="wat017"){
            e.cellHtml =e.cellHtml+ "未缴费:￥ " + sum;
        }
        rows=grid.findRows(function (row) {
            if (row.wft010=="1"){
                return true;
            }else{return false;}
        });
        sum=0;
        for (var i=0;i<rows.length;i++){
            sum=sum+parseFloat(rows[i].wft007?rows[i].wft007:0);
        }
        if (e.field=="daw004"){
            e.cellHtml =e.cellHtml+ "已缴费:￥ " + sum;
        }
        if (e.field=="wft007"){
            e.cellHtml ="合计："+e.cellHtml
        }
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
    //检测数据录入
function onEditWt02(v) {
    var row = grid.getSelected();
    var url="${pageContext.request.contextPath}/work/f100202/loadDO_4?wbt001="+v;
    Web.util.openMiniWindow('检测数据录入', url, 1000, 500, function () {
        //grid.reload();
    })
}
//报告编写
function onPreviewWt02(v) {
    var url="${pageContext.request.contextPath}/work/f100202/loadDO_7?wbt001="+v;
    Web.util.openMiniWindow('报告编写', url, 1000, 500, function () {
        //grid.reload();
    })
}
    //签发报告
function onOutWt02(v) {
    var url="${pageContext.request.contextPath}/work/f100202/loadDO_8?wbt001="+v;
    Web.util.openMiniWindow('签发报告', url, 1000, 500, function () {
        //grid.reload();
    })
}
    //审核报告
function onCheckWt02(v) {
    onOutWt02(v);
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

        url="${pageContext.request.contextPath}/work/f100202/loadBackto?wat001="+row.wat001+"&wat018="+row.wat018;
        Web.util.openMiniWindow("回退",url,500,300,function () {
            grid.reload()
        })

    }else if ('DO_15'==v){//隐藏

        url="${pageContext.request.contextPath}/work/f100202/sorhwt01";
        Web.util.request(url,"post",{wat001:row.wat001,type:"H"},function (data) {
            grid.reload();
        })

    }else if ('DO_16'==v){//恢复显示

        url="${pageContext.request.contextPath}/work/f100202/sorhwt01";
        Web.util.request(url,"post",{wat001:row.wat001,type:"S"},function (data) {
            grid.reload();
        })

    }else {//打印界面
        Web.util.openMiniWindow(t, url, 1000, 500, function () {
            //grid.reload();
            if ('DO_3'==v){
                grid.reload()
            }
        })
    }
}
    grid.on("drawcell", function (e) {
        var record = e.record
        if (record.wft010 == "1") {
            e.rowCls = "wft010_1";
        }
    });
</script>

</html>
