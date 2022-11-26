package demojdbc1;

import java.sql.*;
import java.util.Scanner;

public class Delete {
    static final String D_URL="\"jdbc:mysql://localhost:3306/cogjava";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY= "delete from student where student_id=?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

             try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
             Statement stmt = con.createStatement();
             PreparedStatement ps = con.prepareStatement(QUERY);){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter student ID which you want to delete: ");
            int student_id=sc.nextInt();
           ps.setInt(1, student_id);
        }
        catch(SQLException e){
            
        }
    }
}