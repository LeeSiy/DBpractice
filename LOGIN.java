import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LOGIN extends JFrame{
	BufferedImage img = null;
	JTextField loginTextField;
	JTextField DBnameField;
    JPasswordField passwordField;
    JButton lgbt = new JButton("LOGIN");
    JButton ex = new JButton("�ý��� ����");
    private MAIN main;
    public static void main(String[] args) {
        new LOGIN();
     }
	public LOGIN() {
		setTitle("8�� ���� DB���� ���� - �α���");
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
		
		//�̹��� �޾ƿ���
		try {
            img = ImageIO.read(new File("C:\\Users\\LeeSiYUn\\Desktop\\DBimage/1.png"));
        } catch (IOException e) {
            System.out.println("�̹��� �ҷ����� ����");
            System.exit(0);
        }
		
		MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 515, 540);
        
        // ���̵�
        loginTextField = new JTextField(15);
        loginTextField.setBounds(180, 310, 180, 40);
        loginTextField.setOpaque(false);
        loginTextField.setForeground(Color.blue);
        layeredPane.add(loginTextField);
        // �н�����
        passwordField = new JPasswordField(15);
        passwordField.setBounds(180, 360, 180, 40);
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.blue);
        layeredPane.add(passwordField);
        //DBname
        DBnameField = new JTextField(15);
        DBnameField.setBounds(180, 410, 180, 40);
        DBnameField.setOpaque(false);
        DBnameField.setForeground(Color.blue);
        layeredPane.add(DBnameField);
        
        // �α��ι�ư �߰�
        lgbt.setBounds(370, 310, 100, 50);
        lgbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// ���콺�� �ö�����
				lgbt.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				// ���콺 �������� ��
			}

			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				String USER_NAME = loginTextField.getText();
				String PASSWORD = passwordField.getText();
				String DBname = DBnameField.getText();
				DBM.dataset = DatabaseAccess.DBLoad(DBname, USER_NAME, PASSWORD);
				if(DBM.login_check==false) {
					dispose();
					new LOGIN();
				}else {
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
					MAIN.selection();
				}
			}
		});
        layeredPane.add(lgbt);
        ex.setBounds(370, 370, 100, 50);
        ex.setFocusPainted(false);
		ex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ex.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//////////////////////////////////
				System.exit(0);	
			}

		});
		layeredPane.add(ex);
        // ������ �߰���
        layeredPane.add(panel);
        add(layeredPane);
        setVisible(true);
		
	}
	@SuppressWarnings("serial")
	class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
	public void setMain(MAIN main) {
		this.main = main;
	}   
}
