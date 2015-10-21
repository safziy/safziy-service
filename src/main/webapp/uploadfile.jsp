<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>

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
			url : '/saveMail?type=upload', //用于文件上传的服务器端请求地址
			type : 'post',
			secureuri : false, //一般设置为false
			fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType : 'json', //返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{
				alert('上传成功');
				/* if (data.res == '1') {
					$('#display').html(htmldecode(data.content));
					$('#filePath').val(data.path);
				} else {
					alert(data.msg);
					$('#filePath').val('');
					if (data.content) {
						$('#display').html(htmldecode(data.content));
					}
				} */
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
		<input type="file" id="file" name="file" /> 
		<input type="button" id="upload" value="上传" />
	</div>
</body>
</html>