package com.hedgehog.outletss.Utils;

import java.io.IOException;  
import java.net.URLEncoder;  
  
import javax.servlet.jsp.JspException;  
import javax.servlet.jsp.JspWriter;  
import javax.servlet.jsp.tagext.TagSupport;  
  
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;  

public class EncodeTag extends TagSupport{
	private Object key;//�Զ����ǩ��key����  
	  
    public void setKey(Object key) throws JspException {  
        this.key=ExpressionEvaluatorManager.evaluate("key", key.toString(), Object.class, this, pageContext);  
  
    }  
    public int doEndTag() {  
        try {// ʹ��JspWriter���JSP���������  
            JspWriter jspWriterOutput = pageContext.getOut();  
            jspWriterOutput.write(URLEncoder.encode(key.toString(),"utf-8"));  
        } catch (IOException ioEx) {  
            System.out.println("IOException in HelloTag " + ioEx);  
        }  
        return EVAL_PAGE;  
    }  

}
