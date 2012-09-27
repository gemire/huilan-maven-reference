package com.hedgehog.outletss.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysSystemInfo;


public class FrameSystemInfo {
	public static SysSystemInfo GetSystemInfoTable = null;
	private static SysSystemInfoService systemInfoService=new SysSystemInfoServiceImpl();
	
	static
	{
		if(GetSystemInfoTable==null)
		{
			SysSystemInfo si=new SysSystemInfo();
			
			QueryPara<SysSystemInfo> qp=new QueryPara<SysSystemInfo>();
			qp.setClazz(SysSystemInfo.class);			
			//SystemInfoService systemInfoService=new SystemInfoServiceImpl();
			List<SysSystemInfo> list=systemInfoService.getListForPage(qp);
			if(qp.getRecordcount()==0)
			{
				systemInfoService.saveOrUpdate(si);
			}
			else
			{
				si=list.get(0);				
			}
			GetSystemInfoTable=si;
		}
		
		
	}
	

}
