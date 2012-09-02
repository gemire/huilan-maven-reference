<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="Nav_Link" id="menuTextDiv">
				企业搜索配置管理 -> 欢迎页面
			</div>
			<div class="Contents_List" style="">
			<h3>Message : ${message}</h3>	
	<h3>Username : ${username}>--username : <sec:authentication property="name"/></h3>	
	
	
	<a href="${ctx}/logout" > Logout</a>
			
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						
						<td valign="top" class="Contents_List_Main" id="crawlMainPanel">
							<!-- End Contents-->
							<div class="Contents" style="padding:0 0 6px 0;">
								<div id="board" style="margin-top:0px;margin-left:0px;margin-right:0;">
									<img class="logo" style='border:none;' src="${ctx}/images/icons/home_welcome.png"/>
									<div class="news">
										<img src='${ctx}/images/icons/system_info.png'/>
										<ul>
											<li> 
												<a href="javascript:void(0)">系统处理的信息总量 ：<span class="text-key"><a href="javascript:changeFunction(36);"> 783576 </a></span></a>
											</li>
											<li>
												<a href="javascript:void(0)">系统分配内存/空闲内存 ：<span class="text-key"> 1023/0M </span>
												</a>
											</li>
											
										</ul>
									</div>

									<p>您好，<span class="font_b">admin</span>	  
									<br><span class="text-key" id="welcomeDate"></span>
									<br>系统启动时间：<span class="text-key">2012-07-23 10:03:21</span>，共检索 <span class="text-key">14</span>次	，平均响应时间：<span class="text-key">0.294s</span>		</p>
									<span class="clear"></span>
								</div>
								<div id="quick">
									<div>快速入口</div>
									<ul>
										
											<li><a href="javascript:changeFunction(312);"><img src="${ctx}/images/icons/users_16.png"> 用户管理 </a></li>
											<li><a href="javascript:changeMonitor();"><img src="${ctx}/images/icons/clock_16.png"> 任务监控 </a></li>
											<li><a href="javascript:changeFunction(13);"><img src="${ctx}/images/icons/folder_16.png"> 文件采集</a></li>
											<li><a href="javascript:changeFunction(411);"><img src="${ctx}/images/list/category_16.png"> 分类管理</a></li>
											<li><a href="javascript:changeFunction(23);"><img src="${ctx}/images/icons/index_manage16.png"> 索引管理</a></li>
											<li><a href="javascript:changeFunction(22);"><img src="${ctx}/images/icons/plus_16.png"> 索引字段</a></li>
											
											<li><a href="javascript:changeFunction(31);"><img src="${ctx}/images/icons/diagram_16.png"> 系统状态</a></li>
											<li><a href="javascript:changeFunction(32);"><img src="${ctx}/images/icons/shield_16.png"> 参数配置</a></li>
											<li><a href="javascript:changeFunction(341);"><img src="${ctx}/images/icons/help_16.png"> 插件管理</a></li>
																					
										
                                        <li style="clear:both;float:none;height:0px;font-size:0;overflow:hidden;">&nbsp;</li>
									</ul>
									<!-- 
									<div style="display:none;" style="margin:0px;padding:0px;">
										<div id="cluster_div" class="cluster DivOverFlowHide">
											<div style="margin:auto;" class="DivOverFlowHide">
												
													<div class="cluster_list">
														<a href="javascript:void(0);" class="g_a vm" onclick="jConfirm('确认切换easyDig服务器运行模式吗？','确认窗口',function(r) {if(r){doGet('${ctx}/system/cluster.action?rivu.groupid=402881e52d84aa19012d84abdd8e0001','cls_temp',function(){location.href='${ctx}/welcome.action';});}})">  
															<span class="g_b">  
																<span class="g_c">  
																	<span class="g_d"> </span>  
																	<span class="g_e">
																		<img src="/images/list/upload/1295057320189.png" style="margin-bottom:5px;">
																		
																		<b style="color:blue;">&#21333;&#26381;&#21153;&#22120;</b>
																		
																		
																	</span>  
																</span>  
															</span>  
														</a>
													</div>
												
													<div class="cluster_list">
														<a href="javascript:void(0);" class="g_a vm" onclick="jConfirm('确认切换easyDig服务器运行模式吗？','确认窗口',function(r) {if(r){doGet('${ctx}/system/cluster.action?rivu.groupid=402881e52d84cea8012d873d3c7f0001','cls_temp',function(){location.href='${ctx}/welcome.action';});}})">  
															<span class="g_b">  
																<span class="g_c">  
																	<span class="g_d"> </span>  
																	<span class="g_e">
																		<img src="/images/list/upload/1295054108377.png" style="margin-bottom:5px;">
																		
																		&#20998;&#24067;&#24335;
																	</span>  
																</span>  
															</span>  
														</a>
													</div>
												
													<div class="cluster_list">
														<a href="javascript:void(0);" class="g_a vm" onclick="jConfirm('确认切换easyDig服务器运行模式吗？','确认窗口',function(r) {if(r){doGet('${ctx}/system/cluster.action?rivu.groupid=402881e52d84cea8012d873d5b680002','cls_temp',function(){location.href='${ctx}/welcome.ac
