<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>


<div class="mini-fit" style="height:100%;">
    <div id="datagrid1" class="mini-datagrid" style="width: 50%;height:100%; float: left" allowResize="true" pagerButtons="#buttons" onrowclick="onrowclick"
         url="<%=request.getContextPath()%>/work/f100602/queryBiaozhun?aae016=1"  idField="bbz001">
        <div property="columns">
            <div field="bbz001" width="20"  headerAlign="center" allowSort="true" visible="false">ID</div>
            <div field="bbz002" width="100"width="20" headerAlign="center" allowSort="true">标准名称</div>
            <div field="bbz003" width="40" headerAlign="center" allowSort="true">标签</div>
            <div field="bbz004" width="60" headerAlign="center" allowSort="true">标准代码</div>
            <!--<div field="bbz005"  width="40" headerAlign="center" allowSort="true">标准年度</div>-->
            <div field="bzh002s"  width="100" headerAlign="center" allowSort="true">所属行业</div>
            <div field="bbz006"  width="50" headerAlign="center" dataType="date" dateFormat="yyyy-MM-dd" visible="false" allowSort="true">建立时间</div>
            <div field="aae016"  width="40" headerAlign="center" allowSort="true" renderer="oncodeRender" visible="false">有效标志</div>
        </div>
    </div>
    <div id="datagrid2" class="mini-datagrid" style="width: 49%;height:100%; float: right" allowResize="true" pagerButtons="#buttons2"
         url="<%=request.getContextPath()%>/work/f100603/queryFenzu"  idField="bbz001">
        <div property="columns">
            <div field="bzz001" width="20"  headerAlign="center" allowSort="true" visible="false">ID</div>
            <div field="bzz002" width="50"width="20" headerAlign="center" allowSort="true">分组名称</div>
            <div field="bzz003s" width="150"width="20" headerAlign="center" allowSort="true">项目</div>
            <div headerAlign="center"   width="30" renderer="renderUser">操作</div>
        </div>
    </div>
    <div id="buttons">
        <span class="separator"></span>
        <input id="key" class="mini-textbox" emptyText="请输入关键词" style="width:150px;" onenter="onKeyEnter"/>
        <a class="mini-button" onclick="search()">查询</a>
    </div>
    <div id="buttons2">
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-add" plain="true" onclick="onAdd()"></a>
    </div>
</div>
<span id="grid_buttons" style="display: none"  >
        <a class="mini-button" href="javascript:onDelete()" plain="true" iconCls="icon-remove">删除</a>
    </span>
</body>
<script type="text/javascript">
    mini.parse();
    var grid2=mini.get("datagrid2");
    Web.util.load("datagrid1");
    var bbz001;
    function onrowclick(e) {
        bbz001=e.record.bbz001;
        Web.util.load("datagrid2",{"bbz001":bbz001});
    }
    function renderUser(e) {
        return $("#grid_buttons").clone().css("display","inline").html();
    }
    function onDelete() {

        var bzz001=grid2.getSelected().bzz001;
        var url="<%=request.getContextPath()%>/work/f100603/deleteFenzu";
        Web.util.requestAsync(url,'',{"bzz001":bzz001},function(data,textstatus){
            Web.util.reload("datagrid2")
        });
    }
    function onAdd() {
        if(!bbz001){
            Web.util.showTipsWanring("请选择标准")
            return false;
        }
        Web.util.openMiniWindow('添加',"<%=request.getContextPath()%>/work/f100603/loadZuheAdd?bbz001="+bbz001,500,400,function () {
            Web.util.reload("datagrid2");
        })
    }
    function search() {
        var grid=mini.get("datagrid1");
        var key = mini.get("key").getValue();
        if(isChinese(key)){
            grid.load({ bbz002: key });
        }else{
            grid.load({ bbz004: key });
        }
    }
    function onKeyEnter(e) {
        search();
    }
</script>
</html>
