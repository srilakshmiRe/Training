package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LogOut {

	static final String D_URL = "jdbc:mysql://localhost:3306/cogjava";
	static final String USER = "root";
	static final String PASS = "pass@word1";
	static final String QUERY = "select * from register where email=?";
	static final String UPDATEQUERY = "update  register SET status=? where email=?";

	public static void main(String args[]) {
		try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
				Statement stmt = con.createStatement();
				PreparedStatement ps = con.prepareStatement(QUERY);) {
			Scanner sc = new Scanner(System.in);
			System.out.print("EMAIL: ");
			String email = sc.nextLine();

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				updateLogOutStatus(email, "INACTIVE");
				System.out.print("LogOut Success.");
			} else {
				System.out.print("LogOut Failled.");
			}
		} catch (SQLException e) {

		}
	}

	private static void updateLogOutStatus(String email, String status) {
		try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
				Statement stmt = con.createStatement();
				PreparedStatement psp = con.prepareStatement(UPDATEQUERY);) {
			psp.setString(1, status);
			psp.setString(2, email);
			psp.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
