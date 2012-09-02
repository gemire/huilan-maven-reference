package com.hedgehog.Utils;

public class SearchParameter implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String query;
	private String regionname;
	private String tradename;
	private String pubdate;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	public String getTradename() {
		return tradename;
	}
	public void setTradename(String tradename) {
		this.tradename = tradename;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

}
