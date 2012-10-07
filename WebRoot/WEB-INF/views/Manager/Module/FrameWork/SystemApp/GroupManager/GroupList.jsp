<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/Manager/inc/FineMessBox/css/subModal.css" />
<script type="text/javascript" src="${ctx}/Manager/inc/FineMessBox/js/common.js"></script>
<script type="text/javascript" src="${ctx}/Manager/inc/FineMessBox/js/subModal.js"></script>

<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/grouplist.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;部门资料管理</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;请点选左栏的部门名称进行部门资料管理</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：部门资料管理</td>
                <td class='menubar_menu_td' align='right'>
                <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                <td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='Manager?pGroupID=${param.GroupID==null?'2':param.GroupID}&cmd=new';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/new.gif">&nbsp;新增部门</td>
                <td class="menubar_button" id="button_1" OnClick="JavaScript:window.location.href='Orderby.aspx?GroupID=${param.GroupID==null?'2':param.GroupID}';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/orderby.gif">&nbsp;排序子部门</td>
                <c:if test="${param.GroupID!=null&&param.GroupID!=2}">
                <td class="menubar_button" id="button_2" OnClick="JavaScript:window.location.href='Manager?GroupID=${param.GroupID==null?'2':param.GroupID}&cmd=edit';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/edit.gif">&nbsp;修改部门</td>
				<td class="menubar_button" id="button_3" OnClick="JavaScript:sMove('${param.GroupID==null?'2':param.GroupID}&datetime=${date}')" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/move.gif">&nbsp;移动部门</td>
                </c:if>              
				
                </tr>
                </table>
                </td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,1)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>部门资料</TD>
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
        		  <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
						<tr class="table_title">
							<td colspan="2"><span id="ctl00_PageBody_CatListTitle">${grouptitle}</span></td>
						</tr>
						<tr>
							<td class="table_body">
                                部门名称</td>
							<td class="table_none">
								<span id="ctl00_PageBody_CatNameTxt">${sysGroup.gcname}</span></td>
						</tr>
                      <tr>
                          <td class="table_body">
                              子部门数</td>
                          <td class="table_none">
								<span id="ctl00_PageBody_CatCountTxt">${fn:length(sysGroup.subSysGroups)}</span></td>
                      </tr>
						
						<tr>
							<td colspan="2" class="table_title">子部门</td>
						</tr>
						<tr class="table_body">
							<td>部门名称</td><td>子部门数</td>
						</tr>
						<c:if test="${! empty sysGroup.subSysGroups}">
          <c:forEach var="group" items="${sysGroup.subSysGroups}" varStatus="status">
          <option value="${module.moduleId}">${module.mcname}</option>
          <tr class="table_none">
									<td width="50%">${group.gcname}</td>
									<td width="50%">${fn:length(group.subSysGroups)}</td>
								</tr>
          </c:forEach>
          </c:if>
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
<script language="javascript" type="text/javascript">
    function AlertMessageBox(file_name)
    {
       	        if (file_name!=undefined)
                window.location.href = file_name;
    }
        function sMove(a)
        {
            //var file_name=window.showModalDialog("Move.aspx?GroupID="+a,'', "dialogHeight=215px;dialogWidth=255px;help=no")
	        //if (file_name!=undefined){
	        //    window.location.href = file_name
	        //}
	        showPopWin("移动部门","Move.aspx?GroupID="+a,215, 255, AlertMessageBox,true,true)
        }
    </script>
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
