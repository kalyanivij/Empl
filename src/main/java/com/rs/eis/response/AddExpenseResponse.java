package com.rs.eis.response;

import com.rs.eis.model.Expense;


public class AddExpenseResponse extends AbstractResponse {
	
	private Expense expense;
	
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	
}
