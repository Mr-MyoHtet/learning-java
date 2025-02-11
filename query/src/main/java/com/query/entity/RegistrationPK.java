package com.query.entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class RegistrationPK {

	private int courseId;
	private LocalDate startAt;
	private int studentId;

	public RegistrationPK(int courseId, LocalDate startAt, int studentId) {
		super();
		this.courseId = courseId;
		this.startAt = startAt;
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public LocalDate getStartAt() {
		return startAt;
	}

	public void setStartAt(LocalDate startAt) {
		this.startAt = startAt;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}
