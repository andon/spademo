package com.netcetera.aem.spademo.impl.domain;

import java.util.Comparator;

import com.netcetera.aem.spademo.impl.util.SlotSpeakerComparator;
import com.netcetera.aem.spademo.impl.util.SlotStartTimeComparator;
import com.netcetera.aem.spademo.impl.util.SlotTopicComparator;

public enum Sort {
	START_TIME,
	TOPIC,
	SPEAKER;
	
	public Comparator<Slot> getComparator() {
		switch (this) {
		case START_TIME:
			return new SlotStartTimeComparator();
		case TOPIC:
			return new SlotTopicComparator();
		case SPEAKER:
			return new SlotSpeakerComparator();
		default:
			throw new IllegalStateException("No comparator for " + this);
		}
	}
}
