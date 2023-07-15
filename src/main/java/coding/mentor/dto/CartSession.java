package coding.mentor.dto;

import java.util.HashSet;
import java.util.Set;

import coding.mentor.entity.Book;

public class CartSession {
	private Set<Book> books;
	private int totalPrice;

	public CartSession() {
		this.books = new HashSet<Book>();
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
