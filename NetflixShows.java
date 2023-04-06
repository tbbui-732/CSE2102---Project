public class NetflixShows extends NetflixTitle{
    private int seasons;

    public NetflixShows(
            String show_id,
            String type,
            String title,
            String director,
            String country,
            int    release_year,
            String rating,
            int    seasons,
            String genre) 
    {
        super(show_id, type, title, director, country, release_year, rating, genre);
        this.seasons = seasons;
    }

    setDuration(int seasons) {
        this.seasons = seasons;
    }

    getDuration() {
        return seasons;
    }
}
