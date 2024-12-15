package com.experiment;

import com.expermient.Main;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)
public class SpringExperimentTest {
    public static Logger logger = LoggerFactory.getLogger(Main.class);

    @Test
    public void contextLoads() {
        String someValue="Nayan"
        Supplier<String> supplier = () -> "Message: " + someValue;
        logger.debug(supplier);
        assertEquals(true, true);
    }
}