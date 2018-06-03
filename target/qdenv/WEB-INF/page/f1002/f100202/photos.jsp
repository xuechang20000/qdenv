<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@include file="/include/head.jsp"%>
    <style type="text/css">
        #displayPhoto{clear:both}
        #displayPhoto img{padding: 4px}
        #displayPhoto img:hover{padding: 4px;border: 2px solid #9c9c9c}
        #displayPhoto img:visited {padding: 4px;border: 2px solid #9c9c9c}
    </style>
</head>
<body>

        <div id="displayPhoto" >

        </div>

</body>
<script type="text/javascript">
    mini.parse();
    var wct001=${param.wct001};
    loadPhotos()
    function loadPhotos() {
        var url='${pageContext.request.contextPath}/work/f100201/queryWp01List';
        Web.util.request(url,"post",{wtp002:'COLL',wtp003:wct001},function (data) {
            var img,i=0;
            $("#displayPhoto").html("");
            if(data.length==0)  $("#displayPhoto").html("<h4>没有上传照片！</h4>");
            for(var d;d=data[i++];){
                img='<img src="${pageContext.request.contextPath}/work/f100201/downLoadAttachment?wtp001='+d.wtp001+'" onclick="onSelect('+d.wtp001+')" width="200" alt=""/>'
                $(img).data("wtp001",d.wtp001).appendTo($("#displayPhoto"))
            }
        })
    }

function onSelect(v) {

    var data = {};
    data.wct001=wct001;
    data.wtp001=v
    var wt03s=new Array();
    wt03s.push(data);
    var url="${pageContext.request.contextPath}/work/f100201/updateWt03";
    Web.util.request(url,"post",{wt03s:JSON.stringify(wt03s)},function (data) {
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow("cancle");
    })

}
</script>
</html>
