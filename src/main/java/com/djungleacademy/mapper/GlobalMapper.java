package com.djungleacademy.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GlobalMapper {
    private final ModelMapper modelMapper;

    public GlobalMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convert(Object object, Class<T> convertedObj){
        return modelMapper.map(object, convertedObj);
    }
}
