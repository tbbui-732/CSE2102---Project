public class NetflixMovies extends NetflixTitle {
  private int duration;
  public NetflixMovies(String initTitle,
                      String initDirector,
                      String initCountries[],
                      String initGenre,
                      String initShowID,
                      String initRating,
                      int initDuration) 
  {
    super(initTitle, initDirector, initCountries, initGenre, initShowID, initRating);
    duration = initDuration;
  }

  // Mutator methods
  public void setDuration(int newDuration) {
    duration = newDuration;
  }

  // Accessor methods
  public int getDuration() {
    return duration;
  }
}