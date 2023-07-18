package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Book;

public class BookService {
	public List<Book> getBooksByCategoryId(int categoryId) throws SQLException {

		// Connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// mmake connection to mysql
			conn = DBUtil.makeConnection();

			// ->table Category
			// Run query select * from category"
			ps = conn.prepareStatement("select * from book where category_id=?");
			ps.setInt(1, categoryId);

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (if result set has data) into entity class
			// Category
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				book = new Book(id, name, categoryId);
				list.add(book);

			}
			// -> if exist -> return user(id,name)
			// ->not exist ->return null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return list;

	}

	public List<Book> getBooksByName(String bookName) throws SQLException {

		// Connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// mmake connection to mysql
			conn = DBUtil.makeConnection();

			// ->table Category
			// Run query select * from category"
			ps = conn.prepareStatement("select * from `book` where name like ?");
			ps.setString(1, "%" + bookName + "%");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (if result set has data) into entity class
			// Category
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");

				book = new Book(id, name, categoryId);
				list.add(book);

			}
			// -> if exist -> return user(id,name)
			// ->not exist ->return null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return list;
	}
	
	public List<Book> getAllBooks() throws SQLException {

		// Connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// mmake connection to mysql
			conn = DBUtil.makeConnection();

			// ->table Category
			// Run query select * from category"
			ps = conn.prepareStatement("select * from `book`");
			
			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (if result set has data) into entity class
			// Category
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");

				book = new Book(id, name, categoryId);
				list.add(book);

			}
			// -> if exist -> return user(id,name)
			// ->not exist ->return null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return list;
	}
	
	public Book getBookDetail(int bookId) throws SQLException {

		// Connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try {
			// mmake connection to mysql
			conn = DBUtil.makeConnection();

			// ->table Category
			// Run query select * from category"
			ps = conn.prepareStatement("select * from `book` where id= ?");
			ps.setInt(1, bookId);
			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (if result set has data) into entity class
			// Category
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");
				String author = rs.getString("author");
				int stock=rs.getInt("stock");
				int price=rs.getInt("price");
				
				book = new Book(id, name, categoryId,author,stock,price);

			}
			// -> if exist -> return user(id,name)
			// ->not exist ->return null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return book;
	}
	public List<Book> getBooksByPage(List<Book> bookList, int currentPage, int booksPerPage) {
		int startIndex = (currentPage - 1) * booksPerPage;
		int endIndex = Math.min(startIndex + booksPerPage, bookList.size());
		return bookList.subList(startIndex, endIndex);
	}

	public int getTotalPages(List<Book> bookList, int booksPerPage) {
		return (int) Math.ceil((double) bookList.size() / booksPerPage);
	}
}
