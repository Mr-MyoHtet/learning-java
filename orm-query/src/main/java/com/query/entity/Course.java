package com.query.entity;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@NamedQuery(name = "Course.All", query = "select c from Course c")
@NamedQuery(name = "Course.getAllNames", query = "select c.name from Course c")
@NamedQuery(name = "Course.CountAll", query = "select count(c.id) from Course c")
@NamedQuery(name = "Course.findAverageHours", query = "select avg(c.hours) from Course c")
@NamedQuery(name = "Course.findSumfees", query = "select sum(c.fees) from Course c")
@NamedQuery(name = "Course.findCourseDto", query = "select new com.query.entity.dto.CourseDto(c.id,c.name,c.fees) from Course c")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int hours;
	private int fees;

	public Course() {
	}

	public Course(int id, String name, int hours, int fees) {
		super();
		this.id = id;
		this.name = name;
		this.hours = hours;
		this.fees = fees;
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

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", hours=" + hours + ", fees=" + fees + "]";
	}

}
