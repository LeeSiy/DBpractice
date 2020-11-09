import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MENU extends JFrame {
	private MAIN main;
	int[] s = new int[1000];
	String[] SelectedSsn = { "Default" };
	String SelectedAction;
	String tx = "검색된 인원:";
	JLabel label2 = new JLabel(tx);
	JLabel label3 = new JLabel("0");
	JLabel label5 = new JLabel("선택한 직원:");
	JLabel label6 = new JLabel("");
	JButton search_button = new JButton("이동");
	JTextField searchField = new JTextField(10);
	int chosen = 0;
	int row = 0;
	private Choice choice, choice3;
	static String[] name = { "선택", "Fname", "Lname", "Minit", "Ssn", "Bdate", "Address", "Sex", "Salary", "sup_Fname",
			"sup_Lname", "Dname" };

	// 생성자
	public static void main(String[] args) {
		new MENU();
	}

	public MENU() {
		JFrame frame = new JFrame("DB 검색");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		// 선택창 생성
		JPanel north = new JPanel();
		choice = new Choice();
		choice.add("부서명");
		choice.add("전체");
		choice.add("Research");
		choice.add("Administration");
		choice.add("Headquarters");
		north.add(choice);

		//
		JPanel south = new JPanel();
		JButton btn, btn2, btn3, btn4;
		JTextField SalaryTextField;
		JLabel label;

		//
		btn = new JButton("검색");
		btn2 = new JButton("실행");
		btn3 = new JButton("종료");
		btn4 = new JButton("삽입");
		label = new JLabel("수정내용:");
		label.setFont(new Font("맑은 고딕", 20, 20)); // 폰트 설정
		label.setSize(180, 20); // 크기 설정
		SalaryTextField = new JTextField(10);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				frame.dispose();
				MAIN.searching();
			}
		});
		int i5 = 0;
		for (int number : s) {
			s[i5] = 0;
			i5++;
		}
		int i6 = 0;
		for (String l2 : SelectedSsn) {
			if (i6 != 0) {
				SelectedSsn[i6] = "";
			}
			i6++;
		}
		int i = 0;
		Object[][] print_data = new Object[1000][12];
		for (RESULT line : DBM.dataset) {
			if (DBM.SelectedDname.equals(line.Dname) || DBM.SelectedDname.contains("전체")) {
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
		for (Object[] line3 : print_data) {
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
		for (int k = 1; k < 12; k++) {
			if (DBM.show[k] % 2 == 1) {
				// int temp = print_data[0][k].length();
				table.getColumnModel().getColumn(k);
			} else {
				table.getColumn(name[k]).setWidth(0);
				table.getColumn(name[k]).setMinWidth(0);
				table.getColumn(name[k]).setMaxWidth(0);
			}
		}
		table.getColumn("선택").setCellEditor(checkEditor);
		table.getColumn("선택").setCellRenderer(new cellCheckRenderer());
		table.getColumn("선택").setWidth(30);
		table.getColumn("선택").setMinWidth(30);
		table.getColumn("선택").setMaxWidth(30);
		//resizeColumnWidth(table);
		JScrollPane da = new JScrollPane(table);
		JPanel west = new JPanel();
		label3.setFont(new Font("맑은 고딕", 15, 15)); // 폰트 설정
		west.add(label2);
		String Row = row + "";
		label3.setText(Row);
		label2.setFont(new Font("맑은 고딕", 15, 15)); // 폰트 설정
		west.add(label3);
		west.add(searchField);
		search_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Search = searchField.getText();
				boolean no = false;
				for (int f = 0; f < row; f++) {
					if (print_data[f][4].equals(Search)) {
						table.changeSelection(f, 0, false, false);
						no = true;
					}
				}
				if (!no)
					JOptionPane.showMessageDialog(null, "해당인원은 존재하지 않습니다.");
			}
		});
		west.add(search_button);
		frame.add(west, BorderLayout.WEST);
		frame.add(da, BorderLayout.CENTER);
		for(int init = 1; init<12;init++) {
			DBM.show[init]=0;
		}
		south.add(btn);
		south.add(btn4);
		south.add(btn3);
		choice3 = new Choice();
		choice3.add("삭제/수정");
		choice3.add("삭제");
		choice3.add("수정");
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
				if (Salary.isEmpty())
					Salary = "0";
				double salary = Double.parseDouble(Salary);
				for(int count=0;count<row;count++) {
					if((boolean) table.getValueAt(count,0)) {
						SelectedSsn = append(SelectedSsn, (String)table.getValueAt(count,4));
						System.out.println(SelectedSsn);
					}
				}
				for (String line : SelectedSsn) {
					for (int i = 0; i < DBM.dataset.length - 1; i++) {
						if (DBM.dataset[i].Ssn.equals(line)) {
							if (SelectedAction.equals("삭제")) {
								delete = true;
								String temp2 = DBM.dataset[i].Ssn;
								DatabaseAccess.DBDelete(temp2);
								for (int k = i; k < DBM.dataset.length - 2; k++) {
									DBM.dataset[k] = DBM.dataset[k + 1];
								}
								break;
							} else if (SelectedAction.equals("수정")) {
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
				frame.dispose();
				MAIN.insert();
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// 체크 박스 생성
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
		// choice 이벤트 처리
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.SelectedDname = choice.getSelectedItem();
			}
		});

		// 체크 박스 이벤트처리: 선택된 항목의 index와 순서가 같은 DBM.show 배열 요소를 1로 바꾸어줘서 출력시 매핑하는데 이용.
		chk1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[1] += 1;
			}
		});
		chk2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[2] += 1;
			}
		});
		chk3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[3] += 1;
			}
		});
		chk4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[4] += 1;
			}
		});
		chk5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[5] += 1;
			}
		});
		chk6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[6] += 1;
			}
		});
		chk7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[7] += 1;
			}
		});
		chk8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[8] += 1;
			}
		});
		chk9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[9] += 1;
			}
		});
		chk10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[10] += 1;
			}
		});
		chk11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DBM.show[11] += 1;
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
			check.setSelected(((Boolean) value).booleanValue());
			check.setHorizontalAlignment(SwingConstants.CENTER);
			return check;
		}
	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 1; column < table.getColumnCount(); column++) {
			int width = 15; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}


