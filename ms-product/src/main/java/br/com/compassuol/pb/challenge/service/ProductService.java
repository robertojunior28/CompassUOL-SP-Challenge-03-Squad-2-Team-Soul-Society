package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.payload.ProductResponse;

public interface ProductService {
    ProductResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir);
}
