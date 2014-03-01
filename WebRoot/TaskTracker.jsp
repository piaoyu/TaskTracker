
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<h1>任务跟踪</h1>
<h2 style="color: green">待办事件</h2>
<title></title>
<script type="text/javascript">
	var xmlHttpRequest = null;//定义Request变量
	function createXMLHttpRequest() {//创建XMLHttpRequest请求
		if (window.XMLHttpRequest) {
			xmlHttpRequest = new XMLHttpRequest();
		} else {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}

	function add() {//新增未完成事件
		createXMLHttpRequest();//创建XMLHttpRequest请求
		try {
			//获得时间
			var today = new Date();
			var time = (today.getYear()) + "-" + (today.getMonth() + 1) + "-"
					+ (today.getDate())
			//获得内容
			var content = document.getElementById("content").value;
			//用Get方法传参
			xmlHttpRequest.open("GET", "AddServlet?time=" + time + "&content="
					+ content, true);
			//关联回调函数
			xmlHttpRequest.onreadystatechange = addcallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("新增处理失败");
		}
	}
	function addcallback() {
		if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			document.getElementById("newtask").innerHTML = xmlHttpRequest.responseText;
		}
	}

	function delete_(id) {//删除事件
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "DeleteService?id=" + id, true);
			xmlHttpRequest.onreadystatechange = deletecallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("删除处理失败");
		}
	}
	function deletecallback() {
		document.getElementById(id).style.display = "none";//服务器删除操作完成，将该行隐藏
	}

	function complete(id) {//完成事件
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "CompleteServlet?id=" + id, true);
			xmlHttpRequest.onreadystatechange = completecallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("完成处理失败");
		}
	}
	function completecallback() {
		document.getElementById(id).style.display = "none";//服务器操作完成，将该行隐藏
		document.getElementById("finishtask").innerHTML = xmlHttpRequest.responseText;//返回在完成的语句中
	}

	function modify(id) {//修改事件
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "ModifyServlet?id=" + id, true);
			xmlHttpRequest.onreadystatechange = modifycallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("修改处理失败");
		}
	}
	function modifycallback() {
		document.getElementById(id).style.display = "none";//服务器操作完成，将该行隐藏
		document.getElementById(id).style.display = "inline"; //保证修改框不被隐藏 
	}

	function recover(id) {//恢复事件
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "RecoverServlet?id=" + id, true);
			xmlHttpRequest.onreadystatechange = recovercallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("恢复处理失败");
		}
	}
	function recovercallback() {
		document.getElementById(id).style.display = "none";//服务器操作完成，将该行隐藏
		document.getElementById("newcontent").innerHTML = xmlHttpRequest.responseText;//返回在完成的语句中
	}
</script>
</head>
<body>
	<div id="newtask"></div>
	<div id="finishtask"></div>
	<hr>
	<input type="text" size="50" type="text" id="content" />
	<br />
	<input type="button" value="新增" onclick="add();">
	<p>copyright 任务跟踪器 作者：piaoyu</p>
</body>
</html>
