public class Test {
    public static void testCSVParser() {
        String filename = "netflix.csv";
        CSVParser csv = new CSVParser(filename);
        csv.displayCSVFile();
    }

    public static void testContainer() {
        NetflixTitleContainers database = new NetflixTitleContainers();
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
    }
}
