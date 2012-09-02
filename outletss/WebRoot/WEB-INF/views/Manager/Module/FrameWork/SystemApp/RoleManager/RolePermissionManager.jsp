<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hedgehog.domain.*"%>
<%@page import="com.hedgehog.Utils.QueryPara"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/rule.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;角色资料管理</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：角色应用权限管理</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='RoleManager.aspx?RoleID=1&CMD=Look';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/look.gif">&nbsp;角色资料</td><td class="menubar_button" id="button_1" OnClick="JavaScript:history.back(-1);" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/back.gif">&nbsp;返回</td></tr></table></td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,1)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>角色应用权限管理</TD>
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
		<tr>
			<td class="table_body">
                角色名称</td>
			<td class="table_none">
                <span id="ctl00_PageBody_RoleName_Txt">${sysRole.rroleName}</span></td>
		</tr>
				<tr>
			<td class="table_body">
                角色所属用户</td>
			<td class="table_none">
                <span id="ctl00_PageBody_RoleUser_Txt">${sysRole.rsysUser.uloginName}</span></td>
		</tr>
		<tr>
			<td class="table_body">
                应用名称</td>
			<td class="table_none">
                <span id="ctl00_PageBody_AppName_Txt">${app.aappName}</span></td>
		</tr>
		</table>
        <DIV ID="rightsTable" ondblclick="javascript:Check_CheckBox(this);">        
        <%
        List<SysRolePermission> list=(List<SysRolePermission>)request.getAttribute("rplist"); 
         if(list.size()>0)
            {
            %>
		<table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
	    
		<tr class = "table_title">
		    <td colspan="9">网站应用</td>
		</tr>
		<tr class = "table_body" align="center"><td width = "18%" align="left">栏目名称</td><td colspan="7" align="left">权限名称</td><td align="left">操作</td></tr>
          
          <%          
           Iterator<SysRolePermission> it=list.iterator();  
           SysRolePermission rolePermission=null; 
int temp=0;
  while(it.hasNext())
  {
     temp++;
    rolePermission=(SysRolePermission)it.next();
    
    %>
    <tr class="table_none" align="center">
                <td align="left">
                   <%=rolePermission.getPpageCode()%>
                    </td>
                <td colspan="7"  align="left">
                    <table id="ctl00_PageBody_Module_Main_ctl00_Module_Sub_ctl00_PermissionList" cellspacing="3" cellpadding="1" border="0" style="width:100%;">
	<tr>
		<td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&2)==2?"allow.gif":"disable.gif"%>'  align='absbottom'/>查看(2)
                        </td><td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&4)==4?"allow.gif":"disable.gif"%>'  align='absbottom'/>新增(4)
                        </td><td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&8)==8?"allow.gif":"disable.gif"%>'  align='absbottom'/>修改(8)
                        </td><td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&16)==16?"allow.gif":"disable.gif"%>'  align='absbottom'/>删除(16)
                        </td>
	</tr><tr>
		<td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&32)==32?"allow.gif":"disable.gif"%>'  align='absbottom'/>排序(32)
                        </td><td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&64)==64?"allow.gif":"disable.gif"%>'  align='absbottom'/>打印(64)
                        </td><td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&128)==128?"allow.gif":"disable.gif"%>'  align='absbottom'/>备用A(128)
                        </td><td>
                            <img src='${ctx}/Manager/images/<%=(rolePermission.getPvalue()&256)==256?"allow.gif":"disable.gif"%>'  align='absbottom'/>备用B(256)
                        </td>
	</tr>
</table>
                </td>                
                <td align="left"><a href="?permissionId=<%=rolePermission.getPermissionId()%>&cmd=edit">编辑</a></td>
            </tr>
    <%  
  }
%>
</table>
		<%
		}
%>
		</DIV>
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
