import java.util.ArrayList;
import java.util.Dictionary;

public class NetflixTitleContainer {
    private ArrayList<NetflixMovie> movieContainer = new ArrayList<NetflixMovie>();
    private ArrayList<NetflixShow> showContainer   = new ArrayList<NetflixShow>();

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
        Removal methods
        Wipes title from database
        */
    public void removeMovie(String title) {
        int n = movieContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(movieContainer.get(i).getTitle())) {
                movieContainer.remove(i);
                System.out.printf("Successfully removed %s\n", title);
                return;
            }
        }
        System.out.printf("%s does not exist", title);
    }

    public void removeShow(String title) {
        int n = showContainer.size();
        for (int i = 0; i < n; i++) {
            if (title.equalsIgnoreCase(showContainer.get(i).getTitle())) {
                showContainer.remove(i);
                System.out.printf("Successfully removed %s\n", title);
                return;
            }
        }
        System.out.printf("%s does not exist", title);
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
        Build methods that take in respective Netflix title atttributes
            and store them into their respective container, as well
            as updating the containers to be used in TestDriver.

        The attributes are NOT asked for here.
        */
    public void buildMovieWithoutPrompt(
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
        // Build new movie
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
        
        // Store movie into database
        movieContainer.add(movie);
    }

    public void buildTVShowWithoutPrompt(
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
        // Build new show
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

        // Store show into database
        showContainer.add(show);
    }

    /*
        Build methods that take in respective Netflix title atttributes
            and store them into their respective container, as well
            as updating the containers to be used in TestDriver.

        The attributes ARE asked for here.
        */
    public void buildMovieWithPrompt() {
        // Temporary values
        String  t_show_id;
        String  t_type = "Movie";
        String  t_title;
        String  t_director;
        String  t_country;
        String  t_release_year;
        String  t_rating;
        String  t_minutes;
        String  t_genre;

        // Prompt attributes
        System.out.print("Show ID: ");            t_show_id      = sc.nextLine();
        System.out.print("Title: ");              t_title        = sc.nextLine();
        System.out.print("Director: ");           t_director     = sc.nextLine();
        System.out.print("Country/Countries: ");  t_country      = sc.nextLine();
        System.out.print("Release year: ");       t_release_year = sc.nextLine();
        System.out.print("Rating: ");             t_rating       = sc.nextLine();
        System.out.print("Duration: ");           t_minutes      = sc.nextLine();
        System.out.print("Genre: ");              t_genre        = sc.nextLine();

        NetflixMovie movie = new NetflixMovie(
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

        movieContainer.add(movie);
    }

    public void buildTVShowWithPrompt() {
        // Temporary values
        String  t_show_id;
        String  t_type = "TV Show";
        String  t_title;
        String  t_director;
        String  t_country;
        String  t_release_year;
        String  t_rating;
        String  t_seasons;
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

        // Build show
        NetflixShow show = new NetflixShow(
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

        // Store show into container
        showContainer.add(show);
    }
}
