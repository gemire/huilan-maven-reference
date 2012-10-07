<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 <!-- 二列版式开始 -->
 <div id="box_main">
  <!-- 左栏目开始 -->
  <div id="box_left">
   <!-- 关于我们 -->
   <div id="box_about">
    <div class="title_01"><a href="${ctx}/about" target="_blank"><img src="${ctx}/images/title_01.gif" alt="关于奥特莱斯" border="0" /></a></div>
    <p><a href="${ctx}/about" target="_blank"><img src="${ctx}/images/banner_02.jpg" alt="奥特莱斯" border="0" /></a></p>
   </div>
   <!-- 新闻中心 -->
   <div id="box_news">
    <div class="title_01"><a href="${ctx}/news" target="_blank"><img src="${ctx}/images/title_02.gif" alt="新闻中心" border="0" /></a></div>
    <div class="news_list">
    
    <c:if test="${not empty list4}">
    <ul >
    <c:forEach var="news" items="${list4}" varStatus="status">
    <li><a href="${ctx}/news/${news.newsId}" target="_blank">${news.newsTitle}</a></li>       
      </c:forEach>      
     </ul>
    </c:if>
     
    </div>
   </div>
  </div>
  <!-- 左栏目结束-->
  <!-- 右栏目开始 -->
  <div id="box_right">
   <!-- 奥特莱斯介绍 -->
   <div id="box_introduce">
    <div class="title_01"><a href="${ctx}/about" target="_blank"><img src="${ctx}/images/title_03.gif" alt="介绍奥特莱斯" border="0" /></a></div>
    <div class="introduce_txt">
     <p>奥特莱斯是英文OUTLETS的中文直译，其英文愿意是“出口、出路、排出口”的意思，在零售商业中专指由销售名牌过季、下架、断码商品的商店组成的购物中心，因此也被称为“品牌直销购物中心”。</p>
     <p>奥特莱斯（Outlest）最早诞生于美国，迄今已有近一百年的立时，Outlets最早就是“工厂直销店”专门处理工厂尾货，后来逐渐汇集……</p>
    </div>
   </div>
   <!-- 新联盟成员 -->
   <div id="box_member">
    <div class="title_01"><a href="${ctx}/brand" target="_blank"><img src="${ctx}/images/title_04.gif" alt="新联盟成员" border="0" /></a></div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
      <td height="96" align="center" valign="top"><img src="${ctx}/images/pic_10.jpg" alt="pic01" width="114" height="85" /></td>
      <td align="center" valign="top"><img src="${ctx}/images/pic_11.jpg" alt="pic02" width="125" height="85" /></td>
      <td align="center" valign="top"><img src="${ctx}/images/pic_12.jpg" alt="pic02" width="114" height="85" /></td>
     </tr>
     <tr>
      <td colspan="3" scope="row"><p>本广场卫浴桃花伦东路164号，赫山庙黄金地段，百年城市商脉，周边游万木椿购物广场、步步高超市、国美电器、金鸿百货、金嘉利百货、赫山步行街以及临街的耐克、阿迪、美特斯邦威等品牌店。本广场所在区域是桃花伦商圈中最核心的部分，本项目共六层，配  扶梯、观……</p></td>
     </tr>
    </table>
   </div>
   <!-- 业态研究 -->
   <div id="box_research">
    <div class="title_01"><a href="${ctx}/research" target="_blank"><img src="${ctx}/images/title_05.gif" alt="业态研究" width="420" height="34" border="0" /></a></div>
    <div class="research_list">
     <c:if test="${not empty list5}">
    <ul >
    <c:forEach var="news" items="${list5}" varStatus="status">    
      <li><a href="${ctx}/research/${news.newsId}" target="_blank">${news.newsTitle}</a></li> 
      </c:forEach>      
     </ul>
    </c:if>
     
    </div>
   </div>
  </div>
  <div class="clearBoth"></div>
 </div>