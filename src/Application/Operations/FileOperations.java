package Application.Operations;

import java.util.ArrayList;
import java.util.List;

import Application.Utils.FileUtils;
import Application.Utils.JsonUtils;
import Application.Utils.JsonTypes;

/*
 * TODO: get the json values when split by *:*.
 *   - and get recursively the values that starts with *{* open bracees.
 *   - the values that start with an open tag must show that and the close one to
 */
public class FileOperations {

    private FileUtils fileUtils;
    private JsonUtils jsonUtils;
    private String readingFilePath;
    private List<String> fileLines;

    /**
     * With this constructor you also need to initialize the variables using setReadingPath methods from this class.
     */
    public FileOperations(String rootPath) {
        fileUtils = new FileUtils(rootPath);
        jsonUtils = new JsonUtils();
    }

    public FileOperations(String rootPath, String readingPath) {
        fileUtils = new FileUtils(rootPath);
        jsonUtils = new JsonUtils();
        this.readingFilePath = readingPath;
        fileLines = fileUtils.getFileLines(readingPath);
    }

    /**
     * Initializes the file path to read lines and also initializes the list of file lines.
     *  If you don't give the reading path in the constructor use this method to initializes those variables.
     */
    public void setReadingPath(String filePath) {
        this.readingFilePath = filePath;
        fileLines = fileUtils.getFileLines(readingFilePath);
    }

    public List<String> getJsonKeys() {
        List<String> keys = new ArrayList<>();
        for(int i=0; i<fileLines.size(); ++i) {
            String[] json_lines = fileLines.get(i).trim().split(":");
            if(json_lines[0].startsWith("\"")) {
                keys.add(json_lines[0].replace("\"", ""));
            }
        }
        return keys;
    }
    public List<JsonTypes> getJsonTypes() {
        List<JsonTypes> types = new ArrayList<>();
        for(int i=0; i<fileLines.size(); ++i) {
            String[] json_lines = fileLines.get(i).trim().split(":");
            if(json_lines.length == 2) {
                types.add(jsonUtils.getJsonType(json_lines[1].trim()));
            }
        }
        return types;
    }
    public List<String> getJsonValues() {
        List<String> values = new ArrayList<>();
        for(int i=0; i<fileLines.size(); ++i) {
            String[] json_lines = fileLines.get(i).trim().split(":");
            // TODO: get the multiline value
            if(json_lines.length == 2) {
                values.add(json_lines[1].trim());
            } else {
                // TODO: implement object and list of values
            }
        }
        return values;
    }
}
