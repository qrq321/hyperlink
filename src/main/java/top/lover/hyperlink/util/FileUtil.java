package top.lover.hyperlink.util;

import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author qinrq
 */
@Log
public class FileUtil {
    public static String readFromTextFile(String pathname) {
        String fileContent = "";
        File filename = new File(pathname);
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while(line != null) {
                fileContent+=line;
                line = br.readLine();
            }
        }catch (IOException e){
            log.info("文件读取失败！！！");
        }
        return fileContent;
    }
}
