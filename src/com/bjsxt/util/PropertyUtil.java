package com.bjsxt.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private  static Properties pp;
    private static Logger logger=Logger.getLogger(PropertyUtil.class);
    static {
        pp=new Properties();
    }
    public static String getProperty(String name){
        try {
            pp.load(new FileInputStream("D:\\program\\IdeaProject\\javaeeproject\\sxtoa\\src\\config"));
        } catch (IOException e) {
            logger.fatal(e.getMessage());
        }
        return pp.getProperty(name);
    }
}
