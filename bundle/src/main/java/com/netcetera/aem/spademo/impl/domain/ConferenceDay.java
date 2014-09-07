package com.netcetera.aem.spademo.impl.domain;

import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

public class ConferenceDay {

	private LocalDate date;
	private List<Slot> slots;

	public ConferenceDay(LocalDate date, List<Slot> slots) {
		this.date = date;
		this.slots = slots;
	}

	public LocalDate getDate() {
		return date;
	}

	public List<Slot> getSlots() {
		return Collections.unmodifiableList(slots);
	}
	
}
