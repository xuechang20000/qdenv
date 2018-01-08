<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <%@include file="/include/head.jsp"%>
    <%@include file="/include/head_umeditor.jsp"%>
  </head>
<body>
<div class="mini-tabs"  id="tabs1" activeIndex="0" style="width:100%;height:100%;" plain='false'>
    <div  title="已发布" class="mini-fit" style="height:100%;">
        <div id="datagrid2" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true"
             url="<%=request.getContextPath()%>/admin/loadSendMail"  idField="userId">
            <div property="columns">
                <div field="noticeId"  headerAlign="center" visible="false" allowSort="true">ID</div>
                <div field="noticeTitle"  headerAlign="center" allowSort="true">标题</div>
                <div field="ctime"  headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" allowSort="true">发布日期</div>
                <div field="removed"  headerAlign="center" allowSort="true" renderer="renderStatus">状态</div>
                <div headerAlign="center"  renderer="renderSend">操作</div>
            </div>
        </div>
    </div>
    <div  title="我要发布" class="mini-fit" style="height:100%;">
    <div style="padding-top: 15px">
            <input id="notide_id" name="noticeId" class="mini-textbox" visible="false" />
            标&nbsp;&nbsp;&nbsp;题：
            <input id="noticeTitle"  name="noticeTitle" class="mini-textbox" style="width:80%;" required="true" onblur="onAfterTitle()"  />
        </div>
        <div style="padding-top: 15px">
            <a id="btn_upload" class="mini-button" iconCls="icon-upload" onclick="loadUpload">上传附件</a>
            <span id="attachmentList"></span>
        </div>
<br/>
        <script type="text/plain" id="myEditor" style="width:750px;height:250px;"></script>
        <div style="padding-top: 15px">
            <a class="mini-button" iconCls="icon-add" id="doPost" onclick="onClick">发布</a>
        </div>
   </div>
</div>

<span id="grid_buttons2" style="display: none"  >
<a class="mini-button" href="javascript:onQuery()" plain="true" iconCls="icon-edit" >查看</a>
<a class="mini-button" href="javascript:onDelete()" plain="true" iconCls="icon-remove">删除</a>
</span>
</body>
                <script type="text/javascript">
                mini.parse();
        Web.util.load("datagrid2",{"noticeType":"1"});
        var um = UM.getEditor('myEditor');
        function loadUpload(){
                var id=mini.get("notide_id").getValue();
                if(!id){
                    Web.util.showTipsWanring("请先输入标题！")
                    return;
                }
                Web.util.openMiniWindow('添加附件','<%=request.getContextPath()%>/include/upload.jsp?id='+id,700,350,function (action) {
                    if (action == "close") {       //如果点击“确定”
                        Web.util.request("<%=request.getContextPath()%>/admin/queryAppNoticeAttachment","post",{"noticeId":id},function (data) {
                            $("#attachmentList").html("");
                            for(var atta,i=0;atta=data[i++];){
                                $("#attachmentList").append(atta.filename+"\t");
                            }
                        })
                    }
                })
            }


            function onClick() {

                var title=mini.get("noticeTitle").getValue();
                var id=mini.get("notide_id").getValue();
                var content=UM.getEditor('myEditor').getContent();
                Web.util.request("<%=request.getContextPath()%>/admin/saveAppNotice","post",{"noticeId":id,"noticeTitle":title,"noticeContent":content,"noticeType":"1","users":"all","removed":"0"},function (data) {
                    Web.util.showTips("提交成功！");
                    mini.get("datagrid2").reload();
                    mini.get("doPost").disable();
                })
            }
        function onAfterTitle() {
            var title=mini.get("noticeTitle").getValue();
            var id=mini.get("notide_id").getValue();
            if(title&&id.length==0){
                Web.util.request("<%=request.getContextPath()%>/admin/saveAppNotice","post",{"noticeTitle":title,"noticeType":"1","users":"","removed":"0"},function (data) {
                    mini.get("notide_id").setValue(data.noticeId);
                })
            }
        }
        function renderSend() {
            return $("#grid_buttons2").clone().css("display","inline").html();
        }
        function renderStatus(v) {
            if(1==v.value)
                return '已删除';
            else
                return '正常';
        }
        function onQuery() {
            var noticeId=mini.get("datagrid2").getSelected().noticeId
                ,name=mini.get("datagrid2").getSelected().name;
            Web.util.openMiniWindow("查看公告","<%=request.getContextPath()%>/admin/f1005/loadDetail?noticeId="+noticeId+"&noticeType=1",800,500,function () {
                mini.get("datagrid2").reload();
            })
        }
        function onDelete() {
            var noticeId=mini.get("datagrid2").getSelected().noticeId;
            Web.util.confirm("确定要删除吗？",function () {
                Web.util.request("<%=request.getContextPath()%>/admin/deleteAppNoticeById","",{noticeId:noticeId},function () {
                    mini.get("datagrid2").reload();
                })
            })

        }
        </script>

</html>
