import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Location {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("file1.txt");
        Scanner scanner = new Scanner(file).useDelimiter("\n");
        String line = scanner.next();
        String newLine = line.substring(0, 5) + line.substring(5);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newLine);
            writer.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
