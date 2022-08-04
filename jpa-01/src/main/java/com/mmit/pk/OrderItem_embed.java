package com.mmit.pk;

import java.io.Serializable;
import javax.persistence.*;


//@Entity
@Table(name = "order_items")
public class OrderItem_embed implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderItemPk_embed id;
	@Column(name = "sub_qty")
	private int subQty;
	@ManyToOne
	@JoinColumn(name = "order_id")
	@MapsId("orderId")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	@MapsId("productId")
	private Product product;
	public OrderItem_embed() {
		super();
	}
   
}
