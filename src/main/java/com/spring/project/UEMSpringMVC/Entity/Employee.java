package com.spring.project.UEMSpringMVC.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonProperty("empid")
	@Column(name="empid")
	private String empid;
	
	@JsonProperty("empname")
    @Column(name="empname")
    private String empname;
    
    @JsonProperty("empemail")
    @Column(name="empemail")
    private String empemail;

    @JsonProperty("empcity")
    @Column(name="empcity")
    private String empcity;
    
    @JsonProperty("empcontactno")
    @Column(name="empcontactno")
    private String empcontactno;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @JsonIgnore // 👈 Add this to every getter to hide the "emp_id" version
    public String getEmp_id() {
        return empid;
    }

    public void setEmp_id(String empid) {
        this.empid = empid;
    }

    @JsonIgnore // 👈 Add this here too
    public String getEmp_name() {
        return empname;
    }

    public void setEmp_name(String empname) {
        this.empname = empname;
    }

    @JsonIgnore // 👈 And here
    public String getEmp_email() {
        return empemail;
    }

    public void setEmp_email(String empemail) {
        this.empemail = empemail;
    }

    @JsonIgnore // 👈 And here
    public String getEmp_city() {
        return empcity;
    }

    public void setEmp_city(String empcity) {
        this.empcity = empcity;
    }

    @JsonIgnore // 👈 And here
    public String getEmp_contact_no() {
        return empcontactno;
    }

    public void setEmp_contact_no(String empcontactno) {
        this.empcontactno = empcontactno;
    }
	

}