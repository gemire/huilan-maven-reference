<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html >
<head>
    <title>移动部门</title>
    <script language="javascript">
 var TreeImgdir = "${ctx}/Manager/images/TreeIcon/";    
</script>
<script src="${ctx}/Manager/js/MoveTree.js"></script>
<base target="_self"></base>
<style> .FolderStyle { COLOR: #000000; TEXT-DECORATION: none } </style>
<link rel="stylesheet" href="${ctx}/Manager/Css/Site_Css.css" type="text/css">
<link rel="stylesheet" href="${ctx}/<s:theme code='styleSheet'/>" type="text/css">
</head>

<body>
<table width='100%' cellpadding="0" cellspacing="0" border="0" bgcolor="#6b82a5">
	<tr>
		<td class="table_title">
			移动部门
		</td>
	</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td width="100%" bgcolor="#ffffff" valign="top" style="PADDING-LEFT:5px">
			${outjs}
		</td>
	</tr>
</table>


<script language="javascript">
 function xNowMove(xName,xId)
 {
    if (xId!=null)
    {
        if (confirm("将此部门移动到【"+ xName +"】部门下 ?\n\n确定吗？"))
        {
            //window.returnValue = "Move.aspx?CMD=Move&GroupID=10&ToGroupID="+xId;
            //window.close();
            window.returnVal = "Move.aspx?cmd=move&GroupID=10&ToGroupID="+xId;
            window.parent.hidePopWin(true);
        }      
    }
 }
</script>
</body>
</html>
