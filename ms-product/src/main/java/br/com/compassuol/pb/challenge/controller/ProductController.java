package br.com.compassuol.pb.challenge.controller;

import br.com.compassuol.pb.challenge.payload.ProductDto;
import br.com.compassuol.pb.challenge.payload.ProductResponse;
import br.com.compassuol.pb.challenge.service.impl.ProductServiceImpl;
import br.com.compassuol.pb.challenge.utils.AppConstants;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductServiceImpl productService;
    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ProductResponse getAllPosts(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int page,
            @RequestParam(value = "linesPerPage", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int linesPerPage,
            @RequestParam(value = "direction", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String direction,
            @RequestParam(value = "orderBy", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String orderBy
    ){
        return productService.getAllProducts(page, linesPerPage, direction, orderBy);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto, @PathVariable long id){
        ProductDto productResponse = productService.updateProduct(productDto, id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product entity deleted successfully.", HttpStatus.OK);
    }
}
