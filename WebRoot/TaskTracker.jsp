
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
<h1>�������</h1>
<h2 style="color: green">�����¼�</h2>
<title></title>
<script type="text/javascript">
	var xmlHttpRequest = null;//����Request����
	function createXMLHttpRequest() {//����XMLHttpRequest����
		if (window.XMLHttpRequest) {
			xmlHttpRequest = new XMLHttpRequest();
		} else {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}

	function add() {//����δ����¼�
		createXMLHttpRequest();//����XMLHttpRequest����
		try {
			//���ʱ��
			var today = new Date();
			var time = (today.getYear()) + "-" + (today.getMonth() + 1) + "-"
					+ (today.getDate())
			//�������
			var content = document.getElementById("content").value;
			//��Get��������
			xmlHttpRequest.open("GET", "AddServlet?time=" + time + "&content="
					+ content, true);
			//�����ص�����
			xmlHttpRequest.onreadystatechange = addcallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("��������ʧ��");
		}
	}
	function addcallback() {
		if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			document.getElementById("newtask").innerHTML = xmlHttpRequest.responseText;
		}
	}

	function delete_(id) {//ɾ���¼�
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "DeleteService?id=" + id, true);
			xmlHttpRequest.onreadystatechange = deletecallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("ɾ������ʧ��");
		}
	}
	function deletecallback() {
		document.getElementById(id).style.display = "none";//������ɾ��������ɣ�����������
	}

	function complete(id) {//����¼�
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "CompleteServlet?id=" + id, true);
			xmlHttpRequest.onreadystatechange = completecallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("��ɴ���ʧ��");
		}
	}
	function completecallback() {
		document.getElementById(id).style.display = "none";//������������ɣ�����������
		document.getElementById("finishtask").innerHTML = xmlHttpRequest.responseText;//��������ɵ������
	}

	function modify(id) {//�޸��¼�
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "ModifyServlet?id=" + id, true);
			xmlHttpRequest.onreadystatechange = modifycallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("�޸Ĵ���ʧ��");
		}
	}
	function modifycallback() {
		document.getElementById(id).style.display = "none";//������������ɣ�����������
		document.getElementById(id).style.display = "inline"; //��֤�޸Ŀ򲻱����� 
	}

	function recover(id) {//�ָ��¼�
		createXMLHttpRequest();
		try {
			var id = document.getElementById("id").value;
			xmlHttpRequest.open("GET", "RecoverServlet?id=" + id, true);
			xmlHttpRequest.onreadystatechange = recovercallback;
			xmlHttpRequest.send(null);
		} catch (exception) {
			alert("�ָ�����ʧ��");
		}
	}
	function recovercallback() {
		document.getElementById(id).style.display = "none";//������������ɣ�����������
		document.getElementById("newcontent").innerHTML = xmlHttpRequest.responseText;//��������ɵ������
	}
</script>
</head>
<body>
	<div id="newtask"></div>
	<div id="finishtask"></div>
	<hr>
	<input type="text" size="50" type="text" id="content" />
	<br />
	<input type="button" value="����" onclick="add();">
	<p>copyright ��������� ���ߣ�piaoyu</p>
</body>
</html>
