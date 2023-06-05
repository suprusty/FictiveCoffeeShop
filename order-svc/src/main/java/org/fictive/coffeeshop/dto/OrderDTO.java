package org.fictive.coffeeshop.dto;

import java.math.BigDecimal;

import org.fictive.models.utils.CoffeeSize;
import org.fictive.models.utils.CoffeeType;
import org.fictive.models.utils.DeliveryType;
import org.fictive.models.utils.MilkType;

public class OrderDTO {
	private CoffeeType coffeeType;
	private CoffeeSize coffeeSize;
	private MilkType milkType;
	private DeliveryType deliveryType;
	private BigDecimal price;
	private Long orderId;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public CoffeeType getCoffeeType() {
		return coffeeType;
	}
	public void setCoffeeType(CoffeeType coffeeType) {
		this.coffeeType = coffeeType;
	}
	public CoffeeSize getCoffeeSize() {
		return coffeeSize;
	}
	public void setCoffeeSize(CoffeeSize coffeeSize) {
		this.coffeeSize = coffeeSize;
	}
	public MilkType getMilkType() {
		return milkType;
	}
	public void setMilkType(MilkType milkType) {
		this.milkType = milkType;
	}
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDTO [coffeeType=" + coffeeType + ", coffeeSize=" + coffeeSize + ", milkType=" + milkType
				+ ", deliveryType=" + deliveryType + ", price=" + price + "]";
	}
	

}