package com.behiye.JdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "hr";

		try {
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);// hrye baðlantý baþarýlý kontolü
			System.out.println("Connection successful..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
