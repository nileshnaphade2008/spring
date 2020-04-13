package com.nilesh.poc.laundry.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="userscart")
public class Cart {
    private Integer cart_id;
	private String cloth_name;
	private float price;
	private int noc;
	private String typeOfWash;
	private User ur;
	private ClothsCategory ct;
	@OneToOne
	@JoinColumn(name="cloth_id")
	public ClothsCategory getCt() {
		return ct;
	}
	public void setCt(ClothsCategory ct) {
		this.ct = ct;
	}
	@OneToOne
	@JoinColumn(name="user_id")
	public User getUr() {
		return ur;
	}
	public void setUr(User ur) {
		this.ur = ur;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCart_id() {
		return cart_id;
	}
	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
	public String getCloth_name() {
		return cloth_name;
	}
	public void setCloth_name(String cloth_name) {
		this.cloth_name = cloth_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNoc() {
		return noc;
	}
	public void setNoc(int noc) {
		this.noc = noc;
	}
	public String getTypeOfWash() {
		return typeOfWash;
	}
	public void setTypeOfWash(String typeOfWash) {
		this.typeOfWash = typeOfWash;
	}
	
}
