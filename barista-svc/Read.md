Barista-svc is responsible for handling requests related to order processing.
1)processOrder()

	waiting -> in preparation -> finished -> picked up
	
	The implementation cycle could be done in separate thread/task/timer. 
	
	The orders that have been completed must be deleted from the persistence store.
	
2)getPendingOrders

	listing of pending orders with their current status
