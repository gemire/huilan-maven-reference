/**
 * 
 */
package com.hedgehog.outletss.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.hedgehog.outletss.service.FileTxtLogs;



/**
 * @author Administrator
 *
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
	
	private static final Log log = LogFactory.getLog(MyExceptionHandler.class);
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		 String url = request.getRequestURI();
         String param =request.getQueryString();
         if (param != null &&param.length() > 0) {
                   url += ("?" +param);
         }
         //Date date=new Date();
         String ipaddr=request.getRemoteAddr();
         
         Map<String,Object> map = new HashMap<String,Object>();  
         StringPrintWriter strintPrintWriter = new StringPrintWriter();  
         ex.printStackTrace(strintPrintWriter);
         //写入异常记录文本文件 写入OutputStream 读取 InputStream
         
         FileTxtLogs.WriteLog("访问路径:"+url+"<br>"+strintPrintWriter.getString().replace("\r", "").replace("\n", "<br />")+"<br />", ipaddr, url);        
         
         map.put("exception", strintPrintWriter.getString());//将错误信息传递给view  
         
		return new ModelAndView("errorpages/failure",map); 
	}
	class StringPrintWriter extends PrintWriter{  
		  
	    public StringPrintWriter(){  
	        super(new StringWriter());  
	    }  
	     
	    public StringPrintWriter(int initialSize) {  
	          super(new StringWriter(initialSize));  
	    }  
	     
	    public String getString() {  
	          flush();  
	          return ((StringWriter) this.out).toString();  
	    }  
	     
	    @Override  
	    public String toString() {  
	        return getString();  
	    }  
	}  

}
