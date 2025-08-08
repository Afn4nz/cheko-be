package com.ncai.cheko.repository;

import com.ncai.cheko.dto.CategoryProjection;
import com.ncai.cheko.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT c.id, c.name, (SELECT COUNT (*) FROM item i WHERE i.category_id = c.id) AS itemCount FROM category c", nativeQuery = true)
    List<CategoryProjection> findCategoryList();
}
