package com.library.model;

import java.util.Date;

public class IssuedBook {
	private int issue_id;
	private int book_id;
	private int user_id;
	private Date issue_date;
	private Date return_date;
	
	public IssuedBook() {
		
	}
	public IssuedBook(int issue_id, int book_id, int user_id, Date issue_date, Date return_date) {
		super();
		this.issue_id = issue_id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.issue_date = issue_date;
		this.return_date = return_date;
	}
	public IssuedBook(int book_id, int user_id, Date issue_date, Date return_date) {
		super();
		this.book_id = book_id;
		this.user_id = user_id;
		this.issue_date = issue_date;
		this.return_date = return_date;
	}
	public int getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	@Override
	public String toString() {
		return "IssuedBook [issue_id=" + issue_id + ", book_id=" + book_id + ", user_id=" + user_id + ", issue_date="
				+ issue_date + ", return_date=" + return_date + "]";
	}
	
}
