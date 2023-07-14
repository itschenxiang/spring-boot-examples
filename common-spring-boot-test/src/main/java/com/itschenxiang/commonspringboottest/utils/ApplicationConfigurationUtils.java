package com.itschenxiang.commonspringboottest.utils;

import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.HashMap;

public class ApplicationConfigurationUtils {
    
    public static String getProperty(String propertyKey, String defaultValue) {
        try {
            Environment environment = SpringContextUtils.getBean(Environment.class);
            return environment.getProperty(propertyKey, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }
    
    public static int getIntProperty(String propertyKey, int defaultValue) {
        try {
            Environment environment = SpringContextUtils.getBean(Environment.class);
            return environment.getProperty(propertyKey, Integer.class, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
