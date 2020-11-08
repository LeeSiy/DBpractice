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
		setTitle("8�� ���� DB���� ���� - ����");
	    setSize(515, 540);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // ���̾ƿ� ����
	    setLayout(null); // ���밪
	    JLayeredPane layeredPane = new JLayeredPane();
	    layeredPane.setBounds(0, 0, 515, 540);
	    layeredPane.setLayout(null);
	    MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 515, 540);
        
        // �Է�â��
        Fname = new JTextField(15);
        Fname.setBounds(180, 0, 180, 25);
        Fname.setOpaque(false);
        Fname.setForeground(Color.blue);
        JFname = new JLabel("Fname:");
        JFname.setLocation(0, 0); //��ġ ����
        JFname.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JFname.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JFname);
        layeredPane.add(Fname);
        
        Lname = new JTextField(15);
        Lname.setBounds(180, 25, 180, 25);
        Lname.setOpaque(false);
        Lname.setForeground(Color.blue);
        JLname = new JLabel("Lname:");
        JLname.setLocation(0,25); //��ġ ����
        JLname.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JLname.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JLname);
        layeredPane.add(Lname);
                
        Minit = new JTextField(15);
        Minit.setBounds(180, 50, 180, 25);
        Minit.setOpaque(false);
        Minit.setForeground(Color.blue);
        JMinit = new JLabel("Minit:");
        JMinit.setLocation(0,50); //��ġ ����
        JMinit.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JMinit.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JMinit);
        layeredPane.add(Minit);
                
        Ssn = new JTextField(15);
        Ssn.setBounds(180, 75, 180, 25);
        Ssn.setOpaque(false);
        Ssn.setForeground(Color.blue);
        JSsn = new JLabel("Ssn:");
        JSsn.setLocation(0,75); //��ġ ����
        JSsn.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JSsn.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JSsn);
        layeredPane.add(Ssn);
                
        Bdate = new JTextField(15);
        Bdate.setBounds(180, 100, 180, 25);
        Bdate.setOpaque(false);
        Bdate.setForeground(Color.blue);
        JBdate = new JLabel("Bdate:");
        JBdate.setLocation(0,100); //��ġ ����
        JBdate.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JBdate.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JBdate);
        layeredPane.add(Bdate);
                
        Address = new JTextField(15);
        Address.setBounds(180, 125, 180, 25);
        Address.setOpaque(false);
        Address.setForeground(Color.blue);
        JAddress = new JLabel("Address:");
        JAddress.setLocation(0,125); //��ġ ����
        JAddress.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JAddress.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JAddress);
        layeredPane.add(Address);
                
        Sex = new JTextField(15);
        Sex.setBounds(180, 150, 180, 25);
        Sex.setOpaque(false);
        Sex.setForeground(Color.blue);
        JSex = new JLabel("Sex:");
        JSex.setLocation(0,150); //��ġ ����
        JSex.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JSex.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JSex);
        layeredPane.add(Sex);
                
        Salary = new JTextField(15);
        Salary.setBounds(180, 175, 180, 25);
        Salary.setOpaque(false);
        Salary.setForeground(Color.blue);
        JSalary = new JLabel("Salary:");
        JSalary.setLocation(0,175); //��ġ ����
        JSalary.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JSalary.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JSalary);
        layeredPane.add(Salary);
                
        Super_ssn = new JTextField(15);
        Super_ssn.setBounds(180, 200, 180, 25);
        Super_ssn.setOpaque(false);
        Super_ssn.setForeground(Color.blue);
        JSuper_ssn = new JLabel("Super_ssn:");
        JSuper_ssn.setLocation(0,200); //��ġ ����
        JSuper_ssn.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JSuper_ssn.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JSuper_ssn);
        layeredPane.add(Super_ssn);
                
        Dno = new JTextField(15);
        Dno.setBounds(180, 225, 180, 25);
        Dno.setOpaque(false);
        Dno.setForeground(Color.blue);
        JDno = new JLabel("Dno:");
        JDno.setLocation(0,225); //��ġ ����
        JDno.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
        JDno.setSize(180, 20);  //ũ�� ����
        layeredPane.add(JDno);
        layeredPane.add(Dno);
                
        JButton btn_input = new JButton("�Է�");
        JButton btn_back = new JButton("���ư���");
        
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
            			JOptionPane.showMessageDialog(null, "������ Ssn�� �̹� �����մϴ�.");
            			oksign = false;
            		}	
            	}
            	if(SFname.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Fname�� �ʼ� �׸��Դϴ�.");
            	}
            	else if(SLname.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Lname�� �ʼ� �׸��Դϴ�.");
            	}
            	else if(SSsn.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Ssn�� �ʼ� �׸��Դϴ�.");
            	}
            	else if(SDno.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Dno�� �ʼ� �׸��Դϴ�.");
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
