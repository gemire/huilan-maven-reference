<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.hedgehog.outletss.domain.SysApplication"%>
<%@page import="com.hedgehog.outletss.domain.SysModule"%>
<%@page import="java.util.List"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>-后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    
    <style type="text/css">
.ttl { CURSOR: pointer; COLOR: #ffffff; PADDING-TOP: 4px }
A:active{COLOR: #000000;TEXT-DECORATION: none}
A:hover{COLOR: #000000;TEXT-DECORATION: none}
A:link{COLOR: #000000;TEXT-DECORATION: none}
A:visited{COLOR: #000000;TEXT-DECORATION: none}
TD {FONT-SIZE: 12px; FONT-FAMILY: "Verdana", "Arial", "细明体", "sans-serif"}
.table_body {BACKGROUND-COLOR: #EDF1F8;height:18px;CURSOR: pointer; }
.table_none {BACKGROUND-COLOR: #FFFFFF;height:18px;CURSOR: pointer; }
</style>

    <script language="javascript">
	        function showHide(obj){
		        var oStyle = document.getElementById(obj).style;
		        oStyle.display == "none" ? oStyle.display = "block" : oStyle.display = "none";
	        }
    </script>

    
  </head>
  
  <body bgcolor="#9aadcd" leftmargin="0" topmargin="0">

    <br>
 <%

	    List<SysModule> list_parentmodule=(List<SysModule>)request.getAttribute("module");//父模块
	    if(list_parentmodule.size()>0)
		{
			for(SysModule pm: list_parentmodule)
			{
				if(pm.getSubsysModules().size()==0)
				{
				  continue;
				}
			//父循环开始
			%>
			
			<table cellspacing="0" cellpadding="0" width="159" align="center" border="0">

                <tr>

                    <td width="23">

                        <img height="25" src="${ctx}/Manager/images/Menu/box_topleft.gif" width="23"></td>

                    <td class="ttl" onclick="JavaScript:showHide('<%="M_"+pm.getModuleId()%>');" width="129"

                        background="${ctx}/Manager/images/Menu/box_topbg.gif">                       

                        <%=pm.getMcname()%>

                    </td>

                    <td width="7">

                        <img height="25" src="${ctx}/Manager/images/Menu/box_topright.gif" width="7"></td>

                </tr>

            </table>
			
			<%
			    List<SysModule> list_childmodule=pm.getSubsysModules();//子模块
				if(list_childmodule.size()>0)
				{
				//开始
				%>
				<table id="<%="M_"+pm.getModuleId()%>" style="display: none" cellspacing="0" cellpadding="0"

                width="159" align="center" border="0">

                <tr>

                    <td background='${ctx}/Manager/images/Menu/box_bg.gif' height="0px" width='159' colspan='3'>

                        <table width="157" border="0" cellpadding="2" cellspacing="1">

                            <tbody>
                            <%
					for(SysModule subm:list_childmodule)
					{
					%>					
					
					<tr>

                                            <td class="table_none" onclick="javascript:NowShow('<%="M_"+subm.getModuleId()%>','${ctx}/<%=subm.getMdirectory()%>');" onmousemove="javascript:TDOverORIn('<%="M_"+subm.getModuleId()%>');" onmouseout="javascript:TDOverOROut('<%="M_"+subm.getModuleId()%>');" id="<%="M_"+subm.getModuleId()%>">

                                                <img height='7' hspace='5' src='${ctx}/Manager/images/Menu/arrow.gif' width='5' align="bottom">

									            <%=subm.getMcname()%>

                                            </td>

                                        </tr>
					<%
					}
					//结尾
					%>
					 </tbody>

                        </table>

                    </td>

                </tr>

            </table>
					<%
				}
				//父循环结尾
				%>
				<table cellspacing="0" cellpadding="0" width="159" align="center" border="0">

                <tr>

                    <td colspan="3">

                        <img height='10' src='${ctx}/Manager/images/Menu/box_bottom.gif' width='159'></td>

                </tr>

            </table>
				<%
			}
		} 
		
  %>
</body>

</html>
<script language="javascript">
    var NowClickName="";
    
        function NowShow(TopMenuName,Url)
    {
        document.getElementById(TopMenuName).className  = "table_body";
        if (NowClickName!="" &&NowClickName!=TopMenuName)
            document.getElementById(NowClickName).className  = "table_none"; 
        NowClickName = TopMenuName;
        //var o=window.open(url); 
       window.parent.frames["mainFrame"].location=Url;
       //parment.mainFrame.src=Url;
    }
    
    function TDOverOROut(iname)
    {
        if (NowClickName!=iname)
        {

            document.getElementById(iname).className = "table_none";

        }
    }
        function TDOverORIn(iname)
    {
        if (NowClickName != iname)
        {
            document.getElementById(iname).className = "table_body";
        }
    }
</script>
