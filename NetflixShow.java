public class NetflixShow extends NetflixTitle{
    private int seasons;

    public NetflixShow(
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

    public void setDuration(int seasons) {
        this.seasons = seasons;
    }

    public int getDuration() {
        return seasons;
    }
}
