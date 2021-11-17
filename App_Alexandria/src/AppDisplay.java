import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AppDisplay extends JFrame{

	//==================================================================== Properties
	JLabel appLabel;
	JScrollPane scrollPane;
	JPanel jpMain, jpApp;
	JTextArea appTA;
	JButton sortButton;
	JButton filterButton;
	JTextField searchBar;
    JTable myTable;
    DefaultTableModel tbModel;
	JButton searchBarS, submissionp, adminb;
	AppDisplay home = this;
	
	private JComboBox<String> platformBox;
	
	private static ArrayList<Application> Apps = new ArrayList<>();
	private static final ArrayList<Application> disPlayApps = new ArrayList<>();
	private static ArrayList<String> platforms=new ArrayList<>();
	
	//==================================================================== Constructor
	public AppDisplay() {
		super();
		this.setSize(800, 800);
		this.setTitle("App Alexandria");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		clearArrays();
		addComponent();
		//loadApps();
		
	}
	
	//==================================================================== JPanel Builder
	
	private void addComponent() {

		if(Login.getAdmin()) {
		// get to admin page
		adminb = new JButton("Click here to view app requests [ADMIN]");
		adminb.setBounds(225, 720, 350, 30);
		add(adminb);
		adminb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearArrays();
				dispose();
				new RequestPage().setVisible(true);
			}
		});
		}
		
		// Search bar
		searchBar = new JTextField("Search Bar");
		searchBar.setBounds(300, 570, 200, 30);
		add(searchBar);
		
		
		searchBarS = new JButton("Search");
		searchBarS.setBounds(550, 570, 75, 30);
		add(searchBarS);
		searchBarS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.print(searchBars(searchBar.getText()));
				//appTA.setText(searchBarStrings(searchBar.getText()));
				//searchBar.setText("");
				
				String query = searchBar.getText();
				ArrayList<Application> selected = new ArrayList<>();
				searchBarStrings(query, selected);
				//String result = "";
				disPlayApps.clear();
				for(Application app : selected){
					//result += app.toString();
					//result += "\n";
					disPlayApps.add(app);
				}
				//appTA.setText(result);
				refreshTable();
			}
		});
		
		
		// Submission page button
		submissionp = new JButton("Click here to submit an app to App Alexandria");
		submissionp.setBounds(250, 670, 300, 30);
		add(submissionp);
		submissionp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearArrays();
				dispose();
				new SubmissionPage().setVisible(true);
			}
		});
		
		// Sort/Filter combo box
		platformBox=new JComboBox<>();
		platformBox.setBounds(300,470,200,30);
		add(platformBox);
		
		// Sort button
		sortButton = new JButton("Sort");
		sortButton.setBounds(550, 470, 75, 30);
		add(sortButton);
		sortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String platform=platforms.get(platformBox.getSelectedIndex());
				ArrayList<Application> selected=new ArrayList<>();
				ArrayList<Application> unselected=new ArrayList<>();
				sortByPlatform(platform,selected,unselected);
				//String result="";
				disPlayApps.clear();
				for(Application app:selected){
					//result+=app.toString();
					//result+="\n";
					disPlayApps.add(app);
				}
				for(Application app:unselected){
					//result+=app.toString();
					//result+="\n";
					disPlayApps.add(app);
				}
				//appTA.setText(result);
				refreshTable();
			}
		});

		// Filter button
		filterButton=new JButton("Filter");
		filterButton.setBounds(650,470,75,30);
		add(filterButton);
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String platform=platforms.get(platformBox.getSelectedIndex());
				ArrayList<Application> selected=new ArrayList<>();
				ArrayList<Application> unselected=new ArrayList<>();
				sortByPlatform(platform,selected,unselected);
				//String result="";
				disPlayApps.clear();
				for(Application app:selected){
					//result+=app.toString();
					//result+="\n";
					disPlayApps.add(app);
				}
				//appTA.setText(result);
				refreshTable();
			}
		});
		
		// Initialize JPanel
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
		
		// Applications
		jpApp = new JPanel();
		jpApp.setBorder(new TitledBorder("Applications"));

//		// Application Text Area
//		appTA = new JTextArea(20, 50);
//		appTA.setEditable(false);
//		scrollPane = new JScrollPane(appTA);
//		jpApp.add(scrollPane);
		
		loadApps();

        createTable();
		
		// Compile Main JPanel
		jpMain.add(jpApp, BorderLayout.NORTH);
		
		// Add JPanel
		this.add(jpMain);
		
	}
	
	//==================================================================== Methods
	
	public void loadApps() {
		try( Scanner fin = new Scanner(new File("Applicationdatab.txt"))  ) {
			fin.nextLine();
			//String apps = "";
			while(fin.hasNextLine()) {
				Application tmp = new Application(fin.nextLine(), true);
				for(String platform:tmp.getPlatforms()){
					if(!platforms.contains(platform)){
						platforms.add(platform);
						platformBox.addItem(platform);
					}
				}
				disPlayApps.add(tmp);
				Apps.add(tmp);
				//apps += tmp.toString() + "\n";
				//appTA.setText(apps);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void createTable() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        int appCount = disPlayApps.size();
        System.out.println(disPlayApps.size());
        String[][] tableData = new String[appCount][3];
        for (int i = 0; i < appCount; i++) {
            Application app = disPlayApps.get(i);
            tableData[i][0] = app.getName();
//            tableData[i][1] = app.getDescription();
//            tableData[i][2] = app.getOrigin();
//            tableData[i][3] = app.getVersion();
//            tableData[i][4] = app.getStorehl();
            tableData[i][1] = "$" + app.getPrice();
            tableData[i][2] = app.getPlatforms().toString();
        }
        String[] columnTitle = {"Name", "Price", "Available Platforms"};
        tbModel = new DefaultTableModel(tableData, columnTitle);
        myTable = new JTable(tbModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        myTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint());
                    int col = ((JTable) e.getSource()).columnAtPoint(e.getPoint());
                    new MyDialog(AppDisplay.this, disPlayApps.get(row), home).setVisible(true);
                } else { return; }
            }
        });
        scrollPane = new JScrollPane(myTable);
        jpApp.add(scrollPane);
    }

    public void refreshTable() {
        tbModel.setRowCount(0);
        int appCount = disPlayApps.size();
        String[][] tableData = new String[appCount][7];
        for (int i = 0; i < appCount; i++) {
            Application app = disPlayApps.get(i);
            tableData[i][0] = app.getName();
//            tableData[i][1] = app.getDescription();
//            tableData[i][2] = app.getOrigin();
//            tableData[i][3] = app.getVersion();
//            tableData[i][4] = app.getStorehl();
            tableData[i][1] = "$" + app.getPrice();
            tableData[i][2] = app.getPlatforms().toString();
            tbModel.addRow(tableData[i]);
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
	
//	public Application searchBarApps(String key) {
//		Application ret = null;
//		
//		for (int i = 0; i < Apps.size(); i++)
//		if (Apps.get(i).getName().equals(key)) ret = Apps.get(i);
////		System.out.println(Apps.get(i) + "  ");	
//		//System.out.print(ret);
//		return ret;
//	}
	
	public void searchBarStrings(String key, ArrayList<Application> selectedApplication) {
		for (Application app : Apps) {
			if (app.getName().equals(key)) { selectedApplication.add(app); }
		}
	}
	
	public void clearArrays() {
		platforms.clear();
		disPlayApps.clear();
		Apps.clear();
	}
	
	//==================================================================== Main
	public static void main(String[] args) {
		AppDisplay ap = new AppDisplay();
        ap.setVisible(true);
	}
	
}
