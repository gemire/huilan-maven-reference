<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%  
//response.setHeader("P3P","CP=CAO PSA OUR");  
response.setHeader("P3P","CP='IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT'");
%> 
<html>
  <head>
    <title><t:insertAttribute name="title"/></title>
    <link rel="stylesheet" href="${ctx}/Manager/Css/Site_Css.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/<s:theme code='styleSheet'/>" type="text/css">
    <link rel="shortcut icon" href="${ctx}/Manager/images/icon.ico" type="image/x-icon" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>   
<script type="text/javascript" src="${ctx}/Manager/js/checkform.js" charset="utf-8"></script>
<script src="${ctx}/Manager/js/date/date.js" type="text/javascript" charset="utf-8"></script>
  </head>

<body bgColor="#FFFFFF" topMargin="5" >    
    <div>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">   
    <tr><td>    
        <t:insertAttribute name="content" />    
    </td></tr>    
    <tr><td height="5"></td></tr>
    </table>
    </div>
</body>
</html>
