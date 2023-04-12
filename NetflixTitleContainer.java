import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Collections;
import java.util.Scanner;

public class NetflixTitleContainer {
    private ArrayList<NetflixMovie> movieContainer = new ArrayList<NetflixMovie>();
    private ArrayList<NetflixShow> showContainer   = new ArrayList<NetflixShow>();
    private Scanner sc = new Scanner(System.in);

    /*
        displayMovieInfo() displays all the information of a given movie name
        */
    public void displayMovieInfo(String movieName) {
        int n = movieContainer.size();

        // Parse information and store into temporary variables
        for (int i = 0; i < n; i++) {
            if (movieName.equalsIgnoreCase(movieContainer.get(i).getTitle())) {
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
            }
        }

        // Movie does not exist in database
        System.out.printf("The movie '%s' does not exist in the database\n", movieName);
    }
    
    /*
        displayShowInfo() displays show information given a show name
        */
    public void displayShowInfo(String showName) {
        int n = showContainer.size();

        // Parse information and store into temporary variables
        for (int i = 0; i < n; i++) {
            if (showName.equalsIgnoreCase(showContainer.get(i).getTitle())) {
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
            }
        }

        // Show does not exist in database
        System.out.printf("The show '%s' does not exist in the database\n", showName);
    }

    /*
        Given an attribute, display the names of those
            attributes from every movie or show
    */
    public void displayShowDirectors() {
        int num_show = showContainer.size();
        ArrayList<String> directors = new ArrayList<String>();
        
        // Get all directors
        //      Skip duplicates
        for (int i = 0; i < num_show; i++) {
            String director = showContainer.get(i).getDirector();

            if (!directors.contains(director)) {
                directors.add(director);
            }
        }

        // Sort the directors in alphabetical order
        Collections.sort(directors);

        // Display all directors
        for (int i = 0; i < directors.size(); i++) {
            System.out.println(directors.get(i));
        }
    }

    public void displayMovieDirectors() {
        int num_show = movieContainer.size();
        ArrayList<String> directors = new ArrayList<String>();
        
        // Get all directors
        //      Skip duplicates
        for (int i = 0; i < num_show; i++) {
            String director = movieContainer.get(i).getDirector();

            if (!directors.contains(director)) {
                directors.add(director);
            }
        }

        // Sort the directors in alphabetical order
        Collections.sort(directors);

        // Display all directors
        for (int i = 0; i < directors.size(); i++) {
            System.out.println(directors.get(i));
        }
    }

    public void displayShowCountries() {
        int num_countries = showContainer.size();
        ArrayList<String> countries = new ArrayList<String>();

        // Get all countries
        //      Skip duplicates
        for (int i = 0; i < num_countries; i++) {
            String country = showContainer.get(i).getCountry();

            if (!countries.contains(country)) {
                countries.add(country);
            }
        }

        // Sort the countries in alphabetical order
        Collections.sort(countries);

        // Display all countries
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }

    public void displayMovieCountries() {
        int num_countries = movieContainer.size();
        ArrayList<String> countries = new ArrayList<String>();

        // Get all countries
        //      Skip duplicates
        for (int i = 0; i < num_countries; i++) {
            String country = movieContainer.get(i).getCountry();

            if (!countries.contains(country)) {
                countries.add(country);
            }
        }

        // Sort the countries in alphabetical order
        Collections.sort(countries);

        // Display all countries
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }

    public void displayShowGenres() {
        int num_genres = showContainer.size();
        ArrayList<String> genres = new ArrayList<String>();

        // Get all genres
        //      Skip duplicates
        for (int i = 0; i < num_genres; i++) {
            String genre = showContainer.get(i).getGenre();

            if (!genres.contains(genre)) {
                genres.add(genre);
            }
        }

        // Sort the genres in alphabetical order
        Collections.sort(genres);

        // Display all genres
        for (int i = 0; i < genres.size(); i++) {
            System.out.println(genres.get(i));
        }
    }

    public void displayMovieGenres() {
        int num_genres = movieContainer.size();
        ArrayList<String> genres = new ArrayList<String>();

        // Get all genres
        //      Skip duplicates
        for (int i = 0; i < num_genres; i++) {
            String genre = movieContainer.get(i).getGenre();

            if (!genres.contains(genre)) {
                genres.add(genre);
            }
        }

        // Sort the genres in alphabetical order
        Collections.sort(genres);

        // Display all genres
        for (int i = 0; i < genres.size(); i++) {
            System.out.println(genres.get(i));
        }
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
       Allows the user to select a particular movie attribute to modify
       No return value
       */
    public void changeMovieAttribute(String attribute, String title) {
        NetflixMovie movie = getMovie(title);
        removeMovie(title);

        System.out.printf("Modifying %s\n", attribute);
        String input = sc.nextLine();
        switch(attribute) {
            case "id": 
                movie.setID(input);
                break;
            case "title": 
                movie.setTitle(input);
                break;
            case "director":
                movie.setDirector(input);
                break;
            case "country":
                movie.setCountry(input);
                break;
            case "year":
                movie.setYear(input);
                break;
            case "rating":
                movie.setRating(input);
                break;
            case "seasons":
                movie.setDuration(input);
                break;
            case "genre":
                movie.setGenre(input);
                break;
        }

        addMovie(movie);
        System.out.printf("Successfully modified %s\n", attribute);
    }

    /*
       Allows the user to select a particular show attribute to modify
       No return value
       */
    public void changeShowAttribute(String attribute, String title) {
        NetflixShow show = getShow(title);
        removeShow(title);

        System.out.printf("Modifying %s\n", attribute);
        String input = sc.nextLine();
        switch(attribute) {
            case "id": 
                show.setID(input);
                break;
            case "title": 
                show.setTitle(input);
                break;
            case "director":
                show.setDirector(input);
                break;
            case "country":
                show.setCountry(input);
                break;
            case "year":
                show.setYear(input);
                break;
            case "rating":
                show.setRating(input);
                break;
            case "seasons":
                show.setDuration(input);
                break;
            case "genre":
                show.setGenre(input);
                break;
        }

        addShow(show);
        System.out.printf("Successfully modified %s\n", attribute);
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
