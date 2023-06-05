package org.fictive.models.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.fictive.models.utils.CoffeeSize;
import org.fictive.models.utils.CoffeeType;
import org.fictive.models.utils.DeliveryType;
import org.fictive.models.utils.MilkType;

@Entity
@Table(name = "c_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Coffee_Type", length = 50, nullable = false)
	private CoffeeType coffeeType;

	@Enumerated(EnumType.STRING)
	@Column(name = "Coffee_Size", length = 50,nullable = false)
	private CoffeeSize coffeeSize;
	
	@Column(name = "Milk_Type", length = 50,nullable = false)
	@Enumerated(EnumType.STRING)
	private MilkType milkType;
	
	@Column(name = "Delivery_Type", length = 50,nullable = false)
	@Enumerated(EnumType.STRING)
	private DeliveryType deliveryType;
	
	
	@OneToOne(mappedBy = "order",orphanRemoval = true,
		    cascade = CascadeType.ALL)
	private BaristaOrder baristaOrder;
	
	@Column(name = "price", length = 50,nullable = false)
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BaristaOrder getBaristaOrder() {
		return baristaOrder;
	}

	public void setBaristaOrder(BaristaOrder baristaOrder) {
		this.baristaOrder = baristaOrder;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void addBaristaOrder(BaristaOrder bo) {
		bo.setOrder(this);
		setBaristaOrder(bo);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", coffeeType=" + coffeeType + ", coffeeSize=" + coffeeSize + ", milkType="
				+ milkType + ", deliveryType=" + deliveryType + ", baristaOrder=" + baristaOrder + ", price=" + price
				+ "]";
	}

}