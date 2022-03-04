package com.capgimini.vehicleinsurance.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userId;
	@NotNull
	@NotEmpty(message = "Name cant empty")
	@Column
	private String userName;
	@NotNull
	@NotEmpty(message = "Password cant empty")
	@Column
	private String userPassword;
	@NotNull
	@NotEmpty(message = "MailId cant empty")
	@Column
	private String mailId;
	@NotNull
	@NotEmpty(message = "Gender cant empty")
	@Column
	private String userGender;
	@NotNull
	@NotEmpty(message = "Nationality cant empty")
	@Column
	private String nationality;
	@NotNull
	@NotEmpty(message = "licence cant empty")
	@Column
	private String licence;

	@OneToMany(mappedBy = "user")
	private List<Vehicle> vehicle;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", mailId="
				+ mailId + ", userGender=" + userGender + ", nationality=" + nationality + ", licence=" + licence
				+ ", vehicle=" + vehicle + ", getUserId()=" + getUserId() + ", getUserName()=" + getUserName()
				+ ", getUserPassword()=" + getUserPassword() + ", getUserGender()=" + getUserGender()
				+ ", getNationality()=" + getNationality() + ", getLicence()=" + getLicence() + ", getMailId()="
				+ getMailId() + ", getVehicle()=" + getVehicle() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
