package com.ata.dao.ex;

import java.util.ArrayList;

public interface XyzDao<T>
{
	
	String create(T t);
	int delete(ArrayList<String> list, Class<T> cls);
	boolean update(T t, Class<T> cls);
	T findByID(String s, Class<T> cls);
	ArrayList<T>findAll();
}

