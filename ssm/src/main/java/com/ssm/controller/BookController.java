package com.ssm.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.Book;
import com.ssm.service.BookService;

@Controller
public class BookController {
	private static final Logger log = Logger.getLogger(BookController.class);

	@Resource
	BookService bookService;

	@GetMapping("/books/{id}")
	@ResponseBody
	public Book retrieveBookById(@PathVariable int id, Model model) {
		Book book = bookService.selectById(id);
		log.info(book);
		// TODO
		return book;

	}
}
