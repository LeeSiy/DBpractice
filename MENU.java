import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MENU extends JFrame {
	private MAIN main;
	int[] s = new int[1000];
	String SelectedDname;
	String[] SelectedSsn = {"Default"};
	String SelectedAction;
	String tx = "�˻��� �ο�:";
	JLabel label2 = new JLabel(tx);
	JLabel label3 = new JLabel("0");
	int chosen = 0;
	int row = 0;
	private int[] show = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private Choice choice, choice3;
	static String[] name = { "����", "Fname", "Lname", "Minit", "Ssn", "Bdate", "Address", "Sex", "Salary", "sup_Fname",
			"sup_Lname", "Dname" };
	// ������
	public static void main(String[] args) {
		new MENU();
	}

	@SuppressWarnings("unlikely-arg-type")
	public MENU() {
		JFrame frame = new JFrame("DB �˻�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		// ����â ����
		JPanel north = new JPanel();
		choice = new Choice();
		choice.add("�μ���");
		choice.add("��ü");
		choice.add("Research");
		choice.add("Administration");
		choice.add("Headquarters");
		north.add(choice);

		//
		JPanel south = new JPanel();
		JTextField tf;
		JButton btn, btn2, btn3, btn4;
		JTextArea ta;
		JTextField SalaryTextField;
		JLabel label;

		//
		btn = new JButton("�˻�");
		btn2 = new JButton("����");
		btn3 = new JButton("����");
		btn4 = new JButton("����");
		label = new JLabel("��������:");
		label.setFont(new Font("���� ���", 20, 20)); // ��Ʈ ����
		label.setSize(180, 20); // ũ�� ����
		SalaryTextField = new JTextField(10);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				for(int number : s) {
					number = 0;
				}
				int i = 0;
				Object[][] print_data = new Object[1000][12];
				for (RESULT line : DBM.dataset) {
					if(SelectedDname.equals(line.Dname)||SelectedDname.contains("��ü")) {
						print_data[i][1] = line.Fname;
						print_data[i][2] = line.Lname;
						print_data[i][3] = line.Minit;
						print_data[i][4] = line.Ssn;
						print_data[i][5] = line.Bdate;
						print_data[i][6] = line.Address;
						print_data[i][7] = line.Sex;
						print_data[i][8] = line.Salary + "";
						print_data[i][9] = line.Super_Fname;
						print_data[i][10] = line.Super_Lname;
						print_data[i][11] = line.Dname;
						i++;
					}
				}
				for(Object[] line3:print_data) {
					line3[0] = false;
				}
				row = i;
				JTable table = new JTable(print_data, name);
				JCheckBox cb = new JCheckBox();
				@SuppressWarnings("serial")
				DefaultCellEditor checkEditor = new DefaultCellEditor(cb) {

					public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,

							int row, int column) {

						JCheckBox editor;

						editor = (JCheckBox) super.getTableCellEditorComponent(table, value, isSelected, row, column);

						return editor;
					}
				};
				table.getColumn("����").setCellEditor(checkEditor);
				table.getColumn("����").setCellRenderer(new cellCheckRenderer());
				for (int k = 0; k < 12; k++) {
					if (show[k]%2==1) {
						//int temp = print_data[0][k].length();
						table.getColumnModel().getColumn(k).setPreferredWidth(30);
					}else {
						table.getColumn(name[k]).setWidth(0);
						table.getColumn(name[k]).setMinWidth(0);
						table.getColumn(name[k]).setMaxWidth(0);
					}
				}
				resizeColumnWidth(table);
				JScrollPane da = new JScrollPane(table);
				JPanel west = new JPanel();
				label3.setFont(new Font("���� ���", 15, 15)); //��Ʈ ����
				west.add(label2);
				String Row = row +"";
				label3.setText(Row);
				label2.setFont(new Font("���� ���", 15, 15)); //��Ʈ ����
				west.add(label3);
				frame.add(west, BorderLayout.WEST);
				frame.add(da, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		south.add(btn);
		south.add(btn4);
		south.add(btn3);
		choice3 = new Choice();
		choice3.add("����/����");
		choice3.add("����");
		choice3.add("����");
		south.add(choice3);
		south.add(label);
		south.add(SalaryTextField);
		south.add(btn2);
		//
        choice3.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		SelectedAction = choice3.getSelectedItem();
        	}
        });
        btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean delete = false;
            	String Salary = SalaryTextField.getText();
            	if(Salary.isEmpty())
            		Salary = "0";
            	double salary = Double.parseDouble(Salary);
				for (String line : SelectedSsn) {
					for (int i = 0; i < DBM.dataset.length - 1; i++) {
						if (DBM.dataset[i].Ssn.equals(line)) {
							if (SelectedAction.equals("����")) {
								delete = true;
								String temp2 = DBM.dataset[i].Ssn;
								DatabaseAccess.DBDelete(temp2);
								for (int k = i; k < DBM.dataset.length - 2; k++) {
									DBM.dataset[k] = DBM.dataset[k + 1];
								}
								break;
							} else if (SelectedAction.equals("����")) {
								DBM.dataset[i].Salary = salary;
								String temp = DBM.dataset[i].Ssn;
								DatabaseAccess.DBUpdate(salary, temp);
								break;
							}
						}
					}
					if (delete == true)
						DBM.dataset[DBM.dataset.length - 2] = new RESULT("", "", "", "", "", "", "", 0.0, "", "", "");
				}
				frame.setVisible(true);
			}
		});

		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MAIN.insert();
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// üũ �ڽ� ����
		JCheckBox chk1 = new JCheckBox("Fname", false);
		JCheckBox chk2 = new JCheckBox("Lname", false);
		JCheckBox chk3 = new JCheckBox("Minit", false);
		JCheckBox chk4 = new JCheckBox("Ssn", false);
		JCheckBox chk5 = new JCheckBox("Bdate", false);
		JCheckBox chk6 = new JCheckBox("Address", false);
		JCheckBox chk7 = new JCheckBox("Sex", false);
		JCheckBox chk8 = new JCheckBox("Salary", false);
		JCheckBox chk9 = new JCheckBox("Sup_Fname", false);
		JCheckBox chk10 = new JCheckBox("Sup_Lname", false);
		JCheckBox chk11 = new JCheckBox("Dname", false);
		north.add(chk1);
		north.add(chk2);
		north.add(chk3);
		north.add(chk4);
		north.add(chk5);
		north.add(chk6);
		north.add(chk7);
		north.add(chk8);
		north.add(chk9);
		north.add(chk10);
		north.add(chk11);
		// choice �̺�Ʈ ó��
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				SelectedDname = choice.getSelectedItem();
			}
		});

		// üũ �ڽ� �̺�Ʈó��: ���õ� �׸��� index�� ������ ���� show �迭 ��Ҹ� 1�� �ٲپ��༭ ��½� �����ϴµ� �̿�.
		chk1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[1] += 1;
			}
		});
		chk2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[2] += 1;
			}
		});
		chk3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[3] += 1;
			}
		});
		chk4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[4] += 1;
			}
		});
		chk5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[5] += 1;
			}
		});
		chk6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[6] += 1;
			}
		});
		chk7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[7] += 1;
			}
		});
		chk8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[8] += 1;
			}
		});
		chk9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[9] += 1;
			}
		});
		chk10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[10] += 1;
			}
		});
		chk11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				show[11] += 1;
			}
		});

		//
		frame.add(north, BorderLayout.NORTH);
		frame.add(south, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	static <T> T[] append(T[] arr, T element) {
		final int N = arr.length;
		arr = Arrays.copyOf(arr, N + 1);
		arr[N] = element;
		return arr;
	}

	class cellCheckRenderer extends DefaultTableCellRenderer {

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JCheckBox check = new JCheckBox();
			check.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					s[table.getSelectedRow()]++;
					if(s[table.getSelectedRow()]%2==1) {
						SelectedSsn =(String[]) append(SelectedSsn,table.getValueAt(table.getSelectedRow(), 4));
					}
					else {
						if(SelectedSsn[0].equals("")!=true) {
							for(String line : SelectedSsn) {
								if(line.equals(table.getValueAt(table.getSelectedRow(), 4))) {
									line = "";
								}
							}
						}
					}
				}
			});
			check.setSelected(((Boolean) value).booleanValue());
			check.setHorizontalAlignment(SwingConstants.CENTER);
			return check;

		}
	}
	public void resizeColumnWidth(JTable table) {
	       final TableColumnModel columnModel = table.getColumnModel();
	       for (int column = 0; column < table.getColumnCount(); column++) {
	           int width = 15; // Min width
	           for (int row = 0; row < table.getRowCount(); row++) {
	               TableCellRenderer renderer = table.getCellRenderer(row, column);
	               Component comp = table.prepareRenderer(renderer, row, column);
	               width = Math.max(comp.getPreferredSize().width +1 , width);
	           }
	           if(width > 300)
	               width=300;
	           columnModel.getColumn(column).setPreferredWidth(width);
	       }
	}
}

