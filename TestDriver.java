import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestNetflix {
    private static NetflixTitleContainers database = new NetflixTitleContainers();
    private static Scanner sc = new Scanner(System.in);

    public static int buildNetflixTitle() {
        // Return  1 for TV SHOW
        // Return  0 for MOVIES 
        // Return -1 for bad answer

        // Get user input
        System.out.println("Would you like to build a TV Show or a Movie?");
        String selection = sc.nextLine();

        if (selection.equalsIgnoreCase("TV Show")) {
            System.out.println("Okay, we are going to build a TV Show");
            return 1;
        } else if (selection.equalsIgnoreCase("Movie")) {
            System.out.println("Okay, we are going to build a Movie");
            return 0;
        } else {
            return -1;
        }
    }

    public static void buildTVShow() {
        // Temporary values
        String  t_show_id;
        String  t_type = "TV Show";
        String  t_title;
        String  t_director;
        String  t_country;
        int     t_release_year;
        String  t_rating;
        int     t_seasons;
        String  t_genre;

        // Prompt attributes
        System.out.print("Show ID: ");            t_show_id      = sc.nextLine();
        System.out.print("Title: ");              t_title        = sc.nextLine();
        System.out.print("Director: ");           t_director     = sc.nextLine();
        System.out.print("Country/Countries: ");  t_country      = sc.nextLine();
        System.out.print("Release year: ");       t_release_year = sc.nextLine();
        System.out.print("Rating: ");             t_rating       = sc.nextLine();
        System.out.print("Number of seasons: ");  t_seasons      = sc.nextLine();
        System.out.print("Genre: ");              t_genre        = sc.nextLine();

        // Add prompts to database
        NetflixShow new_show = new NetflixShow(
                t_show_id,
                t_type,
                t_title,
                t_director,
                t_country,
                t_release_year,
                t_rating,
                t_seasons,
                t_genre
                );

        // Add show to database
        database.addShow(new_show);

        // Output TV Show that was just created
        System.out.println("\n-- Show information --");
        database.displayShowInfo(title);
        System.out.println("");
    }

    public static void buildMovie() {
        // Temporary values
        String  t_show_id;
        String  t_type = "Movie";
        String  t_title;
        String  t_director;
        String  t_country;
        int     t_release_year;
        String  t_rating;
        int     t_minutes;
        String  t_genre;

        // Prompt attributes
        System.out.print("Show ID: ");            t_show_id      = sc.nextLine();
        System.out.print("Title: ");              t_title        = sc.nextLine();
        System.out.print("Director: ");           t_director     = sc.nextLine();
        System.out.print("Country/Countries: ");  t_country      = sc.nextLine();
        System.out.print("Release year: ");       t_release_year = sc.nextLine();
        System.out.print("Rating: ");             t_rating       = sc.nextLine();
        System.out.print("Duration (in minutes): ");  t_minutes      = sc.nextLine();
        System.out.print("Genre: ");              t_genre        = sc.nextLine();

        // Add prompts to database
        NetflixMovie new_movie = new NetflixMovie(
                t_show_id,
                t_type,
                t_title,
                t_director,
                t_country,
                t_release_year,
                t_rating,
                t_minutes,
                t_genre
                );

        // Add show to database
        database.addMovie(new_movie);

        // Output TV Show that was just created
        System.out.println("\n-- Movie information --");
        database.displayMovieInfo(title);
        System.out.println("");
    }

    public static void changeMovieAttribute(String attribute, String movieTitle) {
        NetflixMovie movie = database.getMovie(movieTitle);

        String t_show_id    = movie.getID();
        String t_title      = movie.getTitle();
        String t_director   = movie.getDirector();
        String t_country    = movie.getCountry();
        int    t_release_year = movie.getYear();
        String t_rating     = movie.getRating();
        int    t_minutes    = movie.getDuration();
        String t_genre      = movie.getGenre();

        String input;
        switch(attribute) {
            case "id": 
                System.out.println("Old ID: %s", t_show_id);
                input = sc.nextLine();
                movie.setID(input);
                System.out.println("New ID: %s", movie.getID());
                break;
            case "title": 
                System.out.println("Old title: %s", t_title);
                input = sc.nextLine();
                movie.setTitle(input);
                System.out.println("New title: %s", movie.getTitle());
                break;
            case "director":
                System.out.println("Old director: %s", t_director);
                input = sc.nextLine();
                movie.setDirector(input);
                System.out.println("New director: %s", movie.getDirector());
                break;
            case "country":
                System.out.println("Old country: %s", t_country);
                input = sc.nextLine();
                movie.setCountry(input);
                System.out.println("New country: %s", movie.getCountry());
                break;
            case "year":
                System.out.println("Old year: %d", t_release_year);
                input = sc.nextLine();
                movie.setYear(Integer.parseInt(input));
                System.out.println("New year: %d", movie.getYear());
                break;
            case "rating":
                System.out.println("Old rating: %s", t_rating);
                input = sc.nextLine();
                movie.setRating(input);
                System.out.println("New rating: %s", movie.getRating());
                break;
            case "duration":
                System.out.println("Old number of seasons: %d", t_seasons);
                input = sc.nextLine();
                movie.setDuration(Integer.parseInt(input));
                System.out.println("New number of seasons: %d", movie.getDuration());
                break;
            case "genre":
                System.out.println("Old genre: %s", t_genre);
                input = sc.nextLine();
                movie.setGenre(input);
                System.out.println("New genre: %s", movie.getGenre());
                break;
        }
    }

    public static void changeShowAttribute(String attribute, String showTitle) {
        NetflixShow show = database.getShow(showTitle);

        String t_show_id    = show.getID();
        String t_title      = show.getTitle();
        String t_director   = show.getDirector();
        String t_country    = show.getCountry();
        int    t_release_year = show.getYear();
        String t_rating     = show.getRating();
        int    t_seasons    = show.getDuration();
        String t_genre      = show.getGenre();

        String input;
        switch(attribute) {
            case "id": 
                System.out.println("Old ID: %s", t_show_id);
                input = sc.nextLine();
                show.setID(input);
                System.out.println("New ID: %s", show.getID());
                break;
            case "title": 
                System.out.println("Old title: %s", t_title);
                input = sc.nextLine();
                show.setTitle(input);
                System.out.println("New title: %s", show.getTitle());
                break;
            case "director":
                System.out.println("Old director: %s", t_director);
                input = sc.nextLine();
                show.setDirector(input);
                System.out.println("New director: %s", show.getDirector());
                break;
            case "country":
                System.out.println("Old country: %s", t_country);
                input = sc.nextLine();
                show.setCountry(input);
                System.out.println("New country: %s", show.getCountry());
                break;
            case "year":
                System.out.println("Old year: %d", t_release_year);
                input = sc.nextLine();
                show.setYear(Integer.parseInt(input));
                System.out.println("New year: %d", show.getYear());
                break;
            case "rating":
                System.out.println("Old rating: %s", t_rating);
                input = sc.nextLine();
                show.setRating(input);
                System.out.println("New rating: %s", show.getRating());
                break;
            case "duration":
                System.out.println("Old number of seasons: %d", t_seasons);
                input = sc.nextLine();
                show.setDuration(Integer.parseInt(input));
                System.out.println("New number of seasons: %d", show.getDuration());
                break;
            case "genre":
                System.out.println("Old genre: %s", t_genre);
                input = sc.nextLine();
                show.setGenre(input);
                System.out.println("New genre: %s", show.getGenre());
                break;
        }
    }

    public static void userInterface() {
        System.out.println("\n--- Please select an option ---");
        System.out.println("1. Add a title");
        System.out.println("2. Delete a title");
        System.out.println("3. Search for a title (displays information)");
        System.out.println("4. Modify a title");
        System.out.println("Type 'exit' to end program");
    }

    public static void main(String[] args) {

        // Get filename and parse through it
        try {
            System.out.print("Please enter the name of the input file: ");
            String filename = sc.nextLine();
            CSVParser csvParser = new CSVParser(filename);
            database = csvParser.parseCSVFile(); // Operates upon and adds each line to database
        } 
        // Throw error if file does not exist; exitting program...
        catch (FileNotFoundException error) {
            error.printStackTrace();
            System.exit(1);
        }
        
        // Allow user to add another Netflix title
        int selection = buildNetflixTitle();
        while (selection < 0) {
            // Continually ask for input until answer is correct
            System.out.println("Bad input, make sure you answer is either 'TV Show' or 'Movie'\n");
            selection = buildNetflixTitle();
        }
        switch(selection) {
            case 0: 
                buildMovie();
                break;
            case 1: 
                buildTVShow();
                break;
        }

        System.out.print("Do you want to change an attribute? (yes or no): ");
        String answer = sc.nextLine();

        if (answer.equals("yes")) {
            System.out.print("Enter the title you want to edit> ");
            String title = sc.nextLine();
            System.out.println("");

            // Change attribute
            System.out.println("Choose the attribute you want to change (type the full name) --");
            System.out.println("1 > title");
            System.out.println("2 > director");
            System.out.println("3 > country");
            System.out.println("4 > genre");
            System.out.println("5 > id");
            System.out.println("6 > rating");
            System.out.println("7 > year");
            System.out.println("8  (movies only) > duration");
            System.out.println("9  (shows only)  > seasons");
            System.out.print("> ");

            String attribute = sc.nextLine();
            System.out.println("\n-- Updating information --");

            if (selection == 1) { // TV SHOW
                changeShowAttribute(attribute, title); 
                System.out.println("\n-- Updated show information --");
                database.displayShowInfo(title);
            } else if (selection == 0) { // MOVIES
                changeMovieAttribute(attribute, title);
                System.out.println("\n-- Updated movie information --");
                database.displayMovieInfo(title);
            }
        }
        sc.close();
    }
}
