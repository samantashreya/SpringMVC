package com.cg.cust.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
	@Id
private int id;
	@Pattern(regexp="[A-Z][A-Z a-z\\s]{2,}",message="Name should start with Capital ltr followed by two ltr")
private String name;
	@Pattern(regexp="(Male|Female)",message="gender should always be Male or Female")
private String gender;
@Pattern(regexp="(PRI|GEN)",message="Customer type should be either PRI or GEN")
private String type;
@Min(1) @Max(10)
private int rating;
@Pattern(regexp="\\d{10}",message="Mobile Number should be 10 digit only")
private String mobile;

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}

}
