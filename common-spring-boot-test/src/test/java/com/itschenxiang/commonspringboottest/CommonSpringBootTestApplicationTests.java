package com.itschenxiang.commonspringboottest;

import com.itschenxiang.commonspringboottest.utils.ApplicationConfigurationUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("ut")
class CommonSpringBootTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void resolvePropertyOutOfSpringContext() {
        String appName = ApplicationConfigurationUtils.getProperty("app.name", "null");
        Assert.assertEquals("common-spring-boot-test", appName);
        int someTtl = ApplicationConfigurationUtils.getIntProperty("app.someTtl", 10);
        Assert.assertEquals(60, someTtl);
        int notExistProperty = ApplicationConfigurationUtils.getIntProperty("app.notExist", 10);
        Assert.assertEquals(10, notExistProperty);
    }
    
}
