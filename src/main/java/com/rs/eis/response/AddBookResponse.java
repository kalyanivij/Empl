package com.rs.eis.response;

import java.awt.print.Book;
import java.util.Set;

import org.springframework.http.HttpStatus;


public class AddBookResponse extends AbstractResponse{
	private Book book;

	public AddBookResponse() {

	}

	public AddBookResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}



}
