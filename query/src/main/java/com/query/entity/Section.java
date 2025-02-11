package com.query.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.query.entity.convector.DaysConvector;

import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Section {
    @EmbeddedId
	private SectionPK id;
    @ManyToOne
    @JoinColumn(name="courseId",insertable=false,updatable=false)
	private Course course;
    
    //@ElementCollection
    @Convert(converter=DaysConvector.class)
	private List<DayOfWeek> days;
	private String startTime;
	private String endTime;
	private LocalDate endAt;
	private int fees;

	public Section(SectionPK id, Course course, List<DayOfWeek> days, String startTime, String endTime, LocalDate endAt,
			int fees) {
		super();
		this.id = id;
		this.course = course;
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
		this.endAt = endAt;
		this.fees = fees;
	}

	public SectionPK getId() {
		return id;
	}

	public void setId(SectionPK id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<DayOfWeek> getDays() {
		return days;
	}

	public void setDays(List<DayOfWeek> days) {
		this.days = days;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public LocalDate getEndAt() {
		return endAt;
	}

	public void setEndAt(LocalDate endAt) {
		this.endAt = endAt;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

}
