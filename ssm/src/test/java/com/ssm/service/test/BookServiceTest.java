package com.ssm.service.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.entity.Book;
import com.ssm.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class BookServiceTest {
	private static Logger log = Logger.getLogger(BookServiceTest.class);

	@Resource
	private BookService bookService;

	/* @Before */
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		bookService = (BookService) context.getBean("bookService");
	}

	@Test
	public void test() {
		Book book = bookService.selectById(2);
		log.info(book.getEmpAuthor() + "::" + book.getEmpTitle() + "::" + book.getHireDate());

	}

}
