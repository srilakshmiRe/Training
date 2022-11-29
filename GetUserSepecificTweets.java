package com.tweets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetUserSepecificTweets {

	static final String D_URL = "jdbc:mysql://localhost:3306/cogjava";
	static final String USER = "root";
	static final String PASS = "pass@word1";
	static final String QUERY = "select * from tweet where email=?";

	public static void main(String args[]) {
		try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
				Statement stmt = con.createStatement();
				PreparedStatement ps = con.prepareStatement(QUERY);) {
			Scanner sc = new Scanner(System.in);
			System.out.print("EMAIL: ");
			String email = sc.nextLine();

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			List<String> userTweets = new ArrayList<>();
			while (rs.next()) {
				userTweets.add(rs.getString("tweets"));
			}
			if (userTweets.size() > 0) {
				System.out.print(userTweets);
			} else {
				System.out.print("Tweets not available");
			}
		} catch (SQLException e) {

		}
	}

}
