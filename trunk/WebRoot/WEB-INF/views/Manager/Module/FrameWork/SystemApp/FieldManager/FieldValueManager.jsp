<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hedgehog.domain.*"%>
<%@page import="com.hedgehog.Utils.QueryPara"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/Manager/inc/FineMessBox/css/subModal.css" />
<script type="text/javascript" src="${ctx}/Manager/inc/FineMessBox/js/common.js"></script>
<script type="text/javascript" src="${ctx}/Manager/inc/FineMessBox/js/subModal.js"></script>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/FieldManager.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;应用字段设定</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：应用字段管理</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='Default';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/list.gif">&nbsp;列表应用字段</td><td class="menubar_button" id="button_1" OnClick="JavaScript:window.location.href='FieldValueManagerForm?cmd=edit&fieldId=${sysField.fieldId}';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/edit.gif">&nbsp;修改应用字段</td><td class="menubar_button" id="button_2" OnClick="JavaScript:showPopWin('应用字段值增加','FieldValueBox?fieldId=${sysField.fieldId}&cmd=new&rand(10000000)', 300, 160, AlertMessageBox,true);" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/new.gif">&nbsp;新增应用字段值</td><td class="menubar_button" id="button_3" OnClick="JavaScript:showPopWin('应用字段值排序','FieldValueBox.aspx?F_Key=newscate&CMD=OrderBy&1610447', 180, 210, AlertMessageBox,true);" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/orderby.gif">&nbsp;排序应用字段值</td></tr></table></td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,1)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>应用字段管理</TD>
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
	<td class="table_body" style="width: 25%; height: 28px">
                    应用字段Key</td>
	<td class="table_none" style="height: 28px" colspan="2">
                    
                    <span id="ctl00_PageBody_F_Key_Txt">${sysField.fkey}</span></td>
</tr>

            <tr>
	<td class="table_body" style="width: 25%">
                    应用字段名称</td>
	<td class="table_none" colspan="2">
                    
                    <span id="ctl00_PageBody_F_CName_Txt">${sysField.fcname}</span></td>
</tr>

            <tr>
	<td class="table_body" style="width: 25%">
                    应用字段说明</td>
	<td class="table_none" colspan="2">
                    
                    <span id="ctl00_PageBody_F_Remark_Txt">${sysField.fremark}</span></td>
</tr> 
		    <div id="ctl00_PageBody_Disp_Sub">
            <tr class = "table_title">
		        <td>ID</td>
		        <td style="height: 30px">应用字段值列表(点击字段值进行管理)</td>
		        <td>应用字段编码</td>
		    </tr>	
		    
		    <c:if test="${! empty sysField.sysFieldValues}">
		    <c:forEach var="fv" items="${sysField.sysFieldValues}" varStatus="status">		
		 <tr class="table_none" onmouseout="javascript:this.className='table_none'" onmouseover="javascript:this.className='table_body'">
		                <td>${fv.valueId}</td>
		                <td title="点击此处进行字段管理" style="cursor:pointer" onclick="javascript:showPopWin('应用字段值修改','FieldValueBox?cmd=edit&fieldId=${fv.sysField.fieldId}&valueId=${fv.valueId}&'+rand(10000000), 300, 160, AlertMessageBox,true);">
		                   ${fv.vtext}
		                </td>
		                <td>${fv.vcode}</td>
		            </tr>
   </c:forEach> 
		    </c:if>
</div>
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

    // end central randomizer. --> 
    function AlertMessageBox(Messages)
    {
        alert(Messages);
         setTimeout("reload()",100)
    }
    
        function reload()
    {
        window.location.href = location.href+"&?"+rand(1000000);
    }
    
    var gDefaultLogin = "${ctx}/Manager/inc/finemessbox/loading.html";    
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