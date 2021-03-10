package com.dust;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Test {
    
    public static void main(String[] args) throws IOException {
        File file4 = new File(Test.class.getResource("").getPath());
        System.out.println(file4);
        // try {
        //     String content = FileUtils.readFileToString(new File("./conf/setting.json"), Charset.forName("utf-8"));
        //     String content = IOUtils.toString(IOUtils.resourceToURL("./conf/setting.json"), Charset.forName("utf-8"));
        //     System.out.println(content);
            
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }

}
