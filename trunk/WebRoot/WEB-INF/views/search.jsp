<%@ page language="java" import="java.util.*,org.apache.solr.client.solrj.response.FacetField,org.apache.solr.client.solrj.response.FacetField.Count" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLEncoder" %>
<%@page import="com.hedgehog.Utils.QueryPara"%>
<%@page import="org.apache.solr.common.SolrDocument"%>
<%@page import="org.apache.solr.common.SolrDocumentList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.xxx.org/util/url/encode" prefix="en"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'search.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
<c:url value="/search" var="displayURL">
<c:param name="query" value="${param.query}" />

<c:if test="${not empty param.region}">
<c:param name="region" value="${param.region}" />
</c:if>
<c:if test="${not empty param.trade}">
<c:param name="trade" value="${param.trade}" />
</c:if>
<c:if test="${not empty param.update}">
<c:param name="update" value="${param.update}" />
</c:if>
</c:url>
<!-- 表单元素可采取jstl表达式赋值 -->
<form action="${ctx}/search" method="get">
	<input name="query" type="text" style="width:200px;" value="${param.query}" />
	<input type="submit" value="搜索" />
</form>
<div class="bi">
	<c:choose>
		<c:when test="${queryParam.recordcount>0}"> <span class="jgtj">共为您找到相关结果 ${queryParam.recordcount} 个, 查询用时${elapse} 秒 </span> </c:when>
		<c:otherwise> <span class="jgtj">没有找到相关结果 </span> </c:otherwise>
	</c:choose>
</div>
<%

Map<String,String> map=new LinkedHashMap<String,String>();
map.put("region", "地区");
map.put("trade", "行业");



List<FacetField> facetFields=(List<FacetField>)request.getAttribute("facetFields");
if(facetFields.size()>0)
		     {
		     %>
		     <ul>
		     <%
		    	 Iterator<FacetField> itr=facetFields.iterator();
		    	 FacetField fieldFacet=null;
		    	 while(itr.hasNext())
		    	 {
		    		 fieldFacet=itr.next();
		    		 %>
		    		 <li><%=fieldFacet.getName()%></li>		    		 
		    		 <%
		    		 if(fieldFacet.getValueCount()>0)
		    		 {
		    		         
		    		 %>
		    		 <li>
		             <ul>
		             <%
		                 StringBuffer sb=new StringBuffer();
		                 
		                 Iterator<String> it=map.keySet().iterator();
			    		 while(it.hasNext())
			    		 {							
			    			String param=it.next();	
			    			//String value=map.get(param);
							
			                if(map.get(param).equalsIgnoreCase(fieldFacet.getName()))
			                {
			                  sb.append("&amp;"+param+"=%count%");
							 
			                  continue;
			                }
							if(request.getParameter(param)!=null)
			                {
			                   URLEncoder.encode(request.getParameter(param),"utf-8");
			                   sb.append("&amp;"+param+"="+URLEncoder.encode(request.getParameter(param),"utf-8"));
			                }
			    		}
						%>						
						<%
		    			 for (Count count : fieldFacet.getValues()) 
		    			 {		    			    
			    			 //sb.toString().replace("count", count.getName());
		    			 %>
		    			 <li><a href="${ctx}/search?query=<en:urlEncode key="${param.query}"/><%=sb.toString().replace("%count%",URLEncoder.encode(count.getName(),"utf-8"))%>"><%=count.getName()+"["+count.getCount()+"]\t"%></a></li>
		    			 <%
						 }
						 %>
		    	    </ul>
		    	    </li>
		    	 <%		    			 
		    		 }		    		 
		    	 }
		    	 %>
		    	 </ul>
		    	 <%
		     }

 SolrDocumentList docs=(SolrDocumentList)request.getAttribute("docs");
 Map<String,Map<String,List<String>>> hl=(Map<String,Map<String,List<String>>>)request.getAttribute("hl");
 if(docs.getNumFound()>0)
 {
 //循环开始 
 Iterator<SolrDocument> solrDocumentIterator =  docs.iterator();
 SolrDocument solrDocument=null;
 while(solrDocumentIterator.hasNext()) {
	solrDocument = solrDocumentIterator.next();
	//do something useful here	
    String id = (String) solrDocument.getFieldValue("id");
    String title = (String) solrDocument.getFieldValue("title");
    String region = (String) solrDocument.getFieldValue("region");
    String trade = (String) solrDocument.getFieldValue("trade");
    String url = (String) solrDocument.getFieldValue("link");
    System.out.println("日期格式："+solrDocument.getFieldValue("update"));
    Date update = (Date) solrDocument.getFieldValue("update");
    //response.getWriter().println(update);
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");//.format(news.getNewsUpdateTime());
    String datefmt=df.format(update);
    //String datefmt="date";
    //df.format(news.getNewsUpdateTime())
    String content = (String) solrDocument.getFieldValue("content"); 
    Map<String,List<String>> list_hl=hl.get(id);
    %>
   <div class="f">
	<%
                //start title
                if(null!=list_hl.get("title"))
                {
                  List<String> list_str=list_hl.get("title");
                          if(list_str.size()>0)
			                {
			                %>
	<a href="<%=url%>" target="_blank">
	<%			                
			                   StringBuffer buf  = new StringBuffer();
			                   Iterator<String> itr_title=list_str.iterator();
			                   while(itr_title.hasNext())
			                   {
			                     buf.append(itr_title.next());
			                   }
				                %>
	<%=buf.toString()%> </a>
	<%				                
			                 }
                }
                else
		                {
		                %>
	<a href="<%=url%>" target="_blank"><%=title%></a>
	<%
		                
		                }
                // end title
                //start
		                //if(list_hl.containsKey("content"))
		                if(null!=list_hl.get("content"))
		                {
		                List<String> list_str2=list_hl.get("content");
			                if(list_str2.size()>0)
			                {
			                %>
	<div class="ss_jianjie">
		<%
			                StringBuffer buf2  = new StringBuffer();
			                Iterator<String> itr_content=list_str2.iterator();
			                  while(itr_content.hasNext())
			                  {
			                     buf2.append(itr_content.next());
				                  buf2.append("...");
			                  }				                
				                %>
		<%=buf2.toString()%> </div>
	<%				                   
			                }		                
		                } 
		                else
		                {
		                 if(null!=content)
		                 {
		                   if (content.length() >= 100) 
		                   {
		                     content = content.substring(0, 100);		                
		                   }
		                 }
		                %>
	<div class="ss_jianjie"><%=content%></div>
	<%		                
		                }
                 %>
	<div class="ss_dizhi"><%=url+"-"+datefmt%></div>
</div>
<%
}
            
 }
 else
 {
 %>
<span>没有查询到该关键词的相关数据,请更换关键词重新查询!</span>
<%
 
 }
 %>
