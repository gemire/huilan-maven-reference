<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hedgehog.outletss.domain.*"%>
<%@page import="com.hedgehog.outletss.domain.QueryPara"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 头部菜单 Start -->
	        <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
              <tr>
                <td class='menubar_title'><img border='0' src='${ctx}/Manager/images/ICON/applist.gif' align='absmiddle' hspace='3' vspace='3'/>&nbsp;索娱艺人</td>
                <td class='menubar_readme_text' valign='bottom'><img src='${ctx}/Manager/images/ICON/office.gif' align='absMiddle' border='0' />&nbsp;帮助？</td>
              </tr>
              <tr>
                <td height='27px' class='menubar_function_text'>目前操作功能：索娱艺人列表</td>
                <td class='menubar_menu_td' align='right'><table border="0" cellspacing="0" cellpadding="0"><tr><td class="menubar_button" id="button_0" OnClick="JavaScript:window.location.href='?cmd=new';" OnMouseOut="javascript:MenuOnMouseOver(this);" OnMouseOver="javascript:MenuOnMouseOut(this);"><img border="0" align="texttop" src="${ctx}/Manager/images/ICON/new.gif">&nbsp;新增索娱艺人</td></tr></table></td>
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
				         <TD class=tab id=tabLabel__0 onclick='javascript:tabClick(0,2)' background='${ctx}/Manager/images/Menu/tab_unactive_bg.gif' UNSELECTABLE='on'>索娱艺人列表</TD>
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
        <input type='hidden' ID='FrameWork_YOYO_LzppccSelectIndex' name='FrameWork_YOYO_LzppccSelectIndex' value='0'>
        <!--内容框Start-->
        <DIV id='tabContent__0' style='display:none'>
            <div>
