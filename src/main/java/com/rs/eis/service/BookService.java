package com.rs.eis.service;


import com.rs.eis.model.Book;
import com.rs.eis.request.AddBookVO;
import com.rs.eis.response.AddBookResponse;
import com.rs.eis.response.DeleteBookResponse;
import com.rs.eis.response.EditBookResponse;
import com.rs.eis.response.GetBookResponse;

public interface BookService {
	/*
	 * AddBookResponse addBook(AddBookVO addBookVO);
	 */

	AddBookResponse addBookResponse(AddBookVO addBookVO);
	
	EditBookResponse editBook(Book book);

	GetBookResponse getBookById(int id);

	DeleteBookResponse deleteBook(int id);

}
