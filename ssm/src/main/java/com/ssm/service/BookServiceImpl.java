package com.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssm.dao.BookMapper;
import com.ssm.entity.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource
	private BookMapper bookMapper;

	public Book selectById(Integer id) {
		return this.bookMapper.selectByPrimaryKey(id);
	}

	public int updateItem(Book book) {
		return this.bookMapper.updateByPrimaryKey(book);
	}
	
	public int insertItem(Book book) {
		return this.bookMapper.insert(book);
	}

	public int deleteById(Integer id) {
		return this.bookMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Book> selectAll() {
		return this.bookMapper.selectAll();
	}

}
