package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Category;

public class CategoryService {

	public List<Category> getAllCategories() throws SQLException{

		//Connect to DB
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Category category=null;
		List<Category> list=new ArrayList<Category>();
		try {
			//mmake connection to mysql
			conn=DBUtil.makeConnection();
			
			// ->table Category
			//Run query select * from category"
			ps=conn.prepareStatement("select * from `category`");
			
			//execute and get result SET
			rs=ps.executeQuery();
			
			//mapping data in result set (if result set has data) into entity class
			//Category
			while (rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				category=new Category(id,name);
				list.add(category);

			}
		// -> if exist -> return user(id,name)
			//->not exist ->return null
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (conn!=null) {
				conn.close();
			}
		
		}return list;
}
}
