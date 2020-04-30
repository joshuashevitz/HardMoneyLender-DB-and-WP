package databaseProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
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
import java.awt.event.InputMethodEvent;

public class DataBase {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=1030,631
	 */
	private final JTextPane textPane = new JTextPane();
	private static Statement stmt;
	//private JTable table;
	private String data[][];
	private String columns[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBase window = new DataBase();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		 // TODO code application logic here
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        final String ID = "mmoore54";
        final String PW = "Cosc*66m6";
        final String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/"+ID+"db";
        
        try{
            Connection con = DriverManager.getConnection(SERVER, ID, PW);
            stmt = con.createStatement();
         
           
          
           stmt.executeQuery("use mmoore54db");
			
       
        
        }catch(SQLException e){
            System.err.println(e);
        }

	}

	/**
	 * Create the application.
	 */
	public DataBase() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Credit Score", "Job Experience", "Employee", "Accepted Loans", "Rejected Loans", "Pending Loans", "Loan Time", "Risk Factors", "Background Info", "Preview Projects", "All Profit", "Loan Length", "Specific Profit", "Positive Profits", "All Loan Lengths"}));
		comboBox.setBounds(151, 6, 148, 35);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select Query\n");
		lblNewLabel.setLabelFor(comboBox);
		lblNewLabel.setBounds(38, 14, 101, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Excute Query");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = (String) comboBox.getSelectedItem();
				String excuteStatement = getQuery(query);
				
				System.out.println(excuteStatement);
				
				ResultSet rs;
				try {
					 rs = stmt.executeQuery(excuteStatement);
					   ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					   //System.out.println(excuteStatement);
					   int cn = rsmd.getColumnCount();
					   columns = new String[cn];
					   
					  
					   //get columns
					   for(int i = 1; i <= cn; i++) {
						   columns[i - 1] = rsmd.getColumnName(i);
						  
					   }
					   //getting row number
					   int row = 0;
					   while(rs.next()) {
						   for(int i = 0; i < columns.length; i++) {
							   //System.out.print(rs.getString(columns[i]) + " ");
							   
						   }
						   row++;
						   System.out.println();
					   }
					  rs = stmt.executeQuery(excuteStatement);
					 //getting data
					  //i and j are in the wrong spots
					   int j = 0;
					   data = new String[row][cn];
					   while(rs.next()) {
						   for(int i = 0; i < columns.length; i++) {
							   data[j][i] = rs.getString(columns[i]);
							   //System.out.println(" i: " + (i + 1) + " j: " + (j + 1) + " row: " + row);
							   //System.out.print(rs.getString(columns[i]) + " ");
						   }
						   j++;
						   System.out.println();
					   }
					   for(int i = 0; i < data.length; i++) {
						   System.out.println(Arrays.toString(data[i]));
					   }
					 JTable  table = new JTable(data, columns);
						table.setBounds(74, 53, 294, 198);
						
						frame.getContentPane().add(table);
						
					   
					   
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(313, 9, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
	}
	private String getQuery(String q) {
		switch(q) {
			case "Credit Score":
				return "SELECT creditScore\n" + 
						"FROM Finances\n" + 
						"WHERE applicantId = 00001;";
			case "Job Experience":
				return "SELECT jobTitle\n" + 
						"FROM Finances\n" + 
						"WHERE applicantId=00001;";
			case "Employee":
				return "SELECT CONCAT(fName, \" \", lName) AS \"Employee\", SUM(hours) AS \"Hours\"\n" + 
						"FROM Person\n" + 
						"JOIN Employee ON Person.ssn=Employee.ssn\n" + 
						"JOIN Hours ON Employee.ssn=Hours.ssn\n" + 
						"WHERE date >= (\n" + 
						"	SELECT DATE_SUB(CURDATE(), INTERVAL 2 WEEK)\n" + 
						")\n" + 
						"GROUP BY fName, lName;";
			case "Accepted Loans":
				return "SELECT *\n" + 
						"FROM Loan\n" + 
						"WHERE status=\"Accepted\";";
			case "Rejected Loans":
				return "SELECT *\n" + 
						"FROM Loan\n" + 
						"WHERE status=\"Rejected\";";
			case "Pending Loans":
				return "SELECT *\n" + 
						"FROM Loan\n" + 
						"WHERE status=\"Pending\";";
			case "Loan Time":
				return "SELECT timeTable\n" + 
						"FROM Loan\n" + 
						"WHERE applicantID=00001;";
			case "Risk Factors":
				return "SELECT Experience.applicantId, hasBeenBankrupt, involvedInLawsuit, creditScore, income, contractorLicenseNumber\n" + 
						"FROM Experience\n" + 
						"JOIN Finances ON Experience.applicantId=Finances.applicantId;";
			case "Background Info":
				return "SELECT Experience.applicantId, hasBeenBankrupt, involvedInLawsuit, creditScore, income, contractorLicenseNumber\n" + 
						"FROM Experience\n" + 
						"JOIN Finances ON Experience.applicantId=Finances.applicantId;";
			case "Preview Projects":
				return "SELECT CONCAT(street, \", \", city, \", \", state, \", \", zipCode) AS \"Address\"\n" + 
						"FROM Projects;";
			case "All Profit":
				return "SELECT * FROM Profits;";
			case "Loan Length":
				return "SELECT timetable\n" + 
						"FROM Loan\n" + 
						"WHERE status=\"Accepted\" AND applicantId=00001;";
			case "Specific Profit":
				return "SELECT *\n" + 
						"FROM Profits\n" + 
						"WHERE LoanId=0000000002;";
			case "Positive Profits":
				return "SELECT *\n" + 
						"FROM Profits\n" + 
						"WHERE netIncome>0;";
			case "All Loan Lengths":
				return "SELECT timetable\n" + 
						"FROM Loan\n" + 
						"WHERE status=\"Accepted\"\n" + 
						"GROUP BY applicantId;";
		}
		return "error";
	}
}
