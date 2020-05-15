package org.codejudge.sb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="LEAD")
public class Lead {

	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Integer id;
	  
	 @NotNull
	 @Size(min=1, message="Name should have atleast 1 characters")
	 @Column(name="FIRST_NAME")
	 private String first_name;
	 
	 @Column(name="LAST_NAME")
	 private String last_name;
	  
	 @NotNull
	 @Size(max=10, message="mobile no cannot be greater than 10 digit")
	 @Column(name="MOBILE")
	 private String mobile;
	  
	 @Column(name="EMAIL")
	 private String email;
	 
	 @Column(name="LOCATION_TYPE")
	 private String location_type;
	 
	 @Column(name="LOCATION_STRING")
	 private String location_string;
	 
	 @Column(name="STATUS")
	 private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public String getLocation_string() {
		return location_string;
	}

	public void setLocation_string(String location_string) {
		this.location_string = location_string;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 
	 
}
