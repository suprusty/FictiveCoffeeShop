package org.fictive.barista.utils;

public interface APIConstant {
	String PROCESS_ORDER = "Order processing is accepted";
	String API_AUTH_FAILED = "The request failed; Please enter the correct authentication information.";
	String API_ACCESS_FAILED = "The request failed; To access the resource, Please enter the right authentication details.";
	String API_RESOURCE_NOT_FOUND = "Request failed because the resource does not exist.";
	String API_SERVER_ERROR = "Request failed because of unknown failure on the server";
	String API_DEL_SUCCESS = "Delete opertaion is successful";	
	String API_PROCESS_ORDER_SUMMARY = "waiting -> in preparation -> finished -> picked up";
	String API_PENDING_ORDER = "Listing of pending orders with their current status";
	String API_BARISTA_SERVICE_SPEC ="This service is responsible for order processing. The order in the Barista service goes through the following states: \n"
			+ "\n"
			+ "	waiting -> in preparation -> finished -> picked up\n"
			+ "";
	String API_BARISTA_SERVICE = "BARISTA SERVICE API";
}
