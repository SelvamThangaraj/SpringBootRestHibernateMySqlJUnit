package org.spring.web.controller;

import org.spring.web.model.Book;
import org.spring.web.service.CrudUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the Book management.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

	
	@Autowired
	CrudUtilService crudUtil;

	@ModelAttribute("book")
	public Book creatBookModel() {
		return new Book();
	}

	@RequestMapping(value = "/showbook", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showAddForm() {
		System.out.println("Inside showbook method");
		return new ModelAndView("addBook");
	}

	@RequestMapping(value = "/book/save",method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult) {
				
		crudUtil.addBook(book);
		System.out.println("addBook() =>"+book);

		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showEditForm(@PathVariable String id) {

		Book book = crudUtil.getBook(Long.valueOf(id)).get();
		return new ModelAndView("updateBook", "book", book);
	}

	@RequestMapping(value = "/book/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public String updateBook(@ModelAttribute Book book, BindingResult bindingResult) {
	
		
		crudUtil.updateBook(book);
		
		return "redirect:/book/list"; 
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteBook(@PathVariable String id) {
        System.out.println("inside deleteBook() for id="+id);
        String status=crudUtil.deleteBook(Long.valueOf(id));
        return "redirect:/book/list"; 
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView listBooks() {

		Iterable<Book> bookList = crudUtil.getAllBooks();
		return new ModelAndView("listBooks", "bookList", bookList);
	}

}
