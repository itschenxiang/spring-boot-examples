package com.itschenxiang.springtransactionalanalysis.service;


import com.itschenxiang.springtransactionalanalysis.dto.SysUserDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class SimpleServiceTest {

    @Autowired
    private SimpleService simpleService;

    @Test
    public void findUserTest() {
        SysUserDto sysUserDto = simpleService.findUser(1L);
        Assert.assertNotNull(sysUserDto);
        // 'Jone', 18, 'test1@baomidou.com'
        Assert.assertEquals("Jone", sysUserDto.getUserName());
        Assert.assertEquals(18, sysUserDto.getAge().intValue());
        Assert.assertEquals("test1@baomidou.com", sysUserDto.getEmail());
    }

}