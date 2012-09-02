<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hedgehog.domain.SysApplication"%>
<%@page import="com.hedgehog.Utils.QueryPara"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;应用模块管理</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：${sysApplication.aappName}</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='List';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/list.gif">&nbsp;应用列表</td><td class="menubar_button" id="button_1" OnClick="JavaScript:window.location.href='ModuleList?S_ID=${sysApplication.applicationId}&AppName=${sysApplication.aappName}';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/list.gif">&nbsp;${sysApplication.aappName}模块列表</td>
                <c:if test="${! empty currentsysModule}"> 
                <td class="menubar_button" id="button_2" OnClick="JavaScript:window.location.href='?cmd=new&mparentId=${currentsysModule.moduleId}&S_ID=${currentsysModule.mapplicationId}';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/new.gif">&nbsp;新增模块</td>
                <td class="menubar_button" id="button_3" OnClick="JavaScript:DelData('?cmd=del&S_ID=${currentsysModule.mapplicationId}&ModuleId=${currentsysModule.moduleId}')" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/delete.gif">&nbsp;删除</td>
                </c:if>
                </tr></table></td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,4)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>应用模块管理-${sysApplication.aappName}->分类管理</TD>
				         <TD width=3><IMG id=tabImgRight__0 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
			           </TR>
		        </TBODY>
	        </TABLE>
        </TD><TD >
	        <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		        <TBODY>
                       <TR>
				         <TD width=3><IMG id=tabImgLeft__1 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_left.gif'  width=3></TD>
				         <TD class=tab id=tabLabel__1 onclick='javascript:tabClick(1,4)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>子模块列表</TD>
				         <TD width=3><IMG id=tabImgRight__1 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
			           </TR>
		        </TBODY>
	        </TABLE>
        </TD><TD style='display:none'>
	        <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		        <TBODY>
                       <TR>
				         <TD width=3><IMG id=tabImgLeft__2 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_left.gif'  width=3></TD>
				         <TD class=tab id=tabLabel__2 onclick='javascript:tabClick(2,4)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>排序模块</TD>
				         <TD width=3><IMG id=tabImgRight__2 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
			           </TR>
		        </TBODY>
	        </TABLE>
        </TD><TD style='display:none'>
	        <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		        <TBODY>
                       <TR>
				         <TD width=3><IMG id=tabImgLeft__3 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_left.gif'  width=3></TD>
				         <TD class=tab id=tabLabel__3 onclick='javascript:tabClick(3,4)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>模块扩展权限定义</TD>
				         <TD width=3><IMG id=tabImgRight__3 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
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
        <form:form modelAttribute="sysModule">
            <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
                <tr>
                    <td class="table_title" colspan="2">
                        <span id="ctl00_PageBody_Title_Txt"><a href='List'>应用列表</a>><a href='ModuleList?S_ID=${sysApplication.applicationId}&AppName=${sysApplication.aappName}'>${sysApplication.aappName}</a><c:if test="${!empty nav}">${nav}</c:if></span>
                    </td>
                </tr>
                <tr id="ctl00_PageBody_TopTr">
	<td class="table_body">
                        <p align="left">
                            所属应用程序</p>
                    </td>
	<td class="table_none">
	<form:hidden path="mapplicationId" />
                        <span id="ctl00_PageBody_M_ApplicationID_Txt">${sysModule.sysApplication.aappName}</span></td>
</tr>

                <tr id="ctl00_PageBody_Tr1">
	<td class="table_body">
                        父级模块</td>
	<td class="table_none">
	<form:hidden path="mparentId" />
                        <span id="ctl00_PageBody_M_ParentID_Txt">
<c:choose>
 <c:when test="${! empty sysModule.parentSysModule}">
${sysModule.parentSysModule.mcname}
</c:when>
<c:otherwise>
无
</c:otherwise>
 </c:choose>   
