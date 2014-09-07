package com.netcetera.aem.spademo.impl.domain;

import org.joda.time.LocalTime;

public class Slot {

	private final LocalTime startTime;
	private final LocalTime endTime;
	private final String topic;
	private final String speaker;
	
	public Slot(LocalTime startTime, LocalTime endTime, String topic, String speaker) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.topic = topic;
		this.speaker = speaker;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public String getTopic() {
		return topic;
	}

	public String getSpeaker() {
		return speaker;
	}
	
}
