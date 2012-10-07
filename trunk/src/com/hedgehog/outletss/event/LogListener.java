package com.hedgehog.outletss.event;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hedgehog.outletss.domain.SysEvent;
import com.hedgehog.outletss.service.SysEventService;


/**
 * 事件监听器 observor  多方
 * @author Administrator
 *
 */
@Component("logListener")
public class LogListener implements ApplicationListener<LogEvent>{	
	private static final Log logger = LogFactory.getLog(LogListener.class);
	private SysEventService sysEventService;	
	@Autowired
	public void setSysEventService(SysEventService sysEventService) {
		this.sysEventService = sysEventService;
	}	
	@Override
	public void onApplicationEvent(LogEvent event) {
		// TODO Auto-generated method stub		
		//获取事件传递参数		
		SysEvent sysEvent=(SysEvent)event.getSource();
		this.sysEventService.saveOrUpdate(sysEvent);
	}
}
