import java.util.ArrayList;
import java.util.Dictionary;

public class NetflixTitleContainer {
    private ArrayList<NetflixMovie> movieContainer = new ArrayList<NetflixMovie>();
    private ArrayList<NetflixShow> showContainer   = new ArrayList<NetflixShow>();
    private ArrayList<String> directors = new ArrayList<String>();
    private ArrayList<String> countries = new ArrayList<String>();
    private ArrayList<String> genres = new ArrayList<String>();

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
                int numSeasons    = showContainer.get(i).getDuration();

                // Display information
                System.out.printf("Title: %s\n",              title);
                System.out.printf("Director: %s\n",           director);
                System.out.printf("Country: %s\n",            country);
                System.out.printf("Genre: %s\n",              genre);
                System.out.printf("Show ID: %s\n",            show_id);
                System.out.printf("Rating: %s\n",             rating);
                System.out.printf("Number of seasons: %d\n",  numSeasons);

                return 1;
            }
        }

        // Show does not exist in database
        System.out.printf("The show '%s' does not exist in the database\n", showName);
        return 0;
    }

    // Mutator methods 
    public void addMovie(NetflixMovie movie) {
        movieContainer.add(movie);
    }

    public void addShow(NetflixShow show) {
        showContainer.add(show);
    }

    public void removeTitle(String title) {
        // Check showContainer first
        int n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(showContainer.get(i).getTitle())) {
                showContainer.remove(i);
                return;
            }
        }

        // Then check movieContainer
        n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(movieContainer.get(i).getTitle())) {
                movieContainer.remove(i);                
                return;
            }
        }
    }

    // Accessor methods
    // Returns null if movie is not found or doesn't exist
    public NetflixMovie getMovie(String title) {
        int n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (movieContainer.get(i).getTitle() == title) {
                return movieContainer.get(i);
            }
        }
        return null;
    }

    // Returns null if show is not found or doesn't exist
    public NetflixShow getShow(String title) {
        int n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (showContainer.get(i).getTitle() == title) {
                return showContainer.get(i);
            }
        }
        return null;
    }

    public ArrayList<NetflixMovie> getMovieContainer() {
        return movieContainer;
    }

    public ArrayList<NetflixShow> getShowContainer() {
        return showContainer;
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

    // Build methods
    // NOTE: These currently store duplicate values
    public void addDirector(String director) {
        directors.add(director);  
    }

    public void addCountry(String country) {
        countries.add(country);
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }

    public ArrayList<String> getDirectors() {
        return directors;
    }
    
    public ArrayList<String> getCountries() {
        return countries;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void buildMovie(
            String  show_id,
            String  type,
            String  title,
            String  director,
            String  country, 
            int     release_year,
            String  rating,
            int     minutes,
            String  genre)
    {
        NetflixMovie movie = new NetflixMovie(
                show_id,
                type,
                title,
                director,
                country,
                release_year,
                rating,
                minutes,
                genre
                );

        movieContainer.add(movie);
        addDirector(director);
        addCountry(country);
        addGenre(genre);
    }

    public void buildShow(
            String  show_id,
            String  type,
            String  title,
            String  director,
            String  country, 
            int     release_year,
            String  rating,
            int     seasons,
            String  genre)
    {
        NetflixShow show = new NetflixShow(
                show_id,
                type,
                title,
                director,
                country,
                release_year,
                rating,
                seasons,
                genre
                );

        showContainer.add(show);
        addDirector(director);
        addCountry(country);
        addGenre(genre);
    }
}
