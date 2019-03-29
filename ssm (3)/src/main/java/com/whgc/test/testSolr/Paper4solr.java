package com.whgc.test.testSolr;

import org.apache.solr.client.solrj.beans.Field;

public class Paper4solr {
	 @Field
	private int id;
	 @Field
	private int uid;
	 @Field
	private int cid;
	 @Field
	private String title;
	 @Field
	private String content;
	 @Field
	private String description;
	 @Field
	private String updatetime;
	 @Field
	 private String tags;
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}


}
