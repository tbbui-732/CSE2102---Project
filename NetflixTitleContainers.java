import java.util.ArrayList;

public class NetflixTitleContainers {
    private ArrayList<NetflixMovies> movieContainer = new ArrayList<NetflixMovies>();
    private ArrayList<NetflixShows> showContainer = new ArrayList<NetflixShows>();

    public int displayMovieInfo(String movieName) {
        // Return 1 if successful
        //        0 otherwise

        int n = movieContainer.size();

        // Return error if empty
        if (n == 0) {
            System.out.println("Movies database is currently empty");
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (movieName == movieContainer.get(i).getTitle()) {
                // Store information
                String title      = movieContainer.get(i).getTitle();
                String director   = movieContainer.get(i).getDirector();
                String country    = movieContainer.get(i).getCountry();
                String genre      = movieContainer.get(i).getGenre();
                String show_id    = movieContainer.get(i).getID();
                String rating     = movieContainer.get(i).getRating();
                int duration      = movieContainer.get(i).getDuration();

                // Display information
                System.out.printf("Title: %s\n",      title);
                System.out.printf("Director: %s\n",   director);
                System.out.printf("Country: %s\n",    country);
                System.out.printf("Genre: %s\n",      genre);
                System.out.printf("Show ID: %s\n",    show_id);
                System.out.printf("Rating: %s\n",     rating);
                System.out.printf("Duration (in minutes): %d\n",   duration);

                return 1;
            }
        }

        // Movie does not exist in database
        System.out.printf("The movie '%s' does not exist in the database\n", movieName);
        return 0;
    }

    public int displayShowInfo(String showName) {
        // Return 1 if successful
        //        0 otherwise

        int n = showContainer.size();

        // Return error if empty
        if (n == 0) {
            System.out.println("Shows database is currently empty");
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (showName == showContainer.get(i).getTitle()) {
                // Store information
                String title      = showContainer.get(i).getTitle();
                String director   = showContainer.get(i).getDirector();
                String country    = showContainer.get(i).getCountry();
                String genre      = showContainer.get(i).getGenre();
                String show_id    = showContainer.get(i).getID();
                String rating     = showContainer.get(i).getRating();
                int numSeasons    = showContainer.get(i).getNumSeasons();
                int numEpisodes   = showContainer.get(i).getNumEpisodes();

                // Display information
                System.out.printf("Title: %s\n",              title);
                System.out.printf("Director: %s\n",           director);
                System.out.printf("Country: %s\n",            country);
                System.out.printf("Genre: %s\n",              genre);
                System.out.printf("Show ID: %s\n",            show_id);
                System.out.printf("Rating: %s\n",             rating);
                System.out.printf("Number of seasons: %d\n",  numSeasons);
                System.out.printf("Number of episodes: %d\n", numEpisodes);

                return 1;
            }
        }

        // Show does not exist in database
        System.out.printf("The show '%s' does not exist in the database\n", showName);
        return 0;
    }

    // Mutator methods 
    public void addMovie(NetflixMovies movie) {
        movieContainer.add(movie);
    }

    public void addShow(NetflixShows show) {
        showContainer.add(show);
    }

    // Accessor methods
    // Returns null if movie is not found or doesn't exist
    public NetflixMovies getMovie(String title) {
       int n = movieContainer.size();
       for (int i = 0; i < n; i++) {
           if (movieContainer.get(i).getTitle() == title) {
               return movieContainer.get(i);
           }
       }
       return null;
    }

    // Returns null if show is not found or doesn't exist
    public NetflixShows getShow(String title) {
       int n = showContainer.size();
       for (int i = 0; i < n; i++) {
           if (showContainer.get(i).getTitle() == title) {
               return showContainer.get(i);
           }
       }
       return null;
    }

    public boolean titleExists(String title) {
        int n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (movieContainer.get(i).getTitle() == title) {
                return true;
            }
        }
        
        n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (showContainer.get(i).getTitle() == title) {
                return true;
            }
        }

        return false;
    }
}
