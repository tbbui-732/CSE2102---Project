import java.util.Scanner;

public class TestNetflix {
  private static NetflixTitleContainers database;
  public static int buildNetflixTitle() {
    // Return  1 for TV SHOW
    // Return  0 for MOVIES 
    // Return -1 for bad answer

    // Get user input
    Scanner sc = new Scanner(System.in);
    System.out.println("Would you like to build a TV Show or a Movie?");
    String selection = sc.nextLine();
    sc.close();

    // Build based on selection
    System.out.printf("Okay, we are going to build a %s\n", selection);

    if (selection == "TV Show") {
      return 1;
    } else if (selection == "Movie") {
      return 0;
    } else {
      return -1;
    }
  }

  public static void buildTVShow() {
    Scanner sc = new Scanner(System.in); 
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

    System.out.printf("\nEnter show director: ");
    director = sc.nextLine();

    System.out.printf("\nEnter show country: ");
    country = sc.nextLine();

    System.out.printf("\nEnter show genre: ");
    genre = sc.nextLine();

    System.out.printf("\nEnter show ID: ");
    show_id = sc.nextLine();

    System.out.printf("\nEnter show rating: ");
    rating = sc.nextLine();
    sc.close();

    System.out.printf("\nEnter number of seasons: ");
    numSeasons = Integer.parseInt(sc.nextLine());

    System.out.printf("\nEnter number of episodes: ");
    numEpisodes = Integer.parseInt(sc.nextLine());
    
    // Add prompts to database
    NetflixShows show = new NetflixShows(title, director, country, genre, show_id, rating, numSeasons, numEpisodes);
    database.addShow(show);

    // Output TV Show that was just created
    // System.out.printf("Show title: %s", title);
    // System.out.printf("Show director: %s", title);
    // System.out.printf("Show country: %s", title);
    // System.out.printf("Show genre: %s", title);
    // System.out.printf("Show ID: %s", title);
    // System.out.printf("Show rating: %s", title);
    // System.out.printf("Show seasons: %s", title);
    // System.out.printf("Show episodes: %s", title);
    database.displayShowInfo(show.getTitle());
  }

  public static void buildMovie() {
    Scanner sc = new Scanner(System.in); 
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

    System.out.printf("\nEnter movie director: ");
    director = sc.nextLine();

    System.out.printf("\nEnter movie country: ");
    country = sc.nextLine();

    System.out.printf("\nEnter movie genre: ");
    genre = sc.nextLine();

    System.out.printf("\nEnter movie ID: ");
    show_id = sc.nextLine();

    System.out.printf("\nEnter movie rating: ");
    rating = sc.nextLine();
    sc.close();

    System.out.printf("\nEnter movie duration: ");
    duration = Integer.parseInt(sc.nextLine());

    // Store contents of movie into movie database
    NetflixMovies movie = new NetflixMovies(title, director, country, genre, show_id, rating, duration);
    database.addMovie(movie);

    // Output movie that was just created
    // System.out.printf("Movie title: %s",      title);
    // System.out.printf("Movie director: %s",   director);
    // System.out.printf("Movie country: %s",    country);
    // System.out.printf("Movie genre: %s",      genre);
    // System.out.printf("Movie ID: %s",         show_id);
    // System.out.printf("Movie rating: %s",     rating);
    // System.out.printf("Movie duration: %d",   duration);

    database.displayMovieInfo(movie.getTitle());
  }

  public static void main(String[] args) {
    int selection = buildNetflixTitle();
    
    if (selection == 1) { // TV Shows
      buildTVShow();
    } else if (selection == 0) { // Movies
      buildMovie();
    } else { // Error
      System.out.println("Bad input, make sure you answer is either 'TV Show' or 'Movie'\n");
      selection = buildNetflixTitle();
    }
  
  }
}
