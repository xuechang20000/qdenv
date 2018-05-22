<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        #form1 table td{padding: 3px}
        #bz02list{
            text-align: center; /*让div内部文字居中*/
            background-color: #fff;
            border-radius: 20px;
            width: 300px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            z-index: 999;
            display: none;
        }
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
                        <input id="aae003" name="aae003" class="mini-monthpicker" onvaluechanged="setWat002" enabled="false" style="width: 100px;" format="yyyyMM" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="wat003">检测类别：</label>
                    </td>
                    <td>
                        <input id="wat003" class="mini-combobox" enabled="false" style="width: 200px;" onvaluechanged="setWat002" textField="dictName" valueField="dictVal"
                               url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WAT003" value="E"  required="true" allowInput="true" nullItemText="请选择..."/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label for="bhz003">行业类别：</label>
                    </td>
                    <td>
                        <input id="bhz003" class="mini-combobox" enabled="false" style="width: 200px;" onvaluechanged="setWat002" textField="bzh002" valueField="bhz003"
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
                        <input id="aab301" class="mini-combobox" enabled="false" style="width: 70px;" onvaluechanged="setWat002" textField="dictName" valueField="dictVal"
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
                <tr><td colspan="2" align="center">
                    <a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
                    <a class="mini-button" href="javascript:doReset();"  iconCls="icon-redo" >重置</a>
                </td></tr>
            </table>
        </div>
    </div>
    <div  title="检测信息" class="mini-fit" style="height:100%;">
        <table style="width:100%;" align="left" >
            <tr>
                <td align="left" style="padding-bottom: 4px">
                    &nbsp;&nbsp;选取标准：
                    <div id="bbz001" class="mini-combobox" style="width:60%;"  popupWidth="600" textField="bbz002" valueField="bbz001"
                         url="<%=request.getContextPath()%>/work/f100602/queryBiaozhunList" value="" multiSelect="false"  showClose="true" onitemclick="onItemClick" >
                        <div property="columns">
                            <div header="ID" field="bbz001" width="20" visible="false"></div>
                            <div header="标准名称" width="240" field="bbz002"></div>
                            <div header="标签" field="bbz003"></div>
                            <div header="标准代码" width="100"  field="bbz004"></div>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <div id="datagrid" class="mini-datagrid" style="width: 100%;height: 150px;" allowResize="true" pageSize="10"
             onrowclick="onrowclick" idField="bbz001" pagerButtons="#grid1_buttons">
            <div property="columns">
                <div type="checkcolumn" ></div>
                <div field="idx" width="20" headerAlign="center">IDX</div>
                <div field="wat001" width="20" headerAlign="center" visible="false">委托ID</div>
                <div field="bbz001" width="20" headerAlign="center" visible="false">标准ID</div>
                <div field="wbt001" width="20" headerAlign="center" visible="false" >报告ID</div>
                <div field="bbz002" width="200" headerAlign="center" >标准名称</div>
                <div field="bbz003" width="40" headerAlign="center" >标签</div>
                <div field="bbz004" width="80" headerAlign="center" >标准代码</div>
                <div headerAlign="center" width="40" renderer="renderUser">操作</div>
            </div>
        </div>
        <div id="datagrid2" class="mini-datagrid" style="width: 100%;height: 240px; margin-top: 6px" pagerButtons="#buttons"
             allowResize="true" pageSize="100"  allowCellEdit="true" allowCellSelect="true" oncellclick="onBcz002sClick"
             editNextOnEnterKey="true"  editNextRowCell="true" idField="idx" showGroupSummary="true" showSummaryRow="true">
            <div property="columns">
                <div field="bbz001" width="20" headerAlign="center" visible="false" >标准id</div>
                <div field="idx" width="20" headerAlign="center">IDX</div>
                <div field="wct001" width="20" headerAlign="center" >采样点ID</div>
                <div field="wbt001" width="20" headerAlign="center" visible="false" >报告ID</div>
                <div field="wct002" width="50" headerAlign="center"  >采样点名称
                    <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" /></div>
                <div field="bcz001s"  width="120" headerAlign="center" visible="false" >检测项目id</div>
                <div field="bcz002s"  width="170" headerAlign="center"  >检测项目</div>
                <div field="bcz010"  width="30" headerAlign="center"  summaryType="sum" dataType="currency" currencyUnit="￥" >费用</div>
                <div headerAlign="center" width="30" renderer="renderUser2" >操作</div>
            </div>
        </div>
    </div>
    <shiro:hasPermission name="DO_14">
    <div title="安排采样" class="mini-fit" style="height: 100%;"></div>
    </shiro:hasPermission>
    <div title="发票信息" class="mini-fit" style="height:100%;"></div>
    <div title="快递信息" class="mini-fit" style="height: 100%"></div>
