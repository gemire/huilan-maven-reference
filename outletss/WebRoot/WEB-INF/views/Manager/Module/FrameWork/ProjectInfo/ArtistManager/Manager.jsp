<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url var="rpath" value="/resources/Manager" />
<script language="javascript" type="text/javascript" src="${rpath}/js/PopupCalendar.js"></script>

    <script type="text/javascript">

//    var oCalendarEn=new PopupCalendar("oCalendarEn");	//初始化控件时,请给出实例名称如:oCalendarEn
//    oCalendarEn.Init();
    var oCalendarChs=new PopupCalendar("oCalendarChs");	//初始化控件时,请给出实例名称:oCalendarChs
    oCalendarChs.weekDaySting=new Array("日","一","二","三","四","五","六");
    oCalendarChs.monthSting=new Array("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月");
    oCalendarChs.oBtnTodayTitle="今天";
    oCalendarChs.oBtnCancelTitle="取消";
    oCalendarChs.Init();
    </script>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${rpath}/images/ICON/applist.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;索娱作品</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${rpath}/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：修改索娱作品</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='List';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${rpath}/images/ICON/list.gif">&nbsp;列表索娱作品</td><td class="menubar_button" id="button_1" OnClick="JavaScript:DelData('?cmd=del&IDX=626')" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${rpath}/images/ICON/delete.gif">&nbsp;删除索娱作品</td></tr></table></td>
              </tr>
              <tr><td height='5px' colspan='2'></td></tr>
            </table>
        <!-- 头部菜单 End -->
        
    <!-- 选项卡 Start -->
        <TABLE cellSpacing=0 cellPadding=0 width='100%' align=center border=0>   
        <TBODY>   
	        <TR>     
		        <TD style='PADDING-LEFT: 2px; HEIGHT: 22px' background='${rpath}/images/Menu/tab_top_bg.gif'>
			        <TABLE cellSpacing=0 cellPadding=0 border=0>
				        <TBODY><TR>
                                    <!--按钮　Start-->
                                    <TD >
	        <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		        <TBODY>
                       <TR>
				         <TD width=3><IMG id=tabImgLeft__0 height=22 src='${rpath}/images/Menu/tab_unactive_left.gif'  width=3></TD>
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,1)' background='${rpath}/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>修改蛙跳资讯</TD>
				         <TD width=3><IMG id=tabImgRight__0 height=22 src='${rpath}/images/Menu/tab_unactive_right.gif' width=3></TD>
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
			        <TD width=1 background='${rpath}/images/Menu/tab_bg.gif'><IMG  height=1 src='${rpath}/images/Menu/tab_bg.gif'  width=1></TD>
			        <TD style='PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px' vAlign=top>
        <input type='hidden' ID='FrameWork_YOYO_LzppccSelectIndex' name='FrameWork_YOYO_LzppccSelectIndex' value='0'><!--内容框Start--><DIV id='tabContent__0' style='display:none'>
            
            <form:form modelAttribute="syArtist">
            <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">

                <tr>
                    <td class="table_body" style="width:15%">
                        歌手</td>
                    <td class="table_none" style="width:35%">
                     <form:input path="artistAuthor" cssClass="text_input" cssStyle="width:150px;"/>
                <form:errors path="artistAuthor" cssClass="error" />
                        
                    
                  </td>
                        <td class="table_body" style="width:15%">
                        歌手类型</td>
                    <td  class="table_none">
                     <form:select path="artistNsort" cssClass="text_input" cssStyle="width:100px;">
                    <form:option value="">请选择歌手类型</form:option>
                    <form:options items="${artistnsortlist}" itemValue="valueId" itemLabel="vtext"/>
                    </form:select>                                     
                <form:errors path="artistNsort" cssClass="error" />
                        
                    
                  </td>
                </tr>
                
                <tr>
                    <td class="table_body" style="width:15%">
                        地区</td>
                    <td class="table_none" style="width:35%">                   
                     <form:select path="artistArea" cssClass="text_input" cssStyle="width:100px;">
                    <form:option value="">请选择地区</form:option>
                    <form:options items="${artistarealist}" itemValue="valueId" itemLabel="vtext"/>
                    </form:select>    
                <form:errors path="artistArea" cssClass="error" />
                        
                    
                        </td>
                        <td class="table_body" style="width:15%">
                        公司</td>
                    <td class="table_none">
                    <form:input path="artistCompany" cssClass="text_input" cssStyle="width:200px;"/>                                                     
                <form:errors path="artistCompany" cssClass="error" />
                        
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body" style="width:15%">
                        歌手图片</td>
                    <td class="table_none" colspan="3">
                    <form:input path="artistPicpath" cssClass="text_input" cssStyle="width:255px;"/>
                    <input type="button" value=" 浏 览 " class="button_bak" onClick="BrowseServer('artistPicpath');" />
                <form:errors path="artistPicpath" cssClass="error" />
                                   
                       
                        
                        </td>
                </tr>
                
                <tr>
                    <td class="table_body" style="width:15%">
                        专辑名称</td>
                    <td class="table_none" style="width:35%">
                     <form:input path="artistZname" cssClass="text_input" cssStyle="width:200px;"/>
                <form:errors path="artistZname" cssClass="error" />
                        
                    
                        </td>
                        <td class="table_body" style="width:15%">
                        专辑类型</td>
                    <td class="table_none">
                     <form:select path="artistZsort" cssClass="text_input" cssStyle="width:100px;">
                    <form:option value="">请选择专辑类型</form:option>
                    <form:options items="${artistzsortlist}" itemValue="valueId" itemLabel="vtext"/>
                    </form:select>                                     
                <form:errors path="artistZsort" cssClass="error" />
                        
                    
                        </td>
                </tr>
