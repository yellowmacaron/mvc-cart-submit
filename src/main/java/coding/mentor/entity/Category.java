package coding.mentor.entity;

public class Category {
private int id;
private String name;

public Category() {
	
}
public int getId() {
	return id;
}
public Category(int id, String name) {
	super();
	this.id = id;
	this.name = name;
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

}
