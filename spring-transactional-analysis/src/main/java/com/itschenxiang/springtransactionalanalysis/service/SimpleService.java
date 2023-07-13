package com.itschenxiang.springtransactionalanalysis.service;

import com.itschenxiang.springtransactionalanalysis.converter.SysUserConverter;
import com.itschenxiang.springtransactionalanalysis.dto.SysUserDto;
import com.itschenxiang.springtransactionalanalysis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimpleService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserConverter sysUserConverter;

    @Transactional
    public SysUserDto findUser(long id) {
        return sysUserConverter.do2dto(sysUserMapper.selectById(id));
    }

}
