package com.exam.model;

import java.time.LocalDateTime;

public class Course {

	private Integer courseId;
	private String code;
	private String name;
	private Double duration;
	private LocalDateTime start;
	private String description;
	private Double fee;

	public Course() {
		super();
	}

	public Course(Integer courseId) {
		super();
		this.courseId = courseId;
	}

	public Course(Integer courseId, String code, String name) {
		super();
		this.courseId = courseId;
		this.code = code;
		this.name = name;
	}

	public Course(Integer courseId, String code, String name, Double duration, LocalDateTime start, String description,
			Double fee) {
		super();
		this.courseId = courseId;
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.start = start;
		this.description = description;
		this.fee = fee;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", code=" + code + ", name=" + name + ", duration=" + duration
				+ ", start=" + start + ", description=" + description + ", fee=" + fee + "]";
	}
}
