package com.hedgehog.outletss.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.hedgehog.outletss.domain.SysEvent;

/**
 * 事件发布者 主题 subject
 * @author Administrator
 *
 */
@Component("logPublisher")
public class LogPublisher implements ApplicationContextAware{
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
		
	}
	/**
	 * 发布事件
	 * @param log
	 * @return
	 */	
	public void publishEvent(SysEvent sysEvent) {
		/**
		 * 事件传递参数
		 */
		LogEvent event = new LogEvent(sysEvent);
		this.applicationContext.publishEvent(event);		
	}

}
