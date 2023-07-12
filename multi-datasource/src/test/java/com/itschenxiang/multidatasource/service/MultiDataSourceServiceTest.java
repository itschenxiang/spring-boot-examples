package com.itschenxiang.multidatasource.service;

import com.itschenxiang.multidatasource.entity.MasterUser;
import com.itschenxiang.multidatasource.entity.SlaveUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@ActiveProfiles("ut")
@RunWith(SpringRunner.class)
public class MultiDataSourceServiceTest {

    @Autowired
    private MultiDataSourceService multiDataSourceService;

    @Test
    public void accessPrimaryDataSourceTest() {
        List<MasterUser> masterUserList = multiDataSourceService.accessPrimaryDataSource();
        Assert.assertEquals(5, masterUserList.size());
    }
    
    @Test
    public void accessNotPrimaryDataSourceTest() {
        List<SlaveUser> slaveUserList = multiDataSourceService.accessNotPrimaryDataSource();
        Assert.assertEquals(5, slaveUserList.size());
    }
    
    @Test
    public void multiDataSourceWithoutTransactionalTest() {
        multiDataSourceService.multiDataSourceWithoutTransactional();
    }

    @Test
    public void multiDataSourceWithTransactionalTest() {
        try {
            multiDataSourceService.multiDataSourceWithTransactional();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e instanceof BadSqlGrammarException);
        }
    }
    
}