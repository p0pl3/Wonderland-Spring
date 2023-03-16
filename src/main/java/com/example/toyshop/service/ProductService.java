package com.example.toyshop.service;

import com.example.toyshop.dto.ProductCreateDTO;
import com.example.toyshop.dto.ProductDetailDTO;
import com.example.toyshop.dto.ProductListDTO;
import com.example.toyshop.entity.Category;
import com.example.toyshop.entity.Product;
import com.example.toyshop.repository.ProductRepository;
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

    public ProductDetailDTO create(ProductCreateDTO dto) {
        if (dto.getCategoryId() == null)
            return productMapper.toDetailDto(productRepository.save(productMapper.fromCreateDto(dto)));
        Category category = categoryService.findById(dto.getCategoryId());
        if (category == null)
            return productMapper.toDetailDto(productRepository.save(productMapper.fromCreateDto(dto)));
        Product product = productMapper.fromCreateDto(dto);
        product.setCategory(category);
        return productMapper.toDetailDto(productRepository.save(product));
    }

    public List<ProductListDTO> findAll(String title, Long category) {
        return productRepository.findByFilters(title, category).stream().map(productMapper::toListDto).collect(Collectors.toList());
    }

    public ProductDetailDTO findByIdDto(Long id) {
        return productMapper.toDetailDto(productRepository.findById(id).orElse(null));
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductDetailDTO update(Long id, ProductCreateDTO dto) {
        return productMapper.toDetailDto(productRepository.save(productMapper.update(dto, this.findById(id))));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
