package com.tweets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PostTweet {

    static final String D_URL = "jdbc:mysql://localhost:3306/cogjava";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "insert into tweet (tweets,email) values (?,?)";

    public static void main(String args []){
        try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
             Statement stmt = con.createStatement();
             PreparedStatement ps = con.prepareStatement(QUERY);){
            Scanner sc=new Scanner(System.in);
            System.out.print("EMAIL: ");
            String email = sc.nextLine();
            System.out.print("TWEET: ");
            String tweet = sc.nextLine();

            ps.setString(1,tweet);
            ps.setString(2,email);
            ps.executeUpdate();
        }
        catch(SQLException e){
        	e.printStackTrace();

        }
    }


}
