import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class CSVParser {
    private NetflixTitleContainer database = new NetflixTitleContainer();
    private String filename;
    private Scanner file_sc;

    public CSVParser(String filename) throws FileNotFoundException {
        this.filename = filename;
        
        // Make sure that the file given exists
        try {
            file_sc = new Scanner(new File(filename));
        } 
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("FileNotFoundException: " + filename + " does not exist");
        }
    }

    public NetflixTitleContainer parseCSVFile() {
        // Skip line that contains CSV format
        file_sc.nextLine(); 
        
        ArrayList<String> attributes = new ArrayList<String>();
        while (file_sc.hasNextLine()) {
            String line = file_sc.nextLine();
            String word = "";

            // Parse through the given line
            for (int i = 0; i < line.length(); i++) {
                // Parsing regular words
                if (line.charAt(i) == ',') {
                    attributes.add(word);
                    word = "";
                    continue;
                }

                // Parsing through attributes with multiple
                //      strings
                if (line.charAt(i) == '\"') {
                    i++; 
                    while (line.charAt(i) != '\"') {
                        word += line.charAt(i);
                        i++;
                    }
                    attributes.add(word);
                    word = "";
                    continue;
                }

                word += line.charAt(i);

                // Add word to attributes if it's the last one
                if (i == line.length()-1) {
                    attributes.add(word);
                }
            }        
            
            // Put the attributes into either NetflixShow or NetflixMovie
            //      depending on the given type
            String  t_show_id       = attributes.get(0);
            String  t_type          = attributes.get(1); 
            String  t_title         = attributes.get(2); 
            String  t_director      = attributes.get(3); 
            String  t_country       = attributes.get(4); 
            String  t_release_year  = attributes.get(5); 
            String  t_rating        = attributes.get(6); 
            String  t_duration      = attributes.get(7); 
            String  t_genre         = attributes.get(8); 

            // NOTE: remove these temporary files once done testing
            System.out.println(t_show_id);
            System.out.println(t_type);
            System.out.println(t_title);
            System.out.println(t_director);
            System.out.println(t_country);
            System.out.println(t_release_year);
            System.out.println(t_rating);
            System.out.println(t_duration);
            System.out.println(t_genre);
            System.out.println("");

            if (t_show_id.equalsIgnoreCase("TV Show")) {
                database.buildShow(
                        t_show_id,
                        t_type,
                        t_title,
                        t_director,
                        t_country,
                        t_release_year,
                        t_rating,
                        t_duration,
                        t_genre);

            }
            else if (t_show_id.equalsIgnoreCase("Movie")) {
                database.buildMovie(
                        t_show_id,
                        t_type,
                        t_title,
                        t_director,
                        t_country,
                        t_release_year,
                        t_rating,
                        t_duration,
                        t_genre);
            }
        }
        file_sc.close();
        return database;
    }
}

