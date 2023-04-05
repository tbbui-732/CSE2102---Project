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
        String title;
        String director;
        String country;
        String genre;
        String show_id;
        String rating;
        int numSeasons;
        int numEpisodes;

        // Prompt attributes

        System.out.printf("Enter show title: ");
        title = sc.nextLine();

        System.out.printf("Enter show director: ");
        director = sc.nextLine();

        System.out.printf("Enter show country: ");
        country = sc.nextLine();

        System.out.printf("Enter show genre: ");
        genre = sc.nextLine();

        System.out.printf("Enter show ID: ");
        show_id = sc.nextLine();

        System.out.printf("Enter show rating: ");
        rating = sc.nextLine();

        System.out.printf("Enter number of seasons: ");
        numSeasons = Integer.parseInt(sc.nextLine());

        System.out.printf("Enter number of episodes: ");
        numEpisodes = Integer.parseInt(sc.nextLine());

        // Add prompts to database
        NetflixShows newShow = new NetflixShows(title, director, country, genre, show_id, rating, numSeasons, numEpisodes);
        show = newShow;
        database.addShow(newShow);

        // Output TV Show that was just created
        System.out.println("\n-- Show information --");
        database.displayShowInfo(show.getTitle());
        System.out.println("");
    }

    public static void buildMovie() {
        String title;
        String director;
        String country;
        String genre;
        String show_id;
        String rating;
        int duration;

        // Prompt attributes

        System.out.printf("Enter movie title: ");
        title = sc.nextLine();

        System.out.printf("Enter movie director: ");
        director = sc.nextLine();

        System.out.printf("Enter movie country: ");
        country = sc.nextLine();

        System.out.printf("Enter movie genre: ");
        genre = sc.nextLine();

        System.out.printf("Enter movie ID: ");
        show_id = sc.nextLine();

        System.out.printf("Enter movie rating: ");
        rating = sc.nextLine();

        System.out.printf("Enter movie duration: ");
        duration = Integer.parseInt(sc.nextLine());

        // Store contents of movie into movie database
        NetflixMovies newMovie = new NetflixMovies(title, director, country, genre, show_id, rating, duration);
        movie = newMovie;
        database.addMovie(newMovie);

        // Output movie that was just created
        System.out.println("\n-- Movie information --");
        database.displayMovieInfo(movie.getTitle());
        System.out.println("");
    }

    public static void changeMovieAttribute(String attribute) {
        String input;
        switch(attribute) {
            case "title":
                System.out.printf("Old title: %s\n", movie.getTitle());
                System.out.printf("Enter new title: ");
                input = sc.nextLine();
                movie.changeTitle(input);
                System.out.printf("New title: %s\n", movie.getTitle());
                break;
            case "director":
                System.out.printf("Old director: %s\n", movie.getDirector());
                System.out.printf("Enter new director: ");
                input = sc.nextLine();
                movie.changeDirector(input);
                System.out.printf("New director: %s\n", movie.getDirector());
                break;
            case "country":
                System.out.printf("Old country: %s\n", movie.getCountry());
                System.out.printf("Enter new country: ");
                input = sc.nextLine();
                movie.setNewCountry(input);
                System.out.printf("New country: %s\n", movie.getCountry());
                break;
            case "genre":
                System.out.printf("Old genre: %s\n", movie.getGenre());
                System.out.printf("Enter new genre: ");
                input = sc.nextLine();
                movie.changeGenre(input);
                System.out.printf("New genre: %s\n", movie.getGenre());
                break;
            case "id":
                System.out.printf("Old show ID: %s\n", movie.getID());
                System.out.printf("Enter new show id: ");
                input = sc.nextLine();
                movie.changeShowID(input);
                System.out.printf("New show ID: %s\n", movie.getID());
                break;
            case "rating":
                System.out.printf("Old rating: %s\n", movie.getRating());
                System.out.printf("Enter new rating: ");
                input = sc.nextLine();
                movie.changeRating(input);
                System.out.printf("New rating: %s\n", movie.getRating());
                break;
            case "duration":
                System.out.printf("Old duration: %d\n", movie.getDuration());
                System.out.printf("Enter new duration (in minutes): ");
                input = sc.nextLine();
                movie.setDuration(Integer.parseInt(input));
                System.out.printf("New duration: %d\n", movie.getDuration());
                break;
            case "seasons":
                System.out.println("> (!) Can not change show attribute for movie object\n> (!) No changes have been made");
                break;
            case "episodes":
                System.out.println("> (!) Can not change show attribute for movie object\n> (!) No changes have been made");
                break;
        }
    }

    public static void changeShowAttribute (String attribute) {
        String input;
        switch(attribute) {
            case "title":
                System.out.printf("Old title: %s\n", show.getTitle());
                System.out.printf("Enter new title: ");
                input = sc.nextLine();
                show.changeTitle(input);
                System.out.printf("New title: %s\n", show.getTitle());
                break;
            case "director":
                System.out.printf("Old director: %s\n", show.getDirector());
                System.out.printf("Enter new director: ");
                input = sc.nextLine();
                show.changeDirector(input);
                System.out.printf("New director: %s\n", show.getDirector());
                break;
            case "country":
                System.out.printf("Old country: %s\n", show.getCountry());
                System.out.printf("Enter new country: ");
                input = sc.nextLine();
                show.setNewCountry(input);
                System.out.printf("New country: %s\n", show.getCountry());
                break;
            case "genre":
                System.out.printf("Old genre: %s\n", show.getGenre());
                System.out.printf("Enter new genre: ");
                input = sc.nextLine();
                show.changeGenre(input);
                System.out.printf("New genre: %s\n", show.getGenre());
                break;
            case "id":
                System.out.printf("Old show ID: %s\n", show.getID());
                System.out.printf("Enter new id: ");
                input = sc.nextLine();
                show.changeShowID(input);
                System.out.printf("New show ID: %s\n", show.getID());
                break;
            case "rating":
                System.out.printf("Old rating: %s\n", show.getRating());
                System.out.printf("Enter new rating: ");
                input = sc.nextLine();
                show.changeRating(input);
                System.out.printf("New rating: %s\n", show.getRating());
                break;
            case "duration":
                System.out.println("> (!) Can not change a movie attribute for a show object\n> (!) No changes have been made...");
                break;
            case "seasons":
                System.out.printf("Old seasons: %d\n", show.getNumSeasons());
                System.out.printf("Enter new number of seasons: ");
                input = sc.nextLine();
                show.setNumSeasons(Integer.parseInt(input));
                System.out.printf("New seasons: %d\n", show.getNumSeasons());
                break;
            case "episodes": 
                System.out.printf("Old episodes: %d\n", show.getNumEpisodes());
                System.out.printf("Enter new number of episodes: ");
                input = sc.nextLine();
                show.setNumEpisodes(Integer.parseInt(input));
                System.out.printf("New episodes: %d\n", show.getNumEpisodes());
                break;
        }
    }

    public static void main(String[] args) {

        // Get filename and parse through it
        try {
            System.out.print("Please enter the name of the input file: ");
            String filename = sc.nextLine();
            CSVParser csvParser = new CSVParser(filename);
            csvParser.parseCSVFile(); // Operates upon and adds each line to database
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
        //System.out.println(answer);

        if (answer.equals("yes")) {
            // Change attribute
            System.out.println("Choose the attribute you want to change (type the full name) --");
            System.out.println("1 > title");
            System.out.println("2 > director");
            System.out.println("3 > country");
            System.out.println("4 > genre");
            System.out.println("5 > id");
            System.out.println("6 > rating");
            System.out.println("7 (movies only) > duration");
            System.out.println("8 (shows only)  > seasons");
            System.out.println("9 (shows only)  > episodes");
            System.out.print("> ");

            String attribute = sc.nextLine();
            System.out.println("\n-- Updating information --");

            if (selection == 1) { // TV SHOW
                changeShowAttribute(attribute); 
                System.out.println("\n-- Updated show information --");
                database.displayShowInfo(show.getTitle());
            } else if (selection == 0) { // MOVIES
                changeMovieAttribute(attribute);
                System.out.println("\n-- Updated movie information --");
                database.displayMovieInfo(movie.getTitle());
            }

        }
        sc.close();
    }
}
