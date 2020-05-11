package databaseProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;



import com.mysql.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Query {
	
	private String ID;
	private String PW;
	private String SERVER;
	private String data[][];
	private String columns[];
	private int cn;
	private int row;
	
	
	private ResultSet rs;
	private Statement stmt;
	private ResultSetMetaData rsmd;
	
	
	public Query(){
		this.ID = "mmoore54";
		this.PW = "Cosc*66m6";
		this.SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/"+ID+"db";
		setStatement();
	}
	public String[][] getData() {
		return data;
	}
	public String[] getColumns() {
		return columns;
	}
	
	public boolean checkLogin(String username, String password) {
		String employeeLoginStatement = "select username, password from Employee;";
		helperRunQuery(employeeLoginStatement);
		return loginMatch(username, password);
		//System.out.println(isLogin);
	}
	private boolean loginMatch(String username, String password) {
		for(int i = 0; i < data.length; i++) {
			System.out.println(username + " = " + data[i][0]);
			if(data[i][0].equals(username)) {
				//System.out.println("\t " + password + " = " + data[i][1]);
				if(data[i][1].equals(password)) {
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}
	private void setStatement() {
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
		try{
            Connection con = DriverManager.getConnection(SERVER, ID, PW);
            stmt = con.createStatement();
         
           
          
           stmt.executeQuery("use mmoore54db");
			
       
        
        }catch(SQLException e){
            System.err.println(e);
        }
	}
	public void runQuery(String query) {
		helperRunQuery(getQuery(query));
	}
	private void helperRunQuery(String excuteStatement) {
		try {
			 rs = stmt.executeQuery(excuteStatement);
			  rsmd = (ResultSetMetaData) rs.getMetaData();
			   //System.out.println(excuteStatement);
			   cn = rsmd.getColumnCount();
			   columns = new String[cn];
			   
			  
			   //get columns
			   for(int i = 1; i <= cn; i++) {
				   columns[i - 1] = rsmd.getColumnName(i);
				  
			   }
			   //getting row number
			   row = 0;
			   while(rs.next()) {
				   for(int i = 0; i < columns.length; i++) {
					   //System.out.print(rs.getString(columns[i]) + " ");
					   
				   }
				   row++;
				   System.out.println();
			   }
			  rs = stmt.executeQuery(excuteStatement);
			 //getting data
			  //i and j are in the wrong spots in case anyone comes across this and have an ocd attack
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
			   
			 
			  
			 
				
			   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	public void runDelete(String rowData[],String  table) {
		helperRunDelete(rowData, table);
	}
	
	private void helperRunDelete(String rowData[],String table) {
		
		
		String deleteStatement = getDeleteSQLStatement(rowData, table);
		
		
		try {

		stmt.executeUpdate(deleteStatement);
			
		}catch(SQLException e){
            System.err.println(e);
        }
        
	}
	
	private String getDeleteSQLStatement(String rowData[], String table) {
		
		
		
		
		
		switch(table) {
		case "Applicant":
			
			
			return "DELETE\n"
					+ "FROM Applicant\n"
					+ "WHERE ssn = " + rowData[0] +";";
		case "Degree":
			
			
			return "DELETE\n"
					+ "FROM Degree\n"
					+ "WHERE ssn = " + rowData[0] + " AND study = \'"  + rowData[1] + "\';";
		case "Employee":
			
			
			return "DELETE\n"
					+ "FROM Employee\n"
					+ "WHERE ssn = " + rowData[0] +";";
		case "Experience":
			
			
			return "DELETE\n"
					+ "FROM Experience\n"
					+ "WHERE applicantId = " + rowData[0] +";";
		case "Finances":
			
			
			return "DELETE\n"
					+ "FROM Finances\n"
					+ "WHERE applicantId = " + rowData[0] +";";
		case "Hours":
			
			
			return "DELETE\n"
					+ "FROM Hours\n"
					+ "WHERE ssn = " + rowData[0]+ " AND date = \'"  + rowData[1] + "\';";
		case "Loan":
			
			
			return "DELETE\n"
					+ "FROM Loan\n"
					+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
		case "Person":
			
			
			return "DELETE\n"
					+ "FROM Person\n"
					+ "WHERE ssn = " + rowData[0] +";";
		case "Phone":
			
			
			return "DELETE\n"
					+ "FROM Phone\n"
					+ "WHERE ssn = " + rowData[0]+ " AND number = "  + rowData[1] + ";";
		case "Profits":
			
			
			return "DELETE\n"
					+ "FROM Profits\n"
					+ "WHERE loanId = " + rowData[0] +";";
		case "Projects":
			
			
			return "DELETE\n"
					+ "FROM Projects\n"
					+ "WHERE applicantId = " + rowData[0] +";";
		case "Property":
			
			
			return "DELETE\n"
					+ "FROM Property\n"
					+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
		case "View":
			
			
			return "DELETE\n"
					+ "FROM View\n"
					+ "WHERE employeeSsn = " + rowData[0]+ " AND applicantId = "  + rowData[1] + ";";
		}
		return "error";
	}
	
	public void update(String rowData[], String table, int column, String change) {
		helpUpdate(rowData, table, column, change);
	}
	private void helpUpdate(String rowData[], String table, int column, String change) {
		
		String updateStatement = getUpdateStatement(rowData, table, column, change);
		System.out.println(updateStatement);
		
		try {

		stmt.executeUpdate(updateStatement);
			
		}catch(SQLException e){
            System.err.println(e);
        }
        
	}
	private String getUpdateStatement(String rowData[], String table,int  column, String change) {
		String up = "";
		switch(table) {
		case "Applicant":
			if(column == 0) {
				up = "UPDATE Applicant\n"
						+ "SET ssn =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 1) {
				up = "UPDATE Applicant\n"
						+ "SET liabilityInsuranceProvider =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 2) {
				up = "UPDATE Applicant\n"
						+ "SET titleProvider =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 3) {
				up = "UPDATE Applicant\n"
						+ "SET applicantId =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0] +";";
			}
			
			return up;
		case "Degree":
			if(column == 0) {
				up = "UPDATE Degree\n"
						+ "SET ssn =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0] + " AND study = \'"  + rowData[1] + "\';";
				
			}else if(column == 1) {
				up = "UPDATE Degree\n"
						+ "SET study =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] + " AND study = \'"  + rowData[1] + "\';";
				
			}else if(column == 2) {
				up = "UPDATE Degree\n"
						+ "SET level =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] + " AND study = \'"  + rowData[1] + "\';";
			}
			
			return up;
		case "Employee":
			if(column == 0) {
				up = "UPDATE Employee\n"
						+ "SET ssn =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 1) {
				up = "UPDATE Employee\n"
						+ "SET position =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 2) {
				up = "UPDATE Employee\n"
						+ "SET username =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 3) {
				up = "UPDATE Employee\n"
						+ "SET password =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
			}
			
			return up;
			
		case "Experience":
			if(column == 0) {
				up = "UPDATE Experience\n"
						+ "SET applicantId =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 1) {
				up = "UPDATE Experience\n"
						+ "SET contractorLicenseNumber = " + change + "\n"
						+ "WHERE applicantId = " + rowData[0] +";";
			}
			
			return up;
		case "Finances":
			if(column == 0) {
				up = "UPDATE Finances\n"
						+ "SET applicantId =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 1) {
				up = "UPDATE Finances\n"
						+ "SET jobTitle =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 3) {
				up = "UPDATE Finances\n"
						+ "SET hasBeenBankrupt =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 4) {
				up = "UPDATE Finances\n"
						+ "SET involvedInLawsuit =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0] +";";
			}else if(column == 5) {
				up = "UPDATE Finances\n"
						+ "SET creditScore =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 6) {
				up = "UPDATE Finances\n"
						+ "SET income =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 7) {
				up = "UPDATE Finances\n"
						+ "SET assets =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}
			
			return up;
			
		case "Hours":
			if(column == 0) {
				up = "UPDATE Hours\n"
						+ "SET ssn =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0]+ " AND date = \'"  + rowData[1] + "\';";
				
			}else if(column == 1) {
				up = "UPDATE Hours\n"
						+ "SET  date = \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0]+ " AND date = \'"  + rowData[1] + "\';";
			}else if(column == 2) {
				up = "UPDATE Hours\n"
						+ "SET hours = " + change + "\n"
						+ "WHERE ssn = " + rowData[0]+ " AND date = \'"  + rowData[1] + "\';";
			}
			
			return up;
		case "Loan":
			if(column == 0) {
				up = "UPDATE Loan\n"
						+ "SET loanId =  " + change + "\n"
						+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
				
			}else if(column == 1) {
				up = "UPDATE Loan\n"
						+ "SET applicantId =  " + change + "\n"
						+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
				
			}else if(column == 2) {
				up = "UPDATE Loan\n"
						+ "SET reviewerSsn =  " + change + "\n"
						+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
				
			}else if(column == 3) {
				up = "UPDATE Loan\n"
						+ "SET percentForConstruction =  " + change + "\n"
						+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
			}else if(column == 4) {
				up = "UPDATE Loan\n"
						+ "SET percentForPurchase =  " + change + "\n"
						+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
				
			}else if(column == 5) {
				up = "UPDATE Loan\n"
						+ "SET purchasePrice =  " + change + "\n"
						+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
				
			}else if(column == 8) {
				up = "UPDATE Loan\n"
						+ "SET status =  " + change + "\n"
						+ "WHERE loanId = " + rowData[0]+ " AND applicantId = "  +rowData[1] + ";";
				
			}
			
			return up;
			
			
		case "Person":
			if(column == 0) {
				up = "UPDATE Person\n"
						+ "SET ssn =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 2) {
				up = "UPDATE Person\n"
						+ "SET email =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 3) {
				up = "UPDATE Person\n"
						+ "SET fName =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 4) {
				up = "UPDATE Person\n"
						+ "SET lName =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
			}else if(column == 5) {
				up = "UPDATE Person\n"
						+ "SET sex =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 6) {
				up = "UPDATE Person\n"
						+ "SET dateOfBirth =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}
			
			return up;
		case "Phone":
			if(column == 0) {
				up = "UPDATE Phone\n"
						+ "SET ssn =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0]+ " AND number = "  + rowData[1] + ";";
				
			}else if(column == 1) {
				up = "UPDATE Phone\n"
						+ "SET number =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0]+ " AND number = "  + rowData[1] + ";";
				
			}else if(column == 2) {
				up = "UPDATE Phone\n"
						+ "SET type =  \'" + change + "\'\n"
						+ "WHERE ssn = " + rowData[0]+ " AND number = "  + rowData[1] + ";";
				
			}
			return up;
			
		case "Profits":
			if(column == 0) {
				up = "UPDATE Profits\n"
						+ "SET loanId =  " + change + "\n"
						+ "WHERE ssn = " + rowData[0] +";";
				
			}else if(column == 1) {
				up = "UPDATE Profits\n"
						+ "SET loanAmount =  \'" + change + "\'\n"
						+ "WHERE loanId = " + rowData[0] +";";
				
			}else if(column == 2) {
				up = "UPDATE Profits\n"
						+ "SET grossIncome =  \'" + change + "\'\n"
						+ "WHERE loanId = " + rowData[0] +";";
				
			}else if(column == 3) {
				up = "UPDATE Profits\n"
						+ "SET netIncome =  \'" + change + "\'\n"
						+ "WHERE loanId = " + rowData[0] +";";
			}
			
			return up;
		case "Projects":
			if(column == 0) {
				up = "UPDATE Projects\n"
						+ "SET applicantId =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 1) {
				up = "UPDATE Projects\n"
						+ "SET status =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 2) {
				up = "UPDATE Projects\n"
						+ "SET state =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 3) {
				up = "UPDATE Projects\n"
						+ "SET city =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0] +";";
			}else if(column == 4) {
				up = "UPDATE Projects\n"
						+ "SET street =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0] +";";
				
			}else if(column == 5) {
				up = "UPDATE Projects\n"
						+ "SET zipCode =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0] +";";	
			}
			
			return up;
		case "Property":
			if(column == 0) {
				up = "UPDATE Property\n"
						+ "SET applicantId =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
				
			}else if(column == 1) {
				up = "UPDATE Property\n"
						+ "SET aquisitionDate =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
				
			}else if(column == 2) {
				up = "UPDATE Property\n"
						+ "SET exitStrategy =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
				
			}else if(column == 3) {
				up = "UPDATE Property\n"
						+ "SET renovationStage =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
			}else if(column == 4) {
				up = "UPDATE Property\n"
						+ "SET state =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
				
			}else if(column == 5) {
				up = "UPDATE Property\n"
						+ "SET city =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";	
			}else if(column == 6) {
				up = "UPDATE Property\n"
						+ "SET street =  \'" + change + "\'\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
				
			}else if(column == 7) {
				up = "UPDATE Property\n"
						+ "SET zipCode =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
				
			}else if(column == 8) {
				up = "UPDATE Property\n"
						+ "SET currentValue =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
			}else if(column == 9) {
				up = "UPDATE Property\n"
						+ "SET futureValue =  " + change + "\n"
						+ "WHERE applicantId = " + rowData[0]+ " AND aquisitionDate = \'"  + rowData[1] + "\';";
				
			}
			
			return up;
		case "View":
			if(column == 0) {
				up = "UPDATE View\n"
						+ "SET employeeSsn =  " + change + "\n"
						+ "WHERE employeeSsn = " + rowData[0]+ " AND applicantId = "  + rowData[1] + ";";
			}else if(column == 1) {
				up = "UPDATE View\n"
						+ "SET applicantId =  " + change + "\n"
						+ "WHERE employeeSsn = " + rowData[0]+ " AND applicantId = "  + rowData[1] + ";";	
			}
			return up;
		}
		return "error";
	}
	public void addEmp(String firstName, String lastName, String sex, String email, String phoneNumber, String position, String birthday, String username, String password, String ssn, String phoneType) {

		String person = "INSERT INTO Person (ssn, email, fName, lName, sex, dateOfBirth) VALUES ('" + ssn  + "',  '" + email  + "',  '" + firstName  + "',  '"+ lastName  + "',  '"+ sex  + "',  '"+ birthday  + "');"; 
		String employee = "INSERT INTO Employee (ssn, position, username, password) VALUES ('" + ssn + "', '"+ position + "', '"+ username + "', '"+ password + "');";
		String phone = "INSERT INTO Phone (ssn, number, type) VALUES ('" + ssn + "', '"+ phoneNumber + "', '"+ phoneType + "');";
		System.out.println("person = " + person);
		try {
			 stmt.executeUpdate(person);
			 stmt.executeUpdate(employee);
			 stmt.executeUpdate(phone);
			 
			  
			 
				
			   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String getApplicantId(String ssn) {
		String query = "SELECT applicantId FROM Applicant WHERE ssn = " + ssn + ";";
		try {
			rs = stmt.executeQuery(query);
			rs.next();
			return rs.getString(1);
			
			 
			  
			 
				
			   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}
	public void addPerson(String ssn, String email, String fName, String lName,  String sex, String birthday, String insuranceProvider, String titleProvider) {
		try {
			String person = "INSERT INTO Person (ssn, email, fName, lName, sex, dateOfBirth) VALUES ('" + ssn  + "',  '" + email  + "',  '" + fName  + "',  '"+ lName  + "',  '"+ sex  + "',  '"+ birthday  + "');";   
			stmt.executeUpdate(person);
			String applicant = "INSERT INTO Applicant (ssn, liabilityInsuranceProvider, titleProvider) VALUES ('" + ssn + "', '"+ insuranceProvider + "', '"+ titleProvider + "');";
			stmt.executeUpdate(applicant);
			 
			  
			 
				
			   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
		}
	}
	public void addApplication(String ssn,  String aquistionDate, String exitStrategy, String renovation, String state, String city, String street, String zipCode, String current, String future, String contractNum, String assets, String jobTitle, String creditScore, String income, String bankrupt, String lawsuit) {

		
		
		try {
			
			String applicantId = getApplicantId(ssn);
			System.out.println("applicant id = " + applicantId);
			System.out.println("ssn = " + ssn);
			
			
			String property = "INSERT INTO Property (applicantId, aquisitionDate, exitStrategy, renovationStage, state, city, street, zipCode, currentValue, futureValue) VALUES ('" + applicantId + "', '"+aquistionDate + "', '"+ exitStrategy +   "', '"+ renovation+ "', '"+ state+ "', '"+ city + "', '"+ street + "', '"+ zipCode + "', '"+ current+ "', '"+ future + "');";
			stmt.executeUpdate(property);
			
			String experience = "INSERT INTO Experience (applicantId, contractorLicenseNumber) VALUES ('" + applicantId + "', '"+ contractNum + "');";
			stmt.executeUpdate(experience);
			
			String finances = "INSERT INTO Finances (applicantId, jobTitle, hasBeenBankrupt, involvedInLawsuit, creditScore, income, assets) VALUES ('" + applicantId  + "',  '" + jobTitle  + "',  '" + bankrupt  + "',  '"+ lawsuit  + "',  '"+ creditScore  + "',  '"+ income+ "',  '"+ assets +"');";
			stmt.executeUpdate(finances);
			 
			 
			  
			 
			applicantId = getApplicantId(ssn);
			System.out.println("after applicantId = " + applicantId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	public void addHours(String ssn, String hours, String date) {
		String hour = "INSERT INTO Hours (ssn, date, hours) VALUES ('" + ssn  + "',  '" + date  + "',  '" + hours  + "');";    
		
		System.out.println("hours = " + hour);
		try {
			 stmt.executeUpdate(hour);
			
			  
			 
				
			   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private String getQuery(String q) {
		switch(q) {
			case "Credit Score":
				return "SELECT creditscore \n" + 
						"FROM Finances\n" + 
						"WHERE applicantId = 00001;";
			case "Job Experience":
				return "SELECT jobTitle\n" + 
						"FROM Finances\n" + 
						"WHERE applicantId=00001;";
			case "Employee Hours":
				return "\n" + 
						"SELECT CONCAT(fName, \" \", lName) AS \"Employee\", SUM(hours) AS \"Hours\"\n" + 
						"FROM Person\n" + 
						"JOIN Employee ON Person.ssn=Employee.ssn\n" + 
						"JOIN Hours ON Employee.ssn=Hours.ssn\n" + 
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
			case "Applicant":
				return "SELECT *\n"
						+ "FROM Applicant;";
			case "Degree":
				return "SELECT *\n"
						+ "FROM Degree;";
			case "Employee":
				return "SELECT *\n"
						+ "FROM Employee;";
			case "Experience":
				return "SELECT *\n"
						+ "FROM Experience;";
			case "Finances":
				return "SELECT *\n"
						+ "FROM Finances;";
			case "Hours":
				return "SELECT *\n"
						+ "FROM Hours;";
			case "Loan":
				return "SELECT *\n"
						+ "FROM Loan;";
			case "Person":
				return "SELECT *\n"
						+ "FROM Person;";
			case "Phone":
				return "SELECT *\n"
						+ "FROM Phone;";
			case "Profits":
				return "SELECT *\n"
						+ "FROM Profits;";
			case "Projects":
				return "SELECT *\n"
						+ "FROM Projects;";
			case "Property":
				return "SELECT *\n"
						+ "FROM Property;";
			case "View":
				return "SELECT *\n"
						+ "FROM View;";
		}
		return "error";
	}
}
