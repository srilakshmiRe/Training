package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ForgotPassword {
	static final String D_URL = "jdbc:mysql://localhost:3306/cogjava";
	static final String USER = "root";
	static final String PASS = "pass@word1";
	static final String QUERY = "select * from register where email=?";
	static final String UPDATEQUERY = "update  register SET password=? where email=?";

	public static void main(String args[]) {
		try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
				Statement stmt = con.createStatement();
				PreparedStatement ps = con.prepareStatement(QUERY);) {
			Scanner sc = new Scanner(System.in);
			System.out.print("EMAIL: ");
			String email = sc.nextLine();

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("NEWPASSWORD: ");
				String newPassword = sc.nextLine();
				updatePassword(newPassword, email);
			}

		} catch (SQLException e) {

		}
	}

	private static void updatePassword(String newPassword, String email) {
		try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
				Statement stmt = con.createStatement();
				PreparedStatement psp = con.prepareStatement(UPDATEQUERY);) {
			psp.setString(1, newPassword);
			psp.setString(2, email);
			psp.execute();
			System.out.println("Succesfuly updated password");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Not updated password");
			e.printStackTrace();
		}

	}

}
