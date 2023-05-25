package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.entity.Product;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.repository.ProductRepository;
import org.sopt.myhouse.service.dto.response.ProductServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<ProductServiceDto.ProductResponseDto> showRank() throws NotImageFoundException {
        List<Product> products = productRepository.getAllProduct().orElseThrow(()->new NotImageFoundException(ErrorStatus.NO_PRODUCT, ErrorStatus.NO_PRODUCT.getMessage()));
        List<ProductServiceDto.ProductResponseDto> result = new ArrayList<>();
        Collections.sort(products, Comparator.comparing(Product::getRate));
        int i = 1;
        for (Product product : products) {
            ProductServiceDto.ProductResponseDto productResponseDto = new ProductServiceDto.ProductResponseDto(product.getCategory(), product.getImage_url(), product.getTitle(), product.getDiscount(), product.getPrice(), product.getRate(), product.getReviews_count(),i);
            i++;
            result.add(productResponseDto);
        }
        return result;
    }
}
