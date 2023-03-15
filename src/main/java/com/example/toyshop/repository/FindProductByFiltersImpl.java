package com.example.toyshop.repository;

import com.example.toyshop.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class FindProductByFiltersImpl implements FindProductByFilters {
    EntityManager em;
    CategoryRepository repository;

    @Override
    public List<Product> findByFilters(String title, Long categoryId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if (title != null) {
            predicates.add(cb.like(product.get("title"), "%" + title + "%"));
        }
        if (categoryId != null) {
            predicates.add(cb.equal(product.get("category"), categoryId));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
