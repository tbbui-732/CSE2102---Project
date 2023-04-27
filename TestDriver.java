import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class TestDriver {
    private static NetflixTitleContainer database = new NetflixTitleContainer();
    private static Scanner sc = new Scanner(System.in);
    private static DataParser dataParser;

    /*
       promptTitleType() prompts user for title type : ('TV Show', 'Movie')
       Returns 1 for 'TV Show'
       Returns 0 for 'Movie'
       Returns -1 for bad answer
       */
    public static int promptTitleType() {
        // Get user input
        System.out.println("Would you like to build a TV Show or a Movie?");
        System.out.print("> ");
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

    /*
        addNewTitle() prompts the user to create a new 'Movie' or 'TV Show'.
        These new objects are added to the database.

        Sidenote: once object is created, a UI prompt will ask the user if they want to change an attribute

        No return value. 
        */
    public static void addNewTitlePrompt() {
        int selection = promptTitleType();
        while (selection < 0) {
            // Continually ask for input until answer is correct
            System.out.println("Bad input, make sure you answer is either 'TV Show' or 'Movie'");
            System.out.println("Type '2' to quit this menu");
            if (selection == 2) {
                return;
            }
            selection = promptTitleType();
        }

        switch(selection) {
            case 0: 
                database.buildMovieWithPrompt();
                break;
            case 1: 
                database.buildTVShowWithPrompt();
                break;
        }
    }
        
    /*
        deleteTitle() prompts user for desired title to delete.
        The selected title is removed from the database. 
         
        No return value. 
        */
    public static void deleteTitlePrompt() {
        // Store all titles into a single array list
        ArrayList<String> showTitles = database.getShowTitles();
        ArrayList<String> movieTitles = database.getMovieTitles();
        ArrayList<String> allTitles = new ArrayList<String>();
        allTitles.addAll(movieTitles);
        allTitles.addAll(showTitles);

        // Display all the titles
        for (int i = 0; i < allTitles.size(); i++) {

            // This function displays the titles
            if (i >= 0 && i < movieTitles.size()) {
                System.out.printf("%d: %s\n", i+1, movieTitles.get(i));
            } else if (i >= movieTitles.size() && i <= allTitles.size()) {
                System.out.printf("%d: %s\n", i+1, showTitles.get(i - movieTitles.size()));
            }

            // During every 10th title shown, prompt the user for their input
            if ((i+1) % 10 == 0) {
                System.out.println("|Hit space to see more, or type the number of the title you would like to remove|");
                System.out.print("> ");
                String input = sc.nextLine();
                if (input.equals("")) {
                    continue;
                } else {

                    // If a number was selected, then delete the associated number
                    int num = Integer.parseInt(input);
                    System.out.printf("Title: %s will be deleted now\n", allTitles.get(num-1));

                    if (num >= 0 && num < movieTitles.size()) {
                        database.removeMovie(allTitles.get(num-1));
                    } else if (num >= movieTitles.size() && num <= allTitles.size()) {
                        database.removeShow(allTitles.get(num-1));
                    }

                    return;
                }
            }
        }
    }
   
    /*
        addNewFile() prompts user for .csv file.
        The contents of the csv file is parsed and the contents are added to the database.

        No return value.
        */
    public static void addNewFilePrompt() {
        // Get filename and parse through it
        try {
            System.out.print("Please enter the name of the input file: ");
            String filename = sc.nextLine();
            dataParser = new DataParser(filename);
            database = dataParser.parseCSVFile(); // Operates upon and adds each line to database
        } 
        // Throw error if file does not exist; exitting program...
        catch (FileNotFoundException error) {
            error.printStackTrace();
            System.exit(1);
        }
    }
    
    /*
        modifyExistingTitle() prompts the user for desired title to modify.
        Selections are prompted and must be selected by typing the the full name.

        No return value.
        */
    public static void modifyExistingTitle() {
        // Store all titles into a single array list
        ArrayList<String> showTitles = database.getShowTitles();
        ArrayList<String> movieTitles = database.getMovieTitles();
        ArrayList<String> allTitles = new ArrayList<String>();
        allTitles.addAll(movieTitles);
        allTitles.addAll(showTitles);

        // Display all the titles
        for (int i = 0; i < allTitles.size(); i++) {

            // This function displays the titles
            if (i >= 0 && i < movieTitles.size()) {
                System.out.printf("%d: %s\n", i+1, movieTitles.get(i));
            } else if (i >= movieTitles.size() && i <= allTitles.size()) {
                System.out.printf("%d: %s\n", i+1, showTitles.get(i - movieTitles.size()));
            }

            // During every 10th title shown, prompt the user for their input
            if ((i+1) % 10 == 0) {
                System.out.println("|Hit enter to see more, or type the number of the title you would like to remove|");
                System.out.print("> ");
                String input = sc.nextLine();
                if (input.equals("")) {
                    continue;
                } else {

                    // If a number was selected, then modify the associated number
                    int num = Integer.parseInt(input);

                    // Ask for attribute to change
                    System.out.println("-- Type the attribute you want to change --");
                    System.out.println("title");
                    System.out.println("director");
                    System.out.println("country");
                    System.out.println("genre");
                    System.out.println("id");
                    System.out.println("rating");
                    System.out.println("year");
                    System.out.println("duration");
                    System.out.print("> ");
                    String attribute = sc.nextLine();

                    if (num >= 0 && num < movieTitles.size()) {
                        database.changeMovieAttribute(attribute, allTitles.get(num-1)); // movie
                    } else if (num >= movieTitles.size() && num <= allTitles.size()) {
                        database.changeShowAttribute(attribute, allTitles.get(num-1)); // show
                    }

                    return;
                }
            }
        }
    }
    
    /*
        searchDirector() parses database to display every director.
        The user is prompted to select a director, to which every title associated with the director 
            is displayed.
        */
    public static void searchDirector(String type) {
        int n;
        if (type.equalsIgnoreCase("TV Show")) {
            database.displayShowDirectors();
            System.out.print("> ");
            String director = sc.nextLine();
            
            ArrayList<NetflixShow> showContainer = database.getShowContainer();
            n = showContainer.size();
            for (int i = 0; i < n; i++) {
                if (director.equalsIgnoreCase(showContainer.get(i).getDirector())) {
                    System.out.println(showContainer.get(i).getTitle());
                }
            }
        }
        else if (type.equalsIgnoreCase("Movie")) {
            database.displayMovieDirectors();
            System.out.print("> ");
            String director = sc.nextLine();
            
            ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
            n = movieContainer.size();
            for (int i = 0; i < n; i++) {
                if (director.equalsIgnoreCase(movieContainer.get(i).getDirector())) {
                    System.out.println(movieContainer.get(i).getTitle());
                }
            }
        }
    }

    /*
        searchCountry() parses database to display every country.
        Prompts user to select country, to which every title associated with 
            the country is displayed.
            */
    public static void searchCountry(String type) {
        int n;
        if (type.equalsIgnoreCase("TV Show")) {
            database.displayShowCountries();
            System.out.print("> ");
            String country = sc.nextLine();

            ArrayList<NetflixShow> showContainer = database.getShowContainer();
            n = showContainer.size();
            for (int i = 0; i < n; i++) {
                if (country.equalsIgnoreCase(showContainer.get(i).getCountry())) {
                    System.out.println(showContainer.get(i).getTitle());
                }
            }
        }
        else if (type.equalsIgnoreCase("Movie")) {
            database.displayMovieCountries();
            System.out.print("> ");
            String country = sc.nextLine();

            ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
            n = movieContainer.size();
            for (int i = 0; i < n; i++) {
                if (country.equalsIgnoreCase(movieContainer.get(i).getCountry())) {
                    System.out.println(movieContainer.get(i).getTitle());
                }
            }
        }
    }

    /*
        searchGenre() parses database to display every genre.
        Prompts user to select genre, to which every title associated with 
            the genre is displayed.
            */
    public static void searchGenre(String type) {
        // Display the appropriate genres
        if (type.equalsIgnoreCase("Movie")) {
            database.displayMovieGenres();
        }
        else if (type.equalsIgnoreCase("TV Show")) {
            database.displayShowGenres();
        }
        System.out.println("Please select from the following");
        System.out.print("> ");
        String genre = sc.nextLine();

        // Parsing through movieContainer and showContainer to get desired title
        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        ArrayList<NetflixShow> showContainer = database.getShowContainer();
        
        int n;
        if (type.equalsIgnoreCase("Movie")) {
            n = movieContainer.size();
            for (int i = 0; i < n; i++) {
                if (genre.equalsIgnoreCase(movieContainer.get(i).getGenre())) {
                    System.out.println(movieContainer.get(i).getTitle());
                }
            }
        }
        else if (type.equalsIgnoreCase("TV Show")) {
            n = showContainer.size();
            for (int i = 0; i < n; i++) {
                if (genre.equalsIgnoreCase(showContainer.get(i).getGenre())) {
                    System.out.println(showContainer.get(i).getTitle());
                }
            }
        }
    }

    /*
        searchRating() displays every rating.
        Prompts user to select rating, to which every title associated with 
            the rating is displayed.
            */
    public static void searchRating(String type) {
        System.out.println("Please select from the following ratings (type full word)");
        System.out.println("1. PG-13");
        System.out.println("2. TV-MA");
        System.out.println("3. TV-14");
        System.out.println("4. TV-PG");
        System.out.println("5. TV-Y");
        System.out.println("6. TV-Y7");
        System.out.println("7. R");
        System.out.println("8. TV-G");
        System.out.print("> ");

        String rating;
        int n;
        rating = sc.nextLine();

        // Parsing through movieContainer and showContainer to get desired title
        if (type.equalsIgnoreCase("Movie")) {
            ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
            n = movieContainer.size();
            for (int i = 0; i < n; i++) {
                if (rating.equalsIgnoreCase(movieContainer.get(i).getRating())) {
                    System.out.println(movieContainer.get(i).getTitle());
                }
            }
        }
        else if (type.equalsIgnoreCase("TV Show")) {
            ArrayList<NetflixShow> showContainer = database.getShowContainer();
            n = showContainer.size();
            for (int i = 0; i < n; i++) {
                if (rating.equalsIgnoreCase(showContainer.get(i).getRating())) {
                    System.out.println(showContainer.get(i).getTitle());
                }
            }
        }
    }

    /*
        searchYear()
        Prompts user to select year, to which every title associated with 
            the year (+/- 50 years) is displayed.
            */
    public static void searchYear(String type) {
        System.out.println("Please enter a year: ");
        System.out.println("Program will display years +/- 50 years");

        int year;
        int n;
        year = Integer.parseInt(sc.nextLine());

        int minYear = year - 50;
        int maxYear = year + 50;

        // Display titles with years +/- 50 years
        // Parsing through movieContainer and showContainer to get desired title
        if (type.equalsIgnoreCase("Movie")) {
            ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
            n = movieContainer.size();
            for (int i = 0; i < n; i++) {
                String strYear = movieContainer.get(i).getYear();
                strYear = strYear.replaceAll("[^0-9.]", ""); // Remove all non-numeric characters

                if (strYear.isEmpty()) {
                    strYear = "1950";
                }

                int currYear = Integer.parseInt(strYear);

                if (currYear >= minYear && currYear <= maxYear) {
                    System.out.println(movieContainer.get(i).getTitle());
                }
            }
        } 
        else if (type.equalsIgnoreCase("TV Show")) {
            ArrayList<NetflixShow> showContainer = database.getShowContainer();
            n = showContainer.size();
            for (int i = 0; i < n; i++) {
                String strYear = showContainer.get(i).getYear();
                strYear = strYear.replaceAll("[^0-9.]", ""); // Remove all non-numeric characters

                if (strYear.isEmpty()) {
                    strYear = "1950";
                }

                int currYear = Integer.parseInt(strYear);

                if (currYear >= minYear && currYear <= maxYear) {
                    System.out.println(showContainer.get(i).getTitle());
                }
            }
        }
    }

    /*
        searchMoveDuration() displays a selection of movie ranges.
        Prompts user to select movie range, to which every title associated with 
            the movie range is displayed.
            */
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

        if (selection.equalsIgnoreCase("a")) {
            minTime = 0;
            maxTime = 30;
        } else if (selection.equalsIgnoreCase("b")) {
            minTime = 31;
            maxTime = 60;
        } else if (selection.equalsIgnoreCase("c")) {
            minTime = 61;
            maxTime = 90;
        } else if (selection.equalsIgnoreCase("d")) {
            minTime = 91;
            maxTime = 120;
        } else if (selection.equalsIgnoreCase("e")) {
            minTime = 121;
            maxTime = 150;
        } else if (selection.equalsIgnoreCase("f")) {
            minTime = 151;
            maxTime = 180;
        } else {
            System.out.println("Invalid input> defaulting to 0-30 minutes");
        }
        
        // Parse through movieContainer to find associated title
        ArrayList<NetflixMovie> movieContainer = database.getMovieContainer();
        int n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            String strMin = movieContainer.get(i).getDuration();
            strMin = strMin.replaceAll("[^0-9.]", "");

            // Convert to integer before checking values
            int curr_min;
            if (strMin.isEmpty()) {
                curr_min = 0;
            } else {
                curr_min = Integer.parseInt(strMin);
            }
            
            // Check values
            if (curr_min <= maxTime && curr_min >= minTime) {
                System.out.println(movieContainer.get(i).getTitle());
            }
        }
    }

    /*
        searchShowDuration() displays a selection of show season ranges.
        Prompts user to select season range, to which every title associated with 
            the season range is displayed.
            */
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

        if (selection.equalsIgnoreCase("a")) {
            minSeason = 0;
            maxSeason = 3;
        } else if (selection.equalsIgnoreCase("b")) {
            minSeason = 4;
            maxSeason = 7;
        } else if (selection.equalsIgnoreCase("c")) {
            minSeason = 8;
            maxSeason = 11;
        } else if (selection.equalsIgnoreCase("d")) {
            minSeason = 12;
            maxSeason = 15;
        } else if (selection.equalsIgnoreCase("e")) {
            minSeason = 16;
            maxSeason = 19;
        } else if (selection.equalsIgnoreCase("f")) {
            minSeason = 20;
            maxSeason = 23;
        }

        ArrayList<NetflixShow> showContainer = database.getShowContainer();
        int n = showContainer.size();
        for (int i = 0; i < n; i++) {
            String strSeason = showContainer.get(i).getDuration();
            strSeason = strSeason.replaceAll("[^0-9.]", "");
            
            // Convert to integer before checking values
            int curr_season;
            if (strSeason.isEmpty()) {
                curr_season = 0;
            } else {
                curr_season = Integer.parseInt(strSeason);
            }
            
            // Check values
            if (curr_season <= maxSeason && curr_season >= minSeason) {
                System.out.println(showContainer.get(i).getTitle());
            }
        }
    }

    /*
        searchForTitle() displays a selection of attributes to select.
        Prompts user to select attribute, and the elements
            associated with the attribute are displayed.
            */
    public static void searchForTitle() {
        String type;
        String attribute;

        // Ask user for movie or tv show
        System.out.println("Are you looking for a 'TV Show' or 'Movie'?");
        System.out.print("> ");
        type = sc.nextLine();

        // Search based on attributes
        System.out.println("-- Type the attribute you are searching based on --");
        System.out.printf("title [note: this displays all titles of type %s]\n", type);
        System.out.println("director");
        System.out.println("country");
        System.out.println("genre");
        System.out.println("rating");
        System.out.println("year");
        System.out.println("duration");
        System.out.print("> ");
        attribute = sc.nextLine();

        switch(attribute) {
            case "title":
                ArrayList<String> titles = new ArrayList<String>();
                int int_type = 0;
                if (type.equalsIgnoreCase("TV Show")) { 
                    titles = database.getShowTitles(); 
                }
                else if (type.equalsIgnoreCase("Movie")) { 
                    titles = database.getMovieTitles(); 
                    int_type = 1;
                }

                // Display all the titles
                for (int i = 0; i < titles.size(); i++) {
                    System.out.printf("%d: %s\n", i+1, titles.get(i));
                }
                
                // Prompt user to make selection
                System.out.println("Select number to display title information or 'q' to quit");
                System.out.print("> ");
                String selection = sc.nextLine();
                
                // Quit or convert value to integer
                int num;
                if (selection.equalsIgnoreCase("q")) {
                    return;
                } else {
                    num = Integer.parseInt(selection);
                }

                // Display the information of the selected title
                String title = titles.get(num-1);
                System.out.printf("-- Displaying %s ---\n", title);
                if (int_type == 0) { // TV Show
                    database.displayShowInfo(title);
                } else if (int_type == 1) { // Movie
                    database.displayMovieInfo(title);
                }
                break;
            case "director": 
                searchDirector(type);
                break;
            case "country": 
                searchCountry(type);
                break;
            case "genre": 
                searchGenre(type);
                break;
            case "rating": 
                searchRating(type);
                break;
            case "year": 
                searchYear(type);
                break;
            case "duration": 
                if (type.equalsIgnoreCase("Movie")) {
                    searchMovieDuration();
                } else if (type.equalsIgnoreCase("TV Show")) {
                    searchShowDuration();
                }
                break;
        }
    }

    /*
        mainMenu() prompts the user for select options. 
        */
    public static void mainMenu() {
        System.out.println("\n--- Please enter number to select following options ---");
        System.out.println("1 > Add a title");
        System.out.println("2 > Delete a title");
        System.out.println("3 > Search for a title (displays information)");
        System.out.println("4 > Modify a title");
        System.out.println("5 > Exit program");
        System.out.print("> ");
        int input = Integer.parseInt(sc.nextLine());

        while (input < 1 || input > 5 || input == 5) {
            if (input == 5) {
                System.out.println("Exiting program...");
                System.exit(0);
            }

            System.out.println("Invalid input, please enter a value between (1-5)");
            input = Integer.parseInt(sc.nextLine());
        }
        
        while (input <= 5 || input >= 1) {
            if (input == 5) {
                System.out.println("Exiting program...");
                System.exit(0);
            }

            switch(input) {
                case 1: 
                    System.out.println("--- Adding a new title ---");
                    addNewTitlePrompt();
                    dataParser.UpdateFile(database);
                    break;
                case 2: 
                    System.out.println("--- Deleting a title ---");
                    deleteTitlePrompt(); 
                    dataParser.UpdateFile(database);
                    break;
                case 3: 
                    System.out.println("--- Searching for a title ---");
                    searchForTitle();
                    break;
                case 4: 
                    System.out.println("--- Modifying an existing title ---");
                    modifyExistingTitle();
                    dataParser.UpdateFile(database);
                    break;
            }
            System.out.println("\n--- Please enter number to select following options ---");
            System.out.println("1. Add a title");
            System.out.println("2. Delete a title");
            System.out.println("3. Search for a title (displays information)");
            System.out.println("4. Modify a title");
            System.out.println("5. Exit program");
            System.out.print("> ");
            input = Integer.parseInt(sc.nextLine());
        }
    }

    public static void main(String[] args) {
        addNewFilePrompt();
        mainMenu();
        sc.close();
    }
}
