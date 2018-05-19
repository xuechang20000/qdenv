<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/include/zyupload/zyupload-1.0.0.min.css " type="text/css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/include/zyupload/zyupload.basic-1.0.0.min.js"></script>
    <style type="text/css">
        #form1 table td{padding: 3px}
        .mini-panel-border{border: none}
        #zyupload{margin-bottom: 0px;padding-bottom: 0px}
        #displayPhoto{clear:both}
        #displayPhoto img{padding: 4px}
    </style>
</head>
<body>
<div class="mini-tabs"  id="tabs1" activeIndex="0" style="width:100%;height:100%;" plain='false'>
<div title="环境数据">
    <div id="form1" >
        <input name="wat001" class="mini-hidden"  value="${param.wat001}" />
        <table>

            <tr>
                <td align="right">
                    <label for="wct002">采样点名称：</label>
                </td>
                <td align="left">
                    <input id="wct001"  name="wct001"  visible="false" class="mini-textbox"  />
                    <input id="wct002"  name="wct002" style="width:200px" class="mini-textbox"  />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wbt007">样品数量：</label>
                </td>
                <td align="left">
                    <input id="wbt007"  name="wbt007" style="width:100px" class="mini-textbox"  vtype="int"  />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct014">采样时间：</label>
                </td>
                <td align="left">
                    <input id="wct014" name="wct014" class="mini-datepicker" style="width: 200px;" required="true"
                           format="yyyy-MM-dd H:mm" timeFormat="H:mm" showTime="true" showOkButton="true" />
                </td>
            </tr>

            <tr>
                <td align="right">
                    <label for="wct003">温度：</label>
                </td>
                <td align="left">
                    <input id="wct003"  name="wct003" style="width:200px" class="mini-textbox" required="true" vtype="float"  />℃
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct004">相对湿度：</label>
                </td>
                <td align="left">
                    <input id="wct004"  name="wct004"  style="width:200px" class="mini-textbox" required="true"  vtype="float" />φ %
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct005">大气压力：</label>
                </td>
                <td align="left">
                    <input id="wct005"  name="wct005" style="width:200px" class="mini-textbox" required="true" vtype="float" />Kpa
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct006">房屋朝向：</label>
                </td>
                <td align="left">
                    <input id="wct006" class="mini-combobox" style="width: 200px;"  textField="dictName" valueField="dictVal"
                           url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WCT006"    allowInput="true" nullItemText="请选择..."/>
                </td>
            </tr>
            <td align="right">
                <label for="wct007">通风情况：</label>
            </td>
            <td>
                <input id="wct007" class="mini-combobox" style="width: 200px;"  textField="dictName" valueField="dictVal"
                       url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WCT007"    allowInput="true" nullItemText="请选择..."/>
            </td>
            <tr>
                <td align="right">
                    <label for="wct008">装修时间：</label>
                </td>
                <td align="left">
                    <input id="wct008"  name="wct008" class="mini-datepicker" style="width: 200px;"
                           format="yyyy-MM-dd"  showOkButton="true"  />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct009">入住时间：</label>
                </td>
                <td align="left">
                    <input id="wct009"  name="wct009" class="mini-datepicker" style="width: 200px;"
                           format="yyyy-MM-dd"  showOkButton="true"  />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct016">封闭时间：</label>
                </td>
                <td align="left">
                    <input id="wct016"  name="wct016" style="width:200px" class="mini-textbox" required="true" vtype="int" />(小时)
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct010">其它环境条件：</label>
                </td>
                <td>
                    <input id="wct010" name="wct010" style="width: 300px;"  class="mini-textarea" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label for="wct015">配套设施：</label>
                </td>
                <td>
                    <div id="wct015" class="mini-checkboxlist" repeatItems="6" repeatLayout="table"
                         textField="dictName" valueField="dictVal"
                         url="<%=request.getContextPath()%>/admin/queryRenderedAppDictDetails?dictCode=WCT015" >
                    </div>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="mini-button" href="javascript:doSubmit();" id="doSubmit"  iconCls="icon-save" >保存</a></td>
            </tr>
        </table>
    </div>
