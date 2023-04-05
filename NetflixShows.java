public class NetflixShows extends NetflixTitle{
    private int numSeasons;
    public NetflixShows(String initTitle,
            String initDirector,
            String initCountry,
            String initGenre,
            String initShowID,
            String initRating,
            int initNumSeasons)
    {
        super(initTitle, initDirector, initCountry, initGenre, initShowID, initRating);
        numSeasons = initNumSeasons;
    }

    // Mutator methods
    public void setNumSeasons(int newNumSeasons) {
        numSeasons = newNumSeasons;
    }

    // Accessor methods
    public int getNumSeasons() {
        return numSeasons;
    }
}
