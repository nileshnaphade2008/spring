package com.nilesh.poc.laundry.pojos;

import javax.persistence.*;
@Entity
@Table(name="clothscategory")
public class ClothsCategory {
 private Integer cloth_id;
 private String gender;
 private String cloth_type;
 private Cart crt;
 
 
 
 @OneToOne(mappedBy="ct",cascade=CascadeType.ALL)
public Cart getCrt() {
	return crt;
}
public void setCrt(Cart crt) {
	this.crt = crt;
}
public ClothsCategory() {
}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Integer getCloth_id() {
	return cloth_id;
}
@Column(length=20)
public String getGender() {
	return gender;
}
@Column(length=20)
public String getCloth_type() {
	return cloth_type;
}
public void setCloth_id(Integer cloth_id) {
	this.cloth_id = cloth_id;
}
public void setGender(String gender) {
	this.gender = gender;
}
public void setCloth_type(String cloth_type) {
	this.cloth_type = cloth_type;
}
@Override
public String toString() {
	return "ClothsCategory [cloth_id=" + cloth_id + ", gender=" + gender + ", cloth_type=" + cloth_type + "]";
}


}
