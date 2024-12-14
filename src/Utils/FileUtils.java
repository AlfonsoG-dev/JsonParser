package Utils;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileUtils {
    String rootPath;

    public FileUtils(String rootPath) {
        this.rootPath = rootPath;
    }

    public List<String> getFileLines(String filePath) {
        List<String> lines = new ArrayList<>();
        BufferedReader br = null;
        File f = new File(filePath);
        try {
            if(!f.exists() || !f.isFile()) {
                throw new Exception("Incorrect params");
            }
            br = new BufferedReader(new FileReader(f));
            while(br.ready()) {
                lines.add(br.readLine());
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }
}
