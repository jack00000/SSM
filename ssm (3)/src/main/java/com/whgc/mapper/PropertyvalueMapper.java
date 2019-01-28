package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.Propertyvalue;

public interface PropertyvalueMapper {
	public int add(Propertyvalue Propertyvalue);

	public void delete(int id);

	public Propertyvalue get(int id);

	public int update(Propertyvalue Propertyvalue);

	public List<Propertyvalue> list();
}