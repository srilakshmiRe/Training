package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class ViewAllRegisteredUsers {
	static final String D_URL = "jdbc:mysql://localhost:3306/cogjava";
	static final String USER = "root";
	static final String PASS = "pass@word1";
	static final String QUERY = "select * from register ";

	public static void main(String args[]) {
		try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
				Statement stmt = con.createStatement();
				PreparedStatement ps = con.prepareStatement(QUERY);) {

			ResultSet rs = ps.executeQuery();
			List<User> userDetails = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("name"));
				user.setStatus(rs.getString("status"));
				userDetails.add(user);
			}
			if (userDetails.size() > 0) {
				System.out.print(userDetails.toString());
			} else {
				System.out.print("Users empty");
			}
		} catch (SQLException e) {

		}
	}
}
