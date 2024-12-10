package com.library.model;

public class Book {
	private int bookId;
	private String title; 
	private String author;
	private String genre;
	private int availability;

	public Book(){

	}
	public Book(int bookId, String title, String author, String genre, int availability) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availability = availability;
	}
	public Book(String title, String author, String genre, int availability) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availability = availability;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return  String.format("%-10d %-30s %-25s %-20s %-15d",
                bookId, title, author, genre, availability);
	}
}