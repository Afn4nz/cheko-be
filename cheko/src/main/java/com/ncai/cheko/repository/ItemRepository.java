package com.ncai.cheko.repository;

import com.ncai.cheko.dto.ItemPriceProjection;
import com.ncai.cheko.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    List<Item> findAllByIdIn(List<Long> ids);

    @Query(value = "select i.id as id, i.price as price from Item i")
    List<ItemPriceProjection> findAllPrices();
}
