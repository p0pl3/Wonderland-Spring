package com.example.toyshop.service;

import com.example.toyshop.dto.CategoryDTO;
import com.example.toyshop.dto.ProductDetailDTO;
import com.example.toyshop.dto.ProductListDTO;
import com.example.toyshop.entity.Product;
import com.example.toyshop.repository.ProductRepository;
import com.example.toyshop.service.mapper.CategoryMapper;
import com.example.toyshop.service.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private ProductMapper productMapper;
    private CategoryMapper categoryMapper;


    public ProductDetailDTO create(ProductDetailDTO dto) {
        return productMapper.toDetailDto(productRepository.save(productMapper.toEntityFromDetailDto(dto)));
    }

    public List<ProductListDTO> findAll() {
        return productRepository.findAll().stream().map(productMapper::toListDto).collect(Collectors.toList());
    }

    public List<ProductListDTO> findByCategory(CategoryDTO dto) {
        return productRepository.findProductByCategory(categoryMapper.toEntity(dto)).stream().map(productMapper::toListDto).collect(Collectors.toList());
    }

    public List<ProductListDTO> findByTitle(String title) {
        return productRepository.findProductByTitle(title).stream().map(productMapper::toListDto).collect(Collectors.toList());
    }

    public ProductDetailDTO findById(Long id) {
        return productMapper.toDetailDto(productRepository.findById(id).orElse(null));
    }

    public ProductDetailDTO update(Product product) {
        return productMapper.toDetailDto(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
