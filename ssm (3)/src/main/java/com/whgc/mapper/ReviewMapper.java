package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.Review;

public interface ReviewMapper {
	public int add(Review Review);

	public void delete(int id);

	public Review get(int id);

	public int update(Review Review);

	public List<Review> list();
	
	public List<Review> getByPid(int pid);
}