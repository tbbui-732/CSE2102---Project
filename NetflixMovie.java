public class NetflixMovie extends NetflixTitle {
    private int minutes;

    public NetflixMovie(
            String show_id,
            String type,
            String title,
            String director,
            String country,
            int    release_year,
            String rating,
            int    minutes,
            String genre) 
    {
        super(show_id, type, title, director, country, release_year, rating, genre);
        this.minutes = minutes;
    }
    
    public void setDuration(int minutes) {
        this.minutes = minutes; 
    }

    public int getDuration() {
        return minutes; 
    }
}
