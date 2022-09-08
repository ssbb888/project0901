package project0901;

import java.sql.*;

public class Student {

	public static void main(String[] args) {
		String jdbcDriver="com.mysql.cj.jdbc.Driver";
		String jdbcUrl="jdbc:mysql://localhost/yangjung?serverTimezone=UTC";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from student";
		try {
			Class.forName(jdbcDriver);
			conn=DriverManager.getConnection(jdbcUrl,"root","1234");
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString("birthday")+" ");
				System.out.println(rs.getString("address"));
			}
			System.out.println("database 연결 성공");
		}catch(Exception e) {
			System.out.println("database 연결 실패");
			e.printStackTrace();
		}
	}

}
