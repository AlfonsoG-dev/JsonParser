package Application.Utils;

public class JsonUtils {

    public String getJsonType(String sentence) {
        if(sentence.startsWith("\"")) {
            return "String";
        } else if(sentence.startsWith("[")) {
            return "List";
        } else if(sentence.startsWith("{")) {
            return "Object";
        } else if(sentence.equals("true") || sentence.equals("false")) {
            return "Boolean";
        } else {
            return "Number";
        }
    }
}
