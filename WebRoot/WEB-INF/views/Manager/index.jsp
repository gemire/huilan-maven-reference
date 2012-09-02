<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="Nav_Link" id="menuTextDiv">企业搜索配置管理 -> 采集 -> 文件系统 -> 本地文件</div>
			<!-- Begin Contents_List-->
			<div class="Contents_List" style="">
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td valign="top" class="Column1">
							<!-- Begin Column1-->

							<div class="DivBorder DivPadding1">
								<div id="treeboxbox_tree2"
									setImagePath="${ctx}/codebase/imgs/csh_dhx_skyblue/"
									class="dhtmlxTree" style="width: 250px; height: 586px;">
									<xmp container="true"> 
									<item text="检索系统" open="1" id="1"> 
										
											<item text="采集器" open="1" id="12"> 
												<item text="文件" id="101" open="1"> 
													<item text="本地文件" id="13" select="1" >
														<userdata name="url">${ctx}/Manager/Module/FrameWork/SystemApp/FileManager/localFileList</userdata>
													</item> 
												</item>
												
												<item text="数据库" id="18" open="1">
													
														<item text="MySQL" id="1810">
														<userdata name="url">${ctx}/Manager/Module/FrameWork/SystemApp/DBManager/databaselist?typeid=4028b284392d09f001392d14d0550002</userdata>
														</item>	
													
														<item text="Access" id="1811">
														<userdata name="url">${ctx}/Manager/Module/FrameWork/SystemApp/DBManager/databaselist?typeid=4028b284392d09f001392d1661f20004</userdata>
														</item>	
													
														<item text="oracle" id="1812">
														<userdata name="url">${ctx}/Manager/Module/FrameWork/SystemApp/DBManager/databaselist?typeid=4028b284392834030139283537ff0001</userdata>
														</item>	
													
														<item text="db2" id="1813">
														<userdata name="url">${ctx}/Manager/Module/FrameWork/SystemApp/DBManager/databaselist?typeid=4028b284392d09f001392d15baf40003</userdata>
														</item>	
													
														<item text="SQLServer" id="1814">
														<userdata name="url">${ctx}/Manager/Module/FrameWork/SystemApp/DBManager/databaselist?typeid=4028b2843923da00013923da36490001</userdata>
														</item>	
													
												</item> 
											</item> 
										
										<item text="信息管理" open="1" id="20"> 
											
												<item text="索引结构" id="22"> 
													<userdata name="url">${ctx}/crawl/indexField!list.action</userdata>
												</item>
											
											<item text="索引数据" id="23"> 
												<userdata name="url">${ctx}/Manager/Module/FrameWork/SystemApp/InfoManager/IndexData</userdata>
											</item>
											<!--<item text="Index View" id="23" /> -->
											<!--
											<item text="Solr schema export/import" id="24">
												<userdata name="url">system/solr!list.action</userdata>
											</item>
											-->
										</item> 
										<!--
										<item text="Server Manage" open="1" id="40">
											<item text="Distributed" id="41" /> 
											<item text="Cluster" id="42" /> 
										</item> 
										-->
										
											<item text="系统配置" open="1" id="30"> 
												
												<!--<item text="Roles Manage" id="311" /> --> 
												<item text="用户和角色管理" id="312"> 
													<userdata name="url">${ctx}/system/rules!list.action</userdata>
												</item>
												<item text="运行参数配置" id="31">
													<userdata name="url">${ctx}/system/digsite!list.action</userdata>
												</item>
												<item text="检索参数配置" id="32">
													<userdata name="url">${ctx}/system/searchsetting.action</userdata>
												</item>
												
												
													<item text="检索" id="41" open="1">
														<item text="检索分类" id="411">
															<userdata name="url">${ctx}/system/category.action</userdata>
														</item>
														<item text="逻辑库管理" id="413">
															<userdata name="url">${ctx}/system/logicDatabaseCategory.action</userdata>
														</item>
														<!--
														<item text="Search Report" id="413">
															<userdata name="url">/system/project.action</userdata>
														</item>
														-->
													</item>
													<!--
													<item text="Black List" id="33"> 
														<userdata name="url">/system/blacklist!list.action</userdata>
													</item>
													-->
													<!--<item text="Backup/Restoge" id="34" /> -->
													<item text="扩展 &amp; 插件" id="341"> 
														<userdata name="url">${ctx}/system/extension!typelist.action</userdata>
													</item>
													<item text="文档格式管理" id="342"> 
														<userdata name="url">${ctx}/system/mimetype!list.action</userdata>
													</item>
													<item text="文件类型" id="35"> 
														
															<item text="Word" id="350"> 
																<userdata name="url">${ctx}/system/metadata!list.action?data.mimeid=4028804728af09be0128af0ba1c10001</userdata>
															</item>
														
															<item text="HTML" id="351"> 
																<userdata name="url">${ctx}/system/metadata!list.action?data.mimeid=4028804728af09be0128af0d70db0002</userdata>
															</item>
														
															<item text="PPT" id="352"> 
																<userdata name="url">${ctx}/system/metadata!list.action?data.mimeid=402886842963e4b8012963eaf9810003</userdata>
															</item>
														
															<item text="Excel" id="353"> 
																<userdata name="url">${ctx}/system/metadata!list.action?data.mimeid=4028b2ed31f1a7c20131f1d45a770002</userdata>
															</item>
														
													</item> 
												
											</item>										
									</item> 
							</xmp>
						</div>

						<script language="javascript">
							var tree = new dhtmlXTreeFromHTML("treeboxbox_tree2");
							tree.setOnClickHandler(tonclick);
							function tonclick(id) {
									var pid = id ;
									var menuText = "" ;
									for(;pid && pid!=1;){
										text = tree.getItemText(pid);
										if(menuText!=""){
											menuText = text +" -> "+ menuText ;
										}else{
											menuText = text ;
										}
										
										pid = tree.getParentId(pid) ;										
									}
									
									var url=tree.getUserData(id,'url');
									if(url){
										doGet(url , "crawlMainPanel",function(){$("#menuTextDiv").text("企业搜索配置管理 -> "+menuText);});
									}
							};
						</script>
					</div>
					<!-- End Column1-->
				</td>
<td valign="top" class="Contents_List_Main" id="crawlMainPanel">
<tiles:insertAttribute name="rightbox" />				
</td>
</tr>
</table>
</div>
<!-- End Contents_List-->