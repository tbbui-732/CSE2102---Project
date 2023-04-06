public class NetflixMovies extends NetflixTitle {
    private int minutes;

    public NetflixMovies(
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
    
    setDuration(int minutes) {
        this.minutes = minutes; 
    }

    getDuration() {
        return minutes; 
    }
}
