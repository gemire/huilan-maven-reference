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
                <td height='27px' class='menubar_function_text'>目前操作功能：事件日志列表</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='?CMD=DownLoad';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/list.gif">&nbsp;导出日志</td><td class="menubar_button" id="button_1" OnClick="JavaScript:ClearData()" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/delete.gif">&nbsp;清空日志</td></tr></table></td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,2)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>日志列表</TD>
				         <TD width=3><IMG id=tabImgRight__0 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_right.gif' width=3></TD>
			           </TR>
		        </TBODY>
	        </TABLE>
        </TD><TD >
	        <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		        <TBODY>
                       <TR>
				         <TD width=3><IMG id=tabImgLeft__1 height=22 src='${ctx}/Manager/images/Menu/tab_unactive_left.gif'  width=3></TD>
				         <TD class=tab id=tabLabel__1 onclick='javascript:tabClick(1,2)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>查询</TD>
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
        <input type='hidden' ID='FrameWork_YOYO_LzppccSelectIndex' name='FrameWork_YOYO_LzppccSelectIndex' value='0'><!--内容框Start--><DIV id='tabContent__0' style='display:none'>
            <div>
            <%
            List<SysEvent> list=(List<SysEvent>)request.getAttribute("list"); 
  QueryPara<SysEvent> qp=(QueryPara<SysEvent>)request.getAttribute("queryPara"); 
  int pagecount=qp.getPagecount();
  int pageNo=qp.getPageNo();  
  int pagesize=qp.getPagesize();
  if(list.size()>0)
            {
            %>
	<table class="table-box" cellspacing="1" border="0" id="ctl00_PageBody_GridView1" style="background-color:White;border-width:0px;">
		<tr class="table_title" align="center">
			<th scope="col">ID<img src='${ctx}/Manager/images/sort_desc.gif' border='0'></th>
			<th scope="col">用户名</th>
			<th scope="col">客户端IP</th>
			<th scope="col">事件类型</th>
			<th scope="col">应用名称</th>
			<th scope="col">模块名称</th>
			<th scope="col">时间</th>
		</tr>
		<%
	Iterator<SysEvent> it=list.iterator();  
  SysEvent sysEvent=null;
  //SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");//.format(news.getNewsUpdateTime());
  //df.format(news.getNewsUpdateTime())
  //news.getNewsUpdateTime();
  int temp=0;
  
  while(it.hasNext())
  {
    temp++;
    sysEvent=(SysEvent)it.next();
       
		 %>
		
		
		<tr class="<%=temp%2==1?"row":"row1"%>" align="center" style="height:28px;">
			<td><a href="EventDisp?EventID=<%=sysEvent.getEventId()%>&amp;CMD=Look"><%=sysEvent.getEventId()%></a></td>
			<td>
                        <span title="访问地址:<%=sysEvent.getEfrom()%>"><%=sysEvent.getEuLoginName()%></span>
                    </td>
					<td>
                        <a href='http://www.yahoo.cn/s?p=<%=sysEvent.getEip()%>' target='_blank'><%=sysEvent.getEip()%></a>
                    </td>
					<td><span title="<%=sysEvent.getErecord()%>"><%=sysEvent.getEtype()==(byte)1?"操作日志":"安全日志"%></span></td>
					<td><%=sysEvent.getEaAppName()%></td>
					<td><%=sysEvent.getEmName()%></td>
					<td><%=sysEvent.getEdateTime()%></td>
		</tr>	
		<%    
    }
    %>
			
	</table>
	<%
            }
            
             %>
</div>
            
