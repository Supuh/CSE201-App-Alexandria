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
import javax.swing.JTextField;

public class SubmissionPage extends JFrame implements ActionListener{
    JLabel name, desc, ori, ver, store, price, title;
    JTextField tfname, tfdesc, tfori, tfver, tfstore, tfprice;
    JButton submit;
    private ArrayList<Application> requests = new ArrayList<>();
    JButton submissionp;
    SubmissionPage() {
        setTitle("Request new apps for App Alexandria");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ///////////////////////////////////////////////////////////
        title = new JLabel("Request new apps for App Alexandria");
        title.setForeground(Color.blue);
        title.setFont(new Font("Serif", Font.BOLD, 20));

        //labels
        name = new JLabel("Enter your app's name");
        desc = new JLabel("Enter your app's description");
        ori = new JLabel("Enter your app's origin");
        ver = new JLabel("Enter your app's version");
        store = new JLabel("Enter your app's store hotlink");
        price = new JLabel("Enter your app's price");
        
        //text boxes
        tfname = new JTextField();
        tfdesc = new JTextField();
        tfori = new JTextField();
        tfver = new JTextField();
        tfstore = new JTextField();
        tfprice = new JTextField();

        //label bounds
        title.setBounds(100, 30, 400, 30);
        name.setBounds(80, 70, 200, 30);
        desc.setBounds(80, 110, 200, 30);
        ori.setBounds(80, 150, 200, 30);
        ver.setBounds(80, 190, 200, 30);
        store.setBounds(80, 230, 200, 30);
        price.setBounds(80, 270, 200, 30);
        
        // textbox bounds     
        tfname.setBounds(300, 70, 200, 30);
        tfdesc.setBounds(300, 110, 200, 30);
        tfori.setBounds(300, 150, 200, 30);
        tfver.setBounds(300, 190, 200, 30);
        tfstore.setBounds(300, 230, 200, 30);
        tfprice.setBounds(300, 270, 200, 30);
        

        //adding labels
        add(title);
        add(name);
        add(desc);
        add(ori);
        add(ver);
        add(store);
        add(price);
        
        //adding textbox
        add(tfname);
        add(tfdesc);
        add(tfori);
        add(tfver);
        add(tfstore);
        add(tfprice);
        
        //submit button
        submit = new JButton("Submit your app");
        submit.addActionListener(this);
        submit.setBounds(190, 310, 200, 30);
        add(submit);
        
		// app page button
		submissionp = new JButton("Click here to return to main page for App Alexandria");
		submissionp.setBounds(225, 570, 350, 30);
		add(submissionp);
		submissionp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AppDisplay().setVisible(true);
			}
		});
    }
    
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getActionCommand().equals("Submit your app")) {
				requestW(tfname.getText(), tfdesc.getText(), tfori.getText(),
						tfver.getText(), tfstore.getText(), tfprice.getText());
		        tfname.setText("");
		        tfdesc.setText("");
		        tfori.setText("");
		        tfver.setText("");
		        tfstore.setText("");
		        tfprice.setText("");
			}
	}
  
    private boolean requestW(String name, String desc, String ori, String ver, String store, String price) {
		if (name.equals("") || desc.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter every element of data");
			return false;
		}
		
		loadRequests();
		requests.add(new Application(name + "	" + desc + "	" + ori + "	" + ver + "	" + store + "	" + price));
		File file = new File("Requests.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);

		writer.println("Name	Description	Origin	Version	StoreHotLink	Price	Platform");
		for(int i = 0; i < requests.size() ; i++) {
			writer.println(requests.get(i).getName() + "	" + requests.get(i).getDescription() + "	" + requests.get(i).getOrigin() + "	" + requests.get(i).getVersion() + "	" + requests.get(i).getStorehl() + "	" + requests.get(i).getPrice());
		}
		writer.close();
		JOptionPane.showMessageDialog(null, "Your app was submitted");
		return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "An Error Occurred During App Submission. \n Please Try Again");
		return false;
		
	}


	private void loadRequests() {
		try( Scanner fin = new Scanner(new File("Requests.txt"))  ) {
			fin.nextLine();
			while(fin.hasNextLine()) {
				Application tmp = new Application(fin.nextLine());
				requests.add(tmp);
			}
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static void main(String arr[]) {
        new SubmissionPage();
    }
}
