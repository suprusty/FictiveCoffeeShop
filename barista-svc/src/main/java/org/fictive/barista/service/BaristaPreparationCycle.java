package org.fictive.barista.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.fictive.barista.config.OrderClientConfig;
import org.fictive.models.entity.BaristaOrder;
import org.fictive.models.utils.OrderStatus;

public class BaristaPreparationCycle {
	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	public static void processOrder(BaristaOrder baristaOrder,BaristaService baristaService) {
		executorService.submit(() -> {
			for (OrderStatus orderStatus : OrderStatus.values()) {
				if(orderStatus == OrderStatus.WAITING) {
					continue;
				}
				baristaOrder.setStatus(orderStatus);
				try {
					Thread.sleep(60000);//1 mint
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				baristaService.updateTheStatus(baristaOrder);
				if(orderStatus == OrderStatus.PICKED_UP) {
					OrderClientConfig.processOrder(baristaOrder.getId());
				}
			}
		});
	}
}
