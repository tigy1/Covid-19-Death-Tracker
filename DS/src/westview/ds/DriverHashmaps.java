package westview.ds;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class DriverHashmaps {

	public static void main(String[] args) {
		try {
			int add = 0;
			HashMap state = new HashMap<String, HashMap<String, Integer>>();
			Scanner scanner = new Scanner(new File("covid417.csv"));
			String[] row = scanner.nextLine().split(",");
			while(scanner.hasNext()) {
				row = scanner.nextLine().toLowerCase().split(",");
				if(state.get(row[1]) == null){
					HashMap cases = new HashMap<String, Integer>();
					state.put(row[1], cases);
				}
				else {
					( (HashMap) state.get(row[1])).put(row[0], Integer.parseInt(row[2]));
				}
			}
			scanner.close();
			while(true) {
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("Input a state:");
				String seutate = scanner2.nextLine().toLowerCase();
				if(state.get(seutate) == null) {
					System.out.println("its over");
				}
				else {
					for (Object i: ((HashMap) state.get(seutate)).values()) {
						add += (Integer) i;
				}
					System.out.println(add);
					System.out.println("Input a city:");
					String ceuty = scanner2.nextLine().toLowerCase();
				if(((HashMap) state.get(seutate)).get(ceuty) == (null)) {
						System.out.println("City does not exist");
				}
				else {
						System.out.println(( (HashMap) state.get(seutate)).get(ceuty));
				}
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
