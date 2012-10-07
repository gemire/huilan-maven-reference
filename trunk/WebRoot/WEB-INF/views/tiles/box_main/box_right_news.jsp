<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 右栏目开始 -->
   <div id="box_right">
    <div class="ny_right_bg-01">
     <div class="ny_tit-01"><img src="${ctx}/images/ny_tit-07.gif" alt="奥特莱斯在中国" width="180" height="50" /></div>
     <div class="ny_txt-07">
      <div class="rollBox">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
         <td width="42" align="center" valign="middle"><img onmousedown="ISL_GoDown()" onmouseup="ISL_StopDown()" onmouseout="ISL_StopDown()"  class="img1" src="${ctx}/images/shqm_left_pic.gif" width="24" height="50" /></td>
         <td><div class="Cont" id="ISL_Cont">
           <div class="ScrCont">
            <div id="List1">
             <!-- 图片列表 begin -->
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_1.jpg"  /></a> </div>
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_2.jpg"  /></a> </div>
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_3.jpg"  /></a> </div>
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_4.jpg"  /></a> </div>
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_5.jpg"  /></a> </div>
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_6.jpg"  /></a> </div>
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_7.jpg"  /></a> </div>
             <div class="pic"> <a href="#" target="_blank"><img src="${ctx}/images/show_8.jpg"  /></a> </div>
             <!-- 图片列表 end -->
            </div>
            <div id="List2"></div>
           </div>
          </div></td>
         <td width="42" align="center" valign="middle"><img  onmousedown="ISL_GoUp()" onmouseup="ISL_StopUp()" onmouseout="ISL_StopUp()"  class="img2" src="${ctx}/images/shqm_right_pic.gif" width="24" height="50" /></td>
        </tr>
       </table>
      </div>
      <div class="ny_news_list">
      <c:if test="${not empty list}">
      <ul>
      <c:forEach var="news" items="${list}" varStatus="status">
       <li class="list">
         <h1><a href="${ctx}/news/${news.newsId}" target="_blank"> ${news.newsTitle}</a></h1>
         <div class="more"><img src="${ctx}/images/more_01.gif" alt="更多" /></div>
        </li>
        <li class="clearBoth"></li>
      </c:forEach>       
        </ul>      
      </c:if>       
      </div>
     </div>
    </div>
   </div>
