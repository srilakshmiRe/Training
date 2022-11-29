package com.user;

import java.sql.*;
import java.util.Scanner;
public class Registration {
        static final String D_URL = "jdbc:mysql://localhost:3306/cogjava";
        static final String USER = "root";
        static final String PASS = "pass@word1";
        static final String QUERY = "insert into register (name,email,password,status) values (?,?,?,?)";

        public static void main(String args []){
            try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
                 Statement stmt = con.createStatement();
                 PreparedStatement ps = con.prepareStatement(QUERY);){
                Scanner sc=new Scanner(System.in);
                System.out.print("FIRST NAME: ");
                String name = sc.nextLine();
                System.out.print("EMAIL: ");
                String email = sc.nextLine();
                System.out.print("PASSWORD: ");
                String password = sc.nextLine();

                ps.setString(1,name);
                ps.setString(2,email);
                ps.setString(3,password);
                ps.setString(4, "INACTIVE");
                ps.executeUpdate();
            }
            catch(SQLException e){

            }
        }
    }
