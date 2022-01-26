package visitor.omstulecturesvisitor.Parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class NameAndLinksParser {
    private HashMap<String, String> links = new HashMap<>();

    private void readLinksFile(){
        final Path filePath = Path.of("Links.txt");

        try(InputStream inputStream = Files.newInputStream(filePath)){
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                parse(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void parse(String line) {
        String[] separatedLine = line.split(" ");
        System.out.println(separatedLine[0] + separatedLine[1]);
        links.put(separatedLine[0], separatedLine[1]);
    }

    public HashMap<String, String> getListOfLinks(){
        readLinksFile();
        return links;
    }
}
