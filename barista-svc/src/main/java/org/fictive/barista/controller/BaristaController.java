package org.fictive.barista.controller;

import java.util.List;

import org.fictive.barista.dto.BaristaOrderDTO;
import org.fictive.barista.service.BaristaService;
import org.fictive.barista.utils.APIConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/task")
@Tag(name = "Barista service is responsible for order processing")
public class BaristaController {
	@Autowired
	BaristaService baristaService;

	@ApiResponses({ @ApiResponse(responseCode = "202", description = APIConstant.PROCESS_ORDER),
			@ApiResponse(responseCode = "401", description = APIConstant.API_AUTH_FAILED),
			@ApiResponse(responseCode = "403", description = APIConstant.API_ACCESS_FAILED),
			@ApiResponse(responseCode = "404", description = APIConstant.API_RESOURCE_NOT_FOUND),
			@ApiResponse(responseCode = "500", description = APIConstant.API_SERVER_ERROR) })
	@Operation(summary = APIConstant.API_PROCESS_ORDER_SUMMARY)
	@PutMapping("/process/{order_id}")
	public ResponseEntity<String> processOrder(@PathVariable Long order_id) {
		baristaService.processOrder(order_id);
		return new ResponseEntity<String>(APIConstant.PROCESS_ORDER, HttpStatus.ACCEPTED);
	}

	@ApiResponses({ @ApiResponse(responseCode = "200", description = APIConstant.API_PENDING_ORDER),
			@ApiResponse(responseCode = "401", description = APIConstant.API_AUTH_FAILED),
			@ApiResponse(responseCode = "403", description = APIConstant.API_ACCESS_FAILED),
			@ApiResponse(responseCode = "404", description = APIConstant.API_RESOURCE_NOT_FOUND),
			@ApiResponse(responseCode = "500", description = APIConstant.API_SERVER_ERROR) })
	@Operation(summary = APIConstant.API_PENDING_ORDER)
	@GetMapping("/pending")
	public List<BaristaOrderDTO> getPendingOrders() {
		return baristaService.getPendingOrders();
	}

}