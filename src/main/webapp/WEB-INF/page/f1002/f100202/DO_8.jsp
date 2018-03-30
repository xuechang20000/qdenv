<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        .display_title_sub{font-size: 14px}
        .display_table table{width:100%;border-color: black ;border-collapse: collapse;font-size:12px;text-align: center}
        .disPhoto{clear:both;text-align: center; font-size: 14px;border: 1px solid #8dd7d6}
        .disPhoto span{width:45%;float: left;padding: 5px;margin-left:4px;margin-top:4px;border: 1px solid #8dd7d6}
    </style>
</head>
<body>
<c:if test="${dto.wbt009==null}">
<input type="button" id="check" value="审核" onClick="docheck()">&nbsp;&nbsp;
</c:if>
<c:if test="${dto.wbt011==null||dto.wbt011==''}">
<input type="button" id="sign" value="签发" onClick="dosign()">&nbsp;&nbsp;
</c:if>
<input type="button" id="preview" value="打印预览" onClick="dopreview()">&nbsp;&nbsp;
<input type="button" id="print" value="打印" onClick="doprint()">&nbsp;&nbsp;
<span style="color:#C00000;">
<c:if test="${dto.wbt009!=null}">
    审核日期： <fmt:formatDate value="${dto.wbt009}"  type="date"/> &nbsp;&nbsp;
</c:if>
<c:if test="${dto.wbt011!=null&&dto.wbt011!=''}">
    签发日期：${dto.wbt011}&nbsp;&nbsp;
</c:if>
<c:if test="${dto.wbt014!=null}">
    已经打印${dto.wbt014}次
</c:if>
</span>

<div id="display1">
    <div class="display_title">检  测  报  告<br/>
        TEST  REPORT
    </div>
    <div class="display_title_sub"><span style="float: left">青室环检字第${dto.wat002}-${dto.wbt001}号</span>
        <!--<span style="float: right">共 5 页 第 1 页   Page 1 of 5</span>-->
    </div>
    <div class="display_table">
        <table border="1" cellpadding="3" cellspacing="0">
            <tr>
                <td>委托单位<br/>Client</td>
                <td colspan="3">${dto.daw002}</td>
            </tr>
            <tr>
                <td>采样地点<br/>Sample Place</td>
                <td colspan="3">${dto.daw005}</td>
            </tr>
            <tr>
                <td>评价依据<br/>Evidence at assessment</td>
                <td colspan="3">${dto.bbz002}--${dto.bbz004}-</td>
            </tr>
            <tr>
                <td>检测项目<br/>Test Items</td>
                <td colspan="3">${dto.bcz002s}</td>
            </tr>
            <tr>
                <td>检测类别<br/>Test Type</td>
                <td colspan="3">${dto.wat003}</td>
            </tr>
            <tr>
                <td>采样日期<br/> Sample Date</td>
                <td colspan="3">${dto.wct014min}</td>
            </tr>
            <tr>
                <td>检测日期<br/>Test Date  </td>
                <td colspan="3">${dto.wbt005}~~${dto.wbt006}</td>
            </tr>
            <tr>
                <td>工程名称<br/>Project Name</td>
                <td></td>
                <td>建筑类型<br/>Building Type</td>
                <td></td>
            </tr>
            <tr>
                <td>样品数量<br/>Sample Quantity </td>
                <td>${dto.wbt007sum}</td>
                <td>采样点封闭时间<br/>Blocking Time of SP</td>
                <td>${dto.wct016max}</td>
            </tr>
            <tr>
                <td>检验结论<br/>Detection Conclusion</td>
                <td colspan="3">${dto.wbt012}</td>
            </tr>
            <tr>
                <td>备注<br/> Notes </td>
                <td colspan="3">${dto.aae013}</td>
            </tr>
            <tr>
                <td colspan="4">

                    <table>
                        <tr>
                            <td>审核：</td>
                            <td rowspan="2">
                                <c:if test="${dto.wbt008!=null}">
                                    <img src="${pageContext.request.contextPath}/admin/querySignature?userid=${dto.wbt008}"></img>
                                </c:if>
                            </td>
                            <td>签发：</td>
                            <td rowspan="2">
                                <c:if test="${dto.wbt010!=null}">
                                    <img src="${pageContext.request.contextPath}/admin/querySignature?userid=${dto.wbt010}"></img>
                                </c:if>
                            </td>
                            <td>签发日期：</td>
                            <td rowspan="2">${dto.wbt011}</td>
                        </tr>
                        <tr>
                            <td>Verified By:</td>
                            <td>Approved By:</td>
                            <td>Approved Date:</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<div id="display2">
    <div class="display_title">检  测  结  果<br/>
        TEST   EVENT
    </div>
    <div class="display_title_sub"><span style="float: left">青室环检字第${dto.wat002}-${dto.wbt001}号</span>
        <!--<span style="float: right">共 5 页 第 1 页   Page 1 of 5</span>-->
    </div>
    <div class="display_table">
        <table border="1" cellpadding="3" cellspacing="0">
            <c:forEach items="${dto.wt03DtoList}" var="wt03" varStatus="index">
                <tr height="23">
                    <td align="center">
                        检测点位<br/>
                        Test Place
                    </td>
                    <td colspan="4" align="center">
                            ${wt03.wct002 }
                    </td>
                </tr>
                <tr height="23">
                    <td align="center">
                        检测项目<br/>
                        Test Items
                    </td>
                    <td align="center">
                        单位<br/>
                        Unit
                    </td>
                    <td align="center">
                        标准值<br/>
                        Standard Value
                    </td>
                    <td align="center">
                        实测值<br/>
                        Actual Value
                    </td>
                    <td align="center">
                        单项判定<br/>
                        Decision
                    </td>
                </tr>
                <c:forEach var="wt04" items="${wt03.wt04DtoList}" varStatus="index">
                    <tr height="23">
                        <td align="center">
                                ${wt04.bcz002}
                        </td>
                        <td align="center">
                                ${wt04.bcz006}
                        </td>
                        <td align="center">
                                ${wt04.bcz004}~  ${wt04.bcz005}
                        </td>
                        <td align="center">
                                ${wt04.wxt002}
                        </td>
                        <td align="center">
                                <c:if test="${wt04.wxt003=='1'}">
                                    合格
                                </c:if>
                            <c:if test="${wt04.wxt003!='1'}">
                                不合格
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
</div>
<div id="display3">
    <div class="display_title">现  场  说  明<br/>
        THE SCENE INFORMATHION
    </div>
    <div class="display_title_sub"><span style="float: left">青室环检字第${dto.wat002}-${dto.wbt001}号</span>
        <!--<span style="float: right">共 5 页 第 1 页   Page 1 of 5</span>-->
    </div>
    <div class="disPhoto">
        <c:forEach items="${dto.wt03DtoList}" var="wt03" varStatus="index">
        <span>
            <img src="${pageContext.request.contextPath}/work/f100201/downLoadAttachment?wtp001=${wt03.wtp001}" width="200" height="200" alt=""/>
            <br>
            ${wt03.wct002}--示意图<br>
            环境条件：温度：${wt03.wct003}℃，相对湿度：${wt03.wct004}%，大气压力：${wt03.wct004}kPa
        </span>
        </c:forEach>
    </div>
</div>
<div id="display4" style="clear: both">
    <div class="display_title">检  测  说  明<br/>
        TEST DESCRIPTION
    </div>
    <div class="display_title_sub"><span style="float: left">青室环检字第${dto.wat002}-${dto.wbt001}号</span>
        <!--<span style="float: right">共 5 页 第 1 页   Page 1 of 5</span>-->
    </div>
    <div class="disPhoto" style="text-align: left">
        样品状态：<br/>
        	xxx：xxxxxxx<br/>
        试验说明：<br/>
        	实验室环境条件：温度：18.1℃，相对湿度：55%，大气压力：101.5kPa<br/>
        	xxx检验方法:xxx<br/>
        	xxx检验方法:xxx<br/>
        	xxx检验方法:xxx<br/>

    </div>
</div>
</body>
<script language="javascript" type="text/javascript">
    var wbt001=${dto.wbt001};
    var LODOP; //声明为全局变量
    function init() {
        LODOP=getLodop();
        LODOP.SET_PRINT_STYLEA(0,"Horient",2);//
        LODOP.SET_PRINT_PAGESIZE(1,"21cm","29.7cm","");
        var bodyStyle='<style>'+document.getElementById("bodyStyle").innerHTML+'</style>';
        var display1Content=document.getElementById("display1").innerHTML;
        var display2Content=document.getElementById("display2").innerHTML;
        var display3Content=document.getElementById("display3").innerHTML;
        var display4Content=document.getElementById("display4").innerHTML;
        LODOP.ADD_PRINT_HTM("10mm","10mm","190mm","277mm",bodyStyle+'<body>'+display1Content+'</body>');
        LODOP.NewPage();
        LODOP.ADD_PRINT_HTM("10mm","10mm","190mm","277mm",bodyStyle+'<body>'+display2Content+'</body>');
        LODOP.ADD_PRINT_HTM("21mm","173mm","190mm","277mm","<font style='font-size:12px' format='ChineseNum'><span tdata='pageNO'>第##页</span>/<span tdata='pageCount'>共##页</span></font>");
        LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
        LODOP.NewPage();
        LODOP.ADD_PRINT_HTM("10mm","10mm","190mm","277mm",bodyStyle+'<body>'+display3Content+'</body>');
        LODOP.NewPage();
        LODOP.ADD_PRINT_HTM("10mm","10mm","190mm","277mm",bodyStyle+'<body>'+display4Content+'</body>');

    }
    function dopreview() {
        init();
        LODOP.PREVIEW();
    };
    function doprint() {
        init();
       var isSuccess=LODOP.PRINT();
       if(isSuccess){
           var url="${pageContext.request.contextPath}/work/f100201/updateWt02"
               Web.util.request(url,"post",{wbt001:wbt001,flag:"1"},function () {
                   Web.util.showTips("已成功打印");
                   $("#print").hide();
               })
       };
    }
    function docheck() {
     var url="${pageContext.request.contextPath}/work/f100201/updateWt02"
        Web.util.confirm("是否确定审核通过？",function () {
            Web.util.request(url,"post",{wbt001:wbt001,flag:"2"},function () {
                Web.util.showTips("已审核通过");
                location.reload();
            })
        })

    }
    function dosign() {
        Web.util.openMiniWindow("签发","${pageContext.request.contextPath}/work/f100202/loadSign?wbt001="+wbt001,500,300,function () {
            location.reload();
        })
    }
</script>
</html>
