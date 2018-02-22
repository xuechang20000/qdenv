mini.namespace("Web.util");

var timeout__ = 1000;

Web.util.request = function(url,method,params,successFunction,failureFunction,waitMsg){
	var method__ = 'POST';
	if(method)
		method__ = method;
	
	var fialureF;
	if(failureFunction)
		fialureF = failureFunction;
	else
		fialureF = function(data,textstatus){
            Web.util.showTipsWanring(data.responseText);
			//mini.alert(data.responseText);
		};
	var successF;
	if(successFunction)
		successF = successFunction;
	else
		successF = function(data,textstatus){
			mini.alert("提交成功！");
		};
	$.ajax({
		type:method__,
		url:url,
		async:true,
		data:params,
		dataType:'json',
		success:successF,
		error:fialureF
	});
}

Web.util.requestAsync = function(url,method,params,successFunction,failureFunction,waitMsg){
	var method__ = 'POST';
	if(method)
		method__ = method;
	
	var fialureF;
	if(failureFunction)
		fialureF = failureFunction;
	else
		fialureF = function(data,textstatus){
            Web.util.showTipsWanring(data.responseText);
			//mini.alert(data.responseText);
		};
	var successF;
	if(successFunction)
		successF = successFunction;
	else
		successF = function(data,textstatus){
			mini.alert("提交成功！");
		};
	$.ajax({
		type:method__,
		url:url,
		async:false,
		data:params,
		dataType:'json',
		success:successF,
		error:fialureF
	});
}
Web.util.formSubmit = function(formId,url,method,successFunction,failureFunction,waitMsg){
	 var form = new mini.Form("#"+formId);                
	var data = form.getData();      //获取表单多个控件的数据
	Web.util.requestAsync(url,method,data,successFunction,failureFunction,waitMsg);
}
Web.util.formLoad = function(formId,url,method,params,successFunction,failureFunction,waitMsg){
		var method__ = 'POST';
		if(method)
			method__ = method;
		
		var fialureF;
		if(failureFunction)
			fialureF = failureFunction;
		else
			fialureF = function(data){
                Web.util.showTipsWanring(data);
				//mini.alert(data);
			};
	  var form = new mini.Form("#"+formId);                         
	   $.ajax({
	       url: url,
	       type: method__,
	       data: params,
	       success: function (text) {
	           var data ;
	           try{
	           data=mini.decode(text);   //反序列化成对象
	           }catch(e){
	        	   fialureF(text);
	           }
	           form.setData(data);             //设置多个控件数据
	           if(successFunction) successFunction();
	       },
	       error:fialureF
	   });
}
Web.util.load = function(gridid,params,successFunction,failureFunction,waitMsg){
	var grid = mini.get(gridid);
	grid.load(params,successFunction,failureFunction);
	$('#'+gridid).attr('key___',obj2str(params));
}
Web.util.reload = function(gridid){
    var grid = mini.get(gridid);
    var params=grid.getLoadParams();
    grid.gotoPage(params.pageIndex,params.pageSize);
}
Web.util.openWindow = function(url,params,width,height){
	var iTop = (window.screen.availHeight-30-height)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-width)/2; //获得窗口的水平位置;
	$.ajax({
		   type: "POST",
		   url:  url,
		   data: params,
		   dataType:'text',
		   success: function(dataText){
			   var data;
			   try{
				   data=jQuery.parseJSON(dataText);
				   mini.alert(dataText);
			   }catch(e){
				   var OpenWindow=window.open('','newwindow','height='+height+',width='+width+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
				   OpenWindow.document.write(dataText)
				   OpenWindow.document.close();

				  }
		    }
		});
}
Web.util.openMiniWindow = function(title,url,width,height,callFunc){
    mini.open({
        url :url,
        title : title,
        width : width,
        height : height,
        onload : function() {
        },
        ondestroy : function(action) {
            if(callFunc)
            	callFunc(action);
        }
    });
}
Web.util.tip = function(eid,text,postion,state,time){
	var state__ = '';
	var time__ = timeout__;
	if(time)
		time__ = time;
	if(state)
		state__ = state;
	
	var e = document.getElementById(eid);
	var x = $('#'+eid).offset().top;
	var y = $('#'+eid).offset().left;
	var width = $('#'+eid).width();
	var x__;
	var y__;
	if(postion=='center'){
		var h = $('#'+eid).height();
		var wx = 0;
		x__ = y+width/2-40;
		y__ = x+h/2;
	}else if(postion=='left'){
		x__ = y;
		y__ = x;
	}else{
		x__ = y+width+20;
		y__ = x-4;
	}
	mini.showTips({
        content: text,
        state: state__,
        x: x__,
        y: y__,
        timeout: time__
    });
}
Web.util.showTips=function(content,state,x,y,timeout) {
    if(!x) x='center';
    if(!y) y='center';
    if(!state) state='success';
    if(!timeout) timeout=1000;
    mini.showTips({
        content: content,
        state: state,
        x: x,
        y: y,
        timeout: timeout
    });
}
Web.util.showTipsWanring=function(content,state,x,y,timeout) {
    if(!x) x='center';
    if(!y) y='center';
    if(!state) state='warning';
    if(!timeout) timeout=1000;
    mini.showTips({
        content: content,
        state: state,
        x: x,
        y: y,
        timeout: timeout
    });
}
Web.util.confirm=function (context,yesFunc,title) {
	if(yesFunc&&context){
		mini.confirm(context,title,function (action) {
            if (action == "ok") {
                yesFunc();
            }
        })
	}
}
function oncodeRender(e){
	var retStr = '';
	var rootPath=getWebRootPath();
	var url = rootPath+'/admin/queryRenderedAppDictDetails?dictCode='+e.field;
	Web.util.requestAsync(url,'POST','',
			function(data){
				for(var i=0;i<data.length;i++) {
	                var g = data[i];
	                if(g.dictVal==e.value){
	                	retStr=g.dictName;
	                }
	            }
			}
	);
	return retStr;
}

