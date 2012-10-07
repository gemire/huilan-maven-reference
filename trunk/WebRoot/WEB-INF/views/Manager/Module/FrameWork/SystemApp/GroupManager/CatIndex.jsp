<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html >
<head id="Head1">
    <title>无标题页</title>
    <base target="_self"></base>
    <style> .FolderStyle { COLOR: #000000; TEXT-DECORATION: none } </style>

    <link rel="stylesheet" href="${ctx}/Manager/Css/Site_Css.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/<s:theme code='styleSheet'/>" type="text/css">
</head>
<body>
<table width='100%' cellpadding="0" cellspacing="0" border="0">
	<tr >
		<td class="table_title">
			<img src="${ctx}/Manager/images/TreeIcon/refurbish.gif" border="0" align="absMiddle" onclick="javascript:window.location.reload();" title="刷新" style="cursor:pointer">&nbsp;<a href="javascript:disp_all();">展开/收起</a>
		</td>
	</tr>
</table>
<script language="javascript">
var TreeImgdir = "${ctx}/Manager/images/TreeIcon/";
</script>
<script src="${ctx}/Manager/js/Tree.js"></script>


<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td width="100%" bgcolor="#ffffff" valign="top" style="PADDING-LEFT:5px">
${outjs}
		</td>
	</tr>
</table>

<script language="javascript">
var close_id=1
function disp_all()
{
var d_i;
if (close_id==1)
{
close_id=0
dim_src=Fold_id.split(",");
for (d_i = 1; d_i < dim_src.length; d_i=d_i+2)
   {
   if (dim_src[d_i] !='')
     {
      clickOnNode(dim_src[d_i]);
	 }
   }
}
else
{
clickOnNode(0); 
close_id=1 
} 
clickOnNode(0); 
} 
disp_all();
</script>

</body>
</html>

