package com.ssm.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.ssm.entity.Book;
import com.ssm.service.BookService;

@Controller
public class BookController {
	private static final Logger log = Logger.getLogger(BookController.class);

	@Resource
	BookService bookService;

	@GetMapping("/books")
	@ResponseBody
	public List<Book> selectAll() {
		List<Book> list = bookService.selectAll();
		list.forEach(item -> {
			log.info("selectAll:" + item.toString());
		});
		return list;
	}

	@GetMapping("/books/{id}")
	@ResponseBody
	public Book selectById(@PathVariable int id) {
		Book book = bookService.selectById(id);
		log.info("selectById: " + book.toString());
		return book;
	}

	@GetMapping("/jsp/books/{id}")
	public String selectById(@PathVariable int id, Model model) {
		model.addAttribute("book", bookService.selectById(id));
		return "show";
	}

	@PostMapping("/book")
	public String insert(Book book) {
		book.setEmpTitle("IT");
		book.setEmpAuthor("建陽文化");
		book.setHireDate(new Date());
		int statusCode = bookService.insertItem(book);
		if (statusCode == 0)
			return "success";
		else
			return "failure";
	}
}