<tr>
                    <td class="table_body" style="width:15%">
                        语种</td>
                    <td class="table_none" style="width:35%">
                     <form:select path="artistLsort" cssClass="text_input" cssStyle="width:100px;">
                    <form:option value="">请选择语种</form:option>
                    <form:options items="${artistlsortlist}" itemValue="valueId" itemLabel="vtext"/>
                    </form:select>    
                     
                <form:errors path="artistLsort" cssClass="error" />
                        
                    
                        </td>
                        <td class="table_body" style="width:15%">
                        音乐类型</td>
                    <td class="table_none">
                     <form:select path="artistMsort" cssClass="text_input" cssStyle="width:100px;">
                    <form:option value="">请选择音乐类型</form:option>
                    <form:options items="${artistmsortlist}" itemValue="valueId" itemLabel="vtext"/>
                    </form:select>                                     
                <form:errors path="artistMsort" cssClass="error" />
                        
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body" style="width:15%">
                        作品分类</td>
                    <td class="table_none" style="width:35%">
                    <form:select path="artistSort" cssClass="text_input" cssStyle="width:100px;">
                    <form:option value="">请选择作品分类</form:option>
                    <form:options items="${artistsortlist}" itemValue="valueId" itemLabel="vtext"/>
                    </form:select>                     
                <form:errors path="artistSort" cssClass="error" />
                        
                    
                        </td>
                        <td class="table_body" style="width:15%">
                        发行时间</td>
                    <td class="table_none">
                    <form:input path="artistPublish" cssClass="text_input" cssStyle="width:100px;" onclick="return getDateString(this,oCalendarChs)"/>                                                       
                <form:errors path="artistPublish" cssClass="error" />
                        
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body" style="width:15%">
                        专辑曲目</td>
                    <td class="table_none" colspan="3">
                    <form:textarea path="artistList" cssClass="text_input" cssStyle="height:95px;width:500px;"/>                    
                <form:errors path="artistList" cssClass="error" />
                                   
                       
                        
                        </td>
                </tr>
                <tr>
                    <td class="table_body" style="width:15%">
                        基本情况</td>
                    <td class="table_none" colspan="3">
                    <form:textarea path="artistContent" cssClass="text_input"/>
                <form:errors path="artistContent" cssClass="error" />
                                   
                       
                        
                        </td>
                </tr>                
                
                <tr>
                    <td class="table_body" style="width:15%">
                        摘要</td>
                    <td class="table_none" colspan="3">
                     <form:input path="artistSummery" cssClass="text_input" cssStyle="height:95px;width:500px;"/>
                <form:errors path="artistSummery" cssClass="error" />
                        
                    
                        </td>
                </tr>

                <tr>
                    <td class="table_body" style="width:15%">
                        Tags标签</td>
                    <td class="table_none" colspan="3">
                     
                         <form:input path="artistKeywords" cssClass="text_input" cssStyle="width:255px;"/>
                <form:errors path="artistKeywords" cssClass="error" />
                    
                        </td>
                </tr>
                              
                <tr id="ctl00_PageBody_ButtonOption">
	<td align="right" colspan="4">
                        <input type="submit" name="ctl00$PageBody$Button1" value="确定" onClick="return check1();" id="ctl00_PageBody_Button1" class="button_bak" />
                        <input id="Reset1" class="button_bak" type="reset" value="重填" />
                    </td>
</tr>

            </table>
            </form:form>
        </DIV><!--内容框End-->
			        </TD>
			        <TD width=1 background='${rpath}/images/Menu/tab_bg.gif'><IMG height=1 src='${rpath}/images/Menu/tab_bg.gif'  width=1></TD>
		        </TR>
		        </TBODY>
		        </TABLE>
	        </TD>
	        </TR>
	        <TR>
		        <TD background='${rpath}/images/Menu/tab_bg.gif' bgColor='#ffffff'><IMG height=1 src='${rpath}/images/Menu/tab_bg.gif' width='1'></TD>
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

              tabImgLeft.src = '${rpath}/images/Menu/tab_active_left.gif';
              tabImgRight.src = '${rpath}/images/Menu/tab_active_right.gif';
              tabLabel.style.backgroundImage = "url(${rpath}/images/Menu/tab_active_bg.gif)";
              tabContent.style.visibility = 'visible';
              tabContent.style.display = 'block';
              continue;
            }
            var tabImgLeft = document.getElementById('tabImgLeft__' + i_tr);
            var tabImgRight = document.getElementById('tabImgRight__' + i_tr);
            var tabLabel = document.getElementById('tabLabel__' + i_tr);
            var tabContent = document.getElementById('tabContent__' + i_tr);

            tabImgLeft.src = '${rpath}/images/Menu/tab_unactive_left.gif';
            tabImgRight.src = '${rpath}/images/Menu/tab_unactive_right.gif';
            tabLabel.style.backgroundImage = "url(${rpath}/images/Menu/tab_unactive_bg.gif)";
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
<script type="text/javascript">//<![CDATA[
var editor=CKEDITOR.replace('artistContent',{toolbar:'Basic'});
// Just call CKFinder.setupCKEditor and pass the CKEditor instance as the first argument.
	// The second parameter (optional), is the path for the CKFinder installation (default = "/ckfinder/").
	CKFinder.setupCKEditor( editor, '/resources/ckfinder/' ) ;

	// It is also possible to pass an object with selected CKFinder properties as a second argument.
	// CKFinder.setupCKEditor( editor, { basePath : '../', skin : 'v1' } ) ;
//]]></script>