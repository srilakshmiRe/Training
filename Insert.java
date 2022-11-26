package demojdbc1;
  import java.sql.*;
   import java.util.Scanner;
 

public class Insert {
	static final String D_URL="\"jdbc:mysql://localhost:3306/cogjava";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "insert into student(student_id, student_name, student_rollnum,student_dept) values (?, ?, ?, ?)";


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try (Connection con = DriverManager.getConnection(D_URL, USER, PASS);
             Statement stmt = con.createStatement();
             PreparedStatement ps = con.prepareStatement(QUERY);){
            Scanner sc=new Scanner(System.in);
            System.out.print("student_id: ");
            int student_id = sc.nextInt();
            System.out.print("Name: ");
            String student_name = sc.nextLine();
            System.out.print("Roll Number: ");
            String student_rollnum = sc.nextLine();
            System.out.print("Department: ");
            String student_dept = sc.nextLine();

            ps.setInt(1, student_id);
            ps.setString(2, student_name);
            ps.setString(3,student_rollnum );
            ps.setString(4,student_dept );

            int c=ps.executeUpdate();
            if(c==1){
                System.out.println("Insertion is successfully");
            }
            else{
                System.out.println("Insertion is not  successfully");
            }
        }
        catch(SQLException e){

        }
    }


}