</div>

<span id="grid_buttons" style="display: none"  >
         <a class="mini-button" href="javascript:onRemove()" plain="true" iconCls="icon-remove">删除</a>
    </span>
<span id="grid_buttons2" style="display: none"  >
         <a class="mini-button" href="javascript:onRemove2()" plain="true" iconCls="icon-remove"></a>
         <a class="mini-button" href="javascript:onEdit2()" plain="true" iconCls="icon-edit"></a>
    </span>
<div id="buttons">
    <shiro:hasPermission name="DO_11">
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-add" plain="true" onclick="addGrid2Row()"></a>
    </shiro:hasPermission>
    <span class="separator"></span>
    <a class="mini-button" href="javascript:onGrid2Save()" plain="true" iconCls="icon-save">保存</a>
</div>
<div id="grid1_buttons">
         <a class="mini-button" href="javascript:onGrid1Save()" plain="true" iconCls="icon-save">保存</a>
</div>
<div id="bz02list" class="mini-panel"  title="选择检测项目" iconCls="icon-add"
     style="width:500px;height:380px;" buttons="close">
    &nbsp;&nbsp;选取组合：
    <div id="bbz003s" class="mini-combobox" style="width:60%; margin-bottom: 6px;"  popupWidth="350" textField="bzz002" valueField="bzz001"
         multiSelect="false"  showClose="true" onitemclick="onItemClick2" >
        <div property="columns">
            <div header="组合名称" width="100" field="bzz002"></div>
            <div header="组合列表" field="bzz003s"></div>
            <div header="组合列表id" width="50"  field="bzz003"></div>
        </div>
    </div>
    <div id="listbox2" class="mini-listbox" valueField="bcz001" textField="bcz002" showCheckBox="true" multiSelect="true" url="" >
        <div property="columns">
            <div header="ID" field="bcz001"></div>
            <div header="项目" field="bcz002"></div>
            <div header="费用" field="bcz010"></div>
        </div>
    </div>
    <br/>
    <a class="mini-button" href="javascript:onSelectbz02();"  iconCls="icon-ok" >选择</a>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    var wat001=${param.wat001}
    var grid=mini.get("datagrid");
    var grid2=mini.get("datagrid2");
    var form=new mini.Form("#form1");
    var wft031;//合计费用是否可改
    loadWt();
    function loadWt() {
        var url="${pageContext.request.contextPath}/work/f100201/queryWtList";
        Web.util.formLoad("form1",url,"post",{wat001:wat001},function (data) {
            $("#span_wat002").html(data.wat002);
            mini.get("aab301").setValue(data.aab301);
            mini.get("wat003").setValue(data.wat003);
            mini.get("bhz003").setValue(data.bhz003);
            mini.get("userid").setValue(data.userid);
            mini.get("aae003").setValue(""+data.aae003);
            wft031=data.wft031;
            if("2"==wft031&&data.roleCode!="B"){
                mini.get("wft007").set({enabled:false})
            }
            if(data.roleCode=="B"){
                mini.get("aab301").enable();
                mini.get("wat003").enable();
                mini.get("bhz003").enable();
            }
        });
        var url="${pageContext.request.contextPath}/work/f100201/queryWt02"
        Web.util.request(url,'post',{wat001:wat001},function (data) {
            var i=0;
            grid.clearRows();
            grid2.clearRows();
            for(var d;d=data[i++];){
                var idx=v_idx++;
                grid.addRow({idx:idx,bbz001:d.bbz001,wbt001:d.wbt001,wat001:d.wat001,bbz002:d.bbz002,bbz003:d.bbz003,bbz004:d.bbz004})
                var j=0;
                for (var c;c=d.wt03DtoList[j++];){
                    var bcz002s="",bcz001s="",m=0,bcz010=0;
                    for(var x;x=c.wt04DtoList[m++];){
                        if(bcz002s=="") bcz002s=bcz002s+x.bcz002;
                        else bcz002s=bcz002s+","+x.bcz002;
                        if(bcz001s=="") bcz001s=bcz001s+x.bcz001;
                        else bcz001s=bcz001s+","+x.bcz001;
                        bcz010+=x.wxt004;
                    }
                    grid2.addRow({idx:idx,bbz001:c.bbz001,wbt001:c.wbt001,wct001:c.wct001,wct002:c.wct002,bcz001s:bcz001s,bcz002s:bcz002s,bcz010:bcz010});
                }
            }
            grid.accept();
            grid2.accept();
        });
    }


    var bbz001;
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onRemove() {
        var row1=grid.getSelected();
        var rows2=grid2.findRows(function (row) {
            if (row.idx==row1.idx) {
                return true;
            }
        });
        Web.util.confirm("确定要删除吗？",function () {
            grid2.removeRows(rows2,true);
            grid.removeRow(row1);
        })

    }
    function renderUser2(e) {
        return $("#grid_buttons2").clone().css("display","inline").html();
    }
    function onRemove2() {
        Web.util.confirm("确定要删除吗？",function () {
            grid2.removeRow( grid2.getSelected());
        })

        setJianceFee();
    }
    function onEdit2() {
        var row=grid2.getSelected();
        if(!row.wct001){
            Web.util.showTipsWanring("请先保存再操作")
            return;
        }
        var url='${pageContext.request.contextPath}/work/f100202/loadWt03?wct001='+row.wct001;
        Web.util.openMiniWindow("采样编辑",url,900,500,function () {
            
        })
    }

    var v_idx=1;
    function onItemClick(e) {
        var select=mini.get("bbz001").getSelected();
        var row={idx:v_idx++,wat001:wat001,wbt003:'0',bbz001:select.bbz001,bbz002:select.bbz002,bbz003:select.bbz003,bbz004:select.bbz004}
        grid.addRow(row,-1);
        grid.select(row)
    }
    function onItemClick2(e) {
        var select=mini.get("bbz003s").getSelected();
        mini.get("listbox2").setValue('')
        mini.get("listbox2").setValue(select.bzz003)

    }
    function addGrid2Row() {
        var selectGrids=grid.getSelected();
        if(!selectGrids) {
            Web.util.showTipsWanring("请点击选中标准")
            return;
        }
        if(!validateRows()) return false;
        var newRow={idx:selectGrids.idx,bbz001:selectGrids.bbz001,wbt001:selectGrids.wbt001}
        grid2.addRow(newRow,-1);
    }
    function validateRows() {
        var rows=grid2.findRows(function (row) {
            return true;
        });
        var i=0;
        for (var row;row=rows[i++];){
            //alert(JSON.stringify(row))
            if(!row.wct002||row.wct002==''){
                Web.util.showTipsWanring("采样点名称不能为空")
                return false;
            }
            if(!row.bcz002s||row.bcz002s==''){
                Web.util.showTipsWanring("检测项目不能为空")
                return false;
            }
        }
        return true;
    }
    function onrowclick(e) {
        bbz001=e.record.bbz001;
        mini.get("bbz003s").load("${pageContext.request.contextPath}/work/f100603/queryFenzuList?bbz001="+bbz001)
    }
    var grid2_now_row;
    function onBcz002sClick(e) {
        var bbz001_v=e.record.bbz001;
        if(bbz001_v==null||bbz001_v==''){
            bbz001_v=bbz001;
        }
        if(bbz001_v==null||bbz001_v==''){
            Web.util.showTipsWanring("请选择报告")
            return;
        }
        if(e.column.field=='bcz002s'){
            $("#bz02list").css("display","block");
            mini.get("listbox2").load("${pageContext.request.contextPath}/work/f100602/queryXiangMuList?bbz001="+bbz001_v)
            grid2_now_row=grid2.getSelected();
        }
    }
    function onSelectbz02() {
        $("#bz02list").css("display","none");
        var selectRows=mini.get("listbox2").getSelecteds();
        var i=0,vals='',texts='',fee=0;
        for (var row;row=selectRows[i++];){
            if(row.bcz010) fee+=row.bcz010;
            if(i==1){
                vals=vals+row.bcz001;
                texts=texts+row.bcz002;
            }else{
                vals=vals+','+row.bcz001;
                texts=texts+','+row.bcz002;
            }
        }
        grid2_now_row.bcz002s=texts;
        grid2_now_row.bcz001s=vals;
        grid2_now_row.bcz010=fee;
        grid2_now_row._state='added';
        grid2.updateRow(grid2_now_row,grid2_now_row);
        setJianceFee();
    }
    function setInMiddle(){
        var a = document.getElementById("bz02list");//获取div块对象
        var Height=document.documentElement.clientHeight;//取得浏览器页面可视区域的宽度
        var Width=document.documentElement.clientWidth;//取得浏览器页面可视区域的宽度
        var gao1 = a.offsetHeight;//获取div块的高度值
        var gao2 = a.offsetWidth;//获取div块的宽度值
        var Sgao1= (Height - gao1)/2+"px";
        var Sgao2= (Width - gao2)/2+"px";
        a.style.top=Sgao1;
        a.style.left=Sgao2;
    }

    function setJianceFee() {
        var rows=grid2.findRows(function (row) {
            return true;
        });
        var i=0,fee=0;
        for (var row;row=rows[i++];){
            if(row.bcz010) fee+=row.bcz010;
        }
        mini.get('wft004').setValue(fee);
        getSumFee();
    }
    function getSumFee() {
        if(mini.get(wft007).enabled==false) return;
        var wft002=mini.get('wft002').getValue();
        var wft004=mini.get('wft004').getValue();
        var wft006=mini.get('wft006').getValue();
        wft006==''?0:wft006;
        var sum=parseInt(wft002==''?0:wft002)+parseInt(wft004==''?0:wft004);
        mini.get("wft007").setValue(Math.floor(sum*wft006));
    }
    function setWat002() {
        var aae003=mini.get("aae003").getFormValue();
        var wat003=mini.get("wat003").getValue();
        var bhz003=mini.get("bhz003").getValue();
        var aab301=mini.get("aab301").getValue();
        if(aae003==''||wat003==''||bhz003==''||aab301=='')  return;
        var wat015=aae003.substr(0,4)+wat003+bhz003+aab301;
        var url="${pageContext.request.contextPath}/work/f100201/getWat016"
        Web.util.request(url,"post",{wat015:wat015},function (data) {
            var wat016=PrefixInteger(data,4);
            mini.get("wat002").setValue(wat015+"-"+wat016);
            $("#span_wat002").html(wat015+"-"+wat016);
            mini.get("wat015").setValue(wat015);
            mini.get("wat016").setValue(wat016);
        })
    }
    function doSubmit() {
        setJianceFee();
        var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) {
            Web.util.showTipsWanring('填写有误，请修正！');
            return;
        }
        if(!validateRows()) return;
        Web.util.confirm("确定要保存？",function (action) {
            var data = form.getData(true);
            data.wat003=mini.get("wat003").getValue();
            data.bhz003=mini.get("bhz003").getValue();
            data.aab301=mini.get("aab301").getValue();
            data.userid=mini.get("userid").getValue();
            var jsonGrid1= grid.getChanges();
            var jsonGrid2= grid2.getChanges();
            jsonGrid1=JSON.stringify(jsonGrid1);
            jsonGrid2=JSON.stringify(jsonGrid2);
            if( typeof(jsonGrid1)!= 'undefined')  data.json1=jsonGrid1;
            if( typeof(jsonGrid2)!= 'undefined')   data.json2=jsonGrid2;
            var url="${pageContext.request.contextPath}/work/f100201/saveWt";
            Web.util.request(url,"post",data,function (data) {
                //mini.get("doSubmit").disable();
                loadWt();
                Web.util.showTips("保存成功！")
            })
        });
    }
    function onGrid1Save() {
        doSubmit();
    }
    function onGrid2Save() {
        doSubmit();
    }
    function doReset() {
        var form = new mini.Form("#form1");
        form.reset();
        $("#span_wat002").html('');
        mini.get("doSubmit").enable();
    }
    var tabs=mini.get("tabs1");
    tabs.on("activechanged", function (e) {
        if (e.tab.title == "发票信息") {
            var tab = tabs.getActiveTab();
            if(!tabs.getTabBodyEl(tab).innerHTML)
            tabs.loadTab("${pageContext.request.contextPath}/work/f100202/loadInvoice?wat001="+wat001, tab);
            e.cancel = true;
        }
        if (e.tab.title == "安排采样") {
            var tab = tabs.getActiveTab();
            if(!tabs.getTabBodyEl(tab).innerHTML)
            tabs.loadTab("${pageContext.request.contextPath}/work/f100202/loadDO_14?wat001="+wat001, tab);
            e.cancel = true;
        }
        if (e.tab.title == "快递信息") {
            var tab = tabs.getActiveTab();
            if(!tabs.getTabBodyEl(tab).innerHTML)
            tabs.loadTab("${pageContext.request.contextPath}/work/f100202/loadDO_6?wat001="+wat001, tab);
            e.cancel = true;
        }
    });
</script>
</html>
