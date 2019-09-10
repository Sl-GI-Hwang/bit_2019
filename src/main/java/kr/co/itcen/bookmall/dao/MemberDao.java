package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.MemberVo;

public class MemberDao {

	public Boolean insert(MemberVo vo1) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "insert into MemberDao(no, name, phone, email, passwd) values(null, ?, ?, ?, ?)";

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, vo1.getName());
			pstmt.setString(2, vo1.getEmail());
			pstmt.setString(3, vo1.getPhone());
			pstmt.setString(4, vo1.getPasswd());
			
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

	public List<MemberVo> select() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		List <MemberVo> result = new ArrayList<MemberVo>();
		
		
		try {
			connection = getConnection();
			
			String sql = "select * from MemberDao";

			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String passwd = rs.getString(5);
				
				MemberVo mv = new MemberVo();
				mv.setNo(no);
				mv.setName(name);
				mv.setPhone(phone);
				mv.setEmail(email);
				mv.setPasswd(passwd);
				
				result.add(mv);
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

	public void printList(List<MemberVo> result) {
		// TODO Auto-generated method stub
		for(MemberVo m : result) {
			System.out.println(m.toString());
		}
	}

}
