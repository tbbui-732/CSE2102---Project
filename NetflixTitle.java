public class NetflixTitle {
    // Parent class attributes, associated with both movies and shows
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String country;
    private String release_year;
    private String rating;
    private String genre;

    public NetflixTitle(
            String show_id,
            String type,
            String title,
            String director,
            String country,
            String release_year,
            String rating,
            String genre) 
    {
        this.show_id      = show_id;
        this.type         = type;
        this.title        = title;
        this.director     = director;
        this.country      = country;
        this.release_year = release_year;
        this.rating       = rating;
        this.genre        = genre;
    }

    // Mutator methods
    public void setID(String show_id)         { this.show_id = show_id; }
    public void setType(String type)          { this.type = type; }
    public void setTitle(String title)        { this.title = title; }
    public void setDirector(String director)  { this.director = director; }
    public void setCountry(String country)    { this.country = country; }
    public void setYear(String release_year)  { this.release_year = release_year; }
    public void setRating(String rating)      { this.rating = rating; }
    public void setGenre(String genre)        { this.genre = genre; }

    // Accessor methods
    public String getID()        { return show_id; }
    public String getType()      { return type; }
    public String getTitle()     { return title; }
    public String getDirector()  { return director; }
    public String getCountry()   { return country; }
    public String getYear()      { return release_year; }
    public String getRating()    { return rating; }
    public String getGenre()     { return genre; }
}
