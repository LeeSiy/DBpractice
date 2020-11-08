import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//데이터베이스에 접근해서 RESULT 객체의 배열 정보에 LOAD하거나 UPDATE하는 클래스
public class DatabaseAccess {
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 				//JDBC드라이버
	static String DBname2=null;	  											//이용할 DBname:DBpractice
	static String USER_NAME2=null;  										//DB에 접속할 사용자 이름 변수 : root
	static String PASSWORD2=null;   		 								//사용자의 비밀번호를 상수로 정의 : password
	static RESULT[] data = new RESULT[0];
	//파라미터로 DB 계정, 비밀번호, 이용할 DB 이름을 받아와서, DB에 접근하여 RESULt 객체의 배열에 DATA를 복사하는 method
	public static RESULT[] DBLoad(String DBname, String USER_NAME, String PASSWORD) {
		DBname2=DBname;
		USER_NAME2=USER_NAME;
		PASSWORD2=PASSWORD;
		Statement state = null;
        int i = 0;
        Connection conn = null;
		String DB_URL = "jdbc:mysql://192.168.0.2:3306/"+DBname+"?allowPublicKeyRetrieval=true&useSSL=false";
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			JOptionPane.showMessageDialog(null, "로그인 성공");
			DBM.login_check=true;
			state = conn.createStatement();
			String sql = "SELECT DISTINCT E.Fname, E.Lname, E.Minit, E.Ssn, E.Bdate, E.Address, E.Sex, E.Salary, E.Super_ssn , D.Dname FROM EMPLOYEE E, DEPARTMENT D WHERE E.Dno = D.Dnumber";
			ResultSet rs = state.executeQuery(sql);
			rs.last();     
	        int rowcount = rs.getRow();
	        rs.beforeFirst();
	        RESULT[] result = new RESULT[rowcount];
			while(rs.next()) {
				RESULT temp = new RESULT("","","","","","","",0.0,"","","");
				temp.Fname=rs.getString("E.Fname");
				temp.Lname=rs.getString("E.Lname");
				temp.Minit=rs.getString("E.Minit");
				temp.Ssn=rs.getString("E.Ssn");
				temp.Bdate=rs.getString("E.Bdate");
				temp.Address=rs.getString("E.Address");
				temp.Sex=rs.getString("E.Sex");
				temp.Salary=rs.getDouble("E.Salary");
				temp.Super_ssn=rs.getString("E.Super_ssn");
				temp.Dname=rs.getString("D.Dname");
				result[i] = temp;
				i++;
			}
			return result;
	    }catch(Exception e1) {
	    	e1.printStackTrace();
	    	JOptionPane.showMessageDialog(null, "로그인 실패");
	    	return data;
	    }finally { 																	//예외가 있든 없든 무조건 실행
	    	try{
	    		if(conn!=null) {
	    			conn.close();
	    		}
	    	}catch(SQLException ex1){
	    		ex1.printStackTrace();
	    	}
	    }
	}
	//파라미터로 연봉과 Ssn을 전달받아 DB를 수정해주는 method
	public static void DBUpdate(Double Salary, String Ssn){ 						
		//DB관련된 변수들
		Statement state = null;
        Connection conn = null;
		String DB_URL = "jdbc:mysql://192.168.0.2:3306/"+DBname2+"?allowPublicKeyRetrieval=true&useSSL=false";
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME2, PASSWORD2);
			state = conn.createStatement();
			String sql = "UPDATE EMPLOYEE SET Salary = " + Salary + " WHERE Ssn = "+Ssn;
			JOptionPane.showMessageDialog(null, "DB 업데이트 완료");
			state.executeUpdate(sql);
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "DB 접속 실패");
	    }finally { 																	//예외가 있든 없든 무조건 실행
	    	try{
	    		if(state!=null)
	    			state.close();
	    	}catch(SQLException ex1){
	    		//
	    	}
	    			
	    	try{
	    		if(conn!=null)
	    			conn.close();
	    	}catch(SQLException ex1){
	    		//
	    	}
	    }
	}
	//파라미터로 Ssn을 전달받아 해당 튜플을 테이블에서 삭제하는 method.
	public static void DBDelete(String Ssn){ 						
		//DB관련된 변수들
		Statement state = null;
        Connection conn = null;
		String DB_URL = "jdbc:mysql://192.168.0.2:3306/"+DBname2+"?allowPublicKeyRetrieval=true&useSSL=false";
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME2, PASSWORD2);
			state = conn.createStatement();
			String sql = "DELETE FROM EMPLOYEE WHERE Ssn = "+Ssn;
			JOptionPane.showMessageDialog(null, "DB 업데이트 완료");
			state.executeUpdate(sql);
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "DB 접속 실패");
	    }finally { 																	//예외가 있든 없든 무조건 실행
	    	try{
	    		if(state!=null)
	    			state.close();
	    	}catch(SQLException ex1){
	    		//
	    	}
	    			
	    	try{
	    		if(conn!=null)
	    			conn.close();
	    	}catch(SQLException ex1){
	    		//
	    	}
	    }
	}
	public static void DBInsert(String Fname, String Lname, String Minit, String Ssn, String Bdate, String Address, String Sex, String Salary, String Super_ssn, String Dno){ 						
		//DB관련된 변수들
        Connection conn = null;
		String DB_URL = "jdbc:mysql://192.168.0.2:3306/"+DBname2+"?allowPublicKeyRetrieval=true&useSSL=false";
		String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p2 = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME2, PASSWORD2);
			p2=conn.prepareStatement(sql);
            p2.clearParameters();
            p2.setString(1, Fname);
            p2.setString(2, Minit);
            p2.setString(3, Lname);
            p2.setString(4, Ssn);
            p2.setString(5, Bdate);
            p2.setString(6, Address);
            p2.setString(7, Sex);
            double salary = Double.parseDouble(Salary);
            p2.setDouble(8, salary);
            p2.setString(9, Super_ssn);
            int dno = Integer.parseInt(Dno);
            p2.setInt(10, dno);
            System.out.println(p2);
            p2.executeUpdate();

			JOptionPane.showMessageDialog(null, "DB 업데이트 완료");
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "DB 접속 실패");
	    }finally { 																	//예외가 있든 없든 무조건 실행
	    	try{
	    		if(p2!=null)
	    			p2.close();
	    	}catch(SQLException ex1){
	    		//
	    	}
	    			
	    	try{
	    		if(conn!=null)
	    			conn.close();
	    	}catch(SQLException ex1){
	    		//
	    	}
	    }
	}
}