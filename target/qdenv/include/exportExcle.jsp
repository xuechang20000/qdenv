<%@ page contentType="text/html; charset=utf-8"%>
<html>
<!-- grid分页 -->
<div>
	<div id="exportExcel">
		<span class="separator"></span>
		<a class="mini-button" iconCls="icon-add" plain="true" id="add" onclick="exprotExcel(this)">导出</a>
	</div>
</div>
<div id="exprotIfreamDiv__">
	<iframe id="exportIFrame__" style="display:none;" src="<%=request.getContextPath()%>/pages/common/exportContent.jsp">
	</iframe>
</div>
</html>

<script type="text/javascript">
	var projectName='<%=request.getContextPath()%>';

    function exprotExcel(e){
        var grid = e.getParent().getParent();
        var params = grid.getLoadParams();
        var columns = grid.getBottomColumns();
        if(!params){
            return;
        }

        var columns = getColumns(columns);

        var header = mini.encode(columns);
        params.exp_url = grid.url.substr(projectName.length);
        params.exp_header = header;
        params.pageIndex = grid.pageIndex;
        params.pageSize = grid.pageSize;

        makeAndSubmitForm("commonExportGrid","<%=request.getContextPath()%>/work/export/exportGridToExcle",params)
    }

    function getColumns(columns) {
        columns = columns.clone();
        for (var i= columns.length-1; i>=0;i--) {
            var column = columns[i];
            if(!column.field||!column.visible){
                columns.removeAt(i);
            }else{
                var code = 0;
                if(column.renderer=='oncodeRender'){
                    code = 1;
                }
                var c = {header:column.header,field:column.field,width:column.width,code:code};
                columns[i] = c;
            }
        }
        return columns;
    }

    function makeForm(id,url,params)
    {
        // 创建一个 form
		var idocument=document.getElementById('exportIFrame__').contentWindow.document;
        var form1 = idocument.createElement("form");
        form1.id = id;
        form1.name = id;
        // 添加到 body 中
        idocument.body.appendChild(form1);
        for(o in params){
            // 创建一个输入
            var input = idocument.createElement("input");
            // 设置相应参数
            input.type = "text";
            input.name = o;
            input.value = params[o];
            // 将该输入框插入到 form 中
            form1.appendChild(input);
		}
        // form 的提交方式
        form1.method = "POST";
        // form 提交路径
        form1.action = url;
		return form1;
    }
    function  makeAndSubmitForm(id,url,params) {
        var form1=makeForm(id,url,params);
        // 对该 form 执行提交
        form1.submit();
        // 删除该 form
        document.getElementById('exportIFrame__').contentWindow.document.body.removeChild(form1);
    }
</script>