package com.itschenxiang.multidatasource.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {
        "spring.datasource.dynamic.primary=master",
        "spring.datasource.dynamic.strict=false",
        "spring.datasource.dynamic.datasource.master.url=jdbc:h2:mem:master",
        "spring.datasource.dynamic.datasource.master.driver-class-name=org.h2.Driver",
        "spring.datasource.dynamic.datasource.master.init.schema=master-slave_1-schema-h2.sql",
        "spring.datasource.dynamic.datasource.master.init.data=master-slave_1-data-h2.sql",
//        "spring.datasource.dynamic.datasource.slave_1.url=jdbc:h2:mem:slave_1",
//        "spring.datasource.dynamic.datasource.slave_1.driver-class-name=org.h2.Driver",
//        "spring.datasource.dynamic.datasource.slave_1.init.schema=slave_1-schema-h2.sql",
//        "spring.datasource.dynamic.datasource.slave_1.init.data=slave_1-data-h2.sql",
        // "spring.datasource.sql.init.schema-locations=slave_1-schema-h2.sql",
        // "spring.datasource.sql.init.data-locations=slave_1-data-h2.sql",
})
public class MultiDataSourceServiceTest {

    @Autowired
    private MultiDataSourceService multiDataSourceService;

    @Test
    public void multiDataSourceTest() {
        System.out.println(multiDataSourceService.accessNotPrimaryDataSource());
    }

}