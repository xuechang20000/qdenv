<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <%@include file="/include/head.jsp"%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/miniui/ajaxfileupload.js"></script>
</head>
<body>
<div id="form1" >
    <input id="userId"  name="userId" class="mini-textbox" visible="false"/>
    <table  class="form-table">
        <colgroup align="right" width="30%"></colgroup>
        <colgroup align="left" width="70%"></colgroup>
        <tr>
            <td class="form-td-even">
                电子签字授权码：
            </td>
            <td class="form-td-odd">
                <input id="ext1"  name="ext1" class="mini-password" style="width:200px;" required="true" />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                电子签字授权码确认：
            </td>
            <td class="form-td-odd">
                <input id="ext11"   name="ext11" class="mini-password" style="width:200px;" required="true" />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                签名照片上传：
            </td>
            <td class="form-td-odd">
                <input id="signature" class="mini-htmlfile" name="signature" limitType="*.jpg" />

            </td>
        </tr>
        <tr>
            <td></td>
            <td colspan="1"><img src="${pageContext.request.contextPath}/admin/querySignature"></img></td>
        </tr>
        <tr>
            <td></td>
            <td class="form-td-odd">
                <a class="mini-button" iconCls="icon-save" id="doSubmit" onclick="dosubmit()">保存</a>
            </td>

        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    function dosubmit() {
        var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var ext1=mini.get("ext1").getValue()
        var ext11=mini.get("ext11").getValue()
        if(ext1!=ext11){
            Web.util.showTipsWanring('授权码与授权码确认不一致，请修正！');
            return;
        }
        var url="${pageContext.request.contextPath}/admin/updateAppUserExt"
        Web.util.request(url,"post",{"ext1":ext1},function () {
            ajaxFileUpload();
        });
    }
    function ajaxFileUpload() {
        var inputFile = $("#signature > input:file")[0];
        $.ajaxFileUpload({
            url: '${pageContext.request.contextPath}/admin/updateSignature',      //用于文件上传的服务器端请求地址
            fileElementId: inputFile,               //文件上传域的ID
            //data: {"ext1":ext1},            //附加的额外参数
            dataType: 'text',                   //返回值类型 一般设置为json
            success: function (data, status)    //服务器成功响应处理函数
            {
                if (data) alert(data);
                else{
                        Web.util.showTips("上传成功！");
                        mini.get("doSubmit").disable();

                }

            },
            error: function (data, status, e)   //服务器响应失败处理函数
            {
                alert(e);
            },
            complete: function () {
                var jq = $("#file1 > input:file");
                jq.before(inputFile);
                jq.remove();
            }
        });
    }


</script>
</html>
