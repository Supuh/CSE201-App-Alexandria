import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FAQ extends JFrame {

	//==================================================================== Properties
	JScrollPane scrollPane;
	JPanel jpMain, jpFaq;
	JTextArea faqTA;
	JButton loginButton;
	
	//==================================================================== Constructor
	public FAQ() {
		super();
		this.setSize(800, 800);
		this.setTitle("App Alexandria FAQ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponent();
		loadFAQ();
		
	}
	
	//==================================================================== JPanel Builder
	private void addComponent() {
		// Return to Login button
		loginButton = new JButton("Click here to return to Login");
		loginButton.setBounds(250, 570, 300, 30);
		add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		
		// Initialize JPanel
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
		
		// FAQ
		jpFaq = new JPanel();
		jpFaq.setBorder(new TitledBorder("FAQ"));

		// FAQ Text Area
		faqTA = new JTextArea(20, 50);
		faqTA.setEditable(false);
		scrollPane = new JScrollPane(faqTA);
		jpFaq.add(scrollPane);
		
		// Compile Main JPanel
		jpMain.add(jpFaq, BorderLayout.NORTH);
		
		// Add JPanel
		this.add(jpMain);
	}
	
	//==================================================================== Main
	private void loadFAQ() {
		try( Scanner fin = new Scanner(new File("FAQ.txt"))  ) {
			String faq = "";
			while(fin.hasNextLine()) {
				faq += fin.nextLine() + "\n";
				faqTA.setText(faq);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//==================================================================== Main
	public static void main(String[] args) {
		FAQ f = new FAQ();
        f.setVisible(true);
	}

}
