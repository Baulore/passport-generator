import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PassportGenerator {
    private static final int amount = 10;

    public static void main(String[] args) throws FileNotFoundException {
        File outputFile = new File("list_of_expired_passports.csv");
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            pw.println("PASSP_SERIES,PASSP_NUMBER");
            List<String> values = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                values.add(String.format("%s,%s", ThreadLocalRandom.current().nextInt(1000, 10000), ThreadLocalRandom.current().nextInt(100000, 1000000)));
            }
            values.stream().distinct().forEach(pw::println);
        }
    }
}
