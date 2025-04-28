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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
// @NamedQuery(name = "Section.searchFees", query = "select s from Section s
// where s.fees <= :fees")
// @NamedQuery(name = "Section.searchFessUsingSectionDto", query = """
// select new
// com.query.entity.dto.SectionDto(s.id,s.course.hours,s.endAt,s.startTime,s.endTime,s.course.name,s.fees,s.days)
// from Section s where s.fees <= :fees""")
// // s.id.StartAt id is from SectionPK ,SectionPk has startAt
// @NamedQuery(name = "Section.searchDateBetween", query = """
// select new
// com.query.entity.dto.SectionDto(s.id,s.course.hours,s.endAt,s.startTime,s.endTime,s.course.name,s.fees,s.days)
// from Section s where s.id.startAt between :from and :to
// """)

// @NamedQuery(name = "Section.searchStartTimeIn", query = """
// select new
// com.query.entity.dto.SectionDto(s.id,s.course.hours,s.endAt,s.startTime,s.endTime,s.course.name,s.fees,s.days)
// from Section s where s.startTime in :list
// """)
@NamedQuery(name = "Section.searchFessUsingSectionDto", query = """
		 select  new com.query.entity.dto.SectionDto(s.id,c.hours,s.endAt,s.startTime,s.endTime,c.name,s.fees,s.days)
		from Section s left join s.course c
		 where s.fees <= :fees""")
// s.id.StartAt id is from SectionPK ,SectionPk has startAt
@NamedQuery(name = "Section.searchDateBetween", query = """
		 select  new com.query.entity.dto.SectionDto(s.id,c.hours,s.endAt,s.startTime,s.endTime,c.name,s.fees,s.days)
		from Section s left join s.course c
		where s.id.startAt between :from and :to
				""")
// left join s.course course is column name
@NamedQuery(name = "Section.searchStartTimeIn", query = """
		        select  new com.query.entity.dto.SectionDto(s.id,c.hours,s.endAt,s.startTime,s.endTime,c.name,s.fees,s.days)
		from Section s left join s.course c
		where  s.startTime in :list
		""")
// ManyToOne
@NamedQuery(name = "Section.searchOverStudents", query = """
		    select new com.query.entity.dto.SectionWithStudents(
		        s.id, s.endAt, c.name, count(st.id)
		    )
		    from Section s
		    left join s.course c
		    left join s.registration r
		    left join r.student st
		    group by s.id, s.endAt, c.name
		    having count(st.id) >= :students
		    order by count(st.id) desc
		""")

public class Section {
	@EmbeddedId
	private SectionPK id;

	// @JoinColumn(name = "course_id", ) is the Course table の course_id
	// Hibernate won't manage (INSERT or UPDATE) this foreign key column
	// automatically.
	// You are saying "the course_id is already managed somewhere else (maybe inside
	// SectionPK)".
	// =====================================================
	// @ManyToOne(optional = false)
	// optional falseက course မရိရင် section မရိတဲ.သဘော
	// ======================================================
	@ManyToOne
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	public Course course;

	// @ElementCollection
	@Convert(converter = DaysConvector.class)
	private List<DayOfWeek> days;
	private String startTime;
	private String endTime;
	private LocalDate endAt;
	private int fees;

	@OneToMany(mappedBy = "section")
	private List<Registration> registration;

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

	public Section() {

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

	@Override
	public String toString() {
		return "Section [id=" + id + ", course=" + course + ", days=" + days + ", startTime=" + startTime + ", endTime="
				+ endTime + ", endAt=" + endAt + ", fees=" + fees + ", getId()=" + getId() + ", getCourse()="
				+ getCourse() + ", getDays()=" + getDays() + ", getStartTime()=" + getStartTime() + ", getEndTime()="
				+ getEndTime() + ", getEndAt()=" + getEndAt() + ", getFees()=" + getFees() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
