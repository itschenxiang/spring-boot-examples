package com.itschenxiang.multidatasource.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itschenxiang.multidatasource.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<SysUser> {

}
