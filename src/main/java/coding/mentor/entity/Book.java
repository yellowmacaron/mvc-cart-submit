package coding.mentor.entity;

import java.util.Objects;

public class Book {
private int id;
private String name;
private int categoryId;
private String author;
private String title;
private int stock;
private int price;

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Book(int id, String name, int categoryId, String author, int stock, int price) {
	super();
	this.id = id;
	this.name = name;
	this.categoryId = categoryId;
	this.author = author;
	this.stock = stock;
	this.price = price;
}
public Book(int id, String name, int categoryId, String author, String title, int stock) {
	super();
	this.id = id;
	this.name = name;
	this.categoryId = categoryId;
	this.author = author;
	this.title = title;
	this.stock = stock;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public Book() {
	
}
public Book(int id, String name, int categoryId) {
	super();
	this.id = id;
	this.name = name;
	this.categoryId = categoryId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
@Override
public int hashCode() {
	return Objects.hash(author, categoryId, id, name, price, stock, title);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	return id == other.id;
			
}

}
