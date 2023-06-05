package org.fictive.coffeeshop.utils;

public interface APIConstant {
	String API_AUTH_FAILED = "The request failed; Please enter the correct authentication information.";
	String API_ACCESS_FAILED = "The request failed; To access the resource, Please enter the right authentication details.";
	String API_RESOURCE_NOT_FOUND = "Request failed because the resource does not exist.";
	String API_SERVER_ERROR = "Request failed because of unknown failure on the server";
	String API_DEL_SUCCESS = "Delete opertaion is successful";	
	String API_ORDER_CREATED = "Successfully Placed Order.";
	String API_ORDER_DELETED = "Order deleted successfully";
	String API_ORDER = "Order details:\n"
			+ "\n"
			+ "    Type of coffee drink:  LONG_BLACK/LATTE/CAPPUCCINO/ESPRESSO\n"
			+ "    Size of the ordered coffee:  SMALL/MEDIUM/LARGE\n"
			+ "    Milk type: COW_MILK/SOY_MILK/ALMOND_MILK\n"
			+ "    DeliveryType : On-site / takeaway\n"
			+ "    Price: Please provide the price\n"
			+ "    Order number: Please assign an order number";
	
	String API_ORDER_CANCELLING = "An order, which is already in preparation, cannot be cancelled. "
			+ "Also it's called The orders, finalized by the Barista service, shall be removed from the order list.";
	String API_ORDER_SERVICE ="ORDERS SERVICE API";
	String API_ORDER_SERVICE_SPEC ="It will maintain the customer orders for a coffee";
	
}
