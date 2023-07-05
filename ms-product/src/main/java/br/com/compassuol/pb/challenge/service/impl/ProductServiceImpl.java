package br.com.compassuol.pb.challenge.service.impl;

import br.com.compassuol.pb.challenge.ResourceNotFoundException;
import br.com.compassuol.pb.challenge.entity.Product;
import br.com.compassuol.pb.challenge.payload.ProductDto;
import br.com.compassuol.pb.challenge.payload.ProductResponse;
import br.com.compassuol.pb.challenge.repository.ProductRepository;
import br.com.compassuol.pb.challenge.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper mapper;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductDto getPostById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> products = productRepository.findAll(pageable);

        // get content for page object
        List<Product> listOfProducts = products.getContent();

        List<ProductDto> content= listOfProducts.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(content);
        productResponse.setPageNo(products.getNumber());
        productResponse.setPageSize(products.getSize());
        productResponse.setTotalElements(products.getTotalElements());
        productResponse.setTotalPages(products.getTotalPages());
        productResponse.setLast(products.isLast());

        return productResponse;
    }
}
