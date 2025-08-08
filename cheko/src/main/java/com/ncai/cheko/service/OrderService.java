package com.ncai.cheko.service;

import com.ncai.cheko.dto.ItemRequest;
import com.ncai.cheko.dto.OrderRequest;
import com.ncai.cheko.entity.Item;
import com.ncai.cheko.entity.Order;
import com.ncai.cheko.entity.OrderItem;
import com.ncai.cheko.mapper.OrderItemMapper;
import com.ncai.cheko.repository.ItemRepository;
import com.ncai.cheko.repository.OrderItemRepository;
import com.ncai.cheko.repository.OrderRepository;
import com.ncai.cheko.utill.OrderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.UnaryOperator.identity;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public void placeOrder(OrderRequest orderRequest) {
        List<Long> itemIds = orderRequest.getItems().stream().map(ItemRequest::getItemId).toList();
        List<Item> items = itemRepository.findAllByIdIn(itemIds); // TODO: cache prices

        Order order = new Order();
        order.setTotal(OrderUtil.calculateTotalPrice(items, orderRequest));
        orderRepository.save(order);

        Map<Long, Item> itemLookup =
                items.stream().collect(Collectors.toMap(Item::getId, identity()));
        List<OrderItem> mapped = orderItemMapper.toEntities(orderRequest.getItems(), itemLookup);
        mapped.forEach(orderItem -> orderItem.setOrder(order));
        orderItemRepository.saveAll(mapped);
    }

    public long getOrdersTotal() {
        return orderRepository.count();
    }
}
