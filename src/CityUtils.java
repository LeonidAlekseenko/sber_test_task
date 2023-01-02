import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class CityUtils {
    public static LinkedList<City> readFile() {
        LinkedList<City> cities = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(new File("src/resources/city.csv"));
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(";", 6);
                if (splitLine[5].isEmpty())
                    cities.add(new City(splitLine[1], splitLine[2], splitLine[3], splitLine[4], null));
                else
                    cities.add(new City(splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void print(LinkedList<City> cities) {
        cities.forEach(System.out::println);
    }
}