function codeRender(field,value){
	var retStr = '';
	var rootPath=getWebRootPath();
	var url = rootPath+'/admin/queryRenderedAppDictDetails?dictCode='+e.field;
	Web.util.requestAsync(url,'POST','',
			function(data){
		        if(data.length==0) retStr=value;
				for(var i=0;i<data.length;i++) {
	                var g = data[i];
	                if(g.dictVal==value){
	                	retStr=g.dictName;
	                }
	            }
			}
	);
	return retStr;
}

function obj2str(o){    
    var r = [];
    if(typeof o =='string')  return '\"'+o.replace(/([\'\"\\])/g,'\\$1').replace(/(\n)/g,'\\n').replace(/(\r)/g,'\\r').replace(/(\t)/g,'\\t')+'\"';   
    if(typeof o =='undefined')  return '';
    if(typeof o == 'object'){
        if(o===null) return 'null';
        else if(!o.sort){
            for(var i in o)
                 r.push('"'+i+'":'+obj2str(o[i]));
             r='{'+r.join()+'}';
         }else{
            for(var i =0;i<o.length;i++)
                 r.push(obj2str(o[i]));
             r='['+r.join()+']';
         }    
        return r;    
     }
    return o.toString();    
} 
function getWebRootPath() {
	    var webroot=document.location.href;
	    webroot=webroot.substring(webroot.indexOf('//')+2,webroot.length);
	    webroot=webroot.substring(webroot.indexOf('/')+1,webroot.length);
	    webroot=webroot.substring(0,webroot.indexOf('/'));
	    var rootpath="/"+webroot;
	    return rootpath;
	}
function PrefixInteger(num, n) {
    return (Array(n).join(0) + num).slice(-n);

}
