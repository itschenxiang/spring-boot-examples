package com.itschenxiang.multidatasource.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itschenxiang.multidatasource.entity.MasterUser;
import com.itschenxiang.multidatasource.entity.SlaveUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SlaveUserMapper extends BaseMapper<SlaveUser> {

}
