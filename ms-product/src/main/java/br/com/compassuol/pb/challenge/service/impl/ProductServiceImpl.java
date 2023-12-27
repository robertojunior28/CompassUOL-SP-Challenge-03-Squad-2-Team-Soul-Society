package br.com.compassuol.pb.challenge.service.impl;

import br.com.compassuol.pb.challenge.exception.ResourceNotFoundException;
import br.com.compassuol.pb.challenge.entity.Category;
import br.com.compassuol.pb.challenge.entity.Product;
import br.com.compassuol.pb.challenge.payload.ProductDto;
import br.com.compassuol.pb.challenge.payload.ProductResponse;
import br.com.compassuol.pb.challenge.repository.CategoryRepository;
import br.com.compassuol.pb.challenge.repository.ProductRepository;
import br.com.compassuol.pb.challenge.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper mapper;
    private CategoryRepository categoryRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = mapper.map(productDto, Product.class);
        Category category = categoryRepository.findById(product.getCategory().iterator().next().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", product.getCategory().iterator().next().getId()));

        product.getCategory().clear();
        product.getCategory().add(category);
        product.setDate(LocalDateTime.now());
        Product newProduct = productRepository.save(product);

        ProductDto productResponse = mapper.map(newProduct, ProductDto.class);
        return productResponse;

    }


    public ProductDto getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> products = productRepository.findAll(pageable);

        List<Product> listOfProducts = products.getContent();

        List<ProductDto> content= listOfProducts.stream().map(
                product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(content);
        productResponse.setPageNo(products.getNumber());
        productResponse.setPageSize(products.getSize());
        productResponse.setTotalElements(products.getTotalElements());
        productResponse.setTotalPages(products.getTotalPages());
        productResponse.setLast(products.isLast());

        return productResponse;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", id));

        Category category = categoryRepository.findById(product.getCategory().iterator().next().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", product.getCategory().iterator().next().getId()));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.getCategory().add(category);
        product.setDate(LocalDateTime.now());
        product.setImgUrl(productDto.getImgUrl());
        Product updatedProduct = productRepository.save(product);
        return mapper.map(product, ProductDto.class);

    }

    @Override
    public void deleteProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }


}
