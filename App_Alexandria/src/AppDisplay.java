import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AppDisplay extends JFrame implements ActionListener {

	//==================================================================== Properties
	JLabel appLabel;
	JScrollPane scrollPane;
	JPanel jpMain, jpApp;
	JTextArea appTA;
	JTextField searchBar;
	JButton searchBarS;
	//static JList appList = new JList(buttonList);
	
	private static ArrayList<Application> Apps = new ArrayList<>();
	
	//==================================================================== Constructor
	public AppDisplay() {
		super();
		this.setSize(800, 800);
		this.setTitle("App Alexandria");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponent();
		loadApps();
		
	}
	
	//==================================================================== JPanel Builder
	
	private void addComponent() {
		//Search bar
		searchBar = new JTextField("Search Bar");
		searchBar.setBounds(300, 370, 200, 30);
		add(searchBar);
		
		
		searchBarS = new JButton("Search");
		searchBarS.setBounds(550, 370, 75, 30);
		add(searchBarS);
		searchBarS.addActionListener((ActionListener) this);
		
		// Initialize JPanel
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
		
		// Applications
		jpApp = new JPanel();
		jpApp.setBorder(new TitledBorder("Applications"));
		
		// Application Text Area
		appTA = new JTextArea(20, 50);
		appTA.setEditable(false);
		scrollPane = new JScrollPane(appTA);
		jpApp.add(scrollPane);
		
		// Compile Main JPanel
		jpMain.add(jpApp, BorderLayout.NORTH);
		
		// Add JPanel
		this.add(jpMain);
		
	}
	
	//==================================================================== Methods
	
	private void loadApps() {
		try( Scanner fin = new Scanner(new File("Applicationdatab.txt"))  ) {
			fin.nextLine();
			String apps = "";
			while(fin.hasNextLine()) {
				Application tmp = new Application(fin.nextLine());
				Apps.add(tmp);
				apps += tmp.toString() + "\n";
//				JLabel tmpLabel = new JLabel(tmp.toString());
//				appLabel.add(tmpLabel);
				appTA.setText(apps);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Search")) {
			System.out.print(searchBars(searchBar.getText()));
			searchBar.setText("");
			
		} 
    }
	
	public Application searchBars(String key) {
		Application ret = null;
		loadApps();
		
		for (int i = 0; i < Apps.size(); i++)
		if (Apps.get(i).getName().equals(key)) ret = Apps.get(i);
//		System.out.println(Apps.get(i) + "  ");	
		//System.out.print(ret);
		return ret;
	}
	
	//==================================================================== Main
	public static void main(String[] args) {
		AppDisplay ap = new AppDisplay();
        ap.setVisible(true);
		//new AppDisplay();
	}
	
}