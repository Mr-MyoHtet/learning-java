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
	// referenceColumnName id is studnet table property
	// student_id is RegistrationPK of property so this student_id is cannot be
	// insert or update
	@JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
	@JoinColumn(name = "start_at", referencedColumnName = "start_at", insertable = false, updatable = false)
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
