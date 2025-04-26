package com.query.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RegistrationPK {

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "start_at")
	private LocalDate startAt;

	@Column(name = "student_id")
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
