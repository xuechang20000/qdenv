<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>检测数据</title>

    <%@include file="/include/head.jsp"%>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/scripts/lodopFuncs.js"></script>
    <object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
        <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
    </object>

    <style type="text/css" id="bodyStyle">
        body{font-weight: bold}
        .display_title{text-align: center;font-size: 18px;}
        .display_table {text-align: center; font-size: 14px}
        .display_title_sub{font-size: 12px}
        .display_table table{width:100%;border-color: black ;border-collapse: collapse;font-size:12px;text-align: center}
    </style>
</head>
<body>


<input type="button" id="next" value="流转" onClick="doNext()">&nbsp;&nbsp;
<!--input type="button" id="SaveAsEmfFile" value="导出图片" onClick="SaveAsEmfFile()">&nbsp;&nbsp;-->
<c:if test="${wt12.wlt005=='1'}">
<input type="button" id="preview" value="打印预览" onClick="dopreview()">&nbsp;&nbsp;
<input type="button" id="print" value="打印" onClick="doprint()">&nbsp;&nbsp;
</c:if>
<c:if test="${wt12.wlt009!=null}">
    最后打印时间 <fmt:formatDate value="${wt12.wlt009}"  type="both"/>
</c:if>
<div id="display1">
    <div class="display_title">青岛市室内装饰行业协会室内环境监测中心<br/>
        样品流转单
    </div>
    <div class="display_title_sub"><span style="float: left">青室环检字第1000001号</span>
        <span style="float: right">2018 年度</span>
    </div>
    <div class="display_table">
        <table border="1" cellpadding="3" cellspacing="0">
            <tr>
                <td>检测编号</td>
                <td>${wt01.wat002}</td>
                <td>送样人员</td>
                <td>${wt01.fnames}</td>
                <td>送样日期</td>
                <td>${dto.daw005}</td>
                <td>接收人员</td>
                <td>${dto.daw005}</td>
                <td>接收日期</td>
                <td></td>
            </tr>
            <tr>
                <td rowspan="2">检测项目</td>
                <td rowspan="2">样品编号</td>
                <td rowspan="2">数量</td>
                <td colspan="2">采样现场环境条件</td>
                <td rowspan="2">样品保存方式</td>
                <td rowspan="2">是否密封</td>
                <td rowspan="2">检验人</td>
                <td rowspan="2">检验日期</td>
                <td rowspan="2">报废日期</td>
            </tr>
            <tr>
                <td>温度℃</td>
                <td>大气压kPa</td>
            </tr>
<c:forEach items="${wt04s}" var="wt04" varStatus="index">
    <tr>
    <td >${wt04.bcz002}</td>
    <td >${wt04.wxt009}</td>
    <td >1</td>
    <td >${wt04.wct003}</td>
    <td >${wt04.wct005}</td>
    <td >${wt04.wst010s}</td>
    <td >是</td>
    <td ></td>
    <td ></td>
    <td ></td>
    </tr>
</c:forEach>
        </table>
        <div class="display_title_sub"><span style="float: left">备注：</span>
        </div>
    </div>
</div>
</body>
<script language="javascript" type="text/javascript">
    var wat001=${wt01.wat001};
    var wlt001=${wt12.wlt001};
    var LODOP; //声明为全局变量
    function init() {
        LODOP=getLodop();
        LODOP.SET_PRINT_STYLEA(0,"Horient",2);//
        LODOP.SET_PRINT_PAGESIZE(2,"29.7cm","21cm","");
        LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED",1);
        var bodyStyle='<style>'+document.getElementById("bodyStyle").innerHTML+'</style>';
        var display1Content=document.getElementById("display1").innerHTML;
        LODOP.ADD_PRINT_HTM("3%","6%",1000,"85%",bodyStyle+'<body>'+display1Content+'</body>');
        LODOP.ADD_PRINT_HTM("197mm","260mm","190mm","277mm","<font style='font-size:12px' format='ChineseNum'><span tdata='pageNO'>第##页</span>/<span tdata='pageCount'>共##页</span></font>");
    }
    function dopreview() {
        init();
        LODOP.PREVIEW();
    };
    function doprint() {
        init();
       var isSuccess=LODOP.PRINT();
       if(isSuccess){
           Web.util.request("${pageContext.request.contextPath}/work/f100202/saveOrUpdateWt12","POST",{wlt001:wlt001,wat001:wat001,type:"2"},function () {
               Web.util.showTips("已成功打印");
               $("#print").hide();
               $("#preview").hide();
           })
       };
    }
    function SaveAsEmfFile(){
        LODOP=getLodop();
        LODOP.SET_PRINT_STYLEA(0,"Horient",2);//
        LODOP.SET_PRINT_PAGESIZE(2,"29.7cm","21cm","");
        LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED",1);
        var bodyStyle='<style>'+document.getElementById("bodyStyle").innerHTML+'</style>';
        var display1Content=document.getElementById("display1").innerHTML;
        LODOP.ADD_PRINT_HTM("3%","6%",1000,"85%",bodyStyle+'<body>'+display1Content+'</body>');
        LODOP.ADD_PRINT_HTM("197mm","260mm","190mm","277mm","<font style='font-size:12px' format='ChineseNum'><span tdata='pageNO'>第##页</span>/<span tdata='pageCount'>共##页</span></font>");

        var filePath="d:/a.jpg";
        //LODOP.SET_SAVE_MODE("SAVEAS_IMGFILE_EXENAME",".jpg");
        //LODOP.SAVE_TO_FILE("新的矢量图片文件.jpg");
        LODOP.SET_SAVE_MODE("FILE_PROMPT",false);
        LODOP.SAVE_TO_FILE(filePath);
        var imageBuffer=LODOP.FORMAT("FILE:EncodeBase64",filePath);
        alert(encodeURIComponent(imageBuffer))
    };
    function doNext() {
        var wlt007=${wt12.wlt007};
        if(wlt007&&"1"==wlt007){
           mini.alert("此流转单已经被打印，如需重新流转请线下通知下一环节人员！")
        }
        Web.util.confirm("确定无误要流转到下一环节吗？",function () {
            Web.util.request("${pageContext.request.contextPath}/work/f100202/saveOrUpdateWt12","POST",{wlt001:wlt001,wat001:wat001,type:"1"},function () {
                Web.util.showTips("保存成功！")
            })
        });
    }
</script>
</html>
