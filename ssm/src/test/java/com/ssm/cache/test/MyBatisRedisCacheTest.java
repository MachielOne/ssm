package com.ssm.cache.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.entity.Book;
import com.ssm.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-context.xml" })
public class MyBatisRedisCacheTest {
	private static final Logger log = Logger.getLogger(MyBatisRedisCacheTest.class);
	@Resource
	BookService bookService;

	@Test
	public void test1() {
		List<Book> bookList = bookService.selectAll();
		bookList.forEach(book -> {
			log.info("selectAll(): " + book.getEmpAuthor() + "::" + book.getEmpTitle() + "::" + book.getHireDate());
		});
	}

	@Test
	public void test2() {
		Book book = bookService.selectById(3);
		log.info("selectById(): " + book.getEmpAuthor() + "::" + book.getEmpTitle() + "::" + book.getHireDate());
	}

	@Test
	public void test3() {
		Book bookItem = new Book();
		bookItem.setEmpAuthor("韓寒");
		bookItem.setEmpTitle("后会无期");
		bookItem.setHireDate(new Date());
		int itemCount = bookService.insertItem(bookItem);
		log.info("insertItem(): " + itemCount);
	}
}
