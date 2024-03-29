<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
response.setHeader("P3P","CP=CAO PSA OUR");  
%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String FrameName=(String)request.getAttribute("FrameName");
String FrameNameVer=(String)request.getAttribute("FrameNameVer");
int MenuStyle=0;
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=FrameName %></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="${ctx}/Manager/Css/Site_Css.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/Manager/inc/FineMessBox/css/subModal.css" />
    <link rel="shortcut icon" href="${ctx}/Manager/images/icon.ico" type="image/x-icon" />
    <script type="text/javascript" src="${ctx}/Manager/inc/FineMessBox/js/common.js"></script>

    <script type="text/javascript" src="${ctx}/Manager/inc/FineMessBox/js/subModal.js"></script>    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css"> 
.navPoint
	{
	font-family: Webdings;
	font-size:9pt;
	color:white;
	cursor:pointer;
	}
p{
	font-size:9pt;
}

.font_size {  font-family: "Verdana", "Arial", "Helvetica", "sans-serif"; font-size: 12px; font-weight: normal; font-variant: normal; text-transform: none}
</style>
</head>
  
  <body scroll="no"  leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
    <table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
        <tr>
            <td width="100%" height="50" colspan="3" style="border-bottom: 1px solid #000000">
                <table height="49" border="0" cellspacing="0" cellpadding="0" width="100%" class="font_size">
                    <tr>
                        <td width="300">
                            <b><%=FrameName %></b><br />
                            <font size="2" color="#999999" face="Verdana, Arial, Helvetica, sans-serif">
                                <%=FrameNameVer %>
                            </font>
                        </td>
                        <td style="background-image: url(${ctx}/Manager/images/top-gray.gif); background-repeat: no-repeat;
                            background-position: right top" valign="bottom">
                            &nbsp;
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <%
    switch (MenuStyle)
    {
        case 0:
        %>
        <tr>
            <td id="frmTitle" name="frmTitle" nowrap="nowrap" valign="middle" align="center"
                width="198" style="border-right: 1px solid #000000">
                <iframe name="BoardTitle" style="height: 100%; visibility: inherit; width: 198; z-index: 2"
                    scrolling="auto" frameborder="0" src="${ctx}/Manager/left.html"></iframe>
            </td>
            <td style="width: 10pt" bgcolor="#7898A8" width="10" title="关闭/打开左栏" class="navPoint">
                <table border="0" cellpadding="0" cellspacing="0" width="11" height="100%" align="right">
                    <tr>
                        <td valign="middle" align="right"  class="middleCss">
                            <img border="0" src="${ctx}/Manager/images/Menu/close.gif" id="menuimg" alt="隐藏左栏" onmouseover="javascript: menuonmouseover();"
                                onmouseout="javascript: menuonmouseout();" onclick="javascript:switchSysBar()"
                                style="cursor: hand" width="11" height="76" /></td>
                    </tr>
                </table>
            </td>
            <td style="width: 100%">
                <iframe id="mainFrame" name="mainFrame" style="height: 100%; visibility: inherit;
                    width: 100%; z-index: 1" scrolling="auto" frameborder="0" src="${ctx}/Manager/right.html"></iframe>
            </td>
        </tr>
        <%
            break;
        case 1:
            
        %>
        <tr>
            <td id="frmTitle" name="frmTitle" nowrap="nowrap" valign="middle" align="center"
                width="115" style="border-right: 1px solid #000000">
                <iframe name="BoardTitle" style="height: 100%; visibility: inherit; width: 100%; z-index: 2"
                    scrolling="no" frameborder="0" src="Menu1.aspx"></iframe>
            </td>
            <td style="width: 10pt" bgcolor="#7898A8" width="10" title="关闭/打开左栏" class="navPoint">
                <table border="0" cellpadding="0" cellspacing="0" width="11" height="100%" align="right">
                    <tr>
                        <td valign="middle" align="right" class="middleCss">
                            <img border="0" src="${ctx}/Manager/images/Menu/close.gif" id="menuimg" alt="隐藏左栏" onmouseover="javascript: menuonmouseover();"
                                onmouseout="javascript: menuonmouseout();" onclick="javascript:switchSysBar()"
                                style="cursor: hand" width="11" height="76" /></td>
                    </tr>
                </table>
            </td>
            <td style="width: 100%">
                <iframe id="Iframe" name="mainFrame" style="height: 100%; visibility: inherit;
                    width: 100%; z-index: 1" scrolling="auto" frameborder="0" src="Manager/right"></iframe>
            </td>
        </tr>
        <%
            break;
            case 2:
        %>
        <tr>
            <td height="51px">
               <iframe name="MainTop" style="height: 100%; visibility: inherit;
                    width: 100%; z-index: 1" scrolling="no" frameborder="0" src="Menu2.aspx"></iframe>
            </td>
        </tr>
        <tr>
            <td style="width: 100%">
                <iframe id="Iframe" name="mainFrame" style="height: 100%; visibility: inherit;
                    width: 100%; z-index: 1" scrolling="auto" frameborder="0" src="Manager/right"></iframe>
            </td>
        </tr>
        <%
            break;
            case 3:
        %>
        <tr>
            <td id="frmTitle" name="frmTitle" nowrap="nowrap" valign="middle" align="center"
                width="198" style="border-right: 1px solid #000000">
                <iframe name="BoardTitle" style="height: 100%; visibility: inherit; width: 198; z-index: 2"
                    scrolling="auto" frameborder="0" src="Menu3.aspx"></iframe>
            </td>
            <td style="width: 10pt" bgcolor="#7898A8" width="10" title="关闭/打开左栏" class="navPoint">
                <table border="0" cellpadding="0" cellspacing="0" width="11" height="100%" align="right">
                    <tr>
                        <td valign="middle" align="right"  class="middleCss">
                            <img border="0" src="${ctx}/Manager/images/Menu/close.gif" id="menuimg" alt="隐藏左栏" onmouseover="javascript: menuonmouseover();"
                                onmouseout="javascript: menuonmouseout();" onclick="javascript:switchSysBar()"
                                style="cursor: hand" width="11" height="76" /></td>
                    </tr>
                </table>
            </td>
            <td style="width: 100%">
                <iframe id="Iframe1" name="mainFrame" style="height: 100%; visibility: inherit;
                    width: 100%; z-index: 1" scrolling="auto" frameborder="0" src="Manager/right"></iframe>
            </td>
        </tr>       
        <%
            break;
        }
        %>
        <tr>
            <td colspan="3" height="20">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" height="20">
                    <tr>
                        <td class="down_text">
                            Powered By <a href="http://www.outletss.com" target="_blank"><font color="#ffffff">outletss.com</font></a>
                            Information Technology Logistics Inc.</td>
                            <td align="right" width="460" bgcolor="#000000">
                            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                <tr>
                                    <td style="cursor:pointer;border-left:1px solid #FFFFFF;" onclick="javascript:showPopWin('About','${ctx}/Manager/about',510, 170, null,false)">&nbsp;<img src="${ctx}/Manager/images/info.gif" style="margin-bottom: -3px">&nbsp;<font color="#FFFFFF">版本信息</font></td>
                                    <td style="cursor:pointer;border-left:1px solid #FFFFFF;" onclick="javascript:showPopWin('登陆日志','${ctx}/Manager/MyLogin',550, 370, null,true,true)">&nbsp;<img src="${ctx}/Manager/images/log.gif" style="margin-bottom: -3px">&nbsp;<font color="#FFFFFF">登陆日志</font></td>
                                    <td style="cursor:pointer;border-left:1px solid #FFFFFF;" onclick="javascript:showPopWin('个人设定','${ctx}/Manager/UserSet?rand'+rand(100000000),400, 255, AlertMessageBox,true)">&nbsp;<img src="${ctx}/Manager/images/userset.gif" style="margin-bottom: -3px">&nbsp;<font color="#FFFFFF">个人设定</font></td>
                                    <td style="cursor:pointer;border-left:1px solid #FFFFFF;" onclick="javascript: window.mainFrame.location.href='${ctx}/Manager/right'">&nbsp;<img src="${ctx}/Manager/images/house.gif" style="margin-bottom: -3px">&nbsp;<font color="#FFFFFF">回到首页</font></td>
                                    <td style="cursor:pointer;border-left:1px solid #FFFFFF;" onclick="javascript: window.top.location.href = '${ctx}/Manager/Logout'">&nbsp;<img src="${ctx}/Manager/images/logout.gif" style="margin-bottom: -3px">&nbsp;<font color="#FFFFFF">退出系统</font></td>
                                    <td style="cursor:pointer;border-left:1px solid #FFFFFF;" onclick="javascript:window.open('http://www.faydrian.com:8081/help/');">&nbsp;<img src="${ctx}/Manager/images/Help.gif" style="margin-bottom: -3px">&nbsp;<font color="#FFFFFF">帮助手册</font></td>
                                </tr>
                            </table>
                            
                            </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
