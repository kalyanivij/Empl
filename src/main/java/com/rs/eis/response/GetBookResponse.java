package com.rs.eis.response;

import java.awt.print.Book;
import java.util.Set;

import org.springframework.http.HttpStatus;

public class GetBookResponse extends AbstractResponse {

	public GetBookResponse() {

	}

	public GetBookResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
