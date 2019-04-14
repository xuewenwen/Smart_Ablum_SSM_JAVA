package com.imooc.demo.Util;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ImagUtilTest {

    @Test
    public void imagCompress() throws IOException {
        String path = "D:\\helloword";
        String[] files = new String[]{
                "D:\\helloword\\1.jpg",
                "D:\\helloword\\2.jpg"
        };

        List<String> list = ImagUtil.generateThumbnail2Directory(path, files);
        System.out.println(list);
    }

}