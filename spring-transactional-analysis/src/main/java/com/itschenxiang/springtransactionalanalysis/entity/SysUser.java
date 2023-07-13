package com.itschenxiang.springtransactionalanalysis.entity;

import lombok.Data;

@Data
public class SysUser {
    private Long id;
    private String userName;
    private Integer age;
    private String email;
}