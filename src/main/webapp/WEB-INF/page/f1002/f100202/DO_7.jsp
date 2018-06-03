<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>检测数据</title>

    <%@include file="/include/head.jsp"%>
    <%@include file="/include/head_umeditor.jsp"%>
    <style type="text/css">

        #collect_list table{width: 95%; text-align: center;margin-left: 10px}
        #collect_list table textarea{width:100%}
        #collect_list2 table{width: 95%; text-align: left;margin-left: 10px;margin-top: 3px;border-top: 0px}
        #collect_list2 table textarea{width:100%}
        #collect_list3 table{width: 95%; text-align: left;margin-left: 10px;margin-top: 3px;border-top: 0px}
        #collect_list3 table textarea{width:100%}
        table.dataintable {
            margin-top:15px;
            border-collapse:collapse;
            border:1px solid #aaa;
            width:100%;
        }

        table.dataintable th {
            vertical-align:baseline;
            padding:5px 15px 5px 6px;
            background-color:#1296db;
            border:1px solid #3F3F3F;
            text-align:left;
            color:#fff;
        }

        table.dataintable td {
            vertical-align:text-top;
            padding:6px 15px 6px 6px;
            border:1px solid #aaa;
            vertical-align: middle;
        }

        table.dataintable tr:nth-child(odd) {
            background-color:#F5F5F5;
        }

        table.dataintable tr:nth-child(even) {
            background-color:#fff;
        }
    </style>
</head>
<body>
<div id="collect_list">
    <table class="dataintable" id="data1">
     <tr>
         <td>编号</td>
         <td colspan="2"><span class="h_content" id="wat002">${dto.wat002}</span></td>
         <td>委托单位</td>
         <td colspan="3"><span class="h_content" id="daw002">${dto.daw002}</span></td>
     </tr>
    <tr>
        <td>评价标准</td>
        <td colspan="2"><span class="h_content" id="">${dto.bbz002}(${dto.bbz004})</span></td>
        <td>检测地址</td>
        <td colspan="3"><span class="h_content" id="daw005">${dto.daw005}</span></td>
    </tr>
    <tr>
        <td>检测日期</td>
        <td colspan="2"><span class="h_content" id="wbt0056">${dto.wbt005}~~${dto.wbt006}</span></td>
        <td>检测类别</td>
        <td colspan="3"><span class="h_content" id="wat003">${dto.wat003}</span></td>
    </tr>
    <!--<tr>
        <td>大气压</td>
        <td><span class="h_content" id=""></span></td>
        <td>温度</td>
        <td><span class="h_content" id=""></span></td>
        <td>湿度</td>
        <td colspan="2"><span class="h_content" id=""></span></td>
    </tr>
    <tr>
        <td>封闭时间</td>
        <td><span class="h_content" id=""></span></td>
        <td>朝向</td>
        <td><span class="h_content" id=""></span></td>
        <td>通风状态</td>
        <td colspan="2"><span class="h_content" id=""></span></td>
    </tr>
    <tr>
        <td>装修日期</td>
        <td><span class="h_content" id=""></span></td>
        <td>入住日期</td>
        <td><span class="h_content" id=""></span></td>
        <td>样品数量</td>
        <td colspan="2"><span class="h_content" id=""></span></td>
    </tr>
-->
    <tr>
        <th>采样点</th>
    <th >检测项目</th>
    <th>检测值</th>
    <th>标准值</th>
    <th>是否合格</th>
    <th>检测仪器</th>
    <th>检测仪器编号</th>

    </tr>
</table>
<div id="collect_list3">
    <table class="dataintable" id="data2">
    </table>
</div>
<div id="collect_list2">
    <table class="dataintable">
        <!--<tr>
            <td colspan="1">检测点环境数据</td>
            <td colspan="6"><textarea name="wct011" rows="" cols=""></textarea></td>
        </tr>
        <tr>
            <td colspan="1">检测数量<br>(样品数量)</td>
            <td colspan="3"><textarea name="wct011" rows="" cols=""></textarea></td>
            <td colspan="1">封闭时间<br>(多采样点设置)</td>
            <td colspan="2"><textarea name="wct012" rows="" cols=""></textarea></td>
        </tr>-->
        <tr>
            <td colspan="1">实验室环境条件</td>
            <td colspan="3"><textarea name="wct011" rows="" cols=""></textarea></td>
            <td colspan="1">实验室环境备注</td>
            <td colspan="2"><textarea name="wct012" rows="" cols=""></textarea></td>
        </tr>
        <tr>
            <td>检测日期</td>
            <td colspan="3"> <input id="wbt005" name="wbt005" class="mini-datepicker" value="${dto.wbt005}" format="yyyy-MM-dd" />~
                <input id="wbt006" name="wbt006" class="mini-datepicker" value="${dto.wbt006}" format="yyyy-MM-dd" /></td>
           <!-- <td>签发日期</td>
            <td colspan="2"><input id="wbt011" name="wbt011" class="mini-datepicker" value="${dto.wbt011}" /></td>-->
        </tr>
        <tr>
            <td>报告备注</td>
            <td colspan="6"> <input id="aae013" name="aae013" class="mini-textbox" value="${dto.aae013}" style="width: 100%;" /></td>
        </tr>
        <tr>
            <td colspan="1">检测结论</td>
            <td colspan="6"><script type="text/plain" id="myEditor" style="width:100%;height:200px;"></script></td>
        </tr>
    </table>
