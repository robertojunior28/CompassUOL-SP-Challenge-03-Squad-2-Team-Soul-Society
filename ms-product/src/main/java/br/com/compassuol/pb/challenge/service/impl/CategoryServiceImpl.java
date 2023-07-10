package br.com.compassuol.pb.challenge.service.impl;

import br.com.compassuol.pb.challenge.entity.Category;
import br.com.compassuol.pb.challenge.exception.ResourceNotFoundException;
import br.com.compassuol.pb.challenge.payload.CategoryDto;
import br.com.compassuol.pb.challenge.payload.CategoryResponse;
import br.com.compassuol.pb.challenge.repository.CategoryRepository;
import br.com.compassuol.pb.challenge.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper mapper;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);


        Category newCategory = categoryRepository.save(category);

        CategoryDto categoryResponse = mapper.map(newCategory, CategoryDto.class);
        return categoryResponse;
    }

    @Override
    public CategoryResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Category> categories = categoryRepository.findAll(pageable);

        List<Category> listOfCategories = categories.getContent();

        List<CategoryDto> content= listOfCategories.stream().map(
                category -> mapper.map(category, CategoryDto.class)).collect(Collectors.toList());

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(content);
        categoryResponse.setPageNo(categories.getNumber());
        categoryResponse.setPageSize(categories.getSize());
        categoryResponse.setTotalElements(categories.getTotalElements());
        categoryResponse.setTotalPages(categories.getTotalPages());
        categoryResponse.setLast(categories.isLast());

        return categoryResponse;
    }

    @Override
    public CategoryDto getCategoryById(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        return mapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategorytById(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", id));

        category.setName(categoryDto.getName());
        Category updatedCategory = categoryRepository.save(category);
        return mapper.map(category, CategoryDto.class);
    }
}
