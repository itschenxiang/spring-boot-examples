package com.itschenxiang.multidatasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.itschenxiang.multidatasource.dao.UserMapper;
import com.itschenxiang.multidatasource.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MultiDataSourceService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @DS("slave_1")
    public List<SysUser> accessNotPrimaryDataSource() {
        return userMapper.selectList(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<SysUser> accessPrimaryDataSource() {
        return userMapper.selectList(null);
    }
    
}