<!-- AspNetPager V6.0.0 for VS2005  Copyright:2003-2006 Webdiyer (www.webdiyer.com) -->
<div id="ctl00_PageBody_AspNetPager1">
	<%  

  if(pagecount>1 )
  {
  int perpagecount=10;
  
int startpage=pageNo%perpagecount!=0?(pageNo/perpagecount)*perpagecount+1:(pageNo/perpagecount)*perpagecount+1-perpagecount;
//int startpage = ((qp.pageNo + perpagecount - 1) / perpagecount - 1) * perpagecount+1;
int endpage=pageNo%perpagecount!=0?(pageNo/perpagecount+1)*perpagecount:(pageNo/perpagecount)*perpagecount;
//int endpage = ((qp.pageNo + perpagecount - 1) / perpagecount) * perpagecount;
endpage=endpage>pagecount?pagecount:endpage;

if(pageNo!=1)
{
%>
<a href="?page=1">首页</a><a href="?page=<%=pageNo-1%>">上一页</a>
<%
}
else
{
%>
首页 上一页
<%

}
int turnNo=pageNo%perpagecount!=0?pageNo/perpagecount:pageNo/perpagecount-1;
int turnCount=pagecount%perpagecount!=0?pagecount/perpagecount:pagecount/perpagecount-1;
%>

<%
if(turnNo>0)
{
%>
<a href="?page=<%=startpage-1%>">&lt;&lt;</a>
<%

}
for(int i=startpage;i<=endpage;i++)
{
if(i==pageNo)
{
%>
<a href="?page=<%=Integer.toString(i)%>" style="color:red;"><%=Integer.toString(i)%></a>
<%
continue;
}
%>
<a href="?page=<%=Integer.toString(i)%>"><%=Integer.toString(i)%></a>
<%

}
if(turnNo<turnCount)
{
%>
<a href="?page=<%=endpage+1%>">&gt;&gt;</a>
<%
}
if(pageNo!=pagecount)
{
%>
<a href="?page=<%=pageNo+1%>">下一页</a><a href="?page=<%=pagecount%>">尾页</a>
<%

}
else
{
%>下一页 尾页<%

}
  
  }
%>
</div>
<!-- AspNetPager V6.0.0 for VS2005 End -->


        </DIV><!--内容框End--><!--内容框Start--><DIV id='tabContent__1' style='display:none'>
        <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
		<tr>
			<td class="table_body table_body_NoWidth" >
                用户名</td>
			<td class="table_none table_none_NoWidth" >
                <select name="ctl00$PageBody$E_UserID" id="ctl00_PageBody_E_UserID">
	<option value="">不限</option>
	<option value="1">admin(管理员)</option>
	<option value="2">xiaolin()己删除</option>
	<option value="3">nsn()</option>
	<option value="4">tjy()己删除</option>

</select></td>
			<td class="table_body table_body_NoWidth" >
                日志类型</td>
			<td class="table_none table_none_NoWidth" >
                <select name="ctl00$PageBody$E_Type" id="ctl00_PageBody_E_Type">
	<option value="">不限</option>
	<option value="1">操作日志</option>
	<option value="2">安全日志</option>
	<option value="3">访问日志</option>

</select></td>            
		</tr>
            <tr>
                <td class="table_body table_body_NoWidth" style="height: 28px">
                    应用/模块</td>
                <td class="table_none table_none_NoWidth" style="height: 28px">
                    <select name="ctl00$PageBody$E_ApplicationID" onchange="javascript:setTimeout('__doPostBack(\'ctl00$PageBody$E_ApplicationID\',\'\')', 0)" id="ctl00_PageBody_E_ApplicationID">
	<option selected="selected" value="">不限</option>
	<option value="1">基础模组</option>
	<option value="2">业务应用</option>

</select>
                    <select name="ctl00$PageBody$E_M_PageCode" id="ctl00_PageBody_E_M_PageCode">

</select></td>
                <td class="table_body table_body_NoWidth" style="height: 28px">
                    时间</td>
                <td class="table_none table_none_NoWidth" style="height: 28px">
                    <input name="ctl00$PageBody$S_E_DateTime" type="text" size="10" id="ctl00_PageBody_S_E_DateTime" class="text_input" title="请输入开始日期~:date" onfocus="javascript:HS_setDate(this);" />~<input name="ctl00$PageBody$E_E_DateTime" type="text" size="10" id="ctl00_PageBody_E_E_DateTime" class="text_input" title="请输入结束日期~:date" onfocus="javascript:HS_setDate(this);" /></td>
            </tr>
            <tr>
                <td class="table_body table_body_NoWidth" style="height: 28px">
                    详细描述</td>
                <td class="table_none table_none_NoWidth" colspan="3" style="height: 28px">
                    <input name="ctl00$PageBody$E_Record" type="text" size="50" id="ctl00_PageBody_E_Record" class="text_input" /></td>
            </tr>
				<tr><td colspan="4" align="right">
            <input type="submit" name="ctl00$PageBody$Button1" value="查询" id="ctl00_PageBody_Button1" class="button_bak" /></td></tr>
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
        tabClick(0,2);
       </script>
