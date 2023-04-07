import java.util.ArrayList;
import java.util.Dictionary;

public class NetflixTitleContainer {
    private ArrayList<NetflixMovie> movieContainer = new ArrayList<NetflixMovie>();
    private ArrayList<NetflixShow> showContainer   = new ArrayList<NetflixShow>();
    private ArrayList<String> directors = new ArrayList<String>();
    private ArrayList<String> countries = new ArrayList<String>();
    private ArrayList<String> genres = new ArrayList<String>();


    /*
        displayMovieInfo() displays all the information of a given movie name
        Returns 1 if successful, 0 otherwise 
        */
    public int displayMovieInfo(String movieName) {
        int n = movieContainer.size();

        // Return error if empty
        if (n == 0) {
            System.out.println("Movies database is currently empty");
            return 0;
        }

        // Parse information and store into temporary variables
        for (int i = 0; i < n; i++) {
            if (movieName == movieContainer.get(i).getTitle()) {
                // Store information
                String title      = movieContainer.get(i).getTitle();
                String director   = movieContainer.get(i).getDirector();
                String country    = movieContainer.get(i).getCountry();
                String genre      = movieContainer.get(i).getGenre();
                String show_id    = movieContainer.get(i).getID();
                String rating     = movieContainer.get(i).getRating();
                String duration   = movieContainer.get(i).getDuration();

                // Display information
                System.out.printf("Title: %s\n",      title);
                System.out.printf("Director: %s\n",   director);
                System.out.printf("Country: %s\n",    country);
                System.out.printf("Genre: %s\n",      genre);
                System.out.printf("Show ID: %s\n",    show_id);
                System.out.printf("Rating: %s\n",     rating);
                System.out.printf("Duration (in minutes): %s\n",   duration);

                return 1;
            }
        }

        // Movie does not exist in database
        System.out.printf("The movie '%s' does not exist in the database\n", movieName);
        return 0;
    }
    
    /*
        displayShowInfo() displays show information given a show name
        Returns 1 if successful, 0 otherwise 
        */
    public int displayShowInfo(String showName) {
        int n = showContainer.size();

        // Return error if empty
        if (n == 0) {
            System.out.println("Shows database is currently empty");
            return 0;
        }
        
        // Parse information and store into temporary variables
        for (int i = 0; i < n; i++) {
            if (showName == showContainer.get(i).getTitle()) {
                // Store information
                String title      = showContainer.get(i).getTitle();
                String director   = showContainer.get(i).getDirector();
                String country    = showContainer.get(i).getCountry();
                String genre      = showContainer.get(i).getGenre();
                String show_id    = showContainer.get(i).getID();
                String rating     = showContainer.get(i).getRating();
                String numSeasons   = showContainer.get(i).getDuration();

                // Display information
                System.out.printf("Title: %s\n",              title);
                System.out.printf("Director: %s\n",           director);
                System.out.printf("Country: %s\n",            country);
                System.out.printf("Genre: %s\n",              genre);
                System.out.printf("Show ID: %s\n",            show_id);
                System.out.printf("Rating: %s\n",             rating);
                System.out.printf("Number of seasons: %s\n",  numSeasons);

                return 1;
            }
        }

        // Show does not exist in database
        System.out.printf("The show '%s' does not exist in the database\n", showName);
        return 0;
    }

    /*
        Mutator methods -
        Given a particular Netflix type, store the information into 
            their respective container. 
            */
    public void addMovie(NetflixMovie movie) {
        movieContainer.add(movie);
    }

    public void addShow(NetflixShow show) {
        showContainer.add(show);
    }

    /*
        removeTitle() removes title from database based on given title 
        */
    public void removeTitle(String title) {

        // Parse through both containers and remove the title if they match
        int n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(showContainer.get(i).getTitle())) {
                System.out.printf("Successfully removed %s\n", title);
                showContainer.remove(i);
                return;
            }
        }

        n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(movieContainer.get(i).getTitle())) {
                System.out.printf("Successfully removed %s\n", title);
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
            if (title.equalsIgnoreCase(movieContainer.get(i).getTitle())) {
                return movieContainer.get(i);
            }
        }
        return null;
    }

    // Returns null if show is not found or doesn't exist
    public NetflixShow getShow(String title) {
        int n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(showContainer.get(i).getTitle())) {
                return showContainer.get(i);
            }
        }
        return null;
    }
    
    /*
        Methods to return containers 
        */
    public ArrayList<NetflixMovie> getMovieContainer() {
        return movieContainer;
    }

    public ArrayList<NetflixShow> getShowContainer() {
        return showContainer;
    }
    
    /*
        titleExists() parses through both containers
            and returns TRUE if the title exists. 
            */
    public boolean titleExists(String title) {
        int n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(movieContainer.get(i).getTitle())) {
                return true;
            }
        }

        n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(showContainer.get(i).getTitle())) {
                return true;
            }
        }

        return false;
    }

    /*
        These methods keep track of attributes to be displayed in TestDriver 
        */
    public void addDirector(String director) {
        if (!directors.contains(director)) {
            directors.add(director);  
        }
    }

    public void addCountry(String country) {
        if (!countries.contains(country)) {
            countries.add(country);
        }
    }

    public void addGenre(String genre) {
        if (!genres.contains(genre)) {
            genres.add(genre);
        }
    }
    
    /*
        These methods return the attributes to be displayed 
        */
    public ArrayList<String> getDirectors() {
        return directors;
    }
    
    public ArrayList<String> getCountries() {
        return countries;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
    
    /*
        Build methods that take in respective Netflix title atttributes
            and store them into their respective container, as well
            as updating the containers to be used in TestDriver.
        */
    public void buildMovie(
            String  show_id,
            String  type,
            String  title,
            String  director,
            String  country, 
            String  release_year,
            String  rating,
            String  minutes,
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
            String  release_year,
            String  rating,
            String  seasons,
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
