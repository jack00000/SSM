package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.News;
import com.whgc.pojo.Paper;

public interface PaperMapper {
	public int add(Paper paper);

	public void delete(int id);

	public News get(int id);

	public int update(Paper paper);

	public List<Paper> list();
}