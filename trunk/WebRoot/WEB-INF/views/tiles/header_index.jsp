<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link href="${ctx}/style/page_index.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/style/css.css"  rel="stylesheet" type="text/css" />
<script src="${ctx}/js/16sucai.js" type="text/javascript"></script>
<script language="javascript">
	function getBg(num){
		for(var id = 0;id<=5;id++)
		{
			if(id==num)
			{
				document.getElementById("mynav"+id).className="current";
			}
			else
			{
				document.getElementById("mynav"+id).className="";
			}
		}
	}
</script>
