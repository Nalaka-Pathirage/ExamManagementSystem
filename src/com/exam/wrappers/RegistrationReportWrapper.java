package com.exam.wrappers;

import java.util.List;

public class RegistrationReportWrapper {

	private List<RegistrationWrapper> registrations;

	public RegistrationReportWrapper() {
		super();
	}

	public RegistrationReportWrapper(List<RegistrationWrapper> registrations) {
		super();
		this.registrations = registrations;
	}

	public List<RegistrationWrapper> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<RegistrationWrapper> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "RegistrationReportWrapper [registrations=" + registrations + "]";
	}

}