<script language="javascript" type="text/javascript">
var DispClose = true;

function CloseEvent()
{
    if (DispClose)
    {
        return "是否离开当前页面?";
    }
}
　window.onbeforeunload=CloseEvent;
　
　
    rnd.today=new Date(); 

    rnd.seed=rnd.today.getTime(); 

    function rnd() { 

　　　　rnd.seed = (rnd.seed*9301+49297) % 233280; 

　　　　return rnd.seed/(233280.0); 

    }; 

    function rand(number) { 

　　　　return Math.ceil(rnd()*number); 

    }; 
    
    function AlertMessageBox(Messages)
    {
        DispClose = false; 
        alert(Messages);
        setTimeout("reload()",100)
        //window.location.reload();
        //window.location.href = location.href+"?"+rand(1000000);
        
    }
    function reload()
    {
        window.location.href = location.href+"?"+rand(1000000);
    }
    
var var_frmTitle = document.getElementById("frmTitle");
var var_menuimg  = document.getElementById("menuimg");

function switchSysBar(){

 	if (var_frmTitle.style.display=="none") {
		var_frmTitle.style.display=""
		var_menuimg.src="${ctx}/Manager/images/Menu/close.gif";
		var_menuimg.alt="隐藏左栏"
		}
	else {
		var_frmTitle.style.display="none"
		var_menuimg.src="${ctx}/Manager/images/Menu/open.gif";
		var_menuimg.alt="开启左栏"
	 }
	 
	 

}

 function menuonmouseover(){
 		if (var_frmTitle.style.display=="none") {
 		var_menuimg.src="${ctx}/Manager/images/Menu/open_on.gif";
 		}
 		else{
 		var_menuimg.src="${ctx}/Manager/images/Menu/close_on.gif";
 		}
 }
 function menuonmouseout(){
 		if (var_frmTitle.style.display=="none") {
 		var_menuimg.src="${ctx}/Manager/images/Menu/open.gif";
 		}
 		else{
 		var_menuimg.src="${ctx}/Manager/images/Menu/close.gif";
 		}
 }
     if(top!=self)
    {
        top.location.href = "${ctx}/Manager/Main";
    }
   
</script>
</body>
</html>

