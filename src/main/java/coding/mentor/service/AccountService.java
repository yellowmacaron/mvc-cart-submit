package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Account;

public class AccountService {
	public void createAccount(Account account) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// mmake connection to mysql
			conn = DBUtil.makeConnection();

			// create sql for insert
			String sql = "INSERT INTO `account`(username,password,email) value(?,?,?)";
			ps = conn.prepareStatement(sql);

			// Set params
			ps.setString(1, account.getUserName());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getEmail());

			ps.execute();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	public boolean validateEmail(String email) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// make connection to MySQL
			conn = DBUtil.makeConnection();

			// create SQL for query
			String sql = "SELECT COUNT(*) FROM account WHERE email=?";
			ps = conn.prepareStatement(sql);

			// Set params
			ps.setString(1, email);

			// Execute query and assign the result to 'rs'
			rs = ps.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				return count == 0;
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				conn.close();
			}
		}
		return false;
	}

	public boolean validateUsername(String username) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// make connection to MySQL
			conn = DBUtil.makeConnection();

			// create SQL for query
			String sql = "SELECT COUNT(*) FROM account WHERE username=?";
			ps = conn.prepareStatement(sql);

			// Set params
			ps.setString(1, username);

			// Execute query and assign the result to 'rs'
			rs = ps.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				return count == 0;
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				conn.close();
			}
		}
		return false;
	}
public Account accountLogin(String username, String password) throws SQLException {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Account account=null;
	try {
		// mmake connection to mysql
		conn = DBUtil.makeConnection();

		// create sql for insert
		String sql = "SELECT * FROM account WHERE username=? AND password=?";
		ps = conn.prepareStatement(sql);

		// Set params
		ps.setString(1, username);
		ps.setString(2, password);
		
		rs= ps.executeQuery(); 
		
		if (rs.next()) {
			account = new Account(username, password);
		}
	} finally {
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	return account;
}
}
