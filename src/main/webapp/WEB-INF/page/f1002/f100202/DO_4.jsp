<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        .collect{width:100%;padding:3px;margin-top:6px;text-align: center;background-color: #efefef;border-color: black ;border-collapse: collapse;}
        .collect_list table{padding: 0px;margin-left: 20px;}
        .collect .collect_jc{width:100%}
        .collect .collect_jc input{width:100px}
        .collect .collect_jc td{padding: 4px; border-bottom: 1px solid #9c9c9c;}
        .collect_env{margin-left: 10px; width:90%}
        .collect_env td{padding: 0px;text-align: center}
    </style>
</head>
<body>
<h4 id="wat002"></h4>
<div id="collect_list">
</div>
<br/>
<a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a>
&nbsp;&nbsp;
<a class="mini-button" href="javascript:doCheck();" id="doCheck"  iconCls="icon-filter" >判定</a>

<script id="formTemplate" type="text/x-jquery-tmpl">

<table class="collect">
    <tr>
      <td class="collect_name">采样点ID:{{= wct001}}<br>{{= wct002}}
      <input type="hidden" value="{{= wct001}}" name="wct001"/></td>
        <td>
            <table class="collect_jc" >

                 {{each(j,wt04) wt04DtoList}}
                <tr>
                    <td>{{= bcz002}} <input type="hidden" value="{{= wxt001}}" name="wxt001"/></td>
                    <td><input name="wxt002" type="text" value="{{= wxt002 }}" />
                    <input name="bcz003" type="hidden" value={{= bcz003}}  />
                    <input name="bcz004" type="hidden" value={{= bcz004}}  />
                    <input name="bcz005" type="hidden" value={{= bcz005}}   />
                    </td>
                    <td>{{if bcz003=='5'}}
                    {{= bcz004}}~{{= bcz005}}{{= bcz006}}
                    {{else}}
                     {{= bcz004}}
                    {{/if}}
                    </td>
                    <td><input name="wxt003"  type="checkbox" {{if typeof wxt003!='undefined'&&(wxt003=='1')}} checked=true {{/if}} /></td>
                </tr>
                {{/each}}
            </table>
        </td>
        <td>
            <table class="collect_env">
                <tr>
                    <td>实验室环境条件：<br/><textarea name="wct011" rows="" cols="">{{= wct011}}</textarea></td>
                    <td>实验室环境备注：<br/><textarea name="wct012" rows="" cols="">{{= wct012}}</textarea></td>
                </tr>
            </table>
        </td>

    </tr>
</table>
</script>
</body>
<script type="text/javascript">

    mini.parse();

    var wat001=${param.wat001}
        loadWt();
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
        var url="${pageContext.request.contextPath}/work/f100201/queryWt02"
        Web.util.request(url,'post',{wat001:wat001},function (data) {
            var i=0;
            var renderData= new Array();
            for(var d;d=data[i++];){
                var j=0;
                for (var c;c=d.wt03DtoList[j++];){
                    renderData.push(c);
                }
            }
            $("#formTemplate").tmpl(renderData).appendTo(document.getElementById("collect_list"));
            bindKeyDown();
        });

    }
    function doSubmit() {
        var wt03Array=new Array()
        $(".collect").each(function(i){
            var wt03={}
            var wct001=$(this).find("input[name='wct001']").val();
            var wct011=$(this).find("textarea[name='wct011']").val();
            var wct012=$(this).find("textarea[name='wct012']").val();
            wt03.wct001=wct001;
            wt03.wct011=wct011;
            wt03.wct012=wct012;
            wt03.wt04DtoList=new Array();
            $(this).find(".collect_jc tr").each(function () {
                var wt04={}
                var wxt001=$(this).find("input[name='wxt001']").val();
                var wxt002=$(this).find("input[name='wxt002']").val();

                var wxt003=$(this).find("input[name='wxt003']").prop("checked");
                wt04.wxt001=wxt001;
                wt04.wxt002=wxt002;
                if(wxt003==true) wxt003='1'; else wxt003='0';
                wt04.wxt003=wxt003;
                wt03.wt04DtoList.push(wt04)
            })
            wt03Array.push(wt03);
        });

        var url="${pageContext.request.contextPath}/work/f100201/updateWt03"
        Web.util.request(url,"post",{wt03s:JSON.stringify(wt03Array)},function () {
            mini.get('doSubmit').disable()
        })
    }
    function doCheck() {
        $(".collect_jc tr").each(function () {
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
</script>
</html>
