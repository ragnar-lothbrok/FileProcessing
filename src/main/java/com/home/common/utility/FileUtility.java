package com.home.common.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.home.common.enums.ParseEnum;

public class FileUtility {

    public static String writeToFile(Object Object, ParseEnum parseEnum) throws IOException {
        File file = new File(parseEnum.name()+ "."+parseEnum.getFormat());
        String fileName = file.getAbsolutePath();

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Object.toString());
        bw.close();
        return fileName;
    }

}
