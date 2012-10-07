<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.xxx.org/util/url/htmlfilter" prefix="hf"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 <!-- 右栏目开始 -->
   <div id="box_right">
    <div class="ny_right_bg-01">
     <div class="ny_tit-01"><img src="${ctx}/images/ny_tit-06.gif" alt="奥特莱斯在中国" width="252" height="50" /></div>
     <div class="ny_txt-06">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
        <td>&nbsp;</td>
        <td height="100"><img src="${ctx}/images/ny_pic-31.jpg" alt="业态研究" width="132" height="94" /></td>
       </tr>
       <tr>
        <td width="210" valign="top"><img src="${ctx}/images/ny_pic-32.jpg" alt="业态研究" width="203" height="575" /></td>
        <td>
        <div class="ny_research_list">
        <c:if test="${not empty list}">
        <ul>
      <c:forEach var="news" items="${list}" varStatus="status">
       
        
        <li>
            <h1><a href="${ctx}/research/${news.newsId}" target="_blank">${news.newsTitle}</a></h1>
            <p> <hf:htmlfilter content="${news.newsContent}"/> </p>
           </li>
        <li class="clearBoth"></li>
      </c:forEach>       
        </ul>      
        </c:if>          
         </div></td>
       </tr>
      </table>
     </div>
    </div>
   </div>