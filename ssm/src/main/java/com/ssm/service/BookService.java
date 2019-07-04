package com.ssm.service;

import java.util.List;

import com.ssm.entity.Book;

public interface BookService {
	public Book selectById(Integer id);

	public int updateItem(Book book);

	public int insertItem(Book book);

	public int deleteById(Integer id);

}
