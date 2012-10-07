/**
 * 
 */
package com.hedgehog.outletss.domain;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class FileTxtLogsTable implements Comparable<FileTxtLogsTable> {
	
	private Date _LogDate;
    private String _LogTxt;
    private String _LogUserIp;
    private String _LogErrorUrl;
    
    public FileTxtLogsTable()
    {
    	
    }

	public FileTxtLogsTable(Date _LogDate, String _LogTxt, String _LogUserIp,
			String _LogErrorUrl) {
		super();
		this._LogDate = _LogDate;
		this._LogTxt = _LogTxt;
		this._LogUserIp = _LogUserIp;
		this._LogErrorUrl = _LogErrorUrl;
	}



	public Date get_LogDate() {
		return _LogDate;
	}



	public void set_LogDate(Date _LogDate) {
		this._LogDate = _LogDate;
	}



	public String get_LogTxt() {
		return _LogTxt;
	}



	public void set_LogTxt(String _LogTxt) {
		this._LogTxt = _LogTxt;
	}



	public String get_LogUserIp() {
		return _LogUserIp;
	}



	public void set_LogUserIp(String _LogUserIp) {
		this._LogUserIp = _LogUserIp;
	}



	public String get_LogErrorUrl() {
		return _LogErrorUrl;
	}



	public void set_LogErrorUrl(String _LogErrorUrl) {
		this._LogErrorUrl = _LogErrorUrl;
	}



	@Override
	public int compareTo(FileTxtLogsTable o) {
		// TODO Auto-generated method stub
		return this._LogDate.compareTo(o.get_LogDate());
	}

}
