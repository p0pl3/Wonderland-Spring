package com.example.toyshop.repository;

import com.example.toyshop.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findAllByProductId(Long id);
}
