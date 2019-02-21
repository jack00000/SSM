package com.whgc.pojoData;

import java.util.List;

import com.whgc.pojo.Review;

/**
 * index界面中 文章具体内容类
 * @author esesoft
 *
 */
public class IndexPaperDetailData {
	private int id;
	private int uid;
	private int cid;
	private String img;
	private String title;
	private String description;
	private String updateTime;
	private String wordSum;
	private String content;
	private List<Review> comments;
	public List<Review> getComments() {
		return comments;
	}
	public void setComments(List<Review> comments) {
		this.comments = comments;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getWordSum() {
		return wordSum;
	}
	public void setWordSum(String wordSum) {
		this.wordSum = wordSum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	
	
	
	
	
}
