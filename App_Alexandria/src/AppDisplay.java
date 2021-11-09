import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AppDisplay extends JFrame{

	//==================================================================== Properties
	JLabel appLabel;
	JScrollPane scrollPane;
	JPanel jpMain, jpApp;
	JTextArea appTA;
	JButton sortButton;
	JButton filterButton;
	JTextField searchBar;
	JButton searchBarS, submissionp;
	
	private JComboBox<String> platformBox;
	
	private static ArrayList<Application> Apps = new ArrayList<>();
	private static ArrayList<String> platforms=new ArrayList<>();
	
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
		searchBar.setBounds(300, 470, 200, 30);
		add(searchBar);
		
		
		searchBarS = new JButton("Search");
		searchBarS.setBounds(550, 470, 75, 30);
		add(searchBarS);
		searchBarS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(searchBars(searchBar.getText()));
				searchBar.setText("");
			}
		});
		
		
		// submission page button
		submissionp = new JButton("Click here to submit an app to App Alexandria");
		submissionp.setBounds(250, 570, 300, 30);
		add(submissionp);
		submissionp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SubmissionPage().setVisible(true);
			}
		});
		

		platformBox=new JComboBox<>();
		platformBox.setBounds(300,370,200,30);
		add(platformBox);
		
		
		sortButton = new JButton("Sort");
		sortButton.setBounds(550, 370, 75, 30);
		add(sortButton);
		sortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String platform=platforms.get(platformBox.getSelectedIndex());
				ArrayList<Application> selected=new ArrayList<>();
				ArrayList<Application> unselected=new ArrayList<>();
				sortByPlatform(platform,selected,unselected);
				String result="";
				for(Application app:selected){
					result+=app.toString();
					result+="\n";
				}
				for(Application app:unselected){
					result+=app.toString();
					result+="\n";
				}
				appTA.setText(result);
			}
		});

		filterButton=new JButton("Filter");
		filterButton.setBounds(650,370,75,30);
		add(filterButton);
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String platform=platforms.get(platformBox.getSelectedIndex());
				ArrayList<Application> selected=new ArrayList<>();
				ArrayList<Application> unselected=new ArrayList<>();
				sortByPlatform(platform,selected,unselected);
				String result="";
				for(Application app:selected){
					result+=app.toString();
					result+="\n";
				}
				appTA.setText(result);
				

			}
		});
		
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
				for(String platform:tmp.getPlatforms()){
					if(!platforms.contains(platform)){
						platforms.add(platform);
						platformBox.addItem(platform);
					}
				}
				Apps.add(tmp);
				apps += tmp.toString() + "\n";
				appTA.setText(apps);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void sortByPlatform(String platform,ArrayList<Application> selectedApplication,ArrayList<Application> unselectedApplication){
		for(Application app:Apps){
			boolean selected=false;
			for(String plat: app.getPlatforms()){
				if(plat.equals(platform)){
					selectedApplication.add(app);
					selected=true;
					break;
				}
			}
			if(!selected){
				unselectedApplication.add(app);
			}
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
