package kr.co.itcen.bookmall.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;

public class DeleteDao {
	private static final String[] del = {"Order_Book", "OrderDao", "CartDao", "BookDao", "CategoryDao", "MemberDao"};
	public Boolean delete() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		Boolean result = false;
		
		try {
			int count;
			connection = getConnection();
			
			String sql = "set foreign_key_checks=0;";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < del.length; i++) {
				sql = "truncate table " + del[i];
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			
			for(int i = 1; i < del.length; i++) {
				sql = "alter table " + del[i] + " auto_increment = 1";
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		
			String url = "jdbc:mariadb://192.168.1.88:3306/bookmall?characterEncoding=utf8?allowMultiQueries=true";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		}
		
		return connection;
	}

}
