<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
<%@include file="/include/head.jsp"%>
    <style type="text/css">
        #process {padding: 4px;width: 100%;margin-bottom: 10px;text-align: center;border-color: #9c9c9c}
        #process  td{padding: 4px;border-color: #9c9c9c}
        .select{background-color: #2fd85e}
    </style>

</head>
<body>
<table id="process" align="center" border="1" cellspacing="0">
    <tr>
    </tr>
</table>
<div id="datagrid1" class="mini-datagrid" style="width:100%;height:350px;" allowResize="true"
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
    var wat001=${param.wat001};
    var wat018='${param.wat018}';
    var grid=mini.get("datagrid1");
    grid.load({wat001:wat001});
    (function () {
        var url="${pageContext.request.contextPath}/work/f100201/queryWt06";
        Web.util.request(url,"post",{isPermission:"0"},function (data) {
            var i=0;
            for(var d;d=data[i++];){
                if(wat018==d.wlt003){
                    $("#process tr").append('<td class="select">'+d.wlt002+'</td>')
                }else{
                    $("#process tr").append('<td>'+d.wlt002+'</td>')
                }

            }
        })
    })();
</script>

</html>
