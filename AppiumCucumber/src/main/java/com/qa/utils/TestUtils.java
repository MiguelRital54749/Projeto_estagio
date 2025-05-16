package com.qa.utils;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestUtils {
    public static final long WAIT = 10;
    private static final Logger logger = Logger.getLogger(TestUtils.class.getName());
    public Logger log(){
        return logger;
    }
}
