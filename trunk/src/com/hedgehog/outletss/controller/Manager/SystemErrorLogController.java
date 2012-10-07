package com.hedgehog.outletss.controller.Manager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hedgehog.outletss.domain.FileTxtLogsTable;
import com.hedgehog.outletss.service.FileTxtLogs;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemMaintenance/SystemErrorLog")
public class SystemErrorLogController {
	@RequestMapping(value={"/Default"},method=GET,params="!CMD")
	public String right(
			@RequestParam(value="filename",required = false) String filename,
			ModelMap modelMap) 
	{	
		//List<FileTxtLogsTable> list=FileTxtLogs.GetFileTxtLogs("20121006AppErrorLog.txt");
		//Collections.sort(list);
		List<Map.Entry<Date, String>> filelist=FileTxtLogs.GetFileList();
		List<FileTxtLogsTable> list=FileTxtLogs.GetFileTxtLogs(filelist.get(0).getValue());
		if(filename!=null)
		{
			list=FileTxtLogs.GetFileTxtLogs(filename);			
		}		
		Collections.sort(list);
		modelMap.addAttribute("filelist", filelist);
		modelMap.addAttribute("list", list);
		return "SystemErrorLog/Default";		
	}
	@RequestMapping(value={"/Default"},method=GET,params="CMD=Delete")
	public String rightpost(
			@RequestParam(value="FileLogList") String FileLogList,
			ModelMap modelMap) 
	{	
		System.out.println("选择文件："+FileLogList);
		return "SystemErrorLog/Default";		
	}

}
