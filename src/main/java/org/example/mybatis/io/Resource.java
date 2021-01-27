package org.example.mybatis.io;

import org.apache.ibatis.io.Resources;

import java.io.InputStream;

/**
 * 用于读取配置文件的类
 */

public class Resource {
    public static InputStream getResourceAsStream(String xmlPath) {
        return Resources.class.getClassLoader().getResourceAsStream(xmlPath);
    }
}
