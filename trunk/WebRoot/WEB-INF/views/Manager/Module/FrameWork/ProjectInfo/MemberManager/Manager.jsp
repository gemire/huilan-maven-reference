<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/applist.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;索娱艺人</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：修改索娱艺人</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='List';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/list.gif">&nbsp;列表索娱艺人</td><td class="menubar_button" id="button_1" OnClick="JavaScript:DelData('?cmd=del&IDX=626')" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/delete.gif">&nbsp;删除索娱艺人</td></tr></table></td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,1)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>修改索娱艺人</TD>
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
            
            <form:form modelAttribute="syMember">
            <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">

                <tr>
                    <td class="table_body" style="width: 18%">
                        用户ID</td>
                    <td class="table_none">
       <form:hidden path="memberAccount" cssClass="text_input"/>${syMember.memberAccount} 
                        </td>
                </tr>
                
                <tr>
                    <td class="table_body" style="width: 18%">
                        密码</td>
                    <td class="table_none">
                    <form:password path="memberPwd" cssClass="text_input"/>      
       <form:errors path="memberPwd" cssClass="error" />
         <span class="red">(如果不修改，请保持为空)</span> 
                        </td>
                </tr>
                
                <tr>
                    <td class="table_body" style="width: 18%">
                       邮箱地址</td>
                    <td class="table_none">                     
                        <form:input path="memberEmail" cssClass="text_input" cssStyle="width:255px;"/>      
       <form:errors path="memberEmail" cssClass="error" />
                        </td>
                </tr>

                <tr>
                    <td class="table_body" style="width: 18%">
                        姓名</td>
                    <td class="table_none">
                    <form:input path="memberName" cssClass="text_input" maxlength="8"/>      
       <form:errors path="memberName" cssClass="error" />
                        </td>
                </tr>                
                
                
                <tr>
                    <td class="table_body" style="width: 18%">
                        性别</td>
                    <td class="table_none">
                    <label>
       <form:radiobutton path="memberSex" value="0"/>  
       </label>
       男
       <label>
       <form:radiobutton path="memberSex" value="1"/>
       </label>
       女
       
                        </td>
                </tr>

                <tr>
                    <td class="table_body" style="width: 18%">
                        个人说明</td>
                    <td class="table_none">                    
       <form:textarea path="memberMark" cssClass="text_input" cssStyle="height:95px;width:500px;"/>                    
                <form:errors path="memberMark" cssClass="error" />                    
                        </td>
                </tr>
                
                
                
                <tr>
                    <td class="table_body" style="width: 18%">
                        首页显示</td>
                    <td class="table_none">
       <label>
       <form:radiobutton path="memberShow" value="1" cssClass="text_input" />  
       </label>
      可见
       <label>
       <form:radiobutton path="memberShow" value="0" cssClass="text_input" />
       </label>
       不可见                  
                        </td>
                </tr>
                
                              
                <tr id="ctl00_PageBody_ButtonOption">
	<td align="right" colspan="2">
                        <input type="submit" name="ctl00$PageBody$Button1" value="确定" onclick="return check1();" id="ctl00_PageBody_Button1" class="button_bak" />
                        <input id="Reset1" class="button_bak" type="reset" value="重填" />
                    </td>
</tr>

            </table>
            </form:form>
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
 <!--<ckeditor:replace  replace="newsContent" basePath="../ckeditor/" />-->
<script type="text/javascript">//<![CDATA[
window.CKEDITOR_BASEPATH='/resources/ckeditor/';
//]]></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js?t=B37D54V"></script>
<script type="text/javascript" src="/resources/ckfinder/ckfinder.js"></script>
<script type="text/javascript"> 
<!--
                function BrowseServer(inputId)
                {
                var finder = new CKFinder() ;
                finder.basePath = '/resources/ckfinder/';  //导入CKFinder的路径
                finder.selectActionFunction = SetFileField; //设置文件被选中时的函数
                finder.selectActionData = inputId;  //接收地址的input ID
                finder.popup() ;
                }
                
                //文件选中时执行
                function SetFileField(fileUrl,data)
                {
                    document.getElementById(data["selectActionData"]).value = fileUrl ;
                }
                function Validate()
				  {
					 var image =document.getElementById("fileData").value;
					 if(image!=''){
						  var checkimg = image.toLowerCase();
						  if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
							  alert("Please enter  Image  File Extensions .jpg,.png,.jpeg");
							  document.getElementById("fileData").focus();
							  return false;
						    }
						 }
					 return true;
				 }			
                // -->
            </script>
