import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CSVParser {
    private String filename;
    Scanner file_sc;
    NetflixTitleContainer database = new NetflixTitleContainer(); 

    public CSVParser(String filename) throws FileNotFoundException {
        this.filename = filename;

        // Throw an exception if file is not found
        try {
            file_sc = new Scanner(new File(filename));
        } catch (FileNotFoundException error) {
            throw new FileNotFoundException("FileNotFoundException: " + filename + " does not exist");
        }
    }

    // Parses every line in CSV and puts information into the corresponding container
    // Returns database if successful
    public NetflixTitleContainer parseCSVFile() {
        File file = new File(filename);
        try {
            Scanner file_sc = new Scanner(file);

            // Loop through every line in the CSV file
            while (file_sc.hasNextLine()) {
                String line = file_sc.nextLine();
                Scanner line_sc = new Scanner(line);
                line_sc.useDelimiter(",");

                // Temporary variables
                String  t_show_id       = line_sc.next();
                String  t_type          = line_sc.next();
                String  t_title         = line_sc.next();
                String  t_director      = line_sc.next();
                String  t_country       = line_sc.next();
                String  t_release_year  = line_sc.next(); 
                String  t_rating        = line_sc.next();
                String  t_duration      = line_sc.next();
                String  t_genre         = line_sc.next();

                if (t_type.equalsIgnoreCase("TV Show")) {
                    database.buildShow(
                            t_show_id,
                            t_type,
                            t_title,
                            t_director,
                            t_country,
                            Integer.parseInt(t_release_year),
                            t_rating,
                            Integer.parseInt(t_duration),
                            t_genre);
                } else if (t_type.equalsIgnoreCase("Movie")) {
                    database.buildMovie(
                            t_show_id,
                            t_type,
                            t_title,
                            t_director,
                            t_country,
                            Integer.parseInt(t_release_year),
                            t_rating,
                            Integer.parseInt(t_duration),
                            t_genre);
                }
                line_sc.close();
            }
            file_sc.close();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
        return database;
    }
}
