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
    // 생성자
	public static void main(String[] args) {
        new MENU();
     }
    @SuppressWarnings("unlikely-arg-type")
	public MENU2(){
        this.setTitle("DB 검색");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        //선택창 생성
        choice = new Choice();
        choice.add("부서명");
        choice.add("전체");
        choice.add("Research");
        choice.add("Administration");
        choice.add("Headquarters");
        this.add(choice);
        
        // 체크 박스 생성
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
        
        //choice 이벤트 처리
        choice.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		SelectedDname = choice.getSelectedItem();
        	}
        });
        
        //체크 박스 이벤트처리: 선택된 항목의 index와 순서가 같은 show 배열 요소를 1로 바꾸어줘서 출력시 매핑하는데 이용.
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
    //Textarea와 실행 버튼을 위한 패널 생성 클래스.
    class MyCenterPanel extends JPanel{
        JTextField tf;
        JButton btn,btn2,btn3,btn4;
        JTextArea ta;
        String SelectedSsn;
    	String SelectedAction;
    	JTextField SalaryTextField;
    	JLabel label;
        MyCenterPanel(){
            btn=new JButton("검색");
            btn2=new JButton("실행");
            btn3=new JButton("종료");
            btn4=new JButton("삽입");
            choice2 = new Choice();
            choice2.add("Tuple선택");
            label = new JLabel("수정내용:");
            label.setFont(new Font("맑은 고딕", 20, 20)); //폰트 설정
    		label.setSize(180, 20);  //크기 설정
            SalaryTextField = new JTextField(10);
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	choice2.removeAll();
                	choice2.add("Tuple선택");
                	ta.setText(null); 
                	ta.append("검색 결과\n");
                	boolean value=false;
                	//검색결과 화면에 이용자가 체크한 요소만을 출력하기위해 위의 이벤트 함수에서 수정한 Show 배열을 매핑하여 출력.
                	for(RESULT line : DBM.dataset) {
                		if(line.Ssn.equals("")==false) {
	                		if(SelectedDname.equals("전체") || SelectedDname.equals(line.Dname)) {
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
            ta=new JTextArea("검색 결과\n",30,120);
            add(btn);
            add(btn4);
            add(btn3);
            this.add(choice2);
            choice3 = new Choice();
            choice3.add("삭제/수정");
            choice3.add("삭제");
            choice3.add("수정");
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
                			if(SelectedAction.equals("삭제")) {
                				delete = true;
                				String temp2 = DBM.dataset[i].Ssn;
            					DatabaseAccess.DBDelete(temp2);
                				for(int k = i; k < DBM.dataset.length-2; k++) {
                					DBM.dataset[k] = DBM.dataset[k+1];
                				}
                				break;
                			}else if(SelectedAction.equals("수정")) {
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
