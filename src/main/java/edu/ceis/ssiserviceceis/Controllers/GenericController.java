package edu.ceis.ssiserviceceis.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GenericController {

    @Autowired
    protected ModelMapper modelMapper;

    public <T> List<T> convertListToDtoList(List<?> elements, Class<T> classToConvert) {
        return elements.stream().map(element -> modelMapper.map(element, classToConvert)).collect(Collectors.toList());
    }

}