<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="box_header">
  <div id="box_logo"><img src="${ctx}/images/banner_01.jpg" alt="奥特莱斯" width="1002" height="330" /></div>
  <div id="box_nav">
   <ul>
    <li><a href="${ctx}/home" onclick="javascript:getBg(0)" id="mynav0"><span>HOME</span></a></li>
    <li><a href="${ctx}/about" onclick="javascript:getBg(1)" id="mynav1"><span>关于奥莱特斯</span></a></li>
    <li><a href="${ctx}/inchina" onclick="javascript:getBg(2)" id="mynav2"><span>奥莱斯特联盟</span></a></li>
    <li><a href="${ctx}/research" onclick="javascript:getBg(3)" id="mynav3" class="current"><span>业态研究</span></a></li>
    <li><a href="${ctx}/news" onclick="javascript:getBg(4)" id="mynav4"><span>新闻中心</span></a></li>
    <li><a href="${ctx}/conter" onclick="javascript:getBg(5)" id="mynav5"><span>联系我们</span></a></li>
    <div class="clear"></div>
   </ul>
   <img src="${ctx}/images/fus.gif" alt="品牌服务商：蛙跳营销"  class="fws"  /> </div>
 </div>
 <!-- 头部导航结束 -->
