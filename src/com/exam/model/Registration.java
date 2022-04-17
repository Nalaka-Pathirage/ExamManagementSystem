package com.exam.model;

import java.time.LocalDateTime;

public class Registration {

	private Integer registrationId;
	private LocalDateTime requestedDateTime;
	private Boolean adminApproved;
	private LocalDateTime approvedDateTime;
	private Double paymentAmount;
	private LocalDateTime paymentDateTime;
	private Boolean paymentStatus;
	private Boolean mailSent;
	private Boolean registrationStatus;

	public Registration() {
		super();
	}

	public Registration(Integer registrationId, LocalDateTime requestedDateTime) {
		super();
		this.registrationId = registrationId;
		this.requestedDateTime = requestedDateTime;
	}

	public Registration(Integer registrationId, LocalDateTime approvedDateTime, Double paymentAmount,
			Boolean mailSent) {
		super();
		this.registrationId = registrationId;
		this.approvedDateTime = approvedDateTime;
		this.paymentAmount = paymentAmount;
		this.mailSent = mailSent;
	}

	public Registration(Integer registrationId, LocalDateTime requestedDateTime, Boolean adminApproved,
			LocalDateTime approvedDateTime, Double paymentAmount, LocalDateTime paymentDateTime, Boolean paymentStatus,
			Boolean mailSent, Boolean registrationStatus) {
		super();
		this.registrationId = registrationId;
		this.requestedDateTime = requestedDateTime;
		this.adminApproved = adminApproved;
		this.approvedDateTime = approvedDateTime;
		this.paymentAmount = paymentAmount;
		this.paymentDateTime = paymentDateTime;
		this.paymentStatus = paymentStatus;
		this.mailSent = mailSent;
		this.registrationStatus = registrationStatus;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public LocalDateTime getRequestedDateTime() {
		return requestedDateTime;
	}

	public void setRequestedDateTime(LocalDateTime requestedDateTime) {
		this.requestedDateTime = requestedDateTime;
	}

	public Boolean getAdminApproved() {
		return adminApproved;
	}

	public void setAdminApproved(Boolean adminApproved) {
		this.adminApproved = adminApproved;
	}

	public LocalDateTime getApprovedDateTime() {
		return approvedDateTime;
	}

	public void setApprovedDateTime(LocalDateTime approvedDateTime) {
		this.approvedDateTime = approvedDateTime;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Boolean getMailSent() {
		return mailSent;
	}

	public void setMailSent(Boolean mailSent) {
		this.mailSent = mailSent;
	}

	public Boolean getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(Boolean registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	@Override
	public String toString() {
		return "Registration [registrationId=" + registrationId + ", requestedDateTime=" + requestedDateTime
				+ ", adminApproved=" + adminApproved + ", approvedDateTime=" + approvedDateTime + ", paymentAmount="
				+ paymentAmount + ", paymentDateTime=" + paymentDateTime + ", paymentStatus=" + paymentStatus
				+ ", mailSent=" + mailSent + ", registrationStatus=" + registrationStatus + "]";
	}

}
