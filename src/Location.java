import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Location {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("file1.txt");
        Scanner scanner = new Scanner(file).useDelimiter("\n");
        String lines = scanner.next();
        String newLine = lines.substring(0, 5) + lines.substring(5);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newLine);
            writer.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Map<String,String> variableMap = fillMap();
		Path path = Paths.get("file1.txt");
		Stream<String> lined;
		try {
			lined = Files.lines(path,Charset.forName("UTF-8"));
			List<String> replacedLines = lined.map(line -> replaceTag(line,variableMap))
                    .collect(Collectors.toList());
			Files.write(path, replacedLines, Charset.forName("UTF-8"));
			lined.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static Map<String,String> fillMap() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Word to find: ");
        String wordToFind = reader.nextLine();
        System.out.print("Word to replace: ");
        String replaceWord  = reader.nextLine();


		Map<String,String> map = new HashMap<String,String>();
		map.put(wordToFind, replaceWord);
		return map;
	}
	private static String replaceTag(String str, Map<String,String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (str.contains(entry.getKey())) {
				str = str.replace(entry.getKey(), entry.getValue());
			}
		}
		return str;
	}

}