</div>
</div>
<div style="margin-top: 10px;padding: 0;text-align: center">
<a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
&nbsp;&nbsp;
<a class="mini-button" href="javascript:doCheck();" id="doCheck"  iconCls="icon-filter" >判定</a>
</div>
<script id="formTemplate" type="text/x-jquery-tmpl">

     {{each(i,wt04) wt04DtoList}}

    <tr>
    {{if i==0}}
        {{ else }}
         <td rowspan="{{= wt04size}}">采样点ID:{{= wct001}}<br>{{= wct002}}</td>
        {{/if}}
        <td>{{= bcz002}}{{= j}} <input type="hidden" value="{{= wxt001}}" name="wxt001"/></td>
        <td align="left"><input name="wxt002" type="text" style="width:80px" value="{{= wxt002 }}" />{{= bcz006}}
                    <input name="wct001" type="hidden" value={{= wct001}}  />
                    <input name="bcz003" type="hidden" value={{= bcz003}}  />
                    <input name="bcz004" type="hidden" value={{= bcz004}}  />
                    <input name="bcz005" type="hidden" value={{= bcz005}}   /></td>
         <td>{{if bcz003=='5'}}
                    {{= bcz004}}~{{= bcz005}}{{= bcz006}}
                    {{else}}
                     {{= bcz004}}
                    {{/if}}</td>
        <td><input name="wxt003"  type="checkbox" {{if typeof wxt003!='undefined'&&(wxt003=='1')}} checked=true {{/if}} /></td>
       <td>{{= bmz002}}</td>
        <td>
            <select name="wxt012" >
             {{each(k,ml) mlist}}
                <option value="{{= ml}}"  {{if typeof wxt012!='undefined'&& ml==wxt012}} selected ="selected"  {{/if}}>{{= ml}}</option>
             {{/each}}
            <select>
        </td>
    </tr>

      {{/each}}
</script>
<script id="formTemplate2" type="text/x-jquery-tmpl">

    <tr>
        <td rowspan="3" colspan="1">采样点ID:{{= wct001}}<br>{{= wct002}}</td>
        <td>温度</td>
        <td>{{= wct003}} ℃</td>
        <td rowspan="3" colspan="4">
    <button type="button" class="select_photo" onclick="selectPhoto({{= wct001}})">选择照片</button>
    <img src="${pageContext.request.contextPath}/work/f100201/downLoadAttachment?wtp001={{= wtp001}}"  width="200" alt=""/>
    </td>
    </tr>
    <tr>
        <td>湿度</td>
        <td>{{= wct004}} φ %</td>
    </tr>
        <tr>
        <td>大气压力</td>
        <td>{{= wct005}} Kpa</td>
        </tr>

