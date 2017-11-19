$(function() {
	$('#beginDate').datetimebox('setValue', beginDate);
	$('#endDate').datetimebox('setValue', endDate);
	
    $("#entityId").combobox({
        url:'/shipmentBatch/queryCompanyList',
        valueField: 'companyid',
        textField: 'name',
        required: 'true'
    });

    $("#receiverCity").combobox({
        data:[],
        valueField: 'cityname',
        textField: 'cityname'
    });

    $("#receiverProvince").combobox({
        url:'/order/province/lookup',
        valueField: 'chinese',
        textField: 'chinese',
        onSelect:function(r){
            $.post("/order/city/lookup",{ provinceId:r.provinceid }, function(data){
                if (!data.isError) {
                    $("#receiverCity").combobox("clear");
                    $("#receiverCity").combobox("loadData", data);
                }
            });
        }
    });

	$('#dataTable').datagrid({
		title : '',
		iconCls : 'icon-edit',
		width : '100%',
		height : 410,
		nowrap : false,
		striped : true,
		border : true,
		collapsible : false,
		fitColumns:true,
		scrollbarSize:0,
		url : '/shipmentBatch/queryPageList',
		onBeforeLoad : function(param){
			if(param.initLoad){
				return true;
			}
			return false;
		},
		queryParams : {
			'orderType' : $('#orderType').val(),
			'entityId' : $('#entityId').combobox('getValue'),
			'beginDate' : $('#beginDate').datetimebox('getValue'),
			'endDate' : $('#endDate').datetimebox('getValue'),
			'receiverProvince' : $("#receiverProvince").combobox('getValue'),
			'receiverCity' : $("#receiverCity").combobox('getValue')
		},
		columns : [ [
		{
			field : 'tradeName',
			title : '店铺',
			width : 200,
			formatter : function(val, row) {
				if (null == val) {
					return row.orderType;
				}
				return row.orderType + '-' + val;
			}
		}, 
		{
			field : 'tradeId',
			title : '淘宝订单号',
			width : 200
		}, 
		{
			field : 'orderId',
			title : '订单号',
			width : 100
		},
		{
			field : 'receiverName',
			title : '顾客名称',
			width : 100
		},
		{
			field : 'receiverProvince',
			title : '省',
			width : 150
		},
		{
			field : 'receiverCity',
			title : '市',
			width : 150
		},
		{
			field : 'createDate',
			title : '订单创建时间',
			width : 200,
			formatter : dateFormatter
		},
		{
			field : 'totalAmount',
			title : '订单金额',
			width : 100,
			formatter : formatPrice,
			align : 'right'
		},
		{
			field : 'totalItemQty',
			title : '产品数量',
			width : 100
		},
		{
			field : 'buyerMessage',
			title : '买家备注',
			width : 150
		} 
		] ],
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		remoteSort : false,
		singleSelect : false,
		pagination : true,
		rownumbers : true
	});

	var p = $('#dataTable').datagrid('getPager');
	$(p).pagination({
		pageSize : 100,
		pageList : [ 100, 300, 500 ],
		beforePageText : '第',
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		onBeforeRefresh : function() {
			$(this).pagination('loading');
			$(this).pagination('loaded');
		}
	});
	
	function getSelected(){
		var selected = $('#dataTable').datagrid('getSelected');
		if (selected){
			return selected;
		}
	}

	//查询按钮
	$("#queryBtn").click(function() {
		var validate = $('#queryForm').form('validate');
		if(!validate){
			return false;
		}
		
		var beginDate = $('#beginDate').datetimebox('getValue');
		var endDate = $('#endDate').datetimebox('getValue');
		
		var diff = Date.parse(endDate) - Date.parse(beginDate);
		if(diff/1000/3600/24>7){
			$.messager.alert('错误', '下单时间跨度不能超过7天', 'error');
			return;
		}
		
		$('#dataTable').datagrid('reload', {
			'initLoad' : true,
			'orderType' : $('#orderType').val(),
			'entityId' : $('#entityId').combobox('getValue'),
			'beginDate' : beginDate,
			'endDate' : endDate,
			'receiverProvince' : $("#receiverProvince").combobox('getValue'),
			'receiverCity' : $("#receiverCity").combobox('getValue')
		});
	});
	
	//清空按钮
	$('#clearBtn').click(function(){
		$('#orderType').val(null);
		$('#entityId').combobox('setValue', null);
		$("#receiverProvince").combobox('setValue', null);
		$("#receiverCity").combobox('setValue', null);
	});
	
	
	
	//创建批次
	$("#createBatch").click(function() {
		
		var _data = $('#dataTable').datagrid('getChecked');
		
		if( _data.length <= 0){
			$.messager.alert('错误', '请选择要创建波次的数据', 'error');
			return false;
		}
		
		var orderIds = '';
		for (var i=0; i<_data.length; i++) {
			orderIds += _data[i].orderId;
			if (i < (_data.length -1)) {
				orderIds += ',';
			}
		}
		
		console.log('orderIds: ' + orderIds);
		
		$.messager.confirm('确认', '确定选择['+_data.length+']条记录创建波次?', function(result) {
			if(result){
		
				$.ajax({
					type: 'POST',
					url: 'createBatch',
					data: {'orderIds': orderIds},
					success:function(data){
						if(eval(data.success)){
							$.messager.alert('提示', '创建波次[' + data.batchCode + ']成功', 'info');
							$('#dataTable').datagrid('reload');
						}else{
							$.messager.alert('错误', data.message, 'error');
						}
					},
					error:function(msg){
						$.messager.alert('错误', msg, 'error');
					}
				});
		
			}
		});
	});
	
	
	
	//Number 格式化
	function formatFloat(val, pos){
		if(null==val || ''==val || isNaN(val)){
			return null;
		}
		return Math.round(val*Math.pow(10, pos)) / Math.pow(10, pos);
	}

});


function dateFormatter(val, row){
	if(null!=val){
		return new Date(val).format('yyyy-MM-dd hh:mm:ss');
	}
}

Date.prototype.format = function(format){
	var o = {
	"M+" : this.getMonth()+1, //month
	"d+" : this.getDate(),    //day
	"h+" : this.getHours(),   //hour
 	"m+" : this.getMinutes(), //minute
	"s+" : this.getSeconds(), //second
 	"q+" : Math.floor((this.getMonth()+3)/3),  //quarter
 	"S" : this.getMilliseconds() //millisecond
	};

	if(/(y+)/.test(format)) {
		format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
	}
	
 	for(var k in o){
		if(new RegExp("("+ k +")").test(format)){
 			format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
		}
	}
	return format;
};

function formatPrice(price) {
    if(price==null||price=='')
        return '0.00';
    var prc=price;
    return prc.toFixed(2);
}