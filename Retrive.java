
package demojdbc1;
import java.sql.*;

public class Retrive {

	  static final String D_URL="jdbc:mysql://localhost:3306/cogjava";
	  static final String USER="root";
	  static final String PASS="pass@word1";
	  static final String QUERY="select * from employees";
	  
	  public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try(Connection con=DriverManager.getConnection(D_URL, USER, PASS);
				  Statement stmt=con.createStatement();
				  ResultSet rs=stmt.executeQuery(QUERY);){
			  while(rs.next()) {
				  System.out.println("Employee ID = "+ rs.getInt("emp_id"));
				  System.out.println("Ename = "+ rs.getString("emp_name"));
				  System.out.println("Eaddress = "+ rs.getString("emp_add"));
			  }
		  }
			  
		  catch(SQLException e) {
      
	}

}
}
