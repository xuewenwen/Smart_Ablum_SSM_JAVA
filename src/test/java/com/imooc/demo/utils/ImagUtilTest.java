package com.imooc.demo.utils;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ImagUtilTest {
    @Test
    public void test() {

        String thumbnailFilePath = "target/classes/static/images/upload/1/thumbnail";
        String fileName = "target/classes/static/images/upload/1/2fb02c33-f5fd-4bde-9611-56629d8602a5.jpg";
        String thumbnailPicPath;

        {
            try {
                thumbnailPicPath = ImagUtil.generateThumbnail2Directory(thumbnailFilePath, fileName);
                System.out.println(thumbnailPicPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}