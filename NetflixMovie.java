public class NetflixMovie extends NetflixTitle {
    private String minutes;

    public NetflixMovie(
            String show_id,
            String type,
            String title,
            String director,
            String country,
            String release_year,
            String rating,
            String minutes,
            String genre) 
    {
        super(show_id, type, title, director, country, release_year, rating, genre);
        this.minutes = minutes;
    }
    
    public void setDuration(String minutes) {
        this.minutes = minutes; 
    }

    public String getDuration() {
        return minutes; 
    }
}
