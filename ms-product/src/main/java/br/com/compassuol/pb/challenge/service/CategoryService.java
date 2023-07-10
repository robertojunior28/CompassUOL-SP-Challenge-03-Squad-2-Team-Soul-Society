package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.payload.CategoryDto;
import br.com.compassuol.pb.challenge.payload.CategoryResponse;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir);

    CategoryDto getCategoryById(long id);

    void deleteCategorytById(long id);

    CategoryDto updateCategory(CategoryDto categoryDto, long id);
}
