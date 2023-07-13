package com.itschenxiang.springtransactionalanalysis.converter;

import com.itschenxiang.springtransactionalanalysis.dto.SysUserDto;
import com.itschenxiang.springtransactionalanalysis.entity.SysUser;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SysUserConverter extends BidirectionalConverter<SysUser, SysUserDto> {

    private volatile static MapperFacade singleMapperFacade;

    @PostConstruct
    public void init() {
        initMapperFactory();
    }

    private void initMapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(SysUser.class, SysUserDto.class)
                .byDefault()
                .register();

        singleMapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public SysUserDto convertTo(SysUser sysUser, Type<SysUserDto> type, MappingContext mappingContext) {
        return singleMapperFacade.map(sysUser, SysUserDto.class);
    }

    @Override
    public SysUser convertFrom(SysUserDto sysUserDto, Type<SysUser> type, MappingContext mappingContext) {
        return singleMapperFacade.map(sysUserDto, SysUser.class);
    }

    public SysUserDto do2dto(SysUser sysUser) {
        return singleMapperFacade.map(sysUser, SysUserDto.class);
    }

    public SysUser dto2do(SysUserDto sysUserDto) {
        return singleMapperFacade.map(sysUserDto, SysUser.class);
    }
}
