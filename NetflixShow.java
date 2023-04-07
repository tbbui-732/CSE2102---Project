public class NetflixShow extends NetflixTitle{
    private String seasons;

    public NetflixShow(
            String show_id,
            String type,
            String title,
            String director,
            String country,
            String release_year,
            String rating,
            String seasons,
            String genre) 
    {
        super(show_id, type, title, director, country, release_year, rating, genre);
        this.seasons = seasons;
    }

    public void setDuration(String seasons) {
        this.seasons = seasons;
    }

    public String getDuration() {
        return seasons;
    }
}
