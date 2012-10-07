package com.hedgehog.outletss.domain;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.util.ArrayList;
import java.util.List;

public class MessageBox implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String _M_Title = "信息提示标题";
    private String _M_Body = "信息提示内容";
    private Icon_Type _M_IconType = Icon_Type.OK;
    private List<sys_NavigationUrl> _M_ButtonList = new ArrayList<sys_NavigationUrl>();
    private int _M_Type =1;//信息类型: 1操作日志,2安全日志,3访问日志 (默认1)
    private boolean _M_WriteToDB = true;
    private String _M_ReturnScript ; 
    

	public String get_M_Title() {
		return _M_Title;
	}

	public void set_M_Title(String title) {
		_M_Title = title;
	}

	public String get_M_Body() {
		return _M_Body;
	}

	public void set_M_Body(String body) {
		_M_Body = body;
	}

	public Icon_Type get_M_IconType() {
		return _M_IconType;
	}

	public void set_M_IconType(Icon_Type iconType) {
		_M_IconType = iconType;
	}

	public List<sys_NavigationUrl> get_M_ButtonList() {
		return _M_ButtonList;
	}

	public void set_M_ButtonList(List<sys_NavigationUrl> buttonList) {
		_M_ButtonList = buttonList;
	}

	public int get_M_Type() {
		return _M_Type;
	}
	/**
	 * 信息类型: 1操作日志,2安全日志,3访问日志 (默认1)
	 * @param type
	 */
	public void set_M_Type(int type) {
		_M_Type = type;
	}

	public boolean is_M_WriteToDB() {
		return _M_WriteToDB;
	}

	public void set_M_WriteToDB(boolean writeToDB) {
		_M_WriteToDB = writeToDB;
	}

	public String get_M_ReturnScript() {
		return _M_ReturnScript;
	}

	public void set_M_ReturnScript(String returnScript) {
		_M_ReturnScript = returnScript;
	}
	
	public enum Icon_Type
    {OK,Alert,Error}
	
	// plumbing
    @Override
    public boolean equals(Object obj) {
      return reflectionEquals(this, obj);
    }
    
    @Override
    public int hashCode() {
      return reflectionHashCode(this);
    }
    
    @Override
    public String toString() {
      return reflectionToString(this);
    }
}

