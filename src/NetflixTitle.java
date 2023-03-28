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
    // Create a new array for countries
    int n = countries.length; 
    String newCountries[] = new String[n+1];

    // Copy values of old array to new array
    for (int i = 0; i < n; i++) {
      newCountries[i] = countries[i];
    }

    // Add new country
    newCountries[n] = newCountry;
    countries = newCountries;
  }

  public void removeCountry(String countryToRemove) {
    // Make sure countryToRemove exists
    int n = countries.length;
    boolean exists = false;
    for (int i = 0; i < n; i++) {
      if (countries[i] == countryToRemove) {
        exists = true;
        break;
      }
    }

    if (!exists) {
      System.out.println("The attribute supplied does not exist"); 
      return;
    }

    // Create a new array for countries
    String newCountries[] = new String[n-1];

    // Copy values except the country to be removed
    int new_i = 0;
    int old_i = 0;

    while (old_i < n) {
      if (countries[old_i] != countryToRemove) {
        newCountries[new_i] = countries[old_i];
        new_i++;
        old_i++;
      }
      else {
        old_i++;
      }
    }

    // Set country to newCountries
    countries = newCountries;
  }

  public void setNewCountries(String newCountries[]) {
    countries = newCountries;
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
