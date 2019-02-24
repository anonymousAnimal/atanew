package com.ata.dao;

import java.util.ArrayList;

public interface XyzDao<T>
{
	
	String create(T t);
	int delete(ArrayList<String> list);
	boolean update(T t);
	T findByID(String s);
	ArrayList<T>findAll();
}