</div>
<div title="采样信息">
    <div id="datagrid2" class="mini-datagrid" style="width:63%;height:100%; float: left" allowResize="true" pageSize="100" title="样品"
         idField="wst001" pagerButtons="buttons" url="${pageContext.request.contextPath}/work/f100202/queryWt10Page?wct001=${param.wct001}"
         multiSelect="true" allowResize="true">
        <div property="columns">
            <div field="wst001"  headerAlign="center" visible="false">样品ID</div>
            <div field="wct001"  headerAlign="center" visible="false">采样点ID</div>
            <div field="wst002" type="comboboxcolumn" width="20" headerAlign="center" >容器类型
                <input property="editor" class="mini-combobox" style="width:100%;" textField="dictName" valueField="dictVal"
                       popupWidth="120"  url="/qdenv/admin/queryRenderedAppDictDetails?dictCode=WST002" /></div>
            <div field="wst003" width="20" headerAlign="center" >样品编号
                <input property="editor" class="mini-textbox" style="width:100%;" /></div>
            <div field="wst004" width="15" dataType="date" dateFormat="HH:mm" headerAlign="center" >采样时间<br>起
                <input property="editor" class="mini-datepicker" style="width: 200px;"
                       format="H:mm" timeFormat="H:mm" showTime="true" minWidth="200" valueType="string"
                       showOkButton="true" showTodayButton="false" showClearButton="false"/></div>
           <div field="wst005" width="15" dataType="date" dateFormat="HH:mm" headerAlign="center" >采样时间<br>止
            <input property="editor" class="mini-datepicker" style="width: 200px;"
                   format="H:mm" timeFormat="H:mm" showTime="true" minWidth="200" valueType="string"
                   showOkButton="true" showTodayButton="false" showClearButton="false" /></div>
            <div field="wst006" type="comboboxcolumn" width="40" headerAlign="center" >采样设备
                <input property="editor" class="mini-combobox" textField="bmz002" valueField="bmz001"
                       popupWidth="220"  url="<%=request.getContextPath()%>/work/f100604/queryBz06List?aae016=1&bmz003=1" /></div>
            <div field="wst007"  width="40" headerAlign="center" >设备编号</div>
        </div>
    </div>
    <div id="datagrid" class="mini-datagrid" style="width:35%;height:100%; float: left;margin-left: 8px" allowResize="true" pageSize="100" title="检测项目"
         idField="wxt001"  allowCellEdit="true" allowCellSelect="true" showGroupSummary="true" showSummaryRow="true"
         editNextOnEnterKey="true"  editNextRowCell="true" navEditMode="true">
        <div property="columns">
            <div field="wxt001"  headerAlign="center" visible="false">检测项目ID</div>
            <div field="wct001"  headerAlign="center" visible="false">采样点ID</div>
            <div field="bcz002" width="40" headerAlign="center" >检测项目</div>
            <div field="wxt009" width="30" headerAlign="center" >样品编号
               <!-- <input property="editor" class="mini-textbox" style="width:100%;" />-->
            </div>
            <div field="wxt002" width="15" headerAlign="center" >检测值
                <input property="editor" class="mini-textbox" style="width:100%;" /></div>
            <div field="bcz006" width="10" headerAlign="center" >单位</div>
        </div>
    </div>
</div>
    <div title="照片上传">
        <div id="zyupload" class="zyupload"></div>
        <div id="displayPhoto" >

        </div>
    </div>
</div>
<div id="buttons">
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-add" plain="true" onclick="addWt10()"></a>
        <span class="separator"></span>
        <a class="mini-button" iconCls="icon-remove" plain="true" onclick="deleteWt10()"></a>
