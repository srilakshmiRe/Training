

import java.sql.*;
import java.util.Scanner;

public class Login {

    static final String D_URL = "jdbc:mysql://localhost:3306/cogjava";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "select * from reg where email=? AND password=?";

    public static void main(String args []){
        try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
             Statement stmt = con.createStatement();
             PreparedStatement ps = con.prepareStatement(QUERY);){
            Scanner sc=new Scanner(System.in);
            System.out.print("EMAIL: ");
            String email = sc.nextLine();
            System.out.print("PASSWORD: ");
            String password = sc.nextLine();

            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.print("Login Success.");
            }else{
                System.out.print("Login Failled.");
            }
        }
        catch(SQLException e){

        }
    }
}
