import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class CSVParser {
    private NetflixTitleContainer database = new NetflixTitleContainer();
    private Scanner file_sc;

    public CSVParser(String filename) throws FileNotFoundException {
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
                if (line.charAt(i) == '\t' || line.charAt(i) == ',') {
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

            // Reset attributes for clean array list upon next iteration
            attributes.clear();

            // Clean data of whitespaces
            // This is done so that the UI is cleaner when 
            //      the user wants to see a title's information
            //      displayed
            if (t_show_id.equalsIgnoreCase("")) {
                t_show_id = "[show_id not given]";
            }
            if (t_type.equalsIgnoreCase("")) {
                t_type = "[type not given]";
            }
            if (t_title.equalsIgnoreCase("")) {
                t_title = "[title not given]";
            }
            if (t_director.equalsIgnoreCase("")) {
                t_director = "[director not given]";
            }
            if (t_country.equalsIgnoreCase("")) {
                t_country = "[country not given]";
            }
            if (t_release_year.equalsIgnoreCase("")) {
                t_release_year = "[release_year not given]";
            }
            if (t_rating.equalsIgnoreCase("")) {
                t_rating = "[rating not given]";
            }
            if (t_duration.equalsIgnoreCase("")) {
                t_duration = "[duration not given]";
            }
            if (t_genre.equalsIgnoreCase("")) {
                t_genre = "[genre not given]";
            }
            
            // Build and add attributes to respective NetflixTitle type
            if (t_type.equalsIgnoreCase("TV Show")) {
                database.buildTVShowWithoutPrompt(
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
            else if (t_type.equalsIgnoreCase("Movie")) {
                database.buildMovieWithoutPrompt(
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
