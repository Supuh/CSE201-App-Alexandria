import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3, sUsername, sPassword, sHeader;
    JTextField tf1, tf2;
    JButton btn1, sButton;
    JPasswordField p1, sp1;
    private ArrayList<UserBean> Beans = new ArrayList<>();
    
    Login() {
        setTitle("Login/Signup for App Alexandria");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ///////////////////////////////////////////////////////////Login
        l1 = new JLabel("Login for App Alexandria");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Enter Username:");
        l3 = new JLabel("Enter Password:");
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Log in");

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(p1);
        add(btn1);
        btn1.addActionListener(this);
        
        ///////////////////////////////////////////////////////////Sign up
        sHeader = new JLabel("Sign up for App Alexandria");
        sHeader.setForeground(Color.blue);
        sHeader.setFont(new Font("Serif", Font.BOLD, 20));
        
        sUsername = new JLabel("Enter Username:");
        sPassword = new JLabel("Enter Password:");
        tf2 = new JTextField();
        sp1 = new JPasswordField();
        sButton = new JButton("Sign up");

        sHeader.setBounds(100, 330, 400, 30);
        sUsername.setBounds(80, 370, 200, 30);
        sPassword.setBounds(80, 410, 200, 30);
        tf2.setBounds(300, 370, 200, 30);
        sp1.setBounds(300, 410, 200, 30);
        sButton.setBounds(150, 460, 100, 30);

        add(sHeader);
        add(sUsername);
        add(tf2);
        add(sPassword);
        add(sp1);
        add(sButton);
        sButton.addActionListener(this);
        
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Log in")) {
			System.out.print(logIn(tf1.getText(),String.valueOf(p1.getPassword())));
			tf1.setText("");
			p1.setText("");
			
		} else if(e.getActionCommand().equals("Sign up")) {
			signUp(tf2.getText(),String.valueOf(sp1.getPassword()));
			tf2.setText("");
			sp1.setText("");
		}
    }

	
	private void loadUserBeans() {
		try( Scanner fin = new Scanner(new File("UserBeans.txt"))  ) {
			Beans = new ArrayList<>();
			fin.nextLine();
			while(fin.hasNextLine()) {
				UserBean x = new UserBean(fin.nextLine());
				Beans.add(x);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean logIn(String username, String password) {
		if (username.equals("") || password.equals("")) return false;
		loadUserBeans();
		for(int i = 0; i < Beans.size() ; i++) {
			// Successful Login?
			if (Beans.get(i).getUsername().equals(username) && Beans.get(i).getPassword().equals(password)) {
				dispose();
				new AppDisplay().setVisible(true);
				break;
			}
		}
		return false;
	}
	
	public boolean signUp(String username, String password) {
		if (username.equals("") || password.equals("")) return false;
		loadUserBeans();
		Beans.add(new UserBean(username, password));
		File file = new File("UserBeans.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);

		writer.println("Usernames	Passwords");
		for(int i = 0; i < Beans.size() ; i++) {
			writer.println(Beans.get(i).getUsername() + "	" + Beans.get(i).getPassword());
		}
		writer.close();
		return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

    public static void main(String arr[]) {
        new Login();
    }
}