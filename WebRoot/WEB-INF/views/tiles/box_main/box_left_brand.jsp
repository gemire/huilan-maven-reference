<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 左栏目开始 -->
   <div id="box_left">
    <div class="ny_title"><img src="${ctx}/images/ny_title-02.gif" alt="关于我们" width="220" height="50" /></div>
    <div class="ny_nav">
     <ul >
      <li><a href="${ctx}/inchina">奥特莱斯在中国<br/>
       <span>In China</span></a></li>
      <li><a href="${ctx}/alliance" >奥特莱斯联盟<br/>
       <span>Alliance</span></a></li>
      <li><a href="${ctx}/brand" class="hover">战略合作品牌<br/>
       <span>Strategic co-brand</span></a></li>
     </ul>
    </div>
   </div>
