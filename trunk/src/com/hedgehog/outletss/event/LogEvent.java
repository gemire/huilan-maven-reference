package com.hedgehog.outletss.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 可以补充其他事件参数
 * @author Administrator
 *
 */
public class LogEvent extends ApplicationEvent{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LogEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
