package com.mybatis.model;

import java.util.List;

public class Tutors {

	private Integer tutorId;
	private String name;
	private String email;
	private String phone;
	// Tutor and address are one to one relationship
	private Address address;
	// Tutor and cousrse are one-to-many relationship
	private List<Course> course;

	public Integer getTutorId() {
		return tutorId;
	}

	public void setTutorId(Integer tutorId) {
		this.tutorId = tutorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Tutors [tutorId=" + tutorId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", course=" + course + "]";
	}

}
