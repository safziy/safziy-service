<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/jquery/ajaxfileupload.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#upload").click(function() {
			if ($("#file").val().length > 0) {
				ajaxFileUpload();
			} else {
				alert("请选择文件");
			}
		});
	});

	function ajaxFileUpload() {
		$.ajaxFileUpload({
			url : '/remote', //用于文件上传的服务器端请求地址
			type : 'post',
			secureuri : false, //一般设置为false
			fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType : 'json', //返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{
				$('#result').html(data.result);
			},
			error : function(data, status, e)//服务器响应失败处理函数
			{
				alert(e);
			}
		})
		return false;
	}
</script>

</head>
<body>
	<div>
		<input type="file" id="file" name="file" /> <input type="button"
			id="upload" value="上传" />
	</div>
	<div id="result"></div>
</body>
</html>