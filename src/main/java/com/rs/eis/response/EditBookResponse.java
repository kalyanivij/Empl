package com.rs.eis.response;

import java.awt.print.Book;

public class EditBookResponse extends AbstractResponse {

	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
