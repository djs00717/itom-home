/**
 * Created by gaudi.gao on 2015/1/7.
 */


Date.prototype.format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

$(function(){

    $("#tbStatus").combobox({
        url:'/payTransOrder/orderStatus/lookup',
        valueField: 'tmpId',
        textField: 'dsc'
    });

    $("#tbRefundStatus").combobox({
        url:'/payTransOrder/refundStatus/lookup',
        valueField: 'id',
        textField: 'name'
    });

    $('#dg').datagrid({
        title:'',
        iconCls:'icon-edit',
        width: '100%',
        height:350,
        striped: false,
        border: true,
        collapsible:false,
        fitColumns:false,
        url: "/payTransOrder/list",
        columns:[[
            {field: 'ck',checkbox:'true',width:30},
            {field:'orderId',title:'订单号',width:90,editor:'text'},
            {field:'orderType',hidden: true},
            {field:'orderTypeName',title:'订单类型',width:130,editor:'text'},
            {field:'payAmount',title:'付款金额',width:80,editor:'text',
                formatter: function(value) {
                    if(value != null){
                        return (value / 100.0);
                    }
                    return value;
                }
            },
            {field:'entityId',hidden: true},
            {field:'entityName',title:'承运商',width:120,editor:'text'},
            {field:'createDate',title:'创建时间',width:130,editor:'datebox',
                formatter: function(value) {
                    if(value != null){
                        return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                    }
                    return value;
                }
            },
            {field:'status',hidden: true},
            {field:'statusName',title:'订单状态',width:60,editor:'text'},
            {field:'payType',hidden: true},
            {field:'payTypeName',title:'支付类型',width:80,editor:'text'},
            {field:'sendDate',title:'发货时间',width:130,editor:'datebox',
                formatter: function(value) {
                    if(value != null){
                        return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                    }
                    return value;
                }
            },
            {field:'feedbackDate',title:'反馈时间',width:130,editor:'datebox',
                formatter: function(value) {
                    if(value != null){
                        return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                    }
                    return value;
                }
            },
            {field:'ptId',title:'支付交易ID',width:130,editor:'text'},
            {field:'ptReference',title:'支付交易号',width:130,editor:'text'},
            {field:'ptTranDateTime',title:'支付交易时间',width:130,editor:'text',
                formatter: function(value) {
                    if(value != null) {
                        return value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8)+" "+
                                value.substring(8,10)+":"+value.substring(10,12)+":"+value.substring(12,14);
                    }
                    return value;
                }
            },
            {field:'rtId',title:'退款交易ID',width:130,editor:'text'},
            {field:'rtReference',title:'退款交易号',width:130,editor:'text'},
            {field:'rtTranDateTime',title:'退款交易时间',width:130,editor:'text',
                formatter: function(value) {
                    if(value != null) {
                        return value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8)+" "+
                            value.substring(8,10)+":"+value.substring(10,12)+":"+value.substring(12,14);
                    }
                    return value;
                }
            },
            {field:'aa',title:'',width:4,editor:'text'}
        ]],
        remoteSort:false,
        singleSelect:true,
        checkOnSelect: true,
        selectOnCheck: true,
        pagination:true,
        rownumbers:true,
        onLoadSuccess: function(data){
            //alert(JSON.stringify(data));
        },
        onLoadError: function(){
            alert("加载失败!");
        },
        onUncheck:function(index,data){
            $(this).datagrid("clearSelections");
        },
        onSelect:function(index,row){
            if(row.rtId) {
                $("#lnkCancel").hide();
            } else {
                $("#lnkCancel").show();
            }
        },
        onDblClickRow:function(rowIndex, rowData){
            $("#lbAlternate").click();
        }
    });

    var p = $('#dg').datagrid('getPager');
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

    //查询
    $("#btnSearch").click(function () {
        $("#tbOrderId").val($("#tbOrderId").val().replace(/^\s+|\s+$/g, ""));

        var params = {
            orderId:$("#tbOrderId").val(),
            status:$("#tbStatus").combobox('getValue'),
            ptReference:$("#tbPtReference").val(),
            ptTransStart:$("#tbPtTransStart").datetimebox('getValue'),
            ptTransEnd:$("#tbPtTransEnd").datetimebox('getValue'),
            refundStatus:$("#tbRefundStatus").combobox('getValue'),
            rtReference:$("#tbRtReference").val(),
            rtTransStart:$("#tbRtTransStart").datetimebox('getValue'),
            rtTransEnd:$("#tbRtTransEnd").datetimebox('getValue'),
            feedbackStart:$("#tbFeedbackStart").datetimebox('getValue'),
            feedbackEnd:$("#tbFeedbackEnd").datetimebox('getValue'),
            createStart:$("#tbCreateStart").datetimebox('getValue'),
            createEnd:$("#tbCreateEnd").datetimebox('getValue')
        }

        var bNotEmpty = false;
        for(var prop in params) {
            if(prop) {
                var propValue = $(params).attr(prop)
                if(propValue){
                    bNotEmpty = true;
                }
            }
        }

        if(bNotEmpty) {
            $('#dg').datagrid('load',params);
        } else {
            alert("请至少输入一个查询条件");
        }

    });

    $("#btnReset").click(function () {
         $("#ff").form("clear");
    });


    $("#lnkCancel").click(function () {
        var row =  $('#dg').datagrid('getSelected');
        if (row) {
            $.post("/payTransOrder/cancel", { orderId: row.orderId }, function (result) {
                if(result.success){
                    $('#dg').datagrid('reload');
                    alert("退款成功!");
                } else if(result.returnMsg) {
                    alert(result.returnMsg);
                }
            });
        } else {
            alert("请先选择一条语音支付订单!");
        }
    });
});