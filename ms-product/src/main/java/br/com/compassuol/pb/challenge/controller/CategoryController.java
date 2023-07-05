package br.com.compassuol.pb.challenge.controller;

import br.com.compassuol.pb.challenge.service.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private CategoryServiceImpl categoryService;
    private ModelMapper mapper;
    @Autowired
    public CategoryController(CategoryServiceImpl categoryService, ModelMapper mapper) {
        this.categoryService = categoryService;
        this.mapper = mapper;
    }
}
