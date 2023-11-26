<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC = "-//W3C//DTD HTML 4.01 Transitional//EN"
					    "http://W3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생회 소개</title>
<style>
        ul {
            list-style-type: none;
        }

        .level1 {
            color: blue; /* 대표 */
        }

        .level2 {
            color: green; /* 팀장 */
        }

        .level3 {
            color: red; /* 팀원 */
        }
    </style>
</head>
<body>
<center>
<h1>학생회소개</h1>
<hr>
<h2>학생회공약</h2>
<h3>${boardVO.counPromise }</h3>
<h2>조직도</h2>
<c:choose>
    <c:when test="${not empty orgChart}">
        <ul>
            <li class="level${orgChart.level}">${orgChart.name}
                <c:if test="${not empty orgChart.children}">
                    <ul>
                        <c:forEach var="team" items="${orgChart.children}">
                            <li class="level${team.level}">${team.name}
                                <c:if test="${not empty team.children}">
                                    <ul>
                                        <c:forEach var="member" items="${team.children}">
                                            <li class="level${member.level}">${member.name}</li>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </li>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No data available for the organization chart.</p>
    </c:otherwise>
</c:choose>
<hr>
</center>
</body>
</html>