<%
QueryPara qp=(QueryPara)request.getAttribute("queryParam");
  int pagecount=qp.getPagecount();
  int pageNo=qp.getPageNo();
  
  int pagesize=qp.getPagesize();
if(pagecount>1 )
  {
  %>
<div class="p">
	<%
  int perpagecount=10;
  
int startpage=pageNo%perpagecount!=0?(pageNo/perpagecount)*perpagecount+1:(pageNo/perpagecount)*perpagecount+1-perpagecount;
//int startpage = ((qp.pageNo + perpagecount - 1) / perpagecount - 1) * perpagecount+1;
int endpage=pageNo%perpagecount!=0?(pageNo/perpagecount+1)*perpagecount:(pageNo/perpagecount)*perpagecount;
//int endpage = ((qp.pageNo + perpagecount - 1) / perpagecount) * perpagecount;
endpage=endpage>pagecount?pagecount:endpage;

if(pageNo!=1)
{
%>
	<a href="<c:out value="${displayURL}" />&page=1">首页</a><a href="<c:out value="${displayURL}" />&page=<%=pageNo-1%>">上一页</a>
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
	<a href="<c:out value="${displayURL}" />&page=<%=startpage-1%>">&lt;&lt;</a>
	<%

}
for(int i=startpage;i<=endpage;i++)
{
if(i==pageNo)
{
%>
	<a href="<c:out value="${displayURL}" />&page=<%=Integer.toString(i)%>" style="color:red;"><%=Integer.toString(i)%></a>
	<%
continue;
}
%>
	<a href="<c:out value="${displayURL}" />&page=<%=Integer.toString(i)%>"><%=Integer.toString(i)%></a>
	<%

}
if(turnNo<turnCount)
{
%>
	<a href="<c:out value="${displayURL}" />&page=<%=endpage+1%>">&gt;&gt;</a>
	<%
}
if(pageNo!=pagecount)
{
%>
	<a href="<c:out value="${displayURL}" />&page=<%=pageNo+1%>">下一页</a><a href="<c:out value="${displayURL}" />&page=<%=pagecount%>">尾页</a>
	<%

}
else
{
%>
	下一页 尾页
	<%

}
  %>
</div>
<%
  }
%>
</body>
</html>
