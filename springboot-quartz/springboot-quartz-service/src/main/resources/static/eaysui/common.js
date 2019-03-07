function changeTheme(themeName) {/*更换主题扩展*/
	var themeCSS = $("#easyuiTheme");  
    var url = themeCSS.attr('href');  
    var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';  
    themeCSS.attr('href', href);  
    var iframe = $('iframe');  
    if(iframe.length > 0){  
        for(var i = 0; i < iframe.length; i++){  
            var ifr = iframe[i];  
            $(ifr).contents().find('#easyuiTheme').attr('href', href);  
        }  
    }  
    //记住cookie的天数  
    $.cookie('easyuiThemeName', themeName,{  
    	expires: 7  
    });  
}

function showRightMenu(e, id) {
	$("#" + id).menu("show", {
		left : e.pageX,
		top : e.pageY
	});
}

function loadWindow(id, title, iconCls) {
	$("#" + id).window({
		title : title,
		iconCls : iconCls,
		modal : true,// 遮罩层
		shadow : false,
		closed : false,
		collapsible : false,// 展开或者收缩
		minimizable : false,// 最小化
		maximizable : false
	// 最大化
	});
}

function loadDialog(id, title, iconCls, max) {
	$("#" + id).dialog({
		title : title,
		iconCls : iconCls,
		modal : true,// 遮罩层
		maximizable : max
	});
}

function loadDialog(id, title, iconCls, modal, max) {
	$("#" + id).dialog({
		title : title,
		iconCls : iconCls,
		modal : modal,// 遮罩层
		maximizable : max
	});
}

function loadShow(title,msg){
	window.parent.$.messager.show({
		title	:'<span class="icon-tip">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>' + title,
		msg		:msg,
		showType:"slide",//slide,fade等
		style	:{
			right:"",
			top:document.body.scrollTop+document.documentElement.scrollTop+4,
			bottom:"",
			zIndex:99999
		}
	});
}

function loadNotifyMessage(type, title, msg){
    $.messager.show({
        title	: '<span class="icon-tip">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>' + title,
        msg		: msg,
        timeout : 0,//不自动关闭
        showType: 'show'
    });
    //11.有新订单类型 12.申请运单类型
    if(type == 11 || type == 12) {
    	var iframeDoc = $(window.parent.document).contents().find("#iframe")[0];
    	if(iframeDoc != null) {
    		if(typeof (iframeDoc.contentWindow.refreshLoadcar) === 'function') {
    			
    			iframeDoc.contentWindow.refreshLoadcar(type);
    		}
    	}
    } else {
    	var iframeDoc = $(window.parent.document).contents().find("#iframe")[0];
    	if(iframeDoc != null) {
    		if(typeof (iframeDoc.contentWindow.refreshWaybillStatus) === 'function') {
    			
    			iframeDoc.contentWindow.refreshWaybillStatus();
    		}
    	}
    }
}

function loadShowError(title,msg){
	$.messager.show({
		title:title,
		width:570,
		height:250,
		msg:msg,
		timeout:0,
		showType:'slide',
		style:{
			right:'',
			bottom:''
		}
	});
}

function loadShowLog(title,msg){
	$.messager.show({
		title:title,
		width:570,
		height:250,
		msg:msg,
		timeout:0,
		showType:'fade',
		style:{
			right:'',
			bottom:''
		}
	});
}

function loadSort(){
	$("#sort").combobox({
		valueField: "value",
		textField: "text",
		data:[{value:1,text:'1'},{value:2,text:'2'},{value:3,text:'3'},{value:4,text:'4'},{value:5,text:'5'},{value:6,text:'6'},{value:7,text:'7'},{value:8,text:'8'},{value:9,text:'9'},{value:10,text:'10'},{value:11,text:'11'},{value:12,text:'12'},{value:13,text:'13'},{value:14,text:'14'},{value:15,text:'15'}],
		prompt:'--请选择--',
		required:true,
		editable:false,
	});
}

function loadEnable(){
	$("#enable").combobox({
		showItemIcon: true,
		valueField: "value",
		textField: "text",
		data:[
				{value:1,text:'启用',iconCls:'icon-control-stop-blue'},
				{value:2,text:'禁用',iconCls:'icon-control-stop'}
			],
		prompt:'--请选择--',
		required:true,
		editable:false,
		panelHeight:'auto'
	});
}

function loadIconCls(){
	$("#iconCls").combobox({
		url:ctx+"/system/menu/iconClsData",
		valueField:"value",
		textField:"text",
		iconCls:"iconCls",
		showItemIcon: true,
		editable: true
	});
}

function formatterEnable(value,record){
	if(value==1){return "<div class='icon-control-stop-blue' title='启用'>&nbsp;</div>";}
	if(value==2){return "<div class='icon-control-stop' title='禁用'><font color='red'>&nbsp;</font></div>";}
}
function formatterIconCls(value,record){
	return "<img src='"+ctx+"/common/easyui/themes/custom/"+value.replace("icon-","")+".png'/>";
}