package coding.mentor.entity;

public class OrderDetail {
	private int id;
	private int orderId;
	private int bookId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public OrderDetail(int id, int orderId, int bookId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookId = bookId;
	}
	public OrderDetail(int orderId, int bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}
	

}
