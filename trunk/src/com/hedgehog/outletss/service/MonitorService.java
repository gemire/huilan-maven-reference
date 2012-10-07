/**
 * 
 */
package com.hedgehog.outletss.service;

import com.hedgehog.outletss.domain.MonitorInfoBean;

/**
 * @author Administrator
 *
 */
public interface MonitorService {
	/** *//** 
     * 获得当前的监控对象. 
     * @return 返回构造好的监控对象 
     * @throws Exception 
     * @author amgkaka 
     * Creation date: 2008-4-25 - 上午10:45:08 
     */  
    public MonitorInfoBean getMonitorInfoBean() throws Exception;  

}