2000
tion';});}})">  
															<span class="g_b">  
																<span class="g_c">  
																	<span class="g_d"> </span>  
																	<span class="g_e">
																		<img src="/images/list/upload/1295054119332.png" style="margin-bottom:5px;">
																		
																		&#36127;&#36733;&#22343;&#34913;
																	</span>  
																</span>  
															</span>  
														</a>
													</div>
												
													<div class="cluster_list">
														<a href="javascript:void(0);" class="g_a vm" onclick="jConfirm('确认切换easyDig服务器运行模式吗？','确认窗口',function(r) {if(r){doGet('${ctx}/system/cluster.action?rivu.groupid=402881e52d8758e1012d876829b70001','cls_temp',function(){location.href='${ctx}/welcome.action';});}})">  
															<span class="g_b">  
																<span class="g_c">  
																	<span class="g_d"> </span>  
																	<span class="g_e">
																		<img src="/images/list/upload/1295057262199.png" style="margin-bottom:5px;">
																		
																		&#38598;&#32676;&#33410;&#28857;
																	</span>  
																</span>  
															</span>  
														</a>
													</div>
												
											</div>
										</div>
									</div> -->

									<span class="clear"></span>
									<div style="border-bottom:1px solid #CCCCCC;border-top:1px solid #CCCCCC;">服务器状态</div>
									<span style="display:block;border:1px solid #CCCCCC;border-top:none;">
                                        



<script language="javascript">
	$(document).ready(function(){
		$("a#license").fancybox();
	});	
</script>
<table style='padding:10px;'>
<tr>
	<td width=0></td>
	<td colspan="3" valign="top"><strong>系统运行状态信息</strong><br />
	<span id="result_box"><span title="您可以在此处查看系统运行的状态，如内存使用状况、CPU利用率，磁盘存储空间，访问次数，索引数据量等信息">此功能提供一个查看系统运行状态信息的界面, 例如： 内存分配大小和剩余大小, CPU利用率, 磁盘存储空间剩余量, 数据检索次数, 以及索引总量信息等。</span></span></td>
  </tr>
  <tr>
	<td>&nbsp;</td>
	<td colspan="3" valign="top"><table width="100%" border="0" cellpadding="2" cellspacing="1"
				style="background-color: #EFEFEF">
	  <tr style="background-color: #FFFFFF">
		<td width="14%"><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /> <strong> 分配内存</strong></td>
		<td width="12%">1023M</td>
		<td width="14%"><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /> <strong> 当前用户</strong></td>
		<td width="19%">Administrator</td>
		<td width="17%"><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /> <strong> 索引信息总量</strong></td>
		<td width="24%"><font color="green">783576</font> docs</td>
	  </tr>
	  <tr style="background-color: #FFFFFF">
		<td nowrap="nowrap"><img src="${ctx}/images/icon_arrow2.png" alt="" width="6"
							height="9" /> <strong>空闲内存</strong> <br /></td>
		<td><font color="red">0</font>M</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> JAVA虚拟机</strong></td>
		<td>Java HotSpot(TM) Server VM</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /> <strong> 检索请求次数</strong></td>
		<td>14</td>
	  </tr>
	  <tr style="background-color: #FFFFFF">
		<td><img src="${ctx}/images/icon_arrow2.png" alt="" width="6"
							height="9" /> <strong>已使用内存</strong> <br /></td>
		<td>1023M</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 虚拟机版本</strong></td>
		<td>1.7.0_05</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /> <strong> 平均检索响应时间</strong></td>
		<td>0.294s</td>
	  </tr>
	  <tr style="background-color: #FFFFFF">
		<td><img src="${ctx}/images/icon_arrow2.png" alt="" width="6"
							height="9" /> <strong>操作系统</strong> <br /></td>
		<td width="12%"> Windows 2003</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 服务器端口号 </strong></td>
		<td></td>
	   <td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 系统启动时间</strong></td>
		<td>2012-07-23 10:03:21</td>
	  </tr>
	  <tr style="background-color: #FFFFFF">
		<td><img src="${ctx}/images/icon_arrow2.png" alt="" width="6"
							height="9" /> <strong>虚拟机路径</strong> <br /></td>
		<td colspan="5">C:\Program Files\Java\jdk1.7.0_05\jre</td>
	  </tr>
	  <tr style="background-color: #FFFFFF">
		<td><img src="${ctx}/images/icon_arrow2.png" alt="" width="6"
							height="9" /> <strong>用户默认路径</strong> <br /></td>
		<td colspan="5">C:\easyDigPack\dig-tomcat-6.0.35\bin</td>
	  </tr>
	   <tr style="background-color: #FFFFFF">
		<td height="23"><img src="${ctx}/images/icon_arrow2.png" alt="" width="6"
							height="9" /> <strong>磁盘空间/剩余空间</strong> <br /></td>
		<td>
			
			
			126G
			/
			
			<font color="red">79G</font>
				
			</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 授权产品/用户 </strong></td>
		<td nowrap="nowrap">
			&#20225;&#19994;&#26816;&#32034;/&#20013;&#31185;&#27719;&#32852;
			</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 数据量/节点数量 </strong></td>
		<td>
			&#26080;&#25968;&#37327;&#38480;&#21046;/2147483647
		</td>
	  </tr>
	   <tr style="background-color: #FFFFFF">
		<td height="23"><img src="${ctx}/images/icon_arrow2.png" alt="" width="6"
							height="9" /> <strong>easyDig使用的存储空间</strong> <br /></td>
		<td nowrap="nowrap">
			
			<a href="javascript:changeFunction(36);"> 
			
			
			
				116M
			
			
			</a>		
			</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 授权版本/类型/服务 </strong></td>
		<td>
			&#26631;&#20934;&#29256;/&#27491;&#24335;&#29256;/All</td>
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 授权日期 </strong></td>
		<td>&#26080;&#26102;&#38388;&#38480;&#21046;</td>
	  </tr>
	 <tr style="background-color: #FFFFFF">
		<td><img src="${ctx}/images/icon_arrow2.png" width="6" height="9" /><strong> 授权服务器IP/域名 </strong>
		<td colspan="5">192.168.50.183 localhost</td>
	  </tr>
	</table></td>
  </tr>
