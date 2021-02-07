package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDao {

	public Boolean insert(OrderBookVo vo1) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "insert into Order_Book(no, no2) values(?, ?)";

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, vo1.getNo());
			pstmt.setInt(2, vo1.getNo2());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
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
		
			String url = "jdbc:mariadb://192.168.1.88:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		}
		
		return connection;
	}

	public List<OrderBookVo> select() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		List <OrderBookVo> result = new ArrayList<OrderBookVo>();
		
		
		try {
			connection = getConnection();
			
			String sql = "select * from Order_Book";

			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				int no2 = rs.getInt(2);
				
				OrderBookVo cd = new OrderBookVo();
				cd.setNo(no);
				cd.setNo2(no2);
				
				result.add(cd);
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

	public void printList(List<OrderBookVo> result) {
		// TODO Auto-generated method stub
		for(OrderBookVo m : result) {
			System.out.println(m.toString());
		}
	}

}
