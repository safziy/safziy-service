<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>

<link rel="stylesheet" type="text/css" href="/styles/jquery/jquery.dataTables.min.css" />

<script type="text/javascript" src="/js/jquery/jquery.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	function showContent() {
		$("#content").html("我来测试一下JQuery");
	}

	$(document).ready(function() {
		$("#example").dataTable();
	});
</script>

</head>
<body>
	<div id="content"></div>
	<button name="show" onclick="javascript: showContent()">ShowContent</button>

	<table id="example" cellpadding="3" cellspacing="1" style="width:500px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Tom</td>
			<td>20</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Kitty</td>
			<td>18</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Jim</td>
			<td>21</td>
		</tr>
		<tr>
			<td>4</td>
			<td>ketty</td>
			<td>19</td>
		</tr>
	</table>

</body>
</html>