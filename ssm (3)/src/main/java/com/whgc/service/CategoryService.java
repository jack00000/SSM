package com.whgc.service;

import java.util.List;

import com.whgc.pojo.Category;
import com.whgc.util.Page;
/**
 * service的工作 =执行多个mapper方法
 * @author 15581
 *
 */
public interface CategoryService {

	List<Category> list();
}
