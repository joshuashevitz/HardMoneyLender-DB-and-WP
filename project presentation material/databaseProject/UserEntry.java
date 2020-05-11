package databaseProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserEntry {

	public JFrame frame;
	private JTextField userSsnT;
	private JTextField userEmailT;
	private JTextField userFNameT;
	private JTextField userLNameT;
	private JTextField userBirthdayT;
	private JTextField userADT;
	private JTextField exitStrategyT;
	private JTextField userRST;
	private JTextField userStateT;
	private JTextField userCityT;
	private JTextField userStreetT;
	private JTextField userZipCodeT;
	private JTextField userCurrentT;
	private JTextField UserCLNT;
	private JTextField userLIPT;
	private JTextField userTPT;
	private JTextField userAssetsT;
	private JTextField userJobTitleT;
	private JTextField userCreditScoreT;
	private JTextField userIncomeT;
	private JTextField futureT;
	
	
	//jlabels
	private JLabel lblNewLabel_1; //ssn
	private JLabel lblNewLabel_2; //email
	private JLabel usernamelabel; //first name
	private JLabel lblNewLabel_4; //last name
	private JLabel lblNewLabel_5; //birthday
	private JLabel lblNewLabel_3; //aquistion date
	private JLabel lblNewLabel_8; // exit strategy
	private JLabel lblNewLabel_9; //renovation stage
	private	JLabel lblNewLabel_10; //state
	private JLabel lblNewLabel_11; //street
	private JLabel lblNewLabel_12; //zip code
	private JLabel lblNewLabel_13; //currentValue
	private JLabel lblNewLabel_15; //liability insurance
	private JLabel lblNewLabel_20; // job title
	private JLabel lblNewLabel_21; //credit score
	private JLabel lblNewLabel_22; // income
	private JLabel lblNewLabel_23; // contractNum
	private JLabel lblNewLabel_24; //city
	private JLabel lblNewLabel_14; //future value
	private JLabel lblNewLabel_17; // assets
	private JLabel lblNewLabel_16; //title provider
	
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public UserEntry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(900, 800);
		
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER INFO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(379, 6, 115, 16);
		frame.getContentPane().add(lblNewLabel);
		
		userSsnT = new JTextField();
		userSsnT.setBounds(6, 83, 130, 26);
		frame.getContentPane().add(userSsnT);
		userSsnT.setColumns(10);
		
		lblNewLabel_1 = new JLabel("SSN");
		lblNewLabel_1.setBounds(6, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		userEmailT = new JTextField();
		userEmailT.setBounds(212, 83, 130, 26);
		frame.getContentPane().add(userEmailT);
		userEmailT.setColumns(10);
		
		userFNameT = new JTextField();
		userFNameT.setBounds(396, 83, 130, 26);
		frame.getContentPane().add(userFNameT);
		userFNameT.setColumns(10);
		
		userLNameT = new JTextField();
		userLNameT.setBounds(590, 83, 130, 26);
		frame.getContentPane().add(userLNameT);
		userLNameT.setColumns(10);
		
		userBirthdayT = new JTextField();
		userBirthdayT.setBounds(764, 83, 130, 26);
		frame.getContentPane().add(userBirthdayT);
		userBirthdayT.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(212, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		usernamelabel = new JLabel("First Name");
		usernamelabel.setBounds(396, 55, 88, 16);
		frame.getContentPane().add(usernamelabel);
		
		lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setBounds(590, 55, 88, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Birthday");
		lblNewLabel_5.setBounds(764, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Application");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(396, 158, 88, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		userADT = new JTextField();
		userADT.setBounds(6, 231, 130, 26);
		frame.getContentPane().add(userADT);
		userADT.setColumns(10);
		
		exitStrategyT = new JTextField();
		exitStrategyT.setBounds(212, 231, 130, 26);
		frame.getContentPane().add(exitStrategyT);
		exitStrategyT.setColumns(10);
		
		userRST = new JTextField();
		userRST.setBounds(396, 231, 130, 26);
		frame.getContentPane().add(userRST);
		userRST.setColumns(10);
		
		userStateT = new JTextField();
		userStateT.setBounds(590, 231, 130, 26);
		frame.getContentPane().add(userStateT);
		userStateT.setColumns(10);
		
		userCityT = new JTextField();
		userCityT.setBounds(764, 231, 130, 26);
		frame.getContentPane().add(userCityT);
		userCityT.setColumns(10);
		
		userStreetT = new JTextField();
		userStreetT.setBounds(6, 297, 130, 26);
		frame.getContentPane().add(userStreetT);
		userStreetT.setColumns(10);
		
		userZipCodeT = new JTextField();
		userZipCodeT.setBounds(212, 297, 130, 26);
		frame.getContentPane().add(userZipCodeT);
		userZipCodeT.setColumns(10);
		
		userCurrentT = new JTextField();
		userCurrentT.setBounds(396, 297, 130, 26);
		frame.getContentPane().add(userCurrentT);
		userCurrentT.setColumns(10);
		
		UserCLNT = new JTextField();
		UserCLNT.setBounds(590, 297, 130, 26);
		frame.getContentPane().add(UserCLNT);
		UserCLNT.setColumns(10);
		
		userLIPT = new JTextField();
		userLIPT.setBounds(6, 386, 130, 26);
		frame.getContentPane().add(userLIPT);
		userLIPT.setColumns(10);
		
		userTPT = new JTextField();
		userTPT.setBounds(212, 386, 130, 26);
		frame.getContentPane().add(userTPT);
		userTPT.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Finances");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(396, 417, 98, 41);
		frame.getContentPane().add(lblNewLabel_7);
		
		userAssetsT = new JTextField();
		userAssetsT.setBounds(590, 591, 130, 26);
		frame.getContentPane().add(userAssetsT);
		userAssetsT.setColumns(10);
		
		JComboBox bankruptT = new JComboBox();
		bankruptT.setModel(new DefaultComboBoxModel(new String[] {"N", "Y"}));
		bankruptT.setBounds(297, 462, 88, 27);
		frame.getContentPane().add(bankruptT);
		
		JComboBox lawsuitT = new JComboBox();
		lawsuitT.setModel(new DefaultComboBoxModel(new String[] {"N", "Y"}));
		lawsuitT.setBounds(343, 511, 88, 27);
		frame.getContentPane().add(lawsuitT);
		
		userJobTitleT = new JTextField();
		userJobTitleT.setBounds(6, 591, 130, 26);
		frame.getContentPane().add(userJobTitleT);
		userJobTitleT.setColumns(10);
		
		userCreditScoreT = new JTextField();
		userCreditScoreT.setBounds(212, 591, 130, 26);
		frame.getContentPane().add(userCreditScoreT);
		userCreditScoreT.setColumns(10);
		
		userIncomeT = new JTextField();
		userIncomeT.setBounds(396, 591, 130, 26);
		frame.getContentPane().add(userIncomeT);
		userIncomeT.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Aquisition Date");
		lblNewLabel_3.setBounds(6, 203, 115, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_8 = new JLabel("Exit Strategy");
		lblNewLabel_8.setBounds(212, 203, 100, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Renovation Stage");
		lblNewLabel_9.setBounds(396, 203, 115, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("State");
		lblNewLabel_10.setBounds(590, 203, 61, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Street");
		lblNewLabel_11.setBounds(6, 269, 61, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Zip Code");
		lblNewLabel_12.setBounds(212, 269, 61, 16);
		frame.getContentPane().add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Current Value");
		lblNewLabel_13.setBounds(396, 269, 98, 16);
		frame.getContentPane().add(lblNewLabel_13);
		
		lblNewLabel_15 = new JLabel("Liability Insurance Provider");
		lblNewLabel_15.setBounds(6, 355, 183, 16);
		frame.getContentPane().add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Title Provider");
		lblNewLabel_16.setBounds(212, 355, 100, 16);
		frame.getContentPane().add(lblNewLabel_16);
		
		futureT = new JTextField();
		futureT.setBounds(396, 386, 130, 26);
		frame.getContentPane().add(futureT);
		futureT.setColumns(10);
		
		lblNewLabel_17 = new JLabel("Assests");
		lblNewLabel_17.setBounds(590, 563, 61, 16);
		frame.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Have you ever been Bankrupt?  (Y/N)");
		lblNewLabel_18.setBounds(6, 473, 279, 16);
		frame.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Have you ever been involved in a lawsuit? (Y/N)");
		lblNewLabel_19.setBounds(6, 515, 325, 16);
		frame.getContentPane().add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("Job Title");
		lblNewLabel_20.setBounds(6, 563, 115, 16);
		frame.getContentPane().add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("Credit Score");
		lblNewLabel_21.setBounds(212, 563, 100, 16);
		frame.getContentPane().add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel("Income");
		lblNewLabel_22.setBounds(396, 563, 61, 16);
		frame.getContentPane().add(lblNewLabel_22);
		
		lblNewLabel_23 = new JLabel("Contractor License Number");
		lblNewLabel_23.setBounds(590, 269, 183, 16);
		frame.getContentPane().add(lblNewLabel_23);
		
		lblNewLabel_24 = new JLabel("City");
		lblNewLabel_24.setBounds(764, 203, 61, 16);
		frame.getContentPane().add(lblNewLabel_24);
		
		JComboBox userSexC = new JComboBox();
		userSexC.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		userSexC.setBounds(84, 121, 67, 27);
		frame.getContentPane().add(userSexC);
		
		JLabel lblNewLabel_25 = new JLabel("Sex");
		lblNewLabel_25.setBounds(16, 125, 61, 16);
		frame.getContentPane().add(lblNewLabel_25);
		
		JButton userSubmitButton = new JButton("Submit");
		userSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssn = userSsnT.getText();
				String email = userEmailT.getText();
				String fName = userFNameT.getText();
				String lName = userLNameT.getText();
				String birthday = userBirthdayT.getText();
				String aquisitionDate = userADT.getText();
				String exitStrategy = exitStrategyT.getText();
				String renovation = userRST.getText();
				String state = userStateT.getText();
				String city = userCityT.getText();  
				String street = userStreetT.getText(); 
				String zipCode = userZipCodeT.getText();
				String current = userCurrentT.getText();
				String contractNum = UserCLNT.getText();
				String insuranceProvider = userLIPT.getText();
				String titleProvider = userTPT.getText();
				String assets = userAssetsT.getText();
				String jobTitle = userJobTitleT.getText();
				String creditScore = userCreditScoreT.getText();
				String income = userIncomeT.getText();
				String sex = (String) userSexC.getSelectedItem();
				String bankrupt  = (String) bankruptT.getSelectedItem();
				String lawsuit = (String) lawsuitT.getSelectedItem();
				String future = futureT.getText();
				
				
				String message = "Are you sure you want to sumbmit application?";
				int choice = JOptionPane.showConfirmDialog(null, message);
				boolean dataCorrect = userDataGood(ssn, email, fName, lName, birthday, aquisitionDate, exitStrategy, renovation, state, city, street, zipCode, current, future, contractNum, insuranceProvider, titleProvider, assets, jobTitle, creditScore, income);
				
				
				
			
				
				System.out.println(dataCorrect + " and " + choice);
				if(choice == 0 &&  dataCorrect) {
				Query q3 = new Query();
				q3.addPerson(ssn, email, fName, lName,  sex, birthday, insuranceProvider, titleProvider);
				Query q4 = new Query();
				q4.addApplication(ssn, aquisitionDate, exitStrategy, renovation, state, city, street, zipCode, current,future, contractNum, assets,  jobTitle, creditScore, income,  bankrupt, lawsuit);
				}
				else
					JOptionPane.showMessageDialog(null, "Data not entered correctly or not entered at all!");
				
				
				
				
				
			}
		});
		userSubmitButton.setBounds(379, 705, 117, 29);
		frame.getContentPane().add(userSubmitButton);
		
		
		
		lblNewLabel_14 = new JLabel("Future Value");
		lblNewLabel_14.setBounds(396, 355, 98, 16);
		frame.getContentPane().add(lblNewLabel_14);
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
		public  boolean userDataGood(String ssn, String email, String fName, String lName, String birthday, String aquistionDate, String exitStrategy, String renovation, String state, String city, String street, String zipCode, String current, String future, String contractNum, String insuranceProvider, String titleProvider, String assets, String jobTitle, String creditScore, String income)
 {		
			boolean tf = true;
			
			if(!isSsn(ssn)) {
				lblNewLabel_1.setForeground(Color.red);
				tf = false;
				
			}else
				lblNewLabel_1.setForeground(Color.black);	
			if(!isNotEmpty(city)) {
				lblNewLabel_24.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_24.setForeground(Color.black);	
			if(!isNotEmpty(future)) {
				lblNewLabel_14.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_14.setForeground(Color.black);
			if(!isNotEmpty(email)) {
				lblNewLabel_2.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_2.setForeground(Color.black);
			if(!isNotEmpty(fName)) {
				usernamelabel.setForeground(Color.red);
				tf = false;
			}else
				usernamelabel.setForeground(Color.black);
			if(!isNotEmpty(lName)) {
				lblNewLabel_4.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_4.setForeground(Color.black);
			if(!dateCheck(birthday)) {
				lblNewLabel_5.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_5.setForeground(Color.black);
			if(!dateCheck(aquistionDate)) {
				lblNewLabel_3.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_3.setForeground(Color.black);
			if(!isNotEmpty(exitStrategy)) {
				lblNewLabel_8.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_8.setForeground(Color.black);
			if(!isNotEmpty(renovation)) {
				lblNewLabel_9.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_9.setForeground(Color.black);
			if(!isNotEmpty(state)) {
				lblNewLabel_10.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_10.setForeground(Color.black);
			if(!isNotEmpty(street)) {
				lblNewLabel_11.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_11.setForeground(Color.black);
			if(!isNotEmpty(zipCode)) {
				lblNewLabel_12.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_12.setForeground(Color.black);
			if(!isNotEmpty(current)) {
				lblNewLabel_13.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_13.setForeground(Color.black);
			if(!isNotEmpty(contractNum)) {
				lblNewLabel_23.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_23.setForeground(Color.black);
			if(!isNotEmpty(insuranceProvider)) {
				lblNewLabel_15.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_15.setForeground(Color.black);
			if(!isNotEmpty(titleProvider)) {
				lblNewLabel_16.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_16.setForeground(Color.black);
			if(!isNotEmpty(assets)) {
				lblNewLabel_17.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_17.setForeground(Color.black);
			if(!isNotEmpty(jobTitle)) {
				lblNewLabel_20.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_20.setForeground(Color.black);
			if(!isNotEmpty(creditScore)) {
				lblNewLabel_21.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_21.setForeground(Color.black);
			if(!isNotEmpty(income)) {
				lblNewLabel_22.setForeground(Color.red);
				tf = false;
			}else
				lblNewLabel_22.setForeground(Color.black);
			
				
			
				
			
				
			
				
			
			return tf;
		}
		public static boolean isHour(String hour) {
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
