<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String FrameName=(String)request.getAttribute("FrameName");
String FrameNameVer=(String)request.getAttribute("FrameNameVer");
%>

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
<link rel="shortcut icon" href="${ctx}/Manager/images/Icon.ico" type="image/x-icon" />
    <script language="javascript" src="${ctx}/Manager/js/checkform.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
var $j=jQuery.noConflict(); 
$j(function(){           
            $j('#kaptchaImage').click(function () {//生成验证码  
             $j(this).hide().attr('src', '/captcha-image?' + Math.floor(Math.random()*100) ).fadeIn(); })      
                  });   
</script>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
  </head>
<body scroll="no" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
    <table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
        <tr>
            <td width="100%" height="50" colspan="3" style="border-bottom: 1px solid #000000">
                <table height="49" border="0" cellspacing="0" cellpadding="0" width="100%" class="font_size">
                    <tr>
                        <td style="background-image: url(${ctx}/Manager/images/top-gray.gif); background-repeat: no-repeat;
                            background-position: right top">
                            <b>
                                <%=FrameName %>
                            </b>
                            <br />
                            <font size="2" color="#999999" face="Verdana, Arial, Helvetica, sans-serif">
                                <%=FrameNameVer %>
                            </font>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="3">
            <c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
            <form name='f' action="<c:url value='openv-login'/>" method='POST'>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
                

                        <tr>
                            <td>
                                <table width="431" border="0" cellpadding="0" cellspacing="0" align="center">
                                    <tr>
                                        <td colspan="2" background="${ctx}/Manager/images/logon/Logon_1.gif" width="431" height="125">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <img src="${ctx}/Manager/images/logon/Logon_2.gif" width="431" height="30" alt="" /></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img src="${ctx}/Manager/images/logon/Logon_3.gif" width="194" height="28" alt="" /></td>
                                        <td background="${ctx}/Manager/images/logon/Logon_4.gif" width="237">
                                        <input type='text' name='j_username' value='' class="text_input" style="width:138px;">
                                            </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img src="${ctx}/Manager/images/logon/Logon_5.gif" width="194" height="24" alt="" /></td>
                                        <td background="${ctx}/Manager/images/logon/Logon_6.gif">
                                        <input type='password' name='j_password' class="text_input" style="width:138px;"/>
                                             </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <img src="${ctx}/Manager/images/logon/Logon_7no.gif" id="Logincode_op" width="194" height="25" /></td>
                                        <td rowspan="3" background="${ctx}/Manager/images/logon/Logon_18.jpg" valign="top">
                                            <table border="0" cellpadding="0" cellspacing="0">
                                                 <tr>   <td height="3">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="submit"  value="确定" id="ctl00_PageBody_Button1" class="button_bak"/> &nbsp;

<input id="Reset1" class="button_bak" type="reset" value="重填"/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img src="${ctx}/Manager/images/logon/Logon_9.gif" width="194" height="40" alt="" /></td>
                                    </tr>
                                    <tr>
                                        <td height="39" background="${ctx}/Manager/images/logon/Logon_11.gif">
                                            </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <b>提醒 : </b>本管理系统建议议采用Internet Explorer 5.5 (或以上版本) 的浏览器。请开启浏览器的 Cookies 与 JavaScript
                                            功能。</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>                    
                </table>
                </form>
            </td>
        </tr>
        <tr>
            <td colspan="3" height="20">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" height="20">
                    <tr>
                        <td class="down_text">
                            Powered By <a href="http://www.supesoft.com" target="_blank"><font color="#ffffff">Supesoft.com</font></a>
                            Information Technology Logistics Inc.</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
  </body>
  <script language="JavaScript" type="text/javascript"><!-- 

    // The Central Randomizer 1.3 (C) 1997 by Paul Houle (houle@msc.cornell.edu) 

    // See: http://www.msc.cornell.edu/~houle/javascript/randomizer.html 

    rnd.today=new Date(); 

    rnd.seed=rnd.today.getTime(); 

    function rnd() { 

　　　　rnd.seed = (rnd.seed*9301+49297) % 233280; 

　　　　return rnd.seed/(233280.0); 

    }; 

    function rand(number) { 

　　　　return Math.ceil(rnd()*number); 

    }; 
    
    if(top!=self)
    {
        top.location.href = "${ctx}/Manager/Login";
    }
    //alert(navigator.appVersion);
    if(navigator.appVersion.indexOf("MSIE")   ==   -1   ){   
        //alert("提醒 : 本管理系统建议议采用Internet Explorer 5.5 (或以上版本) 的浏览器。请开启浏览器的 Cookies 与 JavaScript 功能。");   
    }   

    // end central randomizer. --> 

</script>
</html>
