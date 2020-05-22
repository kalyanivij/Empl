package com.rs.eis.response;

import org.apache.tomcat.jni.Library;

public class EditLibraryResponse extends AbstractResponse {

	private Library library;

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

}
