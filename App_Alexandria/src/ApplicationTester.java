import java.io.File;
import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Scanner;

public class ApplicationTester {

	private static ArrayList<Application> apps = new ArrayList<>();
	
	public static void main(String[] args) {
		loadData();
		printList();
	}
	

	
	private static void loadData() {
		try( Scanner fin = new Scanner(new File("Applicationdatab.txt"))  ) {
			fin.nextLine();
			while(fin.hasNextLine()) {
				Application x = new Application(fin.nextLine());
				apps.add(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	private static void printList() {
		for(Application s : apps) {
			System.out.println(s);		
		}
	}
	
}
