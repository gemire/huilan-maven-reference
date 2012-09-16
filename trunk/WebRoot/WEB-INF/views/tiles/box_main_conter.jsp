<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 <!-- 二列版式开始 -->
 <div id="box_main">
  <div class="ny_right_bg-08">
<tiles:insertAttribute name="box_left"/>
<tiles:insertAttribute name="box_right"/>
<div class="clearBoth"></div>
</div>
</div>
