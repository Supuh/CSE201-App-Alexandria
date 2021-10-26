import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class DEPRECATEDAppDisplay extends JFrame implements ActionListener{

	//==================================================================== Properties
	JLabel appLabel[];
	private static List<JButton> buttonList = new ArrayList<JButton>();
	static JScrollPane sp; 
	//static JList appList = new JList(buttonList);
	
	//private static ArrayList<Application> Apps = new ArrayList<>();
	
	//==================================================================== Constructor
	DEPRECATEDAppDisplay() {
		setTitle("App Alexandria");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadApps();
		JList<JButton> buttonListJ = new JList<JButton>();
		for (int i = 0; i < buttonList.size(); i++) {
			buttonListJ.add(buttonList.get(i));
		}
		
		System.out.println(buttonListJ.getModel().getSize());
		
		sp = new JScrollPane(buttonListJ);
		
		Container contentPane = getContentPane();
	    contentPane.add(sp, BorderLayout.CENTER);
		
		//sp.setViewportView(buttonList);
		//add(sp);
	}
	
	//==================================================================== Methods
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private static void loadApps() {
		try( Scanner fin = new Scanner(new File("Applicationdatab.txt"))  ) {
			fin.nextLine();
			while(fin.hasNextLine()) {
				Application tmp = new Application(fin.nextLine());
				//Apps.add(tmp);
				
				JButton button = new JButton(tmp.getName());
			    buttonList.add(button);
			    //appList.add(button);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//==================================================================== Main
	public static void main(String[] args) {
		new AppDisplay();
		
//		ap.setTitle("App Alexandria");
//        ap.setVisible(true);
//        ap.setSize(800, 800);
//        ap.setLayout(null);
//        ap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
