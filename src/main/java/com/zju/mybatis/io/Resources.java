package com.zju.mybatis.io;



import java.io.InputStream;

/**
 * 用于读取配置文件的类
 */

public class Resources {
    public static InputStream getResourceAsStream(String xmlPath) {
        return Resources.class.getClassLoader().getResourceAsStream(xmlPath);
    }
}
