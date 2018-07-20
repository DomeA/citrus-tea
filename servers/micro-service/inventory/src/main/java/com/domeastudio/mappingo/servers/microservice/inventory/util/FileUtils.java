package com.domeastudio.mappingo.servers.microservice.inventory.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

public class FileUtils {
    //参数是图片的路径
    public static byte[] FileInput2Byte(MultipartFile imageFile) {
        byte[] data = null;
        try {
            InputStream input = imageFile.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    //参数是图片的路径
    public static byte[] File2Byte(File imageFile) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(imageFile);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }
}
