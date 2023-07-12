package com.itschenxiang.multidatasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.itschenxiang.multidatasource.dao.MasterUserMapper;
import com.itschenxiang.multidatasource.dao.SlaveUserMapper;
import com.itschenxiang.multidatasource.entity.MasterUser;
import com.itschenxiang.multidatasource.entity.SlaveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MultiDataSourceService {

    @Autowired
    private MasterUserMapper masterUserMapper;

    @Autowired
    private SlaveUserMapper slaveUserMapper;
    
    @Autowired
    @Lazy
    private MultiDataSourceService multiDataSourceService;
    
    @DS("master")
    public List<MasterUser> accessPrimaryDataSource() {
        return masterUserMapper.selectList(null);
    }

    @DS("slave_1")
    public List<SlaveUser> accessNotPrimaryDataSource() {
        return slaveUserMapper.selectList(null);
    }

    public void multiDataSourceWithoutTransactional() {
        multiDataSourceService.accessPrimaryDataSource();
        multiDataSourceService.accessNotPrimaryDataSource();
    }

    @Transactional(rollbackFor = Exception.class)
    public void multiDataSourceWithTransactional() {
        accessPrimaryDataSource();
        accessNotPrimaryDataSource();
    }
    
}
