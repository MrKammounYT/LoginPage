package Pages;

import javax.swing.*;

import Events.ForgetPasswordClickEvent;
import Events.LoginButtonClickEvent;
import utils.JComponentsPlus.ClickableText;
import utils.JComponentsPlus.CustomInputField;
import utils.JComponentsPlus.CustomPasswordInputField;
import utils.JComponentsPlus.RoundButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {
	
	final ImageIcon FrameIcon = new ImageIcon(getClass().getResource("/Images/lockImg.png"));
	final ImageIcon BackGroundIMG = new ImageIcon(getClass().getResource("/Images/bg.png"));
	final ImageIcon userImg = new ImageIcon(getClass().getResource("/Images/user.png"));
	final ImageIcon lockImg = new ImageIcon(getClass().getResource("/Images/lockImg.png"));
	
	
	 public LoginPage() {
		 	setIconImage(FrameIcon.getImage());
	        setTitle("Login Page");
	        setSize(1000, 600); 
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the frame is closed
	        setResizable(false);
	        // Create a panel to hold the components
	        JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(BackGroundIMG.getImage(), 0, 0, getWidth(), getHeight(), this);
	            }
	        };
	        panel.setLayout(null); // Use null layout for absolute positioning
	        // Create and add the components to the panel
	        JLabel welcomeLabel = new JLabel("WELCOME");
	        welcomeLabel.setBounds(700, 100, 200, 30); 
	        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font
	        panel.add(welcomeLabel);

	        CustomInputField userText = new CustomInputField("UserName",userImg);
	        userText.setBounds(600, 150, 300, 30); 
	        panel.add(userText);


	        CustomPasswordInputField passwordText = new CustomPasswordInputField("*******************",lockImg);
	        passwordText.setBounds(600, 250, 300, 30); 
	        panel.add(passwordText);

			 JLabel outputLabel = new JLabel();
			 outputLabel.setBounds(650,280,200,50);

	        RoundButton loginButton = new RoundButton("Login");
	        loginButton.setBounds(650, 300, 200, 30);
			loginButton.addMouseListener(new MouseAdapter() {
				 @Override
				 public void mouseClicked(MouseEvent e) {
					 new LoginButtonClickEvent(userText.getName(), new String(passwordText.getPassword()),panel);
				 }
			});
	        panel.add(loginButton);

	        JLabel forgetPasswordLabel = new ClickableText("Forget password",Color.black,Color.red);
	        forgetPasswordLabel.setBounds(700, 330, 150, 30);
			forgetPasswordLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new ForgetPasswordClickEvent();//password Reset Logic Here
				}
			});
	        panel.add(forgetPasswordLabel);


	        
	        
	        add(panel);
	        setLocationRelativeTo(null);
	    }

    
}
