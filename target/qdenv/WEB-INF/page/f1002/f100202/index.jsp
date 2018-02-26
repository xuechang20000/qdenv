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
    <input class="mini-datepicker" style="width:150px;" id="s_date" name="s_date"  />
    至
    <input class="mini-datepicker" style="width:150px;" id="e_date" name="e_date" />
    <input id="wat003" class="mini-combobox" style="width: 150px;" onvaluechanged="setWat002" textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WAT003"   allowInput="true" showNullItem="true" emptyText="请选择检测类别..." />
    <input id="bhz003" class="mini-combobox" style="width: 150px;" onvaluechanged="setWat002" textField="bzh002" valueField="bhz003"
           url="<%=request.getContextPath()%>/work/f100601/queryHangyeList"    allowInput="true" showNullItem="true" emptyText="请选择行业类别..."/>
    <input id="aab301" class="mini-combobox" style="width: 100px;" onvaluechanged="setWat002" textField="dictName" valueField="dictVal"
           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=AAB301"    showNullItem="true" emptyText="请选择区市..."/>
    <a class="mini-button" id="id_onSerach" iconCls="icon-search" onclick="onSerach">查询</a>
    </div>
</fieldset>
<div id="datagrid1" class="mini-datagrid" style="width:100%;height:300px;" allowResize="true"
     url="<%=request.getContextPath()%>/work/f10010202/queryStuListByCurentUserPub.action"
     idField="stuid"  pageSize='100' pagerButtons="#exportExcel" sortMode="client"    >
    <div property="columns">
        <div field="stuid" width="120" headerAlign="center" align="center" visible="false" allowSort="true">学生id</div>
        <div field="groupname" width="70" headerAlign="center" align="center" allowSort="true">用户组名称</div>
        <div field="stu_name" width="60" headerAlign="center" align="center" allowSort="true">学生姓名</div>
        <div field="cellphone" width="90" headerAlign="center"  align="center" allowSort="true" >手机</div>
        <div field="stu_level" width="60" headerAlign="center"  align="center" allowSort="true" renderer='oncodeRender'>学生级别</div>
        <div field="recorderor" width="60" headerAlign="center"  align="center" allowSort="true" >学习顾问</div>
        <div field="followor" width="60" headerAlign="center"  align="center" allowSort="true" >跟进服务人</div>
        <div field="examlevelor" width="60" headerAlign="center"  align="center" allowSort="true" >报考层次</div>
        <div field="examclassor" width="60" headerAlign="center" align="center"  allowSort="true" >考试科类</div>
        <div field="firstwishschoolor" width="60" headerAlign="center" align="center"  allowSort="true" >一志愿院校</div>
        <div field="firstwishspecialtyor" width="60" headerAlign="center" align="center"  allowSort="true" >一志愿专业</div>
        <div field="learningformor" width="60" headerAlign="center" align="center"  allowSort="true" >学习形式</div>
        <div field="manualschool" width="60" headerAlign="center" align="center"  allowSort="true" >手输院校</div>
        <div field="manualspecialty" width="60" headerAlign="center" align="center"  allowSort="true" >手输专业</div>
        <div field="blongrelation" width="60" headerAlign="center" align="center"  allowSort="true"  renderer='oncodeRender'>隶属关系</div>
        <div field="proce_stepname" width="140" headerAlign="center" align="center"  allowSort="true" >当前状态</div>
        <div field="do" width="100" headerAlign="center" align="center"  allowSort="true" renderer='onrenderDO'>详情</div>
    </div>
</div>
</body>
<script type="text/javascript">
    mini.parse();
function onSerach() {
    var form = new mini.Form("#form1");
    var data = form.getData(true);
    data.wat003=mini.get("wat003").getValue();
    data.bhz003=mini.get("bhz003").getValue();
    data.aab301=mini.get("aab301").getValue();
    alert(JSON.stringify(data))
}
</script>

</html>
