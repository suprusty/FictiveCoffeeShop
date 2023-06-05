package org.fictive.barista.dto;

import org.fictive.models.entity.BaristaOrder;
import org.fictive.models.utils.OrderStatus;

public class BaristaOrderDTO {

	private OrderStatus status;
	private Long Order_Id;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Long getOrder_Id() {
		return Order_Id;
	}

	public void setOrder_Id(Long order_Id) {
		Order_Id = order_Id;
	}

	public BaristaOrderDTO(OrderStatus status, Long order_Id) {
		super();
		this.status = status;
		Order_Id = order_Id;
	}

	public static BaristaOrderDTO map(BaristaOrder baristaOrder) {
		return new BaristaOrderDTO(baristaOrder.getStatus(), baristaOrder.getOrder().getId());
	}
}