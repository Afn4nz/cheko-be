package com.ncai.cheko.repository;

import com.ncai.cheko.dto.ItemPriceProjection;
import com.ncai.cheko.dto.TopNItemsPerCategoryByCalories;
import com.ncai.cheko.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    List<Item> findAllByIdIn(List<Long> ids);

    @Query(value = "select i.id as id, i.price as price from Item i")
    List<ItemPriceProjection> findAllPrices();

    @Query(
            value =
                    """
                    SELECT oi.item_id
                    FROM order_items oi
                    JOIN orders o ON o.id = oi.order_id
                    WHERE o.created_at >= (NOW() - INTERVAL '30 days')
                      AND o.created_at < NOW()
                    GROUP BY oi.item_id
                    ORDER BY SUM(oi.quantity) DESC, oi.item_id
                    LIMIT 5
                    """,
            nativeQuery = true)
    Set<Long> findBestSellingItemIds();

    @Query(
            value =
                    """
        WITH ordered AS (
            SELECT
                i.id,
                i.name,
                i.price,
                i.category_id,
                i.calories,
                ROW_NUMBER() OVER (
                    PARTITION BY i.category_id
                    ORDER BY i.calories DESC, i.id ASC
                ) AS rn
            FROM item i
        )
        SELECT
            r.id,
            r.name,
            r.calories,
            r.price,
            c.name        AS categoryName
        FROM ordered r
        JOIN category c
          ON c.id = r.category_id
        WHERE r.rn <= :topN
        """,
            nativeQuery = true)
    List<TopNItemsPerCategoryByCalories> findTopNItemsPerCategoryByCalories(@Param("topN") int topN);
}
