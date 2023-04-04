public class NetflixShows extends NetflixTitle{
    private int numSeasons;
    private int numEpisodes;
    public NetflixShows(String initTitle,
            String initDirector,
            String initCountry,
            String initGenre,
            String initShowID,
            String initRating,
            int initNumSeasons,
            int initNumEpisodes)
    {
        super(initTitle, initDirector, initCountry, initGenre, initShowID, initRating);
        numSeasons = initNumSeasons;
        numEpisodes = initNumEpisodes;
    }

    // Mutator methods
    public void setNumSeasons(int newNumSeasons) {
        numSeasons = newNumSeasons;
    }

    public void setNumEpisodes(int newNumEpisodes) {
        numEpisodes = newNumEpisodes;
    }

    // Accessor methods
    public int getNumSeasons() {
        return numSeasons;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }
}
