package com.nilesh.poc.laundry.pojos;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	private Integer user_id;
	private String user_name;
	private String user_email;
	private String user_Password;
	private String user_mobno;
	private String user_address;
	private String role;
	private Order or;
	private TypeOfWash tos;
	private Cart ct;
	public String getRole() {
		return role;
	}
public void setRole(String role) {
		this.role = role;
	}
	
	@OneToOne(mappedBy="ur",cascade=CascadeType.ALL)
	public Cart getCt() {
		return ct;
	}

	public void setCt(Cart ct) {
		this.ct = ct;
	}

	@OneToOne(mappedBy="us",cascade=CascadeType.ALL)
	public TypeOfWash getTos() {
		return tos;
	}

	public void setTos(TypeOfWash tos) {
		this.tos = tos;
	}

	@OneToOne(mappedBy="usr",cascade=CascadeType.ALL)
	public Order getOr() {
		return or;
	}

	public void setOr(Order or) {
		this.or = or;
	}

	public User() {
		System.out.println("In userPojo");
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUser_id() {
		return user_id;
	}
	@Column(length=20)
	public String getUser_name() {
		return user_name;
	}
	@Column(length=20,unique=true)
	public String getUser_email() {
		return user_email;
	}
	@Column(length=20,nullable=false)
	public String getUser_Password() {
		return user_Password;
	}
	@Column(length=20,unique=true)
	public String getUser_mobno() {
		return user_mobno;
	}
	@Column(length=20)
	public String getUser_address() {
		return user_address;
	}
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	public void setUser_mobno(String user_mobno) {
		this.user_mobno = user_mobno;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_Password=" + user_Password + ", user_mobno=" + user_mobno + ", user_address=" + user_address
				+ "]";
	}
	

}
