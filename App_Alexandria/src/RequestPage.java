import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class RequestPage extends JFrame implements ActionListener{
	JTextArea appRQ;
	JScrollPane scrollPane;
	JLabel main, main2, main3;
	JButton back, verify;
	JTextField platforms, name;
	private static ArrayList<Application> Req = new ArrayList<>();
	private static ArrayList<Application> Apps = new ArrayList<>();
    RequestPage() {
    	// constructor
        setTitle("View requested apps");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // text area
        main = new JLabel("Requested Apps");
        main.setFont(new Font("Serif", Font.BOLD, 20));
        main.setBounds(200, 100, 400, 30);
        add(main);
        
		appRQ = new JTextArea(20, 50);
		appRQ.setEditable(false);
		scrollPane = new JScrollPane(appRQ);
		scrollPane.setBounds(200, 130, 400, 100);
		add(scrollPane);
		
		// Search bar label
        main2 = new JLabel("Type an app name here to verify");
        main2.setFont(new Font("Serif", Font.BOLD, 20));
        main2.setBounds(275, 300, 400, 30);
        add(main2);
		
		// platform label
        main2 = new JLabel("Type the platforms of the app with (tab) inbetween");
        main2.setFont(new Font("Serif", Font.BOLD, 20));
        main2.setBounds(200, 425, 450, 30);
        add(main2);
        
        // textboxes
        name = new JTextField();
        platforms = new JTextField();
        name.setBounds(250, 350, 300, 30);
        platforms.setBounds(250, 475, 300, 30);
        add(name);
        add(platforms);
        
        // Verify button
		verify = new JButton("Click here to Verify");
		verify.setBounds(225, 520, 350, 30);
		add(verify);
		verify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ename = name.getText();
				String eplatforms = platforms.getText();
				
				commitapp(ename, eplatforms);
				
				
				name.setText("");
				platforms.setText("");
				
			}


		});
        
        
        
        
        
        
		// back button
		back = new JButton("Click here to return to main page for App Alexandria");
		back.setBounds(225, 570, 350, 30);
		add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AppDisplay().setVisible(true);
			}
		});
		
		
		
		
		
		
		
        loadRequests();
        
        
        // approve app search bar
        
        // back button
        
        
        
        
        
    }
    
    
    
	private void loadRequests() {
		try( Scanner fin = new Scanner(new File("Requests.txt"))  ) {
			Req = new ArrayList<Application>();
			fin.nextLine();
			String apps = "";
			while(fin.hasNextLine()) {
				Application tmp = new Application(fin.nextLine());
				Req.add(tmp);
				apps += tmp.toString() + "\n";
				appRQ.setText(apps);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
  



	public static void main(String arr[]) {
        new RequestPage();
    }



	private void loadApps() {
		try( Scanner fin = new Scanner(new File("Applicationdatab.txt"))  ) {
			fin.nextLine();
			String apps = "";
			while(fin.hasNextLine()) {
				Application tmp = new Application(fin.nextLine());
				Apps.add(tmp);
				apps += tmp.toString() + "\n";
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	private void commitapp(String ename, String eplatforms) {
		loadRequests();
		loadApps();
		/////////////////////////////////// Search for it
		Application ret = null;
		for (int i = 0; i < Req.size(); i++)
		if (Req.get(i).getName().equals(ename)) ret = Req.get(i);

		/////////////////////////////////add it to apps
		String[] parts = eplatforms.split("\t");
		
		String newretts = "";
		newretts +=  ret.getName() + "	"+ ret.getDescription() + "	" + ret.getOrigin() + "	" + ret.getVersion() + "	" + ret.getStorehl() + "	" + ret.getPrice();
		for(int j = 0; j < parts.length; j++) {
			newretts += "	" + parts[j];
		}
		Application rett = new Application(newretts);
		Apps.add(rett);
				
		//////////////////////////////////////print it
		File file = new File("Applicationdatab.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);

		writer.println("Name	Description	Origin	Version	StoreHotLink	Price	Platforms");
		for(int i = 0; i < Apps.size() ; i++) {
			String tmp = "";
			tmp +=  Apps.get(i).getName() + "	"+ Apps.get(i).getDescription() + "	" + Apps.get(i).getOrigin() + "	" + Apps.get(i).getVersion() + "	" + Apps.get(i).getStorehl() + "	" + Apps.get(i).getPrice();
			ArrayList<String> pizza = Apps.get(i).getPlatforms();
			for(int j = 0; j < pizza.size(); j++) {
				tmp += "	" + pizza.get(j);
			}
			writer.println(tmp);
		}
		writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		///////////////////////////////////////erase it from requests
		for (int i = 0; i < Req.size(); i++)
		if (Req.get(i).getName().equals(ename)) Req.remove(i);
		/////////////need to print shit here
		
		File filed = new File("Requests.txt");
		PrintWriter writed;
		try {
			writed = new PrintWriter(filed);

		writed.println("Name	Description	Origin	Version	StoreHotLink	Price	Platforms");
		for(int i = 0; i < Req.size(); i++) {
			String tmp = "";
			tmp +=  Req.get(i).getName() + "	"+ Req.get(i).getDescription() + "	" + Req.get(i).getOrigin() + "	" + Req.get(i).getVersion() + "	" + Req.get(i).getStorehl() + "	" + Req.get(i).getPrice();
			writed.println(tmp);
		}
		writed.close();
		loadRequests();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}