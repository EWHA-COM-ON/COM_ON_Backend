<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC = "-//W3C//DTD HTML 4.01 Transitional//EN"
					    "http://W3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생회 정보</title>
</head>
<body>
<center>
<h1>학생회정보</h1>
<hr>
<h2>학생회 인삿말</h2>
<h3>${boardVO.counInfo }</h3>
<h2>주소/연락처</h2>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">주소</td>
		<td align="left"><input name="주소" type="text" value="${boardVO.counLocation }"/></td>
	</tr>
</table>
<hr>
</center>
</body>
</html>