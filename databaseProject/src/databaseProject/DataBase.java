package databaseProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.util.Arrays;
import javax.swing.JTable;
import java.awt.event.InputMethodListener;
import java.awt.print.PrinterException;
import java.awt.event.InputMethodEvent;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;

public class DataBase {

	public JFrame frmDatabase;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField;
	private JTextField firstNameT;
	private JTextField lastNameT;
	private JTextField emailT;
	private JTextField phoneNumberT;
	private JTextField birthdayT;
	private JTextField postionT;
	private JTextField ssnT;
	private JTextField usernameT;
	private JTextField passwordT;
	private JTable table_4;
	private JTextField hourInput;
	private JTextField dateInput;
	
	
	//Employee labels
	private JLabel fNameL;
	private JLabel lNameL;
	private JLabel emailL;
	private JLabel phoneNumberL;
	private JLabel positionL;
	private JLabel birthdayL;
	private JLabel usernameL;
	private JLabel passwordL;
	private JLabel ssnL;
	
	
	
	//add hours labels
	private JLabel numHoursL;
	private JLabel whenL;

	public DataBase() {
		initialize();
	}

	public void initialize() {
		
		frmDatabase = new JFrame();
		frmDatabase.setTitle("Database");
		frmDatabase.setSize(500, 500);
		//frmDatabase.setBounds(100, 100, 450, 300);
		frmDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmDatabase.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Querys", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		JComboBox comboBox = new JComboBox();
		
		
		
		//J button for query panel
		JButton btnNewButton = new JButton("Excute Query");
		btnNewButton.addActionListener(new ActionListener() {
			
			//SQL code
			public void actionPerformed(ActionEvent e) {
				String query = (String) comboBox.getSelectedItem();
				Query q = new Query();
				q.runQuery(query);
				TableModel model = new DefaultTableModel(q.getData(), q.getColumns());
				table.setModel(model);
			}
		});
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Credit Score", "Job Experience", "Employee Hours", "Accepted Loans", "Rejected Loans", "Pending Loans", "Loan Time", "Risk Factors", "Background Info", "Preview Projects", "All Profit", "Loan Length", "Specific Profit", "Positive Profits", "All Loan Lengths"}));
		
		JLabel lblNewLabel_1 = new JLabel("Queries:");
		lblNewLabel_1.setLabelFor(comboBox);
		
		JButton btnNewButton_9 = new JButton("Print Table");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(comboBox, 0, 179, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addGap(40))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
					.addGap(50))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(156)
					.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
					.addGap(212))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
		);
		//ending layout for query tab
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 =new JPanel();
		tabbedPane.addTab("Delete", null, panel_1, null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Applicant", "Degree", "Employee", "Experience", "Finances", "Hours", "Loan", "Person", "Phone", "Profits", "Projects", "Property", "View"}));
		
		JLabel lblNewLabel_2 = new JLabel("Select Table:");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JButton btnNewButton_2 = new JButton("Get Table");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = (String) comboBox_2.getSelectedItem();
				Query q2 = new Query();
				q2.runQuery(query);
				TableModel model2 = new DefaultTableModel(q2.getData(), q2.getColumns());
				table_2.setModel(model2);
				
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int columnCount = table_2.getColumnCount();
				String rowData[] = new String[columnCount];
				int row = table_2.getSelectedRow();
				for(int i = 0; i < columnCount; i++) {
					rowData[i] = (String) table_2.getValueAt(row, i);
				}
				
			   
				String selectedTable = (String) comboBox_2.getSelectedItem();
				String message = "Are you sure you want to delete ";
				int choice = JOptionPane.showConfirmDialog(null, message);
				
				if(choice == 0) {
				Query q3 = new Query();
				q3.runDelete(rowData, selectedTable);
				}
				else
					JOptionPane.showMessageDialog(null, "no data deleted");
				
				
			}
		});
		
		
		 /* for (int j = 0; j < selectedColumns.length; j++) {
        selectedData = (String) table_2.getValueAt(selectedRow[i], selectedColumns[j]);
      } */
		
		
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(comboBox_2, 0, 165, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
					.addGap(16))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(161)
					.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(151))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(75)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addGap(82))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2))
					.addGap(18)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnNewButton_3)
					.addGap(39))
		);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update", null, panel_2, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblNewLabel_3 = new JLabel("Select Table");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Applicant", "Degree", "Employee", "Experience", "Finances", "Hours", "Loan", "Person", "Phone", "Profits", "Projects", "Property", "View"}));
		JButton btnNewButton_4 = new JButton("Get Table");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String query = (String) comboBox_3.getSelectedItem();
				Query q3 = new Query();
				q3.runQuery(query);
				TableModel model3 = new DefaultTableModel(q3.getData(), q3.getColumns());
				table_3.setModel(model3);
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Change");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Apply");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String change = textField.getText();
				
				int column = table_3.getSelectedColumn();
				int columnCount = table_3.getColumnCount();
				String rowData[] = new String[columnCount];
				int row = table_3.getSelectedRow();
				for(int i = 0; i < columnCount; i++) {
					rowData[i] = (String) table_3.getValueAt(row, i);
				}
				
				
				String selectedTable = (String) comboBox_3.getSelectedItem();
				String message = "Are you sure you want to updated?";
				int choice = JOptionPane.showConfirmDialog(null, message);
				
				if(choice == 0) {
				Query q3 = new Query();
				q3.update(rowData, selectedTable, column, change);
				}
				else
					JOptionPane.showMessageDialog(null, "NO DATA UPDATED!");
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(comboBox_3, 0, 138, Short.MAX_VALUE)
					.addGap(44)
					.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(textField, 155, 155, 155)
					.addGap(93))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(82)
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
					.addGap(78))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(145)
					.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(167))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(46)
					.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Select Table", null, panel_3, null);
		
		table_3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	int column = table_3.getSelectedColumn();
				int row = table_3.getSelectedRow();
				if (table_3.getSelectedRow() > -1) {
		           
					String newLabel = "Change " + table_3.getValueAt(row, column) + " to ";
					lblNewLabel_4.setText(newLabel);
		        }
				
		    }
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Applicant", "Degree", "Employee", "Experience", "Finances", "Hours", "Loan", "Person", "Phone", "Profits", "Projects", "Property", "View"}));
		JLabel lblNewLabel = new JLabel("Tables:");
		lblNewLabel.setLabelFor(comboBox_1);
		
		
		//jbutton for table tab
		JButton btnNewButton_1 = new JButton("Show table");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query = (String) comboBox_1.getSelectedItem();
				Query q1 = new Query();
				q1.runQuery(query);
				TableModel model1 = new DefaultTableModel(q1.getData(), q1.getColumns());
				table_1.setModel(model1);
				
				
				
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnNewButton_8 = new JButton("Print Table");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					table_1.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(48)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
					.addGap(55))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(btnNewButton_8, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(198))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(comboBox_1, 0, 129, Short.MAX_VALUE)
							.addGap(33)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(23))))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Add Employee", null, panel_4, null);
		
		firstNameT = new JTextField();
		firstNameT.setBounds(38, 53, 155, 26);
		firstNameT.setColumns(10);
		
		fNameL = new JLabel("First Name");
		fNameL.setBounds(38, 25, 68, 16);
		
		lastNameT = new JTextField();
		lastNameT.setBounds(323, 53, 130, 26);
		lastNameT.setColumns(10);
		
		lNameL = new JLabel("Last Name");
		lNameL.setBounds(323, 25, 66, 16);
		
		emailT = new JTextField();
		emailT.setBounds(38, 118, 219, 26);
		emailT.setColumns(10);
		
		phoneNumberT = new JTextField();
		phoneNumberT.setBounds(35, 257, 130, 26);
		phoneNumberT.setColumns(10);
		
		emailL = new JLabel("Email");
		emailL.setBounds(38, 90, 34, 16);
		
		phoneNumberL = new JLabel("Phone Number");
		phoneNumberL.setBounds(35, 229, 92, 16);
		phoneNumberL.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox sexC = new JComboBox();
		sexC.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		sexC.setBounds(205, 54, 84, 27);
		
		JLabel lblNewLabel_9 = new JLabel("Sex");
		lblNewLabel_9.setBounds(220, 25, 22, 16);
		
		birthdayT = new JTextField();
		birthdayT.setBounds(323, 204, 130, 26);
		birthdayT.setColumns(10);
		
		birthdayL = new JLabel("Birthday xxxx-xx-xx");
		birthdayL.setBounds(318, 176, 135, 16);
		
		postionT = new JTextField();
		postionT.setBounds(35, 191, 130, 26);
		postionT.setColumns(10);
		
		positionL = new JLabel("Position");
		positionL.setBounds(38, 156, 51, 16);
		
		ssnT = new JTextField();
		ssnT.setBounds(298, 118, 155, 26);
		ssnT.setColumns(10);
		
		ssnL = new JLabel("Social Security Number");
		ssnL.setBounds(278, 90, 175, 16);
		panel_4.setLayout(null);
		panel_4.add(postionT);
		panel_4.add(positionL);
		panel_4.add(ssnT);
		panel_4.add(ssnL);
		panel_4.add(fNameL);
		panel_4.add(lNameL);
		panel_4.add(firstNameT);
		panel_4.add(emailT);
		panel_4.add(birthdayL);
		panel_4.add(birthdayT);
		panel_4.add(sexC);
		panel_4.add(emailL);
		panel_4.add(lblNewLabel_9);
		panel_4.add(lastNameT);
		panel_4.add(phoneNumberT);
		panel_4.add(phoneNumberL);
		JButton addEmpB = new JButton("Add Employee");
		addEmpB.setBounds(189, 381, 117, 29);
		panel_4.add(addEmpB);
		
		JComboBox phoneTypeC = new JComboBox();
		phoneTypeC.setModel(new DefaultComboBoxModel(new String[] {"Home", "Cell", "Work"}));
		phoneTypeC.setBounds(323, 258, 130, 27);
		panel_4.add(phoneTypeC);
		
		usernameT = new JTextField();
		usernameT.setBounds(35, 343, 155, 26);
		panel_4.add(usernameT);
		usernameT.setColumns(10);
		
		usernameL = new JLabel("Username");
		usernameL.setBounds(38, 315, 97, 16);
		panel_4.add(usernameL);
		
		passwordT = new JTextField();
		passwordT.setBounds(323, 343, 130, 26);
		panel_4.add(passwordT);
		passwordT.setColumns(10);
		
		passwordL = new JLabel("Password");
		passwordL.setBounds(323, 315, 61, 16);
		panel_4.add(passwordL);
		//add Employees
		
		addEmpB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fN = firstNameT.getText();
				String lN = lastNameT.getText();
				String sex = (String)sexC.getSelectedItem();
				String email = emailT.getText();
				String phone = phoneNumberT.getText();
				String position = postionT.getText();
				String birthday = birthdayT.getText();
				String username = usernameT.getText();
				String password = passwordT.getText();
				String ssn = ssnT.getText();
				String phoneType = (String)phoneTypeC.getSelectedItem();
				
				
				String message = "Are you sure you want to add Employee?";
				int choice = JOptionPane.showConfirmDialog(null, message);
				
				
			    boolean dataCorrect = empDataGood(fN, lN, email, phone, position, birthday, username, password, ssn);
					
			
				
				
				if(choice == 0 &&  dataCorrect) {
				Query q3 = new Query();
				q3.addEmp(fN, lN, sex, email, phone, position, birthday, username, password, ssn, phoneType);
				}
				else
					JOptionPane.showMessageDialog(null, "Data not entered correctly or not entered at all!");
				
			}
		});
		
		
		
		
		JLabel lblNewLabel_17 = new JLabel("Phone type");
		lblNewLabel_17.setBounds(328, 229, 125, 16);
		panel_4.add(lblNewLabel_17);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Hours", null, panel_5, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JButton btnNewButton_7 = new JButton("Refresh");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query q2 = new Query();
				q2.runQuery("Employee");
				TableModel model2 = new DefaultTableModel(q2.getData(), q2.getColumns());
				table_4.setModel(model2);
				
			}
		});
		
		hourInput = new JTextField();
		hourInput.setColumns(10);
		
		numHoursL = new JLabel("How many hours?");
		
		dateInput = new JTextField();
		dateInput.setColumns(10);
		
		whenL = new JLabel("When?");
		
		JLabel hourOuput = new JLabel("New label");
		//Add hours
		JButton btnNewButton_6 = new JButton("Add Hours");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hours = hourInput.getText();
				String date = dateInput.getText();
				int column = table_4.getSelectedColumn();
				int columnCount = table_4.getColumnCount();
				String rowData[] = new String[columnCount];
				int row = table_4.getSelectedRow();
				for(int i = 0; i < columnCount; i++) {
					rowData[i] = (String) table_4.getValueAt(row, i);
				}
				
				
				
				
				
				
				String message = "Are you sure you want to add hours";
				int choice = JOptionPane.showConfirmDialog(null, message);
				boolean isDataGood = isHourDataGood(hours, date);
				if(choice == 0 && isDataGood) {
				Query q3 = new Query();
				q3.addHours(rowData[0], hours, date);
				//System.out.println("ssn: " + rowData[0] + " hours: " + hours + " date: " + date);
				}
				else if(choice == 0 && !isDataGood)
					JOptionPane.showMessageDialog(null, "No hours Added becasue bad data entry");
				else
					JOptionPane.showMessageDialog(null, "No hours Added");
				
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(89)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(numHoursL)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(hourInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(whenL)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(dateInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(hourOuput, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(184)
							.addComponent(btnNewButton_7))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(176)
							.addComponent(btnNewButton_6)))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(22)
					.addComponent(btnNewButton_7)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(numHoursL)
						.addComponent(hourInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(whenL))
					.addGap(18)
					.addComponent(hourOuput)
					.addGap(18)
					.addComponent(btnNewButton_6)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		panel_5.setLayout(gl_panel_5);
	
	}
	
	
	
	
	// data entry checks
	public boolean dateCheck(String date){
		  if(date.length() == 10){
		    for(int i = 0; i < 4; i++){
		     

		      if(!(Character.isDigit(date.charAt(i))))
		        return false;
		    }
		    
		  
		  for(int i = 5; i < 7; i++){
		    int num = date.charAt(i);

		      if(!(Character.isDigit(date.charAt(i))))
		        return false;
		    }
		  for(int i = 8; i < 10; i++){
		    int num = date.charAt(i);

		      if(!(Character.isDigit(date.charAt(i))))
		        return false;
		  }
		  if(!(date.charAt(4) == '-' && date.charAt(7) == '-')){
		    return false;
		  }
		    return true;
		  }
		  else
		  return false;
		}
	public boolean isSsn(String ssn){
		   if(ssn.length() == 9){
		     for(int i = 0; i < 9; i++){
		       if(!(Character.isDigit(ssn.charAt(i)))){
		         return false;
		       }
		     }
		     return true;
		   }else
		   return false;
		 }
	public boolean isPhone(String num){
		   if(num.length() == 10){
		     for(int i = 0; i < 10; i++){
		       if(!(Character.isDigit(num.charAt(i)))){
		         return false;
		       }
		     }
		     return true;
		   }else
		   return false;
		 }
	public boolean userPassCheck(String username, String password) {
		Query q21 = new Query();
		return q21.checkLogin(username, password);
	}
	public boolean isNotEmpty(String s){
		   if(s.length() == 0)
		    return false;
		    else
		      return true;
		 }
	public  boolean empDataGood(String fN, String lN, String email, String phone, String position,String birthday,String username,String password, String ssn) {
		
		boolean tf = true;
		
		if(!isNotEmpty(fN)) {
			tf = false;
			fNameL.setForeground(Color.red);
		}else
			fNameL.setForeground(Color.black);
		if(!isNotEmpty(lN)) {
			tf = false;
			lNameL.setForeground(Color.red);
		}else
			lNameL.setForeground(Color.black);
		if(!isNotEmpty(email)) {
			tf = false;
			emailL.setForeground(Color.red);
		}else
			emailL.setForeground(Color.black);
		if(!isPhone(phone)) {
			tf = false;
			phoneNumberL.setForeground(Color.red);
		}else
			phoneNumberL.setForeground(Color.black);
		if(!isNotEmpty(position)) {
			tf = false;
			positionL.setForeground(Color.red);
		}else
			positionL.setForeground(Color.black);
		if(!dateCheck(birthday)) {
			tf = false;
			birthdayL.setForeground(Color.red);
		}else
			birthdayL.setForeground(Color.black);
		if(!isNotEmpty(username)) {
			tf = false;
			usernameL.setForeground(Color.red);
		}else
			usernameL.setForeground(Color.black);
		if(!isNotEmpty(password)) {
			tf = false;
			passwordL.setForeground(Color.red);
		}else
			passwordL.setForeground(Color.black);
		if(!isSsn(ssn)) {
			tf = false;
			ssnL.setForeground(Color.red);
		}else
			ssnL.setForeground(Color.black);
		
		return tf;
	}
	public boolean isHourDataGood(String hours, String date) {
		boolean tf = true;
	if(!isHour(hours)) {
		tf = false;
		numHoursL.setForeground(Color.red);
	}else
		numHoursL.setForeground(Color.black);
	if(!dateCheck(date)) {
		tf = false;
		whenL.setForeground(Color.red);
	}else
		whenL.setForeground(Color.black);
	return tf;
}

	public boolean isHour(String hour) {
		if(hour.length() == 1) {
			if(Character.isDigit(hour.charAt(0)))
				return true;
		}else if(hour.length() ==2){
			if(Character.isDigit(hour.charAt(0)) && Character.isDigit(hour.charAt(1))) {
				if(Integer.parseInt(hour) <= 24)
					return true;
			}
		}
		else
			return false;
		return false;
	}
}
