import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyDialog extends JDialog {
	
	private static ArrayList<Application> Apps = new ArrayList<>();
	
    public MyDialog(JFrame jFrame, Application app) {   	
        super(jFrame, "ApplicationInformation");
        this.setLayout(new BorderLayout());
        if (app != null) {
            String[] tableData = new String[10];
            tableData[0] = "";
            tableData[1] = "Name:         " + app.getName();
            tableData[2] = "Description:  " + app.getDescription();
            tableData[3] = "Origin/Developer:       " + app.getOrigin();
            tableData[4] = "Version:      v" + app.getVersion();
            tableData[5] = "Hotlink:      " + app.getStorehl();
            tableData[6] = "Price:        $" + app.getPrice() + "\n";
            tableData[7] = "Platforms:    " + app.getPlatforms().toString();
            tableData[8] = "Likes:        " + app.getLikes();
            tableData[9] = "";
            for (int i = 0; i < 10; i++) {
                JLabel label = new JLabel(tableData[i]);
                label.setBounds(0, 40 * i, 400, 30);
                label.setVisible(true);
                this.add(label, BorderLayout.CENTER);
            }
            
            loadApps();
            
            // +1 like button
    		JButton upvote = new JButton("Like");
    		upvote.setBounds(1, 1, 1, 1);
    		this.add(upvote, BorderLayout.NORTH);
    		upvote.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				JOptionPane.showMessageDialog(null, "Liked!");
    				for (int i = 0; i < Apps.size(); i++) {
    					if (Apps.get(i).getName().equals(app.getName())) { Apps.get(i).setLikes(app.getLikes() + 1); }
    				}
    				refreshApps();
    				loadApps();
    			}
    		});
        
        	// -1 like button
     		JButton downvote = new JButton("Dislike");
     		downvote.setBounds(2, 2, 1, 1);
     		this.add(downvote, BorderLayout.SOUTH);
     		downvote.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				JOptionPane.showMessageDialog(null, "Disliked!");
     				for (int i = 0; i < Apps.size(); i++) {
    					if (Apps.get(i).getName().equals(app.getName())) { Apps.get(i).setLikes(app.getLikes() - 1); }
    				}
    				refreshApps();
    				loadApps();
     			}
     		});

        }
        setBounds(100, 100, 400, 540);
    }
    
    private void loadApps() {
		try( Scanner fin = new Scanner(new File("Applicationdatab.txt"))  ) {
			fin.nextLine();
			while(fin.hasNextLine()) {
				Application tmp = new Application(fin.nextLine(), true);
				Apps.add(tmp);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
    private void refreshApps() {
    	File file = new File("Applicationdatab.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.println("Name	Description	Origin	Version	StoreHotLink	Price	Likes	Platforms");
			for(int i = 0; i < Apps.size() ; i++) {
				String tmp = "";
				tmp +=  Apps.get(i).getName() + "	"+ Apps.get(i).getDescription() + "	" + Apps.get(i).getOrigin() + "	" + Apps.get(i).getVersion() + "	" + Apps.get(i).getStorehl() + "	" + Apps.get(i).getPrice() + "	" + Apps.get(i).getLikes();
				ArrayList<String> plats = Apps.get(i).getPlatforms();
				for(int j = 0; j < plats.size(); j++) {
					tmp += "	" + plats.get(j);
				}
				writer.println(tmp);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}