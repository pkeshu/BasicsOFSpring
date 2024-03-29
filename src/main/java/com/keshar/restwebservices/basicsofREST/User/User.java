package com.keshar.restwebservices.basicsofREST.User;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "This is the basic description of api.")
public class User {

	private Integer id;

	@Size(min = 4,message = "Name should be at least 4 character")
	@ApiModelProperty(notes = "Name should be at least 4 character")
	private String name;

	@Past
	@ApiModelProperty(notes="Birth Date should be before to the current date.")
	private Date birthDate;



	public User() {
		super();
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}


}
