package org.fictive.coffeeshop.controller;

import org.fictive.coffeeshop.dto.OrderDTO;
import org.fictive.coffeeshop.service.OrderService;
import org.fictive.coffeeshop.utils.APIConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders service is responsible for maintain the customer orders.")
public class OrderController {
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@ApiResponses({ @ApiResponse(responseCode = "201", description = APIConstant.API_ORDER_CREATED),
			@ApiResponse(responseCode = "401", description = APIConstant.API_AUTH_FAILED),
			@ApiResponse(responseCode = "403", description = APIConstant.API_ACCESS_FAILED),
			@ApiResponse(responseCode = "404", description = APIConstant.API_RESOURCE_NOT_FOUND),
			@ApiResponse(responseCode = "500", description = APIConstant.API_SERVER_ERROR) })
	@Operation(summary = APIConstant.API_ORDER_SERVICE)
	@PostMapping
	public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
		orderService.addOrder(orderDTO);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.CREATED);
	}

	@ApiResponses({ @ApiResponse(responseCode = "200", description = APIConstant.API_ORDER_DELETED),
			@ApiResponse(responseCode = "401", description = APIConstant.API_AUTH_FAILED),
			@ApiResponse(responseCode = "403", description = APIConstant.API_ACCESS_FAILED),
			@ApiResponse(responseCode = "404", description = APIConstant.API_RESOURCE_NOT_FOUND),
			@ApiResponse(responseCode = "500", description = APIConstant.API_SERVER_ERROR) })
	@Operation(summary = APIConstant.API_ORDER_CANCELLING)
	@DeleteMapping("/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
		orderService.cancelOrder(orderId);
		return new ResponseEntity<String>(APIConstant.API_ORDER_DELETED, HttpStatus.OK);
	}

}