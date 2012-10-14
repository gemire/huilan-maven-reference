<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title><tiles:insertAttribute name="title"/></title>
<tiles:insertAttribute name="header"/>
</head>
<body>
<div id="box_root">
<tiles:insertAttribute name="box_header"/>
<tiles:insertAttribute name="box_main"/>
<tiles:insertAttribute name="box_footer"/>
</div>
<script type="text/javascript" src="http://js.tongji.linezing.com/2989608/tongji.js"></script><noscript><a href="http://www.linezing.com"><img src="http://img.tongji.linezing.com/2989608/tongji.gif"/></a></noscript>
</body>
</html>

