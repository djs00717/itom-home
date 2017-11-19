$(function(){

    $("#searchBtn").click(function(){
        $('#dataGrid').datagrid("load",{
            launchNum:$("#launchNum").val()
        })
    });

    $("#exportCsvFile").click(function(){
        var row =$("#dataGrid").datagrid("getSelected");
         if(!row){
             alert("请选择下载列");
             return;
         }
        var launchNum = row.launchNum;
        window.location="/shipment/wave/download/"+launchNum;
    });

    $('#dataGrid').datagrid({
        title:'',
        iconCls:'icon-edit',
        url:"/shipment/wave/list",
        width: '100%',
        height:400,
        striped: true,
        border: true,
        collapsible:true,
        fitColumns:true,
        scrollbarSize:0,
        columns:[[
            {field:'id',checkbox:true},
            {field:'launchNum',title:'波次号',editor:'text',width:80},
            {field:'createTime',title:'创建时间',editor:'text',width:80},
            {field:'orderType',title:'店铺',editor:'text',width:80},
            {field:'companyName',title:'承运商',editor:'text',width:80},
            {field:'count',title:'订单量',editor:'text',width:80}

        ]],
        remoteSort:false,
        singleSelect:true,
        checkOnSelect: true,
        selectOnCheck: true,
        pagination:true,
        queryParams: {
            launchNum:$("#launchNum").val()
        }
    });

});