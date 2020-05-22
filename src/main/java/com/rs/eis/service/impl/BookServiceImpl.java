package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Book;
import com.rs.eis.repository.BookRepository;
import com.rs.eis.request.AddBookVO;
import com.rs.eis.response.AddBookResponse;
import com.rs.eis.response.DeleteBookResponse;
import com.rs.eis.response.EditBookResponse;
import com.rs.eis.response.GetBookResponse;
import com.rs.eis.service.BookService;
import com.rs.eis.util.BookUtil;
import com.rs.eis.util.DateUtil;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public AddBookResponse addBookResponse(AddBookVO addBookVO) {

		AddBookResponse response = new AddBookResponse();

		Optional<Book> bookObj = bookRepository.findByName(addBookVO.getName());

		if(bookObj.isPresent()) {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Book is already registered");
		}else {

			Book book = BookUtil.loadAddBookVOToBook(addBookVO);

			book = bookRepository.save(book);

			response.setBook(book);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} 
		return response;
	}

	@Override
	public EditBookResponse editBook(Book book) {
		EditBookResponse response = new EditBookResponse();

		Optional<Book> bookObj = bookRepository.findById(book.getId());

		if (bookObj.isPresent()) {

			book.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			book = bookRepository.save(book);

			response.setBook(book);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as bookid is not present in book table");
		}

		return response;
	}

	@Override
	public GetBookResponse getBookById(int id) {

		GetBookResponse response = new GetBookResponse();
		Optional<Book> bookObj = bookRepository.findById(id);
		if (bookObj.isPresent()) {
			response.setBook(bookObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Book Found for the given bookid");
		}

		return response;
	}
	

	@Override
	public DeleteBookResponse deleteBook(int id) {
		DeleteBookResponse response = new DeleteBookResponse();

		Optional<Book> bookObj = bookRepository.findById(id);

		if (bookObj.isPresent()) {
			Book book = bookObj.get();
			bookRepository.delete(book);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as bookId is not present in book table");
		}

		return response;

	}

}
