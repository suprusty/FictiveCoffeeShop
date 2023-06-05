package org.fictive.barista.repository;

import java.util.List;

import org.fictive.models.entity.BaristaOrder;
import org.fictive.models.utils.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BaristaRepository extends JpaRepository<BaristaOrder, Long> {
	BaristaOrder findByOrder_id(Long order_id);
	List<BaristaOrder> findByStatusOrStatus(OrderStatus WAITING,OrderStatus IN_PREPARATION);
}