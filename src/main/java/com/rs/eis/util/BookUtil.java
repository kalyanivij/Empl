package com.rs.eis.util;

import com.rs.eis.model.Book;
import com.rs.eis.request.AddBookVO;

public class BookUtil {

	public static Book loadAddBookVOToBook(AddBookVO addbookVO) {
		Book book = new Book();

		book.setName(addbookVO.getName());

		book.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return book;
	}
}
