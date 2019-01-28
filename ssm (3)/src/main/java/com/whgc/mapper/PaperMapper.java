package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.News;

public interface PaperMapper {
	public int add(News news);

	public void delete(int id);

	public News get(int id);

	public int update(News news);

	public List<News> list();
}