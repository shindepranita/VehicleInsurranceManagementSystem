package com.capgimini.vehicleinsurance.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int veh_id;

	@NotNull
	@NotEmpty(message = "Veh_name cant empty")
	@Column
	private String veh_name;

	@NotNull
	@NotEmpty(message = "category cant empty")
	@Column
	private String category;
	@NotNull
	@NotEmpty(message = "PlateNumber cant empty")
	@Column
	private String plateNumber;
	@NotNull
	@NotEmpty(message = "Manufacture cant empty")
	@Column
	private String manufacture;

	@NotNull
	@NotEmpty(message = "Type cant empty")
	@Column
	private String type;
	@NotNull
	@NotEmpty(message = "Color cant empty")
	@Column
	private String color;
	@NotNull
	@NotEmpty(message = "RegistrationDate cant empty")
	@Column
	private String registrationDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ins_id")
	private Insurance insurance;

	@ManyToOne(cascade = CascadeType.ALL) // user relationship between vehicle//
	@JoinColumn(name = "userId")
	private User user;

	public Vehicle() {
		super();

	}

	public int getVeh_id() {
		return veh_id;
	}

	public void setVeh_id(int veh_id) {
		this.veh_id = veh_id;
	}

	public String getVeh_name() {
		return veh_name;
	}

	public void setVeh_name(String veh_name) {
		this.veh_name = veh_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Vehicle [veh_id=" + veh_id + ", veh_name=" + veh_name + ", category=" + category + ", plateNumber="
				+ plateNumber + ", manufacture=" + manufacture + ", type=" + type + ", color=" + color
				+ ", registrationDate=" + registrationDate + ", insurance=" + insurance + ", user=" + user
				+ ", getVeh_id()=" + getVeh_id() + ", getVeh_name()=" + getVeh_name() + ", getCategory()="
				+ getCategory() + ", getPlateNumber()=" + getPlateNumber() + ", getManufacture()=" + getManufacture()
				+ ", getType()=" + getType() + ", getColor()=" + getColor() + ", getRegistrationDate()="
				+ getRegistrationDate() + ", getUser()=" + getUser() + ", getInsurance()=" + getInsurance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
