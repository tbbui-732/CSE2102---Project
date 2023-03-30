import java.util.Scanner;

public class TestNetflix {
  private static NetflixTitleContainers database;
  public static int buildNetflixTitle() {
    // Return  1 for TV SHOW
    // Return  0 for MOVIES 
    // Return -1 for bad answer

    // Get user input
    Scanner sc = new Scanner(System.in);
    System.out.println("Would you like to build a TV Show or a Movie?");
    String selection = sc.nextLine();
    sc.close();

    // Build based on selection
    System.out.printf("Okay, we are going to build a %s\n", selection);

    if (selection == "TV Show") {
      return 1;
    } else if (selection == "Movie") {
      return 0;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    buildNetflixTitle();
  }
}
