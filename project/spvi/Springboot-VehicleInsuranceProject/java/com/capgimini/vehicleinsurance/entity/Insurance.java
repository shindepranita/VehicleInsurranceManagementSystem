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
@Table
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int ins_id;
	@NotNull
	@NotEmpty(message="Provider cant empty")
	@Column
	private String provider;
	@NotNull
	@NotEmpty(message="Ins_Number cant empty")
	@Column
	private String ins_Number;
	@NotNull
	@NotEmpty(message="Tenure cant empty")
	@Column
	private String tenure;
	// insurance description//
	@NotNull
	@NotEmpty(message="Description cant empty")
	@Column
	private String description;
	@NotNull
	@NotEmpty(message="Premium cant empty")
	@Column
	private String premium;
	@NotNull
	@NotEmpty(message="claimSettlement cant empty")
	@Column
	private String claimSettlement;
   
	
	
	
	@OneToMany(mappedBy="insurance")
	private List<Vehicle> vehicle;
	
	
	
	

	public Insurance() {
		super();
	}

	public int getIns_id() {
		return ins_id;
	}

	public void setIns_id(int ins_id) {
		this.ins_id = ins_id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getIns_Number() {
		return ins_Number;
	}

	public void setIns_Number(String ins_Number) {
		this.ins_Number = ins_Number;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	

	public String getClaimSettlement() {
		return claimSettlement;
	}

	public void setClaimSettlement(String claimSettlement) {
		this.claimSettlement = claimSettlement;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Insurance [ins_id=" + ins_id + ", provider=" + provider + ", ins_Number=" + ins_Number + ", tenure="
				+ tenure + ", description=" + description + ", premium=" + premium + ", claimSettlement="
				+ claimSettlement + ", vehicle=" + vehicle + ", getIns_id()=" + getIns_id() + ", getProvider()="
				+ getProvider() + ", getIns_Number()=" + getIns_Number() + ", getTenure()=" + getTenure()
				+ ", getDescription()=" + getDescription() + ", getPremium()=" + getPremium()
				+ ", getClaimSettlement()=" + getClaimSettlement() + ", getVehicle()=" + getVehicle() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	

	

	
}

