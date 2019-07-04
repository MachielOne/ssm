package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.entity.Book;
import com.ssm.service.BookService;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext application = new ClassPathXmlApplicationContext("application-context.xml");
		BookService uService = (BookService) application.getBean("bookService");
		Book book = uService.selectById(2);
		System.out.println(book.getEmpAuthor() + "::" + book.getEmpTitle() + "::" + book.getHireDate());
	}
}
