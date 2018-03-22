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
                标准名称：
            </td>
            <td class="form-td-odd">
                <input id="bbz002"  name="bbz002" class="mini-textbox" style="width:300px;" vtype="maxLength:100"  required="true"  />
            </td>
        </tr>
       <!-- <tr>
            <td class="form-td-even">
                标签：
            </td>
            <td class="form-td-odd">
                <input id="bbz003"  name="bbz003" class="mini-textbox" style="width:100px;"  />
            </td>
        </tr>
        <tr>-->
            <td class="form-td-even">
                代码：
            </td>
            <td class="form-td-odd">
                <input id="bbz004"  name="bbz004" class="mini-textbox" required="true" style="width:100px;"  />
            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                所属部门：
            </td>
            <td class="form-td-odd">
                <input id="bmz003" class="mini-combobox" onvaluechanged="setWat002" textField="dictName" valueField="dictVal"
                       url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=BMZ003"  required="true" allowInput="true" nullItemText="请选择..."/>

            </td>
        </tr>
        <tr>
            <td class="form-td-even">
                所属行业：
            </td>
            <td class="form-td-odd">
                <div id="bz04s" class="mini-checkboxlist"  textField="bzh002" valueField="bhz001"
                     url="<%=request.getContextPath()%>/work/f100601/queryHangyeList?aae016=1" >
                </div>
            </td>
        </tr>
        <!--
        <tr>
            <td class="form-td-even">
                出台年度：
            </td>
            <td class="form-td-odd">
                <input id="bbz005" name="bbz005"  class="mini-textbox" vtype="int;rangeLength:4,4" required="true" style="width:100px;" />
            </td>
        </tr>
        -->
        <tr>
            <td class="form-td-even">
               说明：
            </td>
            <td class="form-td-odd">
                <input id="aae013"  name="aae013" class="mini-textbox" style="width:200px;"  />
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
                    var url = '<%=request.getContextPath()%>/work/f100602/saveBiaozhun';
                    var form = new mini.Form("#form1");
                    var data = form.getData(true);      //获取表单多个控件的数据
                if(!mini.get("bz04s").getValue()){
                    Web.util.showTipsWanring('请选择行业')
                    return;
                }
                    data.bhz001ss=mini.get("bz04s").getValue()
            data.bmz003=mini.get("bmz003").getValue();
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
