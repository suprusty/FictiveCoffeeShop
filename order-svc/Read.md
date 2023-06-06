Order-svc is responsible for handling requests related to customer orders. 
1)placeOrder()
Taking order from customer and send the request to barsita service to further process of the order.
	The following information from the customer is required in order to place the order.
	
	a.	Type of coffee drink ->  long black, latte, cappuccino, espresso
	b.	size of the ordered coffee -> small, medium, large
	c.	milk type (if applicable) -> cow milk / soy milk / almond milk
	d.	on-site / takeaway
	e.	price
	f.	order number
	 
	Once the order has been successfully stored in the database, we send it to the barista service for processing. 
2)cancelOrder
Canceling the customer order in case it's in waiting stage
	
	a. An order, which is already in preparation, cannot be cancelled. 