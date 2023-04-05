import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CSVParser {
    private String filename;
    private Scanner file_sc;
    
    public CSVParser(String filename) throws FileNotFoundException {
        this.filename = filename;
        try {
            file_sc = new Scanner(new File(filename));
        } catch (FileNotFoundException error) {
            throw new FileNotFoundException("FileNotFoundException: " + filename + " does not exist");
        }
    }

    // TODO: we need a function that parses through every CSV line
    //  Each line builds either a NetflixShow or NetflixMovie
    //  It then adds it to the NetflixContainers database
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
