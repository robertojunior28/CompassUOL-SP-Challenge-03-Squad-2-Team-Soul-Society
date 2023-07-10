package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.payload.ProductDto;
import br.com.compassuol.pb.challenge.payload.ProductResponse;

public interface ProductService {
    ProductResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, long id);

    void deleteProductById(long id);
}
