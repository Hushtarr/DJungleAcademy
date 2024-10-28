package com.djungleacademy.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlobalMapper {
    private final ModelMapper modelMapper;

    public <T> T convert(Object object, Class<T> convertedObj){
        return modelMapper.map(object, convertedObj);
    }
}
