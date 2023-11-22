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
		<td align="left">${boardVO.counLocation }</td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">위치</td>
		<td align="left">${boardVO.counAddress }</td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">전화</td>
		<td align="left">${boardVO.counPhone }</td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">이메일</td>
		<td align="left">${boardVO.counEmail }</td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">카카오톡</td>
		<td align="left">${boardVO.counTalk }</td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">인스타</td>
		<td align="left">${boardVO.counInsta }</td>
	</tr>
</table>
<hr>
</center>
</body>
</html>