package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.Paperimage;

public interface PaperimageMapper {
	public int add(Paperimage Paperimage);

	public void delete(int id);

	public Paperimage get(int id);

	public int update(Paperimage Paperimage);

	public List<Paperimage> list();
}