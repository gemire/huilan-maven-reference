/**
 * 
 */
package com.hedgehog.outletss.controller.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 文件系统采集
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/FileManager")
public class FileManagerController {
	/**
	 * 本地文件
	 * @return
	 */
	@RequestMapping(value={"/localFileList"},method=RequestMethod.GET)
	public String asddfh()
	{
		return "Manager/Module/FrameWork/SystemApp/FileManager/localFileList";
	}

}
