<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title><tiles:insertAttribute name="title"/></title>
       <LINK href="${ctx}/css/css.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/head.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/datamanage.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/common.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/jquery.fancybox-1.3.0.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/jquery.alerts.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/Pager.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/search.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/calendar.css" type="text/css" rel="stylesheet"/>
		<LINK href="${ctx}/css/clickmenu.css"  type="text/css"  rel="stylesheet" />
		<LINK href="${ctx}/codebase/dhtmlxtree.css" type="text/css" rel="stylesheet"/>
		<script src="${ctx}/codebase/dhtmlxcommon.js"></script>
		<script src="${ctx}/codebase/dhtmlxtree.js"></script>
		<script src="${ctx}/codebase/ext/dhtmlxtree_start.js"></script>
		<script src="${ctx}/codebase/jquery-1.3.2.js"></script>
		<script src="${ctx}/codebase/jquery.form.js"></script>
		<script src="${ctx}/codebase/jquery.pager.js"></script>
		<script src="${ctx}/codebase/jquery.easing-1.3.pack.js"></script>
		<script src='${ctx}/codebase/jquery.fancybox-1.3.0.js'></script>
		<script src='${ctx}/codebase/calendar.js'></script>
		<script src='${ctx}/codebase/calendar-zh.js'></script>
		<script src='${ctx}/codebase/calendar-setup.js'></script>
		<script src="${ctx}/codebase/jquery.ui.draggable.js"></script>
		<script src="${ctx}/codebase/jquery.alerts.js"></script>
		<script src="${ctx}/codebase/jquery.timers.js"></script>
		<script src="${ctx}/codebase/jquery.blockUI.js"></script>
		<script src="${ctx}/codebase/validation.js"></script>
		<script src="${ctx}/codebase/jquery.clickmenu.js"></script>
		<script src="${ctx}/codebase/swfobject.js"></script>
		<script src="${ctx}/codebase/rivu.js"></script>
  </head>

<body>    
    <div class="header_container">
		<div class="header_top_outer">
				<div class="header_top">
					<div class="logo">
						<a href="/dig/welcome.action"><img src="${ctx}/images/logo.png" height="55" /></a>
					</div>
					<div class="access_retsys">
						<a href="/dig/dig.action">访问检索系统</a>
					</div>
					
					<div class="right" style="padding-top:20px;">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td> 
									
									
								</td>
								
								<td>
									<a href="#"></a>
								</td>
								<td>

								</td>
								<td>
									<a name="userprofile" href="/dig/system/changepass.action">
										<img src="${ctx}/images/icons/users_16.png" align="absmiddle" />
										<span class="txtBlue">admin</span>
									</a>		
									<script language="javascript">
										$("a:[name='userprofile']").fancybox({ajax : {type	: 'get'}});
									</script>
								</td>
								<td>
									<span style='display:block;padding:0 10px;'><a href="javascript:void(0);" onclick="jConfirm('确认退出?', '退出', function(r) {if(r) doLogout('/dig/logout.action',function(){location.href='/dig/welcome.action';})});"><img src="${ctx}/images/logout.png" /></a></span>
								</td>
							</tr>
						</table>
					</div>

				</div>
			</div>
			<div class="head_menu">
				<!-- Begin head_menu_Tab-->
				<div class="head_menu_Tab_Choosed" id="welcomeMenu">
					<div class="Tab_Left"></div>
					<div class="Tab_bg">
						<a href="#" onClick="doGet('${ctx}/Manager/first','indexPanel',function(){changeCSS('welcomeMenu');});">欢迎</a>
					</div>
					<div class="Tab_Right"></div>
					<div class="clears"></div>
				</div>
				
				<!-- End head_menu_Tab-->
				<!-- Begin head_menu_Tab-->
				<div class="head_menu_Tab_NoChoosed" id="rivuletMenu">
					<div class="Tab_Left"></div>
					<div class="Tab_bg">
						<a href="#" onClick="doGet('${ctx}/Manager/index','indexPanel',function(){changeCSS('rivuletMenu');});">系统管理</a>
					</div>
					<div class="Tab_Right"></div>
					<div class="clears"></div>
				</div>
				<!-- End head_menu_Tab-->
				
				
				<!-- Begin head_menu_Tab-->
				<div class="head_menu_Tab_NoChoosed" id="crawlMenu">
					<div class="Tab_Left"></div>
					<div class="Tab_bg">
						<a href="#" onClick="doGet('${ctx}/Manager/crawl','indexPanel',function(){changeCSS('crawlMenu');});">采集状态</a>
					</div>
					<div class="Tab_Right"></div>
					<div class="clears"></div>
				</div>
				<!-- End head_menu_Tab-->
				
				<div class="head_menu_Tab_NoChoosed" id="crawlMenu">
					<div class="Tab_Left"></div>
					<div class="Tab_bg">
						<a href="#" onClick="doGet('${ctx}/Manager/Module/FrameWork/SystemApp/DBManager/Mssql','indexPanel',function(){changeCSS('crawlMenu');});">数据采集</a>
					</div>
					<div class="Tab_Right"></div>
					<div class="clears"></div>
				</div>
				
			</div>
		</div>
		<div class="Contents" id="indexPanel">
		<tiles:insertAttribute name="mainbox" />
		</div>		
		<div class="clears"></div>
		<div style="width:100%;text-align:center;">copyright<br/>&#26234;&#33021;&#25628;&#32034;&#24341;&#25806;</div>
		<!-- End Containers-->
		<div id="pubDiv"></div>
		<div id="temp" style="width=0px ; height:0px;display:none;"><!--temp div--></div> 
</body>
</html>
