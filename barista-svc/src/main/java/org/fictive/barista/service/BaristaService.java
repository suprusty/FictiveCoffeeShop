package org.fictive.barista.service;

import java.util.List;
import java.util.stream.Collectors;

import org.fictive.barista.dto.BaristaOrderDTO;
import org.fictive.barista.exception.BaristaNotFoundException;
import org.fictive.barista.repository.BaristaRepository;
import org.fictive.models.entity.BaristaOrder;
import org.fictive.models.utils.OrderStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaristaService {

	@Autowired
	BaristaRepository baristaRepository;

	public List<BaristaOrderDTO> getPendingOrders() {
		List<BaristaOrder> baristaOrders = baristaRepository.findByStatusOrStatus(OrderStatus.WAITING,
				OrderStatus.IN_PREPARATION);
		List<BaristaOrderDTO> baristaOrderDTOs = null;
		if (baristaOrders != null && !baristaOrders.isEmpty()) {
			baristaOrderDTOs = baristaOrders.stream().map(BaristaOrderDTO::map).collect(Collectors.toList());
		}
		return baristaOrderDTOs;
	}

	public void processOrder(Long order_id) {
		BaristaOrder baristaOrder = baristaRepository.findByOrder_id(order_id);
		if (baristaOrder == null) {
			throw new BaristaNotFoundException("Order not found");
		}
		BaristaPreparationCycle.processOrder(baristaOrder, this);
	}

	@Transactional
	public void updateTheStatus(BaristaOrder baristaOrder) {
		baristaRepository.save(baristaOrder);

	}
}
