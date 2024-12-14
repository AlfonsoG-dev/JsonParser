
import java.io.File;

import Utils.FileUtils;

class JsonParser {
    public static void main(String[] args) {
        String fileName = "./docs/json_sample.json";
        FileUtils fu = new FileUtils("." + File.separator);
        fu.getFileLines(fileName)
            .forEach(System.out::println);
    }
}
