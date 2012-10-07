<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hedgehog.outletss.domain.*"%>
<%@page import="com.hedgehog.outletss.domain.QueryPara"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/log.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;事件日志管理</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：查看事件日志</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='Default.aspx';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/back.gif">&nbsp;返回</td></tr></table></td>
              </tr>
              <tr><td height='5px' colspan='2'></td></tr>
            </table>
        <!-- 头部菜单 End -->
        
    <!-- 选项卡 Start -->
        <TABLE cellSpacing=0 cellPadding=0 width='100%' align=center border=0>   
        <TBODY>   
	        <TR>     
		        <TD style='PADDING-LEFT: 2px; HEIGHT: 22px' background='${ctx}/Manager/images/Menu/tab_top_bg.gif'>
			        <TABLE cellSpacing=0 cellPadding=0 border=0>
				        <TBODY><TR>
                                    <!--按钮　Start-->
                                    <TD >
	        <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		        <TBODY>
                       <TR>
				         <TD width=3><IMG id=tabImgLeft__0 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_left.gif'  width=3></TD>
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,1)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>查看事件日志</TD>
				         <TD width=3><IMG id=tabImgRight__0 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
			           </TR>
		        </TBODY>
	        </TABLE>
        </TD>
                                    <!--按钮 End-->
						        </TR>
				        </TBODY>
			        </TABLE>
		        </TD>
	        </TR>
	        <TR>
	        <TD bgColor=#ffffff>           
		        <TABLE cellSpacing=0 cellPadding=0 width='100%' border=0>
		        <TBODY>
		        <TR>
			        <TD width=1 background='${ctx}/Manager/images/Menu/tab_bg.gif'><IMG  height=1 src='${ctx}/Manager/images/Menu/tab_bg.gif'  width=1></TD>
			        <TD style='PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px' vAlign=top>
        <input type='hidden' ID='FrameWork_YOYO_LzppccSelectIndex' name='FrameWork_YOYO_LzppccSelectIndex' value='0'><!--内容框Start--><DIV id='tabContent__0' style='display:none'>
        <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
		<tr id="ctl00_PageBody_TopTr">
	<td class="table_body">
                ID</td>
	<td class="table_none">
                <span id="ctl00_PageBody_EventID_Txt">${sysEvent.eventId}</span></td>
</tr>
	
            <tr>
	<td class="table_body">
                    事件类型</td>
	<td class="table_none">
                <span id="ctl00_PageBody_E_Type_Txt">${sysEvent.etype==1?"操作日志":"安全日志"}</span>
                </td>
</tr>

            <tr>
	<td class="table_body">
                    用户名</td>
	<td class="table_none">
                    <span id="ctl00_PageBody_E_U_LoginName_Txt">${sysEvent.euLoginName}</span></td>
</tr>

            <tr>
	<td class="table_body">
                    应用名称</td>
	<td class="table_none">
                    <span id="ctl00_PageBody_E_A_AppName_Txt">${sysEvent.eaAppName}</span></td>
</tr>

            <tr>
	<td class="table_body" style="height: 28px">
                    模块名称</td>
	<td class="table_none" style="height: 28px">
                    <span id="ctl00_PageBody_E_M_Name_Txt">${sysEvent.emName}</span></td>
</tr>

            <tr>
	<td class="table_body">
                    IP地址</td>
	<td class="table_none">
                    <span id="ctl00_PageBody_E_IP_Txt"><a href='http://www.yahoo.cn/s?p=${sysEvent.eip}' target='_blank'>${sysEvent.eip}</a></span></td>
</tr>

            <tr>
	<td class="table_body">
                    来源网址</td>
	<td class="table_none">
                    <span id="ctl00_PageBody_E_From_Txt">${sysEvent.efrom}</span></td>
</tr>

            <tr>
	<td class="table_body">
                    详细描述</td>
	<td class="table_none">
                    <span id="ctl00_PageBody_E_Record_Txt">${sysEvent.erecord}</span></td>
</tr>

            <tr>
	<td class="table_body">
                    操作时间</td>
	<td class="table_none">
                    <span id="ctl00_PageBody_E_DateTime_Txt">${sysEvent.edateTime}</span></td>
</tr>

		</table>
        </DIV><!--内容框End-->
			        </TD>
			        <TD width=1 background='${ctx}/Manager/images/Menu/tab_bg.gif'><IMG height=1 src='${ctx}/Manager/images/Menu/tab_bg.gif'  width=1></TD>
		        </TR>
		        </TBODY>
		        </TABLE>
	        </TD>
	        </TR>
	        <TR>
		        <TD background='${ctx}/Manager/images/Menu/tab_bg.gif' bgColor='#ffffff'><IMG height=1 src='${ctx}/Manager/images/Menu/tab_bg.gif' width='1'></TD>
	        </TR>
        </TBODY>
        </TABLE>
        <!--选项卡 End-->
<script language='javascript'>
        function tabClick(idx,count) {
          for (i_tr = 0; i_tr < count; i_tr++) {
            if (i_tr == idx) {
              var tabImgLeft = document.getElementById('tabImgLeft__' + idx);
              var tabImgRight = document.getElementById('tabImgRight__' + idx);
              var tabLabel = document.getElementById('tabLabel__' + idx);
              var tabContent = document.getElementById('tabContent__' + idx);

              tabImgLeft.src = '${ctx}/Manager/images/Menu/tab_active_left.gif';
              tabImgRight.src = '${ctx}/Manager/images/Menu/tab_active_right.gif';
              tabLabel.style.backgroundImage = "url(${ctx}/Manager/images/Menu/tab_active_bg.gif)";
              tabContent.style.visibility = 'visible';
              tabContent.style.display = 'block';
              continue;
            }
            var tabImgLeft = document.getElementById('tabImgLeft__' + i_tr);
            var tabImgRight = document.getElementById('tabImgRight__' + i_tr);
            var tabLabel = document.getElementById('tabLabel__' + i_tr);
            var tabContent = document.getElementById('tabContent__' + i_tr);

            tabImgLeft.src = '${ctx}/Manager/images/Menu/tab_unactive_left.gif';
            tabImgRight.src = '${ctx}/Manager/images/Menu/tab_unactive_right.gif';
            tabLabel.style.backgroundImage = "url(${ctx}/Manager/images/Menu/tab_unactive_bg.gif)";
            tabContent.style.visibility = 'hidden';
            tabContent.style.display = 'none';
          }
          document.getElementById('FrameWork_YOYO_LzppccSelectIndex').value=idx;
        }
        tabClick(0,1);
       </script>
