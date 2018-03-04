<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        #form1 table td{padding: 3px}
    </style>
</head>
<body>
<div class="mini-tabs"  id="tabs1" activeIndex="0" style="width:100%;height:100%;" plain='false'>

    <div  title="委托信息" class="mini-fit" style="height:100%;">
        <div id="form1" >
            <input name="wat001" class="mini-hidden" />
            <table>
                <tr>
                    <td align="right">
                        <label for="wat002">委托编号：</label>
                    </td>
                    <td align="left">
                        <span id="span_wat002" style="color: red;font-size: 16px"></span>
                        <input id="wat015"  name="wat015" visible="false" readonly="true" class="mini-textbox" required="true" />
                        <input id="wat016"  name="wat016" visible="false" readonly="true" class="mini-textbox" required="true" />
                        <input id="wat002"  name="wat002" visible="false" readonly="true" class="mini-textbox" required="true" />
                        <input id="aae016"  name="aae016" value="1" visible="false" readonly="true" class="mini-textbox" required="true" />
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="aae003">委托年月：</label>
                    </td>
                    <td>
                        <input id="aae003" name="aae003" class="mini-monthpicker"   style="width: 100px;" format="yyyyMM" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="wat003">检测类别：</label>
                    </td>
                    <td>
                        <input id="wat003" class="mini-combobox" style="width: 200px;"  textField="dictName" valueField="dictVal"
                               url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WAT003" value="E"  required="true" allowInput="true" nullItemText="请选择..."/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="bhz003">行业类别：</label>
                    </td>
                    <td>
                        <input id="bhz003" class="mini-combobox" style="width: 200px;"  textField="bzh002" valueField="bhz003"
                               url="<%=request.getContextPath()%>/work/f100601/queryHangyeList" value="A"  required="true" allowInput="true" nullItemText="请选择..."/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="daw002">委托单位：</label>
                    </td>
                    <td>
                        <input id="daw001" name="daw001" class="mini-textbox" visible="false" required="true"/>
                        <input id="daw002" name="daw002" class="mini-textbox" style="width: 300px;" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="daw003">联系人：</label>
                    </td>
                    <td>
                        <input id="daw003" name="daw003" style="width: 100px;" class="mini-textbox" required="true"/>
                        <label for="daw004">电话：</label> <input id="daw004" name="daw004" style="width: 150px;" class="mini-textbox" required="true"/>
                    </td>

                </tr>

                <tr>
                    <td align="right">
                        <label for="daw005">地点：</label>
                    </td>
                    <td>
                        <input id="aab301" class="mini-combobox" style="width: 70px;"  textField="dictName" valueField="dictVal"
                               url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=AAB301"   required="true" allowInput="true" nullItemText="请选择..."/>
                        <input id="daw005" name="daw005" style="width: 240px;" class="mini-textbox" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="wft002">采样费：</label>
                    </td>
                    <td>
                        <input id="wft002" name="wft002" onblur="getSumFee" style="width:70px" class="mini-textbox" vtype="int" value="0"/>
                        <label for="wft004">检测费</label> <input id="wft004" onblur="getSumFee" style="width:70px" name="wft004" value="0" class="mini-textbox" vtype="int"/>
                        <label for="wft006">折扣率</label> <input id="wft006" onblur="getSumFee" style="width:40px" name="wft006" value="1"  class="mini-textbox" vtype="float;range:0,1"/>
                        <label for="wft007">合计：</label> <input id="wft007" style="width:70px" name="wft007"  class="mini-textbox" vtype="int"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="wat004">预约时间：</label>
                    </td>
                    <td>
                        <input id="wat004" name="wat004" class="mini-datepicker" style="width: 200px;"
                               format="yyyy-MM-dd H:mm" timeFormat="H:mm" showTime="true" showOkButton="true" />
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="userid">业务人员：</label>
                    </td>
                    <td>
                        <input id="userid" class="mini-combobox"  textField="name" valueField="userId"
                               url="<%=request.getContextPath()%>/admin/queryAllUser" value="${user.userId}"  required="true" allowInput="true" nullItemText="请选择..."/>

                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="wat005">数量及项目说明：</label>
                    </td>
                    <td>
                        <input id="wat005" name="wat005" style="width: 300px;"  class="mini-textarea" />
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="aae013">备注：</label>
                    </td>
                    <td>
                        <input id="aae013" name="aae013" style="width: 300px;"  class="mini-textarea" />
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div  title="检测信息" class="mini-fit" style="height:100%;">
        <div id="datagrid" class="mini-datagrid" style="width: 100%;height: 150px;" allowResize="true" pageSize="10"
             onrowclick="onrowclick" idField="bbz001">
            <div property="columns">
                <div field="wbt001" width="20" headerAlign="center"  >报告ID</div>
                <div field="bbz002" width="200" headerAlign="center" >标准名称</div>
                <div field="bbz003" width="40" headerAlign="center" >标签</div>
                <div field="bbz004" width="80" headerAlign="center" >标准代码</div>
            </div>
        </div>
        <div id="datagrid2" class="mini-datagrid" style="width: 100%;height: 240px; margin-top: 6px" pagerButtons="#buttons"
             allowResize="true" pageSize="100"  allowCellEdit="true" allowCellSelect="true" oncellclick="onBcz002sClick"
             editNextOnEnterKey="true"  editNextRowCell="true" idField="idx" showGroupSummary="true" showSummaryRow="true">
            <div property="columns">
                <div field="bbz001" width="20" headerAlign="center" visible="false" >标准id</div>
                <div field="idx" width="20" headerAlign="center" visible="false" >IDX</div>
                <div field="wct001" width="20" headerAlign="center" >采样点ID</div>
                <div field="wbt001" width="20" headerAlign="center" >报告ID</div>
                <div field="wct002" width="50" headerAlign="center"  >采样点名称
                    <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" /></div>
                <div field="bcz001s"  width="120" headerAlign="center" visible="false" >检测项目id</div>
                <div field="bcz002s"  width="170" headerAlign="center"  >检测项目</div>
                <div field="bcz010"  width="30" headerAlign="center"  summaryType="sum" dataType="currency" currencyUnit="￥" >费用</div>
                <div headerAlign="center" width="20" renderer="renderUser2" visible="false">操作</div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    var wat001=${param.wat001}
    var grid=mini.get("datagrid");
    var grid2=mini.get("datagrid2");
    var form=new mini.Form("#form1")
    var url="${pageContext.request.contextPath}/work/f100201/queryWtList";
    Web.util.formLoad("form1",url,"post",{wat001:wat001},function (data) {
        $("#span_wat002").html(data.wat002);
        mini.get("aab301").setValue(data.aab301);
        mini.get("wat003").setValue(data.wat003);
        mini.get("bhz003").setValue(data.bhz003);
        mini.get("userid").setValue(data.userid);
        mini.get("aae003").setValue(""+data.aae003);
        form.setEnabled(false);
    })
    var url="${pageContext.request.contextPath}/work/f100201/queryWt02"
    Web.util.request(url,'post',{wat001:wat001},function (data) {
      var i=0;
      for(var d;d=data[i++];){
          grid.addRow({wbt001:d.wbt001,wat001:d.wat001,bbz002:d.bbz002,bbz003:d.bbz003,bbz004:d.bbz004})
          var j=0;
          for (var c;c=d.wt03DtoList[j++];){
              var bcz002s="",m=0,bcz010=0;
              for(var x;x=c.wt04DtoList[m++];){
                  if(bcz002s=="") bcz002s=bcz002s+x.bcz002;
                  else bcz002s=bcz002s+","+x.bcz002;
                  bcz010+=x.wxt004;
              }
              grid2.addRow({wbt001:c.wbt001,wct001:c.wct001,wct002:c.wct002,bcz002s:bcz002s,bcz010:bcz010});
          }
      }
    })
</script>
</html>
