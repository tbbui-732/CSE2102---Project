import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class TestDriver {
    private static NetflixTitleContainer database = new NetflixTitleContainer();
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
        System.out.print("Release year: ");       t_release_year = Integer.parseInt(sc.nextLine());
        System.out.print("Rating: ");             t_rating       = sc.nextLine();
        System.out.print("Number of seasons: ");  t_seasons      = Integer.parseInt(sc.nextLine());
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
        database.displayShowInfo(t_title);
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
        System.out.print("Release year: ");       t_release_year = Integer.parseInt(sc.nextLine());
        System.out.print("Rating: ");             t_rating       = sc.nextLine();
        System.out.print("Duration (in minutes): ");  t_minutes      = Integer.parseInt(sc.nextLine());
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
        database.displayMovieInfo(t_title);
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
                System.out.printf("Old ID: %s\n", t_show_id);
                input = sc.nextLine();
                movie.setID(input);
                System.out.printf("New ID: %s\n", movie.getID());
                break;
            case "title": 
                System.out.printf("Old title: %s\n", t_title);
                input = sc.nextLine();
                movie.setTitle(input);
                System.out.printf("New title: %s\n", movie.getTitle());
                break;
            case "director":
                System.out.printf("Old director: %s\n", t_director);
                input = sc.nextLine();
                movie.setDirector(input);
                System.out.printf("New director: %s\n", movie.getDirector());
                break;
            case "country":
                System.out.printf("Old country: %s\n", t_country);
                input = sc.nextLine();
                movie.setCountry(input);
                System.out.printf("New country: %s\n", movie.getCountry());
                break;
            case "year":
                System.out.printf("Old year: %d\n", t_release_year);
                input = sc.nextLine();
                movie.setYear(Integer.parseInt(input));
                System.out.printf("New year: %d\n", movie.getYear());
                break;
            case "rating":
                System.out.printf("Old rating: %s\n", t_rating);
                input = sc.nextLine();
                movie.setRating(input);
                System.out.printf("New rating: %s\n", movie.getRating());
                break;
            case "seasons":
                System.out.printf("Old number of minutes: %d\n", t_minutes);
                input = sc.nextLine();
                movie.setDuration(Integer.parseInt(input));
                System.out.printf("New number of minutes: %d\n", movie.getDuration());
                break;
            case "genre":
                System.out.printf("Old genre: %s\n", t_genre);
                input = sc.nextLine();
                movie.setGenre(input);
                System.out.printf("New genre: %s\n", movie.getGenre());
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
                System.out.printf("Old ID: %s\n", t_show_id);
                input = sc.nextLine();
                show.setID(input);
                System.out.printf("New ID: %s\n", show.getID());
                break;
            case "title": 
                System.out.printf("Old title: %s\n", t_title);
                input = sc.nextLine();
                show.setTitle(input);
                System.out.printf("New title: %s\n", show.getTitle());
                break;
            case "director":
                System.out.printf("Old director: %s\n", t_director);
                input = sc.nextLine();
                show.setDirector(input);
                System.out.printf("New director: %s\n", show.getDirector());
                break;
            case "country":
                System.out.printf("Old country: %s\n", t_country);
                input = sc.nextLine();
                show.setCountry(input);
                System.out.printf("New country: %s\n", show.getCountry());
                break;
            case "year":
                System.out.printf("Old year: %d\n", t_release_year);
                input = sc.nextLine();
                show.setYear(Integer.parseInt(input));
                System.out.printf("New year: %d\n", show.getYear());
                break;
            case "rating":
                System.out.printf("Old rating: %s\n", t_rating);
                input = sc.nextLine();
                show.setRating(input);
                System.out.printf("New rating: %s\n", show.getRating());
                break;
            case "duration":
                System.out.printf("Old number of seasons: %d\n", t_seasons);
                input = sc.nextLine();
                show.setDuration(Integer.parseInt(input));
                System.out.printf("New number of seasons: %d\n", show.getDuration());
                break;
            case "genre":
                System.out.printf("Old genre: %s\n", t_genre);
                input = sc.nextLine();
                show.setGenre(input);
                System.out.printf("New genre: %s\n", show.getGenre());
                break;
        }
    }

    public static void addNewTitle() {
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
        
        // After title has been created, the user has a chance to create edits here
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
            System.out.println("8 (movies only) > duration");
            System.out.println("9 (shows only)  > seasons");
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
    }

    public static void deleteTitle() {
        String input;
        System.out.print("Enter title to delete: ");
        input = sc.nextLine();
        
        // Continually prompt user for title to delete in case
        //  the one entered does not exist
        while (!database.titleExists(input)) {
            System.out.printf("%s does not exist\n", input);
            System.out.print("Enter title to delete: ");
            input = sc.nextLine();
        }
       
        database.removeTitle(input);
        System.out.printf("Successfully deleted %s!\n", input);
    }
    
    public static void addNewFile() {
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
    }

    public static void modifyExistingTitle() {
        String type;
        String title;
        String attribute;

        System.out.print("Modify 'TV Show' or 'Movie'? : ");
        type = sc.nextLine();

        System.out.print("Enter title you want to modify: ");
        title = sc.nextLine();

        System.out.println("Choose the attribute you want to change (type the full name) --");
        System.out.println("1 > title");
        System.out.println("2 > director");
        System.out.println("3 > country");
        System.out.println("4 > genre");
        System.out.println("5 > id");
        System.out.println("6 > rating");
        System.out.println("7 > year");
        System.out.println("8 (movies only) > duration");
        System.out.println("9 (shows only)  > seasons");
        System.out.print("> ");
        attribute = sc.nextLine();
        
        // Make sure type exists
        while (!(type.equalsIgnoreCase("TV Show")) && !(type.equalsIgnoreCase("Movie"))) {
            System.out.print("Invalid type: 'TV Show' or 'Movie'? : ");
            type = sc.nextLine();
        }
        
        // Change attributes
        if (type.equalsIgnoreCase("TV Show")) {
            changeShowAttribute(attribute, title);
            return;
        } else if (type.equalsIgnoreCase("Movie")) {
            changeMovieAttribute(attribute, title);
            return;
        }
    }
    
    // Displays titles based on desired director
    public static void searchDirector() {
        ArrayList<String> directors = database.getDirectors();
        int n = directors.size();
        System.out.println("Please select from the following directors");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d: %s\n", i, directors.get(i));
        }
        
        String director;
        director = sc.nextLine();
        
        // Display titles with current director name
        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        ArrayList<NetflixShow> showContainer = database.getShowContainer();

        n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (director.equalsIgnoreCase(movieContainer.get(i).getDirector())) {
                System.out.println(movieContainer.get(i).getTitle());
            }
        }
        
        n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (director.equalsIgnoreCase(showContainer.get(i).getDirector())) {
                System.out.println(showContainer.get(i).getTitle());
            }
        }
    }

    // Displays titles based on desired country
    public static void searchCountry() {
        ArrayList<String> countries = database.getCountries();
        int n = countries.size();
        System.out.println("Please select from the following countries");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d: %s\n", i, countries.get(i));
        }

        String country;
        country = sc.nextLine();

        // Display titles with current country
        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        ArrayList<NetflixShow> showContainer = database.getShowContainer();

        n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (country.equalsIgnoreCase(movieContainer.get(i).getCountry())) {
                System.out.println(movieContainer.get(i).getTitle());
            }
        }

        n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (country.equalsIgnoreCase(showContainer.get(i).getCountry())) {
                System.out.println(showContainer.get(i).getTitle());
            }
        }
    }

    public static void searchGenre() {
        ArrayList<String> genres = database.getGenres();
        int n = genres.size();
        System.out.println("Please select from the following genres");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d: %s", i, genres.get(i));
        }
        String genre;
        genre = sc.nextLine();

        // Display titles with current genre
        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        ArrayList<NetflixShow> showContainer = database.getShowContainer();

        n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (genre.equalsIgnoreCase(movieContainer.get(i).getGenre())) {
                System.out.println(movieContainer.get(i).getTitle());
            }
        }

        n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (genre.equalsIgnoreCase(showContainer.get(i).getGenre())) {
                System.out.println(showContainer.get(i).getTitle());
            }
        }
    }

    public static void searchRating() {
        System.out.println("Please select from the following ratings");
        System.out.println("1. PG-13");
        System.out.println("2. TV-MA");
        System.out.println("3. TV-14");
        System.out.println("4. TV-PG");
        System.out.println("5. TV-Y");
        System.out.println("6. TV-Y7");
        System.out.println("7. R");
        System.out.println("8. TV-G");

        String rating;
        int n;
        rating = sc.nextLine();

        // Display titles with current rating
        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        ArrayList<NetflixShow> showContainer = database.getShowContainer();

        n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (rating.equalsIgnoreCase(movieContainer.get(i).getRating())) {
                System.out.println(movieContainer.get(i).getTitle());
            }
        }

        n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (rating.equalsIgnoreCase(showContainer.get(i).getRating())) {
                System.out.println(showContainer.get(i).getTitle());
            }
        }
    }

    public static void searchYear() {
        System.out.println("Please enter a year: ");
        System.out.println("Program will display years +/- 50 years");

        int year;
        int n;
        year = Integer.parseInt(sc.nextLine());

        int minYear = year - 50;
        int maxYear = year + 50;

        // Display titles with years +/- 50 years
        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        ArrayList<NetflixShow> showContainer = database.getShowContainer();

        n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            int currYear = movieContainer.get(i).getYear();
            if (currYear >= minYear && currYear <= maxYear) {
                System.out.println(movieContainer.get(i).getTitle());
            }
        }

        n = showContainer.size();
        for (int i = 0; i < n; i++) {
            int currYear = showContainer.get(i).getYear();
            if (currYear >= minYear && currYear <= maxYear) {
                System.out.println(showContainer.get(i).getTitle());
            }
        }
    }

    public static void searchMovieDuration() {
        System.out.println("Please select a range of movie length (enter letter)");
        System.out.println("a. 0-30 minutes");
        System.out.println("b. 31-60 minutes");
        System.out.println("c. 61-90 minutes");
        System.out.println("d. 91-120 minutes");
        System.out.println("e. 121-150 minutes");
        System.out.println("f. 151-180 minutes");

        String selection;
        selection = sc.nextLine();

        // Find titles within selected time range
        int minTime = 0;
        int maxTime = 30;

        switch(selection) {
            case "a":
                minTime = 0;
                maxTime = 30;
                break;
            case "b":
                minTime = 31;
                maxTime = 60;
                break;
            case "c":
                minTime = 61;
                maxTime = 90;
                break;
            case "d":
                minTime = 91;
                maxTime = 120;
                break;
            case "e":
                minTime = 121;
                maxTime = 150;
                break;
            case "f":
                minTime = 151;
                maxTime = 180;
                break;
        }

        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        int n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            int curr_year = movieContainer.get(i).getYear();
            if (curr_year <= maxTime && curr_year >= minTime) {
                System.out.println(movieContainer.get(i).getTitle());
            }
        }
    }

    public static void searchShowDuration() {
        System.out.println("Please select a range of season lengths (enter letter)");
        System.out.println("a. 0-3 seasonss");
        System.out.println("b. 4-7 seasonss");
        System.out.println("c. 8-11 seasons");
        System.out.println("d. 12-15 seasons");
        System.out.println("e. 16-19 seasons");
        System.out.println("f. 20-23 seasons");

        String selection;
        selection = sc.nextLine();

        // Find titles within selected time range
        int minSeason = 0;
        int maxSeason = 3;

        switch(selection) {
            case "a":
                minSeason = 0;
                maxSeason = 3;
                break;
            case "b":
                minSeason = 4;
                maxSeason = 7;
                break;
            case "c":
                minSeason = 8;
                maxSeason = 11;
                break;
            case "d":
                minSeason = 12;
                maxSeason = 15;
                break;
            case "e":
                minSeason = 16;
                maxSeason = 19;
                break;
            case "f":
                minSeason = 20;
                maxSeason = 23;
                break;
        }

        ArrayList<NetflixShow> showContainer = database.getShowContainer();
        int n = showContainer.size();
        for (int i = 0; i < n; i++) {
            int curr_year = showContainer.get(i).getYear();
            if (curr_year <= maxSeason && curr_year >= minSeason) {
                System.out.println(showContainer.get(i).getTitle());
            }
        }
    }

    public static void searchForTitle() {
        String type;
        String attribute;

        // Ask user for movie or tv show
        System.out.println("Are you looking for a 'TV Show' or 'Movie'?");
        System.out.print("> ");
        type = sc.nextLine();

        // Search based on attributes
        System.out.println("Which attribute are you searching based on? (enter full word)");
        System.out.println("1 > director");
        System.out.println("2 > country");
        System.out.println("3 > genre");
        System.out.println("4 > rating");
        System.out.println("5 > year");
        System.out.println("6 (movies only) > duration");
        System.out.println("7 (shows only)  > seasons");
        System.out.print("> ");
        attribute = sc.nextLine();

        switch(attribute) {
            case "director": 
                searchDirector();
                break;
            case "country": 
                searchCountry();
                break;
            case "genre": 
                searchGenre();
                break;
            case "rating": 
                searchRating();
                break;
            case "year": 
                searchYear();
                break;
            case "duration": 
                searchMovieDuration();
                break;
            case "seasons": 
                searchShowDuration();
                break;
        }
    }

    public static void mainMenu() {
        int input; 

        System.out.println("\n--- Please enter number to select following options ---");
        System.out.println("1. Add a title");
        System.out.println("2. Delete a title");
        System.out.println("3. Search for a title (displays information)");
        System.out.println("4. Modify a title");
        System.out.println("5. Exit program");
        input = Integer.parseInt(sc.nextLine());

        while (input < 1 || input > 4) {
            System.out.println("Invalid input, please enter a value between (1-5)");
            input = Integer.parseInt(sc.nextLine());
        }
        
        switch(input) {
            case 1: 
                System.out.println("--- Adding a new title ---");
                addNewTitle();
                break;
            case 2: 
                System.out.println("--- Deleting a title ---");
                deleteTitle(); 
                break;
            case 3: 
                System.out.println("--- Searching for a title ---");
                searchForTitle();
                break;
            case 4: 
                System.out.println("--- Modifying an existing title ---");
                modifyExistingTitle();
                break;
        }
    }

    public static void main(String[] args) {
        addNewFile();
        mainMenu();
    }
}
