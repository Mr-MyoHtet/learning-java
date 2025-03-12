package com.mybatis.model;

import java.time.LocalDate;

public class Student {

	private int stud_id;
	private String name;
	private String email;
	private String phone;
	private LocalDate dob;
	private String bio;

//	public Student(int stud_id, String name, String email, String phone, LocalDate dob, String bio) {
//		super();
//		this.stud_id = stud_id;
//		this.name = name;
//		this.email = email;
//		this.phone = phone;
//		this.dob = dob;
//		this.bio = bio;
//	}

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob="
				+ dob + ", bio=" + bio + "]";
	}

}
