CREATE DATABASE IF NOT EXISTS coffeeshop;
USE coffeeshop;
create table c_order 
	(id bigint not null auto_increment, 
	Coffee_Size varchar(255), 
	Coffee_Type varchar(255), 
	Delivery_Type varchar(255), 
	Milk_Type varchar(255), 
	price double precision not null, 
	primary key (id));
commit;
create table barista_order 
	(id bigint not null auto_increment, 
		status varchar(255), 
		order_id bigint,
		FOREIGN KEY (order_id) REFERENCES c_order(id),
		primary key (id));
commit;