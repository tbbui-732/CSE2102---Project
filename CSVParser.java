import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class CSVParser {
    private String filename;
    
    public CSVParser(String filename) {
        this.filename = filename;
    }

    // Prints out every line in CSV file
    public void displayCSVFile() {
        try {
            Scanner sc = new Scanner(new File(filename));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                System.out.print(sc.next());
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
