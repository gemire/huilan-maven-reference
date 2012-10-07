<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.hedgehog.outletss.domain.*"%>
<%@page import="com.hedgehog.outletss.domain.QueryPara"%>
<%@page import="java.util.Properties"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/status.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;系统运行状态</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：运行状态</td>
                <td class='menubar_menu_td' align='right'>&nbsp</td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,2)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>系统信息</TD>
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
        <input type='hidden' ID='FrameWork_YOYO_LzppccSelectIndex' name='FrameWork_YOYO_LzppccSelectIndex' value='0'>
		<!--内容框Start-->
		<DIV id='tabContent__0' style='display:none'>
		<%
		Properties props=(Properties)request.getAttribute("props");
		
		 %>
                <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
                    <tr>
                        <td class="table_body">
                            框架版本</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_SystemName"> spring MVC权限管理系统(FrameWork) 1.0.8 Release<font size='2'>(MySql)</font></span></td>
                    </tr>

                    <tr>
                        <td class="table_body">
                            当前在线用户</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_OnlineUser">1</span></td>
                    </tr>
                    
                    <tr>
                        <td class="table_body">
                            服务器操作系统</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_SystemOsName"><%=props.getProperty("os.name")+"-"+props.getProperty("os.version")+"-"+props.getProperty("os.arch")%></span></td>
                    </tr>                    
                    <tr >
                        <td class="table_body">
                            服务器运行时间</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_SystemRunTime">11天 12小时 40分 3秒</span></td>
                    </tr>
                    <tr >
                        <td class="table_body">
                            应用运行时间</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_AppRunTime">0天 1小时 7分 54秒</span></td>
                    </tr>
                                        
                       
                    <tr >
                        <td class="table_body">
         Java 安装目录</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_CacheNum"><%=props.getProperty("java.home")%></span></td>
                    </tr>
                    <tr>
                        <td class="table_body">
          Java 运行时环境版本</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_CacheUseClass"><%=props.getProperty("java.version")%></span></td>
                    </tr>
                    <tr >
                        <td class="table_body">
          Java 虚拟机实现名称</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_AppRunMemony"><%=props.getProperty("java.vm.name")%></span></td>
                    </tr>
                                                            <tr >
                        <td class="table_body">
          Java 类格式版本号</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_AppRunVirtualMemony"><%=props.getProperty("java.class.version")%></span></td>
                    </tr>
                    <tr>
                        <td class="table_body">
                      用户的账户名称</td>
                        <td class="table_none">
                            <span><%=props.getProperty("user.name")%></span></td>
                    </tr>
                    <tr>
                        <td class="table_body">
                       用户的当前工作目录</td>
                        <td class="table_none">
                            <span id="ctl00_PageBody_CacheMax"><%=props.getProperty("user.dir")%></span></td>
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
