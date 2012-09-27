<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hedgehog.outletss.domain.SysApplication"%>
<%@page import="com.hedgehog.outletss.Utils.QueryPara"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;应用模块管理</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;点击模块名称进入管理</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：应用模块管理</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='List';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/list.gif">&nbsp;应用列表</td><td class="menubar_button" id="button_1" OnClick="JavaScript:window.location.href='ModuleManager?cmd=new&S_ID=${S_ID}&mparentId=${ModuleId}';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/new.gif">&nbsp;新增模块分类</td></tr></table></td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,2)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>应用列表->${AppName}</TD>
				         <TD width=3><IMG id=tabImgRight__0 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
			           </TR>
		        </TBODY>
	        </TABLE>
        </TD><TD >
	        <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		        <TBODY>
                       <TR>
				         <TD width=3><IMG id=tabImgLeft__1 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_left.gif'  width=3></TD>
				         <TD class=tab id=tabLabel__1 onclick='javascript:tabClick(1,2)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>模块分类排序</TD>
				         <TD width=3><IMG id=tabImgRight__1 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
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
            
            <div>
            <c:if test="${! empty childmodule}">
            <table class="table-box" cellspacing="1" border="0" id="ctl00_PageBody_GridView1" style="background-color:White;border-width:0px;">
		<tr class="table_title" align="center">
			<th scope="col">模块分类名称</th><th scope="col">模块分类编码</th><th scope="col">模块数</th><th scope="col">系统模块</th><th scope="col">关闭</th>
		</tr>
		<c:forEach var="module" items="${childmodule}" varStatus="status">
		<tr class="${status.count%2==0?"row1":"row"}" align="center" style="height:28px;">
			<td><a href="ModuleManager?cmd=edit&amp;S_ID=${module.mapplicationId}&amp;ModuleId=${module.moduleId}">${module.mcname}</a></td><td>${module.mpageCode}</td><td>
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
	            
        
        </DIV><!--内容框End-->
		<!--内容框Start-->
		<DIV id='tabContent__1' style='display:none'>
		
		<table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">		
          <tr class="table_none">
            <td align="center">
                <table >
                <tr>
                    <td> 
          <select size="2" multiple="multiple" id="ctl00_PageBody_OrderByListItems" style="height:160px;width:120px;">
          <c:if test="${! empty childmodule}">
          <c:forEach var="module" items="${childmodule}" varStatus="status">
          <option value="${module.moduleId}">${module.mcname}</option>
          </c:forEach>
          </c:if>	
          </select>
          </td>
                    <td>
                       	<img border="0" src="${ctx}/Manager/images/up01.gif" OnClick="javascript:moveUpDown('up','ctl00_PageBody_OrderByListItems');" style="cursor:pointer;">
    			        <p><img border="0" src="${ctx}/Manager/images/down01.gif" OnClick="javascript:moveUpDown('down','ctl00_PageBody_OrderByListItems');" style="cursor:pointer;">
                    </td>
                </tr>
                </table>
                
            </td>
          </tr>
          <tr><td align="right">
          <input type="submit" name="ctl00$PageBody$Button1" value="确定" onclick="selectAll(ctl00_PageBody_OrderByListItems);" id="ctl00_PageBody_Button1" class="button_bak" />
          </td></tr>          
          </table>

       </DIV>
	   <!--内容框End-->
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
