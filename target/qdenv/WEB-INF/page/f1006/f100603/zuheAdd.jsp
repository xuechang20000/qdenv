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
                组合名称：
            </td>
            <td class="form-td-odd">
                <input id="bzz002"  name="bzz002" class="mini-textbox" style="width:300px;" vtype="maxLength:100"  required="true"  />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">检测项目：</td>
            <td class="form-td-odd">
                <div id="bzz003" class="mini-combobox" style="width:80%;"  popupWidth="400" textField="bcz002" valueField="bcz001"
                     url="<%=request.getContextPath()%>/work/f100602/queryXiangMuList?bbz001=${param.bbz001}" value="" multiSelect="true"  showClose="true" oncloseclick="onCloseClick" >
                    <div property="columns">
                        <div header="项目" field="bcz002"></div>
                    </div>
                </div>
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
        Web.util.confirm("确定要保存？",function (action) {
                    //提交表单数据
                    var url = '<%=request.getContextPath()%>/work/f100603/saveFenzu';
                    var form = new mini.Form("#form1");
                    var data = form.getData(true);      //获取表单多个控件的数据
                if(!mini.get("bzz003").getValue()){
                    Web.util.showTipsWanring('请选择项目')
                    return;
                }
                    data.bzz003=mini.get("bzz003").getValue();
                    data.bbz001=${param.bbz001}
                    Web.util.requestAsync(url,'',data,function(data,textstatus){
                        //alert(data);
                        Web.util.showTips("保存成功！ ");
                        mini.get("doSubmit").disable();
                    });
            }
        );
    }
</script>
</html>
