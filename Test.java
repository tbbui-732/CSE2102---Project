import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        try {
            CSVParser parser = new CSVParser("netflix.csv");
        } catch (FileNotFoundException error) {
            error.printStackTrace();
            System.exit(1);
        }
    }
}

