package com.query.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SectionPK {
    
	@Column(name = "course_id")
	private int courseId;
	
	@Column(name = "start_at")
	private LocalDate startAt;

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

	public SectionPK(int courseId, LocalDate startAt) {
		super();
		this.courseId = courseId;
		this.startAt = startAt;
	}

}
