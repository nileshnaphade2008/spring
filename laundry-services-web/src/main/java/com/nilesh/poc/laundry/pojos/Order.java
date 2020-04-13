package com.nilesh.poc.laundry.pojos;

import javax.persistence.*;

@Entity
@Table(name="orders")

  public class Order {
	private Integer order_id;
	private String cloth_type;
    private int noc;
	private int price;
	private User usr;
      public Order() 
	{
		System.out.println("in order pojo");
	}
      
    @Id
  	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOrder_id() {
		return order_id;
	}
    @Column(length=20)
	public String getCloth_type() {
		return cloth_type;
      }
      
	public int getNoc() {
		return noc;
	}
	public int getPrice() {
		return price;
	}
	
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public void setCloth_type(String cloth_type) {
		this.cloth_type = cloth_type;
	}
	public void setNoc(Integer noc) {
		this.noc = noc;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
   
	 
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", cloth_type=" + cloth_type + ", noc=" + noc + ", price=" + price + "]";
	}
	
   @OneToOne
   @JoinColumn(name="user_id")
	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}
	
	
	

}
