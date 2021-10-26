import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class AppDisplay extends JFrame {

	//==================================================================== Properties
	JLabel appLabel;
	JScrollPane scrollPane;
	JPanel jpMain, jpApp;
	JTextArea appTA;
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
	
	//==================================================================== Main
	public static void main(String[] args) {
		AppDisplay ap = new AppDisplay();
        ap.setVisible(true);
		//new AppDisplay();
	}
	
}