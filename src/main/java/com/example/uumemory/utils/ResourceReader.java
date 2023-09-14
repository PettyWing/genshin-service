package com.example.uumemory.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;

public class ResourceReader {

    public static String read(String resourcePath) {
        try {
            ClassPathResource classPathResource = new ClassPathResource(resourcePath);
            InputStream inputStream =classPathResource.getInputStream();
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        } catch (IOException e) {

        }
        return null;
    }
}