</table>
                                    </span>
								</div>
								
						</div>

				</td>
				<td valign="top" class="Column1">
					<div class="DivBorder DivPadding1" style="width:300px;padding-top:0px;padding-left:0px;" id="rPanel">
						<div style="height:28px;background:url('images/tit_bg.png') left top repeat-x;margin-top:0px;padding-top:0px;border-bottom:1px solid #CCCCCC;text-indent:10px;font-weight:bold;line-height:28px;">
							<span style="position:relative;font-weight:normal;margin-right:5px;"><a id="hotlistA" href="javascript:showHotTag('taglisthot')">列表</a>&nbsp;|&nbsp;<a id="hotcloudA" href="javascript:showHotTag('tagcloudhot')">云图</a></span>
							<span style="position:relative;float:right;font-weight:normal;margin-right:5px;">最热</span>
							<span style="position:relative;float:right;font-weight:normal;margin-right:5px;"><a href="${ctx}/downloadhistory.action?type=2">导出数据</a></span>
						</div>
						
						<div id="tagcloudhot" style="display:none;height:250px">
							<div id="hisPanel" ></div>
						</div>
						
						<div id="taglisthot" >
						<ul style="margin: 0 5px 0 5px" id="hotUl">
						
						</ul>
						</div>
					</div>
					
					<div class="DivBorder DivPadding1" style=" margin-top:20px; width:300px;padding-top:0px;padding-left:0px;height:250px">
						<div style="height:28px;background:url('images/tit_bg.png') left top repeat-x;margin-top:0px;padding-top:0px;border-bottom:1px solid #CCCCCC;text-indent:10px;font-weight:bold;line-height:28px;">
							<span style="position:relative;font-wei
394
ght:normal;margin-right:5px;"><a id="newlistA" href="javascript:showNewTag('taglistnew')">列表</a>&nbsp;|&nbsp;<a id="newcloudA" href="javascript:showNewTag('tagcloudnew')">云图</a></span>
							<span style="position:relative;float:right;font-weight:normal;margin-right:5px;">最新</span>
							<span style="position:relative;float:right;font-weight:normal;margin-right:5px;"><a href="${ctx}/downloadhistory.action?type=1">导出数据 </a></span>
						</div>
						<div id="tagcloudnew"style="display:none;" >
							<div id="hisPanel1" ></div>
						</div>
						
						<div id="taglistnew" >
						<ul style="margin: 0 5px 0 5px" id="newUl">
						
						</ul>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>

