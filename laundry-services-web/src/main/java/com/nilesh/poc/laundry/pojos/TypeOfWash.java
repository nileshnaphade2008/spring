package com.nilesh.poc.laundry.pojos;
import javax.persistence.*;
@Entity
@Table(name="typeofwash")
public class TypeOfWash {
	private Integer tid;
	private String type_of_wash;
	private float rate;
	private User us;
	
	@OneToOne
	@JoinColumn(name="user_id")
	public User getUs() {
		return us;
	}
	public void setUs(User us) {
		this.us = us;
	}
	public TypeOfWash() {
		}
	@Id
  	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	 @Column(length=20)
	public String getType_of_wash() {
		return type_of_wash;
	}
	public void setType_of_wash(String type_of_wash) {
		this.type_of_wash = type_of_wash;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	
}
