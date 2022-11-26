package demojdbc1;

import java.sql.*;
import java.util.Scanner;

    public class Update {
    static final String D_URL="jdbc:mysql://localhost:3306/cogjava";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY=  "update student set student_name = ? where student_id = ?";

    public static void main(String[] args) {
    	try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
                Statement stmt = con.createStatement();
                PreparedStatement ps = con.prepareStatement(QUERY);){
               Scanner sc=new Scanner(System.in);
               System.out.print("Enter student name: ");
               String student_name = sc.nextLine();
               System.out.print("Enter student id for which you want to update name: ");
               int student_id = sc.nextInt();

               ps.setInt(1, student_id);
               ps.setString(2, student_name);

               int c=ps.executeUpdate();
               if(c==1){
                   System.out.println("student name is updated successfully");
               }
               else{
                   System.out.println("student name is not updated successfully");
               }
           }
           catch(SQLException e){

           }

       }
   }
   
