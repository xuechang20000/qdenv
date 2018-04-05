<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
<%@include file="/include/head.jsp"%>
    <style type="text/css">

    </style>

</head>
<body>

<div id="datagrid1" class="mini-datagrid" style="width:100%;height:400px;" allowResize="true"
     url="<%=request.getContextPath()%>/work/f100202/queryWt09List"
     idField="wgt001"  pageSize='100'   >
    <div property="columns">
        <div field="wgt001" width="40" headerAlign="center" align="center" visible="false" allowSort="true">日志id</div>
        <div field="wgt003" width="60" headerAlign="center" align="center" allowSort="true">操作人</div>
        <div field="wgt004" width="40" headerAlign="center" align="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss">操作时间</div>
        <div field="wgt006" width="40" headerAlign="center" align="center"  allowSort="true">环节</div>
        <div field="aae013" width="140" headerAlign="center"  align="center" allowSort="true" >备注</div>
    </div>
</div>

</body>

<script type="text/javascript">
    mini.parse()
    var wat001=${param.wat001}
    var grid=mini.get("datagrid1");
    grid.load({wat001:wat001});

</script>

</html>
