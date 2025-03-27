package com.Nil.Electronic.Shop.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    public ModelMapper mapper(){
        return new ModelMapper();

    }
}
