package com.query.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Entity
@Data
@NamedQuery(name = "Student.findByPhone",query = "select s from Student s where s.phone =?1")
@NamedQuery(name="Student.findByKeyWord",query ="select s from Student s where lower(s.name) like:keyword or lower(s.phone) like:keyword or lower(s.email) like:keyword" )
public class Student {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String email;
	
	public Student(){
		
	}

	public Student(int id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}
