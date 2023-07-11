package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
	private static String driverClass = "com.mysql.cj.jdbc.Driver";      //오라클 드라이버
	private static String url = "jdbc:mysql://localhost:3306/javaweb";   //db 경로 포트-1521
	private static String username = "jweb";                             //사용자 이름
	private static String password = "54321"; 						     //사용자 비밀번호

	public static void main(String[] args) {
		Connection conn = null;

		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection 객체 생성: " + conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
