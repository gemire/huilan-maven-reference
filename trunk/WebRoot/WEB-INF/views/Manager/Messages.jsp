<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>${mbx._M_Title}</title>
<link rel="stylesheet" href="${ctx}/Manager/Css/Site_Css.css" type="text/css" />
<link rel="shortcut icon" href="${ctx}/Manager/images/icon.ico" type="image/x-icon" />
<style type="text/css">
<!--
.style3 {
	font-size: 18px;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#EEEEEE" Scroll="no">
<div>
  <table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr height="20%">
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td align="center" valign="top"><table width="200" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="48" valign="middle" background="${ctx}/Manager/images/MessageIcon/MessageHead.gif"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="7%" height="8"></td>
                  <td width="93%" align="left"></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td align="left"><span class="style3">${mbx._M_Title}</span></td>
                </tr>
              </table></td>
          </tr>
          <tr>
            <td background="${ctx}/Manager/images/MessageIcon/MessageBody.gif"><table width="100%" style="table-layout:fixed;"  border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="6%">&nbsp;</td>
                  <td width="11%" height="120"><img src="${ctx}/Manager/images/MessageIcon/Message${mbx._M_IconType}.gif"></td>
                  <td width="77%" align="left"><table width="100%"  border="0" cellspacing="10" cellpadding="0">
                      <tr>
                        <td style="word-break : break-all; ">${mbx._M_Body}</td>
                      </tr>
                    </table></td>
                  <td width="6%">&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td align="left"><c:if test="${! empty mbx._M_ButtonList}">
                      <c:forEach var="item" items="${mbx._M_ButtonList}" varStatus="status">
                        <input type='button' ID='Message_Button${status.count-1}' class='button_bak' onClick="JavaScript:window.location.href='${ctx}/${item._btnUrl}';" value='${item._btnText}' title='${item._btnHint}'/>
                      </c:forEach>
                    </c:if>
                  </td>
                  <td>&nbsp;</td>
                </tr>
              </table></td>
          </tr>
          <tr>
            <td><img src="${ctx}/Manager/images/MessageIcon/MessageEnd.gif" width="459" height="29" /></td>
          </tr>
        </table></td>
    </tr>
  </table>
</div>
<script type="text/javascript">
//<![CDATA[
document.getElementById('Message_Button0').focus();//]]>
</script>
</body>
${mbx._M_ReturnScript}
</html>
