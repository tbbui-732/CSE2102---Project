public class NetflixTitle {
  // Parent class attributes, associated with both movies and shows
  private String title;
  private String director;
  private String countries[]; 
  private String genre;
  private String show_id;
  private String rating;

  public NetflixTitle(String initTitle, String initDirector, String initCountries[], String initGenre, String initShowID, string initRating) {
    title = initTitle;
    director = initDirector;
    countries = initCountries;
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

  public void addCountry(String newCountry) {

  }

  public void removeCountry(String countryToRemove) {

  }

  public void setNewCountries(String newCountries[]) {

  }

  // Accessor methods
  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public String getCountries() {
    return countries;
  }

  public String getGenre() {
    return genre;
  }

  public String getID() {
    return show_id;
  }

  public string getRating() {
    return rating;
  }
}
