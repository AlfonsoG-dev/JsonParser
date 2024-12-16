package Application.Utils;

public class JsonUtils {

    public JsonTypes getJsonType(String sentence) {
        if(sentence.startsWith("\"")) {
            return JsonTypes.STRING;
        } else if(sentence.startsWith("[")) {
            return JsonTypes.LIST;
        } else if(sentence.startsWith("{")) {
            return JsonTypes.OBJECT;
        } else if(sentence.equals("true") || sentence.equals("false")) {
            return JsonTypes.BOOLEAN;
        } else {
            return JsonTypes.NUMBER;
        }
    }
}
