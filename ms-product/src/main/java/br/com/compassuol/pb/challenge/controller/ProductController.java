package br.com.compassuol.pb.challenge.controller;

import br.com.compassuol.pb.challenge.payload.ProductResponse;
import br.com.compassuol.pb.challenge.service.impl.ProductServiceImpl;
import br.com.compassuol.pb.challenge.utils.AppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
POST /products
GET /products/:id
GET /products/?page=1&linesPerPage=5&direction=DESC&orderBy=name
DELETE /products /:id
PUT /products /:id
 */
@RestController
public class ProductController {

    private ProductServiceImpl productService;
    private ModelMapper mapper;
    @Autowired
    public ProductController(ProductServiceImpl productService, ModelMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }
    @GetMapping
    public ProductResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return productService.getAllProducts(pageNo, pageSize, sortBy, sortDir);
    }
}
