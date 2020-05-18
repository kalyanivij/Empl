package com.rs.esi.response;

import com.rs.esi.model.Expense;

public class AddExpenseResponse extends AbstractResponse {
	
	private Expense expense;
	
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	
}