</span></td>
</tr>

                <tr id="ctl00_PageBody_Tr2">
	<td class="table_body" style="height: 25px">
                        模块编码</td>
	<td class="table_none" style="height: 25px">
                        <form:input path="mpageCode" Cssclass="text_input"/><span class="required">* 必填</span>
                <form:errors path="mpageCode" cssClass="error" />
                        </td>
</tr>

                <tr id="ctl00_PageBody_Tr3">
	<td class="table_body">
                        模块名称</td>
	<td class="table_none">
                      <form:input path="mcname" Cssclass="text_input"/><span class="required">* 必填</span>
                <form:errors path="mcname" cssClass="error" />  
                        </td>
</tr>

                <tr id="ctl00_PageBody_Tr4">
	<td class="table_body" style="height: 25px">
                        模块地址</td>
	<td class="table_none" style="height: 25px">
                      <form:input path="mdirectory" size="50" cssClass="text_input"/>
                <form:errors path="mdirectory" cssClass="error" />  
                       </td>
</tr>

                <tr>
                    <td class="table_body" style="height: 25px">
                        模块Icon</td>
                    <td class="table_none" style="height: 25px">
                        <form:input path="micon" size="50" cssClass="text_input"/>
                <form:errors path="micon" cssClass="error" />
                        </td>
                </tr>
                <tr id="ctl00_PageBody_Tr5">
	<td class="table_body">
                        是否为系统模块</td>
	<td class="table_none">
                 <form:select path="misSystem" disabled=""> 
                 <form:option value="0">否</form:option>
                 <form:option value="1">是</form:option>
                 </form:select>(注:系统模块无法修改删除)</td>
</tr>

                <tr id="ctl00_PageBody_Tr6">
	<td class="table_body">
                        是否关闭</td>
	<td class="table_none">
                        <form:select path="mclose"> 
                 <form:option value="0">否</form:option>
                 <form:option value="1">是</form:option>
                 </form:select></td>
</tr>

                <tr id="ctl00_PageBody_SubmitTr">
	<td colspan="2" align="right">
                        <input type="submit" name="ctl00$PageBody$Button1" value="确定" id="ctl00_PageBody_Button1" class="button_bak" />
                        <input id="Reset1" class="button_bak" type="reset" value="重填" />&nbsp;
                    </td>
</tr>

            </table>
            </form:form>
        </DIV><!--内容框End-->
        <!--内容框Start-->
        <DIV id='tabContent__1' style='display:none'>
            
            <div>
            
            <c:if test="${! empty sysModules}">            
	<table class="table-box" cellspacing="1" border="0" id="ctl00_PageBody_GridView1" style="background-color:White;border-width:0px;">
		<tr class="table_title" align="center">
			<th scope="col">模块名称</th><th scope="col">模块编码</th><th scope="col">模块文件地址</th><th scope="col">子模块</th><th scope="col">系统模块</th><th scope="col">关闭</th>
		</tr>
		<c:forEach var="module" items="${sysModules}" varStatus="status">
		<tr class="${status.count%2==0?"row1":"row"}" align="center" style="height:28px;">
			<td><a href="ModuleManager?cmd=edit&amp;S_ID=${module.mapplicationId}&amp;ModuleId=${module.moduleId}">${module.mcname}</a></td><td>${module.mpageCode}</td><td>${module.mdirectory}</td><td>
                             ${fn:length(module.subsysModules)}
                        </td><td>
                            ${module.misSystem==1?"是":"否"}
                        </td><td>
                            ${module.mclose==1?"是":"否"}
                        </td>
		</tr>
		</c:forEach>	
	</table>
	</c:if>	
</div>
        </DIV><!--内容框End--><!--内容框Start--><DIV id='tabContent__2' style='display:none'></DIV><!--内容框End--><!--内容框Start--><DIV id='tabContent__3' style='display:none'></DIV><!--内容框End-->
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
        tabClick(0,2);
       </script>