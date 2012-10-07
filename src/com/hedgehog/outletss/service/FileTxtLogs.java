package com.hedgehog.outletss.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hedgehog.outletss.domain.FileTxtLogsTable;

public class FileTxtLogs {
	private static final String filepath=System.getProperty("maven.outletss.root")+"WEB-INF\\logs\\";
	/**
	 * 写入异常信息 调用api
	 * @param input
	 * @param ip
	 * @param url
	 * @return
	 */
	public static boolean WriteLog(String input,String ip,String url)
	{
		return WriteLog(input, "AppError",ip,url);
	}
	
	public static boolean WriteLog(String input, String FileName,String ip,String url)
	{
		boolean rBool = true;
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
		File f=new File(filepath);		
		if(!f.exists())
		{
			f.mkdirs();
		} 
		f=new File(filepath+simpleDateFormat.format(new Date())+FileName+"Log.txt");
		//simpleDateFormat.format(new Date())+FileName+"Log.txt"
		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			FileWriter fw = new FileWriter(f,true);
			PrintWriter out = new PrintWriter(fw,true);  
			StringBuffer sb=new StringBuffer();
			sb.append(simpleDateFormat2.format(new Date()));
			sb.append("|");
			sb.append(input.replace("\r", "").replace("\n", "<br />"));
			sb.append("|");
			sb.append(ip);
			sb.append("|");
			sb.append(url);
			sb.append("\r\n");
			out.print(sb.toString());  
			//out.flush();
			out.close();
			//fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			rBool=false;
			System.out.println(e.getMessage());
		}
		return rBool;		
	}
	/**
	 * 读取异常信息 调用api
	 * @param realFileName
	 * @return
	 */
	public static List<FileTxtLogsTable> GetFileTxtLogs(String realFileName)
	{
		//String FileName="AppError";
		//SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
		//String realFileName=simpleDateFormat.format(new Date())+FileName+"Log.txt";
		
		String FilePath=filepath+realFileName;
		final List<FileTxtLogsTable> list=new ArrayList<FileTxtLogsTable>();
		final SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		GetFileTxtLogs(FilePath,new FileLoading()
		{
			@Override
			public void row(String line) throws ParseException {
				// TODO Auto-generated method stub				
					String[] strarr=line.split("\\|");					
					FileTxtLogsTable fileTxtLogsTable=new FileTxtLogsTable(simpleDateFormat2.parse(strarr[0]),strarr[1],strarr[2],strarr[3]);
					list.add(fileTxtLogsTable);		
			}			
		});
		return list;		
	}
	
	public static void GetFileTxtLogs(String FilePath,FileLoading loading)
	{
		//InputStream
		File f=new File(FilePath);
		String record = null;
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br = new BufferedReader(fr); 
			//LineNumberReader dd=null;
			while ((record = br.readLine()) != null) {
				
				loading.row(record);
		     }
			br.close();
			fr.close();
//			char[] buf=new char[1024];
//			
//				int len=in.read(buf);
//				System.out.println(new String(buf,0,len));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	private interface FileLoading {			
		void row(String line) throws ParseException;
	}
	/**
	 * 删除文件
	 * @param path
	 * @return
	 */
	public static boolean DeleteFile(String path)
	{
		File f=new File(filepath+path);
		if(f.exists())
		{
			return f.delete();			
		}
		return false;
	}
	/**
	 * 获取日志目录下文件列表
	 * @return
	 */
	public static List<Map.Entry<Date, String>> GetFileList()
	{
		Map<Date, String> FileList=new HashMap<Date, String>();		
		File f=new File(filepath);
		File[] files=f.listFiles(new FileFilter()
		{
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub				
				if(pathname.getName().equalsIgnoreCase("mini-web.log"))
				{
					return false;
				}
				return true;
			}			
		});
		for(File fl:files)
		{
			FileList.put(new Date(fl.lastModified()), fl.getName());			
		}		
		List<Map.Entry<Date, String>> arrayLis =new ArrayList<Map.Entry<Date, String>>(FileList.entrySet()); 
		Collections.sort(arrayLis,new Comparator<Map.Entry<Date, String>>()
		{
			@Override
			public int compare(Map.Entry<Date, String> o1, Map.Entry<Date, String> o2) {
				// TODO Auto-generated method stub
				if(o1.getKey().after(o2.getKey()))
				{
					return -1;
				}
				else if(o1.getKey().before(o2.getKey()))
				{
					return 1;
				}
				else
				{
					return 0;
				}
				//return o1.getKey().compareTo(o2.getKey());				
			}			
		});		
		return arrayLis;		
	}
}
