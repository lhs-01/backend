package com.engis.esd.hrms.config;

import org.apache.catalina.mapper.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="com.engis.esd.hrms", annotationClass = org.apache.ibatis.annotations.Mapper.class)
public class MybatisConfig {

}
