package com.ncai.cheko.repository;

import com.ncai.cheko.dto.ItemPriceProjection;
import com.ncai.cheko.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
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
                    FROM orders_items oi
                    JOIN orders o ON o.id = oi.order_id
                    WHERE o.created_at >= (NOW() - INTERVAL '30 days')
                      AND o.created_at < NOW()
                    GROUP BY oi.item_id
                    ORDER BY SUM(oi.amount) DESC, oi.item_id
                    LIMIT 5
                    """,
            nativeQuery = true)
    Set<Long> findBestSellingItemIds();
}
