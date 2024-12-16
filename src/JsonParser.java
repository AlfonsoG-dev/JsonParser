
import java.io.File;

import java.util.List;

import Application.Operations.FileOperations;
import Application.Utils.JsonTypes;

class JsonParser {
    public static void main(String[] args) throws Exception {
        String fileName = "./docs/json_sample.json";
        FileOperations p = new FileOperations("." + File.separator, fileName);

        List<String> keys = p.getJsonKeys();
        List<JsonTypes> types = p.getJsonTypes();
        List<String> values = p.getJsonValues();
        int size = keys.size();
        if(size > types.size()) {
            throw new Exception("Sizes doesn't match");
        }
        System.out.println(keys.size() + " " + types.size() + " " + values.size());
        for(int i=0; i<size; ++i) {
            System.out.println(
                    String.format("%s\t%s\n\t\t%s\n", keys.get(i), types.get(i), values.get(i))
            );
        }
    }
}
