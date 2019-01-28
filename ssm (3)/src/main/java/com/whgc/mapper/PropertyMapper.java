package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.Property;

public interface PropertyMapper {
	public int add(Property Property);

	public void delete(int id);

	public Property get(int id);

	public int update(Property Property);

	public List<Property> list();
}