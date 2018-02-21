<%@ page contentType="text/html; charset=utf-8"%>
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
<div style="width:43%;height:100%; float: left">
    <fieldset id="fd1" >
        <legend><span>委托信息</span></legend>
    <div id="form1" >
        <input name="wat001" class="mini-hidden" />
        <table>
            <tr>
                <td align="right">
                    <label for="wat002">委托编号：</label>
                </td>
                <td align="left">
                    <input id="wat002"  name="wat002" style="width: 100px;" class="mini-textbox" required="true" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="aae003">委托年月：</label>
                </td>
                <td>
                    <input id="aae003" name="aae003" class="mini-monthpicker" style="width: 100px;" format="yyyyMM" required="true"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wat003">检测类别：</label>
                </td>
                <td>
                    <input id="wat003" class="mini-combobox" style="width: 200px;" textField="dictName" valueField="dictVal"
                           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WAT003" value="E"  required="true" allowInput="true" nullItemText="请选择..."/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="bhz003">行业类别：</label>
                </td>
                <td>
                    <input id="bhz003" class="mini-combobox" style="width: 200px;" textField="bzh002" valueField="bhz003"
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
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="daw004">电话：</label>
                </td>
                <td>
                    <input id="daw004" name="daw004" style="width: 150px;" class="mini-textbox" required="true"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="daw005">地点：</label>
                </td>
                <td>
                    <input id="aab301" class="mini-combobox" style="width: 70px;" textField="dictName" valueField="dictVal"
                           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=AAB301"   required="true" allowInput="true" nullItemText="请选择..."/>
                    <input id="daw005" name="daw005" style="width: 240px;" class="mini-password" required="true"/>
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
    </fieldset>
</div>
<div style="width:55%;height:100%; float: left;margin-left: 8px">
    <div class="mini-fit" style="height:100%;">
    <fieldset id="fd2" >
        <legend><span>费用信息</span></legend>
        <table style="width:100%;" align="left">
            <tr>
                <td align="right">
                  选取标准：
                </td>
                <td align="left">
                    <div id="bbz001" class="mini-combobox" style="width:80%;"  popupWidth="400" textField="bbz002" valueField="bbz001"
                         url="<%=request.getContextPath()%>/work/f100602/queryBiaozhunList" value="" multiSelect="false"  showClose="true" onitemclick="onItemClick" >
                        <div property="columns">
                            <div header="ID" field="bbz001" width="20" visible="false"></div>
                            <div header="标准名称" width="170" field="bbz002"></div>
                            <div header="标签" field="bbz003"></div>
                            <div header="标准代码" field="bbz004"></div>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <div id="datagrid" class="mini-datagrid" style="width: 100%;height: 150px;" allowResize="true" pageSize="10"
             onrowclick="onrowclick" idField="bbz001">
            <div property="columns">
                <div type="indexcolumn">IDX</div>
                <div field="bbz001" width="20" headerAlign="center" visible="false" >ID</div>
                <div field="bbz002" width="200" headerAlign="center" >标准名称</div>
                <div field="bbz003" width="40" headerAlign="center" >标签</div>
                <div field="bbz004" width="80" headerAlign="center" >标准代码</div>
                <div headerAlign="center" width="40" renderer="renderUser">操作</div>
            </div>
        </div>
        <div id="datagrid2" class="mini-datagrid" style="width: 100%;height: 240px; margin-top: 6px" pagerButtons="#buttons"
             allowResize="true" pageSize="100"  allowCellEdit="true" allowCellSelect="true"
             editNextOnEnterKey="true"  editNextRowCell="true" idField="idx">
            <div property="columns">
                <div field="bbz001" width="20" headerAlign="center" visible="false" >IDX</div>
                <div field="idx" width="20" headerAlign="center" >IDX</div>
                <div field="wct002" width="100" headerAlign="center"  >采样点名称
                    <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" /></div>
                <div field="bcz002s"  width="120" headerAlign="center" >检测项目
                    <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" onclick="onBcz002sClick()" />
                </div>
                <div headerAlign="center" width="40" renderer="renderUser2">操作</div>
            </div>
        </div>
    </fieldset>
</div>
</div>
<span id="grid_buttons" style="display: none"  >
         <a class="mini-button" href="javascript:onRemove()" plain="true" iconCls="icon-remove">删除</a>
    </span>
<span id="grid_buttons2" style="display: none"  >
         <a class="mini-button" href="javascript:onRemove2()" plain="true" iconCls="icon-remove">删除</a>
    </span>
<div id="buttons">
    <span class="separator"></span>
    <a class="mini-button" iconCls="icon-add" plain="true" onclick="addGrid2Row()"></a>
</div>

    <div id="bz02list" class="mini-panel"
         title="选择检测项目" iconCls="icon-add" style="width:340px;height:480px;" buttons="close">
    <div id="datagrid3"  class="mini-datagrid" style="width:300px;height:400px;" pageSize="100"
         url="<%=request.getContextPath()%>/work/f100602/queryXiangMuList" multiSelect="true" idField="bcz001">
        <div property="columns">
            <div type="checkcolumn"></div>
            <div field="bcz001" width="20" headerAlign="center" visible="false" >检测项目ID</div>
            <div field="bbz001" width="20" headerAlign="center" visible="false" >标准ID</div>
            <div field="bcz002" width="100" headerAlign="center" >检测项目名称</div>
        </div>
    </div>
        <a class="mini-button" href="javascript:"  iconCls="icon-ok" >选择</a>
</div>

</body>
<script type="text/javascript">
    mini.parse();
    var grid=mini.get("datagrid");
    var grid2=mini.get("datagrid2");
    var bbz001;
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onRemove() {
        grid.removeRow( grid.getSelected());
    }
    function renderUser2(e) {
        return $("#grid_buttons2").clone().css("display","inline").html();
    }
    function onRemove2() {
        grid2.removeRow( grid2.getSelected());
    }
    function onItemClick(e) {
        var select=mini.get("bbz001").getSelected();
        var row={bbz001:select.bbz001,bbz002:select.bbz002,bbz003:select.bbz003,bbz004:select.bbz004}
        grid.addRow(row,-1);
    }
    function addGrid2Row() {
        var selectGrids=grid.getSelected();
        if(!selectGrids) {
            Web.util.showTipsWanring("请点击选中标准")
            return;
        }
        if(!validateRows()) return false;
        var newRow={idx:grid.indexOf(selectGrids)+1,bbz001:selectGrids.bbz001}
        grid2.addRow(newRow,-1);
    }
    function validateRows() {
        var rows=grid2.findRows(function (row) {
            return true;
        });
        var i=0;
        for (var row;row=rows[i++];){
            alert(JSON.stringify(row))
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
        mini.get("datagrid3").load({bbz001:bbz001})
    }
    function onBcz002sClick() {
        $("#bz02list").css("display","block");
        //setInMiddle()
        //var clone=$("#bz02list").clone().css("display","").html();
        /*mini.showMessageBox({
            width: 500,
            height:600,
            title: "选择检测项目",
            buttons: ["ok", "cancel"],
            html: clone,
            showModal: false,
            callback: function (action) {
                var rows=mini.get("datagrid3").getSeconds();
                alert(JSON.stringify(rows));
            }
        });*/
    }
    function onbuttonclick(e) {
        if (e.name == "remove") {
            $("#bz02list").css("display","none");
        }
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
</script>
</html>
