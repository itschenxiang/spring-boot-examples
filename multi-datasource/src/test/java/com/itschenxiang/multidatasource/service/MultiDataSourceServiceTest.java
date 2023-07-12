package com.itschenxiang.multidatasource.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("ut")
@RunWith(SpringRunner.class)
public class MultiDataSourceServiceTest {

    @Autowired
    private MultiDataSourceService multiDataSourceService;

    @Test
    public void accessNotPrimaryDataSourceTest() {
        System.out.println(multiDataSourceService.accessNotPrimaryDataSource());
    }

    @Test
    public void accessPrimaryDataSourceTest() {
        System.out.println(multiDataSourceService.accessPrimaryDataSource());
    }
    
}