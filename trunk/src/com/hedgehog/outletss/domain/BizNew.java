package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA


import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *        @hibernate.class
 *         table="biz_news"
 *     
 */
@Entity
@Table(name="biz_news")
@org.hibernate.annotations.Proxy(lazy = false)
public class BizNew  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="NewsID"
 *         
     */
     private String newsId;
     /**
      *            @hibernate.property
 *             column="News_title"
 *             length="250"
 *         
     */
     private String newsTitle;
     /**
      *            @hibernate.property
 *             column="News_cate"
 *             length="40"
 *         
     */
     private String newsCate;
     /**
      *            @hibernate.property
 *             column="News_content"
 *             length="65535"
 *         
     */
     private String newsContent;
     /**
      *            @hibernate.property
 *             column="News_keywords"
 *             length="200"
 *         
     */
     private String newsKeywords;
     /**
      *            @hibernate.property
 *             column="News_summery"
 *             length="500"
 *         
     */
     private String newsSummery;
     /**
      *            @hibernate.property
 *             column="News_Properties"
 *             length="15"
 *         
     */
     private String newsProperties;
     /**
      *            @hibernate.property
 *             column="News_updatetime"
 *             length="19"
 *         
     */
     private Timestamp newsUpdatetime;
     
     private String newsSource;
     private Integer newsHits;

    
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="NewsID"
     *         
     */
     @Id
  	@Column(name = "NewsID",length =40,unique=true, nullable=false)	
  	@GeneratedValue(generator = "system-uuid")
  	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String getNewsId() {
        return this.newsId;
    }
    
    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }
    /**       
     *      *            @hibernate.property
     *             column="News_title"
     *             length="250"
     *         
     */
    @Column(name="News_title",length=250)
    public String getNewsTitle() {
        return this.newsTitle;
    }
    
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    /**       
     *      *            @hibernate.property
     *             column="News_cate"
     *             length="40"
     *         
     */
    @Column(name="News_cate",length=40)
    public String getNewsCate() {
        return this.newsCate;
    }
    
    public void setNewsCate(String newsCate) {
        this.newsCate = newsCate;
    }
    /**       
     *      *            @hibernate.property
     *             column="News_content"
     *             length="65535"
     *         
     */
    @Column(name="News_content",length=65535)
    public String getNewsContent() {
        return this.newsContent;
    }
    
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
    /**       
     *      *            @hibernate.property
     *             column="News_keywords"
     *             length="200"
     *         
     */
    @Column(name="News_keywords",length=200)
    public String getNewsKeywords() {
        return this.newsKeywords;
    }
    
    public void setNewsKeywords(String newsKeywords) {
        this.newsKeywords = newsKeywords;
    }
    /**       
     *      *            @hibernate.property
     *             column="News_summery"
     *             length="500"
     *         
     */
    @Column(name="News_summery",length=500)
    public String getNewsSummery() {
        return this.newsSummery;
    }
    
    public void setNewsSummery(String newsSummery) {
        this.newsSummery = newsSummery;
    }
    /**       
     *      *            @hibernate.property
     *             column="News_Properties"
     *             length="15"
     *         
     */
    @Column(name="News_Properties",length=15)
    public String getNewsProperties() {
        return this.newsProperties;
    }
    
    public void setNewsProperties(String newsProperties) {
        this.newsProperties = newsProperties;
    }
    /**       
     *      *            @hibernate.property
     *             column="News_updatetime"
     *             length="19"
     *         
     */
    @Column(name="News_updatetime",length=19)
    public Timestamp getNewsUpdatetime() {
        return this.newsUpdatetime;
    }
    
    public void setNewsUpdatetime(Timestamp newsUpdatetime) {
        this.newsUpdatetime = newsUpdatetime;
    }
    
    @Column(name="News_source",length=100)
    public String getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}
	@Column(name="News_hits",length=10)
	public Integer getNewsHits() {
		return newsHits;
	}

	

	public void setNewsHits(Integer newsHits) {
		this.newsHits = newsHits;
	}

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


