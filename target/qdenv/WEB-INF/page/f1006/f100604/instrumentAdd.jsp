<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>
<div id="form1" >
    <table  class="form-table">
        <colgroup align="right" width="30%"></colgroup>
        <colgroup align="left" width="70%"></colgroup>
        <tr>
            <td class="form-td-even">
                仪器名称：
            </td>
            <td class="form-td-odd">
                <input id="bmz002"  name="bmz002" class="mini-textbox" style="width:200px;" required="true" />
            </td>
        </tr>

        <tr>
            <td class="form-td-even">
                选择仪器类别：
            </td>
            <td class="form-td-odd">
                <input id="bmz003" class="mini-combobox" style="width: 200px;"  textField="dictName" valueField="dictVal"
                       url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=BMZ003"   required="true" allowInput="true" nullItemText="请选择..."/>
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                仪器编号列表：

            </td>
            <td class="form-td-odd">
                <input id="bmz004"  name="bmz004" class="mini-textarea" style="width:200px;" required="true"  />
                <font color="#a52a2a"> 多个编号以英文状态下","间隔</font>
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
               备注：
            </td>
            <td class="form-td-odd">
                <input id="aae013"  name="aae013" class="mini-textarea" style="width:200px;"   />
            </td>
        </tr>
        <tr>
            <td></td>
            <td class="form-td-odd">
                <a class="mini-button" iconCls="icon-save" id="doSubmit" onclick="submitForm()">保存</a>
            </td>

        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    function submitForm() {
        var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        var bmz004=mini.get("bmz004").getValue();
        if(bmz004.indexOf("，")>0){
            Web.util.showTipsWanring('编号列表请用英文状态下”,“间隔！');
            return;
        }
        Web.util.confirm("确定要保存？",function (action) {
                    //提交表单数据
                    var url = '<%=request.getContextPath()%>/work/f100604/saveOrUpdateBz06';
                    var form = new mini.Form("#form1");
                    var data = form.getData(true);      //获取表单多个控件的数据
                    data.bmz003=mini.get("bmz003").getValue();
                    data.aae016 = '1';
                    Web.util.requestAsync(url,'',data,function(data,textstatus){

                        Web.util.showTips("保存成功！ ");
                        mini.get("doSubmit").disable();
                    });
            }
        );
    }
</script>
</html>
