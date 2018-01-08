<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
<%@include file="/include/head.jsp"%>
</head>
<body>


    <div  class="mini-fit" style="height:100%;">
        <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true"
             url="<%=request.getContextPath()%>/admin/loadRecevieMail"  idField="userId">
            <div property="columns">
                <div field="noticeId"  headerAlign="center" visible="false" allowSort="true">ID</div>
                <div field="noticeTitle"  headerAlign="center" allowSort="true">标题</div>
                <div field="name"  headerAlign="center" allowSort="true">发布人</div>
                <div field="noticeIsread"  headerAlign="center" allowSort="true" renderer="renderIsRead">状态</div>
                <div field="ctime"  headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" allowSort="true">发送日期</div>
                <div headerAlign="center"  renderer="renderRecive">操作</div>
            </div>
        </div>
    </div>

    <span id="grid_buttons1" style="display: none"  >
            <a class="mini-button" href="javascript:onQuery(1)" plain="true" iconCls="icon-edit" >查看</a>
            </span>
</body>
<script type="text/javascript">
    mini.parse();
    Web.util.load("datagrid1",{"noticeType":"1"});

   function onQuery(v) {
       var noticeId=mini.get("datagrid"+v).getSelected().noticeId
           ,name=mini.get("datagrid"+v).getSelected().name;
       Web.util.openMiniWindow("查看公告","<%=request.getContextPath()%>/admin/f1005/loadDetail?noticeId="+noticeId+"&noticeType=1",800,500,function () {
           mini.get("datagrid1").reload();
       })
        }
        function renderStatus(v) {
                if(1==v.value)
                    return '已删除';
                else
                    return '正常';
            }
       function renderIsRead(v) {
                if(1==v.value)
                    return '已读';
                else
                    return '未读';
            }
    function renderRecive() {
        return $("#grid_buttons1").clone().css("display","inline").html();
    }
</script>

</html>
