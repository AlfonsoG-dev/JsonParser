
import java.io.File;

import java.util.List;

import Application.Operations.FileOperations;
import Application.Utils.JsonTypes;

class JsonParser {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        if(args.length == 0) {
            System.out.println("You have to provide the file if not a default will be use.");
            System.out.println("Use -f and fileName.json to provide the file\n");
            fileName = "./docs/json_sample.json";
        } else if(args.length == 2 && args[0].equals("-f")) {
            fileName = args[1];
        }
        FileOperations p = new FileOperations("." + File.separator, fileName);

        List<String> keys = p.getJsonKeys();
        List<JsonTypes> types = p.getJsonTypes();
        List<String> values = p.getJsonValues();
        int size = keys.size();
        if(size > types.size()) {
            throw new Exception("Sizes doesn't match");
        }
        System.out.println("Json keys\tJson types\tJson values");
        System.out.println(keys.size() + "\t\t" + types.size() + "\t\t" + values.size() + "\n");
        for(int i=0; i<size; ++i) {
            System.out.println(
                    String.format("%s\t%s\n\t\t%s\n", keys.get(i), types.get(i), values.get(i))
            );
        }
    }
}