<%
  List<SyMember> list=(List<SyMember>)request.getAttribute("list"); 
  QueryPara<SyMember> qp=(QueryPara<SyMember>)request.getAttribute("QueryPara"); 
  int pagecount=qp.getPagecount();
  int pageNo=qp.getPageNo();  
  int pagesize=qp.getPagesize();
  if(list.size()>0)
            {
            %>
	<table class="table-box" cellspacing="1" border="0" id="ctl00_PageBody_GridView1" style="background-color:White;border-width:0px;">
		<tr class="table_title" align="center">
			<td style="width:5px;"> <input id='CheckboxAll' value='0' type='checkbox' onclick='SelectAll()'/></td><th scope="col" style="white-space:nowrap;">
			序号<img src='${ctx}/Manager/images/sort_desc.gif' border='0'></th>
			<th scope="col">用户ID</th>
			<th scope="col">Email</th>
			<th scope="col">姓名</th>
			<th scope="col">性别</th>			
			<th scope="col">注册日期</th>
			<th scope="col">首页显示</th>
			<td>操作</td>
		</tr>
		<%
	Iterator<SyMember> it=list.iterator();  
  SyMember syMember=null;
  //SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");//.format(news.getNewsUpdateTime());
  //df.format(news.getNewsUpdateTime())
  //news.getNewsUpdateTime();
  int temp=0;
  
  while(it.hasNext())
  {
  temp++;
      syMember=(SyMember)it.next();
       
		 %>
		<tr class="<%=temp%2==1?"row":"row1"%>" align="center" style="height:28px;">
			<td style="width:5px;"> <input name='Checkbox' id='Checkbox' value='<%=syMember.getMemberId()%>' type='checkbox' /></td>
			            <td><%=temp+(pageNo-1)*pagesize%></td>
                        <td><%=syMember.getMemberAccount()%></td>
                        <td><%=syMember.getMemberEmail()%></td>
                        <td><%=syMember.getMemberName()%></td>
                        <td><%=syMember.getMemberSex()==0?"男":"女"%></td>
                        
                        <td><%=syMember.getMemberUpdatetime()%></td>
                        <td><%=syMember.getMemberShow()==1?"visible":"hidden"%></td>                        
                        <td><a href="?cmd=edit&IDX=<%=syMember.getMemberId()%>">编辑</a>||<a href="JavaScript:DelData('?cmd=del&IDX=<%=syMember.getMemberId()%>')">删除</a></td>
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


            <input type="submit" name="ctl00$PageBody$Button2" value="删除" onclick="return deleteop();" id="ctl00_PageBody_Button2" class="button_bak" />
        </DIV><!--内容框End--><!--内容框Start--><DIV id='tabContent__1' style='display:none'>
            <table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
                <tr>
                    <td class="table_body">
                        标题</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Title_Input" type="text" id="ctl00_PageBody_News_Title_Input" class="text_input" title="请输入标题~200:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        属性集</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Properties_Input" type="text" id="ctl00_PageBody_News_Properties_Input" class="text_input" title="请输入属性集~50:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        缩略图</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Thumbs_Input" type="text" id="ctl00_PageBody_News_Thumbs_Input" class="text_input" title="请输入缩略图~100:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        类别</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Cate_Input" type="text" id="ctl00_PageBody_News_Cate_Input" class="text_input" title="请输入类别~2147483648:int" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        编辑</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Editor_Input" type="text" id="ctl00_PageBody_News_Editor_Input" class="text_input" title="请输入编辑~50:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        摘要</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Summery_Input" type="text" id="ctl00_PageBody_News_Summery_Input" class="text_input" title="请输入摘要~600:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        Tags标签</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Keywords_Input" type="text" id="ctl00_PageBody_News_Keywords_Input" class="text_input" title="请输入Tags标签~200:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        内容</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Content_Input" type="text" id="ctl00_PageBody_News_Content_Input" class="text_input" title="请输入内容~1073741823:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        浏览次数</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Hits_Input" type="text" id="ctl00_PageBody_News_Hits_Input" class="text_input" title="请输入浏览次数~2147483648:int" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        更新时间</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Updatetime_Input" type="text" id="ctl00_PageBody_News_Updatetime_Input" class="text_input" title="请输入更新时间~datetime" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        文章来源</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Source_Input" type="text" id="ctl00_PageBody_News_Source_Input" class="text_input" title="请输入文章来源~200:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        备用字段1</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Temp1_Input" type="text" id="ctl00_PageBody_News_Temp1_Input" class="text_input" title="请输入备用字段1~100:" />
                    
                        </td>
                </tr>
                <tr>
                    <td class="table_body">
                        备用字段2</td>
                    <td class="table_none">
                     
                        <input name="ctl00$PageBody$News_Temp2_Input" type="text" id="ctl00_PageBody_News_Temp2_Input" class="text_input" title="请输入备用字段2~2147483648:int" />
                    
                        </td>
                </tr>
                <tr>
                    <td colspan="4" align="right">
                        <input type="submit" name="ctl00$PageBody$Button1" value="查询" id="ctl00_PageBody_Button1" class="button_bak" /></td>
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
        

<script language="javascript" type="text/javascript">
<!--

function SelectAll()
{
   var e=document.getElementsByTagName("input");
   var IsTrue;
   if(document.getElementById("CheckboxAll").value=="0")
　 {
　　 IsTrue=true;
　　 document.getElementById("CheckboxAll").value="1"
　 }
　 else
　 {
　　IsTrue=false;
　　document.getElementById("CheckboxAll").value="0"
　　}
　　
　for(var i=0;i<e.length;i++)
　{
　　if (e[i].type=="checkbox")
　　{
　　   e[i].checked=IsTrue;
　　}
　}
}
function deleteop()
{
    var checkok = false;
    var e=document.getElementsByTagName("input");
    for(var i=0;i<e.length;i++)
　  {
　     if (e[i].type=="checkbox")
　　     {
　　         if (e[i].checked==true)
　　         {
　　             checkok = true;
　　             break;　　             
　　         }
　　     }  
　  }
　  if (checkok) 
        return confirm('删除后不可恢复,确认要批量删除选中记录吗？');
    else
    {
        
        alert("请选择要删除的记录!");
        return false;
    }
}
// -->
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
  tabClick(0,2);
</script>
