package databaseProject;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Hashtable;

public class start {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Object[] options = {"Applicant", "Employee"};
		int n = JOptionPane.showOptionDialog(f,
				"Start Menu",
				"Select type of user:",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     
				options,  
				options[0]);

		if(n == 0) {
	
			
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UserEntry window = new UserEntry();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}else if(n == 1) {
			Login login = new Login();
			String[] userPass = login.getUserPass();
			login.dispose();
		String userName = 	userPass[0];
		String password = userPass[1];
		
			System.out.println(userName);
			System.out.println(password);
		
		//password verfication
		
		Query q = new Query();
		
		boolean isEmp = q.checkLogin(userName, password);
		System.out.println(isEmp);
		if(isEmp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBase window = new DataBase();
					window.frmDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "username or password is incorrect\n have a nice day");
		}
		
		
		
		
		}
		
	}
	
	

}
