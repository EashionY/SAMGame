package com.mistytech.base;

import java.util.List;

public interface BaseService<T> {
	public List<T> findAll();
	public List<T> pageQuery(Integer page,Integer count);
	public void update(T entity) throws Exception;
	public void removeById(Integer id) throws Exception;
	public void insert(T entity) throws Exception;
	public T findById(Integer entityId);
}
