package com.whgc.pojoData;

import java.util.List;

import com.whgc.pojo.Review;

public class UpdatingData {
	private String avatar;
	private String name;
	private String time;
	private String updatings;
	private String img;
	private String viewCount;
	private String commentCount;
	private String zanCount;
	private List<Review> comments;

	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUpdatings() {
		return updatings;
	}
	public void setUpdatings(String updatings) {
		this.updatings = updatings;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	public String getZanCount() {
		return zanCount;
	}
	public void setZanCount(String zanCount) {
		this.zanCount = zanCount;
	}
	public List<Review> getComments() {
		return comments;
	}
	public void setComments(List<Review> comments) {
		this.comments = comments;
	}
}
