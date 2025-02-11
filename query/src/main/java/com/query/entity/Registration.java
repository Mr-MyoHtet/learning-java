package com.query.entity;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Registration {
    @EmbeddedId
	private RegistrationPK id;
	@ManyToOne
	@JoinColumn(name = "studentId", insertable=false,updatable=false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="courseId",insertable=false,updatable=false)
	@JoinColumn(name="StartAt",insertable=false,updatable=false)
	private Section section;
	
	private LocalDateTime registAt;

	public Registration(RegistrationPK id, Student student, Section section, LocalDateTime registAt) {
		super();
		this.id = id;
		this.student = student;
		this.section = section;
		this.registAt = registAt;
	}

	public RegistrationPK getId() {
		return id;
	}

	public void setId(RegistrationPK id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public LocalDateTime getRegistAt() {
		return registAt;
	}

	public void setRegistAt(LocalDateTime registAt) {
		this.registAt = registAt;
	}

}
