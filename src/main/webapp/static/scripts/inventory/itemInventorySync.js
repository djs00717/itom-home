$(function() {

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
		url : '/inventory/queryPageList',
		queryParams : {
			'plucode' : $("#plucode").val(),
			'pluname' : $("#pluname").val(),
			'active' : $("#active").val(),
			'tradeType' : $("#tradeType").val()
		},
		columns : [ [
		{
			field : 'pluid',
			title : '商品编号',
			width : 150
		}, 
		{
			field : 'pluname',
			title : '商品名称',
			width : 200
		}, 
		{
			field : 'active',
			title : '当前状态',
			formatter : function(value, row, index) {
				if (row.active) {
					return '启用';
				} else if (!row.active) {
					return '停用';
				}
				return 'NONE';
			},
			width : 150
		}, 
		{
			field : 'tradeType',
			title : '订单类型',
			width : 150
		} 
		] ],
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		remoteSort : false,
		singleSelect : true,
		pagination : true,
		rownumbers : true
	});
	
	$('#plubaseDataTable').datagrid({
		title : '',
		iconCls : 'icon-edit',
		width : '100%',
		height : 350,
		nowrap : false,
		striped : true,
		border : true,
		collapsible : false,
		fitColumns:true,
		scrollbarSize:0,
		url : '/inventory/queryPlubasePageList',
		queryParams : {
			'plucode' : $("#p_plucode").val(),
			'pluname' : $("#p_pluname").val()
		},
		columns : [ [
		{
			field : 'plucode',
			title : '商品编号',
			width : 150
		}, 
		{
			field : 'pluname',
			title : '商品名称',
			width : 150
		},
		{
			field : 'issuiteplu',
			title : '是滞套装',
			formatter : function(value, row, index) {
				if (row.issuiteplu == '1') {
					return '套装';
				} else if (row.issuiteplu == '0') {
					return '非套装';
				}
				return 'NONE';
			},
			width : 150
		},
		{
			field : 'pkunit',
			title : '单位',
			width : 150
		} 
		] ],
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		remoteSort : false,
		singleSelect : true,
		pagination : true,
		rownumbers : true
	});
	
	function getSelected(){
		var selected = $('#dataTable').datagrid('getSelected');
		if (selected){
			return selected;
		}
	}

	var p = $('#dataTable').datagrid('getPager');
	$(p).pagination({
		pageSize : 10,
		pageList : [ 5, 10, 15 ],
		beforePageText : '第',
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		onBeforeRefresh : function() {
			$(this).pagination('loading');
			$(this).pagination('loaded');
		}
	});

	//查询按钮
	$("#queryBtn").click(function() {
		$('#dataTable').datagrid('reload', {
			'plucode' : $('#pluid').val(),
			'pluname' : $('#pluname').val(),
			'active' : $("#active").val(),
			'tradeType' : $("#tradeType").val()
		});
	});
	
	//清空按钮
	$('#clearBtn').click(function(){
		$('#plucode').val('');
		$("#pluname").val('');
		$("#active").val('');
		$("#tradeType").val('');
	});
	
	//查询按钮
	$("#p_queryBtn").click(function() {
		$('#plubaseDataTable').datagrid('reload', {
			'plucode' : $('#p_plucode').val(),
			'pluname' : $('#p_pluname').val()
		});
	});
	
	//清空按钮
	$('#p_clearBtn').click(function(){
		$('#p_plucode').val('');
		$("#p_pluname").val('');
	});

	// 启用按钮
	$("#enableBtn").click(function() {
		var row = getSelected();
		if(undefined !=row && null!=row) {
			$.messager.confirm('确认', '确定启用规则编号为['+row.pluid+']的记录?', function(result) {
				if(result){
					
					$.ajax({
						type: 'POST',
						url: 'changeStatus',
						data: {'plucode':row.pluid, 'active': true},
						success:function(data){
							if(eval(data.success)){
								$('#dataTable').datagrid('reload');
							}else{
								$.messager.alert('错误',data.message,'error');
							}
						},
						error:function(msg){
							$.messager.alert('错误',msg,'error');
						}
					});
				}
			});
		}
	});

	//禁用按钮
	$("#disableBtn").click(function() {
		var row = getSelected();
		if(undefined !=row && null!=row) {
			$.messager.confirm('确认', '确定禁用规则编号为['+row.pluid+']的记录?', function(result) {
				if(result){
					
					$.ajax({
						type: 'POST',
						url: 'changeStatus',
						data: {'plucode':row.pluid, 'active': false},
						success:function(data){
							if(eval(data.success)){
								$('#dataTable').datagrid('reload');
							}else{
								$.messager.alert('错误',data.message,'error');
							}
						},
						error:function(msg){
							$.messager.alert('错误',msg,'error');
						}
					});
				}
			});
		}
	});

	//新增按钮
	$("#addBtn").click(function() {
		
		$('#p_plucode').val(null);
		$('#p_pluname').val(null);
		
		$('#persistDialog').window({
			width : 800,
			height : 550,
			iconCls : '',
			top : ($(window).height() - 600) * 0.5,
			left : ($(window).width() - 700) * 0.5,
			shadow : true,
			modal : true,
			closed : true,
			minimizable : false,
			maximizable : false,
			collapsible : false,
			onBeforeClose: function(){
				document.forms['persistForm'].reset();
				$('#message').html('');
			}
		}).window('open');

		$('#persistDialog').window('setTitle', '添加商品');
	});
	
	
	//保存
	$("#saveBtn").click(function() {
		
		var _data = $('#plubaseDataTable').datagrid('getChecked');
		var _valid = $('#persistForm').form('validate');
		if (!_valid) {
			return false;
		}
		
		if( _data.length <= 0){
			$.messager.alert('错误', '请选择一条数据', 'error');
			return false;
		}
		
		var param = {};
		param['plucode'] = _data[0].plucode;
		param['tradeType'] = $('#p_tradeType').val();
		
		$.ajax({
			type: 'POST',
			url: 'persist',
			data: param,
			success:function(data){
				if(eval(data.success)){
					$('#persistDialog').window('close');
					$('#dataTable').datagrid('reload');
				}else{
					$.messager.alert('错误', data.message, 'error');
				}
			},
			error:function(msg){
				$.messager.alert('错误', msg, 'error');
			}
		});
	});
	
	//取消新增
	$("#closeBtn").click(function() {
		document.forms['persistForm'].reset();
		$('#persistDialog').dialog('close');
	});
	
	//Number 格式化
	function formatFloat(val, pos){
		if(null==val || ''==val || isNaN(val)){
			return null;
		}
		return Math.round(val*Math.pow(10, pos)) / Math.pow(10, pos);
	}

});
