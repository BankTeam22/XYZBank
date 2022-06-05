package Helper;

import Web.UseDriver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log4J extends UseDriver {

        public static Logger logger = LogManager.getLogger(log4J.class);
        public static void main(String[] args) {
            PropertyConfigurator.configure("\\path\\to\\log4j2.properties");
            logger.info("Hello world");
            logger.error("we are in logger info mode");


        }

        public void chromeTitleTest() {
            String title = getDriver().getTitle();



        }

    }