</script>
</body>
<script type="text/javascript">

    mini.parse();
    var wat001,flag=0;
    var wbt001=${param.wbt001}
        loadWt02();
        //loadWt();
    var um = UM.getEditor('myEditor');
    function bindKeyDown() {
        $(function () {
            $('input:text:first').focus(); //获取第一个焦点
            var $inp = $('input:text'); //定义全部焦点
            $inp.bind('keydown', function (e) {// 绑定事件
                var key = e.which;//定义按键
                if (key == 13) {//回车事件
                    e.preventDefault();
                    var nxtIdx = $inp.index(this) + 1;
                    $(":input:text:eq(" + nxtIdx + ")").focus();
                    /*if(nxtIdx==3){
                        $('textarea').focus();
                    }*/
                }
            });
        });
    }

    function loadWt() {
        var url="${pageContext.request.contextPath}/work/f100201/queryWtList";
            Web.util.request(url,'post',{wat001:wat001},function (data) {
                $("#wat002").html(data[0].wat002);
            })
    }
    function loadWt02() {

        var url="${pageContext.request.contextPath}/work/f100201/queryWt02"
        Web.util.request(url,'post',{wbt001:wbt001},function (data) {
            var i=0;
            var renderData= new Array();

            for(var d;d=data[i++];){
                $("#collect_list").find("textarea[name='wct011']").val(d.wct011)
                $("#collect_list").find("textarea[name='wct012']").val(d.wct012)

                var j=0;
                for (var c;c=d.wt03DtoList[j++];){
                    c.wt04size=c.wt04DtoList.length;
                    var k=0;
                    for(var m;m=c.wt04DtoList[k++]; ){
                        if(m.bmz004){
                           m.mlist=m.bmz004.split(",");
                        }
                    }
                    renderData.push(c);
                }
            }
            if(flag==0){
                $("#formTemplate").tmpl(renderData).appendTo($("#data1"));
                $("#formTemplate2").tmpl(renderData).appendTo($("#data2"));
                flag=1;
            }else {
                $("#data2").html("");
                $("#formTemplate2").tmpl(renderData).appendTo($("#data2"));
            };


            UM.getEditor('myEditor').setContent(data[0].wbt012);
            bindKeyDown();
        });

    }
    function doSubmit() {
        /**是否全部录入**/
        if(!doValidate()){
            Web.util.showTipsWanring("检测值不允许有空值！")
            return;
        }
        var wt03Array=new Array()
        $("#collect_list .dataintable tr").each(function(i){
            var wt03={}
            var wct001=$(this).find("input[name='wct001']").val();
            wt03.wct001=wct001;
            wt03.wct011=""
            wt03.wt04DtoList=new Array();
                var wt04={}
                var wxt001=$(this).find("input[name='wxt001']").val();
                if(!wxt001) return true;
                var wxt002=$(this).find("input[name='wxt002']").val();
                var wxt012=$(this).find("select[name='wxt012']").val();
                var wxt003=$(this).find("input[name='wxt003']").prop("checked");
                wt04.wxt001=wxt001;
                wt04.wxt002=wxt002;
                wt04.wxt012=wxt012;
                if(wxt003==true) wxt003='1'; else wxt003='0';
                wt04.wxt003=wxt003;
                wt03.wt04DtoList.push(wt04)
            wt03Array.push(wt03);
        });
        //alert(JSON.stringify(wt03Array));
        var wct011=$("#collect_list").find("textarea[name='wct011']").val();
        var wct012=$("#collect_list").find("textarea[name='wct012']").val();
        var wbt005=mini.get("wbt005").getFormValue();
        var wbt006=mini.get("wbt006").getFormValue();
        //var wbt011=mini.get("wbt011").getFormValue();
        var aae013=mini.get("aae013").getValue();
        var wbt012=UM.getEditor('myEditor').getContent();
        var wt02=[{wbt001:wbt001,wct011:wct011,wct012:wct012,wbt005:wbt005,wbt006:wbt006,aae013:aae013,wbt012:wbt012}]
        var url="${pageContext.request.contextPath}/work/f100201/saveWt02"
        Web.util.request(url,"post",{json1:JSON.stringify(wt02)},function () {
            url="${pageContext.request.contextPath}/work/f100201/updateWt03"
            Web.util.request(url,"post",{wt03s:JSON.stringify(wt03Array)},function () {
                Web.util.showTips("保存成功")
                mini.get('doSubmit').disable()
            })
        })

    }

    function doValidate() {
        var isAllset=true;
        $("#collect_list .dataintable tr").each(function (i) {
            var wxt001=$(this).find("input[name='wxt001']").val();
            if(!wxt001) return true;
            var wxt002=$(this).find("input[name='wxt002']").val();
            if(!wxt002){
                isAllset=false;
                return false;
            }
        });
        return isAllset;
    }
    function doCheck() {
        $("#collect_list .dataintable tr").each(function () {
            var bcz003=$(this).find("input[name='bcz003']").val();
            var bcz004=$(this).find("input[name='bcz004']").val();
            var bcz005=$(this).find("input[name='bcz005']").val();
            var wxt002=$(this).find("input[name='wxt002']").val();
            bcz004=parseFloat(bcz004);
            bcz005=bcz005==''?0:parseFloat(bcz005);
            wxt002=parseFloat(wxt002);
            var wxt003=$(this).find("input[name='wxt003']");
            var isLegle=false;
            switch (bcz003){
                case '1':
                    if( wxt002>bcz004) isLegle= true; else isLegle= false;
                    break;
                case '2':
                    if( wxt002<bcz004) isLegle= true; else isLegle= false;
                    break;
                case '3':
                    if( wxt002>=bcz004) isLegle= true; else isLegle= false;
                    break;
                case '4':
                    if( wxt002<=bcz004) isLegle= true; else isLegle= false;
                    break;
                case '5':
                    if( wxt002>=bcz004 && wxt002 <= bcz005) isLegle= true; else isLegle= false;
                    break;
                case '6':
                    if( wxt002=='0') isLegle= true; else isLegle= false;
                    break;
                case '7':
                    if( wxt002=='0') isLegle= true; else isLegle= false;
                    break;
                case '8':
                    if(wxt002=='0') isLegle= true; else isLegle= false;
                    break;
                default:
                    isLegle= true;
            }
            wxt003.prop("checked", isLegle);
        });
    }
    function selectPhoto(v) {
        var url='${pageContext.request.contextPath}/work/f100202/loadPhotos?wct001='+v
       Web.util.openMiniWindow("选择照片",url,700,500,function () {
           loadWt02()
       })
    }
</script>
</html>
