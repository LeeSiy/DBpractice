import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.*;
public class MENU2 extends JFrame {
	private MAIN main;
	String SelectedDname;
	private int[] show= {0,0,0,0,0,0,0,0,0,0,0};
	private Choice choice, choice2, choice3;
    // ������
	public static void main(String[] args) {
        new MENU();
     }
    @SuppressWarnings("unlikely-arg-type")
	public MENU2(){
        this.setTitle("DB �˻�");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        //����â ����
        choice = new Choice();
        choice.add("�μ���");
        choice.add("��ü");
        choice.add("Research");
        choice.add("Administration");
        choice.add("Headquarters");
        this.add(choice);
        
        // üũ �ڽ� ����
        JCheckBox chk1 = new JCheckBox("Fname",false);
        JCheckBox chk2 = new JCheckBox("Lname",false);
        JCheckBox chk3 = new JCheckBox("Minit",false);
        JCheckBox chk4 = new JCheckBox("Ssn",false);
        JCheckBox chk5 = new JCheckBox("Bdate",false);
        JCheckBox chk6 = new JCheckBox("Address",false);
        JCheckBox chk7 = new JCheckBox("Sex",false);
        JCheckBox chk8 = new JCheckBox("Salary",false);
        JCheckBox chk9 = new JCheckBox("Sup_Fname",false);
        JCheckBox chk10 = new JCheckBox("Sup_Lname",false);
        JCheckBox chk11 = new JCheckBox("Dname",false);
        this.add(chk1);
        this.add(chk2);
        this.add(chk3);
        this.add(chk4);
        this.add(chk5);
        this.add(chk6);
        this.add(chk7);
        this.add(chk8);
        this.add(chk9);
        this.add(chk10);
        this.add(chk11);
        
        //choice �̺�Ʈ ó��
        choice.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		SelectedDname = choice.getSelectedItem();
        	}
        });
        
        //üũ �ڽ� �̺�Ʈó��: ���õ� �׸��� index�� ������ ���� show �迭 ��Ҹ� 1�� �ٲپ��༭ ��½� �����ϴµ� �̿�.
        chk1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[0]+=1;
        	}
        });
        chk2.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[1]+=1;
        	}
        });
        chk3.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[2]+=1;
        	}
        });
        chk4.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[3]+=1;
        	}
        });
        chk5.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[4]+=1;
        	}
        });
        chk6.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[5]+=1;
        	}
        });
        chk7.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[6]+=1;
        	}
        });
        chk8.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[7]+=1;
        	}
        });
        chk9.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[8]+=1;
        	}
        });
        chk10.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[9]+=1;
        	}
        });
        chk11.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		show[10]+=1;
        	}
        });
        this.add(new MyCenterPanel(), BorderLayout.SOUTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
    //Textarea�� ���� ��ư�� ���� �г� ���� Ŭ����.
    class MyCenterPanel extends JPanel{
        JTextField tf;
        JButton btn,btn2,btn3,btn4;
        JTextArea ta;
        String SelectedSsn;
    	String SelectedAction;
    	JTextField SalaryTextField;
    	JLabel label;
        MyCenterPanel(){
            btn=new JButton("�˻�");
            btn2=new JButton("����");
            btn3=new JButton("����");
            btn4=new JButton("����");
            choice2 = new Choice();
            choice2.add("Tuple����");
            label = new JLabel("��������:");
            label.setFont(new Font("���� ���", 20, 20)); //��Ʈ ����
    		label.setSize(180, 20);  //ũ�� ����
            SalaryTextField = new JTextField(10);
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	choice2.removeAll();
                	choice2.add("Tuple����");
                	ta.setText(null); 
                	ta.append("�˻� ���\n");
                	boolean value=false;
                	//�˻���� ȭ�鿡 �̿��ڰ� üũ�� ��Ҹ��� ����ϱ����� ���� �̺�Ʈ �Լ����� ������ Show �迭�� �����Ͽ� ���.
                	for(RESULT line : DBM.dataset) {
                		if(line.Ssn.equals("")==false) {
	                		if(SelectedDname.equals("��ü") || SelectedDname.equals(line.Dname)) {
	                			choice2.add(line.Ssn);
			                	if(show[0]%2==1) {
			                    	String temp = line.Fname+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                    }
			                	if(show[1]%2==1) {
			                    	String temp = line.Lname+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                    }
			                	if(show[2]%2==1) {
			                    	String temp = line.Minit+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[3]%2==1) {
			                    	String temp = line.Ssn+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[4]%2==1) {
			                    	String temp = line.Bdate+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[5]%2==1) {
			                    	String temp = line.Address+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[6]%2==1) {
			                    	String temp = line.Sex+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[7]%2==1) {
			                    	String temp = line.Salary+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[8]%2==1) {
			                    	String temp = line.Super_Fname+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[9]%2==1) {
			                    	String temp = line.Super_Lname+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
			                	if(show[10]%2==1) {
			                    	String temp = line.Dname+"\t";
			                    	ta.append(temp);
			                    	value = true;
			                	}
	                		}
                		}
	                	if(value) {
	                		ta.append("\n");
	                		value = false;
	                	}
                	}
                }
            });
            ta=new JTextArea("�˻� ���\n",30,120);
            add(btn);
            add(btn4);
            add(btn3);
            this.add(choice2);
            choice3 = new Choice();
            choice3.add("����/����");
            choice3.add("����");
            choice3.add("����");
            this.add(choice3);
            add(choice3);
            this.add(label);
            this.add(SalaryTextField);
            add(btn2);
            add(new JScrollPane(ta));
            choice2.addItemListener(new ItemListener() {
            	public void itemStateChanged(ItemEvent e) {
            		SelectedSsn = choice2.getSelectedItem();
            	}
            });
            choice3.addItemListener(new ItemListener() {
            	public void itemStateChanged(ItemEvent e) {
            		SelectedAction = choice3.getSelectedItem();
            	}
            });
            btn2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	boolean delete = false;
                	String Salary = SalaryTextField.getText();
                	if(Salary.isEmpty())
                		Salary = "0";
                	double salary = Double.parseDouble(Salary);
                	for(int i = 0; i<DBM.dataset.length-1;i++) {
                		if(DBM.dataset[i].Ssn.equals(SelectedSsn)) {
                			if(SelectedAction.equals("����")) {
                				delete = true;
                				String temp2 = DBM.dataset[i].Ssn;
            					DatabaseAccess.DBDelete(temp2);
                				for(int k = i; k < DBM.dataset.length-2; k++) {
                					DBM.dataset[k] = DBM.dataset[k+1];
                				}
                				break;
                			}else if(SelectedAction.equals("����")) {
                				DBM.dataset[i].Salary = salary;
                				String temp = DBM.dataset[i].Ssn;
                				DatabaseAccess.DBUpdate(salary, temp);
                				break;
                			}
                		}
                	}
                	if(delete==true)
                		DBM.dataset[DBM.dataset.length-2] = new RESULT("","","","","","","",0.0,"","","");
                }
            });
            btn4.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	MAIN.insert();
                }
            });
            btn3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	System.exit(0);
                }
            });
        }
    }
}
