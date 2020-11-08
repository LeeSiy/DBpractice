import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//�����ͺ��̽��� �����ؼ� RESULT ��ü�� �迭 ������ LOAD�ϰų� UPDATE�ϴ� Ŭ����
public class DatabaseAccess {
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 				//JDBC����̹�
	static String DBname2=null;	  											//�̿��� DBname:DBpractice
	static String USER_NAME2=null;  										//DB�� ������ ����� �̸� ���� : root
	static String PASSWORD2=null;   		 								//������� ��й�ȣ�� ����� ���� : password
	static RESULT[] data = new RESULT[0];
	//�Ķ���ͷ� DB ����, ��й�ȣ, �̿��� DB �̸��� �޾ƿͼ�, DB�� �����Ͽ� RESULt ��ü�� �迭�� DATA�� �����ϴ� method
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
			JOptionPane.showMessageDialog(null, "�α��� ����");
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
	    	JOptionPane.showMessageDialog(null, "�α��� ����");
	    	return data;
	    }finally { 																	//���ܰ� �ֵ� ���� ������ ����
	    	try{
	    		if(conn!=null) {
	    			conn.close();
	    		}
	    	}catch(SQLException ex1){
	    		ex1.printStackTrace();
	    	}
	    }
	}
	//�Ķ���ͷ� ������ Ssn�� ���޹޾� DB�� �������ִ� method
	public static void DBUpdate(Double Salary, String Ssn){ 						
		//DB���õ� ������
		Statement state = null;
        Connection conn = null;
		String DB_URL = "jdbc:mysql://192.168.0.2:3306/"+DBname2+"?allowPublicKeyRetrieval=true&useSSL=false";
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME2, PASSWORD2);
			state = conn.createStatement();
			String sql = "UPDATE EMPLOYEE SET Salary = " + Salary + " WHERE Ssn = "+Ssn;
			JOptionPane.showMessageDialog(null, "DB ������Ʈ �Ϸ�");
			state.executeUpdate(sql);
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "DB ���� ����");
	    }finally { 																	//���ܰ� �ֵ� ���� ������ ����
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
	//�Ķ���ͷ� Ssn�� ���޹޾� �ش� Ʃ���� ���̺��� �����ϴ� method.
	public static void DBDelete(String Ssn){ 						
		//DB���õ� ������
		Statement state = null;
        Connection conn = null;
		String DB_URL = "jdbc:mysql://192.168.0.2:3306/"+DBname2+"?allowPublicKeyRetrieval=true&useSSL=false";
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME2, PASSWORD2);
			state = conn.createStatement();
			String sql = "DELETE FROM EMPLOYEE WHERE Ssn = "+Ssn;
			JOptionPane.showMessageDialog(null, "DB ������Ʈ �Ϸ�");
			state.executeUpdate(sql);
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "DB ���� ����");
	    }finally { 																	//���ܰ� �ֵ� ���� ������ ����
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
		//DB���õ� ������
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

			JOptionPane.showMessageDialog(null, "DB ������Ʈ �Ϸ�");
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "DB ���� ����");
	    }finally { 																	//���ܰ� �ֵ� ���� ������ ����
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