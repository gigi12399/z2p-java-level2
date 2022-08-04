package com.mmit.pk;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(OrderItemPk.class)
public class orderItem implements Serializable {
	/*
	 * @Id private int product_id;
	 * 
	 * @Id private int order_id;
	 */
	@Column(name = "sub_qty")
	private int subQty;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private static final long serialVersionUID = 1L;

	public orderItem() {
		super();
	}
   
}
