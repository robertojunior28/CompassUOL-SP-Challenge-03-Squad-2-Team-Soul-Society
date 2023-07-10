package br.com.compassuol.pb.challenge.controller;

import br.com.compassuol.pb.challenge.payload.CategoryDto;
import br.com.compassuol.pb.challenge.payload.CategoryResponse;
import br.com.compassuol.pb.challenge.service.impl.CategoryServiceImpl;
import br.com.compassuol.pb.challenge.utils.AppConstants;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceImpl categoryService;
    private ModelMapper mapper;
    @Autowired
    public CategoryController(CategoryServiceImpl categoryService, ModelMapper mapper) {
        this.categoryService = categoryService;
        this.mapper = mapper;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping
    public CategoryResponse getAllCategory(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return categoryService.getAllCategory(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable long id){
        CategoryDto categoryResponse = categoryService.updateCategory(categoryDto, id);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable long id){
        categoryService.deleteCategorytById(id);
        return new ResponseEntity<>("Category entity deleted successful.", HttpStatus.OK);
    }
}
