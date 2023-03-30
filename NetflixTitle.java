public class NetflixTitle {
  // Parent class attributes, associated with both movies and shows
  private String title;
  private String director;
  private String country;
  private String genre;
  private String show_id;
  private String rating;

  public NetflixTitle(String initTitle, String initDirector, String initCountry, String initGenre, String initShowID, String initRating) {
    title = initTitle;
    director = initDirector;
    country = initCountry;
    genre = initGenre;
    show_id = initShowID;
    rating = initRating;
  }

  // Mutator methods
  public void changeTitle(String newTitle) {
    title = newTitle;
  }

  public void changeDirector(String newDirector) {
    director = newDirector;
  }

  public void setNewCountry(String newCountry) {
    country = newCountry;
  }

  public void changeGenre(String newGenre) {
    genre = newGenre;
  }

  public void changeShowID(String newID) {
    show_id = newID;
  }

  public void changeRating(String newRating) {
    rating = newRating;
  }

  // Accessor methods
  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public String getCountry() {
    return country;
  }

  public String getGenre() {
    return genre;
  }

  public String getID() {
    return show_id;
  }

  public String getRating() {
    return rating;
  }
}
