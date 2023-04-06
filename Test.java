import java.io.FileNotFoundException;

public class Test {
    private static NetflixTitleContainers database = new NetflixTitleContainers();
    public static void testCSVParser() {
        String filename = "netflix.csv";

        try {
            CSVParser csv = new CSVParser(filename);
            csv.parseCSVFile();
        } catch (FileNotFoundException error) {
            error.printStackTrace();
            System.exit(1);
        }

    }

    public static void testContainer() {
        NetflixMovies movie = new NetflixMovies(
            "title",
            "director",
            "country",
            "genre",
            "id",
            "rating",
            120
        );

        NetflixShows show = new NetflixShows(
            "title",
            "director",
            "country",
            "genre",
            "id",
            "rating",
            10,
            5
        );
        
        database.addMovie(movie);
        database.addShow(show);

        database.displayMovieInfo("title");
        System.out.println("");
        database.displayShowInfo("title");
    }

    public static void main(String[] args) {
        testContainer();
        System.out.println(database.titleExists("title"));
        System.out.println(database.titleExists("tle"));
    }
}
