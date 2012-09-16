<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>奥特莱斯</title>
<link href="${ctx}/style/page_index.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/style/css.css"  rel="stylesheet" type="text/css" />
<script src="${ctx}/js/16sucai.js" type="text/javascript"></script>
<script language="javascript">
	function getBg(num){
		for(var id = 0;id<=5;id++)
		{
			if(id==num)
			{
				document.getElementById("mynav"+id).className="current";
			}
			else
			{
				document.getElementById("mynav"+id).className="";
			}
		}
	}
</script>
</head>
<body>
<div id="box_root">
 <div id="box_header">
  <div id="box_logo"><img src="${ctx}/images/banner_01.jpg" alt="奥特莱斯" width="1002" height="330" /></div>
  <div id="box_nav">
   <ul>
    <li><a href="index.html" onclick="javascript:getBg(0)" id="mynav0" class="current"><span>HOME</span></a></li>
    <li><a href="about.html" onclick="javascript:getBg(1)" id="mynav1"><span>关于奥莱特斯</span></a></li>
    <li><a href="inchina.html" onclick="javascript:getBg(2)" id="mynav2"><span>奥莱斯特联盟</span></a></li>
    <li><a href="research.html" onclick="javascript:getBg(3)" id="mynav3"><span>液态研究</span></a></li>
    <li><a href="news.html" onclick="javascript:getBg(4)" id="mynav4"><span>新闻中心</span></a></li>
    <li><a href="conter.html" onclick="javascript:getBg(5)" id="mynav5"><span>联系我们</span></a></li>
    <div class="clear"></div>
   </ul>
   <img src="${ctx}/images/fus.gif" alt="品牌服务商：蛙跳营销"  class="fws"  /> </div>
 </div>
 <!-- 头部导航结束 -->
 <!-- 二列版式开始 -->
 <div id="box_main">
  <!-- 左栏目开始 -->
  <div id="box_left">
   <!-- 关于我们 -->
   <div id="box_about">
    <div class="title_01"><a href="about.html"><img src="${ctx}/images/title_01.gif" alt="关于奥特莱斯" border="0" /></a></div>
    <p><a href="about.html"><img src="${ctx}/images/banner_02.jpg" alt="奥特莱斯" border="0" /></a></p>
   </div>
   <!-- 新闻中心 -->
   <div id="box_news">
    <div class="title_01"><a href="news.html"><img src="${ctx}/images/title_02.gif" alt="新闻中心" border="0" /></a></div>
    <div class="news_list">
     <ul >
      <li><a href="news_detail.html" >长沙金砖房地产公司李克强：逐步扩大房产税改革试点长沙金砖房地产公司李克强：逐步扩大房产税改革试点</a></li>
      <li><a href="#" >湖南中联房地产顾问有限公司</a></li>
      <li><a href="#" >嘉业地产长沙金砖房地产公司李克强：逐步扩大房产税改革试点</a></li>
      <li><a href="#" >长沙市荣志房地产经纪有限公司</a></li>
      <li><a href="#">湖南建安房屋联动营销有限公司</a></li>
     </ul>
    </div>
   </div>
  </div>
  <!-- 左栏目结束-->
  <!-- 右栏目开始 -->
  <div id="box_right">
   <!-- 奥特莱斯介绍 -->
   <div id="box_introduce">
    <div class="title_01"><a href="about.html"><img src="${ctx}/images/title_03.gif" alt="介绍奥特莱斯" border="0" /></a></div>
    <div class="introduce_txt">
     <p>奥特莱斯是英文OUTLETS的中文直译，其英文愿意是“出口、出路、排出口”的意思，在零售商业中专指由销售名牌过季、下架、断码商品的商店组成的购物中心，因此也被称为“品牌直销购物中心”。</p>
     <p>奥特莱斯（Outlest）最早诞生于美国，迄今已有近一百年的立时，Outlets最早就是“工厂直销店”专门处理工厂尾货，后来逐渐汇集……</p>
    </div>
   </div>
   <!-- 新联盟成员 -->
   <div id="box_member">
    <div class="title_01"><a href="brand.html"><img src="${ctx}/images/title_04.gif" alt="新联盟成员" border="0" /></a></div>
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
    <div class="title_01"><a href="research.html"><img src="${ctx}/images/title_05.gif" alt="业态研究" width="420" height="34" border="0" /></a></div>
    <div class="research_list">
     <ul >
      <li><a href="research_detail.html" >长沙金砖房地产公司李克强：逐步扩大房产税改革试点长沙金砖房地产公司李克强：逐步扩大房产税改革试点</a></li>
      <li><a href="#" >湖南中联房地产顾问有限公司</a></li>
      <li><a href="#" >嘉业地产长沙金砖房地产公司李克强：逐步扩大房产税改革试点</a></li>
      <li><a href="#" >长沙市荣志房地产经纪有限公司</a></li>
      <li><a href="#">湖南建安房屋联动营销有限公司</a></li>
     </ul>
    </div>
   </div>
  </div>
  <div class="clearBoth"></div>
 </div>
 <!-- 底部栏目开始 -->
 <div id="box_footer">
  <!-- 奥特莱斯联盟 -->
  <div id="box_alliance">
   <div class="title_01"><a href="alliance.html"><img src="${ctx}/images/title_06.gif" alt="奥特莱斯联盟" border="0" /></a></div>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
     <td width="540" ><div id="box_flash">
       <pre class="prev">prev</pre>
       <pre class="next">next</pre>
       <ul>
        <li><img src="${ctx}/images/pic_1.jpg" />
         <div>万国奥特莱斯</div>
        </li>
        <li><img src="${ctx}/images/pic_2.jpg" />
         <div>友阿奥特莱斯</div>
        </li>
        <li><img src="${ctx}/images/pic_3.jpg" />
         <div>中天广场国奥特莱斯</div>
        </li>
        <li><img src="${ctx}/images/pic_4.jpg" />
         <div>万国奥特莱斯</div>
        </li>
        <li><img src="${ctx}/images/pic_5.jpg" />
         <div>友阿奥特莱斯</div>
        </li>
        <li><img src="${ctx}/images/pic_1.jpg" />
         <div>中天广场国奥特莱斯</div>
        </li>
        <li><img src="${ctx}/images/pic_2.jpg" />
         <div>友阿奥特莱斯</div>
        </li>
       </ul>
     </div></td>
     <td align="center"><a href="inchina.html"><img src="${ctx}/images/maps_01.jpg" alt="联盟地图" width="242" height="189" border="0" /></a></td>
    </tr>
   </table>
  </div>
  <!-- 友情链接 -->
  <div id="box_links"><p><img src="${ctx}/images/line_01.gif" alt="line" /><a href="#">蛙跳网</a><img src="${ctx}/images/line_01.gif" alt="line" /><a href="#">新浪地产</a><img src="${ctx}/images/line_01.gif" alt="line" /><a href="#">奥特莱斯（中国）有限公司</a><img src="${ctx}/images/line_01.gif" alt="line" /><a href="#">好房子网</a><img src="${ctx}/images/line_01.gif" alt="line" /><a href="#">0731房产网</a><img src="${ctx}/images/line_01.gif" alt="line" /></p></div>
 </div>
</div>
</body>
</html>
