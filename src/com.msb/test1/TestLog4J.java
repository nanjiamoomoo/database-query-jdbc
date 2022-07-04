package com.msb.test1;

import com.msb.dao.impl.EmpDaoImpl;
import org.apache.log4j.Logger;

public class TestLog4J {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TestLog4J.class);

        logger.fatal("fatal message");
        logger.error("error message");
        logger.warn("warn message");
        logger.info("info message");
        logger.debug("debug message");

        try{
            int i = 1 / 0;

        } catch (Exception e){
            logger.warn("Program Exception", e);
        }


    }
}
