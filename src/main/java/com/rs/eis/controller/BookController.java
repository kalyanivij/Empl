package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Book;
import com.rs.eis.repository.BookRepository;
import com.rs.eis.request.AddBookVO;
import com.rs.eis.response.AddBookResponse;
import com.rs.eis.response.DeleteBookResponse;
import com.rs.eis.response.EditBookResponse;
import com.rs.eis.response.GetBookResponse;
import com.rs.eis.service.BookService;
import com.rs.eis.validation.BookValidationUtil;

@RestController
@RequestMapping("/eis")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	BookValidationUtil bookValidationUtil;

	@Autowired
	BookRepository bookRepository;

//	private int expenseId;

	@PostMapping("/book")
	public AddBookResponse addBookResponse(@Valid @RequestBody AddBookVO addBookVO) {

		Set<String> errorMessages = bookValidationUtil.validateAddBookRequest(addBookVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddBookResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return bookService.addBookResponse(addBookVO);
		}
	}

	@PutMapping("/book/{id}")
	public EditBookResponse editBook(@PathVariable("id") int id, @Valid @RequestBody Book book) {
		/*
		 * Set<String> errorMessages =
		 * libraryValidationUtil.validateEditEmployeeRequest(id); if
		 * (!CollectionUtils.isEmpty(errorMessages)) { return new
		 * EditEmployeeResponse(); } else {
		 */
		return bookService.editBook(book);
	}

	@DeleteMapping("/book/{id}")
	public DeleteBookResponse deleteBook(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = bookValidationUtil.validateDeleteBookRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteBookResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return bookService.deleteBook(id);
		}
	}

	@GetMapping("/book/{id}")
	public GetBookResponse getBookById(@PathVariable("id") int id) {
		Set<String> errorMessages = bookValidationUtil.validateGetBookRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetBookResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return bookService.getBookById(id);
		}
	}
}