</div>
</body>
<script type="text/javascript">
    mini.parse();
    var wct001=${param.wct001};
    loadWt03();
    loadPhotos();
    var grid= mini.get("datagrid");
    var grid2= mini.get("datagrid2");
    grid2.reload();
    function loadWt03() {
        var url ='${pageContext.request.contextPath}/work/f100201/queryWt03'
        Web.util.formLoad("form1",url,"post",{wct001:wct001},function (data) {
            mini.get("wct015").setValue(data.wct015);
            mini.get("wct006").setValue(data.wct006);
            mini.get("wct007").setValue(data.wct007);
            var wt04list=data.wt04DtoList,i=0;
            grid.clearRows();
            for(var wt04;wt04=wt04list[i++];){
                var row={wxt001:wt04.wxt001,wct001:wt04.wct001,bcz002:wt04.bcz002,bcz006:wt04.bcz006,
                    wxt009:wt04.wxt009,wxt008:wt04.wxt008,wxt010:wt04.wxt010,wxt007:wt04.wxt007,wxt002:wt04.wxt002}
                grid.addRow(row);
            }
        });
    }
    function loadPhotos() {
        var url='${pageContext.request.contextPath}/work/f100201/queryWp01List';
        Web.util.request(url,"post",{wtp002:'COLL',wtp003:wct001},function (data) {
            var img,i=0;
            $("#displayPhoto").html("");
            for(var d;d=data[i++];){
                img='<img src="${pageContext.request.contextPath}/work/f100201/downLoadAttachment?wtp001='+d.wtp001+'" width="200" alt=""/>'
                $(img).appendTo($("#displayPhoto"))
            }
        })
        
    }
    function addWt10() {
        var url="${pageContext.request.contextPath}/work/f100202/loadWt10add?wct001="+wct001;
        Web.util.openMiniWindow("添加样品",url,1000,350,function () {
            grid2.reload();
            loadWt03();
        })
    }
    function deleteWt10() {
        var wst001=grid2.getSelected().wst001;
        var wst003=grid2.getSelected().wst003;
        var url="${pageContext.request.contextPath}/work/f100202/deleteWt10";
        Web.util.request(url,"post",{wct001:wct001,wst001:wst001,wst003:wst003},function () {
            grid2.reload();
            loadWt03();
        })
    }
  function doSubmit() {
      var form = new mini.Form("#form1");
      form.validate();
      if (form.isValid() == false) {
          Web.util.showTipsWanring('填写有误，请修正！');
          return;
      }
      Web.util.confirm("确定要保存？",function (action) {
          var data = form.getData(true);
          data.wct015=mini.get("wct015").getValue();
          data.wct006=mini.get("wct006").getValue();
          data.wct007=mini.get("wct007").getValue();
          //data.wct018=mini.get("wct018").getFormValue();
          data.wt04DtoList = grid.findRows(function(row){return true;});
          var wt03s=new Array();
          wt03s.push(data);
          var url="${pageContext.request.contextPath}/work/f100201/updateWt03";
          Web.util.request(url,"post",{wt03s:JSON.stringify(wt03s)},function (data) {
              //mini.get("doSubmit").disable();
              loadWt03();
              Web.util.showTips("保存成功！")
          })
      });
  }

    $(function(){
        // 初始化插件
        $("#zyupload").zyUpload({
            width            :   "650px",                 // 宽度
            height           :   "200px",                 // 宽度
            itemWidth        :   "140px",                 // 文件项的宽度
            itemHeight       :   "115px",                 // 文件项的高度
            url              :   "<%=request.getContextPath()%>/work/f100201/uploadWt03Photo?wct001="+wct001,              // 上传文件的路径
            fileType         :   ["jpg","png","doc","docx","xls","xlsx","rar","zip"],// 上传文件的类型
            fileSize         :   51200000,                // 上传文件的大小
            multiple         :   true,                    // 是否可以多个文件上传
            dragDrop         :   false,                   // 是否可以拖动上传文件
            tailor           :   false,                   // 是否可以裁剪图片
            del              :   true,                    // 是否可以删除文件
            finishDel        :   false,  				  // 是否在上传文件完成后删除预览
            /* 外部获得的回调接口 */
            onSelect: function(selectFiles, allFiles){    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
                console.info("当前选择了以下文件：");
                console.info(selectFiles);
            },
            onDelete: function(file, files){              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
                console.info("当前删除了此文件：");
                console.info(file.name);
            },
            onSuccess: function(file, response){          // 文件上传成功的回调方法
                console.info("此文件上传成功：");
                console.info(file.name);
                console.info("此文件上传到服务器地址：");
                console.info(response);
                loadPhotos();
                //$("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");
            },
            onFailure: function(file, response){          // 文件上传失败的回调方法
                console.info("此文件上传失败：");
                console.info(file.name);
            },
            onComplete: function(response){           	  // 上传完成的回调方法
                console.info("文件上传完成");
                console.info(response);
            }
        });

    });
</script>
</html>
