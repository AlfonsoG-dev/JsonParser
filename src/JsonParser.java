
import java.io.File;

import Application.Operations.FileOperations;

class JsonParser {
    public static void main(String[] args) {
        String fileName = "./docs/json_sample.json";
        FileOperations p = new FileOperations("." + File.separator);

        p.setReadingPath(fileName);

        p.getJsonTypes()
            .forEach(System.out::println);
    }
}
