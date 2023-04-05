import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CSVParser {
    private String filename;
    private Scanner file_sc;
    
    public CSVParser(String filename) throws FileNotFoundException {
        this.filename = filename;

        // Throw an exception if file is not found
        try {
            file_sc = new Scanner(new File(filename));
        } catch (FileNotFoundException error) {
            throw new FileNotFoundException("FileNotFoundException: " + filename + " does not exist");
        }
    }
    
    // TODO: 
    //  Read data from this file and a build a database of titles
    public void parseCSVFile() {
        try {
            file_sc = new Scanner(new File(filename));
            //file_sc.useDelimiter(",");
            while(file_sc.hasNext()) {
                String current_line = file_sc.next();
                System.out.printf("%s", current_line);


            }
            System.out.println("");
            file_sc.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
