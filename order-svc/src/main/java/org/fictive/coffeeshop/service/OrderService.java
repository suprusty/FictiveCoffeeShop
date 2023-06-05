package org.fictive.coffeeshop.service;

import org.fictive.coffeeshop.config.BaristaClientConfig;
import org.fictive.coffeeshop.dto.OrderDTO;
import org.fictive.coffeeshop.exception.OrderNotFoundException;
import org.fictive.coffeeshop.repository.OrderRepository;
import org.fictive.models.entity.BaristaOrder;
import org.fictive.models.entity.Order;
import org.fictive.models.utils.OrderStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

	@Autowired
	private ModelMapper modelMapper;

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	/*
	 * Adding an order. The completed orders shall be forwarded to Barista service
	 * for processing.
	 */
	@Transactional
	public OrderDTO addOrder(OrderDTO orderdto) {
		Order order = getOrderModelMapper(orderdto);
		populateBaristaOrder(order);
		orderRepository.save(order);
		BaristaClientConfig.processOrder(order.getId());
		orderdto.setOrderId(order.getId());
		return orderdto;
	}

	/*
	 * Cancelling an order 4.An order, which is already in
	 * preparation/finished/pickedup, cannot be cancelled.
	 */
	@Transactional
	public void cancelOrder(Long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found"));

		if (order.getBaristaOrder().getStatus() == OrderStatus.IN_PREPARATION
				|| order.getBaristaOrder().getStatus() == OrderStatus.FINISHED) {
			throw new IllegalStateException(
					"Because the order is being " + order.getBaristaOrder().getStatus() + ", it cannot be cancelled");
		}
		orderRepository.delete(order);
	}

	private Order getOrderModelMapper(OrderDTO orderdto) {
		Order order = modelMapper.map(orderdto, Order.class);
		return order;
	}

	private void populateBaristaOrder(Order order) {
		BaristaOrder bo = new BaristaOrder();
		bo.setStatus(OrderStatus.WAITING);
		order.addBaristaOrder(bo);
	}
}
