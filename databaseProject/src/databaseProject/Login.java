package databaseProject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
	private JLabel usernameL, passwordL;
	private JTextField usernameT, passwordT;
	private JButton submit;
	private String[] userPass;
	private boolean hasHitButton;
	private submitButtonHandler submitHandler;
		public Login() {
			setTitle("Employee Login");
			userPass = new String[2];
			hasHitButton = true;
			//labels
			usernameL = new JLabel("Username: ", SwingConstants.CENTER);
			passwordL = new JLabel("Password: ", SwingConstants.CENTER);
			
			
			//textFields
			usernameT = new JTextField(10);
			passwordT = new JTextField(10);
			
			
			//button
			submit = new JButton("Login");
			submitHandler = new submitButtonHandler();
			submit.addActionListener(submitHandler);
			
			
			
			
			
			//container
			Container pane = getContentPane();
			pane.setLayout(new GridLayout(3,2));
			pane.add(usernameL);
			pane.add(usernameT);
			pane.add(passwordL);
			pane.add(passwordT);
			pane.add(submit);
			
			
			//frame
			setSize(300, 150);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
		
		//button handler
		private class submitButtonHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				userPass[0] = usernameT.getText();
				userPass[1] = passwordT.getText();
				hasHitButton = false;
				
			}
			
		}
		public boolean getHasHitButton() {
			return hasHitButton;
		}
		public String[] getUserPass() {
			boolean flag = getHasHitButton();
		
			while(flag) {
				flag = getHasHitButton();
				System.out.print("");
			}
			return userPass;
			
		
		}
		
		
		public static void main(String[] args) {
			Login l = new Login();
			String test[] = l.getUserPass();
			l.dispose();
			
		}
		
}
