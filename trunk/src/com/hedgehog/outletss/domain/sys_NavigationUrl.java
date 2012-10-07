package com.hedgehog.outletss.domain;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

public class sys_NavigationUrl implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String _btnText;            // 按妞的文字
    private String _btnUrl;             // 按钮的地址
    private String _btnHint;            // 按钮的提示信息
     private UrlType _btnType = UrlType.Href;
     private boolean _btnDefaultSelect = false;
     public sys_NavigationUrl()
     {    	 
    	 this(null, null,null,UrlType.Href,true);
     }
     public sys_NavigationUrl(String bText, String bUrl, String bHint, UrlType bType,boolean bDefautl)
     {
         this._btnText = bText;         
         this._btnUrl = bUrl;            
         this._btnHint = bHint;
         this._btnType = bType;
         this._btnDefaultSelect = bDefautl;
     }

	public String get_btnText() {
		return _btnText;
	}

	public void set_btnText(String text) {
		_btnText = text;
	}

	public String get_btnUrl() {
		return _btnUrl;
	}

	public void set_btnUrl(String url) {
		_btnUrl = url;
	}

	public String get_btnHint() {
		return _btnHint;
	}

	public void set_btnHint(String hint) {
		_btnHint = hint;
	}

	public UrlType get_btnType() {
		return _btnType;
	}

	public void set_btnType(UrlType type) {
		_btnType = type;
	}

	public boolean is_btnDefaultSelect() {
		return _btnDefaultSelect;
	}

	public void set_btnDefaultSelect(boolean defaultSelect) {
		_btnDefaultSelect = defaultSelect;
	}
	public enum UrlType
    { Href,JavaScript,VBScript}
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
