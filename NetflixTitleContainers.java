public class NetflixTitleContainers {
  private static NetflixMovies moviesContainer[];
  private static NetflixShows showsContainer[];
  
  // -- Display method --
  public static int displayMovieInfo(String movieName) {
    // Return 1 if successful
    //        0 otherwise

    int n = moviesContainer.length;
    
    // Return error if empty
    if (n == 0) {
      System.out.println("Movies database is currently empty");
      return 0;
    }

    for (int i = 0; i < n; i++) {
      if (movieName == moviesContainer[i].getTitle()) {
        // Store information
        String title      = moviesContainer[i].getTitle();
        String director   = moviesContainer[i].getDirector();
        String country  = moviesContainer[i].getCountry();
        String genre      = moviesContainer[i].getGenre();
        String show_id    = moviesContainer[i].getID();
        String rating     = moviesContainer[i].getRating();
        int duration      = moviesContainer[i].getDuration();

        // Display information
        System.out.printf("Title: %s\n",      title);
        System.out.printf("Director: %s\n",   director);
        System.out.printf("Country: %s\n",    country);
        System.out.printf("Genre: %s\n",      genre);
        System.out.printf("Show ID: %s\n",    show_id);
        System.out.printf("Rating: %s\n",     rating);
        System.out.printf("Duration: %d\n",   duration);

        return 1;
      }
    }

    // Movie does not exist in database
    System.out.printf("The movie '%s' does not exist in the database\n", movieName);
    return 0;
  }

  // Mutator methods
  public static void addMovie(NetflixMovies movie) {
    int n = moviesContainer.length;
    NetflixMovies newMoviesContainer[] = NetflixMovies[n+1];

    for (int i = 0; i < n; i++) {
      newMoviesContainer[i] = moviesContainer[i];
    }

    newMoviesContainer[n] = movie;

    moviesContainer = newMoviesContainer;
  }
  
  // TODO: implement this method
  public static void addShow() {
    
  }

}
