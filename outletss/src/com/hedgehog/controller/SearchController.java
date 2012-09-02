package com.hedgehog.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hedgehog.Utils.QueryPara;
import com.hedgehog.Utils.SearchParameter;

@Controller
@RequestMapping("/search")
public class SearchController {	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String showHomePage(			  
			  @RequestParam(value="page", defaultValue="1") int page,
	          @RequestParam(value="perPage", defaultValue="10") int perPage,
	          @RequestParam(value="query",defaultValue="") String query,
	          @RequestParam(value="region",defaultValue="") String region,
	          @RequestParam(value="trade",defaultValue="") String trade,
			  ModelMap modelMap)   {
		   logger.info("进入搜索结果页面");
		   if(!StringUtils.hasLength(query))
		   {
			   return "redirect:/home";
		   }		   	   
		   HttpSolrServer solrServer = new HttpSolrServer("http://localhost/solr/core0/");	
		   SolrQuery solrquery = new SolrQuery();
		   solrquery.setQuery(query);  
		   
		   solrquery.setFacet(true);
		   
//		   if(!StringUtils.hasLength(region))
//		   {
//			   solrquery.addFacetField("{!key=地区}region");
//		   }		  
//		   if(!StringUtils.hasLength(trade))
//		   {
//			   solrquery.addFacetField("{!key=行业}trade" );
//		   }
		   
		   //solrquery.addFacetField(new String[] { "{!key=地区}region","{!key=行业}trade" });
		   solrquery.addFacetField(new String[] { "{!key=地区}region","{!key=行业}trade" });
		   
		   
		   solrquery.addFacetQuery("update:[2012-1-1T0:0:0Z TO 2012-12-31T0:0:0Z]");
		   solrquery.addFacetQuery("update:[2011-1-1T0:0:0Z TO 2011-12-31T0:0:0Z]");
		   solrquery.addFacetQuery("update:[1990-1-1T0:0:0Z TO 2010-12-31T0:0:0Z]");
		   
		  
		   
		   //solrquery.addDateRangeFacet(field, start, end, gap)
		      
		   Calendar calendar = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。 
		   calendar.set(1990, 1, 1);
		   Date start = calendar.getTime();
		   
		   calendar.set(2012, 12, 31);
		   Date end = calendar.getTime();
		   solrquery.addDateRangeFacet("update", start, end, "+1YEAR");
		   
		   //solrquery.addDateRangeFacet("update", "1990-1-1T0:0:0Z", "2012-12-31T0:0:0Z", gap)
//		   solrquery.add(params)
		   /**
		    * 过滤
		    */
		   if(StringUtils.hasLength(region))
		   {
			   solrquery.addFilterQuery("region:"+region);
	       }
		   
		   if(StringUtils.hasLength(trade))
		   {
			   solrquery.addFilterQuery("trade:"+trade); 
		   }
		   //solrquery.setFacetMinCount(1);
		   solrquery.setSortField("score", ORDER.desc);
		   solrquery.setFields(new String[]{"*","score"});
		   //solrquery.setFields(new String[]{"title","region","trade","content","update","link","score"});
		   solrquery.setStart((page-1)*perPage);
		   solrquery.setRows(perPage);
		   //ModifiableSolrParams params = new ModifiableSolrParams();
		   //params.add(solrquery);
		   
//		   ModifiableSolrParams params = new ModifiableSolrParams();		   
//		   params.set("q", query); //parabuf.toString()
//		   params.set("facet", true);		   
//		   params.set("facet.field", new String[] { "region","trade" });		   
//		   //params.set("fq", "update:[20100620 to 20100622]");		   
//		   params.set("start", (page-1)*perPage);  
//		   params.set("rows", perPage);		  
//		   // 排序，，如果按照id 排序，，那么将score desc 改成 id desc(or asc)  
//		   params.set("sort", "score desc");  
//		   // 返回信息  * 为全部  这里是全部加上score，如果不加下面就不能使用score  
//		   params.set("fl", "*,score");		   		   
         try {	   
		     QueryResponse rsp=solrServer.query(solrquery);		     
		     //List<Document> beans=rsp.getBeans(Document.class);	   
		     SolrDocumentList docs = rsp.getResults();			 
		     Map<String,Map<String,List<String>>> hl = rsp.getHighlighting();		     	            
		     modelMap.addAttribute("elapse", (double)rsp.getQTime()/1000);		     
		     QueryPara<SolrDocument> qp=new QueryPara<SolrDocument>();
		     qp.setPagesize(perPage);
		     qp.setPageNo(page);
		     qp.setRecordcount((int)docs.getNumFound());
		     qp.setPagecount(((int)docs.getNumFound() + qp.getPagesize() - 1) / qp.getPagesize());
		     modelMap.put("queryParam", qp);      
		     modelMap.addAttribute("docs", docs);
		     modelMap.addAttribute("hl", hl);
		     
		     /*
		      * 地区及分类facet
		      */
		     List<FacetField> facetFields = rsp.getFacetFields();  
		     
		     Iterator<FacetField> itr=facetFields.iterator();
	    	 FacetField fieldFacet=null;
	    	 while(itr.hasNext())
	    	 {
	    		 fieldFacet=itr.next();
	    		 logger.info(fieldFacet.getName());
	    		 if(fieldFacet.getValueCount()>0)
	    		 {
	    			 for (Count count : fieldFacet.getValues()) {
	    				 logger.info(count.getName()+"["+count.getCount()+"]\t");
						}		    			 
	    		 }
	    		 logger.info("-----------------------------------------------------");
	    	 }	
	    	  Map<String,Integer> map=rsp.getFacetQuery();
	    	  Iterator<String> it=map.keySet().iterator();
	    		 while(it.hasNext())
	    		 {							
	    			String param=it.next();	
	    			Integer value=map.get(param);
	    			logger.info(param);
	    			logger.info(String.valueOf(value));
					
	                
	    		}
		     /*
		      * 日期facet
		      */
		     List<FacetField> facetDates=rsp.getFacetDates();
		     Iterator<FacetField> itr2=facetDates.iterator();
	    	 FacetField fieldFacet2=null;
	    	 while(itr2.hasNext())
	    	 {
	    		 fieldFacet2=itr2.next();
	    		 logger.info(fieldFacet2.getName());
	    		 if(fieldFacet2.getValueCount()>0)
	    		 {
	    			 for (Count count : fieldFacet2.getValues()) {
	    				 logger.info(count.getName()+"["+count.getCount()+"]\t");
						}		    			 
	    		 }
	    		 logger.info("-----------------------------------------------------");
	    	 }		    	 
		     
		     modelMap.addAttribute("facetFields", facetFields);
		     
		  } catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	    return "search";
	  }
	@RequestMapping(value = {"/test"},method=RequestMethod.GET)
	public void showHomePagedh(			  
			  @RequestParam(value="page", defaultValue="1") int page,
	          @RequestParam(value="perPage", defaultValue="10") int perPage,
	          @RequestParam(value="query",defaultValue="") String query,
			  ModelMap modelMap)   {
		
		   HttpSolrServer solrServer = new HttpSolrServer("http://localhost/solr/core0/");
		   
		   
		   ModifiableSolrParams params = new ModifiableSolrParams();		   
		   //System.out.println("查询字符串："+parabuf.toString());
		   params.set("q", query); //parabuf.toString()
		   params.set("facet", true);
		   params.set("facet.field", "region");
		   
		   //params.set("fq", "update:[20100620 to 20100622]");		   
		   params.set("start", (page-1)*perPage);  
		   params.set("rows", perPage);		  
		   // 排序，，如果按照id 排序，，那么将score desc 改成 id desc(or asc)  
		   params.set("sort", "score desc");  
		   // 返回信息  * 为全部  这里是全部加上score，如果不加下面就不能使用score  
		   params.set("fl", "*,score");		   		   
         try {	   
		     QueryResponse rsp=solrServer.query(params);		     
		     //List<Document> beans=rsp.getBeans(Document.class);
		     SolrDocumentList docs = rsp.getResults();	
		     Iterator<SolrDocument> solrDocumentIterator =  docs.iterator();
		     while(solrDocumentIterator.hasNext()) {
		    	SolrDocument solrDocument = solrDocumentIterator.next();
		    	//do something useful here	
		        String id = (String) solrDocument.getFieldValue("id");
		        String title = (String) solrDocument.getFieldValue("title");
		        String region = (String) solrDocument.getFieldValue("region");
		        String trade = (String) solrDocument.getFieldValue("trade");
		        String url = (String) solrDocument.getFieldValue("link");
		        //System.out.println("日期格式："+solrDocument.getFieldValue("update"));
		        Date update = (Date) solrDocument.getFieldValue("update");
		        //response.getWriter().println(update);
		        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");//.format(news.getNewsUpdateTime());
		        String datefmt=df.format(update);
		        //String datefmt="date";
		        //df.format(news.getNewsUpdateTime())
		        String content = (String) solrDocument.getFieldValue("content"); 
		        logger.info(id);
		        logger.info(title);
		        logger.info(region);
		        logger.info(trade);
		        logger.info(content);
		        logger.info(url);
		        logger.info(datefmt);
		        logger.info("-------------------------SolrDocument黄金分割线----------------------------");
		     }
		     //Map<String,Map<String,List<String>>> hl = rsp.getHighlighting();		     	            
		     //modelMap.addAttribute("elapse", (double)rsp.getQTime()/1000);		     
		     //QueryPara<SolrDocument> qp=new QueryPara<SolrDocument>();
		     //qp.setPagesize(perPage);
		     //qp.setPageNo(page);
		     //qp.setRecordcount((int)docs.getNumFound());
		     //qp.setPagecount(((int)docs.getNumFound() + qp.getPagesize() - 1) / qp.getPagesize());
		     //modelMap.put("queryParam", qp);      
		     //modelMap.addAttribute("docs", docs);
		     //modelMap.addAttribute("hl", hl); 
		     
		     List<FacetField> facetFields = rsp.getFacetFields();  
		     if(facetFields.size()>0)
		     {
		    	 Iterator<FacetField> itr=facetFields.iterator();
		    	 FacetField fieldFacet=null;
		    	 while(itr.hasNext())
		    	 {
		    		 fieldFacet=itr.next();
		    		 logger.info(fieldFacet.getName());
		    		 if(fieldFacet.getValueCount()>0)
		    		 {
		    			 for (Count count : fieldFacet.getValues()) {
		    				 logger.info(count.getName()+"["+count.getCount()+"]\t");
							}		    			 
		    		 }
		    		 logger.info("-------------------------FacetField黄金分割线----------------------------");
		    	 }		    	 
		     }
		  } catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	   
	  }
}
