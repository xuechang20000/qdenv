<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>

&nbsp;&nbsp;<a class="mini-button" iconCls="icon-undo" plain="true" onclick="javascript:history.go(-1);">返回</a>
<span id="title" style="font-size: 22px;padding-left: 20%;line-height: 30px">${dto.bbz002}${dto.bbz004}</span>
<div class="mini-fit" style="height:100%;">
    <div id="datagrid1" class="mini-datagrid" style="width: 100%;height:100%;" allowResize="true" pagerButtons="#buttons"
         url="<%=request.getContextPath()%>/work/f100602/queryXiangMu"  idField="bcz001" pageSize="100"
         allowCellEdit="true" allowCellSelect="true" showGroupSummary="true" showSummaryRow="true"
         editNextOnEnterKey="true"  editNextRowCell="true" navEditMode="true">
        <div property="columns">
            <div field="index" type="indexcolumn" ></div>
            <div field="bcz001" width="20"  headerAlign="center"  visible="false">ID</div>
            <div field="bcz002" width="140"width="20" headerAlign="center" >检测项目名称
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" /></div>
            <div type="comboboxcolumn" field="bcz003" width="40" headerAlign="center"   >标准类型
                <input property="editor" class="mini-combobox" style="width:100%;" textField="dictName" valueField="dictVal"
                       popupWidth="120"  url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=bcz003" />
            </div>
            <div field="bcz0045" width="60" headerAlign="center" >标准值
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="60" />
            </div>
            <div field="bcz006"  width="40" headerAlign="center" >单位
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="40" />
            </div>
            <div field="bcz010" width="60" headerAlign="center" summaryType="sum" dataType="currency" currencyUnit="￥">单项收费(元)
                <input property="editor" class="mini-textbox"  style="width:100%;" minWidth="40" />
            </div>
            <div type="comboboxcolumn" field="bcz011" width="80" headerAlign="center"   >主要采样仪器
                <input property="editor" class="mini-combobox" style="width:100%;" textField="bmz002s" valueField="bmz001"
                       popupWidth="300"   url="<%=request.getContextPath()%>/work/f100604/queryBz06List?aae016=1" />
            </div>
            <div type="comboboxcolumn" field="bcz012" width="80" headerAlign="center"   >主要检测仪器
                <input property="editor" class="mini-combobox" style="width:100%;" textField="bmz002s" valueField="bmz001"
                       popupWidth="300"   url="<%=request.getContextPath()%>/work/f100604/queryBz06List?aae016=1" />
            </div>
            <!--<div field="bcz007"  width="20" headerAlign="center" >排序</div>-->
            <div field="bcz008"  headerAlign="center" width="140">检测依据
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="350" />
            </div>
            <div field="bcz009"  headerAlign="center" >样品要求
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="350" />
            </div>
            <div headerAlign="center" width="40" renderer="renderUser">操作</div>
        </div>
    </div>

    <span id="grid_buttons" style="display: none"  >
         <a class="mini-button" href="javascript:onRemove()" plain="true" iconCls="icon-remove">删除</a>
    </span>
    <div id="buttons">
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-add" plain="true" onclick="addRow()">添加</a>
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-upload" plain="true" onclick="moveUp()">上移</a>
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-download" plain="true" onclick="moveDown()">下移</a>
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-save" plain="true" id="doSubmit" onclick="onSave()">保存</a>
    </div>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    var grid=mini.get("datagrid1");
    var bbz001=${param.bbz001};

    Web.util.load("datagrid1",{bbz001:bbz001});


    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }

    function addRow() {
       if(!validateRows()) return false;
        var newRow = { bcz002: "",bcz003:"",bcz0045:"",bcz006:"",bcz010:"" };
        grid.addRow(newRow, -1);
        grid.beginEditCell(newRow, "bcz002");
    }
    function onSave() {
        if(!validateRows()) return false;
        grid.accept();
        var rows=getALlRows();
        var url="<%=request.getContextPath()%>/work/f100602/saveXiangMu";
        Web.util.requestAsync(url,'',{json:JSON.stringify(rows)},function(data,textstatus){
            Web.util.showTips("保存成功！ ");
            mini.get("doSubmit").disable();
        });
    }
    function getALlRows() {
        var rows=grid.findRows(function (row) {
            return true;
        });
        return rows;
    }
    function validateRows() {
        var rows=getALlRows();
        var i=0;
        for (var row;row=rows[i++];){
            if(!validateRow(row)) return false;
            row.rowIndex=grid.indexOf(row);
            row.bbz001=bbz001;
        }
        return true;
    }
    function validateRow(row) {

        if(row.bcz002=='') {
            Web.util.showTipsWanring("检测项目名称请填写完整");
            return false;
        }
        if(row.bcz003=='') {
            Web.util.showTipsWanring("标准类型请填写完整");
            return false;
        }
        if(row.bcz0045=='') {
            Web.util.showTipsWanring("标准值请填写完整");
            return false;
        }
        if(row.bcz006=='') {
            Web.util.showTipsWanring("单位请填写完整");
            return false;
        }
        if(row.bcz010=='') {
            Web.util.showTipsWanring("单项收费标准请填写完整");
            return false;
        }
        var reg=/^[-\+]?\d+(\.\d+)?$/;
        if(!reg.test(row.bcz010)) {
            Web.util.showTipsWanring("单项收费标准输入格式不正确");
            return false;
        }
        if (row.bcz003==5){
            var reg=/^[-\+]?\d+(\.\d+)?~[-\+]?\d+(\.\d+)?$/;
            if(!reg.test(row.bcz0045)) {
                Web.util.showTipsWanring("标准值输入格式不正确");
                return false;
            }
        }else{
            var reg= /^[-\+]?\d+(\.\d+)?$/;
            if(!reg.test(row.bcz0045)) {
                Web.util.showTipsWanring("标准值输入格式不正确");
                return false;
            }
        }
        return true;
    }
    function onRemove() {
       grid.removeRow( grid.getSelected());
    }

    function moveUp() {
        var row = grid.getSelected();
        if (row) {
            var index = grid.indexOf(row);
            grid.moveRow(row, index - 1);
        }
    }

    function moveDown() {
        var row = grid.getSelected();
        if (row) {
            var index = grid.indexOf(row);

            grid.moveRow(row, index + 2);
        }
    }
</script>
</html>
