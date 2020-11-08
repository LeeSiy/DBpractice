import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class INSERT extends JFrame{
	JTextField Fname, Lname, Minit, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno;
	JLabel JFname, JLname, JMinit, JSsn, JBdate, JAddress, JSex, JSalary, JSuper_ssn, JDno;
	String SFname, SLname, SMinit, SSsn, SBdate, SAddress, SSex, SSalary, SSuper_ssn, SDno;
	JButton btn_input,btn_back;
	double DSalary;
	private MAIN main;
    public static void main(String[] args) {
        new INSERT();
     }
	public INSERT() {
		setTitle("8조 직원 DB관리 서비스 - 삽입");
	    setSize(515, 540);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // 레이아웃 설정
	    setLayout(null); // 절대값
	    JLayeredPane layeredPane = new JLayeredPane();
	    layeredPane.setBounds(0, 0, 515, 540);
	    layeredPane.setLayout(null);
	    MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 515, 540);
        
        // 입력창들
        Fname = new JTextField(15);
        Fname.setBounds(180, 0, 180, 25);
        Fname.setOpaque(false);
        Fname.setForeground(Color.blue);
        JFname = new JLabel("Fname:");
        JFname.setLocation(0, 0); //위치 설정
        JFname.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JFname.setSize(180, 20);  //크기 설정
        layeredPane.add(JFname);
        layeredPane.add(Fname);
        
        Lname = new JTextField(15);
        Lname.setBounds(180, 25, 180, 25);
        Lname.setOpaque(false);
        Lname.setForeground(Color.blue);
        JLname = new JLabel("Lname:");
        JLname.setLocation(0,25); //위치 설정
        JLname.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JLname.setSize(180, 20);  //크기 설정
        layeredPane.add(JLname);
        layeredPane.add(Lname);
                
        Minit = new JTextField(15);
        Minit.setBounds(180, 50, 180, 25);
        Minit.setOpaque(false);
        Minit.setForeground(Color.blue);
        JMinit = new JLabel("Minit:");
        JMinit.setLocation(0,50); //위치 설정
        JMinit.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JMinit.setSize(180, 20);  //크기 설정
        layeredPane.add(JMinit);
        layeredPane.add(Minit);
                
        Ssn = new JTextField(15);
        Ssn.setBounds(180, 75, 180, 25);
        Ssn.setOpaque(false);
        Ssn.setForeground(Color.blue);
        JSsn = new JLabel("Ssn:");
        JSsn.setLocation(0,75); //위치 설정
        JSsn.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JSsn.setSize(180, 20);  //크기 설정
        layeredPane.add(JSsn);
        layeredPane.add(Ssn);
                
        Bdate = new JTextField(15);
        Bdate.setBounds(180, 100, 180, 25);
        Bdate.setOpaque(false);
        Bdate.setForeground(Color.blue);
        JBdate = new JLabel("Bdate:");
        JBdate.setLocation(0,100); //위치 설정
        JBdate.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JBdate.setSize(180, 20);  //크기 설정
        layeredPane.add(JBdate);
        layeredPane.add(Bdate);
                
        Address = new JTextField(15);
        Address.setBounds(180, 125, 180, 25);
        Address.setOpaque(false);
        Address.setForeground(Color.blue);
        JAddress = new JLabel("Address:");
        JAddress.setLocation(0,125); //위치 설정
        JAddress.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JAddress.setSize(180, 20);  //크기 설정
        layeredPane.add(JAddress);
        layeredPane.add(Address);
                
        Sex = new JTextField(15);
        Sex.setBounds(180, 150, 180, 25);
        Sex.setOpaque(false);
        Sex.setForeground(Color.blue);
        JSex = new JLabel("Sex:");
        JSex.setLocation(0,150); //위치 설정
        JSex.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JSex.setSize(180, 20);  //크기 설정
        layeredPane.add(JSex);
        layeredPane.add(Sex);
                
        Salary = new JTextField(15);
        Salary.setBounds(180, 175, 180, 25);
        Salary.setOpaque(false);
        Salary.setForeground(Color.blue);
        JSalary = new JLabel("Salary:");
        JSalary.setLocation(0,175); //위치 설정
        JSalary.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JSalary.setSize(180, 20);  //크기 설정
        layeredPane.add(JSalary);
        layeredPane.add(Salary);
                
        Super_ssn = new JTextField(15);
        Super_ssn.setBounds(180, 200, 180, 25);
        Super_ssn.setOpaque(false);
        Super_ssn.setForeground(Color.blue);
        JSuper_ssn = new JLabel("Super_ssn:");
        JSuper_ssn.setLocation(0,200); //위치 설정
        JSuper_ssn.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JSuper_ssn.setSize(180, 20);  //크기 설정
        layeredPane.add(JSuper_ssn);
        layeredPane.add(Super_ssn);
                
        Dno = new JTextField(15);
        Dno.setBounds(180, 225, 180, 25);
        Dno.setOpaque(false);
        Dno.setForeground(Color.blue);
        JDno = new JLabel("Dno:");
        JDno.setLocation(0,225); //위치 설정
        JDno.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
        JDno.setSize(180, 20);  //크기 설정
        layeredPane.add(JDno);
        layeredPane.add(Dno);
                
        JButton btn_input = new JButton("입력");
        JButton btn_back = new JButton("돌아가기");
        
        btn_input.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	SFname = Fname.getText();
            	SLname = Lname.getText();
            	SMinit = Minit.getText();
            	SSsn = Ssn.getText();
            	SBdate = Bdate.getText();
            	SAddress = Address.getText();
            	SSex = Sex.getText();
            	SSalary = Salary.getText();
            	boolean oksign = true;
                if(SSalary.isEmpty())
                	SSalary="0";
                DSalary = Double.parseDouble(SSalary);
            	SSuper_ssn = Super_ssn.getText();
            	SDno = Dno.getText();
            	for(RESULT line : DBM.dataset) {
            		if(line.Ssn.equals(SSsn)) {
            			JOptionPane.showMessageDialog(null, "동일한 Ssn이 이미 존재합니다.");
            			oksign = false;
            		}	
            	}
            	if(SFname.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Fname은 필수 항목입니다.");
            	}
            	else if(SLname.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Lname은 필수 항목입니다.");
            	}
            	else if(SSsn.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Ssn은 필수 항목입니다.");
            	}
            	else if(SDno.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Dno는 필수 항목입니다.");
            	}else {
            		if(oksign==true)
            			DatabaseAccess.DBInsert(SFname, SLname, SMinit, SSsn, SBdate, SAddress, SSex, SSalary, SSuper_ssn, SDno);
	            		DBM.dataset = DatabaseAccess.DBLoad(DatabaseAccess.DBname2, DatabaseAccess.USER_NAME2, DatabaseAccess.PASSWORD2);
	    				int i =0;
	    				int k = 0;
	    				for(RESULT line : DBM.dataset) {
	    					for(RESULT line2 : DBM.dataset) {
	    						if(line.Super_ssn != null) {
	    							if(line.Super_ssn.equals(line2.Ssn)) {
	    								String temp1 = line2.Fname;
	    								String temp2 = line2.Lname;
	    								DBM.dataset[i].Super_Fname = temp1;
	    								DBM.dataset[i].Super_Lname = temp2;
	    							}
	    						}
	    					}
	    					i++;
	    				}
            	}
            	dispose();
        		new INSERT();
            }
        });
        
        btn_back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	MAIN.insert2();
            }
        });
        
        btn_input.setBounds(50, 270, 100, 30);
        layeredPane.add(btn_input);
        
        btn_back.setBounds(160, 270, 100, 30);
        layeredPane.add(btn_back);
        
        layeredPane.add(panel);
        add(layeredPane);
        setVisible(true);
	}
	@SuppressWarnings("serial")
	class MyPanel extends JPanel {
        public void paint(Graphics g) {
            //
        }
    }
	public void setMain(MAIN main) {
		this.main = main;
	}
}
