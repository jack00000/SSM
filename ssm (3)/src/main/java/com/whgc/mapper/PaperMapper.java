package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.Paper;

public interface PaperMapper {
	public int add(Paper paper);

	public void delete(int id);

	public Paper get(int id);

	public int update(Paper paper);

	public List<Paper> list();

	public List<Paper> listByPage(int start, int end);

	public int getTotal();
	
	public int getIdByName(String name);
}