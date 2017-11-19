/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-5
 * Time: 下午1:43
 * To change this template use File | Settings | File Templates.
 */

function checkForm() {
	var fileName = $('#uploadfile').val();
	if (null == fileName || fileName.length == 0) {
		$.messager.alert('错误', '请选择要导入的CSV文件', 'error');
		return false;
	}
	
	var idx = fileName.lastIndexOf(".");
	var suffix = fileName.substring(idx + 1, fileName.length);
	if(suffix != "csv") {
		$.messager.alert('错误', '文件格式错误，只能识别CSV文件', 'error');
		return false;
	}
	
	return true;
}


String.prototype.lastIndexOf = function(str) {
	val = this.valueOf();
	if (val.indexOf(str) <= 0) {
		return -1;
	}
	
	for(var i=(val.length-1); i>0; i--){
		var idx = val.charAt(i);
		if (idx == str) {
			return i;
		}
	}
};
