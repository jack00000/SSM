package com.whgc.pojoData;

import java.util.List;

import com.whgc.pojo.Tags;

/**
 * index界面的文章简介数据类
 * 
 * @author esesoft
 *
 */
public class IndexData {
	private String title;
	private String description;
	private String imgUrl;
	private List<Tags> tags;
	private int paperId;

	

	


	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}



	
	

}
