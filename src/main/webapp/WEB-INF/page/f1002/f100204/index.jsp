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
     url="<%=request.getContextPath()%>/work/f100201/queryWt"
     idField="wat001"  pageSize='100'  sortMode="client">
    <div property="columns">
        <div headerAlign="center" align="center" width="40" renderer="renderDO">操作</div>
        <div field="wat001" width="40" headerAlign="center" align="center" visible="false" allowSort="true">委托id</div>
        <div field="wat002" width="60" headerAlign="center" align="center" allowSort="true">编号</div>
        <div field="wat018" width="40" headerAlign="center" align="center"  visible="false" allowSort="true">状态</div>
        <div field="wat018s" width="40" headerAlign="center" align="center" visible="false"  allowSort="true">状态</div>
        <div field="aab301" width="50" headerAlign="center"  align="center" renderer="oncodeRender" allowSort="true" >地区</div>
        <div field="daw005" width="140" headerAlign="center"  align="center" allowSort="true" >地点</div>
        <div field="daw002" width="140" headerAlign="center"  align="center" allowSort="true" >委托单位</div>
        <div field="fnames" width="100" headerAlign="center"   align="center" allowSort="true" >分配人</div>
        <div field="userid" width="60" headerAlign="center" visible="false"  align="center" allowSort="true" >创建人</div>
        <div field="username" width="60" headerAlign="center"  align="center" visible="false" allowSort="true" >创建人</div>
        <div field="wat017" width="40" headerAlign="center"   dateFormat="yyyy-MM-dd" visible="false" align="center" allowSort="true" >创建时间</div>
        <div field="wft007" width="40" headerAlign="center" visible="false" align="center" dataType="currency" currencyUnit="￥" allowSort="true" >费用</div>
        <div field="wft010" width="40" headerAlign="center" align="center" visible="false" allowSort="true" >是否实收</div>
        <div field="wat004" width="60" headerAlign="center" align="center" allowSort="true" >预约时间</div>
        <div field="do" width="50" headerAlign="center" align="center" visible="false" allowSort="true" renderer='onrenderDO'>操作</div>
    </div>
</div>
<span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onUpdate()" plain="true" iconCls="icon-edit" >维护</a>
    </span>
</body>

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
    function renderDO(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onUpdate() {
        var wat002=mini.get("datagrid1").getSelected().wat002;
        window.location.href="${pageContext.request.contextPath}/work/f100203/index?wat002="+wat002
    }
</script>

</html>
