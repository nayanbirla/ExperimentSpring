package com.experiment;

import com.expermient.Main;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SpringExperimentTest {

    public static Logger logger= LoggerFactory.getLogger(Main.class);

    @Test
    public void contextLoads(){
        logger.info("Test case execution...");
        assertEquals(true,true);
    }
}
