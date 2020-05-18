package com.rs.esi.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.esi.model.Expense;

public class DeleteExpenseResponse extends AbstractResponse {

private Expense expense;
	
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	public DeleteExpenseResponse() {

	}

	public DeleteExpenseResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
